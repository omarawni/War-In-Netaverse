package cwk4.src.cwk4;
public class Force {
    //Fields:
    private String uniqueFleetRefrence;
    private String nameOfForce;
    private int activationFee;
    private int battleStrength;

    private ForceState forceState;



    //Constructor:
    public Force (String UFR, String NOF, int AF, int BS  ){
        uniqueFleetRefrence = UFR;
        nameOfForce = NOF;
        activationFee = AF;
        battleStrength = BS;
        forceState = ForceState.DOCKED;


    }

    //Methods:
    /*
    returns int Unique fleet reference.
     */
    public String getUniqueFleetReference(){
        return uniqueFleetRefrence;
    }


    /*
    returns String name of force.
     */
    public String getNameOfForce(){
        return nameOfForce;
    }


    /*
    returns int activation Fee.
     */
    public int getActivationFee(){
        return activationFee;
    }


    /*
    returns int battle strength.
     */
    public int getBattleStrength(){
        return battleStrength;
    }


    /*
    returns String state of the force.
     */
    public String getstateofforce(){
        return forceState.toString();
    }


    /*
    Changes and returns newly changed state of force, by passing param f, which is either of the 3 force states (Forcestate.ACTIVE, Forcestate.DOCKED or ForceState.DESTROYED)
     */
    public ForceState changestateofforce(ForceState f){
        forceState = f;
        return forceState;
    }


    /*
    Changes activation fee to param newAF (a new value for the activation fee).
     */
    public void changeActivationFee(int newAF){
        activationFee = newAF;
    }

    @Override
    /*
     * toString method:
     * Returns string representation of relevant information regarding Force.
     * will be overriden by Starships, Wings and warbirds toString methods.
     */
    public String toString(){
        return "\n Unique fleet reference: " + this.uniqueFleetRefrence + "\n Force Name: " + this.nameOfForce + "\n Activation Fee: " + this.activationFee + "\n Battle Strength: " + this.battleStrength + "\n State of the force: " + this.forceState.toString() + "\n";
    }




}
