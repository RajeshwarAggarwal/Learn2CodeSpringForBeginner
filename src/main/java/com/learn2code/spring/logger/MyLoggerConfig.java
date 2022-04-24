package com.learn2code.spring.logger;

import com.sun.org.apache.xerces.internal.impl.xpath.XPath;
import org.apache.commons.logging.Log;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.Console;
import java.util.logging.ConsoleHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class MyLoggerConfig {

    private String rootLoggerLevel;
    private String printedLoggerLevel;

    public void setRootLoggerLevel(String rootLoggerLevel) {
        this.rootLoggerLevel = rootLoggerLevel;
    }

    public void setPrintedLoggerLevel(String printedLoggerLevel) {
        this.printedLoggerLevel = printedLoggerLevel;
    }

    public void initLogger(){
        // parse level

        Level rootLevel = Level.parse(rootLoggerLevel);
        Level printedLevel = Level.parse(printedLoggerLevel);

        // get logger for application context
        Logger applicationContextLogger = Logger.getLogger(ClassPathXmlApplicationContext.class.getName());

        // get Parent Logger
        Logger loggerParent = applicationContextLogger.getParent();

        //set the root logging level.
        loggerParent.setLevel(rootLevel);

        //setup console handler
        ConsoleHandler consoleHandler= new ConsoleHandler();
        consoleHandler.setLevel(printedLevel);
        consoleHandler.setFormatter(new SimpleFormatter());

        // add handler to the logger
        loggerParent.addHandler(consoleHandler);

    }
}

