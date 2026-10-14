
package project_DS_3c9;

// 1. كلاس Person
public class Person {
    protected String name;
    protected String id;

    public Person(String name, String id) {
        this.name = name;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public String getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Name: " + name + ", ID: " + id;
    }
}





