package part_two.Human_fac;

public abstract class human {
    human(){}
    public static human create(String name, String pnr){
        String lastDigit = String.valueOf(pnr.charAt(10));
        human person;
        if (lastDigit.equals("0")){
            person = new nonBinary(name);
        }
        else if (Integer.parseInt(lastDigit)%2 == 0){
            person = new woman(name);
        }
        else {
            person = new man(name);
        }
        return person;
    }
}
