package designpattern.visitor.shape;

import designpattern.visitor.shape.visitor.Visitor;

public interface Shape {
    void move(int x, int y);
    void draw();
    String accept(Visitor visitor);
}