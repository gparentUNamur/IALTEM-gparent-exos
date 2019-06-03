package be.pj.patterns.visitor;

import be.pj.patterns.visitor.visitable.*;

public class CounterVisitor implements Visitor {
    private int nbHouse = 0;
    private int nbStore = 0;
    private int nbFlatBuilding = 0;

    @Override
    public void visitFlatBuilding(FlatBuilding f) {
        nbFlatBuilding++;
    }

    @Override
    public void visitHouse(House h) {
        nbHouse++;
    }

    @Override
    public void visitStore(Store s) {
        nbStore++;
    }

    @Override
    public void visitStreet(Street s) {
        for (Building b : s.getBuildings()) {
            b.accept(this);
        }
        System.out.printf("There are %d Houses, %d Stores and %d FlatBuildings\n", nbHouse, nbStore, nbFlatBuilding);
    }
}
