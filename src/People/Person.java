package People;

public class Person implements PersonNode {
    //Forces child classes to have a name and descriptor
    protected String name = "";
    protected String descriptor = "";

    //General constructor
    public Person(){

    }

    //Probably the main constructor we will be using
    public Person(String name, String descriptor){
        this.name = name;
        this.descriptor = descriptor;
    }

    public String getName(){
        return this.name;
    }

    public String getDescriptor(){
        return this.descriptor;
    }

    //Returns in format:
        //  <Name> - <Description>
    //  Unlike the sub-class specific toStrings, this will not blatantly say Doctor or Patient
    @Override
    public String toString() {
        return this.getName() + " - " + this.getDescriptor();
    }

    // Try to set the person's name, if whatever it does breaks then it returns false and prints an error, else it will return true
    public boolean setName(String name){
        try{
            this.name = name;
        }
        catch(Exception e){
            System.out.println(e);
            return false;
        }
        return true;
    }

    // Try to set the person's description, if whatever it does breaks then it returns false and prints an error, else it will return true
    public boolean setDescriptor(String descriptor){
        try{
            this.descriptor = descriptor;
        }
        catch(Exception e){
            System.out.println(e);
            return false;
        }
        return true;
    }
}
