public class person3
{
    // Instance Variables
    String name;
    int age;
 
    // Constructor Declaration of Class
    public person3(String nameIn,int ageIn)
    {
        name = nameIn; 
        age = ageIn;
    }
    
    
    //Part of uppgift 3
    public person3()
    {
    	String[] personArray = {"Kristian", "Alperen", "Jakob", "Oscar",
    			"Ayda", "Sabina", "Olga", "Hania", "Bethel", "Mervan"};
		int personIndex = (int)(Math.random()*(personArray.length));
		String randomName = personArray[personIndex];
		
		double ageDecimal = Math.random()*85 + 15;
		int randomAge = (int)ageDecimal;
		
		name = randomName;
		age = randomAge;
    
    }
    // end of uppgift 3
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