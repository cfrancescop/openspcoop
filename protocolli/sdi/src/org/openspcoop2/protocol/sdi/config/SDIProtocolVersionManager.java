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


package org.openspcoop2.protocol.sdi.config;

import org.openspcoop2.protocol.basic.config.BasicVersionManager;
import org.openspcoop2.protocol.sdk.IProtocolFactory;
import org.openspcoop2.protocol.sdk.ProtocolException;

/**
 * Classe che implementa, in base al protocollo SdI, l'interfaccia {@link org.openspcoop2.protocol.sdk.config.IProtocolVersionManager} 
 *
 * @author Poli Andrea (apoli@link.it)
 * @author $Author$
 * @version $Rev$, $Date$
 */
public class SDIProtocolVersionManager extends BasicVersionManager {
	
	protected String versione;
	public SDIProtocolVersionManager(IProtocolFactory protocolFactory,String versione) throws ProtocolException{
		super(protocolFactory);
		this.versione = versione;
	}
	
	/* *********** ECCEZIONI ******************* */

	/**
	 * Indicazione se devono essere gestite eccezioni di livello INFO
	 * 
	 * @return Indicazione se devono essere gestite eccezioni di livello INFO
	 */
	@Override
	public boolean isEccezioniLivelloInfoAbilitato(){
		return true;
	}

	
	/**
	 * Indicazione se devono essere ignorate eventuali eccezioni di livello diverso da GRAVE
	 * 
	 * @return Indicazione se devono essere ignorate eventuali eccezioni di livello diverso da GRAVE
	 */
	@Override
	public boolean isIgnoraEccezioniLivelloNonGrave(){
		return true;
	}
}