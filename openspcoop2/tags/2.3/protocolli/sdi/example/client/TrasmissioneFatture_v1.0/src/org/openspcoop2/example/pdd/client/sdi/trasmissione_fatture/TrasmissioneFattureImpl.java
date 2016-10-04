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

/**
 * Please modify this class to meet your needs
 * This class is not complete
 */

package org.openspcoop2.example.pdd.client.sdi.trasmissione_fatture;

import java.util.logging.Logger;

/**
 * This class was generated by Apache CXF 2.7.4
 * 2014-10-10T14:24:52.597+02:00
 * Generated source version: 2.7.4
 * 
 * @author Andrea Poli (apoli@link.it)
 * @author $Author$
 * @version $Rev$, $Date$
 */

@javax.jws.WebService(
                      serviceName = "TrasmissioneFatture_service",
                      portName = "TrasmissioneFatture_port",
                      targetNamespace = "http://www.fatturapa.gov.it/sdi/ws/trasmissione/v1.0",
                      wsdlLocation = "TrasmissioneFatture_v1.1.wsdl",
                      endpointInterface = "org.openspcoop2.example.pdd.client.sdi.trasmissione_fatture.TrasmissioneFatture")
                      
public class TrasmissioneFattureImpl implements TrasmissioneFatture {

    private static final Logger LOG = Logger.getLogger(TrasmissioneFattureImpl.class.getName());

    /* (non-Javadoc)
     * @see org.openspcoop2.example.pdd.client.sdi.trasmissione_fatture.TrasmissioneFatture#notificaDecorrenzaTermini(org.openspcoop2.example.pdd.client.sdi.trasmissione_fatture.FileSdIType  decorrenzaTermini )*
     */
    @Override
	public void notificaDecorrenzaTermini(FileSdIType decorrenzaTermini) { 
        TrasmissioneFattureImpl.LOG.info("Executing operation notificaDecorrenzaTermini");
        System.out.println(decorrenzaTermini);
        try {
        } catch (java.lang.Exception ex) {
            ex.printStackTrace();
            throw new RuntimeException(ex);
        }
    }

    /* (non-Javadoc)
     * @see org.openspcoop2.example.pdd.client.sdi.trasmissione_fatture.TrasmissioneFatture#notificaMancataConsegna(org.openspcoop2.example.pdd.client.sdi.trasmissione_fatture.FileSdIType  mancataConsegna )*
     */
    @Override
	public void notificaMancataConsegna(FileSdIType mancataConsegna) { 
        TrasmissioneFattureImpl.LOG.info("Executing operation notificaMancataConsegna");
        System.out.println(mancataConsegna);
        try {
        } catch (java.lang.Exception ex) {
            ex.printStackTrace();
            throw new RuntimeException(ex);
        }
    }

    /* (non-Javadoc)
     * @see org.openspcoop2.example.pdd.client.sdi.trasmissione_fatture.TrasmissioneFatture#ricevutaConsegna(org.openspcoop2.example.pdd.client.sdi.trasmissione_fatture.FileSdIType  ricevuta )*
     */
    @Override
	public void ricevutaConsegna(FileSdIType ricevuta) { 
        TrasmissioneFattureImpl.LOG.info("Executing operation ricevutaConsegna");
        System.out.println(ricevuta);
        try {
        } catch (java.lang.Exception ex) {
            ex.printStackTrace();
            throw new RuntimeException(ex);
        }
    }

    /* (non-Javadoc)
     * @see org.openspcoop2.example.pdd.client.sdi.trasmissione_fatture.TrasmissioneFatture#notificaScarto(org.openspcoop2.example.pdd.client.sdi.trasmissione_fatture.FileSdIType  scarto )*
     */
    @Override
	public void notificaScarto(FileSdIType scarto) { 
        TrasmissioneFattureImpl.LOG.info("Executing operation notificaScarto");
        System.out.println(scarto);
        try {
        } catch (java.lang.Exception ex) {
            ex.printStackTrace();
            throw new RuntimeException(ex);
        }
    }

    /* (non-Javadoc)
     * @see org.openspcoop2.example.pdd.client.sdi.trasmissione_fatture.TrasmissioneFatture#attestazioneTrasmissioneFattura(org.openspcoop2.example.pdd.client.sdi.trasmissione_fatture.FileSdIType  attestazioneTrasmissioneFattura )*
     */
    @Override
	public void attestazioneTrasmissioneFattura(FileSdIType attestazioneTrasmissioneFattura) { 
        TrasmissioneFattureImpl.LOG.info("Executing operation attestazioneTrasmissioneFattura");
        System.out.println(attestazioneTrasmissioneFattura);
        try {
        } catch (java.lang.Exception ex) {
            ex.printStackTrace();
            throw new RuntimeException(ex);
        }
    }

    /* (non-Javadoc)
     * @see org.openspcoop2.example.pdd.client.sdi.trasmissione_fatture.TrasmissioneFatture#notificaEsito(org.openspcoop2.example.pdd.client.sdi.trasmissione_fatture.FileSdIType  esito )*
     */
    @Override
	public void notificaEsito(FileSdIType esito) { 
        TrasmissioneFattureImpl.LOG.info("Executing operation notificaEsito");
        System.out.println(esito);
        try {
        } catch (java.lang.Exception ex) {
            ex.printStackTrace();
            throw new RuntimeException(ex);
        }
    }

}