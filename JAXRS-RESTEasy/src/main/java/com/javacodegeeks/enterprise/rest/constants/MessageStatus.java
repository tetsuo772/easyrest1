package com.javacodegeeks.enterprise.rest.constants;

public enum MessageStatus {
	DELIVERED("DELIVERED"),
	    SEEN("SEEN")	    
	    ;

	    private final String text;

	    /**
	     * @param text
	     */
	    MessageStatus(final String text) {
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
