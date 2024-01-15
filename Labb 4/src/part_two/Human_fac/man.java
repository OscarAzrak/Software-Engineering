package part_two.Human_fac;

public class man extends human{
    String name;

    man(String name){
        this.name = name;
    }

    public String toString(){
        return "Jag är man och heter " + name;
    }
}
