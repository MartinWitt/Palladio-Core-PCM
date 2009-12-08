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

package org.opt4j.operator.mutate;

import java.util.Collections;
import java.util.Random;

import org.opt4j.core.Genotype;
import org.opt4j.genotype.PermutationGenotype;

import com.google.inject.Inject;
import com.google.inject.Singleton;

/**
 * <p>
 * Mutate operator for the {@link PermutationGenotype}. With a given mutation
 * rate two elements are selected and swapped.
 * </p>
 * 
 * <p>
 * Given a permutation {@code 1 2 3 4 5 6 7 8}, this might result in
 * {@code 1 2 7 4 5 6 3 8}.
 * </p>
 * 
 * @author lukasiewycz
 * 
 */
@Singleton
public class MutatePermutationSwap implements MutatePermutation {

	protected final Random random;

	protected final MutationRate mutationRate;

	/**
	 * Constructs a new {@code MutatePermutation} with the given mutation rate.
	 * 
	 * @param mutationRate
	 *            the {@code MutationRate} for the mutation operation
	 * @param random
	 *            the random number generator
	 */
	@Inject
	public MutatePermutationSwap(final MutationRate mutationRate, Random random) {
		this.mutationRate = mutationRate;
		this.random = random;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.opt4j.operator.mutate.Mutate#mutate(org.opt4j.core.Genotype)
	 */
	public void mutate(Genotype genotype) {
		PermutationGenotype<?> permutation = (PermutationGenotype<?>) genotype;

		int size = permutation.size();

		if (size > 1) {
			for (int i = 0; i < size; i++) {
				if (random.nextDouble() < mutationRate.get()) {
					int j;
					do {
						j = random.nextInt(size);
					} while (j == i);

					Collections.swap(permutation, i, j);
				}
			}
		}
	}

}