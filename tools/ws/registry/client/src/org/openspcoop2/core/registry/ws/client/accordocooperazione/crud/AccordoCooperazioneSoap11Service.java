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
package org.openspcoop2.core.registry.ws.client.accordocooperazione.crud;

import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceFeature;
import javax.xml.ws.Service;

/**
 * This class was generated by Apache CXF 2.7.4
 * 2015-01-26T16:23:03.321+01:00
 * Generated source version: 2.7.4
 * 
 */
@WebServiceClient(name = "AccordoCooperazioneSoap11Service", 
                  wsdlLocation = "deploy/wsdl/AccordoCooperazioneCRUD_PortSoap11.wsdl",
                  targetNamespace = "http://www.openspcoop2.org/core/registry/management") 
public class AccordoCooperazioneSoap11Service extends Service {

    public final static URL WSDL_LOCATION;

    public final static QName SERVICE = new QName("http://www.openspcoop2.org/core/registry/management", "AccordoCooperazioneSoap11Service");
    public final static QName AccordoCooperazionePortSoap11 = new QName("http://www.openspcoop2.org/core/registry/management", "AccordoCooperazionePortSoap11");
    static {
        URL url = AccordoCooperazioneSoap11Service.class.getResource("deploy/wsdl/AccordoCooperazioneCRUD_PortSoap11.wsdl");
        if (url == null) {
            url = AccordoCooperazioneSoap11Service.class.getClassLoader().getResource("deploy/wsdl/AccordoCooperazioneCRUD_PortSoap11.wsdl");
        } 
        if (url == null) {
            
		}
		if (url==null ){
			url = AccordoCooperazioneSoap11Service.class.getResource("/registry/AccordoCooperazioneCRUD_PortSoap11.wsdl");
		}
		if (url==null ){
			url = AccordoCooperazioneSoap11Service.class.getClassLoader().getResource("/registry/AccordoCooperazioneCRUD_PortSoap11.wsdl");
		}
		if (url==null ){
			java.util.logging.Logger.getLogger(AccordoCooperazioneSoap11Service.class.getName())
                .log(java.util.logging.Level.INFO, 
                     "Can not initialize the default wsdl from {0}", "deploy/wsdl/AccordoCooperazioneCRUD_PortSoap11.wsdl");
        }       
        WSDL_LOCATION = url;
    }

    public AccordoCooperazioneSoap11Service(URL wsdlLocation) {
        super(wsdlLocation, AccordoCooperazioneSoap11Service.SERVICE);
    }

    public AccordoCooperazioneSoap11Service(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public AccordoCooperazioneSoap11Service() {
        super(AccordoCooperazioneSoap11Service.WSDL_LOCATION, AccordoCooperazioneSoap11Service.SERVICE);
    }
    

    /**
     *
     * @return
     *     returns AccordoCooperazione
     */
    @WebEndpoint(name = "AccordoCooperazionePortSoap11")
    public AccordoCooperazione getAccordoCooperazionePortSoap11() {
        return super.getPort(AccordoCooperazioneSoap11Service.AccordoCooperazionePortSoap11, AccordoCooperazione.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns AccordoCooperazione
     */
    @WebEndpoint(name = "AccordoCooperazionePortSoap11")
    public AccordoCooperazione getAccordoCooperazionePortSoap11(WebServiceFeature... features) {
        return super.getPort(AccordoCooperazioneSoap11Service.AccordoCooperazionePortSoap11, AccordoCooperazione.class, features);
    }

}