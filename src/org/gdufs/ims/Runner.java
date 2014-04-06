package org.gdufs.ims;

import java.io.UnsupportedEncodingException;
/**
 * 
 */

/**
 * @author prehawk
 *
 */



public class Runner {

	/**
	 * @param args
	 * @throws InterruptedException 
	 * @throws UnsupportedEncodingException 
	 */
	public static void main(String[] args) throws UnsupportedEncodingException, InterruptedException {
		// TODO Auto-generated method stub
		
		HttpFetcher hf = new HttpFetcher();
		hf.run();
		System.out.println("Hello wolrd");
	}

}
