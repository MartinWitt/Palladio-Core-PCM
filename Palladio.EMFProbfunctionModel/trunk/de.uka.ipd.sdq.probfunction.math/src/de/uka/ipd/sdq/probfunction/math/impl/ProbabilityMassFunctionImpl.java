/**
 * 
 */
package de.uka.ipd.sdq.probfunction.math.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import de.uka.ipd.sdq.probfunction.math.IProbabilityMassFunction;
import de.uka.ipd.sdq.probfunction.math.ISample;
import de.uka.ipd.sdq.probfunction.math.exception.DifferentDomainsException;
import de.uka.ipd.sdq.probfunction.math.exception.DomainNotNumbersException;
import de.uka.ipd.sdq.probfunction.math.exception.ProbabilitySumNotOneException;
import de.uka.ipd.sdq.probfunction.math.exception.UnorderedDomainException;
import de.uka.ipd.sdq.probfunction.math.util.MathTools;

/**
 * @author Ihssane
 * 
 */
public class ProbabilityMassFunctionImpl extends ProbabilityFunctionImpl
		implements
			IProbabilityMassFunction {

	private List<ISample> samples;

	private enum Operation {
		ADD, SUB, MULT, DIV
	}

	protected ProbabilityMassFunctionImpl() {
		samples = new ArrayList<ISample>();
	}

	protected ProbabilityMassFunctionImpl(List<ISample> samples) {
		this.samples = samples;
	}
	private static IProbabilityMassFunction performOperation(Operation op,
			IProbabilityMassFunction pmf1, IProbabilityMassFunction pmf2) {
		List<ISample> resultList = new ArrayList<ISample>();

		Iterator<ISample> iterator = pmf2.getSamples().iterator();
		for (ISample s1 : pmf1.getSamples()) {
			ISample s2 = iterator.next();
			double result;
			switch (op) {
				case ADD :
					result = s1.getProbability() + s2.getProbability();
					break;
				case SUB :
					result = s1.getProbability() - s2.getProbability();
					break;
				case MULT :
					result = s1.getProbability() * s2.getProbability();
					break;
				case DIV :
					result = s1.getProbability() / s2.getProbability();
					break;
				default :
					result = 0.0;
					break;
			}
			resultList.add(pfFactory.createSample(s1.getValue(), result));
		}
		return pfFactory.createProbabilityMassFunction(resultList, false);
	}

	public IProbabilityMassFunction add(IProbabilityMassFunction pmf)
			throws DifferentDomainsException {
		if (!haveSameDomain(this.samples, pmf.getSamples()))
			throw new DifferentDomainsException();

		return performOperation(Operation.ADD, this, pmf);
	}

	public IProbabilityMassFunction mult(IProbabilityMassFunction pmf)
			throws DifferentDomainsException {
		if (!haveSameDomain(this.samples, pmf.getSamples()))
			throw new DifferentDomainsException();

		return performOperation(Operation.MULT, this, pmf);
	}

	public IProbabilityMassFunction scale(double scalar) {

		List<ISample> newList = new ArrayList<ISample>();
		for (ISample sample : samples)
			newList.add(pfFactory.createSample(sample.getValue(), sample
					.getProbability()
					* scalar));

		return pfFactory.createProbabilityMassFunction(newList, false);
	}

	public IProbabilityMassFunction div(IProbabilityMassFunction pmf)
			throws DifferentDomainsException {
		if (!haveSameDomain(this.samples, pmf.getSamples()))
			throw new DifferentDomainsException();

		return performOperation(Operation.DIV, this, pmf);
	}

	public IProbabilityMassFunction sub(IProbabilityMassFunction pmf)
			throws DifferentDomainsException {
		if (!haveSameDomain(this.samples, pmf.getSamples()))
			throw new DifferentDomainsException();

		return performOperation(Operation.SUB, this, pmf);
	}

	@SuppressWarnings("unchecked")
	private boolean haveSameDomain(List<ISample> values1, List<ISample> values2) {
		if (values1.size() != values2.size())
			return false;
		if (values1.size() == 0 && values2.size() == 0)
			return true;
		if (!(values1.get(0).getValue().getClass().isInstance(values2.get(0)
				.getValue())))
			return false;
		if (!(values1.get(0).getValue() instanceof Comparable))
			return false;

		Collections.sort(values1, MathTools.getSampleComparator());
		Collections.sort(values2, MathTools.getSampleComparator());

		boolean result = true;
		Iterator iterator = values2.iterator();
		for (Object o : values1)
			if (!o.equals(iterator.next()))
				result = false;

		return result;
	}

	public IProbabilityMassFunction getFourierTramsform() {
		// TODO Auto-generated method stub
		return null;
	}

	public IProbabilityMassFunction getInverseFourierTransform() {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * @return the samples
	 */
	public List<ISample> getSamples() {
		return new ArrayList<ISample>(samples);
	}

	/**
	 * @param samples
	 *            the samples to set
	 * @throws ProbabilitySumNotOneException
	 */
	public void setSamples(List<ISample> samples)
			throws ProbabilitySumNotOneException {
		if (!MathTools.equalsDouble(MathTools.sumOfSamples(samples), 1.0))
			throw new ProbabilitySumNotOneException();
		if (samples.size() > 1
				&& samples.get(0).getValue() instanceof Comparable)
			Collections.sort(samples, MathTools.getSampleComparator());
		this.samples = samples;
	}

	public double getArithmeticMeanValue() throws DomainNotNumbersException {
		return MathTools.sumOfSamples(samples) / samples.size();
	}

	public Object getMedian() throws UnorderedDomainException {
		return getPercentile(50);
	}

	public Object getPercentile(int p) throws IndexOutOfBoundsException, UnorderedDomainException {
		if (!hasOrderedDomain())
			throw new UnorderedDomainException();
		if (p < 0 || p > 100)
			throw new IndexOutOfBoundsException();

		int rank = (int) Math.round((p * (samples.size() + 1.0)) / 100.0);
		return samples.get(rank);
	}

	public boolean hasOrderedDomain() {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean isInFrequencyDomain() {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean isInTimeDomain() {
		// TODO Auto-generated method stub
		return false;
	}

	public Object drawSample() {
		Object result = 0.0;
		List<Double> intervals = MathTools
				.computeIntervalsOfProb(getProbabilities());

		double random = Math.random();
		for (int j = 0; j < intervals.size(); j++)
			if (random < intervals.get(j)) {
				result = samples.get(j).getValue();
				break;
			}
		return result;
	}

	private List<Double> getProbabilities() {
		List<Double> prob = new ArrayList<Double>();
		for (ISample s : samples)
			prob.add(s.getProbability());
		return prob;
	}

}
