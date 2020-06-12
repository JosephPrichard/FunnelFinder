/*
This class provides information on how to run a script, and how to convert a funnel into a .stl file
 */
//package heskethfunnelfinder;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * 
 */
public class Help extends JFrame implements ActionListener {
    
    //declaration
    private JPanel textPanel;
    private JPanel textPanel1;
    private JPanel endPanel;
    private JPanel buttonPanel;
    private JLabel explainLabel;
    private JLabel explainLabel1;
    private JLabel explainLabel2;
    private JLabel explainLabel3;
    private JLabel explainLabel4;
    private JLabel explainLabel5;
//    private JButton helpButton;
    private JButton stlButton;
    private JButton backButton;
    
    //file checking
    public static boolean error = false;
    
    //declaring constants of classes related to JFrame
    public final Color LIGHT_COLOR = new Color(192,192,192);
    public final Color BK_COLOR = new Color(0,0,0);
    public final Font TEXT_FONT = new Font("Comic Sans MS", Font.PLAIN, 40);
    
    //declaring scripts
    private static final String STL_SCRIPT = "STLOUT\r\n" + "L" + "\r\n\r\n" + "Y\r\n";

    public Help()
    {
        
        //sets important basics of the frame
        super("Help");
        this.setBounds(300,150,1300,660);
        //this.setResizable(false);
//        this.setExtendedState(JFrame.MAXIMIZED_BOTH); 
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.getContentPane().setBackground(BK_COLOR);
        this.setLayout(new BorderLayout());
        
        //labels
        explainLabel = new JLabel("Script Instructions: "); 
        explainLabel.setForeground(LIGHT_COLOR);
        explainLabel.setFont(TEXT_FONT);  
        explainLabel1 = new JLabel("Open empty project, Type 'scr' in Autocad's command terminal"); 
        explainLabel1.setForeground(LIGHT_COLOR);
        explainLabel1.setFont(TEXT_FONT); 
        explainLabel2 = new JLabel("Navigate to " + DbClient.getSetting(0) + " in the file popup"); 
        explainLabel2.setForeground(LIGHT_COLOR);
        explainLabel2.setFont(TEXT_FONT); 
        explainLabel3 = new JLabel("Click the .scr file you want to run and click 'Open'"); 
        explainLabel3.setForeground(LIGHT_COLOR);
        explainLabel3.setFont(TEXT_FONT); 
        explainLabel4 = new JLabel("Click the button below to create an .stl conversion script"); 
        explainLabel4.setForeground(LIGHT_COLOR);
        explainLabel4.setFont(TEXT_FONT); 
        explainLabel5 = new JLabel("Run " + DbClient.getSetting(0) + "conversion" + ".scr"); 
        explainLabel5.setForeground(LIGHT_COLOR);
        explainLabel5.setFont(TEXT_FONT); 
        
        //buttons
        stlButton = new JButton ("Stl Script");
        stlButton.addActionListener(this);
        backButton = new JButton ("Back");
        backButton.addActionListener(this);
        
        //panels
        textPanel = new JPanel (new BorderLayout());
        textPanel.setBackground(BK_COLOR);
        textPanel.add(explainLabel, BorderLayout.NORTH);
        textPanel.add(explainLabel1, BorderLayout.CENTER);
        textPanel.add(explainLabel2, BorderLayout.SOUTH);
        textPanel1 = new JPanel (new BorderLayout());
        textPanel1.setBackground(BK_COLOR);
        textPanel1.add(explainLabel3, BorderLayout.NORTH);
        textPanel1.add(explainLabel4, BorderLayout.CENTER);
        textPanel1.add(explainLabel5, BorderLayout.SOUTH);
        endPanel = new JPanel (new BorderLayout());
        endPanel.add(textPanel, BorderLayout.NORTH);
        endPanel.add(textPanel1, BorderLayout.SOUTH);
        buttonPanel = new JPanel (new FlowLayout());
        buttonPanel.setBackground(BK_COLOR);
        buttonPanel.add(backButton);
//        buttonPanel.add(helpButton);
        buttonPanel.add(stlButton);
        buttonPanel.setBackground(BK_COLOR);
        
        //adding panels 
        this.add(endPanel, BorderLayout.NORTH);
        this.add(buttonPanel, BorderLayout.SOUTH);
        this.setVisible(true);
    }
    
    //generates help script
    public void scriptGenerator(String script) throws IOException         
    {

        //declare file path and name
        String scriptPath = DbClient.getSetting(0) + "conversion" + ".scr";
        System.out.println(scriptPath);
        File file = new File(scriptPath);
        
        error = false;
        
        //check for ENTER_A_PATH default
        if(DbClient.getSetting(0).equals("ENTER_A_PATH"))
        {
            error = true;
            //dialog box
            JOptionPane.showMessageDialog(null, "Please set up a valid path in Settings!");
        }
        
        if (error == false) {
            try {
                //create the file
                file.createNewFile();
                //write Content
                FileWriter writer = new FileWriter(file);
                writer.write(script);
                writer.close();
                //dialog box
                JOptionPane.showMessageDialog(null, "Conversion script has been added to " + scriptPath);
            } catch (IOException io) {
                //dialog box
                JOptionPane.showMessageDialog(null, "Invalid path. Please add a valid path in settings.");
            }
        }
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();
        
        if (command.equals("Back"))
        {
                this.dispose();
              
        }
        if (command.equals("Stl Script"))
        {
                try {
                    scriptGenerator(STL_SCRIPT);
                } catch (IOException ex) {
                    Logger.getLogger(Input.class.getName()).log(Level.SEVERE, null, ex);
                }
        }
    
    }
    
//    public static void main(String[] args) {
//        Help HelpObj = new Help();
//    }
//    
    
    
}
