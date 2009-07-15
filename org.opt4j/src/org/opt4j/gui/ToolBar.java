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
package org.opt4j.gui;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

import javax.swing.BorderFactory;
import javax.swing.JToolBar;
import javax.swing.border.Border;

import com.google.inject.Inject;

/**
 * The {@code ToolBar} is a collection of the {@code ToolBarServices}.
 * 
 * @see ToolBarService
 * @author lukasiewycz
 * 
 */
public class ToolBar {

	protected final JToolBar toolBar = new JToolBar();
	protected final Set<ToolBarService> toolBarServices;

	/**
	 * Constructs a {@code ToolBar}.
	 * 
	 * @param toolBarServices
	 *            the set of {@code ToolBarServices}
	 */
	@Inject
	public ToolBar(Set<ToolBarService> toolBarServices) {
		this.toolBarServices = toolBarServices;
	}

	/**
	 * Initialization. This method has to be called once after construction.
	 */
	public void init() {
		toolBar.setFloatable(false);
		Border border = BorderFactory.createMatteBorder(0, 0, 1, 0, toolBar.getBackground().darker());
		toolBar.setBorder(border);

		List<ToolBarService> list = new ArrayList<ToolBarService>();
		list.addAll(toolBarServices);
		Collections.sort(list, new OrderComparator<ToolBarService>());

		for (ToolBarService toolBarService : list) {
			JToolBar component = toolBarService.getToolBar();
			toolBar.add(component);
		}
	}

	/**
	 * Returns the {@code JToolBar} component.
	 * 
	 * @return the component
	 */
	public JToolBar get() {
		return toolBar;
	}

}
