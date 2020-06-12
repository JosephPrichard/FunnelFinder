/*
This class functions as the main centerpiece for script creation, input insertion, and database calling
First, a GUI is provided to insert inputs
When the inputs are inserted, funnel objects are constructed with passed funnel inputs
This class then extracts the script out of each object and creates a file containing the script
This class also adds the inputs into the database 
*/
//package heskethfunnelfinder;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * 
 */
public class Input extends JFrame implements ActionListener {
    
    //declaration
    private JLabel imageLabel;
    private JPanel imagePanel;
    private JPanel buttonPanel;
    private JButton nextButton;
    private JButton backButton;
    private JMenuBar mainBar;
    private JMenu dataMenu;
    private JMenuItem dataOption;
    private JMenu helpMenu;
    private JMenuItem helpOption;
    private JMenu settingsMenu;
    private JMenuItem settingsOption;
    //input declaration
    private JLabel sideLabel;
    private JLabel sideLabel1;
    private JLabel radiusLabel;
    private JLabel radiusLabel1;
    private JLabel heightLabel;
    private JLabel sectorLabel;
    private JLabel nameLabel;
    private JLabel thickLabel;
    private JTextField radiusField;
    private JTextField radiusField1;
    private JTextField heightField;
    private JTextField sideField;
    private JTextField sideField1;
    private JTextField sectorField;
    private JTextField nameField;
    private JTextField thickField;
    //important panels
    private JPanel top;
    private JPanel mid;
    private JPanel bot;
    private JPanel panel1;
    private JPanel panel2;
    private JPanel thePanel;
    private JPanel panel3;
    //field variables
    private static int type;
    private static double radius;
    private static double radius1;
    private static double side;
    private static double side1;
    private static double height;
    private static double sectors;
    private static double thickness;
    //for testing values
    private static int intTester;
    //shapetypes
    private static final int STS = 3;
    private static final int CTC = 2;
    private static final int STC = 1;
    
    //for error checking
    public static final double MIN_VALUE = 0.001;
    public static final int MAX_DIGIT = 8;
    public static boolean error = false;
    
    //declaring constants of classes related to JFrame
    public final Font FIELD_FONT = new Font("Comic Sans MS", Font.PLAIN, 40);
    public final Font FIELD_FONT1 = new Font("Comic Sans MS", Font.PLAIN, 25);
    public final Color INPUT_COLOR = new Color(0,51,102);
    public final Color LIGHT_COLOR = new Color(192,192,192);
    public final Color BK_COLOR2 = new Color(0,0,0);
    public final Color BK_COLOR = new Color(255,255,255);
    private final java.net.URL IMAGE_URL = getClass().getResource("pic.jpg");
    private final ImageIcon IMAGE = new ImageIcon(new ImageIcon(IMAGE_URL).getImage().getScaledInstance(450,350,Image.SCALE_DEFAULT));
    
    //generic input constructor to use input methods
    public Input()
    {
        
    }
    
