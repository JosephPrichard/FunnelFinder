//package heskethfunnelfinder;

 /*
This program allows the user to select the funnel type, and pass it into the input class
This will change the type of funnel object that will later be constructed
 */
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ButtonGroup;
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
import javax.swing.JRadioButton;

/**
 *
 * 
 */
public class ShapeSelect extends JFrame implements ActionListener {
    
    //declaration
    private JPanel textPanel;
    private JPanel imagePanel;
    private JPanel buttonPanel;
    private JPanel miniPanel;
    private JButton nextButton;
    private JButton backButton; 
    private JLabel shapeLabel;
    private JLabel imageLabel;
    private JMenuBar mainBar;
    private JMenu dataMenu;
    private JMenuItem dataOption;
    private JMenu helpMenu;
    private JMenuItem helpOption;
    private JMenu settingsMenu;
    private JMenuItem settingsOption;
    private JRadioButton squareToCircle;
    private JRadioButton squareToSquare;
    private JRadioButton circleToCircle;
    private ButtonGroup shapeGroup;
    //1 is circle 2 is square
    
    //declaring constants of classes related to JFrame
    public final Color LIGHT_COLOR = new Color(192,192,192);
    public final Color BK_COLOR2 = new Color(0,0,0);
    public final Color BK_COLOR = new Color(255,255,255);
    public final Font TEXT_FONT = new Font("Comic Sans MS", Font.BOLD | Font.ITALIC, 30);
    private final java.net.URL IMAGE_URL = getClass().getResource("pic.jpg");
    private final ImageIcon IMAGE = new ImageIcon(new ImageIcon(IMAGE_URL).getImage().getScaledInstance(800,600,Image.SCALE_DEFAULT));
    
    public ShapeSelect()
    {
        //sets important basics of the frame
        super("Shape Select");
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
        shapeLabel = new JLabel("Select your shape"); 
        shapeLabel.setForeground(LIGHT_COLOR);
        shapeLabel.setFont(TEXT_FONT);
        imageLabel = new JLabel(IMAGE);
        
        //formatting buttons
        nextButton = new JButton ("Next");
        nextButton.addActionListener(this);
        backButton = new JButton ("Back");
        backButton.addActionListener(this);
        squareToCircle = new JRadioButton("Square to Circle");
        circleToCircle = new JRadioButton("Circle to Circle");
        squareToSquare = new JRadioButton("Square to Square");
        squareToCircle.setOpaque(false);
        circleToCircle.setOpaque(false);
        squareToSquare.setOpaque(false);
        squareToCircle.setForeground(LIGHT_COLOR);
        circleToCircle.setForeground(LIGHT_COLOR);
        squareToSquare.setForeground(LIGHT_COLOR);
        squareToCircle.setFont(TEXT_FONT);
        circleToCircle.setFont(TEXT_FONT);
        squareToSquare.setFont(TEXT_FONT);
        shapeGroup = new ButtonGroup();
        shapeGroup.add(squareToCircle);
        shapeGroup.add(circleToCircle);
        shapeGroup.add(squareToSquare);    
        squareToCircle.setSelected(true);
        
        //panels
        textPanel = new JPanel (new BorderLayout());
        textPanel.setBackground(BK_COLOR2);
        miniPanel = new JPanel (new BorderLayout());
        miniPanel.setBackground(BK_COLOR2);
        //textPanel.setBackground(BK_COLOR2);
        miniPanel.add(squareToCircle, BorderLayout.NORTH);
        miniPanel.add(circleToCircle, BorderLayout.CENTER);
        miniPanel.add(squareToSquare, BorderLayout.SOUTH);
        textPanel.add(shapeLabel, BorderLayout.NORTH);
        textPanel.add(miniPanel, BorderLayout.CENTER);
        imagePanel = new JPanel(new BorderLayout());
        imagePanel.setBackground(BK_COLOR);
        imagePanel.add(imageLabel);
        imagePanel.setBackground(BK_COLOR2);
        buttonPanel = new JPanel(new FlowLayout());
        buttonPanel.add(backButton);
        buttonPanel.add(nextButton);  
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
        
        if (command.equals("Next"))
        {
           //calling another class which contains another JFrame
                //identify shapes
                //1 square to circle, 2 circle to circle, 3 square to square
                if(squareToCircle.isSelected())
                {
                    this.dispose();
                    Input inputObj = new Input(1);
                }
                else if(circleToCircle.isSelected())
                {
                    this.dispose();
                    Input inputObj = new Input(2);
                }
                else if(squareToSquare.isSelected())
                {   
                    this.dispose();
                    Input inputObj = new Input(3);
                }
                else
                {
                    System.out.println("Please select a shape.");
                    //dialog box
                    JOptionPane.showMessageDialog(null, "Please select a shape type.");
                }
                
        }
        if (command.equals("Back"))
        {
           //calling another class which contains another JFrame

                this.dispose();
                Welcome WelcomeObj = new Welcome();
                
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
    
//    public static void main(String[] args) {
//        // TODO code application logic here
//        ShapeSelect SelectObj = new ShapeSelect();
//    }
    
}