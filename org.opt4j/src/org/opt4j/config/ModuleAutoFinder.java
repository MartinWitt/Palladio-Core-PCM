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

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;
import java.util.zip.ZipEntry;
import java.util.zip.ZipException;
import java.util.zip.ZipFile;

import org.opt4j.config.annotations.Ignore;
import org.opt4j.start.Opt4JModule;

import com.google.inject.Inject;
import com.google.inject.Module;

/**
 * The {@code ModuleAutoFinder} searches the classpath for all moduleFinder that
 * are annotated with {@code AutoFind}.
 * 
 * @author lukasiewycz
 * 
 */
public class ModuleAutoFinder implements ModuleFinder {

	protected final Transformer<Class<? extends Module>, Boolean> accept;

	protected final Transformer<Class<? extends Module>, Boolean> ignore;

	protected final Collection<String> directories;

	protected ClassLoader classLoader;

	/**
	 * The {@code AllTrue} is a transformer that always returns {@code true}.
	 * 
	 * @author lukasiewycz
	 * 
	 */
	private class AllTrue implements
			Transformer<Class<? extends Module>, Boolean> {
		public Boolean transform(Class<? extends Module> arg) {
			return true;
		}
	}

	/**
	 * The {@code AllFalse} is a transformer that always returns {@code false}.
	 * 
	 * @author lukasiewycz
	 * 
	 */
	private class AllFalse implements
			Transformer<Class<? extends Module>, Boolean> {
		public Boolean transform(Class<? extends Module> arg) {
			return false;
		}
	}

	@Inject
	public ModuleAutoFinder() {
		this(null, null, null);
	}

	/**
	 * Constructs a {@code ModuleAutoFinder}.
	 * 
	 * @param accept
	 *            the accept transformer
	 * @param ignore
	 *            the ignore transformer
	 * @param directories
	 *            additional directories for the classpath
	 */
	public ModuleAutoFinder(
			Transformer<Class<? extends Module>, Boolean> accept,
			Transformer<Class<? extends Module>, Boolean> ignore,
			Collection<String> directories) {
		super();
		this.accept = (accept != null) ? accept : new AllTrue();
		this.ignore = (ignore != null) ? ignore : new AllFalse();
		this.directories = (directories != null) ? directories
				: new ArrayList<String>();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.opt4j.conf.ModuleFinder#getModules()
	 */
	public Collection<Class<? extends Module>> getModules() {
		return getAll();
	}

	/**
	 * Returns all not abstract classes that implement {@code PropertyModule}.
	 * 
	 * @return all not abstract classes that implement {@code PropertyModule}
	 */
	protected Collection<Class<? extends Module>> getAll() {

		Starter starter = new Starter();
		Collection<File> files = starter.addPlugins();

		classLoader = ClassLoader.getSystemClassLoader();

		String paths = System.getProperty("java.class.path");
		StringTokenizer st = new StringTokenizer(paths, ";\n:");

		while (st.hasMoreTokens()) {
			String path = st.nextToken();
			File f = new File(path);

			if (f.exists()) {
				try {
					f = f.getCanonicalFile();
					files.add(f);
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}

		List<Class<?>> classes = new ArrayList<Class<?>>();

		for (File file : files) {

			if (isJar(file)) {

				try {
					classes.addAll(getAllClasses(new ZipFile(file)));
				} catch (ZipException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				} catch (UnsupportedClassVersionError e) {
					System.err.println(file
							+ " not supported: bad version number");
				}
			} else {
				classes.addAll(getAllClasses(file));
			}
		}

		List<Class<? extends Module>> modules = new ArrayList<Class<? extends Module>>();

		for (Class<?> clazz : classes) {
			if (Opt4JModule.class.isAssignableFrom(clazz)
					&& !Modifier.isAbstract(clazz.getModifiers())) {
				Class<? extends Module> module = clazz.asSubclass(Module.class);
				Ignore i = module.getAnnotation(Ignore.class);

				if (i == null && accept.transform(module)
						&& !ignore.transform(module)) {
					modules.add(module);
				}
			}
		}

		return modules;

	}

	/**
	 * Returns {@code true} if the file is a Jar archive.
	 * 
	 * @param file
	 *            the tested file
	 * @return {@code true} if the file is a Jar archive
	 */
	protected boolean isJar(File file) {
		if (file.isDirectory()) {
			return false;
		}

		try {
			@SuppressWarnings("unused")
			ZipFile zf = new ZipFile(file);
			return true;
		} catch (ZipException e) {

		} catch (IOException e) {
			e.printStackTrace();
		}
		return false;
	}

	/**
	 * Retrieves all Classes from one directory.
	 * 
	 * @param directory
	 *            the directory
	 * @return all classes in a {@code List}
	 */
	protected List<Class<?>> getAllClasses(File directory) {
		return getAllClasses(directory, directory);
	}

	/**
	 * Recursive methods searching for classes in a root directory.
	 * 
	 * @param root
	 *            the root directory
	 * @param file
	 *            the current file
	 * @return the {@code List} of all found classes
	 */
	protected List<Class<?>> getAllClasses(File root, File file) {
		List<Class<?>> classes = new ArrayList<Class<?>>();
		if (file.isDirectory()) {
			for (File f : file.listFiles()) {
				classes.addAll(getAllClasses(root, f));
			}
		} else {
			int rootLength = root.getAbsolutePath().length();
			String s = file.getAbsolutePath().substring(rootLength + 1);
			s = s.replace("\\", ".");
			s = s.replace("/", ".");
			if (s.endsWith(".class")) {
				s = s.substring(0, s.length() - 6);
				try {
					classes.add(classLoader.loadClass(s));
				} catch (ClassNotFoundException e) {
					e.printStackTrace();
				} catch (UnsupportedClassVersionError e) {
					System.err
							.println(s + " not supported: bad version number");
				}
			}
		}

		return classes;

	}

	/**
	 * Retrieves all Classes from a {@code ZipFile} (Jar archive).
	 * 
	 * @param zipFile
	 *            the Jar archive
	 * @return the {@code List} of all classes
	 */
	protected List<Class<?>> getAllClasses(ZipFile zipFile) {
		List<Class<?>> classes = new ArrayList<Class<?>>();

		List<? extends ZipEntry> entries = Collections.list(zipFile.entries());
		for (int i = 0; i < entries.size(); i++) {

			ZipEntry entry = entries.get(i);

			String s = entry.getName();

			if (s.endsWith(".class")) {

				s = s.replace("/", ".");
				s = s.substring(0, s.length() - 6);

				try {
					Class<?> clazz = classLoader.loadClass(s);
					classes.add(clazz);
				} catch (ClassNotFoundException e) {
				} catch (NoClassDefFoundError e) {
				} catch (UnsupportedClassVersionError e) {
					System.err
							.println(s + " not supported: bad version number");
				}

			}
		}

		return classes;
	}

}
