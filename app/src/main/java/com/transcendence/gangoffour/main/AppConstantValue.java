package com.transcendence.gangoffour.main;

import com.transcendence.gangoffour._03_behavioral.MainBehavioralActivity;
import com.transcendence.gangoffour._01_creational.MainCreationalActivity;
import com.transcendence.gangoffour._01_creational.singleton.MainSingletonActivity;
import com.transcendence.gangoffour._01_creational.singleton.SingletonEager;
import com.transcendence.gangoffour._01_creational.singleton.SingletonLazy;
import com.transcendence.gangoffour._01_creational.singleton.SingletonLazyStaticInnerClass;
import com.transcendence.gangoffour._01_creational.singleton.SingletonLazyThreadSafe;
import com.transcendence.gangoffour._02_structural.MainStructuralActivity;

public interface AppConstantValue {

    Class[] mainPatterns = {
            MainCreationalActivity.class,
            MainStructuralActivity.class,
            MainBehavioralActivity.class
    };


    Class[] mainPatternsCreational = {
            MainSingletonActivity.class,
            MainStructuralActivity.class,
            MainBehavioralActivity.class
    };

    Class[] mainPatternsCreationalSingleton = {
            SingletonEager.class,
            SingletonLazy.class,
            SingletonLazyThreadSafe.class,
            SingletonLazyStaticInnerClass.class
    };

}
