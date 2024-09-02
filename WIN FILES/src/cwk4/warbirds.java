package cwk4.src.cwk4;

public class warbirds extends Force //subclass of Force
{
    //Fields:
    private boolean cloakDevice;

    /*
     * Constructor:
     * super is the constructor of the parent class, Force, that links force and warbirds. giving warbirds the fields in force class, and access to its methods.
     */
    public warbirds (String UFR, String FN, int BS, boolean CD){
        super (UFR, FN, 300, BS );
        cloakDevice = CD;
        if (CD == true){
            super.changeActivationFee(400);
        }

    }

    //Methods:
    /*
    returns boolean (true or false) to whether the warbird has a cloak device or not;
     */
    public boolean CloakDeviceAvailability(){
        return cloakDevice;
    }



    /*
     * toString method:
     * Returns string representation of relevant information regarding Warbirds.
     */
    public String toString(){
        return "\n Unique fleet reference: " + getUniqueFleetReference() + "\n Force Name: " + getNameOfForce()+ "\n Activation Fee: " + getActivationFee() + "\n Battle strength: " + getBattleStrength() + "\n Cloak device available? " + cloakDevice + "\n State of force: " + getstateofforce() + "\n";
    }
}
