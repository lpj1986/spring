package win.elegentjs.ioc.factory;

public class Circle implements Shape {

    private String name;


    public Circle(String name) {
        this.name = name;
    }


    @Override
    public String toString() {
        return "Circle{" +
                "name='" + name + '\'' +
                '}';
    }
}
