package xyz.volartrix.amethyst.util;

// No this is not a whole custom logger only and abstraction for java.util.logging.Logger since that one sucks

import java.util.logging.Logger;
import java.util.logging.Level;

public class AmLogger {

    private final Logger logger;

    public AmLogger(String sub_ident, Logger parent) {
        String ident = "Amethyst-" + sub_ident;
        this.logger = Logger.getLogger(ident);
        this.logger.setParent(parent);
    }

    public void info(String message) {
        this.logger.log(Level.INFO, message);
    }

    public void warn(String message) {
        this.logger.log(Level.WARNING, message);
    }

    public void error(String message) {
        this.logger.log(Level.SEVERE, message);
    }

    void fatal(String message, Throwable exception) throws Throwable {
        this.logger.log(Level.SEVERE, message);
        throw exception;
    }

}
