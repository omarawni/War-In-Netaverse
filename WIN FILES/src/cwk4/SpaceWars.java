package cwk4.src.cwk4;
import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * This class implements the behaviour expected from a WIN
 system as required for 5COM2007 - March 2023
 * 
 * @author Team ??
 * @version March 2023
 */

public class SpaceWars implements WIN {

    private Admiral A;

    private ArrayList<Force> overallForceList= new ArrayList<Force>();
    private ArrayList<Force> DestroyedList= new ArrayList<Force>();
    private ArrayList<Force> ActiveList= new ArrayList<Force>();

    private ArrayList<Force> DockList= new ArrayList<Force>();
    private ArrayList<Battle> BattleList = new ArrayList<Battle>();
    private String admiralname;

    private String filename;



//**************** WIN **************************  

    /**
     * Constructor requires the name of the admiral
     *
     * @param ad the name of the admiral
     */
    public SpaceWars(String ad) {
        this(ad, "battles.txt");
        admiralname = ad;

        A = new Admiral(admiralname, 0000, 1000);

        setupForces();
        setupBattles();
    }

    /** Second constructor - task 3.5
     *  To be added for task 3.5
     */

    public SpaceWars (String ad, String fname){
        this.admiralname = ad;
        A = new Admiral(admiralname, 0000, 1000);
        this.filename = fname;
        setupForces();
        readBattles(fname);
    }


    /**
     * Returns a String representation of the state of the game,
     * including the name of the admiral, state of the war chest,
     * whether defeated or not, and the forces currently in the
     * Active Star Fleet(ASF),(or, "No forces" if Star Fleet is empty)
     *
     * @return a String representation of the state of the game,
     * including the name of the admiral, state of the war chest,
     * whether defeated or not, and the forces currently in the
     * Star Fleet,(or, "No forces" if Active Star Fleet is empty)
     **/
    public String toString() {
        return "\n Name of the admiral:" + admiralname + "\n State of the war chest : " + getWarchest() + "\n Is admiral defeated? " +  isDefeated() + "\n Forces currently in active star fleet: \n" + getASFleet();
    }


    /**
     * returns true if war chest <=0 AND the active Star Fleet(ASF) has no
     * forces which can be recalled.
     *
     * @returns true if war chest <=0 and the active Star Fleet(ASF) has no
     * forces which can be recalled.
     */
    public boolean isDefeated( ) {
        if (getWarchest() <= 0 && ActiveList.size() == 0){
            return true;
        } else {
            return false;
        }
    }


    /** returns the number of bit coins in the war chest
     * @returns the number of bit coins in the war chest
     */
    public int getWarchest()
    {
        int x;
        x = A.getBitsInWarChest();
        return x;
    }



    /* Returns a list of all forces in the system by listing :
     * All forces in the Active Star Fleet(ASF), or "No forces in ASF")
     * All forces remaining in the UFF dock, or "No forces in UFF dock
     * All forces destroyed as a result of losing a battle, or "No destroyed forces"
     */
    public String getAllForces()
    {
        String message = "";
        for (Force F: overallForceList) {
                message = message + F.toString();

        }
        if (!message.contains(" active") ){
            message = message + "\n No forces in ASF \n";
        }
        if (!message.contains(" In dock") ){
            message = message + "\n No forces in UFF dock \n";
        }
        if (!message.contains(" destroyed") ){
            message = message + "\n No destroyed forces \n";
        }


        return message;
    }
        
    
    /**Returns true if force is in the United Forces Fleet(UFF), else false
     * @param ref reference of the force
     * @return a String representation of all forces in the United Forces Fleet(UFF)
     **/
    public boolean isInUFFDock(String ref) 
    {
        boolean result = false;
        for (Force F: DockList){
            if (F.getUniqueFleetReference() == ref){
                result = true;
                break;
            } else {
                result = false;
            }
        }
        return result;
    }


    /**Returns a String representation of all forces in the United Forces Fleet(UFF) dock.
     * Does not include destroyed forces
     * @return a String representation of all forces in the United Forces Fleet(UFF) dock.
     **/
    public String getForcesInDock()
    {
        String s = "\n************ Forces available in UFFleet Dock********\n";
        for (Force F: DockList){
            s = s + F.toString();
        }

        return s;
    }



     /** Returns a list of all destroyed forces in the system 
     * @return all destroyed forces   
     */
    public String getDestroyedForces()
    {
        String s ="\n***** Destroyed Forces ****\n" ;
        if (DestroyedList.size() > 0){
            for (Force F: DestroyedList){
                s = s + F.toString();

            }
    } else {
            s = s + "No destroyed forces.";
        }

        return s;
    }


