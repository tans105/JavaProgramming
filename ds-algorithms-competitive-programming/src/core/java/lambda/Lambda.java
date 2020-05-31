package core.java.lambda;

public class Lambda {
    public static void main(String[] args) {
        A lam = () -> System.out.println("Hello");
    }
}

interface A {
    void show();
}
