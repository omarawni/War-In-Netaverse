package cwk4.src.cwk4;

import java.io.Serializable;
/**
 * Enumeration class ForceState - An enum class that gives the user 3 fixed options to choose from for the force state. 3 force states (DOCKED, ACTIVE OR DESTROYED).
 * 
 * @author A.Marczyk
 * @version 02/11/2019
 */
public enum ForceState implements Serializable
{
    DOCKED(" In dock"), ACTIVE(" active"), DESTROYED (" destroyed");
    private String state;
    
    private ForceState(String st)
    {
        state = st;
    }
    
    public String toString()
    {
        return state;
    }
}
