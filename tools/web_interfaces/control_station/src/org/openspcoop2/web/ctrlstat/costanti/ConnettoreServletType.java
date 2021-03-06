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

package org.openspcoop2.web.ctrlstat.costanti;

/**     
 * ConnettoreServletType
 *
 * @author Poli Andrea (poli@link.it)
 * @author $Author$
 * @version $Rev$, $Date$
 */
public enum ConnettoreServletType {

	SOGGETTO, 
	SERVIZIO_APPLICATIVO_ADD,
	SERVIZIO_APPLICATIVO_CHANGE,
	SERVIZIO_APPLICATIVO_INVOCAZIONE_SERVIZIO, 
	SERVIZIO_APPLICATIVO_RISPOSTA_ASINCRONA,
	ACCORDO_SERVIZIO_PARTE_SPECIFICA_ADD, 
	ACCORDO_SERVIZIO_PARTE_SPECIFICA_CHANGE, 
	FRUIZIONE_ACCORDO_SERVIZIO_PARTE_SPECIFICA_ADD,
	FRUIZIONE_ACCORDO_SERVIZIO_PARTE_SPECIFICA_CHANGE,
	WIZARD_CONFIG,
	WIZARD_REGISTRY,
	
}
