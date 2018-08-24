package win.elegentjs.ioc.factory;

public class InstanceShapeFactory {

    public Shape getInstance() {
        return new Circle("hello");
    }
}
