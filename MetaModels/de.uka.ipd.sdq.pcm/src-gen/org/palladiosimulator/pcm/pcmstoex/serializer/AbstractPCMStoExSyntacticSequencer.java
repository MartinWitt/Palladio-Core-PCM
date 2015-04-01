package org.palladiosimulator.pcm.pcmstoex.serializer;

import com.google.inject.Inject;
import java.util.List;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.IGrammarAccess;
import org.eclipse.xtext.RuleCall;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.serializer.analysis.GrammarAlias.AbstractElementAlias;
import org.eclipse.xtext.serializer.analysis.GrammarAlias.TokenAlias;
import org.eclipse.xtext.serializer.analysis.ISyntacticSequencerPDAProvider.ISynNavigable;
import org.eclipse.xtext.serializer.analysis.ISyntacticSequencerPDAProvider.ISynTransition;
import org.eclipse.xtext.serializer.sequencer.AbstractSyntacticSequencer;
import org.palladiosimulator.pcm.pcmstoex.services.PCMStoExGrammarAccess;

@SuppressWarnings("all")
public abstract class AbstractPCMStoExSyntacticSequencer extends AbstractSyntacticSequencer {

	protected PCMStoExGrammarAccess grammarAccess;
	protected AbstractElementAlias match_unitPow_LPARENTerminalRuleCall_0_1_0_a;
	protected AbstractElementAlias match_unitPow_LPARENTerminalRuleCall_0_1_0_p;
	
	@Inject
	protected void init(IGrammarAccess access) {
		grammarAccess = (PCMStoExGrammarAccess) access;
		match_unitPow_LPARENTerminalRuleCall_0_1_0_a = new TokenAlias(true, true, grammarAccess.getUnitPowAccess().getLPARENTerminalRuleCall_0_1_0());
		match_unitPow_LPARENTerminalRuleCall_0_1_0_p = new TokenAlias(true, false, grammarAccess.getUnitPowAccess().getLPARENTerminalRuleCall_0_1_0());
	}
	
	@Override
	protected String getUnassignedRuleCallToken(EObject semanticObject, RuleCall ruleCall, INode node) {
		if(ruleCall.getRule() == grammarAccess.getBOOLPMFRule())
			return getBOOLPMFToken(semanticObject, ruleCall, node);
		else if(ruleCall.getRule() == grammarAccess.getCOLONRule())
			return getCOLONToken(semanticObject, ruleCall, node);
		else if(ruleCall.getRule() == grammarAccess.getCONDDELIMITERRule())
			return getCONDDELIMITERToken(semanticObject, ruleCall, node);
		else if(ruleCall.getRule() == grammarAccess.getDOTRule())
			return getDOTToken(semanticObject, ruleCall, node);
		else if(ruleCall.getRule() == grammarAccess.getDOUBLEPDFRule())
			return getDOUBLEPDFToken(semanticObject, ruleCall, node);
		else if(ruleCall.getRule() == grammarAccess.getDOUBLEPMFRule())
			return getDOUBLEPMFToken(semanticObject, ruleCall, node);
		else if(ruleCall.getRule() == grammarAccess.getELSEDELIMITERRule())
			return getELSEDELIMITERToken(semanticObject, ruleCall, node);
		else if(ruleCall.getRule() == grammarAccess.getENUMPMFRule())
			return getENUMPMFToken(semanticObject, ruleCall, node);
		else if(ruleCall.getRule() == grammarAccess.getINTPMFRule())
			return getINTPMFToken(semanticObject, ruleCall, node);
		else if(ruleCall.getRule() == grammarAccess.getLPARENRule())
			return getLPARENToken(semanticObject, ruleCall, node);
		else if(ruleCall.getRule() == grammarAccess.getNOTRule())
			return getNOTToken(semanticObject, ruleCall, node);
		else if(ruleCall.getRule() == grammarAccess.getORDERED_DEFRule())
			return getORDERED_DEFToken(semanticObject, ruleCall, node);
		else if(ruleCall.getRule() == grammarAccess.getPOWRule())
			return getPOWToken(semanticObject, ruleCall, node);
		else if(ruleCall.getRule() == grammarAccess.getRPARENRule())
			return getRPARENToken(semanticObject, ruleCall, node);
		else if(ruleCall.getRule() == grammarAccess.getSEMIRule())
			return getSEMIToken(semanticObject, ruleCall, node);
		else if(ruleCall.getRule() == grammarAccess.getSQUARE_PAREN_LRule())
			return getSQUARE_PAREN_LToken(semanticObject, ruleCall, node);
		else if(ruleCall.getRule() == grammarAccess.getSQUARE_PAREN_RRule())
			return getSQUARE_PAREN_RToken(semanticObject, ruleCall, node);
		return "";
	}
	
	/**
	 * terminal BOOLPMF: 'BoolPMF';
	 */
	protected String getBOOLPMFToken(EObject semanticObject, RuleCall ruleCall, INode node) {
		if (node != null)
			return getTokenText(node);
		return "BoolPMF";
	}
	
	/**
	 * terminal COLON:	',';
	 */
	protected String getCOLONToken(EObject semanticObject, RuleCall ruleCall, INode node) {
		if (node != null)
			return getTokenText(node);
		return ",";
	}
	
