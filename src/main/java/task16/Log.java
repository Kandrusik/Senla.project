package task16;

import org.apache.log4j.Logger;

public class Log {

    private static final Logger log = Logger.getLogger(Log.class);

    public static void info(String message) {
        log.info(message);
    }

}
