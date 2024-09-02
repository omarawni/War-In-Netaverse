package cwk4.src.cwk4;


/**
 * Details of your team:
 * Team 1.
 * @authors Ahmed amin (20022537), Omar Awni (20025344), Mahmoud ibrahim (20025336), Mohanad khatab (20022584)
 * @version 1.0
 */
public class Teamwork
{
    private String[] details = new String[12];
    
    public Teamwork()
    {   // in each line replace the contents of the String 
        // with the details of your team member
        // Please list the member details alphabetically by surname 
        // i.e. the surname of member1 should come alphabetically 
        // before the surname of member 2...etc
        details[0] = "1";
        
        details[1] = "Amin";
        details[2] = "Ahmed";
        details[3] = "20022537";

        details[4] = "Awni";
        details[5] = "Omar";
        details[6] = "20025344";

        details[7] = "Ibrahim";
        details[8] = "Mahmoud";
        details[9] = "20025336";


        details[10] = "Khatab";
        details[11] = "Mohanad";
        details[12] = "20022584";

    }
    
    public String[] getTeamDetails()
    {
        return details;
    }
    
    public void displayDetails()
    {
        for(String temp:details)
        {
            System.out.println(temp.toString());
        }
    }
}
        
