package com.transcendence.gangoffour._01_creational.builder;

public abstract class HouseBuilder {

    protected House house = new House();

    public abstract void buildFoundation();
    public abstract void buildStructure();
    public abstract void buildRoof();
    public abstract void buildInterior();

    public House getHouse() {
        return house;
    }

}
