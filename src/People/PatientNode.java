package People;

public class PatientNode extends Person{

    /*We don't really need to do much here yet, but instanceof can be used now to test what kind of person it is
    * The logic is in Person.java which implements interface PersonNode.java
    * Not sure if this is efficient or what but it'll work
    * I just didn't want to type basically the same class twice
    * If we need to add methods unique to the patient class then we can do that here
    */

    //Returns in format:
        //  Patient - <Name> - <Description>
    @Override
    public String toString() {
        return "Patient - " + this.getName() + " - " + this.getDescriptor();
    }
}
