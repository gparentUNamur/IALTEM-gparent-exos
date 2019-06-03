package be.pj.patterns.visitor.visitable;

import be.pj.patterns.visitor.Visitor;

public class House extends Building {
    public House(int id, int gazLevel, int waterLevel, int electricLevel) {
        super(id, gazLevel, waterLevel, electricLevel);
        this.type = "House";
    }


    @Override
    public void accept(Visitor v) {
        v.visitHouse(this);
    }
}
