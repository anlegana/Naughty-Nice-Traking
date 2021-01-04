package cis.entity;

import cis.util.CisUtility;

/**
 * Represents a kid that wants presents
 * @author bjmac
 * @since 2-Dec-2020
 */
public class Kid {

    private String name = "";
    private int age;
    private int behaviourRating; //1-Very naughty 10-Very nice

    public void getInformation(){
        //todo Requirement 4-Add validation user input.  User to be continually prompted until valid
       int count=0;
       int a;
       do {
        do { 
        name = CisUtility.getInputString("Name (Must be at least length of two)");
        count=0;
        for (int i=0;i<name.length();i++){
            
        if(Character.isLetter(name.charAt(i))){
        count++;
        }
        }
      
         if (name.equals("Rudolph")) 
         System.out.println(System.lineSeparator() + "Type another name");
        }while( name.equals("Rudolph")   );
       }while(count<2 );
       
        do { 
        age = CisUtility.getInputInt("Age (must be below 16)");
        }while(age>=16);
        
        do{
        do { 
        behaviourRating = CisUtility.getInputInt("How nice was the kid this year? (1-10 where 1==very naughty 10==very nice)");
       }while(behaviourRating>10);
        }while(behaviourRating<1);
      
    }
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    
    
    public int getBehaviourRating() {
        return behaviourRating;
    }

    public void setBehaviourRating(int behaviourRating) {
        this.behaviourRating = behaviourRating;
    }

    public void display(){
         System.out.println(this.toString());
    }
    
    @Override
    public String toString() {
        return  System.lineSeparator()+"--- Kid Details ---"+System.lineSeparator()
             + "- Name: " + name + System.lineSeparator()
             + "- Age: " + age + System.lineSeparator()
             + "- Behaviour Rating: " + behaviourRating + System.lineSeparator()
             + "--------------------" + System.lineSeparator()+ System.lineSeparator();
    }
 
    
    
}
