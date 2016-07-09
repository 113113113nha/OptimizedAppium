package com.appium.test;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Level;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

/**
 * Created by User on 7/8/2016.
 */
public class Log4J {
    public static void main(String[] args) {
        Logger logger1 = LogManager.getLogger("Logger1");
        Logger logger2 = LogManager.getLogger("Logger2");
        Logger logger3 = LogManager.getLogger("Logger3");

        BasicConfigurator.configure();
//        PropertyConfigurator.configure(System.getProperty("user.dir") + "/src/main/config/log4j.properties");

        logger1.info("This is logger 1");
        logger2.info("This is logger 2");
        logger3.info("This is logger 3");

        Logger logger1_2 = LogManager.getLogger("Logger1");
        Logger logger1_3 = LogManager.getLogger("Logger1");

        //You will see that LogManager doesnt create a new instance of logger
        //Object with name Logger1, instead passes on the reference to the
        //existing Logger1 object. We can confirm this with following lines
        logger1_2.info("The name of logger1_2 is " + logger1_2.getName());

        if (logger1_3.equals(logger1)) {
            logger1_3.info("Both objects are same");
        } else {
            logger1_3.info("Logger1 and logger1_2 are different objects");
        }

        System.out.println("------------------------");
        // Any logger that you create can be traced back to the root logger.
        // As a.b.c will have b as the father and a as the ancestor.
        // -> Root.a.b where Root is the ancestor of b.
        Logger rootLogger = LogManager.getRootLogger();
        Logger rootOfLogger1 = logger1.getRootLogger();

        if (rootOfLogger1.equals(rootLogger)) {
            rootOfLogger1.info("Both rootLogger and rootOfLogger1 are same objects");
            rootOfLogger1.info("The Name of the root logger is " + rootLogger.getName());
        } else {
            rootOfLogger1.info("Both rootLogger and rootOfLogger1 are different objects");
        }

        //set log level of a logger using the Logger.setLevel method
        //higher level will be logged
        logger1.setLevel(Level.DEBUG);

        //INHERITANCE
        // Child and lets say Logger LoggerParent has log level set to LoggerParent.setLevel(Level.WARN) to warn.
        Logger LoggerParent = LogManager.getLogger("LoggerParent");
        Logger LoggerChild = LogManager.getLogger("LoggerParent.Child");
        //Setting up the log level of both loggers
        LoggerParent.setLevel(Level.WARN);
        LoggerParent.trace("This is the trace log - PARENT");
        LoggerParent.debug("This is debug log - PARENT");
        LoggerParent.info("This is info log - PARENT");
        LoggerParent.warn("This is Warn log - PARENT");
        LoggerParent.error("This is error log - PARENT");
        LoggerParent.fatal("This is Fatal log - PARENT");
        LoggerChild.trace("This is the trace log - CHILD");
        LoggerChild.debug("This is debug log - CHILD");
        LoggerChild.info("This is info log - CHILD");
        LoggerChild.warn("This is Warn log - CHILD");
        LoggerChild.error("This is error log - CHILD");
        LoggerChild.fatal("This is Fatal log - CHILD");

        System.out.println("-------------------");
        //Exceptions: This is a very important feature of a Logger class
        //Debug only, this allows us to pass the exception.
        //->  Logger.Debug(Object message, Throwable t)
        try
        {
            // We will get a divide by zero exception her
            int x = 200 / 0;
        }
        catch(Exception e)
        {
            LoggerParent.warn("Following exception was raised", e);
        }
    }
}
