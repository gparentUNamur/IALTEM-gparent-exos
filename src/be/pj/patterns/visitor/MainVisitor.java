package be.pj.patterns.visitor;

import be.pj.patterns.visitor.visitable.FlatBuilding;
import be.pj.patterns.visitor.visitable.House;
import be.pj.patterns.visitor.visitable.Store;
import be.pj.patterns.visitor.visitable.Street;

import java.util.Random;

public class MainVisitor {
    public static void main(String[] args) {
        Street s = streetGenerator(40);

        Visitor v = new GazVisitor();
        v.visitStreet(s);
        Visitor w = new WaterVisitor();
        w.visitStreet(s);
        Visitor e = new ElectricVisitor();
        e.visitStreet(s);
        Visitor c = new CounterVisitor();
        c.visitStreet(s);
    }


    private static Street streetGenerator(int nbOfBuilding) {
        int i = 0;
        Street s = new Street();
        Random r = new Random();
        while (i < nbOfBuilding) {
            if (i % 3 == 0) {
                s.addBuilding(new House(i, Math.abs(r.nextInt() % 1000), Math.abs(r.nextInt() % 1000), Math.abs(r.nextInt() % 1000)));
            } else if (i % 3 == 1) {
                s.addBuilding(new FlatBuilding(i, Math.abs(r.nextInt() % 1000), Math.abs(r.nextInt() % 1000), Math.abs(r.nextInt() % 1000)));
            } else {
                s.addBuilding(new Store(i, Math.abs(r.nextInt() % 1000), Math.abs(r.nextInt() % 1000), Math.abs(r.nextInt() % 1000)));
            }
            i++;
        }
        return s;
    }
}
