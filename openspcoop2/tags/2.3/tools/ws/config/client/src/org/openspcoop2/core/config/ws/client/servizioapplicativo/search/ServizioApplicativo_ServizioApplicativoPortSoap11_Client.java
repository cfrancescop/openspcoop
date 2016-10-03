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

package org.openspcoop2.core.config.ws.client.servizioapplicativo.search;

/**
 * Please modify this class to meet your needs
 * This class is not complete
 */

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;

/**
 * This class was generated by Apache CXF 2.7.4
 * 2015-01-26T16:36:59.746+01:00
 * Generated source version: 2.7.4
 * 
 */
public final class ServizioApplicativo_ServizioApplicativoPortSoap11_Client {

    private static final QName SERVICE_NAME = new QName("http://www.openspcoop2.org/core/config/management", "ServizioApplicativoSoap11Service");

    private ServizioApplicativo_ServizioApplicativoPortSoap11_Client() {
    }

    public static void main(String args[]) throws java.lang.Exception {
        URL wsdlURL = ServizioApplicativoSoap11Service.WSDL_LOCATION;
        if (args.length > 0 && args[0] != null && !"".equals(args[0])) { 
            File wsdlFile = new File(args[0]);
            try {
                if (wsdlFile.exists()) {
                    wsdlURL = wsdlFile.toURI().toURL();
                } else {
                    wsdlURL = new URL(args[0]);
                }
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }
        }
      
        ServizioApplicativoSoap11Service ss = new ServizioApplicativoSoap11Service(wsdlURL, ServizioApplicativo_ServizioApplicativoPortSoap11_Client.SERVICE_NAME);
        ServizioApplicativo port = ss.getServizioApplicativoPortSoap11();
	
		new org.openspcoop2.core.config.ws.client.utils.RequestContextUtils("servizioApplicativo.soap11").addRequestContextParameters((javax.xml.ws.BindingProvider)port);  
        
        {
        System.out.println("Invoking findAllIds...");
        org.openspcoop2.core.config.ws.client.servizioapplicativo.search.SearchFilterServizioApplicativo _findAllIds_filter = new org.openspcoop2.core.config.ws.client.servizioapplicativo.search.SearchFilterServizioApplicativo();
        try {
            java.util.List<org.openspcoop2.core.config.IdServizioApplicativo> _findAllIds__return = port.findAllIds(_findAllIds_filter);
            System.out.println("findAllIds.result=" + _findAllIds__return);

        } catch (ConfigNotAuthorizedException_Exception e) { 
            System.out.println("Expected exception: config-not-authorized-exception has occurred.");
            System.out.println(e.toString());
        } catch (ConfigNotImplementedException_Exception e) { 
            System.out.println("Expected exception: config-not-implemented-exception has occurred.");
            System.out.println(e.toString());
        } catch (ConfigServiceException_Exception e) { 
            System.out.println("Expected exception: config-service-exception has occurred.");
            System.out.println(e.toString());
        }
            }
        {
        System.out.println("Invoking find...");
        org.openspcoop2.core.config.ws.client.servizioapplicativo.search.SearchFilterServizioApplicativo _find_filter = new org.openspcoop2.core.config.ws.client.servizioapplicativo.search.SearchFilterServizioApplicativo();
        try {
            org.openspcoop2.core.config.ServizioApplicativo _find__return = port.find(_find_filter);
            System.out.println("find.result=" + _find__return);

        } catch (ConfigNotFoundException_Exception e) { 
            System.out.println("Expected exception: config-not-found-exception has occurred.");
            System.out.println(e.toString());
        } catch (ConfigNotAuthorizedException_Exception e) { 
            System.out.println("Expected exception: config-not-authorized-exception has occurred.");
            System.out.println(e.toString());
        } catch (ConfigNotImplementedException_Exception e) { 
            System.out.println("Expected exception: config-not-implemented-exception has occurred.");
            System.out.println(e.toString());
        } catch (ConfigMultipleResultException_Exception e) { 
            System.out.println("Expected exception: config-multiple-result-exception has occurred.");
            System.out.println(e.toString());
        } catch (ConfigServiceException_Exception e) { 
            System.out.println("Expected exception: config-service-exception has occurred.");
            System.out.println(e.toString());
        }
            }
        {
        System.out.println("Invoking get...");
        org.openspcoop2.core.config.IdServizioApplicativo _get_idServizioApplicativo = new org.openspcoop2.core.config.IdServizioApplicativo();
        try {
            org.openspcoop2.core.config.ServizioApplicativo _get__return = port.get(_get_idServizioApplicativo);
            System.out.println("get.result=" + _get__return);

        } catch (ConfigNotFoundException_Exception e) { 
            System.out.println("Expected exception: config-not-found-exception has occurred.");
            System.out.println(e.toString());
        } catch (ConfigNotAuthorizedException_Exception e) { 
            System.out.println("Expected exception: config-not-authorized-exception has occurred.");
            System.out.println(e.toString());
        } catch (ConfigNotImplementedException_Exception e) { 
            System.out.println("Expected exception: config-not-implemented-exception has occurred.");
            System.out.println(e.toString());
        } catch (ConfigMultipleResultException_Exception e) { 
            System.out.println("Expected exception: config-multiple-result-exception has occurred.");
            System.out.println(e.toString());
        } catch (ConfigServiceException_Exception e) { 
            System.out.println("Expected exception: config-service-exception has occurred.");
            System.out.println(e.toString());
        }
            }
        {
        System.out.println("Invoking findAll...");
        org.openspcoop2.core.config.ws.client.servizioapplicativo.search.SearchFilterServizioApplicativo _findAll_filter = new org.openspcoop2.core.config.ws.client.servizioapplicativo.search.SearchFilterServizioApplicativo();
        try {
            java.util.List<org.openspcoop2.core.config.ServizioApplicativo> _findAll__return = port.findAll(_findAll_filter);
            System.out.println("findAll.result=" + _findAll__return);

        } catch (ConfigNotAuthorizedException_Exception e) { 
            System.out.println("Expected exception: config-not-authorized-exception has occurred.");
            System.out.println(e.toString());
        } catch (ConfigNotImplementedException_Exception e) { 
            System.out.println("Expected exception: config-not-implemented-exception has occurred.");
            System.out.println(e.toString());
        } catch (ConfigServiceException_Exception e) { 
            System.out.println("Expected exception: config-service-exception has occurred.");
            System.out.println(e.toString());
        }
            }
        {
        System.out.println("Invoking inUse...");
        org.openspcoop2.core.config.IdServizioApplicativo _inUse_idServizioApplicativo = new org.openspcoop2.core.config.IdServizioApplicativo();
        try {
            org.openspcoop2.core.config.ws.client.servizioapplicativo.search.UseInfo _inUse__return = port.inUse(_inUse_idServizioApplicativo);
            System.out.println("inUse.result=" + _inUse__return);

        } catch (ConfigNotFoundException_Exception e) { 
            System.out.println("Expected exception: config-not-found-exception has occurred.");
            System.out.println(e.toString());
        } catch (ConfigNotAuthorizedException_Exception e) { 
            System.out.println("Expected exception: config-not-authorized-exception has occurred.");
            System.out.println(e.toString());
        } catch (ConfigNotImplementedException_Exception e) { 
            System.out.println("Expected exception: config-not-implemented-exception has occurred.");
            System.out.println(e.toString());
        } catch (ConfigServiceException_Exception e) { 
            System.out.println("Expected exception: config-service-exception has occurred.");
            System.out.println(e.toString());
        }
            }
        {
        System.out.println("Invoking exists...");
        org.openspcoop2.core.config.IdServizioApplicativo _exists_idServizioApplicativo = new org.openspcoop2.core.config.IdServizioApplicativo();
        try {
            boolean _exists__return = port.exists(_exists_idServizioApplicativo);
            System.out.println("exists.result=" + _exists__return);

        } catch (ConfigNotAuthorizedException_Exception e) { 
            System.out.println("Expected exception: config-not-authorized-exception has occurred.");
            System.out.println(e.toString());
        } catch (ConfigNotImplementedException_Exception e) { 
            System.out.println("Expected exception: config-not-implemented-exception has occurred.");
            System.out.println(e.toString());
        } catch (ConfigMultipleResultException_Exception e) { 
            System.out.println("Expected exception: config-multiple-result-exception has occurred.");
            System.out.println(e.toString());
        } catch (ConfigServiceException_Exception e) { 
            System.out.println("Expected exception: config-service-exception has occurred.");
            System.out.println(e.toString());
        }
            }
        {
        System.out.println("Invoking count...");
        org.openspcoop2.core.config.ws.client.servizioapplicativo.search.SearchFilterServizioApplicativo _count_filter = new org.openspcoop2.core.config.ws.client.servizioapplicativo.search.SearchFilterServizioApplicativo();
        try {
            long _count__return = port.count(_count_filter);
            System.out.println("count.result=" + _count__return);

        } catch (ConfigNotAuthorizedException_Exception e) { 
            System.out.println("Expected exception: config-not-authorized-exception has occurred.");
            System.out.println(e.toString());
        } catch (ConfigNotImplementedException_Exception e) { 
            System.out.println("Expected exception: config-not-implemented-exception has occurred.");
            System.out.println(e.toString());
        } catch (ConfigServiceException_Exception e) { 
            System.out.println("Expected exception: config-service-exception has occurred.");
            System.out.println(e.toString());
        }
            }

        System.exit(0);
    }

}
