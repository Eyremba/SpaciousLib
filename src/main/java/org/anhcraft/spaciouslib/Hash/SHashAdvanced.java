package org.anhcraft.spaciouslib.Hash;

import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

/**
 * The type Ice hash advanced.
 */
public class SHashAdvanced {
    /**
     * MD5 encryption for a string
     *
     * @param hash    the string should be MD5 encrypted
     * @param charset type of character encoding
     *
     * @return MD5 encrypted string
     *
     * @throws NoSuchAlgorithmException     the no such algorithm exception
     * @throws UnsupportedEncodingException the unsupported encoding exception
     */
    public String md5(String hash, Charset charset) throws NoSuchAlgorithmException, UnsupportedEncodingException {
		MessageDigest md = MessageDigest.getInstance("MD5");
        byte[] byteData = md.digest(hash.getBytes(charset.name()));
        StringBuffer hexString = new StringBuffer();
    	for (int i = 0; i < byteData.length; i++) {
    		String hex = Integer.toHexString(0xff & byteData[i]);
   	     	if(hex.length() == 1) {
   	     		hexString.append('0');
   	     	}
   	     	hexString.append(hex);
    	}
    	return hexString.toString();
	}

    /**
     * SHA-256 encryption for a string
     *
     * @param hash    the string should be SHA-256 encrypted
     * @param charset type of character encoding
     *
     * @return SHA -256 encrypted string
     *
     * @throws NoSuchAlgorithmException     the no such algorithm exception
     * @throws UnsupportedEncodingException the unsupported encoding exception
     */
    public String sha256(String hash, Charset charset) throws NoSuchAlgorithmException, UnsupportedEncodingException {
        MessageDigest digest = MessageDigest.getInstance("SHA-256");
        byte[] md = digest.digest(hash.getBytes(charset.name()));
        StringBuffer hexString = new StringBuffer();

        for (int i = 0; i < md.length; i++) {
            String hex = Integer.toHexString(0xff & md[i]);
            if(hex.length() == 1){
            	hexString.append('0');
            }
            hexString.append(hex);
        }
        return hexString.toString();
	}

    /**
     * SHA-512 encryption for a string
     *
     * @param hash    the string should be SHA-512 encrypted
     * @param charset type of character encoding
     *
     * @return SHA -512 encrypted string
     *
     * @throws NoSuchAlgorithmException     the no such algorithm exception
     * @throws UnsupportedEncodingException the unsupported encoding exception
     */
    public String sha512(String hash, Charset charset) throws NoSuchAlgorithmException, UnsupportedEncodingException {
        MessageDigest digest = MessageDigest.getInstance("SHA-512");
        byte[] md = digest.digest(hash.getBytes(charset.name()));
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < md.length ; i++){
           sb.append(Integer.toString((md[i] & 0xff) + 0x100, 16).substring(1));
        }
        return sb.toString();
	}

    /**
     * Base64 encryption for a string
     *
     * @param hash    the string should be Base64 encrypted
     * @param charset type of character encoding
     *
     * @return Base64 encrypted string
     *
     * @throws NoSuchAlgorithmException     the no such algorithm exception
     * @throws UnsupportedEncodingException the unsupported encoding exception
     */
    public String base64(String hash, Charset charset) throws NoSuchAlgorithmException, UnsupportedEncodingException {
		byte[] bytes = hash.getBytes(charset.name());
        String sb = Base64.getEncoder().encodeToString(bytes);
        return sb.toString();
	}
}
