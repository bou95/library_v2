package com.library.config;

public class JavaMailSenderUtil {
    static String HOST;
    public static void setHOST(String HOST) {
        JavaMailSenderUtil.HOST = HOST;
    }

    static Integer PORT;
    public static void setPORT(Integer PORT) {
        JavaMailSenderUtil.PORT = PORT;
    }

    static String USERNAME;
    public static void setUSERNAME(String USERNAME) {
        JavaMailSenderUtil.USERNAME = USERNAME;
    }

    static String PASSWORD;
    public static void setPASSWORD(String PASSWORD) {
        JavaMailSenderUtil.PASSWORD = PASSWORD;
    }
}
