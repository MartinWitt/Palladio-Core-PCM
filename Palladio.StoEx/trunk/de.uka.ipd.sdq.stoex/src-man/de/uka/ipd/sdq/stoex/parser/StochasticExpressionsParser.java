// $ANTLR : "stoex.g" -> "StochasticExpressionsParser.java"$
  
	package de.uka.ipd.sdq.stoex.parser;
	import de.uka.ipd.sdq.stoex.*;
	import de.uka.ipd.sdq.probfunction.*;
	import java.util.ArrayList;

import antlr.TokenBuffer;
import antlr.TokenStreamException;
import antlr.TokenStreamIOException;
import antlr.ANTLRException;
import antlr.LLkParser;
import antlr.Token;
import antlr.TokenStream;
import antlr.RecognitionException;
import antlr.NoViableAltException;
import antlr.MismatchedTokenException;
import antlr.SemanticException;
import antlr.ParserSharedInputState;
import antlr.collections.impl.BitSet;
@SuppressWarnings({"unused"})
public class StochasticExpressionsParser extends antlr.LLkParser       implements StochasticExpressionsParserTokenTypes
 {

protected StochasticExpressionsParser(TokenBuffer tokenBuf, int k) {
  super(tokenBuf,k);
  tokenNames = _tokenNames;
}

public StochasticExpressionsParser(TokenBuffer tokenBuf) {
  this(tokenBuf,2);
}

protected StochasticExpressionsParser(TokenStream lexer, int k) {
  super(lexer,k);
  tokenNames = _tokenNames;
}

public StochasticExpressionsParser(TokenStream lexer) {
  this(lexer,2);
}

public StochasticExpressionsParser(ParserSharedInputState state) {
  super(state,2);
  tokenNames = _tokenNames;
}

	public final Expression  expression() throws RecognitionException, TokenStreamException {
		Expression exp;
		
		exp = null;
		
		Comparison c;
		c=compareExpr();
		exp = c;
		return exp;
	}
	
	public final Comparison  compareExpr() throws RecognitionException, TokenStreamException {
		Comparison comp;
		
		comp = null;
		
		Term t1 = null, t2 = null;
		t1=sumExpr();
		comp = t1;
		{
		switch ( LA(1)) {
		case GREATER:
		case LESS:
		case EQUAL:
		case NOTEQUAL:
		case GREATEREQUAL:
		case LESSEQUAL:
		{
			CompareExpression compExp = StoexFactory.eINSTANCE.createCompareExpression();
			{
			switch ( LA(1)) {
			case GREATER:
			{
				match(GREATER);
				compExp.setOperation(CompareOperations.GREATER);
				break;
			}
			case LESS:
			{
				match(LESS);
				compExp.setOperation(CompareOperations.LESS);
				break;
			}
			case EQUAL:
			{
				match(EQUAL);
				compExp.setOperation(CompareOperations.EQUALS);
				break;
			}
			case NOTEQUAL:
			{
				match(NOTEQUAL);
				compExp.setOperation(CompareOperations.NOTEQUAL);
				break;
			}
			case GREATEREQUAL:
			{
				match(GREATEREQUAL);
				compExp.setOperation(CompareOperations.GREATEREQUAL);
				break;
			}
			case LESSEQUAL:
			{
				match(LESSEQUAL);
				compExp.setOperation(CompareOperations.LESSEQUAL);
				break;
			}
			default:
			{
				throw new NoViableAltException(LT(1), getFilename());
			}
			}
			}
			t2=sumExpr();
			compExp.setLeft(t1); compExp.setRight(t2); comp=compExp;
			break;
		}
		case EOF:
		case RPAREN:
		{
			break;
		}
		default:
		{
			throw new NoViableAltException(LT(1), getFilename());
		}
		}
		}
		return comp;
	}
	
	public final Term  sumExpr() throws RecognitionException, TokenStreamException {
		Term t;
		
		t = null;
		
		Product p1 = null, p2 = null;
		p1=prodExpr();
		t = p1;
		{
		_loop678:
		do {
			if ((LA(1)==PLUS||LA(1)==MINUS)) {
				TermExpression termExp = StoexFactory.eINSTANCE.createTermExpression();
				{
				switch ( LA(1)) {
				case PLUS:
				{
					match(PLUS);
					termExp.setOperation(TermOperations.ADD);
					break;
				}
				case MINUS:
				{
					match(MINUS);
					termExp.setOperation(TermOperations.SUB);
					break;
				}
				default:
				{
					throw new NoViableAltException(LT(1), getFilename());
				}
				}
				}
				p2=prodExpr();
				termExp.setLeft(t); termExp.setRight(p2); t = termExp;
			}
			else {
				break _loop678;
			}
			
		} while (true);
		}
		return t;
	}
	
	public final Product  prodExpr() throws RecognitionException, TokenStreamException {
		Product p;
		
		p = null;
		
		Power pw1 = null, pw2 = null;
		pw1=powExpr();
		p = pw1;
		{
		_loop682:
		do {
			if (((LA(1) >= MUL && LA(1) <= MOD))) {
				ProductExpression prodExp = StoexFactory.eINSTANCE.createProductExpression();
				{
				switch ( LA(1)) {
				case MUL:
				{
					match(MUL);
					prodExp.setOperation(ProductOperations.MULT);
					break;
				}
				case DIV:
				{
					match(DIV);
					prodExp.setOperation(ProductOperations.DIV);
					break;
				}
				case MOD:
				{
					match(MOD);
					prodExp.setOperation(ProductOperations.MOD);
					break;
				}
				default:
				{
					throw new NoViableAltException(LT(1), getFilename());
				}
				}
				}
				pw2=powExpr();
				prodExp.setLeft(p); prodExp.setRight(pw2); p = prodExp;
			}
			else {
				break _loop682;
			}
			
		} while (true);
		}
		return p;
	}
	
	public final Power  powExpr() throws RecognitionException, TokenStreamException {
		Power pw;
		
		pw = null;
		
		Atom a1 = null, a2 = null;
		a1=atom();
		pw = a1;
		{
		switch ( LA(1)) {
		case POW:
		{
			match(POW);
			a2=atom();
			PowerExpression pwExp = StoexFactory.eINSTANCE.createPowerExpression();
								pwExp.setBase(a1); pwExp.setExponent(a2); pw = pwExp;
							
			break;
		}
		case EOF:
		case GREATER:
		case LESS:
		case EQUAL:
		case NOTEQUAL:
		case GREATEREQUAL:
		case LESSEQUAL:
		case PLUS:
		case MINUS:
		case MUL:
		case DIV:
		case MOD:
		case RPAREN:
		{
			break;
		}
		default:
		{
			throw new NoViableAltException(LT(1), getFilename());
		}
		}
		}
		return pw;
	}
	
	public final Atom  atom() throws RecognitionException, TokenStreamException {
		Atom a;
		
		Token  number = null;
		Token  sl = null;
		a = null;
		
		{
		switch ( LA(1)) {
		case NUMBER:
		{
			number = LT(1);
			match(NUMBER);
			
							String value = number.getText();
							if (value.indexOf('.') < 0)
							{
								IntLiteral il = StoexFactory.eINSTANCE.createIntLiteral();
								il.setValue(Integer.parseInt(value));
								a = il;
							}
							else
							{
								DoubleLiteral dl = StoexFactory.eINSTANCE.createDoubleLiteral();
								dl.setValue(Double.parseDouble(value));
								a = dl;
							}
						
			break;
		}
		case ID:
		{
			AbstractNamedReference id = null;
			id=scoped_id();
			a = StoexFactory.eINSTANCE.createVariable();
					  	((Variable)a).setId_Variable(id);
					
			break;
		}
		case LITERAL_IntPMF:
		case LITERAL_DoublePMF:
		case LITERAL_EnumPMF:
		case LITERAL_DoublePDF:
		case LITERAL_BoolPMF:
		{
			a=definition();
			break;
		}
		case STRING_LITERAL:
		{
			sl = LT(1);
			match(STRING_LITERAL);
			
					  	StringLiteral stringLiteral = StoexFactory.eINSTANCE.createStringLiteral();
					  	stringLiteral.setValue(sl.getText().replace("\"",""));
					  	a = stringLiteral;
					
			break;
		}
		case LITERAL_false:
		case LITERAL_true:
		{
			String bl = null;
			bl=boolean_keywords();
			
					  	BoolLiteral boolLiteral = StoexFactory.eINSTANCE.createBoolLiteral();
				   		boolLiteral.setValue(bl.equals("true"));
					  	a = boolLiteral;
					
			break;
		}
		case LPAREN:
		{
			Expression inner = null;
			match(LPAREN);
			inner=compareExpr();
			match(RPAREN);
			
						Parenthesis paren = StoexFactory.eINSTANCE.createParenthesis();
						paren.setInnerExpression(inner);
						a = paren;
					
			break;
		}
		default:
		{
			throw new NoViableAltException(LT(1), getFilename());
		}
		}
		}
		return a;
	}
	
	public final AbstractNamedReference  scoped_id() throws RecognitionException, TokenStreamException {
		AbstractNamedReference ref;
		
		Token  id1 = null;
		Token  id2 = null;
		ref = null;
		ArrayList<String> nameParts = new ArrayList<String>();
		
		id1 = LT(1);
		match(ID);
		nameParts.add(id1.getText());
		{
		_loop719:
		do {
			if ((LA(1)==DOT)) {
				match(DOT);
				{
				switch ( LA(1)) {
				case ID:
				{
					id2 = LT(1);
					match(ID);
					nameParts.add(id2.getText());
					break;
				}
				case LITERAL_INNER:
				{
					match(LITERAL_INNER);
					nameParts.add("INNER");
					break;
				}
				default:
				{
					throw new NoViableAltException(LT(1), getFilename());
				}
				}
				}
			}
			else {
				break _loop719;
			}
			
		} while (true);
		}
		
			AbstractNamedReference firstNsRef=null;
			NamespaceReference lastNsRef = null;
			for (int i=0; i < nameParts.size()-1; i++)
			{
				NamespaceReference nsRef = StoexFactory.eINSTANCE.createNamespaceReference();
				nsRef.setReferenceName(nameParts.get(i));
				if (lastNsRef != null)
					lastNsRef.setInnerReference_NamespaceReference(nsRef);
				if (i == 0)
				   	firstNsRef = nsRef;
				lastNsRef = nsRef;
			}
			VariableReference varRef = StoexFactory.eINSTANCE.createVariableReference();
			varRef.setReferenceName(nameParts.get(nameParts.size()-1));
				if (lastNsRef != null) {
					lastNsRef.setInnerReference_NamespaceReference(varRef);
					ref = firstNsRef;
				}
				else
					ref = varRef;
			
		return ref;
	}
	
	public final ProbabilityFunctionLiteral  definition() throws RecognitionException, TokenStreamException {
		ProbabilityFunctionLiteral pfl;
		
		pfl = StoexFactory.eINSTANCE.createProbabilityFunctionLiteral();
			 ProbabilityFunction probFunction = null;
		
		switch ( LA(1)) {
		case LITERAL_IntPMF:
		{
			match(LITERAL_IntPMF);
			probFunction = ProbfunctionFactory.eINSTANCE.createProbabilityMassFunction();
							   pfl.setFunction_ProbabilityFunctionLiteral(probFunction);
			match(LPAREN);
			{
			Unit uunit = null;
			uunit=unit();
			probFunction.setUnit(uunit);
			}
			match(RPAREN);
			match(SQUARE_PAREN_L);
			{
			int _cnt690=0;
			_loop690:
			do {
				if ((LA(1)==LPAREN)) {
					Sample isample=null;
					isample=numeric_int_sample();
					((ProbabilityMassFunction)probFunction).getSamples().add(isample);
				}
				else {
					if ( _cnt690>=1 ) { break _loop690; } else {throw new NoViableAltException(LT(1), getFilename());}
				}
				
				_cnt690++;
			} while (true);
			}
			match(SQUARE_PAREN_R);
			break;
		}
		case LITERAL_DoublePMF:
		{
			match(LITERAL_DoublePMF);
			probFunction = ProbfunctionFactory.eINSTANCE.createProbabilityMassFunction();
							   pfl.setFunction_ProbabilityFunctionLiteral(probFunction);
			match(LPAREN);
			{
			Unit uunit = null;
			uunit=unit();
			probFunction.setUnit(uunit);
			}
			match(RPAREN);
			match(SQUARE_PAREN_L);
			{
			int _cnt693=0;
			_loop693:
			do {
				if ((LA(1)==LPAREN)) {
					Sample rsample=null;
					rsample=numeric_real_sample();
					((ProbabilityMassFunction)probFunction).getSamples().add(rsample);
				}
				else {
					if ( _cnt693>=1 ) { break _loop693; } else {throw new NoViableAltException(LT(1), getFilename());}
				}
				
				_cnt693++;
			} while (true);
			}
			match(SQUARE_PAREN_R);
			break;
		}
		case LITERAL_EnumPMF:
		{
			match(LITERAL_EnumPMF);
			probFunction = ProbfunctionFactory.eINSTANCE.createProbabilityMassFunction();
							   pfl.setFunction_ProbabilityFunctionLiteral(probFunction);
							   ((ProbabilityMassFunction)probFunction).setOrderedDomain(false);
							
			match(LPAREN);
			{
			Unit uunit = null;
			uunit=unit();
			probFunction.setUnit(uunit);
			}
			{
			switch ( LA(1)) {
			case SEMI:
			{
				match(SEMI);
				match(ORDERED_DEF);
				((ProbabilityMassFunction)probFunction).setOrderedDomain(true);
				break;
			}
			case RPAREN:
			{
				break;
			}
			default:
			{
				throw new NoViableAltException(LT(1), getFilename());
			}
			}
			}
			match(RPAREN);
			match(SQUARE_PAREN_L);
			{
			int _cnt697=0;
			_loop697:
			do {
				if ((LA(1)==LPAREN)) {
					Sample ssample=null;
					ssample=stringsample();
					((ProbabilityMassFunction)probFunction).getSamples().add(ssample);
				}
				else {
					if ( _cnt697>=1 ) { break _loop697; } else {throw new NoViableAltException(LT(1), getFilename());}
				}
				
				_cnt697++;
			} while (true);
			}
			match(SQUARE_PAREN_R);
			break;
		}
		case LITERAL_DoublePDF:
		{
			match(LITERAL_DoublePDF);
			probFunction = ProbfunctionFactory.eINSTANCE.createBoxedPDF();
							   pfl.setFunction_ProbabilityFunctionLiteral(probFunction);
			match(LPAREN);
			{
			Unit uunit = null;
			uunit=unit();
			probFunction.setUnit(uunit);
			}
			match(RPAREN);
			match(SQUARE_PAREN_L);
			{
			int _cnt700=0;
			_loop700:
			do {
				if ((LA(1)==LPAREN)) {
					ContinuousSample pdf_sample=null;
					pdf_sample=real_pdf_sample();
					((BoxedPDF)probFunction).getSamples().add(pdf_sample);
				}
				else {
					if ( _cnt700>=1 ) { break _loop700; } else {throw new NoViableAltException(LT(1), getFilename());}
				}
				
				_cnt700++;
			} while (true);
			}
			match(SQUARE_PAREN_R);
			break;
		}
		case LITERAL_BoolPMF:
		{
			match(LITERAL_BoolPMF);
			probFunction = ProbfunctionFactory.eINSTANCE.createProbabilityMassFunction();
							   pfl.setFunction_ProbabilityFunctionLiteral(probFunction);
							   ((ProbabilityMassFunction)probFunction).setOrderedDomain(false);
							
			match(LPAREN);
			{
			Unit uunit = null;
			uunit=bool_unit();
			probFunction.setUnit(uunit);
			}
			{
			switch ( LA(1)) {
			case SEMI:
			{
				match(SEMI);
				match(ORDERED_DEF);
				((ProbabilityMassFunction)probFunction).setOrderedDomain(true);
				break;
			}
			case RPAREN:
			{
				break;
			}
			default:
			{
				throw new NoViableAltException(LT(1), getFilename());
			}
			}
			}
			match(RPAREN);
			match(SQUARE_PAREN_L);
			{
			int _cnt704=0;
			_loop704:
			do {
				if ((LA(1)==LPAREN)) {
					Sample ssample=null;
					ssample=boolsample();
					((ProbabilityMassFunction)probFunction).getSamples().add(ssample);
				}
				else {
					if ( _cnt704>=1 ) { break _loop704; } else {throw new NoViableAltException(LT(1), getFilename());}
				}
				
				_cnt704++;
			} while (true);
			}
			match(SQUARE_PAREN_R);
			break;
		}
		default:
		{
			throw new NoViableAltException(LT(1), getFilename());
		}
		}
		return pfl;
	}
	
	public final String  boolean_keywords() throws RecognitionException, TokenStreamException {
		String keyword;
		
		keyword = null;
		
		{
		switch ( LA(1)) {
		case LITERAL_false:
		{
			match(LITERAL_false);
			keyword = "false";
			break;
		}
		case LITERAL_true:
		{
			match(LITERAL_true);
			keyword = "true";
			break;
		}
		default:
		{
			throw new NoViableAltException(LT(1), getFilename());
		}
		}
		}
		return keyword;
	}
	
	public final Unit  unit() throws RecognitionException, TokenStreamException {
		Unit u;
		
		Token  str = null;
		u = null;
		
		match(LITERAL_unit);
		u = ProbfunctionFactory.eINSTANCE.createUnit();
		match(DEFINITION);
		str = LT(1);
		match(STRING_LITERAL);
		u.setUnitName(str.getText().replace("\"",""));
		return u;
	}
	
	public final Sample  numeric_int_sample() throws RecognitionException, TokenStreamException {
		Sample s;
		
		Token  n = null;
		Token  n2 = null;
		s = null;
		
		match(LPAREN);
		s = ProbfunctionFactory.eINSTANCE.createSample();
		n = LT(1);
		match(NUMBER);
		s.setValue(Integer.parseInt(n.getText()));
		match(SEMI);
		n2 = LT(1);
		match(NUMBER);
		s.setProbability(Double.parseDouble(n2.getText()));
		match(RPAREN);
		return s;
	}
	
	public final Sample  numeric_real_sample() throws RecognitionException, TokenStreamException {
		Sample s;
		
		Token  n = null;
		Token  n2 = null;
		s = null;
		
		match(LPAREN);
		s = ProbfunctionFactory.eINSTANCE.createSample();
		n = LT(1);
		match(NUMBER);
		s.setValue(Double.parseDouble(n.getText()));
		match(SEMI);
		n2 = LT(1);
		match(NUMBER);
		s.setProbability(Double.parseDouble(n2.getText()));
		match(RPAREN);
		return s;
	}
	
	public final Sample  stringsample() throws RecognitionException, TokenStreamException {
		Sample s;
		
		Token  str = null;
		Token  n = null;
		s = null;
		
		match(LPAREN);
		s = ProbfunctionFactory.eINSTANCE.createSample();
		str = LT(1);
		match(STRING_LITERAL);
		s.setValue(str.getText().replace("\"",""));
		match(SEMI);
		n = LT(1);
		match(NUMBER);
		s.setProbability(Double.parseDouble(n.getText()));
		match(RPAREN);
		return s;
	}
	
	public final ContinuousSample  real_pdf_sample() throws RecognitionException, TokenStreamException {
		ContinuousSample s;
		
		Token  n = null;
		Token  n2 = null;
		s = null;
		
		match(LPAREN);
		s = ProbfunctionFactory.eINSTANCE.createContinuousSample();
		n = LT(1);
		match(NUMBER);
		s.setValue(Double.parseDouble(n.getText()));
		match(SEMI);
		n2 = LT(1);
		match(NUMBER);
		s.setProbability(Double.parseDouble(n2.getText()));
		match(RPAREN);
		return s;
	}
	
	public final Unit  bool_unit() throws RecognitionException, TokenStreamException {
		Unit u;
		
		u = null;
		
		match(LITERAL_unit);
		u = ProbfunctionFactory.eINSTANCE.createUnit();
		match(EQUAL);
		match(31);
		u.setUnitName("bool");
		return u;
	}
	
	public final Sample  boolsample() throws RecognitionException, TokenStreamException {
		Sample s;
		
		Token  n = null;
		s = null;String str = null;
		
		match(LPAREN);
		s = ProbfunctionFactory.eINSTANCE.createSample();
		str=boolean_keywords();
		s.setValue(str);
		match(SEMI);
		n = LT(1);
		match(NUMBER);
		s.setProbability(Double.parseDouble(n.getText()));
		match(RPAREN);
		return s;
	}
	
	public final String  characterisation_keywords() throws RecognitionException, TokenStreamException {
		String keyword;
		
		keyword = null;
		
		{
		switch ( LA(1)) {
		case LITERAL_BYTESIZE:
		{
			match(LITERAL_BYTESIZE);
			keyword="BYTESIZE";
			break;
		}
		case LITERAL_STRUCTURE:
		{
			match(LITERAL_STRUCTURE);
			keyword="STRUCTURE";
			break;
		}
		case LITERAL_NUMBER_OF_ELEMENTS:
		{
			match(LITERAL_NUMBER_OF_ELEMENTS);
			keyword="NUMBER_OF_ELEMENTS";
			break;
		}
		case LITERAL_TYPE:
		{
			match(LITERAL_TYPE);
			keyword="TYPE";
			break;
		}
		case LITERAL_VALUE:
		{
			match(LITERAL_VALUE);
			keyword="VALUE";
			break;
		}
		default:
		{
			throw new NoViableAltException(LT(1), getFilename());
		}
		}
		}
		return keyword;
	}
	
	
	public static final String[] _tokenNames = {
		"<0>",
		"EOF",
		"<2>",
		"NULL_TREE_LOOKAHEAD",
		"GREATER",
		"LESS",
		"EQUAL",
		"NOTEQUAL",
		"GREATEREQUAL",
		"LESSEQUAL",
		"PLUS",
		"MINUS",
		"MUL",
		"DIV",
		"MOD",
		"POW",
		"NUMBER",
		"STRING_LITERAL",
		"LPAREN",
		"RPAREN",
		"\"IntPMF\"",
		"SQUARE_PAREN_L",
		"SQUARE_PAREN_R",
		"\"DoublePMF\"",
		"\"EnumPMF\"",
		"SEMI",
		"ORDERED_DEF",
		"\"DoublePDF\"",
		"\"BoolPMF\"",
		"\"unit\"",
		"DEFINITION",
		"\"\\\"bool\\\"\"",
		"\"false\"",
		"\"true\"",
		"\"BYTESIZE\"",
		"\"STRUCTURE\"",
		"\"NUMBER_OF_ELEMENTS\"",
		"\"TYPE\"",
		"\"VALUE\"",
		"ID",
		"DOT",
		"\"INNER\"",
		"DIGIT",
		"ALPHA",
		"WS",
		"COMMENT",
		"ML_COMMENT"
	};
	
	
	}
