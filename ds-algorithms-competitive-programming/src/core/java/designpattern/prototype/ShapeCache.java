package core.java.designpattern.prototype;

import competitiveProgramming.leetcode.LRUCache;
import core.java.designpattern.prototype.shapes.Circle;
import core.java.designpattern.prototype.shapes.Shape;
import core.java.designpattern.prototype.shapes.Square;

import java.util.Map;

public class ShapeCache {
    private Map<String, Shape> shapeMap;

    public void loadCache() {
        Circle circle = new Circle();
        circle.setId("1");
        shapeMap.put(circle.getId(),circle);

        Square square = new Square();
        square.setId("2");
        shapeMap.put(square.getId(),square);

    }

    public Shape getShape(String shapeId) {
        Shape cachedShape = shapeMap.get(shapeId);
        return (Shape) cachedShape.clone();
    }
}
