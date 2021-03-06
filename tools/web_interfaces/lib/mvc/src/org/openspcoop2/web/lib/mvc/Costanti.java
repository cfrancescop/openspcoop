/*
 * OpenSPCoop - Customizable API Gateway 
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

package org.openspcoop2.web.lib.mvc;

import org.openspcoop2.web.lib.mvc.DataElement;

/**
 * Costanti
 * 
 * @author Andrea Poli (apoli@link.it)
 * @author $Author$
 * @version $Rev$, $Date$
 */
public class Costanti {

	/** SISTEMA NON DISPONIBILE */
	
	public static final String MESSAGGIO_SISTEMA_NON_DISPONIBILE = "Il sistema &egrave; momentaneamente indisponibile.<BR>Si prega di riprovare pi&ugrave; tardi";
	
	
	/** LABEL */
	
	public final static String LABEL_VISUALIZZA = "visualizza";
	public final static String LABEL_NON_DISPONIBILE = "non disp.";
	
	
	/** Multipart */
	public static final String MULTIPART = "multipart/form-data";
	public static final String MULTIPART_FILENAME = "filename";
	public static final String MULTIPART_START = "-----";
	public static final String MULTIPART_BEGIN = "BEGIN";
	public static final String MULTIPART_END = "END";
	
	
	/** PARAMETER */
	
	public final static String PARAMETER_NAME_OBJECTS_FOR_REMOVE = "obj";
	public final static String PARAMETER_NAME_MSG_ERROR_EXPORT = "errorExport";
	
	/** PARAMETER ATTRIBUTE */
	
	public final static String REQUEST_ATTIBUTE_PARAMS = "params";
	
	
	/** SEARCH */
	
	public final static String SEARCH_ENABLED ="on";
	public final static String SEARCH_DISABLED ="off";
	
	
	/** POSTBACK FUNCTION */
	
	public final static String POSTBACK_ELEMENT_NAME = "postBackElementName"; //nome dell'element che ha scaturito il postBack
	public final static String POSTBACK_FUNCTION = "postBack()";
	public final static String POSTBACK_FUNCTION_WITH_PARAMETER_START = "postBack('";
	public final static String POSTBACK_FUNCTION_WITH_PARAMETER_END = "')";
	
	
	/** CHECK BOX */
	
	public final static String CHECK_BOX_ENABLED = "yes";
	public final static String CHECK_BOX_ENABLED_TRUE = "true";
	public final static String CHECK_BOX_ENABLED_ABILITATO = "abilitato";
	public final static String CHECK_BOX_DISABLED = "no";
	
	
	/** PAGE DATA TITLE */
	
	public final static String PAGE_DATA_TITLE_LABEL_AGGIUNGI = "Aggiungi";
	public final static String PAGE_DATA_TITLE_LABEL_ELENCO = "Elenco";
	public final static String PAGE_DATA_TITLE_LABEL_VISUALIZZA = "Visualizza";
	public final static String PAGE_DATA_TITLE_LABEL_RISULTATI_RICERCA = "Risultati ricerca";
	public final static String PAGE_DATA_TITLE_LABEL_ELIMINA = "Elimina";
	public final static String PAGE_DATA_TITLE_LABEL_MODIFICA = "Modifica";
	public final static String PAGE_DATA_TITLE_LABEL_REGISTRO = "Registro";
	
	
	/** STRUTS-FORWARD */
	
	public final static String STRUTS_FORWARD_FORM = "Form";
	public final static String STRUTS_FORWARD_CONFIRM_FORM = "ConfirmForm";
	public final static String STRUTS_FORWARD_OK = "Ok";
	public final static String STRUTS_FORWARD_CHECK_ERROR = "CheckError";	
	public final static String STRUTS_FORWARD_ERRORE_GENERALE = "Error";

	
	
	/** SESSION */
	
	protected final static String SESSION_ATTRIBUTE_LOGIN = "Login";
	protected final static String SESSION_ATTRIBUTE_USER = "User";
	protected final static String SESSION_ATTRIBUTE_GENERAL_DATA = "GeneralData";
	protected final static String SESSION_ATTRIBUTE_PAGE_DATA = "PageData";
	protected final static String SESSION_ATTRIBUTE_RICERCA = "Ricerca";
	protected final static String SESSION_ATTRIBUTE_CONTA_LISTE = "contaListe";
	protected final static String SESSION_ATTRIBUTE_LIST_ELEMENT ="ListElement";
	protected final static String SESSION_ATTRIBUTE_VALUE_RICERCA_UNDEFINED = org.openspcoop2.core.constants.Costanti.SESSION_ATTRIBUTE_VALUE_RICERCA_UNDEFINED;
	protected final static String SESSION_ATTRIBUTE_VALUE_SOGGETTO_VIRTUALE_YES ="yes";
	protected final static String SESSION_ATTRIBUTE_GENERAZIONE_AUTOMATICA_PD ="generazioneAutomaticaPD";
	protected final static String SESSION_ATTRIBUTE_GESTIONE_WSBL ="GestioneWSBL";
	protected final static String SESSION_ATTRIBUTE_CONFIGURAZIONI_PERSONALIZZATE ="ConfigurazioniPersonalizzate";
	
