package com.i2i.vehicleloan.exception;

/**
 * Exception class which has constructors for creating own error messages.
 * 
 * @author Madhan
 * 
 * @created 2016-08-27
 */
public class DatabaseException extends Exception {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
    
    /**
     * Constructor with single parameter which has message. 
     * 
     * @param message
     * 		Error message to be overridden.
     */
    public DatabaseException(String message) {
        super(message);
    }

    /**
     * Constructor with single parameter which has object. 
     * 
     * @param cause
     * 		Error object to be overridden.
     */
    public DatabaseException(Throwable cause) {
        super(cause);
    }

    /**
     * Constructor with double parameter which has string and object. 
     * 
     * @param message
     * 		Error message to be overridden.
     * @param cause
     * 		Error object to be overridden.
     */    
    public DatabaseException(String message, Throwable cause) {
        super(message,cause);
    }
}
