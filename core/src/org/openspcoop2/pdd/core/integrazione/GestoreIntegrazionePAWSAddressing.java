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

package org.openspcoop2.pdd.core.integrazione;

import javax.xml.soap.SOAPHeaderElement;

import org.slf4j.Logger;
import org.openspcoop2.message.OpenSPCoop2Message;
import org.openspcoop2.pdd.config.OpenSPCoop2Properties;
import org.openspcoop2.pdd.core.AbstractCore;
import org.openspcoop2.pdd.logger.OpenSPCoop2Logger;
import org.openspcoop2.utils.LoggerWrapperFactory;


/**
 * Classe utilizzata per la spedizione di informazioni di integrazione 
 * dalla porta di dominio verso i servizi applicativi.
 *
 * @author Poli Andrea (apoli@link.it)
 * @author $Author$
 * @version $Rev$, $Date$
 */
public class GestoreIntegrazionePAWSAddressing extends AbstractCore implements IGestoreIntegrazionePASoap{

	/** Utility per l'integrazione */
	UtilitiesIntegrazioneWSAddressing utilities = null;
	
	/** OpenSPCoopProperties */
	OpenSPCoop2Properties openspcoopProperties = OpenSPCoop2Properties.getInstance();
	
	/** Logger utilizzato per debug. */
	private Logger log = null;

	
	public GestoreIntegrazionePAWSAddressing(){
		this.log = OpenSPCoop2Logger.getLoggerOpenSPCoopCore();
		if(this.log==null){
			this.log = LoggerWrapperFactory.getLogger(GestoreIntegrazionePAWSAddressing.class);
		}

		try{
			this.utilities = UtilitiesIntegrazioneWSAddressing.getInstance(this.log);
		}catch(Exception e){
			this.log.error("Errore durante l'inizializzazione delle UtilitiesIntegrazioneWSAddressing: "+e.getMessage(),e);
		}
	}
	
	
	// IN - Request
	
	@Override
	public void readInRequestHeader(HeaderIntegrazione integrazione,
			InRequestPAMessage inRequestPAMessage) throws HeaderIntegrazioneException{
		try{
			this.utilities.readHeader(inRequestPAMessage.getMessage(), integrazione, UtilitiesIntegrazioneWSAddressing.INTERPRETA_COME_ID_BUSTA, this.openspcoopProperties.getHeaderSoapActorIntegrazione()+"/wsa");
		}catch(Exception e){
			throw new HeaderIntegrazioneException("GestoreIntegrazionePASoap, "+e.getMessage(),e);
		}
	}
	
	@Override
	public void deleteInRequestHeader(InRequestPAMessage inRequestPAMessage) throws HeaderIntegrazioneException{
		try{
			this.utilities.deleteHeader(inRequestPAMessage.getMessage(), this.openspcoopProperties.getHeaderSoapActorIntegrazione()+"/wsa");
		}catch(Exception e){
			throw new HeaderIntegrazioneException("GestoreIntegrazionePASoap, "+e.getMessage(),e);
		}
	}
	
	@Override
	public void updateInRequestHeader(InRequestPAMessage inRequestPAMessage,
			String idMessaggio,String servizioApplicativo,String correlazioneApplicativa) throws HeaderIntegrazioneException{
		try{
			this.utilities.updateHeader(inRequestPAMessage.getMessage(), 
					inRequestPAMessage.getSoggettoMittente(),
					inRequestPAMessage.getServizio(),
					idMessaggio, servizioApplicativo, correlazioneApplicativa, this.openspcoopProperties.getHeaderSoapActorIntegrazione()+"/wsa");
		}catch(Exception e){
			throw new HeaderIntegrazioneException("GestoreIntegrazionePASoap, "+e.getMessage(),e);
		}
	}
	
	
	// OUT - Request
	
