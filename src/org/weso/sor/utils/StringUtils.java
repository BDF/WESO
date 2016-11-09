package org.weso.sor.utils;

public class StringUtils {
	
	public StringUtils() {
	}
	
	public boolean hasLength(final CharSequence str) {
		return (str != null && str.length() > 0);
	}
	
	/**
	 * Will throw an exception if 'str' is null or empty.
	 * @param str Field under test.
	 * @param field Name of the field to test.
	 * @throws IllegalArgumentException Thrown if 'str is null or empty
	 */
	public void requiresLength(final String str, final String field) throws IllegalArgumentException {
		if (!hasLength((CharSequence)str)) {
			throw new IllegalArgumentException(field + " is a required field");
		}
	}
	
	public String buildPhone(String inAreaCode,
			String inPrefix, String inLineNumber) {
		final String phone = inLineNumber;
		return phone;
	}

}
