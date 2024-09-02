package cwk4.src.cwk4;
import java.util.ArrayList;

public class Active_Star_Fleet {
    //Fields:
    private static ArrayList<Force> activeForceList;
    private String fleetName;



    //Constructor:
    public Active_Star_Fleet(String fleetName) {
        this.fleetName = fleetName;
        activeForceList = new ArrayList<>();
    }


    //Methods:
    /* returns string representation of all forces stored in active star fleet. */
    public String getActiveForceList() {
        String List = "";
        if (activeForceList.size() == 0){
            List = "No forces activated";
        } else {
            for (Force F: activeForceList){
                List = List + "\n" + F.toString();

            }
        }
        return List;
    }



    /*
     * returns string representation of force in active star fleet that matches string param ref.
     * */
    public String getOneForce( String ref){
        String aforce = "";
        for (Force F: activeForceList){
            if (F.getUniqueFleetReference() == ref){
                aforce = F.toString();
            } else {
                aforce = "No such force";
            }

        }
        return aforce;
    }





    /* returns String of Fleet name*/
    public String getFleetName() {
        return fleetName;
    }


    /* a function that checks if Force is in the activeForceList or not */
    public boolean checkForceASF(String ref){
        boolean state = false;
        for (Force F: activeForceList){
            if(F.getUniqueFleetReference() == ref){
                state = true;
            }else {
                state = false;
            }

        }
        return state;
    }



    /* a function that adds Force to Active Star Fleet but first using the function to check for the force's existance,
    * if it does not exist then check if it exists in dock if it does then it is removed from dock and added to Active Star Fleet
    * if it does not exist then it is added normally, if the Force exists in the Active Star Fleet then a message pops up*/
    public String addForceASF(Force insertForce){
        String message = "";
        for (Force F: activeForceList) {
            if (F == insertForce) {
                message = "Force already exists in active star fleet.";
            } else if (insertForce.getstateofforce() == "destroyed") {
               message = "Force destroyed.";

            } else if (F != insertForce){
                activeForceList.add(insertForce);
                insertForce.changestateofforce(ForceState.ACTIVE);
                message = "New Force added to active star fleet.";
            }
        }
        return message;

    }




    /* a function that recalls the force from the Active Star Fleet and returns it to Dock.
    * takes params Force insertforce, and Dock D.*/
    public  String recallForceASF(Force insertForce, Dock D) {
        String message = "";
        for (Force F: activeForceList){
            if (F == insertForce && D.checkForceDock(insertForce.getUniqueFleetReference()) == false) {
                activeForceList.remove(insertForce);
                D.addForceDock(insertForce);
                message = "Force recalled back from active star fleet to the dock.";

            } else if (F != insertForce || D.checkForceDock(insertForce.getUniqueFleetReference()) == true) {
                message = "Force does not exist in active star fleet.";
            }
        }
        return message;
    }


    /*
    Function that removes force from active star fleet completely.
     */
    public void removeForceASF(Force F){

        for (Force f: activeForceList){
            if (f == F) {
                activeForceList.remove(f);
            }
        }

    }




    /*
    Returns the int size of the active star fleet.
     */
    public int Sizeofactivestarfleet(){
        return activeForceList.size();
    }

    /*
     * toString method:
     * Returns string representation of relevant information regarding Active star fleet.
     */
    public String toString() {
        return "Active Star Fleet information: " + "\n fleet name: " + fleetName + "\n Forces in Active star fleet: " + getActiveForceList();
    }
}
