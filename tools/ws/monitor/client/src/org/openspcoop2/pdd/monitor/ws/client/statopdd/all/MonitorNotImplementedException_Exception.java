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

package org.openspcoop2.pdd.monitor.ws.client.statopdd.all;

import javax.xml.ws.WebFault;


/**
 * This class was generated by Apache CXF 2.7.4
 * 2014-12-01T13:15:49.881+01:00
 * Generated source version: 2.7.4
 */

@WebFault(name = "monitor-not-implemented-exception", targetNamespace = "http://www.openspcoop2.org/pdd/monitor/management")
public class MonitorNotImplementedException_Exception extends Exception {
    
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private org.openspcoop2.pdd.monitor.ws.client.statopdd.all.MonitorNotImplementedException monitorNotImplementedException;

    public MonitorNotImplementedException_Exception() {
        super();
    }
    
    public MonitorNotImplementedException_Exception(String message) {
        super(message);
    }
    
    public MonitorNotImplementedException_Exception(String message, Throwable cause) {
        super(message, cause);
    }

    public MonitorNotImplementedException_Exception(String message, org.openspcoop2.pdd.monitor.ws.client.statopdd.all.MonitorNotImplementedException monitorNotImplementedException) {
        super(message);
        this.monitorNotImplementedException = monitorNotImplementedException;
    }

    public MonitorNotImplementedException_Exception(String message, org.openspcoop2.pdd.monitor.ws.client.statopdd.all.MonitorNotImplementedException monitorNotImplementedException, Throwable cause) {
        super(message, cause);
        this.monitorNotImplementedException = monitorNotImplementedException;
    }

    public org.openspcoop2.pdd.monitor.ws.client.statopdd.all.MonitorNotImplementedException getFaultInfo() {
        return this.monitorNotImplementedException;
    }
}
