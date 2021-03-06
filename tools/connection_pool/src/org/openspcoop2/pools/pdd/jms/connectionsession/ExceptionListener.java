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



package org.openspcoop2.pools.pdd.jms.connectionsession;

import javax.jms.JMSException;

import org.slf4j.Logger;

/**
 * ExceptionListener
 *
 * @author Poli Andrea (apoli@link.it)
 * @author $Author$
 * @version $Rev$, $Date$
 */
public class ExceptionListener implements javax.jms.ExceptionListener{

	private Connection connection;
	private Logger logger;
	private String jndiName;
	
	public ExceptionListener(Connection con,Logger logger,String jndiName){
		this.connection = con;
		this.logger = logger;
		this.jndiName = jndiName;
	}
	
	@Override
	public void onException(JMSException arg0) {
		this.logger.error("Exception listener ha rilevato un errore sulla connessione ["+this.jndiName+"]",arg0);
		this.connection.setValidationExceptionListener(arg0);
	}

}
