package com.javacodegeeks.enterprise.rest.constants;

public enum MessageType {
	CALL("CALL"),
	    MSG	("MSG	")	    
	    ;

	    private final String text;

	    /**
	     * @param text
	     */
	    MessageType(final String text) {
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
