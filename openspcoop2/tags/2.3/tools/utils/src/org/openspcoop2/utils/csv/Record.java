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

package org.openspcoop2.utils.csv;
import org.apache.commons.csv.CSVRecord;

/**
 * Record
 *
 * @author Andrea Poli (apoli@link.it)
 * @author $Author$
 * @version $Rev$, $Date$
 */
public class Record {

	private long line;
	private MapResult map;
	private String comment;
	private CSVRecord record;
	
	public long getCsvLine() {
		return this.line;
	}
	public void setCsvLine(long line) {
		this.line = line;
	}
	public MapResult getMap() {
		return this.map;
	}
	public void setMap(MapResult map) {
		this.map = map;
	}
	public String getComment() {
		return this.comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	public CSVRecord getRecord() {
		return this.record;
	}
	public void setRecord(CSVRecord record) {
		this.record = record;
	}
	
}