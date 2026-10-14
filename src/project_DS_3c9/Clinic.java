
package project_DS_3c9;


// 7. كلاس Clinic
public class Clinic {
   
    private SinglyLinkedList services = new SinglyLinkedList <>();

    public Clinic() {
        services.addFirst("General Checkup");
        services.addFirst("Pediatric Care");
        services.addFirst("Emergency Services");
    }
    
    public SinglyLinkedList<String> getServices() {
    return services;
}

}


 