	/**
	 * terminal CONDDELIMITER: '?';
	 */
	protected String getCONDDELIMITERToken(EObject semanticObject, RuleCall ruleCall, INode node) {
		if (node != null)
			return getTokenText(node);
		return "?";
	}
	
	/**
	 * terminal DOT: '.';
	 */
	protected String getDOTToken(EObject semanticObject, RuleCall ruleCall, INode node) {
		if (node != null)
			return getTokenText(node);
		return ".";
	}
	
	/**
	 * terminal DOUBLEPDF: 'DoublePDF';
	 */
	protected String getDOUBLEPDFToken(EObject semanticObject, RuleCall ruleCall, INode node) {
		if (node != null)
			return getTokenText(node);
		return "DoublePDF";
	}
	
	/**
	 * terminal DOUBLEPMF: 'DoublePMF';
	 */
	protected String getDOUBLEPMFToken(EObject semanticObject, RuleCall ruleCall, INode node) {
		if (node != null)
			return getTokenText(node);
		return "DoublePMF";
	}
	
	/**
	 * terminal ELSEDELIMITER: ':';
	 */
	protected String getELSEDELIMITERToken(EObject semanticObject, RuleCall ruleCall, INode node) {
		if (node != null)
			return getTokenText(node);
		return ":";
	}
	
	/**
	 * terminal ENUMPMF: 'EnumPMF';
	 */
	protected String getENUMPMFToken(EObject semanticObject, RuleCall ruleCall, INode node) {
		if (node != null)
			return getTokenText(node);
		return "EnumPMF";
	}
	
	/**
	 * terminal INTPMF: 'IntPMF';
	 */
	protected String getINTPMFToken(EObject semanticObject, RuleCall ruleCall, INode node) {
		if (node != null)
			return getTokenText(node);
		return "IntPMF";
	}
	
	/**
	 * terminal LPAREN: '(' ;
	 */
	protected String getLPARENToken(EObject semanticObject, RuleCall ruleCall, INode node) {
		if (node != null)
			return getTokenText(node);
		return "(";
	}
	
	/**
	 * terminal NOT: 'NOT';
	 */
	protected String getNOTToken(EObject semanticObject, RuleCall ruleCall, INode node) {
		if (node != null)
			return getTokenText(node);
		return "NOT";
	}
	
	/**
	 * terminal ORDERED_DEF: 'ordered';
	 */
	protected String getORDERED_DEFToken(EObject semanticObject, RuleCall ruleCall, INode node) {
		if (node != null)
			return getTokenText(node);
		return "ordered";
	}
	
	/**
	 * terminal POW   : '^' ;
	 */
	protected String getPOWToken(EObject semanticObject, RuleCall ruleCall, INode node) {
		if (node != null)
			return getTokenText(node);
		return "^";
	}
	
	/**
	 * terminal RPAREN: ')' ;
	 */
	protected String getRPARENToken(EObject semanticObject, RuleCall ruleCall, INode node) {
		if (node != null)
			return getTokenText(node);
		return ")";
	}
	
	/**
	 * terminal SEMI: ';' ;
	 */
	protected String getSEMIToken(EObject semanticObject, RuleCall ruleCall, INode node) {
		if (node != null)
			return getTokenText(node);
		return ";";
	}
	
	/**
	 * terminal SQUARE_PAREN_L : '[' ;
	 */
	protected String getSQUARE_PAREN_LToken(EObject semanticObject, RuleCall ruleCall, INode node) {
		if (node != null)
			return getTokenText(node);
		return "[";
	}
	
	/**
	 * terminal SQUARE_PAREN_R : ']' ;
	 */
	protected String getSQUARE_PAREN_RToken(EObject semanticObject, RuleCall ruleCall, INode node) {
		if (node != null)
			return getTokenText(node);
		return "]";
	}
	
	@Override
	protected void emitUnassignedTokens(EObject semanticObject, ISynTransition transition, INode fromNode, INode toNode) {
		if (transition.getAmbiguousSyntaxes().isEmpty()) return;
		List<INode> transitionNodes = collectNodes(fromNode, toNode);
		for (AbstractElementAlias syntax : transition.getAmbiguousSyntaxes()) {
			List<INode> syntaxNodes = getNodesFor(transitionNodes, syntax);
			if(match_unitPow_LPARENTerminalRuleCall_0_1_0_a.equals(syntax))
				emit_unitPow_LPARENTerminalRuleCall_0_1_0_a(semanticObject, getLastNavigableState(), syntaxNodes);
			else if(match_unitPow_LPARENTerminalRuleCall_0_1_0_p.equals(syntax))
				emit_unitPow_LPARENTerminalRuleCall_0_1_0_p(semanticObject, getLastNavigableState(), syntaxNodes);
			else acceptNodes(getLastNavigableState(), syntaxNodes);
		}
	}

	/**
	 * Syntax:
	 *     LPAREN*
	 */
	protected void emit_unitPow_LPARENTerminalRuleCall_0_1_0_a(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Syntax:
	 *     LPAREN+
	 */
	protected void emit_unitPow_LPARENTerminalRuleCall_0_1_0_p(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
}
