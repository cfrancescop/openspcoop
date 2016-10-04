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

package org.openspcoop2.example.pdd.server.sdi.ricevi_notifica;

import java.io.FileInputStream;

import javax.xml.ws.Endpoint;

/**
 * This class was generated by Apache CXF 2.7.4
 * 2014-10-09T15:59:57.743+02:00
 * Generated source version: 2.7.4
 * 
 * @author Andrea Poli (apoli@link.it)
 * @author $Author$
 * @version $Rev$, $Date$
 */
 
public class SdIRiceviNotifica_SdIRiceviNotificaPort_Server{

    protected SdIRiceviNotifica_SdIRiceviNotificaPort_Server() throws java.lang.Exception {
        System.out.println("Starting Server");
        Object implementor = new SdIRiceviNotificaImpl();
        
    	java.util.Properties reader = new java.util.Properties();
		try{  
			reader.load(new FileInputStream("Server.properties")); 
		}catch(java.io.IOException e) {
			System.err.println("ERROR : "+e.toString());
			return;
		}
		
		String address = reader.getProperty("endpoint");
		if(address==null){
			throw new Exception("Property [endpoint] not definded");
		}
		else{
			address = address.trim();
		}
		
		String mtom = reader.getProperty("mtom");
		boolean isMTOMEnabled = false;
		if(mtom==null){
			throw new Exception("Property [mtom] not definded");
		}
		else{
			mtom = mtom.trim();
			isMTOMEnabled = Boolean.parseBoolean(mtom);
		}
		
		address = address + "?properties.mtom-enabled="+isMTOMEnabled;
        
        Endpoint.publish(address, implementor);
    }
    
    public static void main(String args[]) throws java.lang.Exception { 
        new SdIRiceviNotifica_SdIRiceviNotificaPort_Server();
        System.out.println("Server ready..."); 
        
        Thread.sleep(5 * 60 * 1000); 
        System.out.println("Server exiting");
        System.exit(0);
    }
}
