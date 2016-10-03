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
package org.openspcoop2.core.diagnostica.ws.client.informazioniprotocollotransazione.search;

import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceFeature;
import javax.xml.ws.Service;

/**
 * This class was generated by Apache CXF 2.7.4
 * 2015-02-20T15:28:37.021+01:00
 * Generated source version: 2.7.4
 * 
 */
@WebServiceClient(name = "InformazioniProtocolloTransazioneSoap11Service", 
                  wsdlLocation = "deploy/wsdl/InformazioniProtocolloTransazioneSearch_PortSoap11.wsdl",
                  targetNamespace = "http://www.openspcoop2.org/core/diagnostica/management") 
public class InformazioniProtocolloTransazioneSoap11Service extends Service {

    public final static URL WSDL_LOCATION;

    public final static QName SERVICE = new QName("http://www.openspcoop2.org/core/diagnostica/management", "InformazioniProtocolloTransazioneSoap11Service");
    public final static QName InformazioniProtocolloTransazionePortSoap11 = new QName("http://www.openspcoop2.org/core/diagnostica/management", "InformazioniProtocolloTransazionePortSoap11");
    static {
        URL url = InformazioniProtocolloTransazioneSoap11Service.class.getResource("deploy/wsdl/InformazioniProtocolloTransazioneSearch_PortSoap11.wsdl");
        if (url == null) {
            url = InformazioniProtocolloTransazioneSoap11Service.class.getClassLoader().getResource("deploy/wsdl/InformazioniProtocolloTransazioneSearch_PortSoap11.wsdl");
        } 
        if (url == null) {
            
		}
		if (url==null ){
			url = InformazioniProtocolloTransazioneSoap11Service.class.getResource("/diagnostica/InformazioniProtocolloTransazioneSearch_PortSoap11.wsdl");
		}
		if (url==null ){
			url = InformazioniProtocolloTransazioneSoap11Service.class.getClassLoader().getResource("/diagnostica/InformazioniProtocolloTransazioneSearch_PortSoap11.wsdl");
		}
		if (url==null ){
			java.util.logging.Logger.getLogger(InformazioniProtocolloTransazioneSoap11Service.class.getName())
                .log(java.util.logging.Level.INFO, 
                     "Can not initialize the default wsdl from {0}", "deploy/wsdl/InformazioniProtocolloTransazioneSearch_PortSoap11.wsdl");
        }       
        WSDL_LOCATION = url;
    }

    public InformazioniProtocolloTransazioneSoap11Service(URL wsdlLocation) {
        super(wsdlLocation, InformazioniProtocolloTransazioneSoap11Service.SERVICE);
    }

    public InformazioniProtocolloTransazioneSoap11Service(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public InformazioniProtocolloTransazioneSoap11Service() {
        super(InformazioniProtocolloTransazioneSoap11Service.WSDL_LOCATION, InformazioniProtocolloTransazioneSoap11Service.SERVICE);
    }
    

    /**
     *
     * @return
     *     returns InformazioniProtocolloTransazione
     */
    @WebEndpoint(name = "InformazioniProtocolloTransazionePortSoap11")
    public InformazioniProtocolloTransazione getInformazioniProtocolloTransazionePortSoap11() {
        return super.getPort(InformazioniProtocolloTransazioneSoap11Service.InformazioniProtocolloTransazionePortSoap11, InformazioniProtocolloTransazione.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns InformazioniProtocolloTransazione
     */
    @WebEndpoint(name = "InformazioniProtocolloTransazionePortSoap11")
    public InformazioniProtocolloTransazione getInformazioniProtocolloTransazionePortSoap11(WebServiceFeature... features) {
        return super.getPort(InformazioniProtocolloTransazioneSoap11Service.InformazioniProtocolloTransazionePortSoap11, InformazioniProtocolloTransazione.class, features);
    }

}
