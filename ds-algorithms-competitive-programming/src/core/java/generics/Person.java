package core.java.generics;

public class Person<T1, T2> {
    private T1 name;

    public T1 getName() {
        return name;
    }

    public void setName(T1 name) {
        this.name = name;
    }

    public T2 getId() {
        return id;
    }

    public void setId(T2 id) {
        this.id = id;
    }

    private T2 id;

    Person(T1 name, T2 id) {
        this.name = name;
        this.id = id;
    }

    private <V extends Number, T> void display(V v, T t) {
        System.out.println(v.getClass().getName());
        System.out.println(t.getClass().getName());
    }

    private <V, T> void display(V v, T t) {
        System.out.println(v.getClass().getName());
        System.out.println(t.getClass().getName());
    }

    public String toString() {
        return "NAME: " + name.getClass() + " " + " ID: " + id.getClass();
    }

    public static void main(String[] args) {
        Person<String, Integer> person = new Person<>("Tanmay", 1);
        System.out.println(person);
        person.display(1, new String("S"));
    }
}
