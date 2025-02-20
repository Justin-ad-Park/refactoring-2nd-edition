package designpattern.visitor.shape.visitor;

import designpattern.visitor.shape.Circle;
import designpattern.visitor.shape.CompoundShape;
import designpattern.visitor.shape.Dot;
import designpattern.visitor.shape.Rectangle;

public interface Visitor {
    String visitDot(Dot dot);

    String visitCircle(Circle circle);

    String visitRectangle(Rectangle rectangle);

    String visitCompoundGraphic(CompoundShape cg);
}