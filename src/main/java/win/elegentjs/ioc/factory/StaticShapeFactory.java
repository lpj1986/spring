package win.elegentjs.ioc.factory;

public class StaticShapeFactory {

    public static Shape getInstance(String name) {
        return new Circle(name);
    }
}
