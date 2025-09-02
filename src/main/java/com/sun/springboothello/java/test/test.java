package com.sun.springboothello.java.test;

/**
 * @author sun.yang
 * @version 1.0
 * @description: TODO
 * @date 2025/8/30 22:49
 */
public class test {

    public static final String USER_KEY_PREFIX = "user:";
    public static final String USER_INFO_KEY = USER_KEY_PREFIX + "info:%s"; // user:info:{userId}
    public static final String USER_TOKEN_KEY = USER_KEY_PREFIX + "token:%s"; // user:token:{token}
    public static final String USER_LOCK_KEY = USER_KEY_PREFIX + "lock:%s"; // user:lock:{userId}

    /**
     * 工具方法：格式化 Key
     * @param pattern 模式，如 USER_INFO_KEY
     * @param args 参数，如 userId
     * @return 格式化后的完整 Key
     */
    public static String format(String pattern, Object... args) {
        return String.format(pattern, args);
    }


    public static void main(String[] args) {
        String key = format(USER_INFO_KEY, "123");
        System.out.println(key);
    }
}
