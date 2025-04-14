package com.transcendence.gangoffour._01_creational.factory.abstractfactory;

import com.transcendence.gangoffour.log.LogUtils;

public class WindowsOS implements OperatingSystem {
    @Override
    public void run() {
        LogUtils.d("Running Windows OS");
    }
}
