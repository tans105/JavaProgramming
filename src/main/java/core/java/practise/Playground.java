package core.java.practise;

public class Playground {
    public static void main(String[] args) {
        Parent p = new Parent("Tanmay");
    }

}

class Parent {
    String name;

    {
        System.out.println("Closure Parent");
    }

    static {
        System.out.println("Init Parent");
    }

    public Parent(String name) {
        System.out.println("Parent cons");
        this.name = name;
    }
}

class Child extends Parent {
    String name;

    {
        System.out.println("Closure Child");
    }

    static {
        System.out.println("Init Child");
    }

    public Child(String name) {
        super(name);
        System.out.println("Parent cons");
    }
}