    //frame constructor
    public Input(int shapeType)
    {
        //sets important basics of the frame
        super("Inputs");
        this.setBounds(350,40,1200,950);
        this.setExtendedState(JFrame.MAXIMIZED_BOTH); 
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.getContentPane().setBackground(BK_COLOR);
        this.setLayout(new BorderLayout());
        
        //set equal
        type = shapeType;
        
        //menu
        mainBar = new JMenuBar();
        dataMenu = new JMenu("Database");
        dataOption = new JMenuItem("View Database");
        dataOption.addActionListener(this);
        dataMenu.add(dataOption);
        helpMenu = new JMenu("Help");
        helpOption = new JMenuItem("View Help");
        helpOption.addActionListener(this);
        helpMenu.add(helpOption);
        settingsMenu = new JMenu("Settings");
        settingsOption = new JMenuItem("View Settings");
        settingsOption.addActionListener(this);
        settingsMenu.add(settingsOption);
        mainBar.add(dataMenu);
        mainBar.add(settingsMenu);
        mainBar.add(helpMenu);
        
        //labels and textfields
        sideLabel = new JLabel("Enter side length");
        sideLabel.setFont(FIELD_FONT);
        sideLabel.setForeground(LIGHT_COLOR);
        sideLabel1 = new JLabel("Enter other side length (this will be on top)");
        sideLabel1.setFont(FIELD_FONT);
        sideLabel1.setForeground(LIGHT_COLOR);
        radiusLabel = new JLabel("Enter radius length");
        radiusLabel.setFont(FIELD_FONT);
        radiusLabel.setForeground(LIGHT_COLOR);
        radiusLabel1 = new JLabel("Enter other radius length (this will be on top)");
        radiusLabel1.setFont(FIELD_FONT);
        radiusLabel1.setForeground(LIGHT_COLOR);
        heightLabel = new JLabel("Enter height ");
        heightLabel.setFont(FIELD_FONT);
        heightLabel.setForeground(LIGHT_COLOR);
        sectorLabel = new JLabel("Enter number of pseudo-circle sectors ");
        sectorLabel.setFont(FIELD_FONT);
        sectorLabel.setForeground(LIGHT_COLOR);
        nameLabel = new JLabel("Enter project name");
        nameLabel.setFont(FIELD_FONT);
        nameLabel.setForeground(LIGHT_COLOR);
        thickLabel = new JLabel("Enter wall thickness");
        thickLabel.setFont(FIELD_FONT);
        thickLabel.setForeground(LIGHT_COLOR);
        radiusField = new JTextField(20);
        radiusField1 = new JTextField(20);
        heightField = new JTextField(20);
        sideField = new JTextField(20);
        sideField1 = new JTextField(20);
        sectorField = new JTextField(20);
        nameField = new JTextField(20);
        thickField = new JTextField(20);
        radiusField.setBackground(BK_COLOR2);
        radiusField1.setBackground(BK_COLOR2);
        heightField.setBackground(BK_COLOR2);
        sideField.setBackground(BK_COLOR2);
        sideField1.setBackground(BK_COLOR2);
        sectorField.setBackground(BK_COLOR2);
        nameField.setBackground(BK_COLOR2);
        thickField.setBackground(BK_COLOR2);
        radiusField.setFont(FIELD_FONT1);
        radiusField1.setFont(FIELD_FONT1);
        sideField.setFont(FIELD_FONT1);
        sideField1.setFont(FIELD_FONT1);
        heightField.setFont(FIELD_FONT1);
        nameField.setFont(FIELD_FONT1);
        sectorField.setFont(FIELD_FONT1);
        thickField.setFont(FIELD_FONT1);
        radiusField.setForeground(LIGHT_COLOR);
        radiusField1.setForeground(LIGHT_COLOR);
        sideField.setForeground(LIGHT_COLOR);
        sideField1.setForeground(LIGHT_COLOR);
        heightField.setForeground(LIGHT_COLOR);
        nameField.setForeground(LIGHT_COLOR);
        sectorField.setForeground(LIGHT_COLOR);
        thickField.setForeground(LIGHT_COLOR);
        radiusField.setCaretColor(Color.WHITE);
        radiusField1.setCaretColor(Color.WHITE);
        sideField.setCaretColor(Color.WHITE);
        sideField1.setCaretColor(Color.WHITE);
        heightField.setCaretColor(Color.WHITE);
        nameField.setCaretColor(Color.WHITE);
        sectorField.setCaretColor(Color.WHITE);
        thickField.setCaretColor(Color.WHITE);
        imageLabel = new JLabel(IMAGE);
        
        //formatting buttons
        nextButton = new JButton ("Construct");
        nextButton.addActionListener(this);
        backButton = new JButton ("Back");
        backButton.addActionListener(this);
        
        //panels
        imagePanel = new JPanel(new BorderLayout());
        imagePanel.setBackground(BK_COLOR2);
        imagePanel.add(imageLabel);
        buttonPanel = new JPanel(new FlowLayout());
        buttonPanel.add(backButton);
        buttonPanel.add(nextButton);
        buttonPanel.setBackground(BK_COLOR2);
        
        panel2 = new JPanel(new BorderLayout());
        panel2.add(nameLabel, BorderLayout.NORTH);
        panel2.add(nameField, BorderLayout.CENTER);
        panel2.setBackground(BK_COLOR2);
        panel3 = new JPanel(new BorderLayout());
        panel3.add(thickLabel, BorderLayout.NORTH);
        panel3.add(thickField, BorderLayout.CENTER);
        panel3.setBackground(BK_COLOR2);
        
        //constructs gui based on type of funnel passed from shapeselect
        if (type == STC)
        {
        //square to circle
            panel1 = new JPanel(new BorderLayout());
            top = new JPanel(new BorderLayout());
            mid = new JPanel(new BorderLayout());
            bot = new JPanel(new BorderLayout());
            top.add(heightLabel, BorderLayout.NORTH);
            top.add(heightField, BorderLayout.CENTER);
            top.add(sideLabel, BorderLayout.SOUTH);
            top.setBackground(BK_COLOR2);
            mid.add(sideField, BorderLayout.NORTH);
            mid.add(radiusLabel, BorderLayout.CENTER);
            mid.add(radiusField, BorderLayout.SOUTH);
            mid.setBackground(BK_COLOR2);
            bot.add(sectorLabel, BorderLayout.CENTER);
            bot.add(sectorField, BorderLayout.SOUTH);
            bot.setBackground(BK_COLOR2);
            panel1.add(top, BorderLayout.NORTH);
            panel1.add(mid, BorderLayout.CENTER);
            panel1.add(bot, BorderLayout.SOUTH);
        }
        else if (type == CTC)
        {
        //circle to circle
            panel1 = new JPanel(new BorderLayout());
            top = new JPanel(new BorderLayout());
            mid = new JPanel(new BorderLayout());
            bot = new JPanel(new BorderLayout());
            top.add(heightLabel, BorderLayout.NORTH);
            top.add(heightField, BorderLayout.CENTER);
            top.add(radiusLabel, BorderLayout.SOUTH);
            top.setBackground(BK_COLOR2);
            mid.add(radiusField, BorderLayout.NORTH);
            mid.add(radiusLabel1, BorderLayout.CENTER);
            mid.add(radiusField1, BorderLayout.SOUTH);
            mid.setBackground(BK_COLOR2);
            bot.add(sectorLabel, BorderLayout.CENTER);
            bot.add(sectorField, BorderLayout.SOUTH);
            bot.setBackground(BK_COLOR2);
            panel1.add(top, BorderLayout.NORTH);
            panel1.add(mid, BorderLayout.CENTER);
            panel1.add(bot, BorderLayout.SOUTH);
        }
        else if (type == STS) 
        {
        //square to square
            panel1 = new JPanel(new BorderLayout());
            top = new JPanel(new BorderLayout());
            mid = new JPanel(new BorderLayout());
            bot = new JPanel(new BorderLayout());
            top.add(heightLabel, BorderLayout.NORTH);
            top.add(heightField, BorderLayout.CENTER);
            top.add(sideLabel, BorderLayout.SOUTH);
            top.setBackground(BK_COLOR2);
            mid.add(sideField, BorderLayout.NORTH);
            mid.add(sideLabel1, BorderLayout.CENTER);
            mid.add(sideField1, BorderLayout.SOUTH);
            mid.setBackground(BK_COLOR2);
            panel1.add(top, BorderLayout.NORTH);
            panel1.add(mid, BorderLayout.CENTER);
        }
        
        //main panel
        thePanel = new JPanel(new BorderLayout());
        thePanel.add(panel2, BorderLayout.NORTH);
        thePanel.add(panel1, BorderLayout.CENTER);
        thePanel.add(panel3, BorderLayout.SOUTH);
        
        //adding panels and menubar
        this.add(buttonPanel, BorderLayout.SOUTH);
        this.add(imagePanel, BorderLayout.CENTER);
        this.add(thePanel, BorderLayout.NORTH);
        this.setJMenuBar(mainBar);
        this.setVisible(true);
    }
    
