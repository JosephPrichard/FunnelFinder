/*
This class provides a GUI to insert settings
This class will then take the values from the GUI, verify they are viable, and insert them into the settings database
 */
//package heskethfunnelfinder;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

/**
 *
 * 
 */
public class Settings extends JFrame implements ActionListener{
    
    //generic settings declaration (27 max DbClientects stored)
    private JPanel textPanel;
    private JPanel textPanel1;
    private JPanel textPanel2;
    private JPanel textPanel3;
    private JPanel textPanel4;
    private JPanel textPanel5;
    private JPanel textPanel6;
    private JPanel textPanel7;
    private JPanel thePanel;
    private JPanel thePanel1;
    private JPanel thePanel2;
    private JPanel endPanel;
    private JPanel buttonPanel;
    private JLabel pathLabel;
    private JTextField pathField;
    private JLabel lwLabel;
    private JTextField lwField;
    private JLabel redLabel;
    private JTextField redField;
    private JLabel greenLabel;
    private JTextField greenField;
    private JLabel blueLabel;
    private JTextField blueField;
    private JLabel vsCurrentLabel;

    //radiobuttons!
    private JRadioButton frame2dButton;
    private JRadioButton frameButton;
    private JRadioButton hiddenButton;
    private JRadioButton realisitcButton;
    private JRadioButton conceptualButton;
    private JRadioButton shadedButton;
    private JRadioButton shadedEdgesButton;
    private JRadioButton shadeGrayButton;
    private JRadioButton sketchyButton;
    private JRadioButton xrayButton;
    private ButtonGroup currentGroup;
    
    //buttons
    private JButton applyButton;
    private JButton restoreButton;
    private JButton backButton;
    
    //field variables
    private static String path;
    private static String vsCurrent;
    private static double thickness;
    private static int red;
    private static int green;
    private static int blue;
    
    //constant
    private static final int MAX_DIGIT = 4;
    private static final int MAX_PATH = 99;
   
    //error
    private static boolean error;

