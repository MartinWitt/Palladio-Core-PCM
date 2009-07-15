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

package org.opt4j.config;

import java.awt.Component;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.net.URL;

import javax.swing.ImageIcon;

//import org.opt4j.Opt4JPluginActivator;

/**
 * The {@code Icons} class is used to get {@code ImageIcons} from a given
 * {@code filename}. Moreover, it contains the {@code filenames} of some
 * standard icons.
 * 
 * @author glass
 * 
 */
public class Icons {

	/**
	 * The icon for the optimizer.
	 */
	public static final String OPTIMIZER = "icons/tools-blue.png";

	/**
	 * The icon for the problem.
	 */
	public static final String PROBLEM = "icons/gear-gray.png";

	/**
	 * The icon for the archive.
	 */
	public static final String ARCHIVE = "icons/user-green.png";

	/**
	 * The icon for the population.
	 */
	public static final String POPULATION = "icons/user-blue.png";

	/**
	 * The icon for the pareto contentPanel.
	 */
	public static final String PARETO = "icons/stat.png";

	/**
	 * The icon for the play button.
	 */
	public static final String PLAY = "icons/play.png";

	/**
	 * The icon for the operator.
	 */
	public static final String OPERATOR = "icons/tools-orange.png";

	/**
	 * The icon for the application.
	 */
	public static final String APPLICATION = "icons/appl.png";
	
	/**
	 * The icon for the green puzzle.
	 */
	public static final String PUZZLE_GREEN = "icons/puzzle-green.png";
	
	/**
	 * The icon for the blue puzzle.
	 */
	public static final String PUZZLE_BLUE = "icons/puzzle-blue.png";

	/**
	 * The icon for the selector.
	 */
	public static final String SELECTOR = "icons/tools-orange.png";

	/**
	 * The icon for the control start.
	 */
	public static final String CONTROL_START = "icons/control_start.png";

	/**
	 * The icon for the control stop.
	 */
	public static final String CONTROL_STOP = "icons/control_stop.png";

	/**
	 * The icon for the control pause.
	 */
	public static final String CONTROL_PAUSE = "icons/control_pause.png";

	/**
	 * The icon for the control term.
	 */
	public static final String CONTROL_TERM = "icons/control_term.png";

	/**
	 * The icon for the control term.
	 */
	public static final String FOLDER = "icons/folder.png";

	/**
	 * The icon for the control term.
	 */
	public static final String FOLDER_ADD = "icons/folder_add.png";

	/**
	 * The icon for the control term.
	 */
	public static final String SFOLDER = "icons/small_folder.png";

	/**
	 * A disk.
	 */
	public static final String DISK = "icons/disk.png";

	/**
	 * A console.
	 */
	public static final String CONSOLE = "icons/console.png";

	/**
	 * The Opt4J logo.
	 */
	public static final String OPT4J = "icons/logo2.png";

	/**
	 * An add bullet.
	 */
	public static final String ADD = "icons/add.png";

	/**
	 * A delete bullet.
	 */
	public static final String DELETE = "icons/delete.png";

	/**
	 * A delete bullet.
	 */
	public static final String LOADING = "icons/loading.gif";

	/**
	 * Constructs {@code Icons}.
	 */
	public Icons() {
		super();
	}

	/**
	 * Returns an {@code ImageIcon} from a filename.
	 * 
	 * @param filename
	 *            the filename
	 * @return an {@code ImageIcon} from a filename
	 */
	public static ImageIcon getIcon(String filename) {
		
		ClassLoader classLoader = ClassLoader.getSystemClassLoader();
		URL url = classLoader.getResource(filename);
		//URL url = Opt4JPluginActivator.getURLForOpt4JIcon(filename);
		try {
			return new ImageIcon(url);
		} catch (NullPointerException e) {
			System.err.println("Image " + filename + " not found.");
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * Returns a transparent 16x16px {@code ImageIcon}.
	 * 
	 * @return a transparent 16x16px {@code ImageIcon}
	 */
	public static ImageIcon getDefault() {
		Image image = new BufferedImage(16, 16, BufferedImage.TYPE_INT_ARGB);
		ImageIcon icon = new ImageIcon(image);

		return icon;
	}

	/**
	 * This methods merges multiple {@code ImageIcon}s into a single {@code
	 * ImageIcon}.
	 * 
	 * @param icons
	 *            the icons to merge
	 * @return the merged icons
	 */
	public static ImageIcon merge(ImageIcon... icons) {

		/**
		 * The {@code MergedIcon} merges two icons into one.
		 * 
		 * @author lukasiewycz
		 * 
		 */
		@SuppressWarnings("serial")
		class MergedIcon extends ImageIcon {

			private final ImageIcon[] icons;

			public MergedIcon(ImageIcon[] icons) {
				super();
				this.icons = icons;
			}

			@Override
			public void paintIcon(Component c, Graphics g, int x, int y) {
				for (ImageIcon icon : icons) {
					icon.paintIcon(c, g, x, y);
				}
			}

			@Override
			public int getIconWidth() {
				return icons[0].getIconWidth();
			}

			@Override
			public int getIconHeight() {
				return icons[0].getIconHeight();
			}
		}

		return new MergedIcon(icons);
	}
}
