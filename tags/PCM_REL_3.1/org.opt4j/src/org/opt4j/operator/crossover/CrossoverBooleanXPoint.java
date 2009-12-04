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

package org.opt4j.operator.crossover;

import java.util.Random;

import org.opt4j.genotype.BooleanGenotype;
import org.opt4j.start.Constant;

import com.google.inject.Inject;

/**
 * Crossover for the {@link BooleanGenotype}. The crossover is done on {@code x}
 * points.
 * 
 * @author lukasiewycz
 * 
 */
public class CrossoverBooleanXPoint extends CrossoverListXPoint implements
		CrossoverBoolean {

	/**
	 * Constructs a {@code CrossoverBooleanXPoint}.
	 * 
	 * @param x
	 *            the number of crossover points
	 * @param random
	 *            the random number generator
	 */
	@Inject
	public CrossoverBooleanXPoint(
			@Constant(value = "x", namespace = CrossoverBooleanXPoint.class) int x,
			Random random) {
		super(x, random);
	}

}