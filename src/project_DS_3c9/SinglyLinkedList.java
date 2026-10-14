package project_DS_3c9;


// 5. كلاس SinglyLinkedList
public class SinglyLinkedList<E> {

    //---------------------------- Nested Class Node ----------------------------------
    static class Node<E> {

        private E element; // reference to the element stored at this node
        private Node<E> next; // reference to the subsequent node in the list

        public Node(E e, Node<E> n) {
            element = e;
            next = n;
        }

        public E getElement() {
            return element;
        }

        public Node<E> getNext() {
            return next;
        }

        public void setNext(Node<E> n) {
            next = n;
        }

        public void setElement(E element) {
            this.element = element;
        }
    } // End of Nested Class Node
    //---------------------------------------------------------------------------

    private Node<E> head; // head node of the list (or null if empty)
    private Node<E> tail; // last node of the list (or null if empty)
    private int size; // number of nodes in the list

    public SinglyLinkedList() { // constructs an initially empty list
        head = null;
        tail = null;
        size = 0;
    }

    // access methods
    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void addFirst(E e) { // adds element e to the front of the list
        Node<E> newest = new Node<>(e, null); // create and link a new node
        newest.setNext(head);
        head = newest;
        if (size == 0) {
            tail = head; // special case: new node becomes tail also
        }
        size++;
    }

    // دالة لاسترجاع العنصر بناءً على الموقع المحدد
    public E get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index out of bounds: " + index);
        }
        Node<E> current = head;
        for (int i = 0; i < index; i++) {
            current = current.getNext();
        }
        return current.getElement();
    }

    //---------------------------- Appointment Methods ----------------------------
    private AppointmentNode headAppointment; // head node for appointments

    private static class AppointmentNode {

        Appointment data;
        AppointmentNode next;

        AppointmentNode(Appointment data) {
            this.data = data;
            this.next = null;
        }
    }

    // إضافة موعد إلى القائمة مع التحقق من عدم تكرار الوقت
    public void addAppointment(Appointment appointment) {
        AppointmentNode current = headAppointment;
        // التحقق من تكرار الموعد
        while (current != null) {
            if (current.data.getDateTime().equals(appointment.getDateTime())
                    && current.data.getDoctor().equals(appointment.getDoctor())) {
                System.out.println("Error: This doctor is already booked at " + appointment.getDateTime());
                return; // لا يمكن إضافة الموعد، لأنه موجود بالفعل
            }
            current = current.next;
        }

        // إضافة الموعد لأنه غير موجود
        AppointmentNode newNode = new AppointmentNode(appointment);
        if (headAppointment == null) {
            headAppointment = newNode;
        } else {
            current = headAppointment;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
        System.out.println("Appointment added for " + appointment.getPatient().getName() + " at " + appointment.getDateTime());
    }

    // إزالة آخر موعد من القائمة
    public void removeLastAppointment() {
        if (headAppointment == null) {
            System.out.println("No appointments to remove.");
            return;
        }
        if (headAppointment.next == null) {
            headAppointment = null;
            System.out.println("Last appointment removed.");
            return;
        }

        AppointmentNode current = headAppointment;
        while (current.next.next != null) {
            current = current.next;
        }
        current.next = null;
        System.out.println("Last appointment removed.");
    }

    // عرض جميع المواعيد
    public void displayAppointments() {
        if (headAppointment == null) {
            System.out.println("No appointments.");
            return;
        }

        AppointmentNode current = headAppointment;
        System.out.println("Appointments:");
        while (current != null) {
            System.out.println("- " + current.data.getPatient().getName() + " at " + current.data.getDateTime());
            current = current.next;
        }
    }
}