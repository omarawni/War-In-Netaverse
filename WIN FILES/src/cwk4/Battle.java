package cwk4.src.cwk4;

public class Battle {
    //Fields:
    private int battleID;
    private String enemyName;
    private int enemyStrength;
    private int battleGains;
    private int battleLosses;


    private BattleType battleType;

    //Constructor:
    public Battle (int BID, String EN, int ES, int BG, int BL, BattleType BT){
        battleID = BID;
        enemyName = EN;
        enemyStrength = ES;
        battleGains = BG;
        battleLosses = BL;
        battleType = BT;
    }


    //Methods:
    /*
    returns int battle ID.
     */
    public int getBattleID(){
        return battleID;
    }


    /*
    returns String enemy name.
     */
    public String getEnemyName(){
        return enemyName;
    }



    /*
    returns int enemy strength.
     */
    public int getEnemyStrength(){
        return enemyStrength;
    }


    /*
    returns int battle gains.
     */
    public int getBattleGains (){
        return battleGains;
    }


    /*
    returns int battle Losses.
     */
    public int getBattleLosses(){
        return battleLosses;
    }


    /*
    returns String of battle type.
     */
    public String getBattleType(){
        return battleType.toString();
    }



    /*
    changes and returns newly changed battle state, by passing param b, which is either of the 3 battle types (BattleType.FIGHT, BattleType.AMBUSH or BattleType.SKIRMISH)
     */
    public BattleType changeBattleType(BattleType b){
        battleType = b;
        return battleType;
    }





    /*
     * toString method:
     * Returns string representation of relevant information regarding Battle.
     */
    public String toString(){
        return "\n Battle ID: " + battleID + "\n Battle type: " + battleType.toString() + "\n Enemy name: " + enemyName + "\n Enemy strength: " + enemyStrength + "\n Battle gains: " + battleGains + "\n Battle losses: " + battleLosses + "\n";
    }


}