    /** Returns details of the force with the given reference code, or "No such force" 
     * @param ref the reference of the force
     * @return details of the force with the given reference code
     **/
    public String getForceDetails(String ref)
    {
        String message = "";

        for (Force F: overallForceList){
            if (F.getUniqueFleetReference() == ref){
                message = F.toString();
                break;
            } else {
                message = "No such force";
            }
        }
        return message;
    }     






    
 // ***************** Active Star Fleet Forces ************************   
    /** Allows a force to be activated into the Active Star Fleet(ASF), but 
     * only if there are enough resources for the activation fee.The force's 
     * state is set to "active"
     * @param ref represents the reference code of the force
     * @return 0 if force is activated, 1 if force is not in the UFF dock or is destroyed
      * 2 if not enough money, -1 if no such force
     **/       
    public int activateForce(String ref) {
        int number = 0;
        for (Force F: DockList){
            if (F.getUniqueFleetReference().equalsIgnoreCase(ref) &&  F.getstateofforce() != " active"  ){
                if ( A.getBitsInWarChest() >= F.getActivationFee()){
                    ActiveList.add(F);
                    DockList.remove(F);
                    F.changestateofforce(ForceState.ACTIVE);
                    A.removebitsinWarChest(F.getActivationFee());
                    number = 0;
                    break;
                } else {
                    number = 2;
                    break;
                }
            } else if (F.getUniqueFleetReference() != ref && F.getstateofforce() == " destroyed") {
                    number = 1;

                }
            else if (F.getUniqueFleetReference() != ref){
                    number = -1;
                }



        }
        return number;
    }
        


    /** Returns true if the force with the reference code is in
     * the Active Star Fleet(ASF), false otherwise.
     * @param ref is the reference code of the force
     * @return returns true if the force with the reference code
     * is in the active Star Fleet(ASF), false otherwise.
     **/
    public boolean isInASFleet(String ref) {
        boolean result = false;
        for (Force F: ActiveList){
            if (F.getUniqueFleetReference() == ref) {
                result = true;
                break;
            } else {
                result = false;
            }
        }
        return result;

    }



    /**Returns a String representation of the forces in the active 
     * Star Fleet(ASF), or the message "No forces activated"
     * @return a String representation of the forces in the active
     * Star Fleet, or the message "No forces activated"
     **/
    public String getASFleet()
    {
        String s = "\n****** Forces in the Active Star Fleet******\n";

        for (Force F: ActiveList){
            s = s + F.toString();
        }
        if (ActiveList.size() == 0){
            s = "No forces activated";
        }
        
        return s;
    }



    /** Recalls a force from the Star Fleet(ASF) back to the UFF dock, but only  
     * if it is in the Active Star Fleet(ASF)
     * @param ref is the reference code of the force
     **/
    public void recallForce(String ref)
    {
        for (Force F: ActiveList){
                    if (F.getUniqueFleetReference().equalsIgnoreCase(ref)){
                        ActiveList.remove(F);
                        DockList.add(F);
                        F.changestateofforce(ForceState.DOCKED);
                        A.addbitsinWarChest((F.getActivationFee()/2));
                        break;
                    }



        }

    }   
            





//**********************Battles************************* 
    /** returns true if the number represents a battle
     * @param num is the number of the required battle
     * @returns true if the number represents a battle
     **/
     public boolean isBattle(int num)
     {
         boolean result = false;
       for (Battle B: BattleList){
           if (B.getBattleID() == num){
               result = true;
            break;
           } else {
               result = false;
           }
       }
       return result;
     }
    
    
    /** Provides a String representation of a battle given by 
     * the battle number
     * @param num the number of the battle
     * @return returns a String representation of a battle given by 
     * the battle number
     **/
    public String getBattle(int num)
    {
        String message = "";
        for (Battle B: BattleList){
            if (B.getBattleID() == num){
                message = B.toString();
                break;
            } else {
               message = "No such battle";
            }
        }
        return message;
    }
    
