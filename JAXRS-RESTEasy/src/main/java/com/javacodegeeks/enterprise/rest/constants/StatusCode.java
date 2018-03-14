package com.javacodegeeks.enterprise.rest.constants;

public enum StatusCode {
	OK("OK"),
	    KO	("KO")	    
	    ;

	    private final String text;

	    /**
	     * @param text
	     */
	    StatusCode(final String text) {
	        this.text = text;
	    }

	    /* (non-Javadoc)
	     * @see java.lang.Enum#toString()
	     */
	    @Override
	    public String toString() {
	        return text;
	    }
}
