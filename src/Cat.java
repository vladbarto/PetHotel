public class Cat extends Animal implements CatActions{
    public String varsta;  //matura, junior

    public Cat(String nume, String checkInDate, String checkOutDate, String apartinator, String varsta) {
        super(nume, checkInDate, checkOutDate, apartinator);
        this.varsta = varsta;///TODO: throw error nu e pisica matura sau junior
    }

    public String getVarsta() {
        return varsta;
    }

    public void drinkMilk() {
        System.out.println(getNume()+"["+getClass().getName()+"]");
        System.out.println("Sip, sip, sip, meow, ce bun e laptele de bivolita!");
    }

    public void climb(){
        System.out.println("*scratch, scratch*");
        System.out.println("Hei-hop! I'm up");
    }
    public void dormiPisiceste(){
        System.out.println("Zzz");
        System.out.println("*Si toarce*");
    }
    public void joacaPisiceasca(){
        System.out.println("Meow, purrrr, Jos cu bradul de Craciun!");
    }

    @Override
    public String toString() {
        return "Cat: "+ super.toString() +
                 '\n' +
                " varsta='" + varsta + '\'';
    }
}
