package helpers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LoggerHelper {

    private static boolean root = false;

    public static Logger getLogger(Class<?> cls) {
        if (root) {
            return LoggerFactory.getLogger(cls);
        }
        // SLF4J with Logback automatically finds the configuration file.
        // No need for explicit configuration.
        root = true;
        return LoggerFactory.getLogger(cls);
    }

    public static void main(String[] args) {
        Logger log = LoggerHelper.getLogger(LoggerHelper.class);
        log.info("I am test");
        log.info("I am test");
        log.info("I am test");
    }
}