package com.transcendence.gangoffour.main;

import com.transcendence.gangoffour._01_creational.builder.BuilderActivity;
import com.transcendence.gangoffour._01_creational.factory.abstractfactory.AbstractFactoryActivity;
import com.transcendence.gangoffour._01_creational.factory.factorymethod.FactoryMethodShapeActivity;
import com.transcendence.gangoffour._03_behavioral.MainBehavioralActivity;
import com.transcendence.gangoffour._01_creational.CreationalMainActivity;
import com.transcendence.gangoffour._01_creational.singleton.SingletonMainActivity;
import com.transcendence.gangoffour._01_creational.singleton.SingletonEager;
import com.transcendence.gangoffour._01_creational.singleton.SingletonLazy;
import com.transcendence.gangoffour._01_creational.singleton.SingletonLazyStaticInnerClass;
import com.transcendence.gangoffour._01_creational.singleton.SingletonLazyThreadSafe;
import com.transcendence.gangoffour._02_structural.MainStructuralActivity;

public interface AppConstantValue {

    Class[] mainPatterns = {
            CreationalMainActivity.class,
            MainStructuralActivity.class,
            MainBehavioralActivity.class
    };


    Class[] mainPatternsCreational = {
            SingletonMainActivity.class,
            FactoryMethodShapeActivity.class,
            AbstractFactoryActivity.class,
            BuilderActivity.class,
    };

    Class[] mainPatternsCreationalSingleton = {
            SingletonEager.class,
            SingletonLazy.class,
            SingletonLazyThreadSafe.class,
            SingletonLazyStaticInnerClass.class
    };

}
