package project_DS_3c9;
import java.util.Scanner;

public class Main {
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        LLQueue clinicQueue = new LLQueue(); // قائمة الانتظار للعيادة
        SinglyLinkedList appointmentList = new SinglyLinkedList(); // قائمة المواعيد للعيادة
        Clinic clinic = new Clinic(); // كائن من كلاس Clinic

        showMenu(clinicQueue, appointmentList, clinic); // عرض القائمة الرئيسية للنظام
    }

    // عرض القائمة الرئيسية وإدارة الخيارات
    private static void showMenu(LLQueue clinicQueue, SinglyLinkedList appointmentList, Clinic clinic) {
        System.out.println("\nWelcome to the Clinic System");
        System.out.println("\n-----------------------------");
        while (true) {
            
            System.out.println("1. Add a new appointment");
            System.out.println("2. Remove the last appointment");
            System.out.println("3. View all appointments");
            System.out.println("4. Add a patient to the waiting list");
            System.out.println("5. Serve the next patient");
            System.out.println("6. View the waiting list");
            System.out.println("7. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // استهلاك السطر الجديد

            switch (choice) {
                case 1:
                    addAppointment(appointmentList, clinic); // إضافة موعد جديد
                    break;
                case 2:
                    appointmentList.removeLastAppointment(); // حذف آخر موعد من القائمة
                    break;
                case 3:
                    appointmentList.displayAppointments(); // عرض جميع المواعيد
                    break;
                case 4:
                    addPatientToWaitingList(clinicQueue); // إضافة مريض إلى قائمة الانتظار
                    break;
                case 5:
                    clinicQueue.serveNextPatient(); // خدمة المريض التالي في قائمة الانتظار
                    break;
                case 6:
                    clinicQueue.displayWaitingList(); // عرض جميع المرضى في قائمة الانتظار
                    break;
                case 7:
                    System.out.println("Exiting...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    // إضافة موعد جديد
    private static void addAppointment(SinglyLinkedList appointmentList, Clinic clinic) {
        System.out.println("Enter patient details:");

        System.out.print("Enter name: ");
        String name = scanner.nextLine();
        System.out.print("Enter ID: ");
        String id = scanner.nextLine();
        Patient patient = new Patient(name, id); // إنشاء كائن للمريض

        // عرض الخدمات المتاحة (العيادات)
        System.out.println("Available Services (Departments):");
        SinglyLinkedList<String> services = clinic.getServices(); // استخدام كلاس Clinic للحصول على الخدمات
        for (int i = 0; i < services.size(); i++) {
            System.out.println((i + 1) + ". " + services.get(i));
        }

        System.out.print("Choose a service : ");
        int serviceChoice = scanner.nextInt();
        scanner.nextLine(); // استهلاك السطر الجديد

        if (serviceChoice < 1 || serviceChoice > services.size()) {
            System.out.println("Invalid service choice.");
            return;
        }

        // عرض الأطباء بناءً على الخدمة المختارة
        String[] doctors = getDoctorsForService(serviceChoice);
        System.out.println("Available Doctors:");
        for (int i = 0; i < doctors.length; i++) {
            System.out.println((i + 1) + ". " + doctors[i]);
        }

        System.out.print("Choose a doctor : ");
        int doctorChoice = scanner.nextInt();
        scanner.nextLine(); // استهلاك السطر الجديد

        if (doctorChoice < 1 || doctorChoice > doctors.length) {
            System.out.println("Invalid doctor choice.");
            return;
        }

        // اختيار وقت الموعد
        System.out.print("Enter appointment time (e.g., 8:00 AM): ");
        String dateTime = scanner.nextLine();

        // التحقق مما إذا كان الموعد محجوزًا مسبقًا
        if (isAppointmentTimeTaken(dateTime, appointmentList)) {
            System.out.println("The selected time is already taken. Please choose a different time.");
            return; // العودة لتحديد الوقت من جديد
        }

        // إنشاء الموعد مع الطبيب والعيادة المختارة
        String doctor = doctors[doctorChoice - 1];
        String service = services.get(serviceChoice - 1);

        Appointment appointment = new Appointment(patient, dateTime, doctor, service);
        appointmentList.addAppointment(appointment); // إضافة الموعد إلى قائمة المواعيد
    }

    // إرجاع قائمة الأطباء بناءً على الخدمة المختارة
    private static String[] getDoctorsForService(int serviceChoice) {
        String[][] doctors = {
            {"Dr. Ahmed", "Dr. Mona", "Dr. Kareem"}, // أطباء العيادة 1 (General Checkup)
            {"Dr. Sara", "Dr. Layla", "Dr. Ali"}, // أطباء العيادة 2 (Pediatric Care)
            {"Dr. Omar", "Dr. Nader", "Dr. Rania"} // أطباء العيادة 3 (Emergency Services)
        };

        // إرجاع الأطباء بناءً على اختيار الخدمة
        if (serviceChoice >= 1 && serviceChoice <= doctors.length) {
            return doctors[serviceChoice - 1];
        }
        return new String[0]; // في حال كان الاختيار غير صالح
    }

    // التحقق مما إذا كان الوقت محجوزًا مسبقًا
    private static boolean isAppointmentTimeTaken(String dateTime, SinglyLinkedList appointmentList) {
        for (int i = 0; i < appointmentList.size(); i++) {
            Appointment appointment = (Appointment) appointmentList.get(i);
            if (appointment.getDateTime().equals(dateTime)) {
                return true; // الوقت محجوز
            }
        }
        return false; // الوقت متاح
    }

    // إضافة مريض إلى قائمة الانتظار
    private static void addPatientToWaitingList(LLQueue clinicQueue) {
        System.out.println("Enter patient details for the waiting list:");

        System.out.print("Enter name: ");
        String name = scanner.nextLine();
        System.out.print("Enter ID: ");
        String id = scanner.nextLine();
        Patient patient = new Patient(name, id); // إنشاء كائن للمريض

        clinicQueue.addToWaitingList(patient); // إضافة المريض إلى قائمة الانتظار
    }
}



