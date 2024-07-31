package prototype;

import java.util.List;
import java.util.ArrayList;

public class Test {
    public List<Shape> cloneShapes(List<Shape> shapes) {
        List<Shape> clonedShapes = new ArrayList<>();
        for (Shape shape : shapes) {
            clonedShapes.add(shape.clone());
        }
        return clonedShapes;

    }
}
