import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Scanner;

public class Controller {
    Model model = new Model();
    private PetHotel petHotel = new PetHotel();

    public void LoadData(){
        ///1
        model.LoadData(petHotel);
    }

    public void displayCurrentList(){
        ///3
        Collections.sort(petHotel.getCurrentList(), new Comparator<Client>(){
            public int compare(Client c1, Client c2){
                int y1 = Model.extractYear(c1.getAnimal().getCheckInDate());
                int y2 = Model.extractYear(c2.getAnimal().getCheckInDate());
                int m1 = Model.extractMonth(c1.getAnimal().getCheckInDate());
                int m2 = Model.extractMonth(c2.getAnimal().getCheckInDate());
                int d1 = Model.extractDay(c1.getAnimal().getCheckInDate());
                int d2 = Model.extractDay(c2.getAnimal().getCheckInDate());
                if(y1 != y2)
                    return y1-y2;
                else{
                    if(m1 != m2)
                        return m1-m2;
                    else
                        return d1-d2;
                }
            }
        });
        petHotel.printCurrentRegistru();
    }
    public void cazeazaAnimal() throws Exception{
        ///2
        Scanner in = new Scanner(System.in);
        System.out.println("Pasul 1: poti caza \'pisica\' sau \'caine\'");
        String tipAnimal="";
        String numeAnimal="";
        String numeProprietar="";
        String checkIn="";
        String checkOut="";
        boolean inputOK = false;
        while(!inputOK){
            System.out.print(">>");
            try{
                tipAnimal = in.nextLine();
                inputOK = true;
                if(!(tipAnimal.equals("pisica") || tipAnimal.equals("caine")))
                    throw new Exception("ERROR: Tipul animalului neaparat trebuie sa fie pisica sau caine");
            }
            catch(Exception e){
                System.out.println(e.getMessage());
                inputOK = false;
            }
        }
        do{
            System.out.println("Pasul 2: Iata numele animalului pe care vrei sa il cazezi:");
            System.out.print(">>");
            numeAnimal = in.nextLine();
        }while(numeAnimal == "");
        do{
            System.out.println("Pasul 3: Cine este proprietarul animalului?");
            System.out.print(">>");
            numeProprietar = in.nextLine();
        }while(numeProprietar == "");
        do{
            System.out.println("Pasul 4: Check In Date");
            System.out.println("Please, introdu un tip de data valid DD/MM/YYYY, ca nu am facut sa arunce eroare daca introduci prostii");
            System.out.print(">>");
            checkIn = in.nextLine();
        }while(checkIn == "");
        do{
            System.out.println("Pasul 5: Check Out Date");
            System.out.println("Please, introdu un tip de data valid DD/MM/YYYY, ca nu am facut sa arunce eroare daca introduci prostii");
            System.out.print(">>");
            checkOut = in.nextLine();
        }while(checkOut == "");

        if (tipAnimal.equals("pisica")){
            String varstaPisica = "junior";
            inputOK = false;
            while(!inputOK){
                System.out.println("Pasul 6: Introdu varsta pisicii. Sa fie \'matura\' sau \'junior\'");
                System.out.print(">>");
                try{
                    varstaPisica = in.next();
                    inputOK = true;
                    if(!(varstaPisica.equals("matura") || varstaPisica.equals("junior")))
                        throw new Exception("ERROR: Pisica trebuie neaparat sa fie \'matura\' sau \'junior\'");
                }
                catch(Exception e){
                    inputOK = false;
                    System.out.println(e.getMessage());
                }
            }
            System.out.println("Date despre pisica receptionate cu succes");
            model.cazeazaPisica(petHotel, numeAnimal, numeProprietar, checkIn, checkOut, varstaPisica);
        }
        else{
            //automat tipAnimal = caine
            String rasa="";
            do{
                System.out.println("Pasul 6: Introdu rasa cainelui");
                System.out.print(">>");
                rasa = in.nextLine();
            }while(rasa.equals(""));
            boolean tbPlimbat; String input="";
            inputOK = false;
            do {
                System.out.println("Pasul 7: Trebuie plimbat acest caine zilnic? \'y\'/\'n\'");
                System.out.print(">>");
                input = in.nextLine();
                if(input.equals("")==false){
                    if(input.equals("y") == true || input.equals("n")==true)
                        inputOK = true;
                }
            }while(!inputOK);
            tbPlimbat = (input.equals("y"))?true:false;
            System.out.println("Date despre caine receptionate cu succes");
            model.cazeazaCaine(petHotel, numeAnimal, numeProprietar, checkIn, checkOut, rasa, tbPlimbat);
        }
    }
    public void chitantePeste200(){
        ///4
        System.out.println("Acum cazati:");
        Iterator<Client> ite = petHotel.getCurrentList().iterator();
        while(ite.hasNext()){
            Client curr = ite.next();
            if(curr.getChitanta().getSuma() > 200){
                System.out.println(curr.getAnimal().toString() + " cu chitanta:\n" + curr.getChitanta().toString() + "\n\n");
            }
        }
        System.out.println("Pe lista de asteptare");
        ite = petHotel.getWaitingList().iterator();
        while(ite.hasNext()){
            Client curr = ite.next();
            if(curr.getChitanta().getSuma() > 200){
                System.out.println(curr.getAnimal().toString() + " cu chitanta:\n" + curr.getChitanta().toString() + "\n\n");
            }
        }
    }
    public void checkOutInTrecut(){
        ///5
        model.checkOutInTrecut(petHotel);
    }
    public void joacaPisiciJunior(){
        ///6
        Iterator<Client> ite = petHotel.getCurrentList().iterator();
        while(ite.hasNext()){
            Client curr = ite.next();
            if(curr.getAnimal().getClass().getName().equals("Cat") && ((Cat)curr.getAnimal()).getVarsta().equals("junior"))
            {
                System.out.println(curr.getAnimal().getId()+") "+ ((Cat) curr.getAnimal()).getNume());
                ((Cat)curr.getAnimal()).joacaPisiceasca();
            }
        }
    }
    public void dreseazaCainiNepretentiosi(){
        ///7
        Iterator<Client> ite = petHotel.getCurrentList().iterator();
        while(ite.hasNext()){
            Client curr = ite.next();
            if(curr.getAnimal().getClass().getName().equals("Dog") && ((Dog)curr.getAnimal()).isTrebuiePlimbatZilnic() == false)
            {
                System.out.println(curr.getAnimal().getId()+") "+ ((Dog) curr.getAnimal()).getNume());
                ((Dog)curr.getAnimal()).fiDresat();
            }
        }
    }
    public void displayWaitingList(){
        ///8
        if(PetHotel.getLocuriOcupate() < PetHotel.MAX_CAPACITY)
            System.out.println("Nu exista nimeni pe lista de asteptare");
        else
            petHotel.printWaitingRegistru();
    }
    public void chitanteSub50(){
        ///9
        Iterator<Client> ite = petHotel.getWaitingList().iterator();
        while(ite.hasNext()){
            Client curr = ite.next();
            if(curr.getChitanta().getSuma() < 50){
                ite.remove();
            }
        }
    }
}
