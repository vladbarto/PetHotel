import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

public class PetHotel {
    private static int locuriOcupate = 0;
    public static final int MAX_CAPACITY = 10;
    public static final int TAXA_PENTRU_PISICI = 40;
    public static final int TAXA_PENTRU_CAINI = 230;
    public static final String CURRENT_DATE = "18/12/2022";//vom considera aceasta data curenta, si ca animalele vor sta 7 zile.
    public static int nrDosar = 0;
    private ArrayList<Client> waitingList = new ArrayList<Client>();
    private ArrayList<Client> currentList = new ArrayList<Client>();

    public static int getLocuriOcupate() {
        return locuriOcupate;
    }

    public static void setLocuriOcupate(int locuriOcupate) {
        PetHotel.locuriOcupate = locuriOcupate;
    }

    public static int getNrDosar() {
        return nrDosar;
    }

    public static void setNrDosar(int nrDosar) {
        PetHotel.nrDosar = nrDosar;
    }

    public ArrayList<Client> getWaitingList() {
        return waitingList;
    }

    public void setWaitingList(ArrayList<Client> waitingList) {
        this.waitingList = waitingList;
    }

    public ArrayList<Client> getCurrentList() {
        return currentList;
    }

    public void setCurrentList(ArrayList<Client> currentList) {
        this.currentList = currentList;
    }

    public void addAnimal(Animal pet){
        nrDosar++;//acesta creste oricum
        if(locuriOcupate < MAX_CAPACITY)
        {
            locuriOcupate++;
            if(pet.getCheckInDate() == "NIL" && pet.getCheckOutDate() == "NIL"){
                pet.setCheckInDate(CURRENT_DATE);
                pet.setCheckOutDate("25/12/2022");
            }
            currentList.add( new Client(pet,
                    new Chitanta( pet.getCheckOutDate(),
                            (pet.getClass().getName()=="Cat")?TAXA_PENTRU_PISICI:TAXA_PENTRU_CAINI,
                            nrDosar, pet)
                ));
            pet.setHasChitanta(true);

        }
        else
        {
            pet.setCheckInDate("Still waiting to be checked in");
            pet.setCheckOutDate("TBD");
            waitingList.add( new Client(pet,
                    new Chitanta( pet.getCheckOutDate(),
                            (pet.getClass().getName()=="Cat")?TAXA_PENTRU_PISICI:TAXA_PENTRU_CAINI,
                            nrDosar, pet)
            ));
            pet.setHasChitanta(true);
        }
    }
    public void removeClientFromCurrentRegister(int nrDosar){
        Iterator<Client> ite = currentList.iterator();
        while(ite.hasNext()){
            Client currentObject = ite.next();
            if(currentObject.getChitanta().getNrChitanta() == nrDosar){
                ite.remove();
            }
        }
    }
    public void removeClientFromWaiting(int nrDosar){
        Iterator<Client> ite = waitingList.iterator();
        while(ite.hasNext()){
            Client currentObject = ite.next();
            if(currentObject.getChitanta().getNrChitanta() == nrDosar){
                ite.remove();
            }
        }
    }
    public void printCurrentRegistru (){//TODO: tipRegistru = {"current", "waiting}
        Iterator<Client> ite = currentList.iterator();
        System.out.println("Animalele cazate in hotel:");
        if(locuriOcupate == 0)
            System.out.println("La ora actuala nu avem animale cazate!");
        else{
            while(ite.hasNext()){
                Client curr = ite.next();
                System.out.println(curr.getChitanta().getNrChitanta() + " | "+ curr.getNumeComplet() + "->\n" +
                        curr.getChitanta().toString() + "\n");
            }
        }

    }
    public void printWaitingRegistru (){//TODO: tipRegistru = {"current", "waiting}
        Iterator<Client> ite = waitingList.iterator();
        System.out.println("Lista de asteptare a PetHotel:");
        while(ite.hasNext()){
            Client curr = ite.next();
            System.out.println(curr.getChitanta().getNrChitanta() + " | "+ curr.getNumeComplet() + "->\n" +
                    curr.getChitanta().toString());
        }
    }

}
