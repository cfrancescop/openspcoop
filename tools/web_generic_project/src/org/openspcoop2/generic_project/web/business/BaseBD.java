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
package org.openspcoop2.generic_project.web.business;

import java.util.List;

import org.openspcoop2.generic_project.web.form.SearchForm;


/**
 * BaseBD Definisce i metodi da implementare per agganciare il livello dao/ejb.
 * 
 * @param <T> Tipo Oggetto 
 * @param <K> Tipo chiave primaria Oggetto
 * 
 * @author Pintori Giuliano (pintori@link.it)
 * @author $Author$
 * @version $Rev$, $Date$
 */
public abstract class BaseBD<T,K> {

	public BaseBD() {
	}

	public abstract <S extends SearchForm> int count(S form)throws Exception;

	public abstract <S extends SearchForm> List<T> findAll(S form, Integer start, Integer limit)throws Exception;

	public abstract void store(T dto) throws Exception;

	public abstract T findById(K key) throws Exception;
}
