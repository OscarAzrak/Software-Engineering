public class person
{
    // Instance Variables
    String name;
    int age;
 
    // Constructor Declaration of Class
    public person(String nameIn,int ageIn)
    {
        name = nameIn; 
        age = ageIn;
    }
    
    
    //Part of uppgift 3
    public String getName()
    {
        return name;
    }
 
    public int getAge()
    {
        return age;
    }

   
    public String toString()
    {
        return("Name is: " + name + ", Age is: " + age);
    }
 
}