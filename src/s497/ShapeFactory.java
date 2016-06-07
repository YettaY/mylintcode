package s497;

/**
 * Created by Administrator on 2016/5/24.
 */
interface Shape {
    void draw();
}
class Rectangle implements Shape {
    public void draw(){
        System.out.println(" ---- ");
        System.out.println("|    |");
        System.out.println(" ---- ");
    }
}

class  Triangle implements Shape {
    public void draw(){
        System.out.println("  /\\");
        System.out.println(" /  \\");
        System.out.println("/____\\");
    }
}

class Square implements Shape {
    public void draw(){
        System.out.println(" ---- ");
        System.out.println("|    |");
        System.out.println("|    |");
        System.out.println(" ---- ");
    }
}
public class ShapeFactory {
    public Shape getShape(String shapeType) {
        if (shapeType==null)
            return null;
        if (shapeType.equals("Rectangle"))
            return new Rectangle();
        else if (shapeType.equals("Square"))
            return new Square();
        else if (shapeType.equals("Triangle"))
            return new Triangle();
        return null;
    }
}
