package com.zm.mi.utils;

public class StringDataUtils {
	private static final String MULTIPLE_SPACE_REGX = " +";
	private static final String SINGLE_SPACE_REGX = " ";

	public static String normlaizeString(String string) {
		if (string != null && string.length() != 0) {
			
			
			return string.trim().replaceAll(MULTIPLE_SPACE_REGX, SINGLE_SPACE_REGX);

		}
		if(string.length()==0)
		{
			return "";
		}

		return null;
	}

}
