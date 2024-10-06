package TestCases;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class logfourj {
    
    // Creating a Logger instance
    private static final Logger yhu = LogManager.getLogger(logfourj.class);

    public static void main(String[] args) {
        // Log messages of different levels
    	
         
    	
        yhu.debug("This is a debug message.");
        yhu.info("This is an info message.");
        yhu.error("This is an error message.");
    }
}
