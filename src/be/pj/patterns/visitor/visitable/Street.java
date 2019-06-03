package be.pj.patterns.visitor.visitable;

import be.pj.patterns.visitor.Visitor;

import java.util.ArrayList;
import java.util.List;


public class Street implements Visitable {
    List<Building> buildings = new ArrayList<>();


    public void addBuilding(Building b) {
        this.buildings.add(b);
    }

    public List<Building> getBuildings() {
        return buildings;
    }

    @Override
    public void accept(Visitor v) {
        v.visitStreet(this);
    }
}