    /** Provides a String representation of all battles 
     * @return returns a String representation of all battles
     **/
    public String getAllBattles()
    {
        String s = "\n************ All Battles ************\n" + getbattlelist();
        
        return s;
    }
     
     
    /** Retrieves the battle represented by the battle number.Finds 
      * a force from the Active Star Fleet which can engage in the battle.The  
      * results of battle will be one of the following: 
      * 0 - Battle won, battle gains added to the war chest, 
      * 1 - Battle lost as no suitable force available, battle losses 
      * deducted from war chest 
      * 2 - Battle lost on battle strength , battle losses 
      * deducted from war chest and force destroyed
      * 3 - If a battle is lost and admiral completely defeated (no resources and 
      * no forces to recall) 
      * -1 - no such battle
      * @param battleNo is the number of the battle
      * @return an int showing the result of the battle (see above)
      */ 
    public int doBattle(int battleNo)
    {

        int number = 0;
        for (Battle B: BattleList){
            if (B.getBattleID()== battleNo) {
                for (Force F : ActiveList) {
                    //FIGHT BATTLE SUITABLE FORCE CONDITIONS:
                    if (B.getBattleType() == " Fight") {
                        if (F instanceof warbirds || F instanceof Starships) {
                            if (F.getBattleStrength() >= B.getEnemyStrength()) {
                                A.addbitsinWarChest(B.getBattleGains());
                                number = 0;
                                break;
                            } else if (F.getBattleStrength() < B.getEnemyStrength()) {
                                A.removebitsinWarChest(B.getBattleLosses());
                                ActiveList.remove(F);
                                DestroyedList.add(F);
                                F.changestateofforce(ForceState.DESTROYED);
                                number = 2;
                                break;
                            }
                        }else if (F instanceof Wings) {
                            A.removebitsinWarChest(B.getBattleLosses());
                            number = 1;
                        }
                    }






                    //AMBUSH BATTLE SUITABLE FORCE CONDITIONS:
                    if (B.getBattleType() == " Ambush") {
                        if (F instanceof warbirds && ((warbirds) F).CloakDeviceAvailability() == false) {
                            number = 1;
                            A.removebitsinWarChest(B.getBattleLosses());
                            break;
                        } else if (F instanceof warbirds && ((warbirds) F).CloakDeviceAvailability() == true) {
                            if (F.getBattleStrength() >= B.getEnemyStrength()) {
                                A.addbitsinWarChest(B.getBattleGains());
                                number = 0;
                                break;
                            } else {
                                A.removebitsinWarChest(B.getBattleLosses());
                                ActiveList.remove(F);
                                DestroyedList.add(F);
                                F.changestateofforce(ForceState.DESTROYED);
                                number = 2;
                                break;
                            }


                        } else if (F instanceof Wings) {
                            if (F.getBattleStrength() >= B.getEnemyStrength()) {
                                A.addbitsinWarChest(B.getBattleGains());
                                number = 0;
                                break;
                            } else if (F.getBattleStrength() < B.getEnemyStrength()) {
                                A.removebitsinWarChest(B.getBattleLosses());
                                ActiveList.remove(F);
                                DestroyedList.add(F);
                                F.changestateofforce(ForceState.DESTROYED);
                                number = 2;
                                break;
                            }

                        } else if (F instanceof Starships) {
                            A.removebitsinWarChest(B.getBattleLosses());
                            number = 1;

                        }
                    }









                    //SKIRMISH BATTLE SUITABLE FORCE CONDITIONS:
                    if (B.getBattleType() == " Skirmish") {
                        if (F instanceof Starships || F instanceof Wings) {
                            if (F.getBattleStrength() >= B.getEnemyStrength()) {
                                A.addbitsinWarChest(B.getBattleGains());
                                number = 0;
                                break;
                            } else if (F.getBattleStrength() < B.getEnemyStrength()) {
                                A.removebitsinWarChest(B.getBattleLosses());
                                ActiveList.remove(F);
                                DestroyedList.add(F);
                                F.changestateofforce(ForceState.DESTROYED);
                                number = 2;
                                break;
                            }
                        }else if (F instanceof warbirds) {
                            A.removebitsinWarChest(B.getBattleLosses());
                            number = 1;
                        }
                    }





                    if (isDefeated() == true) {
                        A.removebitsinWarChest(B.getBattleLosses());
                        ActiveList.remove(F);
                        DestroyedList.add(F);
                        F.changestateofforce(ForceState.DESTROYED);
                        number = 3;
                    }

                }
               break;
            }else if (B.getBattleID() != battleNo){
                number = -1;
            }
        }





        return number;
    }
    


    
    //*******************************************************************************
    private void setupForces()
    {
        Force F1 = new Wings("IW1" ,"Twister" , 10 );
        Force F2 = new Starships("SS2", "Enterprise", 10 , 20);
        Force F3 = new warbirds("WB3", "Droop", 100, false);
        Force F4 = new Wings("IW4", "Winger", 20);
        Force F5 = new warbirds("WB5", "Hang", 300 , true);
        Force F6 = new Starships("SS6", "Voyager", 15, 10 );
        Force F7 = new Starships("SS7", "Explorer", 4, 5);
        Force F8 = new warbirds("WB9", "Hover", 400,  false);
        Force F9 = new Wings("IW10", "Flyer", 5 );


        DockList.add(F1);
        DockList.add(F2);
        DockList.add(F3);
        DockList.add(F4);
        DockList.add(F5);
        DockList.add(F6);
        DockList.add(F7);
        DockList.add(F8);
        DockList.add(F9);
        overallForceList.add(F1);
        overallForceList.add(F2);
        overallForceList.add(F3);
        overallForceList.add(F4);
        overallForceList.add(F5);
        overallForceList.add(F6);
        overallForceList.add(F7);
        overallForceList.add(F8);
        overallForceList.add(F9);


    }
    
