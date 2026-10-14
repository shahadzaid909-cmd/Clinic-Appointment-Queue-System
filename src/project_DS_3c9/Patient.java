
package project_DS_3c9;

// 2. كلاس Patient
public class Patient extends Person {
    public Patient(String name, String id) {
        super(name, id);
    }

    @Override
    public String toString() {
        return "Patient: " + getName() + ", ID: " + getId();
    }
}
