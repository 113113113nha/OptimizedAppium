package libraries.utility;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.springframework.util.StopWatch;

public class Common extends Utilities {
    private static boolean debugFlag = true;
    private static StopWatch watch;

    public static void wait(int seconds) {
        try {
            Thread.sleep(seconds * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static Logger log = Logger.getLogger("toLog");
//    public static Logger log = LogManager.getLogger("toLog");

    /**
     * Get logInfo to console
     */
    public static void logInfo(String text) {
        System.out.println("---" + text);
    }

    public static void logDebug(String text) {
        if (debugFlag) {
            System.out.println("---" + text);
        }
    }

    public static void setDebugLog(boolean value) {
        debugFlag = value;
    }

    /**
     *  Create log by Log4J
     */
    public static Logger setLog() {
        PropertyConfigurator.configure(System.getProperty("user.dir") + "/src/main/config/log4j.properties");
        Logger loggert = Logger.getLogger("toLog");
        return loggert;
    }

    public static void log4jInfo(String log) {
        setLog().info(log);
    }

    public static void log4jDebug(String log) {
        setLog().debug(log);
    }

    public static void startTimeWatcher() {
        watch = new StopWatch();
        watch.start();
    }

    public static void stopTimeWatcher() {
        watch.stop();
    }

    public static void showElapsedTimeInMinutes() {
        Common.logInfo(String.format("Total elapsed execution time: %f minutes.", watch.getTotalTimeSeconds() / 60));
    }

    public static final StringBuilder getClassName() {
        StringBuilder name = new StringBuilder(Thread.currentThread().getStackTrace()[2].getClassName());
        return name;
    }

    public static final StringBuilder getMethod() {
        StringBuilder name = new StringBuilder(Thread.currentThread().getStackTrace()[2].getMethodName());
        return name;
    }

}
