public class Chitanta {
    private String checkOutDate;
    private int suma;
    private int nrChitanta;
    private Animal animal;

    public Chitanta(String checkOutDate, int suma, int nrChitanta, Animal animal) {
        this.checkOutDate = checkOutDate;
        this.suma = suma;
        this.nrChitanta = nrChitanta;
        this.animal = animal;
    }

    public String getCheckOutDate() {
        return checkOutDate;
    }

    public int getSuma() {
        return suma;
    }

    public int getNrChitanta() {
        return nrChitanta;
    }


    @Override
    public String toString() {
        String x = (animal.getClass().getName().equals("Cat"))?" [pisica]": " [caine]";
        return "--------------------------------------------------------------------\n"+
                "| Chitanta nr." + nrChitanta + "/2022 \n" +
                "| \n" +
                "| Am primit de la " + animal.getApartinator() + " suma de " + suma + " lei\n"+
                "| reprezentand gazduirea animalului " + animal.getNume() + x + "\n" +
                "| identificat prin id-ul " + animal.getId() + ".\n" +
                "__________________________________________________________________";
    }
}
