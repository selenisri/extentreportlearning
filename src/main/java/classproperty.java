import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.core.config.Configurator;
import org.apache.logging.log4j.core.config.DefaultConfiguration;

import TestCases.logfourj;

public class classproperty {
	 private static final Logger yhu = LogManager.getLogger(classproperty.class);

	    public static void main(String[] args) {
	        // Log messages of different levels
	 

	        yhu.debug("This is a debug message.");
	        yhu.info("This is an info message.");
	        yhu.error("This is an error message.");
	    }
}
