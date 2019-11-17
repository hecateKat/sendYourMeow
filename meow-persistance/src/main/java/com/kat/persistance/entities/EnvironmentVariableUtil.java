package com.kat.persistance.entities;

public class EnvironmentVariableUtil {

    public static String getVariable(String key) {
        return System.getenv(key.replace(".", "_"));
    }


}
