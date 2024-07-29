package com.brady;

import java.util.HashMap;
import java.util.Map;

public class ArgumentParser {
    static Map<String, String> parse(String[] args) {
        Map<String, String> result = new HashMap<>();

        String key = null;

        for (String arg : args) {
            if (arg.startsWith("-")) {
                key = arg.substring(1);
                result.put(key, "");
            } else {
                if (key == null) {
                    throw new IllegalArgumentException("Argument " + arg + " has no key");
                }
                result.put(key, arg);
                key = null;
            }
        }
        return result;
    }
}