    //creates a file on laptop containg contents of passed string(script)
    public void outputGenerator(String script, String pName) throws IOException         
    {

        //copy scipt to clipboard
        StringSelection stringSelection = new StringSelection(script);
        Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
        clipboard.setContents(stringSelection, null);
        
        error = false;
        
        //check for ENTER_A_PATH default
        if(DbClient.getSetting(0).equals("ENTER_A_PATH"))
        {
            error = true;
            //dialog box
            JOptionPane.showMessageDialog(null, "Please set up a valid path in Settings!");
        }
        
        if (error == false) {
            //declare file path and name
            String name = pName;
            String scriptPath = DbClient.getSetting(0) + "" + name + ".scr";
            System.out.println(scriptPath);
            File file = new File(scriptPath);
            //create the file
            try {
                file.createNewFile();
                //write Content
                FileWriter writer = new FileWriter(file);
                writer.write(script);
                writer.close();

                //dialog box
                JOptionPane.showMessageDialog(null, "Script has been copied to clipboard and has been added to " + scriptPath);
            } catch (IOException io) {
                //dialog box
                JOptionPane.showMessageDialog(null, "Invalid path. Please add a valid path in settings.");
            }
        }
    }
    
    //gets time for laptop and returns it
    public String timeFinder()
    {
         Date date= new Date();
         long time = date.getTime();
         Timestamp ts = new Timestamp(time);
         String sts = ts.toString();
         return sts;
    }
    
    //removes certain special characters and replaces them with "-"
    public String specialRemover(String c)
    {
        c = c.replace(" ","-");
        c = c.replace(".","-");
        c = c.replace(":","-");
        return c;
    }
    
