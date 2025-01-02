package com.ex.junitbook.lifecycle;

import lombok.extern.log4j.Log4j2;

@Log4j2
public class SystemUnderTest {
    private final String systemName;

    public SystemUnderTest(String systemName) {
        this.systemName = systemName;
        log.info(systemName + " from class " + getClass().getSimpleName() + " is initializing.");
    }

    public boolean canReceiveRegularWork() {
        log.info(systemName + " from class " + getClass().getSimpleName() + " can receive regular work.");
        return true;
    }

    public boolean canReceiveAdditionalWork() {
        log.info(systemName + " from class " + getClass().getSimpleName() + " cannot receive additional work.");
        return false;
    }

    public void close() {
        log.info(systemName + " from class " + getClass().getSimpleName() + " is closing.");
    }
}
