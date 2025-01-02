package com.ex.junitbook.lifecycle;

import lombok.extern.log4j.Log4j2;

@Log4j2
public class ResourceForAllTests {
    private final String resourceName;

    public ResourceForAllTests(String resourceName) {
        this.resourceName = resourceName;
        log.info(resourceName + " from class " + getClass().getSimpleName() + " is initializing.");
    }

    public void close() {
        log.info(resourceName + " from class " + getClass().getSimpleName() + " is closing.");
    }
}
