/**
 * Opt4J is free software: you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the
 * Free Software Foundation, either version 3 of the License, or (at your
 * option) any later version.
 * 
 * Opt4J is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or
 * FITNESS FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public
 * License for more details.
 * 
 * You should have received a copy of the GNU Lesser General Public
 * License along with Opt4J. If not, see http://www.gnu.org/licenses/. 
 */

package org.opt4j.benchmark;

import org.opt4j.core.problem.Decoder;

/**
 * The {@code BinaryCopyDecoder} passes the {@code BinaryString} directly to
 * the evaluator.
 * @author lukasiewycz
 * 
 */
public class BinaryCopyDecoder implements Decoder<BinaryString, BinaryString> {

	/* (non-Javadoc)
	 * @see org.opt4j.core.problem.Decoder#decode(org.opt4j.core.Genotype)
	 */
	public BinaryString decode(BinaryString genotype) {
		return genotype;
	}
}