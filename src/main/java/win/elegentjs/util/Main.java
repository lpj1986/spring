package win.elegentjs.util;

public class Main {

    public static void main(String[] args) {
        String a = "1234asdf12_)12341**";

        a = a.substring(a.indexOf(")"), 14);

        System.out.println(a);
    }
}
