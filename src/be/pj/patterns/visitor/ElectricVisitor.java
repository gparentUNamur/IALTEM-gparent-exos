package be.pj.patterns.visitor;

import be.pj.patterns.visitor.visitable.*;

public class ElectricVisitor implements Visitor {

    @Override
    public void visitFlatBuilding(FlatBuilding f) {
        System.out.printf("Electric level in %s n°%d is %d\n", f.getType(), f.getId(), f.getElectricLevel());
    }

    @Override
    public void visitHouse(House h) {
        System.out.printf("Electric level in %s n°%d is %d\n", h.getType(), h.getId(), h.getElectricLevel());
    }

    @Override
    public void visitStore(Store s) {
        System.out.printf("Electric level in %s n°%d is %d\n", s.getType(), s.getId(), s.getElectricLevel());
    }

    @Override
    public void visitStreet(Street s) {
        for (Building b : s.getBuildings()) {
            b.accept(this);
        }
    }
}
