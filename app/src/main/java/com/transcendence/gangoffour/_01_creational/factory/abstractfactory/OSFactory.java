package com.transcendence.gangoffour._01_creational.factory.abstractfactory;

public class OSFactory {

    // 根据类型创建操作系统实例
    public static OperatingSystem createOS(String type) {
        switch (type.toLowerCase()) {
            case "windows":
                return new WindowsOS();
            case "linux":
                return new LinuxOS();
            default:
                throw new IllegalArgumentException("Unknown OS type: " + type);
        }
    }

}
