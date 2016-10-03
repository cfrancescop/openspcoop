/*
 * OpenSPCoop v2 - Customizable SOAP Message Broker 
 * http://www.openspcoop2.org
 * 
 * Copyright (c) 2005-2016 Link.it srl (http://link.it). 
 * 
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 *
 */


package org.openspcoop2.web.ctrlstat.servlet.utenti;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.openspcoop2.core.commons.Liste;
import org.openspcoop2.core.id.IDSoggetto;
import org.openspcoop2.core.registry.AccordoCooperazione;
import org.openspcoop2.core.registry.AccordoServizioParteComune;
import org.openspcoop2.core.registry.Soggetto;
import org.openspcoop2.utils.crypt.Password;
import org.openspcoop2.web.ctrlstat.core.ControlStationCore;
import org.openspcoop2.web.ctrlstat.costanti.CostantiControlStation;
import org.openspcoop2.web.ctrlstat.dao.PdDControlStation;
import org.openspcoop2.web.ctrlstat.dao.SoggettoCtrlStat;
import org.openspcoop2.web.ctrlstat.servlet.GeneralHelper;
import org.openspcoop2.web.ctrlstat.core.Search;
import org.openspcoop2.web.ctrlstat.servlet.ac.AccordiCooperazioneCore;
import org.openspcoop2.web.ctrlstat.servlet.apc.AccordiServizioParteComuneCore;
import org.openspcoop2.web.ctrlstat.servlet.config.ConfigurazioneCostanti;
import org.openspcoop2.web.ctrlstat.servlet.login.LoginSessionUtilities;
import org.openspcoop2.web.ctrlstat.servlet.pdd.PddCore;
import org.openspcoop2.web.ctrlstat.servlet.soggetti.SoggettiCore;
import org.openspcoop2.web.lib.mvc.Costanti;
import org.openspcoop2.web.lib.mvc.DataElement;
import org.openspcoop2.web.lib.mvc.ForwardParams;
import org.openspcoop2.web.lib.mvc.GeneralData;
import org.openspcoop2.web.lib.mvc.PageData;
import org.openspcoop2.web.lib.mvc.Parameter;
import org.openspcoop2.web.lib.mvc.ServletUtils;
import org.openspcoop2.web.lib.mvc.TipoOperazione;
import org.openspcoop2.web.lib.users.dao.InterfaceType;
import org.openspcoop2.web.lib.users.dao.Permessi;
import org.openspcoop2.web.lib.users.dao.PermessiUtente;
import org.openspcoop2.web.lib.users.dao.User;

/**
 * suChange
 * 
 * @author Andrea Poli (apoli@link.it)
 * @author Stefano Corallo (corallo@link.it)
 * @author Sandra Giangrandi (sandra@link.it)
 * @author $Author$
 * @version $Rev$, $Date$
 * 
 */
