package be.pj.patterns.visitor.visitable;

import be.pj.patterns.visitor.Visitor;

public class FlatBuilding extends Building {


    public FlatBuilding(int id, int gazLevel, int waterLevel, int electricLevel) {
        super(id, gazLevel, waterLevel, electricLevel);
        this.type = "FlatBuilding";
    }

    @Override
    public void accept(Visitor v) {
        v.visitFlatBuilding(this);
    }
}
