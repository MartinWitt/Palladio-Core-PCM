/**
 * Copyright (c) 2004-2006 FZI Forschungszentrum Informatik, 
 * 10-14 Haid-und-Neu Street, 76131 Karlsruhe, Germany
 *
 * This library is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation; either
 * version 2.1 of the License, or (at your option) any later version.
 *
 * This library is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this library; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin St, Fifth Floor, Boston, MA  02110-1301  USA
 */
package de.fzi.sissy.extractors.cdt.ast;

import org.eclipse.cdt.core.parser.ast.IASTExpression;


/**
 * @author phil
 */
public class ASTIfStatement extends ASTAbstractStatement {

	//private IASTExpression cond = null;
	private IASTStatement then = null;
	private IASTStatement els = null;
	
	public ASTIfStatement(IASTExpression condition, IASTStatement thenStmt, IASTStatement elseStmt) {
		//cond = condition;
		then = thenStmt;
		els = elseStmt;
	}
	
    public ASTIfStatement() {
    }

    public void setExpression(IASTExpression expr) {
        //cond = expr;
    }
	public IASTExpression getExpression() {
		return /*cond;*/ null;
	}
	public void setThen(IASTStatement stmt) {
        then = stmt;
    }
	public IASTStatement getThen() {
		return then;
	}
	public void setElse(IASTStatement stmt) {
        els = stmt;
    }
	public IASTStatement getElse() {
		return els;
	}
	
	public String toString() {
		return "if (" /*+ cond.toString()*/ + ")\n"
					+ then.toString() + ((els != null) ? "\nelse\n" + els.toString() : "");
	}
}