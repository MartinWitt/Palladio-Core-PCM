package de.uka.ipd.sdq.stoex.analyser.operations;

import de.uka.ipd.sdq.probfunction.math.IProbabilityDensityFunction;
import de.uka.ipd.sdq.probfunction.math.IProbabilityMassFunction;
import de.uka.ipd.sdq.probfunction.math.exception.FunctionsInDifferenDomainsException;
import de.uka.ipd.sdq.probfunction.math.exception.IncompatibleUnitsException;
import de.uka.ipd.sdq.probfunction.math.exception.UnknownPDFTypeException;

public class ModOperation implements TermProductOperation {

	public double compute(double left, double right) {
		return left % right;
	}

	public int compute(int left, int right) {
		return left % right;
	}

	public IProbabilityMassFunction compute(IProbabilityMassFunction left,
			double right) {
		//TODO
		//return left.mod(right);
		throw new UnsupportedOperationException();
	}

	public IProbabilityMassFunction compute(IProbabilityMassFunction left,
			IProbabilityMassFunction right) {
		//TODO
		//return left.mod(right);
		throw new UnsupportedOperationException();
	}

	public IProbabilityDensityFunction compute(IProbabilityDensityFunction leftPDF, IProbabilityDensityFunction rightPDF) throws FunctionsInDifferenDomainsException, UnknownPDFTypeException, IncompatibleUnitsException {
		throw new UnsupportedOperationException();
	}

}