    //declaring constants of classes related to JFrame
    public final Color LIGHT_COLOR = new Color(192,192,192);
    public final Color BK_COLOR2 = new Color(0,0,0);
    public final Color BK_COLOR = new Color(255,255,255);
    public final Font TEXT_FONT = new Font("Comic Sans MS", Font.BOLD | Font.ITALIC, 30);

    
    public Settings()
    {
        //sets important basics of the frame
        super("Settings");
        this.setBounds(350,40,1300,800);
        this.setResizable(false);
//        this.setExtendedState(JFrame.MAXIMIZED_BOTH); 
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.getContentPane().setBackground(BK_COLOR);
        this.setLayout(new BorderLayout());
        
        //labels
        //access client
        pathLabel = new JLabel("What folder should this program save its files to? Please copy paste the path."); 
        pathLabel.setForeground(LIGHT_COLOR);
        pathLabel.setFont(TEXT_FONT);
        lwLabel = new JLabel("What is the lineweight thickness (mm)?"); 
        lwLabel.setForeground(LIGHT_COLOR);
        lwLabel.setFont(TEXT_FONT);
        redLabel = new JLabel("What is the Red Value?"); 
        redLabel.setForeground(LIGHT_COLOR);
        redLabel.setFont(TEXT_FONT);
        greenLabel = new JLabel("What is the Green Value?"); 
        greenLabel.setForeground(LIGHT_COLOR);
        greenLabel.setFont(TEXT_FONT);
        blueLabel = new JLabel("What is the Blue Value?"); 
        blueLabel.setForeground(LIGHT_COLOR);
        blueLabel.setFont(TEXT_FONT);
        vsCurrentLabel = new JLabel("What is the VsCurrent?"); 
        vsCurrentLabel.setForeground(LIGHT_COLOR);
        vsCurrentLabel.setFont(TEXT_FONT);
        
        //fields
        pathField = new JTextField(20);
        lwField = new JTextField(20);
        redField = new JTextField(20);
        greenField = new JTextField(20);
        blueField = new JTextField(20);
        
        //field bg/color
        lwField.setBackground(BK_COLOR2);
        redField.setBackground(BK_COLOR2);
        greenField.setBackground(BK_COLOR2);
        blueField.setBackground(BK_COLOR2);
        pathField.setBackground(BK_COLOR2);
        lwField.setFont(TEXT_FONT);
        redField.setFont(TEXT_FONT);
        greenField.setFont(TEXT_FONT);
        blueField.setFont(TEXT_FONT);
        pathField.setFont(TEXT_FONT);
        lwField.setForeground(LIGHT_COLOR);
        redField.setForeground(LIGHT_COLOR);
        greenField.setForeground(LIGHT_COLOR);
        blueField.setForeground(LIGHT_COLOR);
        pathField.setForeground(LIGHT_COLOR);
        lwField.setCaretColor(Color.WHITE);
        redField.setCaretColor(Color.WHITE);
        greenField.setCaretColor(Color.WHITE);
        blueField.setCaretColor(Color.WHITE);
        pathField.setCaretColor(Color.WHITE);
        
        //set defaults
        pathField.setText(DbClient.getSetting(0));
        lwField.setText(DbClient.getSetting(1));
        redField.setText(DbClient.getSetting(3));
        greenField.setText(DbClient.getSetting(4));
        blueField.setText(DbClient.getSetting(5));
        
        //radiobuttons
        frame2dButton = new JRadioButton("2dWireFrame");
        frameButton = new JRadioButton("Wireframe");
        hiddenButton = new JRadioButton("Hidden");
        realisitcButton = new JRadioButton("Realistic");
        conceptualButton = new JRadioButton("Conceptual");
        shadedButton = new JRadioButton("Shaded");
        shadedEdgesButton = new JRadioButton("Shaded with Edges");
        shadeGrayButton = new JRadioButton("Shades of Gray");
        sketchyButton = new JRadioButton("SKetchy");
        xrayButton = new JRadioButton("X-ray");
        currentGroup = new ButtonGroup();
        currentGroup.add(frame2dButton);
        currentGroup.add(frameButton);
        currentGroup.add(hiddenButton);
        currentGroup.add(realisitcButton);
        currentGroup.add(conceptualButton);
        currentGroup.add(shadedButton);
        currentGroup.add(shadedEdgesButton);
        currentGroup.add(shadeGrayButton);
        currentGroup.add(sketchyButton);
        currentGroup.add(xrayButton);
        
        //button bg/color
        frame2dButton.setBackground(BK_COLOR2);
        frameButton.setBackground(BK_COLOR2);
        hiddenButton.setBackground(BK_COLOR2);
        realisitcButton.setBackground(BK_COLOR2);
        conceptualButton.setBackground(BK_COLOR2);
        shadedButton.setBackground(BK_COLOR2);
        shadedEdgesButton.setBackground(BK_COLOR2);
        shadeGrayButton.setBackground(BK_COLOR2);
        sketchyButton.setBackground(BK_COLOR2);
        xrayButton.setBackground(BK_COLOR2);
        frame2dButton.setForeground(LIGHT_COLOR);
        frameButton.setForeground(LIGHT_COLOR);
        hiddenButton.setForeground(LIGHT_COLOR);
        realisitcButton.setForeground(LIGHT_COLOR);
        conceptualButton.setForeground(LIGHT_COLOR);
        shadedButton.setForeground(LIGHT_COLOR);
        shadedEdgesButton.setForeground(LIGHT_COLOR);
        shadeGrayButton.setForeground(LIGHT_COLOR);
        sketchyButton.setForeground(LIGHT_COLOR);
        xrayButton.setForeground(LIGHT_COLOR);
//        frame2dButton.setFont(TEXT_FONT);
//        frameButton.setFont(TEXT_FONT);
//        hiddenButton.setFont(TEXT_FONT);
//        realisitcButton.setFont(TEXT_FONT);
//        conceptualButton.setFont(TEXT_FONT);
//        shadedButton.setFont(TEXT_FONT);
//        shadedEdgesButton.setFont(TEXT_FONT);
//        shadeGrayButton.setFont(TEXT_FONT);
//        sketchyButton.setFont(TEXT_FONT);
//        xrayButton.setFont(TEXT_FONT);

        
        //defaults
       if(DbClient.getSetting(2).equals("2D"))
       {    
           frame2dButton.setSelected(true);
       }
       else if(DbClient.getSetting(2).equals("W"))
       {    
           frameButton.setSelected(true);
       }
       else if(DbClient.getSetting(2).equals("H"))
       {    
           hiddenButton.setSelected(true);
       }
       else if(DbClient.getSetting(2).equals("R"))
       {    
           realisitcButton.setSelected(true);
       }
       else if(DbClient.getSetting(2).equals("C"))
       {
           conceptualButton.setSelected(true);
       }
       else if(DbClient.getSetting(2).equals("S"))
       {    
           shadedButton.setSelected(true);
       }
       else if(DbClient.getSetting(2).equals("E"))
       {    
           shadedEdgesButton.setSelected(true);
       }
       else if(DbClient.getSetting(2).equals("G"))
       {   
           shadeGrayButton.setSelected(true);
       }
       else if(DbClient.getSetting(2).equals("S"))
       {    
           sketchyButton.setSelected(true);
       }
       else if(DbClient.getSetting(2).equals("X"))
       {    
           xrayButton.setSelected(true);
       }
        
        //buttons
        applyButton = new JButton ("Apply Changes");
        applyButton.addActionListener(this);
        restoreButton = new JButton ("Restore Defaults");
        restoreButton.addActionListener(this);
        backButton = new JButton ("Back");
        backButton.addActionListener(this);
        
        //panels
        thePanel = new JPanel (new BorderLayout());
        thePanel.setBackground(BK_COLOR2);
        thePanel1 = new JPanel (new BorderLayout());
        thePanel1.setBackground(BK_COLOR2);
        thePanel2 = new JPanel (new BorderLayout());
        thePanel2.setBackground(BK_COLOR2);
        endPanel = new JPanel (new BorderLayout());
        endPanel.setBackground(BK_COLOR2);
        textPanel = new JPanel (new BorderLayout());
        textPanel.setBackground(BK_COLOR2);
        textPanel1 = new JPanel (new BorderLayout());
        textPanel1.setBackground(BK_COLOR2);
        textPanel2 = new JPanel (new BorderLayout());
        textPanel2.setBackground(BK_COLOR2);
        textPanel3 = new JPanel (new BorderLayout());
        textPanel3.setBackground(BK_COLOR2);
        textPanel4 = new JPanel (new BorderLayout());
        textPanel4.setBackground(BK_COLOR2);
        textPanel5 = new JPanel (new BorderLayout());
        textPanel5.setBackground(BK_COLOR2);
        textPanel6 = new JPanel (new BorderLayout());
        textPanel6.setBackground(BK_COLOR2);
        textPanel7 = new JPanel (new BorderLayout());
        textPanel7.setBackground(BK_COLOR2);
        buttonPanel = new JPanel (new FlowLayout());
        textPanel.add(pathLabel, BorderLayout.NORTH);
        textPanel.add(pathField, BorderLayout.CENTER);
        textPanel.add(lwLabel, BorderLayout.SOUTH);
        textPanel1.add(lwField, BorderLayout.NORTH);
        textPanel1.add(redLabel, BorderLayout.CENTER);
        textPanel1.add(redField, BorderLayout.SOUTH);
        textPanel2.add(greenLabel, BorderLayout.NORTH);
        textPanel2.add(greenField, BorderLayout.CENTER);
        textPanel2.add(blueLabel, BorderLayout.SOUTH);
        textPanel3.add(blueField, BorderLayout.NORTH);
        textPanel3.add(vsCurrentLabel, BorderLayout.CENTER);
        textPanel3.add(frame2dButton, BorderLayout.SOUTH);
        textPanel4.add(xrayButton, BorderLayout.NORTH);
        textPanel4.add(frameButton, BorderLayout.CENTER);
        textPanel4.add(hiddenButton, BorderLayout.SOUTH);
        textPanel5.add(realisitcButton, BorderLayout.NORTH);
        textPanel5.add(conceptualButton, BorderLayout.CENTER);
        textPanel5.add(shadedButton, BorderLayout.SOUTH);
        textPanel6.add(shadedEdgesButton, BorderLayout.NORTH);
        textPanel6.add(shadeGrayButton, BorderLayout.CENTER);
        textPanel6.add(sketchyButton, BorderLayout.SOUTH);
        textPanel7.add(xrayButton, BorderLayout.NORTH);
        thePanel.add(textPanel, BorderLayout.NORTH);
        thePanel.add(textPanel1, BorderLayout.CENTER);
        thePanel.add(textPanel2, BorderLayout.SOUTH);
        thePanel1.add(textPanel3, BorderLayout.NORTH);
        thePanel1.add(textPanel4, BorderLayout.CENTER);
        thePanel1.add(textPanel5, BorderLayout.SOUTH);
        thePanel2.add(textPanel6, BorderLayout.NORTH);
        thePanel2.add(textPanel7, BorderLayout.CENTER);
        endPanel.add(thePanel, BorderLayout.NORTH);
        endPanel.add(thePanel1,BorderLayout.CENTER);
        buttonPanel.add(applyButton);
        buttonPanel.add(restoreButton);
        buttonPanel.add(backButton);
        buttonPanel.setBackground(BK_COLOR2);

        //adding panels
        this.add(endPanel, BorderLayout.NORTH);
        this.add(thePanel2, BorderLayout.CENTER);
        this.add(buttonPanel, BorderLayout.SOUTH);
        this.revalidate();
        this.setVisible(true);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();
        
        if (command.equals("Back"))
        {
                this.dispose();
              
        }
        if (command.equals("Apply Changes"))
        {      
            //applies changes
            //robust and checks wheter there are errors with a boolean and try/catch
               error = false;
               
               try {
                   path = pathField.getText();
                   thickness = Double.parseDouble(lwField.getText());
                   red = Integer.parseInt(redField.getText());
                   green = Integer.parseInt(greenField.getText());
                   blue = Integer.parseInt(blueField.getText());
                   if(lwField.getText().length() > MAX_DIGIT || redField.getText().length() > MAX_DIGIT
                                || greenField.getText().length() > MAX_DIGIT || blueField.getText().length() > MAX_DIGIT)
                    {
                            error = true;
                            //error dialog box
                            JOptionPane.showMessageDialog(null, "Please enter 4 or less digits for color values and Lw thickness");
                    }
                   if(pathField.getText().length() > MAX_PATH)
                   {
                            error = true;
                            //error dialog box
                            JOptionPane.showMessageDialog(null, "Please enter less than 100 digits for path");
                   }
                }
               catch(NumberFormatException nfe) {
                   //dialog box
                   JOptionPane.showMessageDialog(null, "Please enter integers for color values and a double for Lw thickness");
                   error = true;
               }
               
               //path checker
               
               try {
                    pathChecker(path);
                } catch (IOException ex) {
                    Logger.getLogger(Input.class.getName()).log(Level.SEVERE, null, ex);
                }
               
               //color checker
               if (error == false) 
               {
                    if (red > 255 || red < 0 || green > 255 || green < 0 || blue > 255 || blue < 0)
                    {
                        //dialog box
                        JOptionPane.showMessageDialog(null, "Please enter a color value between 0 and 255.");
                        error = true;
                    }
                }
               if (error == false)
               {
               //thickness checker
                    if (thickness > 2 || thickness < 0)
                    {
                        //dialog box
                        JOptionPane.showMessageDialog(null, "Please enter a lineweight thickness between 0 and 2.");
                        error = true;
                    }
               }
               //nested if else assigns value off radio buttons
               if(frame2dButton.isSelected())
               {    
                   vsCurrent = "2D";
               }
               else if(frameButton.isSelected())
               {    
                   vsCurrent = "W";
               }
               else if(hiddenButton.isSelected())
               {    
                   vsCurrent = "H";
               }
               else if(realisitcButton.isSelected())
               {    
                   vsCurrent = "R";
               }
               else if(conceptualButton.isSelected())
               {
                   vsCurrent = "C";
               }
               else if(shadedButton.isSelected())
               {    
                   vsCurrent = "S";
               }
               else if(shadedEdgesButton.isSelected())
               {    
                   vsCurrent = "E";
               }
               else if(shadeGrayButton.isSelected())
               {   
                   vsCurrent = "G";
               }
               else if(sketchyButton.isSelected())
               {    
                   vsCurrent = "S";
               }
               else if(xrayButton.isSelected())
               {    
                   vsCurrent = "X";
               }
               
               if (error == false)
               {
                    DbClient.settingChange(path, 0);
                    DbClient.settingChange(lwField.getText(), 1);
                    DbClient.settingChange(vsCurrent, 2);
                    DbClient.settingChange(redField.getText(), 3);
                    DbClient.settingChange(greenField.getText(), 4);
                    DbClient.settingChange(blueField.getText(), 5);
                    
                    this.dispose();
                    Settings SetDbClient = new Settings();
                    
                    //dialog box
                    JOptionPane.showMessageDialog(null, "Settings updated successfully.");
                    error = true;
               }
        }
        
        if (command.equals("Restore Defaults"))
        {       
            DbClient.restoreDefaults();
               
            this.dispose();
            Settings SetDbClient = new Settings();
               
            //dialog box
            JOptionPane.showMessageDialog(null, "Settings updated successfully.");
            error = true;
        }

    }

    //checks validity of path and adds slash if neccessary
    public void pathChecker(String text) throws IOException  
    {
        String OS = System.getProperty("os.name");
        OS = OS.substring(0, Math.min(OS.length(), 7));
        System.out.println(OS);
        try 
        {
            if (!(Files.isDirectory(Paths.get(text)))) 
            {
                //dialog box
                JOptionPane.showMessageDialog(null, "Specified path doesn't exist.");
                error = true;
            }
            else if (OS.equals("Windows"))
            {
                if (!(text.charAt(text.length() - 1) == ('\\'))) 
                {
                path = text + "\\";
                }
            }
            else 
            {
                if (!(text.charAt(text.length() - 1) == ('/'))) 
                {
                    path = text + "/";
                }
            }
        }
        catch(java.nio.file.InvalidPathException err)
        {
            //dialog box
            JOptionPane.showMessageDialog(null, "Specified path doesn't exist.");
            error = true;
        }
    }
    
//    public static void main(String[] args) {
//        Settings Settingsobj = new Settings();
//    }
    
    
    
}
