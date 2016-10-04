/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
/*
 * Modificato per supportare le seguenti funzionalita':
 * - Generazione ID all'interno delle interfacce di OpenSPCoop2
 * 
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
package org.openspcoop2.utils.id.apache;

import org.openspcoop2.utils.id.apache.serial.MaxReachedException;

/**
 * Abstract superclass for StringIdentifierGenerator implementations.
 *
 * @author Commons-Id team
 * @version $Id: AbstractStringIdentifierGenerator.java 480488 2006-11-29 08:57:26Z bayard $
 */
/**
 * OpenSPCoop2
 *
 * @author $Author$
 * @version $Rev$, $Date$
 */
public abstract class AbstractStringIdentifierGenerator implements StringIdentifierGenerator {

    /**
     * Maximum length for a numeric string representing a long value.
     */
    protected static final int MAX_LONG_NUMERIC_VALUE_LENGTH =
    Long.toString(Long.MIN_VALUE).length();

    /**
     * Number of alphanumeric characters.
     */
    protected static final int ALPHA_NUMERIC_CHARSET_SIZE = 36;

    /**
     * Maximum length for an alphanumeric string representing a long value.
     */
    protected static final int MAX_LONG_ALPHANUMERIC_VALUE_LENGTH =
    Long.toString(Long.MAX_VALUE, ALPHA_NUMERIC_CHARSET_SIZE).length();

    /**
     * Maximum length for a numeric string representing an integer value.
     */
    protected static final int MAX_INT_NUMERIC_VALUE_LENGTH =
    Integer.toString(Integer.MIN_VALUE).length();

    /**
     * Maximum length for an alphanumeric string representing an integer value.
     */
    protected static final int MAX_INT_ALPHANUMERIC_VALUE_LENGTH =
    Integer.toString(Integer.MAX_VALUE, ALPHA_NUMERIC_CHARSET_SIZE).length();

    /**
     * Default size of an alphanumeric identifier.
     */
    protected static final int DEFAULT_ALPHANUMERIC_IDENTIFIER_SIZE = 15;

    /**
     * Constructor.
     */
    protected AbstractStringIdentifierGenerator() {
        super();
    }

    @Override
	public abstract String nextStringIdentifier() throws MaxReachedException;

    /**
     * Returns the maximum length (number or characters) for an identifier
     * from this sequence.
     * 
     * <p>The default implementation returns {@link #INFINITE_MAX_LENGTH}. Implementations
     * with bounded length identifiers should override this method to
     * return the maximum length of a generated identifier.</p>
     *
     * @return {@inheritDoc}
     */
    @Override
	public long maxLength() {
        return INFINITE_MAX_LENGTH;
    }

    /**
     * Returns the minimum length (number of characters) for an identifier
     * from this sequence.
     *
     * <p>The default implementation returns 0. Implementations
     * with identifiers having a postive minimum length should override this
     * method to return the maximum length of a generated identifier.</p>
     *
     * @return {@inheritDoc}
     */
    @Override
	public long minLength() {
        return 0;
    }

    @Override
	public Object nextIdentifier() throws MaxReachedException {
        return nextStringIdentifier();
    }
}