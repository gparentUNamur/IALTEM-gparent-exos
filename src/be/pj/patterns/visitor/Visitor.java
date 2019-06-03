package be.pj.patterns.visitor;

import be.pj.patterns.visitor.visitable.FlatBuilding;
import be.pj.patterns.visitor.visitable.House;
import be.pj.patterns.visitor.visitable.Store;
import be.pj.patterns.visitor.visitable.Street;

public interface Visitor {
    void visitFlatBuilding(FlatBuilding f);

    void visitHouse(House h);

    void visitStore(Store s);

    void visitStreet(Street s);
}
