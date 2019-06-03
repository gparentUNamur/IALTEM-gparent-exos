package be.pj.patterns.visitor.visitable;

import be.pj.patterns.visitor.Visitor;

public interface Visitable {
    void accept(Visitor v);
}
