package cwk4.src.cwk4;
import java.util.ArrayList;

public class Dock {
    //Fields:
    private static ArrayList<Force> forceList;
    private String dockName;
    private String locationOfDock;



    //Constructor:
    public Dock(String dockName, String locationOfDock) {
        this.dockName = dockName;
        this.locationOfDock = locationOfDock;
        forceList = new ArrayList<>();
    }



    //Methods:
    /*
    * returns string representation of all forces currently stored in dock.
    * */
    public String getForceList() {
        String List = "";
        for (Force F: forceList){
               List = List + "\n" + F.toString();

        }
        return List;
    }


    /*
     * returns string representation of force in dock that matches string param ref.
     * */
    public String getOneForce( String ref){
        String aforce = "";
        for (Force F: forceList){
            if (F.getUniqueFleetReference() == ref){
                aforce = F.toString();
            } else {
                aforce = "No such force";
            }

        }
        return aforce;
    }






    /*
    * returns String name of Dock Name
    * */
    public String getDockName() {
        return dockName;
    }



    /*
    * returns String name of Dock location*/
    public String getLocationOfDock() {
        return locationOfDock;
    }



    /*
    * a function that checks if Force is in the forceList or not */
    public boolean checkForceDock(String refForce){
        boolean state = false;
        for (Force F: forceList){
            if(F.getUniqueFleetReference() == refForce){
                state = true;
            }else {
                state = false;
            }
        }

        return state;
    }



    /*
    * a function that adds Force to the forceList but first checks if it is already preexisting, as well as if it exists
    * in Active Star Fleet Class and if it is, it returns an appropriate string message informing the user of the aforementioned information,
    * and if it isn't in Active Star Fleet and dock, the force is then added directly.*/
    public String addForceDock(Force insertForce){
        String message = "";
        for (Force F: forceList){
            if (F == insertForce) {
                message = "Force already exists in dock.";
            } else if (insertForce.getstateofforce() == "destroyed"){
                message = "Force destroyed.";

            }
            else if (F != insertForce){
                forceList.add(insertForce);
                insertForce.changestateofforce(ForceState.DOCKED);
                message = "New Force added to dock.";

            }
        }
         return message;

    }



    /* a function that removes Force from the forceList in Dock, and returns message informing user of the action. */
    public String removeForceDock(Force insertForce) {
        String message = "";
        for (Force F: forceList){
            if (F == insertForce) {
                forceList.remove(insertForce);
                message = "Force removed from dock.";
            } else {
                message = "Force already not in dock.";
            }
        }
        return message;

    }



    /*
     * toString method:
     * Returns string representation of relevant information regarding Dock.
     */
    public String toString() {
        return "Dock information: " + "\n Force List=" + getForceList() + "\n Name of The Dock='" + dockName + "\n The Docks Location= " + locationOfDock;
    }
}
