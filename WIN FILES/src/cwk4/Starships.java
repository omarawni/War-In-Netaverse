package cwk4.src.cwk4;
public class Starships extends Force //subclass of Force
{
    //Fields:
    private int numberOfLaserCannons;
    private int numberOfPhotonTorpedos;

    /*
     * Constructor:
     * super is the constructor of the parent class, Force, that links force and starships. giving Starships the fields in force class, and access to its methods.
     */
    public Starships (String UFR, String FN, int nlc, int npt){
     super (UFR, FN, 30*nlc, (5*npt + 10*nlc));
     numberOfLaserCannons = nlc;
     numberOfPhotonTorpedos = npt;
    }

    //Methods:
    /*
    returns int Number of laser cannons.
     */
    public int getNumberOfLaserCannons(){
        return numberOfLaserCannons;
    }


    /*
    returns int number of photon torpedos.
     */
    public int getNumberOfPhotonTorpedos(){
        return numberOfPhotonTorpedos;
    }



    /*
     * toString method:
     * Returns string representation of relevant information regarding Starships.
     */
    public String toString(){
        return "\n Unique fleet reference: " + getUniqueFleetReference() + "\n Force Name: " + getNameOfForce()+ "\n Activation Fee: " + getActivationFee() + "\n Battle strength: " + getBattleStrength() + "\n Number of laser cannons: " + numberOfLaserCannons +"\n Number of Photon torpedos: " + numberOfPhotonTorpedos + "\n State of force: " + getstateofforce() + "\n";
    }
}
