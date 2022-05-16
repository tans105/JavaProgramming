package competitiveProgramming.others.practise;

import java.util.ArrayList;
import java.util.List;

public class Shape {
    private String type;
    private String color;

    public Shape(String type, String color) {
        this.type = type;
        this.color = color;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getColor() {
        return color;
    }

    @Override
    public String toString() {
        return "Shape{" +
                "type='" + type + '\'' +
                ", color='" + color + '\'' +
                '}';
    }

    public void setColor(String color) {
        this.color = color;
    }

    protected Object cloneShape() {
        return new Shape(this.type, this.color);
    }

    public static void main(String[] args) {
        List<Shape> shapes = new ArrayList<>();
        shapes.add(new Shape("Circle", "Red"));
        shapes.add(new Shape("Square", "Blue"));
        shapes.add(new Shape("Circle", "Yellow"));

        Shape clonedShape = (Shape) shapes.get(0).cloneShape();
        shapes.add(clonedShape);
        System.out.println(shapes);
    }
}
