package com.transcendence.gangoffour.main;

import com.transcendence.gangoffour.behavioral.MainBehavioralActivity;
import com.transcendence.gangoffour.creational.MainCreationalActivity;
import com.transcendence.gangoffour.creational.singleton.MainSingletonActivity;
import com.transcendence.gangoffour.creational.singleton.SingletonEager;
import com.transcendence.gangoffour.creational.singleton.SingletonLazy;
import com.transcendence.gangoffour.creational.singleton.SingletonLazyStaticInnerClass;
import com.transcendence.gangoffour.creational.singleton.SingletonLazyThreadSafe;
import com.transcendence.gangoffour.structural.MainStructuralActivity;

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