    public String spaceRemover(String c)
    {
        c = c.replace(" ","_");
        return c;
    }
    
    //returns false if string has any special characters
    public boolean specialChecker(String c)
    {
        boolean special = false;
        
        char cArray[] = new char[c.length()]; 
        cArray = c.toCharArray();
        for(int i = 0; i < cArray.length; i++)
        {
            if (cArray[i] == '/' || cArray[i] == '\\' || cArray[i] == ':' || cArray[i] == '*'
                    || cArray[i] == '?' || cArray[i] == '<' || cArray[i] == '>' || cArray[i] == '"' 
                     || cArray[i] == '|' || cArray[i] == '=' || cArray[i] == ';')
            {
                special = true;
            }
        }
        
        return special;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();
        
        if (command.equals("Construct"))
        {
            //exception handling
            error = false;
            String time;
            //check for exceptions, or invalid values in fields
            try 
            {
                //ensures that name length is less than 30
               if(nameField.getText().length() > 29 || nameField.getText().length() < 1)
                {
                    //error dialog box
                    JOptionPane.showMessageDialog(null, "Please enter a name between 1 and 30 characters.");
                    error = true;
                }
                if (type == STC) 
                {
                        height = Double.parseDouble(heightField.getText());
                        side = Double.parseDouble(sideField.getText());
                        radius = Double.parseDouble(radiusField.getText());
                        sectors = Double.parseDouble(sectorField.getText());
                        thickness = Double.parseDouble(thickField.getText());
                        if(height <= MIN_VALUE || side <= MIN_VALUE || radius <= MIN_VALUE
                                || sectors <= MIN_VALUE || thickness <= MIN_VALUE)
                        {
                            error = true;
                            //error dialog box
                            JOptionPane.showMessageDialog(null, "Please enter numbers larger than 0.001");
                        }
                        if(heightField.getText().length() > MAX_DIGIT || sideField.getText().length() > MAX_DIGIT || radiusField.getText().length() > MAX_DIGIT
                                || sectorField.getText().length() > MAX_DIGIT || thickField.getText().length() > MAX_DIGIT)
                        {
                            error = true;
                            //error dialog box
                            JOptionPane.showMessageDialog(null, "Please enter 8 or less digits in number fields.");
                        }
                }
                else if (type == CTC)
                {
                        height = Double.parseDouble(heightField.getText());
                        radius1 = Double.parseDouble(radiusField1.getText());
                        radius = Double.parseDouble(radiusField.getText());
                        sectors = Double.parseDouble(sectorField.getText());
                        thickness = Double.parseDouble(thickField.getText());
                        if(height <= MIN_VALUE || radius <= MIN_VALUE || radius1 <= MIN_VALUE
                                || sectors <= MIN_VALUE || thickness <= MIN_VALUE)
                        {
                            error = true;
                            //error dialog box
                            JOptionPane.showMessageDialog(null, "Please enter numbers larger than 0.001");
                        }
                        if(heightField.getText().length() > MAX_DIGIT || radiusField1.getText().length() > MAX_DIGIT || radiusField.getText().length() > MAX_DIGIT
                                || sectorField.getText().length() > MAX_DIGIT || thickField.getText().length() > MAX_DIGIT)
                        {
                            error = true;
                            //error dialog box
                            JOptionPane.showMessageDialog(null, "Please enter 8 or less digits in number fields.");
                        }
                }
                else if(type == STS)
                {
                        height = Double.parseDouble(heightField.getText());
                        side1 = Double.parseDouble(sideField1.getText());
                        side = Double.parseDouble(sideField.getText());
                        thickness = Double.parseDouble(thickField.getText());
                        if(height <= MIN_VALUE || side <= MIN_VALUE|| side1 <= MIN_VALUE
                                || thickness <= MIN_VALUE)
                        {
                            error = true;
                            //error dialog box
                            JOptionPane.showMessageDialog(null, "Please enter numbers larger than 0.001");
                        }
                        if(heightField.getText().length() > MAX_DIGIT || sideField1.getText().length() > MAX_DIGIT || sideField.getText().length() > MAX_DIGIT
                                || sectorField.getText().length() > MAX_DIGIT || thickField.getText().length() > MAX_DIGIT)
                        {
                            error = true;
                            //error dialog box
                            JOptionPane.showMessageDialog(null, "Please enter 8 or less digits in number fields.");
                        }
                }       
            }
            catch(NumberFormatException nfe)
            {
                error = true;
                //error dialog box
                JOptionPane.showMessageDialog(null, "Please enter a number in all non-name fields.");
            }   
            //checks for spcial characters in name
            if (error == false)
                if(specialChecker(nameField.getText()))
                {
                    //error dialog box
                    JOptionPane.showMessageDialog(null, "Please remove special characters / \\ : ; * ? \" | < > = from name.");
                    error = true;
                }    
            //
            //checks if sector value is a decimal
            if (error == false)
            {
                if (!(type == STS))
                {
                    try
                    {
                        intTester = Integer.parseInt(sectorField.getText());
                        System.out.println(intTester);
                    }
                    catch(NumberFormatException nfe)
                    {
                        error = true;
                        //error dialog box
                        JOptionPane.showMessageDialog(null, "Sectors must be an integer.");
                    
                    }
                }  
            }
            //pops up an option message if sector value is higher than 90
            if(error == false)
            {
                if (!(type == STS)) 
                {
                    if (Double.parseDouble(sectorField.getText()) > 90) 
                    {
                        Object[] options = {"Yes", "No"};
                        int option = JOptionPane.showOptionDialog(null, "Sector value higher than 90 can take a very long time and is not reccomended.. Proceed?", "Confirmation",
                                JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[1]);
                        //System.out.println(option);
                        if (option == 1) 
                        {
                            error = true;
                        }
                    }
                }
            }
            //creating the file, adding to the database, calling computation classes
            //only runs proccesses if there isn't an error
            if(error == false)
            {
                    //if statment checks the funnel type 1 is stc, 2 is ctc, 3 is sts
                    if (type == STC) 
                    {
                        System.out.println(height + " " + side + " " + radius + " " + sectors);
                        SquareToCircle SCObj = new SquareToCircle(spaceRemover(nameField.getText()), height, side, radius, sectors, thickness);
                        int id = DbClient.rowCounter() + 1;
                        time = timeFinder();
                        DbClient.funnelAdd(id, spaceRemover(nameField.getText()), time);
                        time = specialRemover(time);
                        DbClient.addStc(id, heightField.getText(), sideField.getText(), radiusField.getText(), sectorField.getText(), thickField.getText());
                        try {
                            outputGenerator(SCObj.getScript(), spaceRemover(nameField.getText()) + "-" + time);
                        } catch (IOException ex) {
                            Logger.getLogger(Input.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                    else if (type == CTC) 
                    {
                        System.out.println(height + " " + radius + " " + radius1 + " " + sectors);
                        CircleToCircle CCObj = new CircleToCircle(spaceRemover(nameField.getText()), height, radius, radius1, sectors, thickness);
                        int id = DbClient.rowCounter() + 1;
                        time = timeFinder();
                        DbClient.funnelAdd(id, spaceRemover(nameField.getText()), time);
                        time = specialRemover(time);
                        DbClient.addCtc(id, heightField.getText(), radiusField1.getText(), radiusField.getText(), sectorField.getText(), thickField.getText());
                        try {
                            outputGenerator(CCObj.getScript(), spaceRemover(nameField.getText()) + "-" + time);
                        } catch (IOException ex) {
                            Logger.getLogger(Input.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                    else if (type == STS) 
                    {
                        System.out.println(height + " " + side + " " + side1);
                        SquareToSquare SSObj = new SquareToSquare(spaceRemover(nameField.getText()), height, side, side1, thickness);
                        int id = DbClient.rowCounter() + 1;
                        time = timeFinder();
                        DbClient.funnelAdd(id, spaceRemover(nameField.getText()), time);
                        time = specialRemover(time);
                        DbClient.addSts(id, heightField.getText(), sideField1.getText(), sideField.getText(), thickField.getText());
                        try {
                            outputGenerator(SSObj.getScript(), spaceRemover(nameField.getText()) + "-" + time);
                        } catch (IOException ex) {
                            Logger.getLogger(Input.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
            }
                
        }
        //uses relationship
        if (command.equals("Back"))
        {
           //calling another class which contains another JFrame

                this.dispose();
                ShapeSelect SelectObj = new ShapeSelect();
                
        }
        
        if (command.equals("View Database"))
        {
           //calling another class which contains another JFrame

                DbViewer ViewObj = new DbViewer();
                
        }
        
        if (command.equals("View Help"))
        {
           //calling another class which contains another JFrame

                Help HelpObj = new Help();
                
        }
        
        if (command.equals("View Settings"))
        {
           //calling another class which contains another JFrame

                Settings SetObj = new Settings();
                
        }
 
    }
    
//        public static void main(String[] args) {
//        Input InputObj = new Input(2);
//    }
    
}
