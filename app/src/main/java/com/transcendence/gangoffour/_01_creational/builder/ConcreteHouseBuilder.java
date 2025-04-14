package com.transcendence.gangoffour._01_creational.builder;

public class ConcreteHouseBuilder extends HouseBuilder {
    @Override
    public void buildFoundation() {
        house.setFoundation("Standard Concrete Foundation");
    }

    @Override
    public void buildStructure() {
        house.setStructure("Wooden Structure");
    }

    @Override
    public void buildRoof() {
        house.setRoof("Asphalt Shingle Roof");
    }

    @Override
    public void buildInterior() {
        house.setInterior("Basic Drywall Interior");
    }
}
