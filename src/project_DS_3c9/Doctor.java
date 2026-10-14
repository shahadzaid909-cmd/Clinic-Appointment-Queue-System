
package project_DS_3c9;

// 3. كلاس Doctor
public class Doctor extends Person {
    private String specialty;

    public Doctor(String name, String id, String specialty) {
        super(name, id);
        this.specialty = specialty;
    }

    public String getSpecialty() {
        return specialty;
    }

    @Override
    public String toString() {
        return "Doctor: " + getName() + ", ID: " + getId() + ", Specialty: " + specialty;
    }
}
