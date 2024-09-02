package cwk4.src.cwk4;
public class Admiral {

    //Fields:
    private String admiralName;
    private int admiralID;
    public static int  bitsInWarChest;


    //Constructors:
    public Admiral (String AN, int AID, int BIWC){
        admiralName = AN;
        admiralID = AID;
        bitsInWarChest = BIWC;
    }

    //Methods:
    /*
    returns String admiral name.
     */
    public String getAdmiralName(){
        return  admiralName;
    }


    /*
    returns int Admiral ID.
     */
    public int getAdmiralID(){
        return admiralID;
    }


    /*
    returns int bits in the war chest.
     */
    public int getBitsInWarChest() {
        return bitsInWarChest;
    }


    /*
    Add bits into war chest, by passing int newbits, and adding it to original bits value.
     */
    public void addbitsinWarChest(int newbits){
        bitsInWarChest = bitsInWarChest + newbits;
    }


    /*
    remove bits into war chest, by passing int removedbits, and subtracting it from original bits value.
     */
    public void removebitsinWarChest(int removedbits){
        bitsInWarChest = bitsInWarChest -removedbits;
    }



    /*
     * toString method:
     * Returns string representation of relevant information regarding Admiral.
     */
    public String toString(){
        return "\n Admiral ID: " + admiralID + "\n Admiral Name : " + admiralName + "\n Bits in the war chest: " + bitsInWarChest;
    }
}
