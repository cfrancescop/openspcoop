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
package org.openspcoop2.core.registry.ws.client.portadominio.search;

import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceFeature;
import javax.xml.ws.Service;

/**
 * This class was generated by Apache CXF 2.7.4
 * 2015-01-26T16:24:28.821+01:00
 * Generated source version: 2.7.4
 * 
 */
@WebServiceClient(name = "PortaDominioSoap11Service", 
                  wsdlLocation = "deploy/wsdl/PortaDominioSearch_PortSoap11.wsdl",
                  targetNamespace = "http://www.openspcoop2.org/core/registry/management") 
public class PortaDominioSoap11Service extends Service {

    public final static URL WSDL_LOCATION;

    public final static QName SERVICE = new QName("http://www.openspcoop2.org/core/registry/management", "PortaDominioSoap11Service");
    public final static QName PortaDominioPortSoap11 = new QName("http://www.openspcoop2.org/core/registry/management", "PortaDominioPortSoap11");
    static {
        URL url = PortaDominioSoap11Service.class.getResource("deploy/wsdl/PortaDominioSearch_PortSoap11.wsdl");
        if (url == null) {
            url = PortaDominioSoap11Service.class.getClassLoader().getResource("deploy/wsdl/PortaDominioSearch_PortSoap11.wsdl");
        } 
        if (url == null) {
            
		}
		if (url==null ){
			url = PortaDominioSoap11Service.class.getResource("/registry/PortaDominioSearch_PortSoap11.wsdl");
		}
		if (url==null ){
			url = PortaDominioSoap11Service.class.getClassLoader().getResource("/registry/PortaDominioSearch_PortSoap11.wsdl");
		}
		if (url==null ){
			java.util.logging.Logger.getLogger(PortaDominioSoap11Service.class.getName())
                .log(java.util.logging.Level.INFO, 
                     "Can not initialize the default wsdl from {0}", "deploy/wsdl/PortaDominioSearch_PortSoap11.wsdl");
        }       
        WSDL_LOCATION = url;
    }

    public PortaDominioSoap11Service(URL wsdlLocation) {
        super(wsdlLocation, PortaDominioSoap11Service.SERVICE);
    }

    public PortaDominioSoap11Service(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public PortaDominioSoap11Service() {
        super(PortaDominioSoap11Service.WSDL_LOCATION, PortaDominioSoap11Service.SERVICE);
    }
    

    /**
     *
     * @return
     *     returns PortaDominio
     */
    @WebEndpoint(name = "PortaDominioPortSoap11")
    public PortaDominio getPortaDominioPortSoap11() {
        return super.getPort(PortaDominioSoap11Service.PortaDominioPortSoap11, PortaDominio.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns PortaDominio
     */
    @WebEndpoint(name = "PortaDominioPortSoap11")
    public PortaDominio getPortaDominioPortSoap11(WebServiceFeature... features) {
        return super.getPort(PortaDominioSoap11Service.PortaDominioPortSoap11, PortaDominio.class, features);
    }

}
