
package project_DS_3c9;

 // 6. كلاس LLQueue
   public class LLQueue {
    private Node front;
    private Node rear;

    private static class Node {
        Patient data;
        Node next;

        Node(Patient data) {
            this.data = data;
            this.next = null;
        }
    }

    // إضافة مريض إلى قائمة الانتظار
    public void addToWaitingList(Patient patient) {
        Node newNode = new Node(patient);
        if (rear == null) {
            front = rear = newNode;
        } else {
            rear.next = newNode;
            rear = newNode;
        }
        System.out.println("Patient added to waiting list: " + patient.getName());
    }

    // تقديم الخدمة للمريض التالي
    public void serveNextPatient() {
        if (front == null) {
            System.out.println("No patients in the waiting list.");
            return;
        }

        System.out.println("Serving patient: " + front.data.getName());
        front = front.next;

        if (front == null) {
            rear = null;
        }
    }

    // عرض جميع المرضى في قائمة الانتظار
    public void displayWaitingList() {
        if (front == null) {
            System.out.println("Waiting list is empty.");
            return;
        }

        Node current = front;
        System.out.println("Patients in waiting list:");
        while (current != null) {
            System.out.println("- " + current.data.getName());
            current = current.next;
        }
    }
}
