package org.anhcraft.spaciouslib.Converter;

import java.text.Normalizer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * The type Data types.
 */
public class DataTypes {
	/**
	 * Convert String to Float
	 *
	 * @param num the string
	 *
	 * @return a new data type called Float was converted from this string
	 */
	public float toFloat(String num) {
		num = Normalizer.normalize(num, Normalizer.Form.NFD);
		Pattern pattern = Pattern.compile("[^0-9\\-\\+\\.]*");
	    Matcher matcher = pattern.matcher(num);
	    num = matcher.replaceAll("");
	    num = num.replace("+","");
	    float n = Float.parseFloat(num);
		return n;
	}

	/**
	 * Convert String to Double
	 *
	 * @param num the string
	 *
	 * @return a new data type called Double was converted from this string
	 */
	public double toDouble(String num) {
		num = Normalizer.normalize(num, Normalizer.Form.NFD);
		Pattern pattern = Pattern.compile("[^0-9\\-\\+\\.]*");
	    Matcher matcher = pattern.matcher(num);
	    num = matcher.replaceAll("");
	    num = num.replace("+","");
	    double n = Double.parseDouble(num);
		return n;
	}

	/**
	 * Convert String to Long
	 *
	 * @param num the string
	 *
	 * @return a new data type called Long was converted from this string
	 */
	public long toLong(String num) {
		num = Normalizer.normalize(num, Normalizer.Form.NFD);
		Pattern pattern = Pattern.compile("[^0-9\\-\\+]*");
	    Matcher matcher = pattern.matcher(num);
	    num = matcher.replaceAll("");
	    num = num.replace("+","");
	    long n = Long.parseLong(num);
		return n;
	}

	/**
	 * Convert String to Short
	 *
	 * @param num the string
	 *
	 * @return a new data type called Short was converted from this string
	 */
	public short toShort(String num) {
		num = Normalizer.normalize(num, Normalizer.Form.NFD);
		Pattern pattern = Pattern.compile("[^0-9\\-\\+]*");
	    Matcher matcher = pattern.matcher(num);
	    num = matcher.replaceAll("");
	    num = num.replace("+","");
	    short n = Short.parseShort(num);
		return n;
	}

	/**
	 * Convert String to Integer
	 *
	 * @param num the string
	 *
	 * @return a new data type called Integer was converted from this string
	 */
	public int toInt(String num) {
		num = Normalizer.normalize(num, Normalizer.Form.NFD);
		Pattern pattern = Pattern.compile("[^0-9\\-\\+]*");
	    Matcher matcher = pattern.matcher(num);
	    num = matcher.replaceAll("");
	    num = num.replace("+","");
	    int n = Integer.parseInt(num);
		return n;
	}
}
