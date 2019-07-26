package core.java.serialization;

import java.io.Serializable;

public class Person implements Serializable {

    //the serialVersionUID uniquely identify the serialized class. The value of it should match at the time of reading the serialized object.
    private static final long serialVersionUID = 4801633306273802062L;

    private int id;
    private String name;

    public Person(int id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Person [id=" + id + ", name=" + name + "]";
    }
}
