package com.springbootprojects.myfirstproject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;

public class EnvironmentData {
    private Environment environment;

    @Autowired
    public void setEnvironment(
        Environment environment
    ) {
        this.environment = environment;
    }

    public String getJavaVersion() {
        return environment.getProperty("java.version");
    }

    public String getOsName() {
        return environment.getProperty("os.name");
    }
}
