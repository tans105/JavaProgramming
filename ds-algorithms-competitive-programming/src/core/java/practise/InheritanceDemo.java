package core.java.practise;

public class InheritanceDemo {
    public static void main(String[] args) {
        A a = new A();
        System.out.println("----------------");
        B c = new A();
        System.out.println("----------------");
        B b = new B();

        /*
        Output:

        Constructor B called
        Constructor A called
        ----------------
        Constructor B called
        Constructor A called
        ----------------
        Constructor B called

         */
    }
}

class A extends B {
    A() {
        System.out.println("Constructor A called");
    }
}

class B {
    B() {
        System.out.println("Constructor B called");
    }
}
