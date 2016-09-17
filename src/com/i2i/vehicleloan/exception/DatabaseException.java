package com.i2i.vehicleloan.exception;

/**
 * <p>
 * Exception class which has constructors for creating own error messages.
 * </p>
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
     * <p>
     * Constructor with single parameter which has message. 
     * </p>
     * @param message
     * 		Error message to be overridden.
     */
    public DatabaseException(String message) {
        super(message);
    }

    /**
     * <p>
     * Constructor with single parameter which has object. 
     * </p>
     * @param cause
     * 		Error object to be overridden.
     */
    public DatabaseException(Throwable cause) {
        super(cause);
    }

    /**
     * <p>
     * Constructor with double parameter which has string and object. 
     * </p>
     * @param message
     * 		Error message to be overridden.
     * @param cause
     * 		Error object to be overridden.
     */    
    public DatabaseException(String message, Throwable cause) {
        super(message,cause);
    }
}
