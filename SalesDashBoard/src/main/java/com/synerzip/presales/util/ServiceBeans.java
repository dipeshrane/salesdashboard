package com.synerzip.presales.util;


public enum ServiceBeans {
    UserService("userService");

    private String beanName;

    private ServiceBeans(String beanName) {
        this.beanName = beanName;
    }

    public String getBeanName() {
        return beanName;
    }
}