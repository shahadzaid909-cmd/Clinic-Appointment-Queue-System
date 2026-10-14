
package project_DS_3c9;


public class Appointment {
    private Patient patient;
    private String dateTime;
    private String doctor;
    private String service;

    // منشئ الكلاس
    public Appointment(Patient patient, String dateTime, String doctor, String service) {
        this.patient = patient;
        this.dateTime = dateTime;
        this.doctor = doctor;
        this.service = service;
    }

    // دالة getDoctor() للحصول على الطبيب
    public String getDoctor() {
        return doctor;
    }

    public Patient getPatient() {
        return patient;
    }

    public String getDateTime() {
        return dateTime;
    }

    public String getService() {
        return service;
    }
}