	/** COOKIES **/
	
	public static final String COOKIE_NAME_JSESSIONID = "JSESSIONID";
	
	
	/** DATA ELEMENT **/
	
	public final static String DATA_ELEMENT_EDIT_MODE_NAME = "edit-mode";
	public final static String DATA_ELEMENT_EDIT_MODE_DISABLE_NAME = "view-noeditbutton";
	public final static String DATA_ELEMENT_DISABLE_ONLY_BUTTON = "view-nobutton";
	
	public final static String DATA_ELEMENT_EDIT_MODE_VALUE_EDIT_IN_PROGRESS_POSTBACK = "in_progress_postback";
	public final static String DATA_ELEMENT_EDIT_MODE_VALUE_EDIT_IN_PROGRESS = "in_progress";
	public final static String DATA_ELEMENT_EDIT_MODE_VALUE_EDIT_END = "end";
	
	public static DataElement DATA_ELEMENT_HIDDENT_EDIT_MODE_END = new DataElement();
	static{
		DATA_ELEMENT_HIDDENT_EDIT_MODE_END.setLabel(Costanti.DATA_ELEMENT_EDIT_MODE_NAME);
		DATA_ELEMENT_HIDDENT_EDIT_MODE_END.setValue(DATA_ELEMENT_EDIT_MODE_VALUE_EDIT_END);
		DATA_ELEMENT_HIDDENT_EDIT_MODE_END.setType(DataElementType.HIDDEN);
		DATA_ELEMENT_HIDDENT_EDIT_MODE_END.setName(Costanti.DATA_ELEMENT_EDIT_MODE_NAME);
	}
	
	public static Parameter PARAMETER_EDIT_MODE_END = new Parameter
			(DATA_ELEMENT_EDIT_MODE_NAME, DATA_ELEMENT_EDIT_MODE_VALUE_EDIT_END);

	
	public static DataElement DATA_ELEMENT_HIDDENT_EDIT_MODE_IN_PROGRESS = new DataElement();
	static{
		DATA_ELEMENT_HIDDENT_EDIT_MODE_IN_PROGRESS.setLabel(Costanti.DATA_ELEMENT_EDIT_MODE_NAME);
		DATA_ELEMENT_HIDDENT_EDIT_MODE_IN_PROGRESS.setValue(DATA_ELEMENT_EDIT_MODE_VALUE_EDIT_IN_PROGRESS);
		DATA_ELEMENT_HIDDENT_EDIT_MODE_IN_PROGRESS.setType(DataElementType.HIDDEN);
		DATA_ELEMENT_HIDDENT_EDIT_MODE_IN_PROGRESS.setName(Costanti.DATA_ELEMENT_EDIT_MODE_NAME);
	}
	
	/** FUNZIONE ESEGUI / ANNULLA  CONFERMA **/
	
	public final static String PARAMETRO_ACTION_CONFIRM = "actionConfirm";
	
	public final static String LABEL_MONITOR_BUTTON_OK = "Ok";
	public final static String LABEL_MONITOR_BUTTON_ANNULLA = "Annulla";
	
	public final static String LABEL_MONITOR_BUTTON_ESEGUI_OPERAZIONE_CONFERMA_PREFIX = "EseguiConferma(";
	public final static String LABEL_MONITOR_BUTTON_ESEGUI_OPERAZIONE_CONFERMA_SUFFIX = ")";
	
	public final static String LABEL_MONITOR_BUTTON_ANNULLA_CONFERMA_PREFIX = "AnnullaConferma("; 
	public final static String LABEL_MONITOR_BUTTON_ANNULLA_CONFERMA_SUFFIX = ")"; 
	
	public final static String PARAMETRO_ACTION_CONFIRM_VALUE_OK = "ok";
	public final static String PARAMETRO_ACTION_CONFIRM_VALUE_NO = "no";
}