	@Override
	public void setOutRequestHeader(HeaderIntegrazione integrazione,
			OutRequestPAMessage outRequestPAMessage) throws HeaderIntegrazioneException{
		try{
			
			OpenSPCoop2Message message = outRequestPAMessage.getMessage();
			if(message.getSOAPHeader() == null){
				message.getSOAPPart().getEnvelope().addHeader();
			}
			
			if(integrazione.getBusta()!=null){
				
				HeaderIntegrazioneBusta hBusta = integrazione.getBusta();
					
				if(hBusta.getDestinatario()!=null && hBusta.getServizio()!=null){
					
					// To
					SOAPHeaderElement wsaTO = UtilitiesIntegrazioneWSAddressing.buildWSATo(message,this.openspcoopProperties.getHeaderSoapActorIntegrazione()+"/wsa",hBusta.getTipoDestinatario(),hBusta.getDestinatario(), hBusta.getTipoServizio(), hBusta.getServizio());
					message.addHeaderElement(message.getSOAPHeader(), wsaTO);
										
					// Action
					if(hBusta.getAzione()!=null){
						SOAPHeaderElement wsaAction = UtilitiesIntegrazioneWSAddressing.buildWSAAction(message,this.openspcoopProperties.getHeaderSoapActorIntegrazione()+"/wsa",hBusta.getTipoDestinatario(),hBusta.getDestinatario(), hBusta.getTipoServizio(), hBusta.getServizio(),hBusta.getAzione());
						message.addHeaderElement(message.getSOAPHeader(), wsaAction);
					}
				}
				
				if(hBusta.getMittente()!=null){
					SOAPHeaderElement wsaFROM = UtilitiesIntegrazioneWSAddressing.buildWSAFrom(message,this.openspcoopProperties.getHeaderSoapActorIntegrazione()+"/wsa",integrazione.getServizioApplicativo(),hBusta.getTipoMittente(),hBusta.getMittente());
					message.addHeaderElement(message.getSOAPHeader(), wsaFROM);
				}
					
				if(hBusta.getID()!=null){
					SOAPHeaderElement wsaID = UtilitiesIntegrazioneWSAddressing.buildWSAID(message,this.openspcoopProperties.getHeaderSoapActorIntegrazione()+"/wsa",hBusta.getID());
					message.addHeaderElement(message.getSOAPHeader(), wsaID);
				}
				
				if(hBusta.getRiferimentoMessaggio()!=null || hBusta.getIdCollaborazione()!=null){
					String rif = hBusta.getRiferimentoMessaggio();
					if(rif==null){
						rif = hBusta.getIdCollaborazione();
					}
					SOAPHeaderElement wsaRelatesTo = UtilitiesIntegrazioneWSAddressing.buildWSARelatesTo(message,this.openspcoopProperties.getHeaderSoapActorIntegrazione()+"/wsa",rif);
					message.addHeaderElement(message.getSOAPHeader(), wsaRelatesTo);
				}
			}
			
		}catch(Exception e){
			throw new HeaderIntegrazioneException("GestoreIntegrazionePASoap, "+e.getMessage(),e);
		}
	}

	
	// IN - Response
	
	@Override
	public void readInResponseHeader(HeaderIntegrazione integrazione,
			InResponsePAMessage inResponsePAMessage) throws HeaderIntegrazioneException{
		try{
			this.utilities.readHeader(inResponsePAMessage.getMessage(), integrazione, UtilitiesIntegrazioneWSAddressing.INTERPRETA_COME_ID_APPLICATIVO, this.openspcoopProperties.getHeaderSoapActorIntegrazione()+"/wsa");
		}catch(Exception e){
			throw new HeaderIntegrazioneException("GestoreIntegrazionePASoap, "+e.getMessage(),e);
		}
	}
	
	@Override
	public void deleteInResponseHeader(InResponsePAMessage inResponsePAMessage) throws HeaderIntegrazioneException{
		try{
			this.utilities.deleteHeader(inResponsePAMessage.getMessage(), this.openspcoopProperties.getHeaderSoapActorIntegrazione()+"/wsa");
		}catch(Exception e){
			throw new HeaderIntegrazioneException("GestoreIntegrazionePASoap, "+e.getMessage(),e);
		}
	}
	
	@Override
	public void updateInResponseHeader(InResponsePAMessage inResponsePAMessage,
			String idMessageRequest,String idMessageResponse,String servizioApplicativo,String correlazioneApplicativa,String riferimentoCorrelazioneApplicativaRichiesta) throws HeaderIntegrazioneException{
		try{
			this.utilities.updateHeader(inResponsePAMessage.getMessage(), 
					inResponsePAMessage.getSoggettoMittente(),
					inResponsePAMessage.getServizio(),
					idMessageRequest, idMessageResponse, servizioApplicativo, correlazioneApplicativa, this.openspcoopProperties.getHeaderSoapActorIntegrazione()+"/wsa");
		}catch(Exception e){
			throw new HeaderIntegrazioneException("GestoreIntegrazionePASoap, "+e.getMessage(),e);
		}
	}
	
	// OUT - Response
		
	@Override
	public void setOutResponseHeader(HeaderIntegrazione integrazione,
			OutResponsePAMessage outResponsePAMessage) throws HeaderIntegrazioneException{
		
		// nop;
		
	}
}