package be.pj.patterns.visitor;

import be.pj.patterns.visitor.visitable.*;

public class WaterVisitor implements Visitor {
    @Override
    public void visitFlatBuilding(FlatBuilding f) {
        System.out.printf("Water level in %s n°%d is %d\n", f.getType(), f.getId(), f.getWaterLevel());

    }

    @Override
    public void visitHouse(House h) {
        System.out.printf("Water level in %s n°%d is %d\n", h.getType(), h.getId(), h.getWaterLevel());

    }

    @Override
    public void visitStore(Store s) {
        System.out.printf("Water level in %s n°%d is %d\n", s.getType(), s.getId(), s.getWaterLevel());

    }

    @Override
    public void visitStreet(Street s) {
        for (Building b : s.getBuildings()) {
            b.accept(this);
        }
    }
}
