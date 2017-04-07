package org.anhcraft.spaciouslib.Hash;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

/**
 * The type Ice hash.
 */
public class SHash extends SHashAdvanced{
    /**
     * MD5 encryption for a string [UTF-8]
     *
     * @param hash the string should be MD5 encrypted
     *
     * @return MD5 encrypted string
     *
     * @throws NoSuchAlgorithmException     the no such algorithm exception
     * @throws UnsupportedEncodingException the unsupported encoding exception
     */
    public String md5(String hash) throws NoSuchAlgorithmException, UnsupportedEncodingException {
		MessageDigest md = MessageDigest.getInstance("MD5");
        byte[] byteData = md.digest(hash.getBytes("UTF-8"));
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
     * SHA-256 encryption for a string [UTF-8]
     *
     * @param hash the string should be SHA-256 encrypted
     *
     * @return SHA -256 encrypted string
     *
     * @throws NoSuchAlgorithmException     the no such algorithm exception
     * @throws UnsupportedEncodingException the unsupported encoding exception
     */
    public String sha256(String hash) throws NoSuchAlgorithmException, UnsupportedEncodingException {
        MessageDigest digest = MessageDigest.getInstance("SHA-256");
        byte[] md = digest.digest(hash.getBytes("UTF-8"));
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
     * SHA-512 encryption for a string [UTF-8]
     *
     * @param hash the string should be SHA-512 encrypted
     *
     * @return SHA -512 encrypted string
     *
     * @throws NoSuchAlgorithmException     the no such algorithm exception
     * @throws UnsupportedEncodingException the unsupported encoding exception
     */
    public String sha512(String hash) throws NoSuchAlgorithmException, UnsupportedEncodingException {
        MessageDigest digest = MessageDigest.getInstance("SHA-512");
        byte[] md = digest.digest(hash.getBytes("UTF-8"));
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < md.length ; i++){
           sb.append(Integer.toString((md[i] & 0xff) + 0x100, 16).substring(1));
        }
        return sb.toString();
	}

    /**
     * Base64 encryption for a string [UTF-8]
     *
     * @param hash the string should be Base64 encrypted
     *
     * @return Base64 encrypted string
     *
     * @throws NoSuchAlgorithmException     the no such algorithm exception
     * @throws UnsupportedEncodingException the unsupported encoding exception
     */
    public String base64(String hash) throws NoSuchAlgorithmException, UnsupportedEncodingException {
		byte[] bytes = hash.getBytes("UTF-8");
        String sb = Base64.getEncoder().encodeToString(bytes);
        return sb.toString();
	}
}
