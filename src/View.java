import java.util.Scanner;

public class View {
    public static void main(String[] args) throws Exception {
        System.out.println("~~~Bine ati venit la PetHotel~~~");
        System.out.println("Pentru ajutor, type -h in consola");
        Controller controller = new Controller();
        Scanner in = new Scanner(System.in);
        System.out.print(">");
        String textConsola = in.nextLine();
        do{
            switch(textConsola){
                case "-h": {
                    System.out.println("Pentru a opri executia programului, type stop in consola");
                    System.out.println("Meniu capabilitati:");
                    System.out.println("-> 1. Incarca niste animale hardcodate in aplicatie");
                    System.out.println("-> 2. Cazeaza animal");
                    System.out.println("-> 3. Vezi animalele cazate in functie de data in care au fost cazate");
                    System.out.println("-> 4. Afiseaza chitantele care contin sume mai mari de 200 lei si animalele asociate acestora");
                    System.out.println("-> 5. Daca data de plecare a oricarui animal e in trecut, sa se elimine din registrul curent");
                    System.out.println("-> 6. Simulare joaca a pisicilor Junior");
                    System.out.println("-> 7. Simulare dresat caini care nu trebuie plimbati zilnic");
                    System.out.println("-> 8. Vezi lista de asteptare");
                    System.out.println("-> 9. Elimina din lista de asteptare clientii cu chitanta mai mica de 50 lei");
                    System.out.print(">");
                }
                break;
                case "1": controller.LoadData();
                    System.out.println("Date hardcodate incarcate cu succes");
                    System.out.print(">");
                break;
                case "2":controller.cazeazaAnimal();
                    System.out.print(">");
                    break;
                case "3": controller.displayCurrentList();
                    System.out.print(">");
                    break;
                case "4": controller.chitantePeste200();
                    System.out.print(">");
                    break;
                case "5": controller.checkOutInTrecut();
                    System.out.print(">");
                    break;
                case "6": controller.joacaPisiciJunior();
                    System.out.print(">");
                    break;
                case "7": controller.dreseazaCainiNepretentiosi();
                    System.out.print(">");
                    break;
                case "8": controller.displayWaitingList();
                    System.out.print(">");
                    break;
                case "9":controller.chitanteSub50();
                    System.out.print(">");
                    break;
                default:
                    System.out.println("Ceva comanda nu ai introdus bine in consola. Try again");
                    System.out.print(">");
            }
            textConsola = in.nextLine();
        }while(!textConsola.equals("stop"));

    }
}
