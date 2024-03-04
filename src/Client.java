public class Client {
    private String numeComplet;
    private Animal animal;
    private Chitanta chitanta;

    public Client(Animal animal, Chitanta chitanta) {
        numeComplet = animal.getApartinator();
        this.animal = animal;
        this.chitanta = chitanta;
    }

    public String getNumeComplet() {
        return numeComplet;
    }

    public Animal getAnimal() {
        return animal;
    }

    public Chitanta getChitanta() {
        return chitanta;
    }
}
