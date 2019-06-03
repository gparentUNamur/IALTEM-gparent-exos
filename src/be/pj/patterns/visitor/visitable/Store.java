package be.pj.patterns.visitor.visitable;

import be.pj.patterns.visitor.Visitor;

public class Store extends Building {
    public Store(int id, int gazLevel, int waterLevel, int electricLevel) {
        super(id, gazLevel, waterLevel, electricLevel);
        this.type = "Store";
    }

    @Override
    public void accept(Visitor v) {
        v.visitStore(this);
    }
}
