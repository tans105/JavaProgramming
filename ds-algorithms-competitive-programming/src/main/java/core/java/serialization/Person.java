package core.java.serialization;

import java.io.Serializable;

public class Person implements Serializable {

    //the serialVersionUID uniquely identify the serialized class. The value of it should match at the time of reading the serialized object.
    private static final long serialVersionUID = 4801633306273802062L;

    private transient int id; //transient will prevent id to get serialized.
    private String name;
    private static int count;//static values are not serialized because they are class level and there is no need to serialize them.

    public Person(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public static int getCount() {
        return count;
    }

    public static void setCount(int count) {
        Person.count = count;
    }

    @Override
    public String toString() {
        return "Person [id=" + id + ", name=" + name + "]" + " Count: " + count;
    }
}
