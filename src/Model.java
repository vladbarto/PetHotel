import java.util.Iterator;

public class Model {
    public static int extractYear(String data){
        char[] traverse = data.toCharArray();
        String result = "";
        int cntSlash = 0;
        for(int i = 0; i < traverse.length; i++)
        {
            if(cntSlash == 2)
                result += traverse[i];
            if(traverse[i] == '/')
                cntSlash++;
        }
        return Integer.parseInt(result);
    }
    public static int extractMonth(String data){
        char[] traverse = data.toCharArray();
        String result = "";
        int cntSlash = 0;
        for(int i = 0; i < traverse.length; i++)
        {
            if(cntSlash == 1 && traverse[i] != '/')
                result += traverse[i];
            if(traverse[i] == '/')
                cntSlash++;
        }
        return Integer.parseInt(result);
    }
    public static int extractDay(String data){
        char[] traverse = data.toCharArray();
        String result = "";
        for(int i = 0; i < traverse.length && traverse[i]!='/'; i++)
        {
            result += traverse[i];
        }
        return Integer.parseInt(result);
    }
    public void LoadData(PetHotel petHotel){
        Animal a1 = new Cat("Fido", "13/09/2022", "20/09/2022", "Iamnitchi Bogdan", "matura");
        Animal a2 = new Dog("Azorel", "14/07/2021", "30/07/2021", "Pop Vasile", "ciobanesc belgian", false);
        Animal a3 = new Cat("Neo", "07/11/2022", "28/12/2022", "Bartolomei Vlad", "junior");
        Animal a4 = new Dog("Tzirmi", "14/07/2021", "30/07/2021", "Cimpean Dalia", "ciobanesc belgian", true);
        Animal a5 = new Cat("Toulouse", "20/05/2022", "27/05/2022", "Gheran Alexia", "junior");
        petHotel.addAnimal( a1 );
        petHotel.addAnimal( a2 );
        petHotel.addAnimal( a3 );
        petHotel.addAnimal( a4 );
        petHotel.addAnimal( a5 );
        Animal a11 = new Cat("Fido", "13/09/2022", "20/09/2022", "Iamnitchi Bogdan", "matura");
        Animal a22 = new Dog("Azorel", "14/07/2021", "30/07/2021", "Pop Vasile", "ciobanesc belgian", false);
        Animal a33 = new Cat("Neo", "07/11/2022", "28/12/2022", "Bartolomei Vlad", "junior");
        Animal a44 = new Dog("Tzirmi", "14/07/2021", "30/07/2021", "Cimpean Dalia", "ciobanesc belgian", true);
        Animal a55 = new Cat("Toulouse", "20/05/2022", "27/05/2022", "Gheran Alexia", "junior");
        petHotel.addAnimal( a11 );
        petHotel.addAnimal( a22 );
        petHotel.addAnimal( a33 );
        petHotel.addAnimal( a44 );
        petHotel.addAnimal( a55 );
    }
    public void cazeazaPisica(PetHotel petHotel, String nume, String owner, String checkIn, String checkOut, String varsta){
        petHotel.addAnimal( new Cat(nume, checkIn, checkOut, owner, varsta) );
    }
    public void cazeazaCaine(PetHotel pethotel, String nume, String owner, String checkIn, String checkout, String rasa, boolean plimbarica){
        pethotel.addAnimal( new Dog(nume, checkIn, checkout, owner, rasa, plimbarica) );
    }
    public static boolean isItSmaller(String a, String b)
    {
        //consideram relatia de ordine a<b, b fiind data mai recenta
        if(extractYear(a) < extractYear(b))
            return true;
        if(extractMonth(a) < extractMonth(b))
            return true;
        if(extractDay(a) < extractDay(b))
            return true;
        return false;
    }
    public void checkOutInTrecut(PetHotel petHotel){
        ///5
        //Vom considera Data curenta (adica reperul) ca fiind 18 Decembrie 2022
        Iterator<Client> ite = petHotel.getCurrentList().iterator();
        while(ite.hasNext()){
            Client curr = ite.next();
            if(isItSmaller(curr.getChitanta().getCheckOutDate(), petHotel.CURRENT_DATE)==true)
                ite.remove();
        }

    }
}
