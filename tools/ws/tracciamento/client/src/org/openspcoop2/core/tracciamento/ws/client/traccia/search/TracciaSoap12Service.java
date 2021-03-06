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
package org.openspcoop2.core.tracciamento.ws.client.traccia.search;

import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceFeature;
import javax.xml.ws.Service;

/**
 * This class was generated by Apache CXF 2.7.4
 * 2015-02-18T17:09:26.801+01:00
 * Generated source version: 2.7.4
 * 
 */
@WebServiceClient(name = "TracciaSoap12Service", 
                  wsdlLocation = "deploy/wsdl/TracciaSearch_PortSoap12.wsdl",
                  targetNamespace = "http://www.openspcoop2.org/core/tracciamento/management") 
public class TracciaSoap12Service extends Service {

    public final static URL WSDL_LOCATION;

    public final static QName SERVICE = new QName("http://www.openspcoop2.org/core/tracciamento/management", "TracciaSoap12Service");
    public final static QName TracciaPortSoap12 = new QName("http://www.openspcoop2.org/core/tracciamento/management", "TracciaPortSoap12");
    static {
        URL url = TracciaSoap12Service.class.getResource("deploy/wsdl/TracciaSearch_PortSoap12.wsdl");
        if (url == null) {
            url = TracciaSoap12Service.class.getClassLoader().getResource("deploy/wsdl/TracciaSearch_PortSoap12.wsdl");
        } 
        if (url == null) {
            
		}
		if (url==null ){
			url = TracciaSoap12Service.class.getResource("/tracciamento/TracciaSearch_PortSoap12.wsdl");
		}
		if (url==null ){
			url = TracciaSoap12Service.class.getClassLoader().getResource("/tracciamento/TracciaSearch_PortSoap12.wsdl");
		}
		if (url==null ){
			java.util.logging.Logger.getLogger(TracciaSoap12Service.class.getName())
                .log(java.util.logging.Level.INFO, 
                     "Can not initialize the default wsdl from {0}", "deploy/wsdl/TracciaSearch_PortSoap12.wsdl");
        }       
        WSDL_LOCATION = url;
    }

    public TracciaSoap12Service(URL wsdlLocation) {
        super(wsdlLocation, TracciaSoap12Service.SERVICE);
    }

    public TracciaSoap12Service(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public TracciaSoap12Service() {
        super(TracciaSoap12Service.WSDL_LOCATION, TracciaSoap12Service.SERVICE);
    }
    

    /**
     *
     * @return
     *     returns Traccia
     */
    @WebEndpoint(name = "TracciaPortSoap12")
    public Traccia getTracciaPortSoap12() {
        return super.getPort(TracciaSoap12Service.TracciaPortSoap12, Traccia.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns Traccia
     */
    @WebEndpoint(name = "TracciaPortSoap12")
    public Traccia getTracciaPortSoap12(WebServiceFeature... features) {
        return super.getPort(TracciaSoap12Service.TracciaPortSoap12, Traccia.class, features);
    }

}