public final class UtentiChange extends Action {

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {

		HttpSession session = request.getSession(true);

		// Inizializzo PageData
		PageData pd = new PageData();

		GeneralHelper generalHelper = new GeneralHelper(session);

		// Inizializzo GeneralData
		GeneralData gd = generalHelper.initGeneralData(request);

		String userLogin = ServletUtils.getUserLoginFromSession(session);

		try {
			UtentiHelper utentiHelper = new UtentiHelper(request, pd, session);

			UtentiCore utentiCore = new UtentiCore();
			PddCore pddCore = new PddCore(utentiCore);
			SoggettiCore soggettiCore = new SoggettiCore(utentiCore);
			AccordiCooperazioneCore acCore = new AccordiCooperazioneCore(utentiCore);
			AccordiServizioParteComuneCore apcCore = new AccordiServizioParteComuneCore(utentiCore);

			String nomesu = request.getParameter(UtentiCostanti.PARAMETRO_UTENTI_USERNAME);
			String pwsu = request.getParameter(UtentiCostanti.PARAMETRO_UTENTI_PASSWORD);
			String confpwsu = request.getParameter(UtentiCostanti.PARAMETRO_UTENTI_CONFERMA_PASSWORD);
			String tipoGui = request.getParameter(UtentiCostanti.PARAMETRO_UTENTI_TIPO_GUI);

			String isServizi = request.getParameter(UtentiCostanti.PARAMETRO_UTENTI_IS_SERVIZI);
			String isDiagnostica = request.getParameter(UtentiCostanti.PARAMETRO_UTENTI_IS_DIAGNOSTICA);
			String isSistema = request.getParameter(UtentiCostanti.PARAMETRO_UTENTI_IS_SISTEMA);
			String isMessaggi = request.getParameter(UtentiCostanti.PARAMETRO_UTENTI_IS_MESSAGGI);
			String isUtenti = request.getParameter(UtentiCostanti.PARAMETRO_UTENTI_IS_UTENTI);
			String isAuditing = request.getParameter(UtentiCostanti.PARAMETRO_UTENTI_IS_AUDITING);
			String isAccordiCooperazione = request.getParameter(UtentiCostanti.PARAMETRO_UTENTI_IS_ACCORDI_COOPERAZIONE);

			String singleSuServizi = request.getParameter(UtentiCostanti.PARAMETRO_UTENTI_SINGLE_SU_SERVIZI);
			String singleSuAccordiCooperazione = request.getParameter(UtentiCostanti.PARAMETRO_UTENTI_SINGLE_SU_ACCORDI_COOPERAZIONE);
			String changepwd = request.getParameter(UtentiCostanti.PARAMETRO_UTENTI_CHANGE_PASSWORD);

			Boolean singlePdD = (Boolean) session.getAttribute(CostantiControlStation.SESSION_PARAMETRO_SINGLE_PDD);

			// Prendo l'utente
			User user = utentiCore.getUser(nomesu);
			//Prendo i vecchi dati dell'utente
			tipoGui = (tipoGui==null) ? user.getInterfaceType().toString() : tipoGui;
			InterfaceType interfaceType = InterfaceType.STANDARD;
			if(InterfaceType.AVANZATA.toString().equals(tipoGui)){
				interfaceType = InterfaceType.AVANZATA;
			}
			// Preparo il menu
			utentiHelper.makeMenu();

			// Se nomehid = null, devo visualizzare la pagina per l'inserimento dati
			if(ServletUtils.isEditModeInProgress(request)){

				// setto la barra del titolo
				//				ServletUtils.setPageDataTitle_ServletChange(pd, UtentiCostanti.LABEL_UTENTI, 
				//						UtentiCostanti.SERVLET_NAME_UTENTI_LIST,
				//						nomesu);

				ServletUtils.	setPageDataTitle(pd, 
						new Parameter(ConfigurazioneCostanti.LABEL_CONFIGURAZIONE,null),
						new Parameter(UtentiCostanti.LABEL_UTENTI ,UtentiCostanti.SERVLET_NAME_UTENTI_LIST),
						new Parameter(nomesu,null));


				PermessiUtente pu = user.getPermessi();

				isServizi = (isServizi==null) ? (pu.isServizi() ? Costanti.CHECK_BOX_ENABLED : Costanti.CHECK_BOX_DISABLED) : isServizi;
				isDiagnostica = (isDiagnostica==null) ? (pu.isDiagnostica() ? Costanti.CHECK_BOX_ENABLED : Costanti.CHECK_BOX_DISABLED) : isDiagnostica;
				isSistema = (isSistema==null) ? (pu.isSistema() ? Costanti.CHECK_BOX_ENABLED : Costanti.CHECK_BOX_DISABLED) : isSistema;
				isMessaggi = (isMessaggi==null) ? (pu.isCodeMessaggi() ? Costanti.CHECK_BOX_ENABLED : Costanti.CHECK_BOX_DISABLED) : isMessaggi;
				isUtenti = (isUtenti==null) ? (pu.isUtenti() ? Costanti.CHECK_BOX_ENABLED : Costanti.CHECK_BOX_DISABLED) : isUtenti;
				isAuditing = (isAuditing==null) ? (pu.isAuditing() ? Costanti.CHECK_BOX_ENABLED : Costanti.CHECK_BOX_DISABLED) : isAuditing;
				isAccordiCooperazione = (isAccordiCooperazione==null) ? (pu.isAccordiCooperazione() ? Costanti.CHECK_BOX_ENABLED : Costanti.CHECK_BOX_DISABLED) : isAccordiCooperazione;


				// preparo i campi
				Vector<DataElement> dati = new Vector<DataElement>();

				dati.addElement(ServletUtils.getDataElementForEditModeFinished());

				utentiHelper.addUtentiToDati(dati, TipoOperazione.CHANGE, singlePdD,
						nomesu,pwsu,confpwsu,interfaceType,
						isServizi,isDiagnostica,isSistema,isMessaggi,isUtenti,isAuditing,isAccordiCooperazione,
						changepwd);

				pd.setDati(dati);

				ServletUtils.setGeneralAndPageDataIntoSession(session, gd, pd);

				return ServletUtils.getStrutsForwardEditModeInProgress(mapping, UtentiCostanti.OBJECT_NAME_UTENTI, ForwardParams.CHANGE());

			}

			// Controlli sui campi immessi
			boolean isOk = utentiHelper.utentiCheckData(TipoOperazione.CHANGE,singlePdD);
			if (!isOk) {

				// setto la barra del titolo
				//				ServletUtils.setPageDataTitle_ServletChange(pd, UtentiCostanti.LABEL_UTENTI, 
				//						UtentiCostanti.SERVLET_NAME_UTENTI_LIST,
				//						nomesu);

				ServletUtils.setPageDataTitle(pd, 
						new Parameter(ConfigurazioneCostanti.LABEL_CONFIGURAZIONE,null),
						new Parameter(UtentiCostanti.LABEL_UTENTI, UtentiCostanti.SERVLET_NAME_UTENTI_LIST),
						new Parameter(nomesu,null));

				// preparo i campi
				Vector<DataElement> dati = new Vector<DataElement>();

				dati.addElement(ServletUtils.getDataElementForEditModeFinished());

				utentiHelper.addUtentiToDati(dati, TipoOperazione.CHANGE, singlePdD,
						nomesu,pwsu,confpwsu,interfaceType,
						isServizi,isDiagnostica,isSistema,isMessaggi,isUtenti,isAuditing,isAccordiCooperazione,
						changepwd);

				pd.setDati(dati);

				ServletUtils.setGeneralAndPageDataIntoSession(session, gd, pd);

				return ServletUtils.getStrutsForwardEditModeCheckError(mapping, UtentiCostanti.OBJECT_NAME_UTENTI, ForwardParams.CHANGE());
			}

			// Se singleSuServizi != null, controllo che il superutente non sia
			// quello che sto modificando
			// Se singleSu = null, controllo se l'utente aveva permessi S
			List<String> usersWithS = utentiCore.getUsersWithType(Permessi.SERVIZI.toString());

			String[] uws = null;
			if (usersWithS != null && usersWithS.size() > 0) {
				Vector<String> usersWithPermessoS = new Vector<String>();
				Iterator<String> itUWS = usersWithS.iterator();
				while (itUWS.hasNext()) {
					String singleUWS = itUWS.next();
					if (nomesu.equals(singleUWS) == false) {
						usersWithPermessoS.add(singleUWS);
					}
				}
				if(usersWithPermessoS.size()>0){
					uws = new String[1];
					uws = usersWithPermessoS.toArray(uws);
				}
			}

			// Se singleSuAccordi = null, controllo se l'utente aveva permessi P
			List<String> usersWithP = utentiCore.getUsersWithType(Permessi.ACCORDI_COOPERAZIONE.toString());

			String[] uwp = null;
			if (usersWithP != null && usersWithP.size() > 0) {
				Vector<String> usersWithPermessoP = new Vector<String>();
				Iterator<String> itUWS = usersWithP.iterator();
				while (itUWS.hasNext()) {
					String singleUWP = itUWS.next();
					if (nomesu.equals(singleUWP) == false) {
						usersWithPermessoP.add(singleUWP);
					}
				}
				if(usersWithPermessoP.size()>0){
					uwp = new String[1];
					uwp = usersWithPermessoP.toArray(uwp);
				}
			}

			// check input relativo ai servizi
			String msgServizi = "";
			boolean paginaSuServizi = false;

			if (singleSuServizi != null) {
				if (nomesu.equals(singleSuServizi)) {
					paginaSuServizi = true;
					msgServizi = "Scegliere un utente con il permesso 'Servizi' che non sia quello che sto modificando<br>";
				}
			} else {
				if ((isServizi == null || !isServizi.equals("yes")) &&
						usersWithS.contains(nomesu)) {
					if(uws==null){

						Vector<DataElement> dati = new Vector<DataElement>();

						dati.addElement(ServletUtils.getDataElementForEditModeFinished());

						pd.disableEditMode();

						pd.setDati(dati);

						// Preparo il menu
						pd.setMessage("Non è possibile eliminare il permesso 'Servizi', poichè non esistono altri utenti con tale permesso");

						ServletUtils.setGeneralAndPageDataIntoSession(session, gd, pd);

						return ServletUtils.getStrutsForwardGeneralError(mapping, UtentiCostanti.OBJECT_NAME_UTENTI, ForwardParams.CHANGE());	

					}else{
						paginaSuServizi = true;
						msgServizi = "Scegliere un utente a cui verranno assegnati tutti gli oggetti appartenenti all'utente '"+nomesu+
								"'.<br>L'operazione si è resa necessaria in seguito all'eliminazione del permesso di gestione 'Servizi' (S).<br>";
					}
				}
			}

			String msgAccordi = "";
			boolean paginaSuAccordi = false;
			boolean checkOggettiAccordi = false;
			if (singleSuAccordiCooperazione != null) {
				if (nomesu.equals(singleSuAccordiCooperazione)) {
					paginaSuAccordi = true;
					msgAccordi = "Scegliere un utente con il permesso 'Accordi Cooperazione' che non sia quello che sto modificando<br>";
				}
			} else {
				if ((isAccordiCooperazione == null || !isAccordiCooperazione.equals("yes")) &&
						usersWithP.contains(nomesu)) {
					if(uwp==null){
						// controllare che l'utente possieda degli oggetti
						checkOggettiAccordi = true;
					}else{
						paginaSuAccordi = true;
						msgAccordi = (!msgServizi.contains("Scegliere un utente")
								? ("Scegliere un utente a cui verranno assegnati tutti gli oggetti appartenenti all'utente '"+nomesu+	"'.<br>") : "")
								+"L'operazione si è resa necessaria in seguito all'eliminazione del permesso di gestione 'Accordi Cooperazione' (P).<br>";
					}
				}
			}


			boolean paginaSu = paginaSuAccordi || paginaSuServizi;
			// CHECK
			String msg = msgServizi + msgAccordi;

			// Se paginaSu = true, propongo una pagina in cui faccio scegliere
			// un superutente con permessi S e/o P a cui assegnare gli oggetti
			// dell'utente che sto modificando
			// In caso contrario, modifico l'utente, assegnando gli eventuali
			// oggetti a singleSu
			if (paginaSu) {
				// Faccio scegliere il superutente a cui assegnare gli oggetti

				// Preparo il menu
				utentiHelper.makeMenu();

				// setto la barra del titolo
				//				ServletUtils.setPageDataTitle_ServletChange(pd, UtentiCostanti.LABEL_UTENTI, 
				//						UtentiCostanti.SERVLET_NAME_UTENTI_LIST,
				//						nomesu);

				ServletUtils.setPageDataTitle(pd, 
						new Parameter(ConfigurazioneCostanti.LABEL_CONFIGURAZIONE,null),
						new Parameter(UtentiCostanti.LABEL_UTENTI, UtentiCostanti.SERVLET_NAME_UTENTI_LIST),
						new Parameter(nomesu,null));

				// preparo i campi
				Vector<DataElement> dati = new Vector<DataElement>();

				dati.addElement(ServletUtils.getDataElementForEditModeFinished());

				utentiHelper.addChangeUtenteInfoToDati(dati, nomesu, changepwd, pwsu, confpwsu, interfaceType, 
						isServizi, isDiagnostica, isSistema, isMessaggi, isUtenti, isAuditing,isAccordiCooperazione,paginaSuServizi,  uws, paginaSuAccordi, uwp);

				pd.setDati(dati);
				pd.setMessage(msg);

				ServletUtils.setGeneralAndPageDataIntoSession(session, gd, pd);

				return ServletUtils.getStrutsForward(mapping, UtentiCostanti.OBJECT_NAME_UTENTI, ForwardParams.CHANGE(),UtentiCostanti.STRUTS_FORWARD_INFO);	

			} else {

				// Modifico l'utente

				// Cripto la password
				boolean cpwd = ServletUtils.isCheckBoxEnabled(changepwd);
				if(cpwd && !"".equals(pwsu)){
					Password procToCall = new Password();
					pwsu = procToCall.cryptPw(pwsu);
				}

				// Modifico i dati dell'utente
				user.setInterfaceType(InterfaceType.valueOf(tipoGui));
				if(cpwd && !"".equals(pwsu))
					user.setPassword(pwsu);
				String puString = "";

				if (isServizi != null && ServletUtils.isCheckBoxEnabled(isServizi))
					puString = Permessi.SERVIZI.toString();

				if (isDiagnostica != null && ServletUtils.isCheckBoxEnabled(isDiagnostica)) {
					if (puString.equals(""))
						puString = Permessi.DIAGNOSTICA.toString();
					else
						puString = puString+","+Permessi.DIAGNOSTICA.toString();
				}

				if (isSistema != null && ServletUtils.isCheckBoxEnabled(isSistema)) {
					if (puString.equals(""))
						puString = Permessi.SISTEMA.toString();
					else
						puString = puString+","+Permessi.SISTEMA.toString();
				}

				if (isMessaggi != null && ServletUtils.isCheckBoxEnabled(isMessaggi)) {
					if (puString.equals(""))
						puString = Permessi.CODE_MESSAGGI.toString();
					else
						puString = puString+","+Permessi.CODE_MESSAGGI.toString();
				}

				if (isUtenti != null && ServletUtils.isCheckBoxEnabled(isUtenti)) {
					if (puString.equals(""))
						puString = Permessi.UTENTI.toString();
					else
						puString = puString+","+Permessi.UTENTI.toString();
				}

				if (isAuditing != null && ServletUtils.isCheckBoxEnabled(isAuditing)) {
					if (puString.equals(""))
						puString = Permessi.AUDITING.toString();
					else
						puString = puString+","+Permessi.AUDITING.toString();
				}
				if (isAccordiCooperazione != null && ServletUtils.isCheckBoxEnabled(isAccordiCooperazione)) {
					if (puString.equals(""))
						puString = Permessi.ACCORDI_COOPERAZIONE.toString();
					else
						puString = puString+","+Permessi.ACCORDI_COOPERAZIONE.toString();
				}

				user.setPermessi(PermessiUtente.toPermessiUtente(puString));

				// Se singleSu != null, devo recuperare gli oggetti
				// dell'utente ed assegnarli a singleSu
				List<Object> oggetti = new ArrayList<Object>();
				List<Integer> tipoModifica = new ArrayList<Integer>();
				if (singleSuServizi != null && !singleSuServizi.equals("")) {
					if(soggettiCore.isRegistroServiziLocale()){
						// Recupero le pdd dell'utente
						List<PdDControlStation> pdsLista = pddCore.pddList(nomesu, new Search());
						Iterator<PdDControlStation> itPds = pdsLista.iterator();
						while (itPds.hasNext()) {
							PdDControlStation pds = itPds.next();
							pds.setSuperUser(singleSuServizi);
							oggetti.add(pds);
							tipoModifica.add(org.openspcoop2.web.ctrlstat.costanti.CostantiControlStation.PERFORM_OPERATION_UPDATE);
						}
						// Recupero gli accordi servizio dell'utente
						List<AccordoServizioParteComune> asLista = apcCore.accordiServizioParteComuneList(nomesu, new Search());
						Iterator<AccordoServizioParteComune> itAs = asLista.iterator();
						while (itAs.hasNext()) {
							AccordoServizioParteComune as = itAs.next();
							as.setSuperUser(singleSuServizi);
							oggetti.add(as);
							tipoModifica.add(org.openspcoop2.web.ctrlstat.costanti.CostantiControlStation.PERFORM_OPERATION_UPDATE);
						}
						// Recupero i soggetti dell'utente
						List<Soggetto> soggLista = soggettiCore.soggettiRegistroList(nomesu, new Search());
						Iterator<Soggetto> itSs = soggLista.iterator();
						while (itSs.hasNext()) {					
							Soggetto sogg = itSs.next();
							sogg.setSuperUser(singleSuServizi);
							org.openspcoop2.core.config.Soggetto soggConf = soggettiCore.getSoggetto(new IDSoggetto(sogg.getTipo(),sogg.getNome()));
							soggConf.setSuperUser(singleSuServizi);
							SoggettoCtrlStat soggControlStation = new SoggettoCtrlStat(sogg,soggConf);
							oggetti.add(soggControlStation);
							tipoModifica.add(org.openspcoop2.web.ctrlstat.costanti.CostantiControlStation.PERFORM_OPERATION_UPDATE);
						}
					}
					else{
						// Recupero i soggetti dell'utente
						List<org.openspcoop2.core.config.Soggetto> soggLista = soggettiCore.soggettiList(nomesu, new Search());
						Iterator<org.openspcoop2.core.config.Soggetto> itSs = soggLista.iterator();
						while (itSs.hasNext()) {					
							org.openspcoop2.core.config.Soggetto sogg = itSs.next();
							sogg.setSuperUser(singleSuServizi);
							oggetti.add(sogg);
							tipoModifica.add(org.openspcoop2.web.ctrlstat.costanti.CostantiControlStation.PERFORM_OPERATION_UPDATE);
						}
					}
				}

				if(soggettiCore.isRegistroServiziLocale()){
					if ((singleSuAccordiCooperazione != null && !singleSuAccordiCooperazione.equals("")) || checkOggettiAccordi) {
						// Recupero gli accordi di cooperazione dell'utente
						List<AccordoCooperazione> acLista = acCore.accordiCooperazioneList(nomesu, new Search());
						Iterator<AccordoCooperazione> itAc = acLista.iterator();
						while (itAc.hasNext()) {
							AccordoCooperazione ac = itAc.next();
							ac.setSuperUser(singleSuAccordiCooperazione);
							oggetti.add(ac);
							tipoModifica.add(org.openspcoop2.web.ctrlstat.costanti.CostantiControlStation.PERFORM_OPERATION_UPDATE);
						}
						// Recupero gli accordi servizio composto dell'utente
						List<AccordoServizioParteComune> asLista = apcCore.accordiServizioCompostiList(nomesu, new Search());
						Iterator<AccordoServizioParteComune> itAs = asLista.iterator();
						while (itAs.hasNext()) {
							AccordoServizioParteComune as = itAs.next();
							as.setSuperUser(singleSuAccordiCooperazione);
							oggetti.add(as);
							tipoModifica.add(org.openspcoop2.web.ctrlstat.costanti.CostantiControlStation.PERFORM_OPERATION_UPDATE);
						}
	
	
						//check oggetti presenti
	
						if(checkOggettiAccordi){
							if(oggetti.size() > 0){
								Vector<DataElement> dati = new Vector<DataElement>();
	
								dati.addElement(ServletUtils.getDataElementForEditModeFinished());
	
								pd.disableEditMode();
	
								pd.setDati(dati);
	
								// Preparo il menu
								pd.setMessage("Non è possibile eliminare il permesso 'Accordi Cooperazione', poichè non esistono altri utenti con tale permesso");
	
								ServletUtils.setGeneralAndPageDataIntoSession(session, gd, pd);
	
								return ServletUtils.getStrutsForwardGeneralError(mapping, UtentiCostanti.OBJECT_NAME_UTENTI, ForwardParams.CHANGE());
							}
						}
					}
				}





				// Alla fine, modifico l'utente
				oggetti.add(user);
				tipoModifica.add(org.openspcoop2.web.ctrlstat.costanti.CostantiControlStation.PERFORM_OPERATION_UPDATE);
				int[] operationTypes = new int[tipoModifica.size()];
				for (int cO = 0; cO < tipoModifica.size(); cO++)
					operationTypes[cO] = tipoModifica.get(cO);
				utentiCore.performOperationMultiTypes(userLogin, utentiHelper.smista(), operationTypes, oggetti.toArray());



				// Se sto modificando l'utente che è anche quello connesso
				if(userLogin.equals(user.getLogin())){

					LoginSessionUtilities.cleanLoginParametersSession(session);

					ServletUtils.setUserIntoSession(session, user); // update in sessione.
					LoginSessionUtilities.setLoginParametersSession(session, utentiCore, userLogin);

				}


				// Se ho modificato l'utente loggato non faccio caricare la lista, degli utente ma una
				// pagina di info che indica che l'utente e' stato modificato con successo
				// MOTIVO: Viene effettuato il refresh della colonna a sinistra, se per caso sono cambiati i diritti
				if (userLogin.equals(user.getLogin())){

					// Reinit general data per aggiornare lo stato della barra dell'header a dx.
					gd = generalHelper.initGeneralData(request);
					
					utentiHelper.makeMenu();

					pd.setMessage("Utente '"+userLogin+"' modificato con successo");

					ServletUtils.setGeneralAndPageDataIntoSession(session, gd, pd);

					return ServletUtils.getStrutsForward(mapping, UtentiCostanti.OBJECT_NAME_UTENTI, ForwardParams.CHANGE(),UtentiCostanti.STRUTS_FORWARD_PERMESSI_OK);	

				} else {

					// Preparo la lista
					int idLista = Liste.SU;

					Search ricerca = (Search) ServletUtils.getSearchObjectFromSession(session,Search.class);

					ricerca = utentiHelper.checkSearchParameters(idLista, ricerca);

					List<User> lista = utentiCore.userList(ricerca);

					utentiHelper.prepareUtentiList(ricerca, lista, singlePdD);

					ServletUtils.setGeneralAndPageDataIntoSession(session, gd, pd);

					return ServletUtils.getStrutsForwardEditModeFinished(mapping, UtentiCostanti.OBJECT_NAME_UTENTI, ForwardParams.CHANGE());
				}
			}
		} catch (Exception e) {
			return ServletUtils.getStrutsForwardError(ControlStationCore.getLog(), e, pd, session, gd, mapping, 
					UtentiCostanti.OBJECT_NAME_UTENTI, ForwardParams.CHANGE());
		}
	}
}
