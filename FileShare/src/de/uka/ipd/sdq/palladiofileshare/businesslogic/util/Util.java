package de.uka.ipd.sdq.palladiofileshare.businesslogic.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

import org.apache.log4j.Logger;

public class Util {

	private static Logger logger = Logger.getLogger(Util.class);
	private static int randomSeed = 1234;
		
	public static Set<Integer> initHashSetWithInteger(int amountOfData) {	
		Set<Integer> hashSet = new HashSet<Integer>();
		Random r = new Random(randomSeed);

		for(int x = 0; x < amountOfData; x++) {			
			//FIXME: adapt to size of used hash algorithm: 
			byte[] randomBytes = {0x0000,0x0000,0x0000,0x0000,0x0000,0x0000,0x0000,0x0000,0x0000,0x0000,0x0000,0x0000,0x0000,0x0000,0x0000,0x0000,0x0000,0x0000,0x0000,0x0000};
			MessageDigest md;
			
			try {
				md = MessageDigest.getInstance("SHA");

				r.nextBytes(randomBytes);
				md.update(randomBytes);
				hashSet.add(createIntegerHash(md.digest()));
			} catch (NoSuchAlgorithmException e) {
				e.printStackTrace();
				logger.error(e);
			}
		}
		return hashSet;
	}
	
	/**
	 * creates a string unique for file and thread
	 * @param fileHash
	 * @return
	 */
	public static Integer createIntegerHash(byte[] fileHash) {				
		Byte[] fileHash2 = new Byte[fileHash.length];
		
		for(int x = 0; x < fileHash.length; x++) {
			fileHash2[x] = new Byte(fileHash[x]);		
		}
		
		return Arrays.deepHashCode(fileHash2);
	}
		
	/**
	 * creates a string unique for file and thread
	 * @param fileHash
	 * @return
	 */
	public static String createString(byte[] fileHash) {		
		StringBuilder string = new StringBuilder("f" + Thread.currentThread().getId());		
						
		for(int x = 0; (x < fileHash.length && x < 40) ; x++) {			
			string.append(fileHash[x]);
		}
		
		return string.toString();
	}
}
