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
package org.openspcoop2.generic_project.web.impl.jsf1.input.impl;

import org.openspcoop2.generic_project.web.factory.Costanti;
import org.openspcoop2.generic_project.web.input.FieldType;
import org.openspcoop2.generic_project.web.input.SingleListBox;

/***
 * 
 * SingleListBoxImpl
 * 
 * 
 * @author Pintori Giuliano (pintori@link.it)
 * @author $Author$
 * @version $Rev$, $Date$ 
 * 
 */
public class SingleListBoxImpl extends SelectListImpl implements SingleListBox{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int numeroRigheDaVisualizzare = Costanti.LISTBOX_NUMERO_RIGHE_DA_VISUALIZZARE;
	
	public SingleListBoxImpl(){
		super();
		
		setType(FieldType.SINGLE_LISTBOX); 
		
	}

	@Override
	public int getNumeroRigheDaVisualizzare() {
		return this.numeroRigheDaVisualizzare;
	}

	@Override
	public void setNumeroRigheDaVisualizzare(int numeroRigheDaVisualizzare) {
		this.numeroRigheDaVisualizzare = numeroRigheDaVisualizzare;
	}

}
