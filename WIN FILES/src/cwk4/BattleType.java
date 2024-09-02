package cwk4.src.cwk4;

import java.io.Serializable;
/**
 * Enumeration class BattleType - An enum class that gives the user 3 fixed options to choose from for the battle type. 3 battle types (AMBUSH, FIGHT OR SKIRMISH).
 * 
 * @author A.Marczyk
 * @version 02/11/2019
 */
public enum BattleType implements Serializable
{
    SKIRMISH (" Skirmish"), AMBUSH(" Ambush"), FIGHT(" Fight") ;
    private String type;
    
    private BattleType(String ty)
    {
        type = ty;
    }
    
    public String toString()
    {
        return type;
    }

}
