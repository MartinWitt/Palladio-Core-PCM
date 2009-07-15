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

import org.opt4j.config.annotations.Info;
import org.opt4j.config.annotations.Required;
import org.opt4j.start.Constant;
import org.opt4j.start.Opt4JModule;

/**
 * The basic {@code MutateModule}.
 * 
 * @author lukasiewycz
 * 
 */
@Info("Setting for the basic mutate operators for genotype manipulation.")
public class BasicMutateModule extends Opt4JModule implements MutateModule {

	@Info("The type of mutation rate")
	protected MutationRateType mutationRateType = MutationRateType.ADAPTIVE;

	@Info("The type of the mutate operator for the Permutation genotype")
	protected PermutationType permutationType = PermutationType.MIXED;

	@Info("The type of the mutate operator for the Double genotype")
	protected DoubleType doubleType = DoubleType.POLYNOMIAL;

	@Required(property = "doubleType", elements = { "POLYNOMIAL" })
	@Constant(value = "eta", namespace = MutateDoublePolynomial.class)
	protected double eta = 20;

	@Required(property = "doubleType", elements = { "GAUSS" })
	@Constant(value = "sigma", namespace = MutateDoubleGauss.class)
	protected double sigma = 0.1;

	@Required(property = "mutationRateType", elements = { "CONSTANT" })
	@Constant(value = "rate", namespace = ConstantMutationRate.class)
	protected double mutationRate = 0.01;

	/**
	 * The type of the used mutation rate.
	 * 
	 * @author lukasiewycz
	 * 
	 */
	public enum MutationRateType {
		/**
		 * Use a constant mutation rate.
		 */
		CONSTANT,
		/**
		 * Use a variable (adaptive) mutation rate.
		 */
		ADAPTIVE;
	}

	/**
	 * Type of {@code Mutate} operator for the {@code DoubleGenotype}.
	 * 
	 * @author lukasiewycz
	 * 
	 */
	public enum DoubleType {
		/**
		 * Use a constant mutation rate.
		 */
		GAUSS,
		/**
		 * Use a variable (adaptive) mutation rate.
		 */
		POLYNOMIAL;
	}

	/**
	 * Type of {@code Mutate} operator for the {@code PermutationGenotype}.
	 * 
	 * @author lukasiewycz
	 * 
	 */
	public enum PermutationType {
		/**
		 * Use the {@link MutatePermutationMixed}.
		 */
		MIXED,
		/**
		 * Use the {@link MutatePermutationSwap}.
		 */
		SWAP,
		/**
		 * Use the {@link MutatePermutationInsert}.
		 */
		INSERT,
		/**
		 * Use the {@link MutatePermutationRevert}.
		 */
		REVERT;
	}

	/**
	 * Constructs a {@code BasicMutateModule}.
	 */
	public BasicMutateModule() {
		super();
	}

	/**
	 * Returns the type of mutation rate.
	 * 
	 * @return the type of mutation rate
	 */
	public MutationRateType getMutationRateType() {
		return mutationRateType;
	}

	/**
	 * Sets the type of mutation rate.
	 * 
	 * @param mutationRateType
	 *            the type of mutation rate
	 */
	public void setMutationRateType(MutationRateType mutationRateType) {
		this.mutationRateType = mutationRateType;
	}

	/**
	 * Returns the mutation rate as a double value.
	 * 
	 * @return the mutation rate
	 */
	public double getMutationRate() {
		return mutationRate;
	}

	/**
	 * Sets the mutation rate.
	 * 
	 * @param mutationRate
	 *            the mutation rate
	 */
	public void setMutationRate(double mutationRate) {
		this.mutationRate = mutationRate;
	}

	/**
	 * Returns the permutation mode.
	 * 
	 * @return the permutation mode
	 */
	public PermutationType getPermutationType() {
		return permutationType;
	}

	/**
	 * Sets the permutation mode.
	 * 
	 * @param permutationMode
	 *            the permutation mode
	 */
	public void setPermutationType(PermutationType permutationMode) {
		this.permutationType = permutationMode;
	}

	/**
	 * Returns the double type.
	 * 
	 * @return the doubleType
	 */
	public DoubleType getDoubleType() {
		return doubleType;
	}

	/**
	 * Sets the double type.
	 * 
	 * @param doubleType
	 *            the doubleType to set
	 */
	public void setDoubleType(DoubleType doubleType) {
		this.doubleType = doubleType;
	}

	/**
	 * Returns the eta.
	 * 
	 * @return the eta
	 */
	public double getEta() {
		return eta;
	}

	/**
	 * Sets the eta.
	 * 
	 * @param eta
	 *            the eta to set
	 */
	public void setEta(double eta) {
		this.eta = eta;
	}

	/**
	 * Returns the sigma value.
	 * 
	 * @return the sigma
	 */

	public double getSigma() {
		return sigma;
	}

	/**
	 * Sets the sigma value.
	 * 
	 * @param sigma
	 *            the sigma to set
	 */
	public void setSigma(double sigma) {
		this.sigma = sigma;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.opt4j.start.Opt4JModule#config()
	 */
	@Override
	public void config() {
		switch (mutationRateType) {
		case ADAPTIVE:
			bind(MutationRate.class).to(AdaptiveMutationRate.class).in(
					SINGLETON);
			break;
		case CONSTANT:
			bind(MutationRate.class).to(ConstantMutationRate.class).in(
					SINGLETON);
		}

		Class<? extends MutatePermutation> permutation = MutatePermutationMixed.class;

		switch (permutationType) {
		case MIXED:
			permutation = MutatePermutationMixed.class;
			break;
		case SWAP:
			permutation = MutatePermutationSwap.class;
			break;
		case INSERT:
			permutation = MutatePermutationInsert.class;
			break;
		case REVERT:
			permutation = MutatePermutationRevert.class;
			break;
		}
		bind(MutatePermutation.class).to(permutation).in(SINGLETON);

		switch (doubleType) {
		case GAUSS:
			bind(MutateDouble.class).to(MutateDoubleGauss.class).in(SINGLETON);
			break;
		case POLYNOMIAL:
			bind(MutateDouble.class).to(MutateDoublePolynomial.class).in(
					SINGLETON);
			break;
		}
	}
}
