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
package org.openspcoop2.example.pdd.client.sdi.ricezione_fatture;

import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceFeature;
import javax.xml.ws.Service;

/**
 * This class was generated by Apache CXF 2.7.4
 * 2014-10-07T14:32:46.387+02:00
 * Generated source version: 2.7.4
 *
 * @author Andrea Poli (apoli@link.it)
 * @author $Author$
 * @version $Rev$, $Date$
 */
@WebServiceClient(name = "RicezioneFatture_service", 
                  wsdlLocation = "RicezioneFatture_v1.0.wsdl",
                  targetNamespace = "http://www.fatturapa.gov.it/sdi/ws/ricezione/v1.0") 
public class RicezioneFattureService extends Service {

    public final static URL WSDL_LOCATION;

    public final static QName SERVICE = new QName("http://www.fatturapa.gov.it/sdi/ws/ricezione/v1.0", "RicezioneFatture_service");
    public final static QName RicezioneFatturePort = new QName("http://www.fatturapa.gov.it/sdi/ws/ricezione/v1.0", "RicezioneFatture_port");
    static {
        URL url = RicezioneFattureService.class.getResource("RicezioneFatture_v1.0.wsdl");
        if (url == null) {
            url = RicezioneFattureService.class.getClassLoader().getResource("RicezioneFatture_v1.0.wsdl");
        } 
        if (url == null) {
        	System.out.println("Can not initialize the default wsdl from RicezioneFatture_v1.0.wsdl");
        }       
        WSDL_LOCATION = url;
    }

    public RicezioneFattureService(URL wsdlLocation) {
        super(wsdlLocation, RicezioneFattureService.SERVICE);
    }

    public RicezioneFattureService(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public RicezioneFattureService() {
        super(RicezioneFattureService.WSDL_LOCATION, RicezioneFattureService.SERVICE);
    }
    
//    //This constructor requires JAX-WS API 2.2. You will need to endorse the 2.2
//    //API jar or re-run wsdl2java with "-frontend jaxws21" to generate JAX-WS 2.1
//    //compliant code instead.
//    public RicezioneFattureService(WebServiceFeature ... features) {
//        super(RicezioneFattureService.WSDL_LOCATION, RicezioneFattureService.SERVICE, features);
//    }
//
//    //This constructor requires JAX-WS API 2.2. You will need to endorse the 2.2
//    //API jar or re-run wsdl2java with "-frontend jaxws21" to generate JAX-WS 2.1
//    //compliant code instead.
//    public RicezioneFattureService(URL wsdlLocation, WebServiceFeature ... features) {
//        super(wsdlLocation, RicezioneFattureService.SERVICE, features);
//    }
//
//    //This constructor requires JAX-WS API 2.2. You will need to endorse the 2.2
//    //API jar or re-run wsdl2java with "-frontend jaxws21" to generate JAX-WS 2.1
//    //compliant code instead.
//    public RicezioneFattureService(URL wsdlLocation, QName serviceName, WebServiceFeature ... features) {
//        super(wsdlLocation, serviceName, features);
//    }

    /**
     *
     * @return
     *     returns RicezioneFatture
     */
    @WebEndpoint(name = "RicezioneFatture_port")
    public RicezioneFatture getRicezioneFatturePort() {
        return super.getPort(RicezioneFattureService.RicezioneFatturePort, RicezioneFatture.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns RicezioneFatture
     */
    @WebEndpoint(name = "RicezioneFatture_port")
    public RicezioneFatture getRicezioneFatturePort(WebServiceFeature... features) {
        return super.getPort(RicezioneFattureService.RicezioneFatturePort, RicezioneFatture.class, features);
    }

}
