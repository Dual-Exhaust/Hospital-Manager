package People;

import java.util.ArrayList;

public class Person {
    //Forces child classes to have a name and descriptor
    protected String name;
    protected String descriptor;
    protected ArrayList<Integer> visits;

    /**Creates empty person object
     * 
     */
    public Person(){
    	name = "";
    	descriptor = "";
    	visits = new ArrayList<>();
    }

    /**Creates person object with parameters
     * 
     * @param name
     * @param descriptor
     */
    public Person(String name, String descriptor){
        this.name = name;
        this.descriptor = descriptor;
        visits = new ArrayList<>();
    }

    /**Returns name of person
     * 
     */
    public String getName(){
        return this.name;
    }

    /**Returns descriptor of person
     * 
     */
    public String getDescriptor(){
        return this.descriptor;
    }

    /**Returns "Name - Description"
     * 
     */
    @Override
    public String toString() {
        return this.getName() + " - " + this.getDescriptor();
    }

    /**Try to set the person's name, if whatever it does breaks then it returns false and prints an error, else it will return true
     *
     */
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

    /**Try to set the person's description, if whatever it does breaks then it returns false and prints an error, else it will return true
     * 
     */
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
    
    /**Add visit to visits linked list
     * 
     * @param v
     */
    public void addVisit(int visitNumber) {
    	visits.add(visitNumber);
    }
    
    /**Remove visit from visits linked list
     * 
     * @param v
     */
    public void removeVisit(VisitNode v) {
    	visits.remove(v);
    }
    
    public ArrayList<Integer> getVisits(){
    	return visits;
    }
}
