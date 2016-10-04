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
package org.openspcoop2.core.registry.ws.client.accordoserviziopartespecifica.search;

import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceFeature;
import javax.xml.ws.Service;

/**
 * This class was generated by Apache CXF 2.7.4
 * 2015-01-26T16:26:12.468+01:00
 * Generated source version: 2.7.4
 * 
 */
@WebServiceClient(name = "AccordoServizioParteSpecificaSoap11Service", 
                  wsdlLocation = "deploy/wsdl/AccordoServizioParteSpecificaSearch_PortSoap11.wsdl",
                  targetNamespace = "http://www.openspcoop2.org/core/registry/management") 
public class AccordoServizioParteSpecificaSoap11Service extends Service {

    public final static URL WSDL_LOCATION;

    public final static QName SERVICE = new QName("http://www.openspcoop2.org/core/registry/management", "AccordoServizioParteSpecificaSoap11Service");
    public final static QName AccordoServizioParteSpecificaPortSoap11 = new QName("http://www.openspcoop2.org/core/registry/management", "AccordoServizioParteSpecificaPortSoap11");
    static {
        URL url = AccordoServizioParteSpecificaSoap11Service.class.getResource("deploy/wsdl/AccordoServizioParteSpecificaSearch_PortSoap11.wsdl");
        if (url == null) {
            url = AccordoServizioParteSpecificaSoap11Service.class.getClassLoader().getResource("deploy/wsdl/AccordoServizioParteSpecificaSearch_PortSoap11.wsdl");
        } 
        if (url == null) {
            
		}
		if (url==null ){
			url = AccordoServizioParteSpecificaSoap11Service.class.getResource("/registry/AccordoServizioParteSpecificaSearch_PortSoap11.wsdl");
		}
		if (url==null ){
			url = AccordoServizioParteSpecificaSoap11Service.class.getClassLoader().getResource("/registry/AccordoServizioParteSpecificaSearch_PortSoap11.wsdl");
		}
		if (url==null ){
			java.util.logging.Logger.getLogger(AccordoServizioParteSpecificaSoap11Service.class.getName())
                .log(java.util.logging.Level.INFO, 
                     "Can not initialize the default wsdl from {0}", "deploy/wsdl/AccordoServizioParteSpecificaSearch_PortSoap11.wsdl");
        }       
        WSDL_LOCATION = url;
    }

    public AccordoServizioParteSpecificaSoap11Service(URL wsdlLocation) {
        super(wsdlLocation, AccordoServizioParteSpecificaSoap11Service.SERVICE);
    }

    public AccordoServizioParteSpecificaSoap11Service(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public AccordoServizioParteSpecificaSoap11Service() {
        super(AccordoServizioParteSpecificaSoap11Service.WSDL_LOCATION, AccordoServizioParteSpecificaSoap11Service.SERVICE);
    }
    

    /**
     *
     * @return
     *     returns AccordoServizioParteSpecifica
     */
    @WebEndpoint(name = "AccordoServizioParteSpecificaPortSoap11")
    public AccordoServizioParteSpecifica getAccordoServizioParteSpecificaPortSoap11() {
        return super.getPort(AccordoServizioParteSpecificaSoap11Service.AccordoServizioParteSpecificaPortSoap11, AccordoServizioParteSpecifica.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns AccordoServizioParteSpecifica
     */
    @WebEndpoint(name = "AccordoServizioParteSpecificaPortSoap11")
    public AccordoServizioParteSpecifica getAccordoServizioParteSpecificaPortSoap11(WebServiceFeature... features) {
        return super.getPort(AccordoServizioParteSpecificaSoap11Service.AccordoServizioParteSpecificaPortSoap11, AccordoServizioParteSpecifica.class, features);
    }

}