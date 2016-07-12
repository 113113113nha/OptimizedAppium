package libraries.mobile;

import com.github.genium_framework.appium.support.server.AppiumServer;
import com.github.genium_framework.server.ServerArguments;
import com.github.genium_framework.server.exception.ServerDirectoryNotFoundException;
import libraries.utility.Common;
import libraries.utility.DataReader;
import libraries.utility.Log;
import org.apache.commons.exec.OS;

import java.io.File;

public class AppiumServerBuilder {
    private AppiumServer appiumServer;
    private File appiumFolder;

    /**
     * Start Appium Server
     */
    public void start(String address, String port) {
        ServerArguments serverArguments = new ServerArguments();
        serverArguments.setArgument("--address", address);
        serverArguments.setArgument("--bootstrap-port", port);
        serverArguments.setArgument("--no-reset", true);
        serverArguments.setArgument("--local-timezone", true);

        if (OS.isFamilyMac()) {
            appiumServer = new AppiumServer(serverArguments);
        } else if (OS.isFamilyWindows()) {
            appiumServer = new AppiumServer(appiumFolder, serverArguments);
        } else {
            Log.info("Don't have option for this Operation");
//            Common.logInfo("Don't have option for this Operation");
        }
        appiumServer.startServer();
        Common.wait(3);
        Log.info("Appium server has been started successfully.");
//        Common.logInfo("Appium server has been started successfully.");
    }

    /**
     * Stop Appium Server
     */
    public void stop() {
        appiumServer.startServer();
        Common.wait(3);
        Log.info("Appium server has been stopped successfully.");
//        Common.logInfo("Appium server has been stopped successfully.");
    }

    public void setAppiumDirectoryOnWindowsOS(String path) {
        File directory = new File(path);
        if (directory.exists()) {
            appiumFolder = directory;
        } else {
            throw new ServerDirectoryNotFoundException();
        }
    }

    public boolean isRunning() {
        return appiumServer.isServerRunning();
    }

}
