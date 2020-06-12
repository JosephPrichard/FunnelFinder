/*
 This class is the main GUI class that provides an introduction on how the program works, into the GUI, and how this program is structured
 */
//package heskethfunnelfinder;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

/**
 *
 * 
 */
public class Welcome extends JFrame implements ActionListener {
    
    //declaration
    private JPanel textPanel;
    private JPanel imagePanel;
    private JPanel buttonPanel;
    private JLabel explainLabel;
    private JLabel explainLabel1;
    private JLabel explainLabel2;
    private JLabel imageLabel;
    private JButton startButton;
    private JMenuBar mainBar;
    private JMenu dataMenu;
    private JMenuItem dataOption;
    private JMenu helpMenu;
    private JMenuItem helpOption;
    private JMenu settingsMenu;
    private JMenuItem settingsOption;
    
    //declaring constants of classes related to JFrame
    public final Color LIGHT_COLOR = new Color(192,192,192);
    public final Color BK_COLOR2 = new Color(0,0,0);
    public final Color BK_COLOR = new Color(255,255,255);
    public final Font TEXT_FONT = new Font("Comic Sans MS", Font.BOLD | Font.ITALIC, 30);
    private final java.net.URL IMAGE_URL = getClass().getResource("cadgrid.jpg");
    private final ImageIcon IMAGE = new ImageIcon(new ImageIcon(IMAGE_URL).getImage().getScaledInstance(800,800,Image.SCALE_DEFAULT));
    
    public Welcome()
    {
        //sets important basics of the frame
        super("Funnel Finder");
        this.setBounds(350,40,1200,950);
        this.setExtendedState(JFrame.MAXIMIZED_BOTH); 
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.getContentPane().setBackground(BK_COLOR);
        this.setLayout(new BorderLayout());
        
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
        
        //labels
        explainLabel = new JLabel("Welcome to Funnel Finder. This program calculates vertices and faces of a funnel transitioned between circles or squares."); 
        explainLabel.setForeground(LIGHT_COLOR);
        explainLabel.setFont(TEXT_FONT);
        explainLabel1 = new JLabel("This program will output a script for use in Autocad."); 
        explainLabel1.setForeground(LIGHT_COLOR);
        explainLabel1.setFont(TEXT_FONT);
        explainLabel2 = new JLabel("Click the button to Start the program."); 
        explainLabel2.setForeground(LIGHT_COLOR);
        explainLabel2.setFont(TEXT_FONT);
        imageLabel = new JLabel(IMAGE);
        
        //formatting buttons
        startButton = new JButton ("Start");
        startButton.addActionListener(this);
        
        //panels
        textPanel = new JPanel (new BorderLayout());
        textPanel.setBackground(BK_COLOR2);
        textPanel.add(explainLabel, BorderLayout.NORTH);
        textPanel.add(explainLabel1, BorderLayout.CENTER);
        textPanel.add(explainLabel2, BorderLayout.SOUTH);
        imagePanel = new JPanel(new BorderLayout());
        imagePanel.setBackground(BK_COLOR);
        imagePanel.add(imageLabel);
        imagePanel.setBackground(BK_COLOR2);
        buttonPanel = new JPanel(new FlowLayout());
        buttonPanel.add(startButton);
        buttonPanel.setBackground(BK_COLOR2);
        
        //adding panels and menubar
        this.add(textPanel, BorderLayout.NORTH);
        this.add(imagePanel, BorderLayout.CENTER);
        this.add(buttonPanel, BorderLayout.SOUTH);
        this.setJMenuBar(mainBar);
        this.setVisible(true);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();
        
        if (command.equals("Start"))
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
    
    public static void main(String[] args) {
        // TODO code application logic here
        Welcome WelcomeObj = new Welcome();
    }
    
}
