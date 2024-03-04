public class Animal{
    private String apartinator;
    private String nume;
    private static int id_generat = 0;
    private int id;
    private String checkInDate;
    private String checkOutDate;
    private boolean hasChitanta;

    public Animal(String nume, String apartinator) {
        this.apartinator = apartinator;
        this.nume = nume;
        checkInDate = "NIL";
        checkOutDate = "NIL";
        id_generat++;
        this.id = id_generat;
        this.hasChitanta = false;
    }
    public Animal(String nume, String checkInDate, String checkOutDate, String apartinator) {
        this.apartinator = apartinator;
        this.nume = nume;
        this.checkInDate = checkInDate;
        this.checkOutDate = checkOutDate;
        id_generat++;
        this.id = id_generat;
        this.hasChitanta = false;
    }

    public boolean isHasChitanta() {
        return hasChitanta;
    }

    public void setHasChitanta(boolean hasChitanta) {
        this.hasChitanta = hasChitanta;
    }

    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCheckInDate() {
        return checkInDate;
    }

    public void setCheckInDate(String checkInDate) {
        this.checkInDate = checkInDate;
    }

    public String getCheckOutDate() {
        return checkOutDate;
    }

    public String getApartinator() {
        return apartinator;
    }

    public void setApartinator(String apartinator) {
        this.apartinator = apartinator;
    }

    @Override
    public String toString() {
        return  "nume=" + nume +
                ",\n proprietar =" + apartinator +
                ",\n id=" + id +
                ",\n checkInDate=" + checkInDate +
                ",\n checkOutDate=" + checkOutDate + ",";
    }

    public void setCheckOutDate(String checkOutDate) {
        this.checkOutDate = checkOutDate;

    }

}
