package cwk4.src.cwk4;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Provide a GUI interface for the game
 * 
 * @author A.A.Marczyk
 * @version 20/10/23
 */
public class GameGUI 
{
   private WIN gp = new SpaceWars("Horatio", "battles.txt");
    private JFrame myFrame = new JFrame("Game GUI");

    private JTextArea listing = new JTextArea();
    private JLabel codeLabel = new JLabel ();
    private JButton fightBtn = new JButton("Fight");

    private JButton ViewBtn = new JButton("View State");

    private JButton clearBtn = new JButton("Clear");
    private JPanel eastPanel = new JPanel();

    
    public GameGUI()
    {
        makeFrame();
        makeMenuBar(myFrame);
    }
    
    /**
     * Create the main frame's menu bar.
     */
    private void makeMenuBar(JFrame frame)
    {
        JMenuBar menubar = new JMenuBar();
        frame.setJMenuBar(menubar);
        
        // create the Forces menu
        JMenu forcesMenu = new JMenu("Forces");
        menubar.add(forcesMenu);

        JMenu battlesMenu = new JMenu("Battles");
        menubar.add(battlesMenu);

        JMenuItem listbattlesItem = new JMenuItem("List All Battles ");
        listbattlesItem.addActionListener(new ListbattlesHandler());
        battlesMenu.add(listbattlesItem);
        
        JMenuItem listForcesItem = new JMenuItem("List All Forces ");
        listForcesItem.addActionListener(new ListForcesHandler());
        forcesMenu.add(listForcesItem);

        JMenuItem listASFForcesItem = new JMenuItem("List All Active Forces ");
        listASFForcesItem.addActionListener(new ListASFForcesHandler());
        forcesMenu.add(listASFForcesItem);

        JMenuItem ActivateForceItem = new JMenuItem("Activate Force");
        ActivateForceItem.addActionListener(new ActivateforceHandler());
        forcesMenu.add(ActivateForceItem);

        JMenuItem RecallForceItem = new JMenuItem("Recall Force");
        RecallForceItem.addActionListener(new RecallforceHandler());
        forcesMenu.add(RecallForceItem);

    }
    /**
     * Create the Swing frame and its content.
     */
    private void makeFrame()
    {    
        myFrame.setLayout(new BorderLayout());
        myFrame.add(listing,BorderLayout.CENTER);
        listing.setVisible(false);
        myFrame.add(eastPanel, BorderLayout.EAST);
        // set panel layout and add components
        eastPanel.setLayout(new GridLayout(4,1));

        eastPanel.add(fightBtn);
        fightBtn.addActionListener(new FightBtnHandler());
        fightBtn.setVisible(true);

        eastPanel.add(ViewBtn);
        ViewBtn.addActionListener(new viewBtnHandler());
        ViewBtn.setVisible(true);

        eastPanel.add(clearBtn);
        clearBtn.addActionListener(new clearBtnHandler());
        clearBtn.setVisible(true);
        
        // building is done - arrange the components and show        
        myFrame.pack();
        myFrame.setVisible(true);
    }
    
    
    private String fighting(int code)
    {
        switch (code)
        {
            case 0:return "Battle won";
            case 1:return "Battle lost has no suitable force available";
            case 2:return "Battle lost on battle strength, force destroyed";
            case 3:return "Battle is lost and admiral completely defeated ";
            case -1: return "No such battle";
            default: return "Error";
        }

    }

    private String activation(int code)
    {

        switch (code)
        {
            case 0: return "Force is activated";
            case 1: return "force is not in the UFF dock or is destroyed";
            case 2: return "not enough money";
            case -1: return " no such force ";
            default: return "error";
        }

    }

    private class ListbattlesHandler implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            listing.setVisible(true);
            String xx = gp.getAllBattles();
            listing.setText(xx);

        }
    }


    private class ListForcesHandler implements ActionListener
    {
        public void actionPerformed(ActionEvent e) 
        { 
            listing.setVisible(true);
            String xx = gp.getAllForces();
            listing.setText(xx);
            
        }
    }

    private class ListASFForcesHandler implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            listing.setVisible(true);
            String xx = gp.getASFleet();
            listing.setText(xx);

        }
    }


    private class ActivateforceHandler implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            int result = -1;
            String inputValue = JOptionPane.showInputDialog("Unique fleet reference ?:");
            System.out.println(inputValue);
            result = gp.activateForce(inputValue);
            System.out.println(result);
            JOptionPane.showMessageDialog(myFrame,activation(result));
        }
    }

    private class RecallforceHandler implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            int result = 0;
            String inputValue = JOptionPane.showInputDialog("Unique fleet reference ?: ");
            gp.recallForce(inputValue);
            JOptionPane.showMessageDialog(myFrame, "Force recalled.");
        }
    }
    
    
    private class FightBtnHandler implements ActionListener
    {
        public void actionPerformed(ActionEvent e) 
        { 
            int result = -1;
            String inputValue = JOptionPane.showInputDialog("Battle number ?: ");
            int num = Integer.parseInt(inputValue);
            result = gp.doBattle(num);
            JOptionPane.showMessageDialog(myFrame,fighting(result));    
        }
    }

    private class viewBtnHandler implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            listing.setVisible(true);
            String xx = gp.toString();
            listing.setText(xx);
        }
    }


    private class clearBtnHandler implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            String xx = "";
            listing.setText(xx);
        }
    }
    
 
    
    public static void main(String[] args)
    {
        new GameGUI();
    }
}
   
