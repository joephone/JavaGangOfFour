package com.transcendence.gangoffour._01_creational.builder;

public class LuxuryHouseBuilder extends HouseBuilder {
    @Override
    public void buildFoundation() {
        house.setFoundation("Reinforced Concrete Foundation");
    }

    @Override
    public void buildStructure() {
        house.setStructure("Steel Frame Structure");
    }

    @Override
    public void buildRoof() {
        house.setRoof("Slate Tile Roof");
    }

    @Override
    public void buildInterior() {
        house.setInterior("High-End Custom Interior");
    }
}
