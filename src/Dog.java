public class Dog extends Animal implements DogActions{
    private String rasa;
    private boolean trebuiePlimbatZilnic;

    public Dog(String nume, String checkInDate, String checkOutDate, String apartinator, String rasa, boolean dailyStroll) {
        super(nume, checkInDate, checkOutDate, apartinator);
        this.rasa = rasa;
        trebuiePlimbatZilnic = dailyStroll;
    }

    public boolean isTrebuiePlimbatZilnic() {
        return trebuiePlimbatZilnic;
    }

    public void aport(){
        System.out.println("Ui, mamaaa, bat zvarlit!");
        System.out.println("AI DE CAPATUL SATULUI, fug dupa el pana in capatul satului");
        System.out.println("Repede, repede, sa nu il pierd");
        System.out.println("Ni-l-ai");
        System.out.println("Ia sa il aduc eu inapoi la stapan. Ioi, ce-o sa se bucure!");
    }
    public void fiDresat(){
        System.out.println("Sezi! No bine, sed.");
    }
    public void dormiCaineste(){
        System.out.println("Zzz");
        System.out.println("*Viseaza cum prinde un mat de coada*");//mâț
    }
    public void joacaCaineasca(){
        System.out.println("woof, woof! Vreau sa fug in toate directiiiiile!");
    }

    @Override
    public String toString() {
        return "Dog:" + super.toString() +
                "\n rasa='" + rasa + '\'' +
                ",\n trebuiePlimbatZilnic=" + trebuiePlimbatZilnic;
    }
}
