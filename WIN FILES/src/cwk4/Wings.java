package cwk4.src.cwk4;
public class Wings extends Force //subclass of Force
{
    //Fields:
    private int numberOfStrikers;

    /*
     * Constructor:
     * super is the constructor of the parent class, Force, that links force and wings. giving wings the fields in force class, and access to its methods.
     */
    public Wings (String UFR, String FN, int S){
    super(UFR, FN, 200, 20*S);
    numberOfStrikers = S;
    }

    //Methods:
    /*
    returns int number of strikers.
     */
    public int getNumberOfStrikers(){
        return numberOfStrikers;
    }

    /*
     * toString method:
     * Returns string representation of relevant information regarding Wings.
     */
    public String toString(){
        return "\n Unique fleet reference: " + getUniqueFleetReference() + "\n Force Name: " + getNameOfForce()+ "\n Activation Fee: " + getActivationFee() + "\n Battle strength: " + getBattleStrength() + "\n Number of Strikers: " + numberOfStrikers + "\n State of force: " + getstateofforce() + "\n";
    }


}
