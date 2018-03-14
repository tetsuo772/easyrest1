package com.javacodegeeks.enterprise.rest.constants;

public enum EnumString {
	    STRING_ONE("ONE"),
	    STRING_TWO("TWO")	    
	    ;

	    private final String text;

	    /**
	     * @param text
	     */
	    EnumString(final String text) {
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