    private void setupBattles()
    {
        Battle B1 = new Battle(1 , "Borg" , 200 , 100 , 300 , BattleType.FIGHT);
        Battle B2 = new Battle(2, " Kardassians", 700, 120, 200, BattleType.SKIRMISH);
        Battle B3 = new Battle(3, "Ferengi", 100, 150, 400, BattleType.AMBUSH);
        Battle B4 = new Battle(4, "Ewoks", 600 , 200 , 600 , BattleType.FIGHT);
        Battle B5 = new Battle(5, "Borg" , 500 , 90 , 400 , BattleType.AMBUSH);
        Battle B6 = new Battle(6, "Groaners" , 150 , 100 , 100 , BattleType.SKIRMISH);
        Battle B7 = new Battle(7, "Borg" , 150 , 300 , 500 , BattleType.FIGHT);
        Battle B8 = new Battle(8, "Wailers" , 300 , 300 , 500 , BattleType.AMBUSH);

        BattleList.add(B1);
        BattleList.add(B2);
        BattleList.add(B3);
        BattleList.add(B4);
        BattleList.add(B5);
        BattleList.add(B6);
        BattleList.add(B7);
        BattleList.add(B8);
    }







    //**************************Add your own private methods here ***********************
    private String getbattlelist (){
        String m = "";
        if(BattleList.size() != 0 ){
            for(Battle B : BattleList){
                m = m + B.toString();
            }

        } else {
            m = "No battles available";
        }
        return m;
    }












    //*******************************************************************************
  
    //These methods are not needed until Task 3.5. Uncomment thmemto complete task 3.5
    // ***************   file write/read  *********************
 
   /** Writes whole game to the specified file
    * @param fname: name of file storing requests
    */
    public void saveGame(String fname) {
        try{
            FileOutputStream fout =new FileOutputStream(fname);
            ObjectOutputStream out=new ObjectOutputStream(fout);
            out.writeObject(toString());
            out.flush();
            out.close();
        } catch (Exception e){
            try {
                throw new IOException("Something went wrong");
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }

        }

    }




    /** reads all information about the game from the specified file
    * and returns a SpaceWars object
     * @param fname: name of file storing the game
     * @return the game (as a SpaceWars object)
   */
    public SpaceWars restoreGame(String fname) {
        try {
            FileInputStream f = new FileInputStream(fname);
            ObjectInputStream o = new ObjectInputStream(f);
            String Currenttostring = o.readObject().toString();
            SpaceWars restoredwar = new SpaceWars( fname) ;
            f.close();
            o.close();
            return restoredwar;
        } catch (Exception e){
            try {
                throw new IOException();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        }

    }






    /** Reads information about battles from the specified file into the appropriate collection
     * @param fname: the name of the file
   */
    private void readBattles(String fname)
     {BattleType BT = null;
        try {
            BufferedReader reader = new BufferedReader(new FileReader(fname));
            String line;
            while ((line = reader.readLine()) != null) {
                ArrayList<String> Thebattle = new ArrayList<>(Arrays.asList(line.split(",")));
                BT = BT.valueOf(Thebattle.get(5));
                Battle B = new Battle (Integer.parseInt(Thebattle.get(0)), Thebattle.get(1),Integer.parseInt(Thebattle.get(2)), Integer.parseInt(Thebattle.get(3)), Integer.parseInt(Thebattle.get(4)), BT);
                BattleList.add (B);
            }

            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }




}
