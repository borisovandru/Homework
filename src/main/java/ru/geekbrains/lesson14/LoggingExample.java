package ru.geekbrains.lesson14;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class LoggingExample {
    public static final Logger log = LogManager.getRootLogger();
    //Trace << Debug << Info << Warn << Error << Fatal
    public static void main(String[] args) {

        String s = "Hi hell";
        int a = 100500;

        log.trace("Trace");
        log.debug("debug");
        log.info("{} info {}", a, s);
        log.warn("warn");
        log.error("error");
        log.fatal("fatal");

        new Thread(() -> log.info("Hello world!")).start();

        try {
            throw new Exception("EXCEPTION!!!!");
        } catch (Exception e) {
//            log.error(e);
            log.throwing(e);
        }
    }
}
