/*
This class receives a passed ID contained within the database and displays themi in a GUI
This class can access the inputs class to use the same script generation method 
This allows the database to be used as a "library" for scripts
 */
//package heskethfunnelfinder;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;

/**
 *
 * 
 */
public class IDViewer extends JFrame implements ActionListener{
    
    public final Font FIELD_FONT = new Font("Comic Sans MS", Font.PLAIN, 40);
    public final Color INPUT_COLOR = new Color(0,51,102);
    public final Color BK_COLOR2 = new Color(0,0,0);
    public final Color LIGHT_COLOR = new Color(192,192,192);
    
    private JPanel panel1;
    private JPanel panel2;
    private JPanel colorPanel;
    private JPanel endPanel;
    private JLabel inputLabel;
    private JLabel heightLabel;
    private JLabel thicknessLabel;
    private JLabel radiusLabel;
    private JLabel radius1Label;
    private JLabel sideLabel;
    private JLabel side1Label;
    private JLabel sectorsLabel;
    private JButton returnButton;
    private JButton generateButton;
    private JPanel buttonPanel;
    
    private String[] inputs;
    private String name;
    private String time;
    
    //shapetypes
    private static final String CTC = "2";
    private static final String STC = "1";
    
    public IDViewer(int id)
    {
        //sets important basics of the frame
        super("IDViewer");
        this.setBounds(500,200,700,410);
        this.setResizable(false);
//        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        this.getContentPane().setBackground(Color.LIGHT_GRAY);
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.setLayout(new BorderLayout());
        
        //database transfer to get the inputs
        inputs = DbClient.searchIndex(id);
        name = DbClient.searchName(id);
        time = DbClient.searchTime(id);
        System.out.println(Arrays.deepToString(inputs));
           
        //panels
        panel1 = new JPanel(new BorderLayout());
        panel2 = new JPanel(new BorderLayout());
        colorPanel = new JPanel(new BorderLayout());
        endPanel = new JPanel(new BorderLayout());
        panel1.setBackground(BK_COLOR2);
        panel2.setBackground(BK_COLOR2);
        colorPanel.setBackground(BK_COLOR2);
 
        //labels will be constructed depending on funnel type
        //1 is stc, 2 is ctc, 3 is sts
        //funnel type is stored in last slot
        System.out.println(inputs[inputs.length - 1]);
        if(inputs[inputs.length - 1].equals(STC))
        {
        
            inputLabel = new JLabel("For Funnel_ID: " + id); // + ", Height: " + inputs[0] + ", Thickness: " + inputs[1] + ", Side: " + inputs[2] + ", Radius: " + inputs[3] + ", Sectors: " + inputs[4]);
            inputLabel.setFont(FIELD_FONT);
            inputLabel.setForeground(LIGHT_COLOR);
            heightLabel = new JLabel("Height: " + inputs[0]);
            heightLabel.setFont(FIELD_FONT);
            heightLabel.setForeground(LIGHT_COLOR);
            sideLabel = new JLabel("Side: " + inputs[2]);
            sideLabel.setFont(FIELD_FONT);
            sideLabel.setForeground(LIGHT_COLOR);
            radiusLabel = new JLabel("Radius: " + inputs[3]);
            radiusLabel.setFont(FIELD_FONT);
            radiusLabel.setForeground(LIGHT_COLOR);
            sectorsLabel = new JLabel("Sectors: " + inputs[4]);
            sectorsLabel.setFont(FIELD_FONT);
            sectorsLabel.setForeground(LIGHT_COLOR);
            thicknessLabel = new JLabel("Thickness: " + inputs[1]);
            thicknessLabel.setFont(FIELD_FONT);
            thicknessLabel.setForeground(LIGHT_COLOR);
            panel1.add(inputLabel, BorderLayout.NORTH);
            panel1.add(heightLabel, BorderLayout.CENTER);
            panel1.add(sideLabel, BorderLayout.SOUTH);
            panel2.add(radiusLabel, BorderLayout.NORTH);
            panel2.add(sectorsLabel, BorderLayout.CENTER);
            panel2.add(thicknessLabel, BorderLayout.SOUTH);
        }
        else if(inputs[inputs.length - 1].equals(CTC))
        {
            inputLabel = new JLabel("For Funnel_ID: " + id); // + ", Height: " + inputs[0] + ", Thickness: " + inputs[1] + ", Radius: " + inputs[2] + ", Radius: " + inputs[3] + ", Sectors: " + inputs[4]);
            inputLabel.setFont(FIELD_FONT);
            inputLabel.setForeground(LIGHT_COLOR);
            heightLabel = new JLabel("Height: " + inputs[0]);
            heightLabel.setFont(FIELD_FONT);
            heightLabel.setForeground(LIGHT_COLOR);
            radius1Label = new JLabel("Radius: " + inputs[2]);
            radius1Label.setFont(FIELD_FONT);
            radius1Label.setForeground(LIGHT_COLOR);
            radiusLabel = new JLabel("Radius: " + inputs[3]);
            radiusLabel.setFont(FIELD_FONT);
            radiusLabel.setForeground(LIGHT_COLOR);
            sectorsLabel = new JLabel("Sectors: " + inputs[4]);
            sectorsLabel.setFont(FIELD_FONT);
            sectorsLabel.setForeground(LIGHT_COLOR);
            thicknessLabel = new JLabel("Thickness: " + inputs[1]);
            thicknessLabel.setFont(FIELD_FONT);
            thicknessLabel.setForeground(LIGHT_COLOR);
            panel1.add(inputLabel, BorderLayout.NORTH);
            panel1.add(heightLabel, BorderLayout.CENTER);
            panel1.add(radius1Label, BorderLayout.SOUTH);
            panel2.add(radiusLabel, BorderLayout.NORTH);
            panel2.add(sectorsLabel, BorderLayout.CENTER);
            panel2.add(thicknessLabel, BorderLayout.SOUTH);
        }
        else
        {
            inputLabel = new JLabel("For Funnel_ID: " + id); // + ", Height: " + inputs[0] + ", Thickness: " + inputs[1] + ", Side: " + inputs[2] + ", Side: " + inputs[3]);
            inputLabel.setFont(FIELD_FONT);
            inputLabel.setForeground(LIGHT_COLOR);
            heightLabel = new JLabel("Height: " + inputs[0]);
            heightLabel.setFont(FIELD_FONT);
            heightLabel.setForeground(LIGHT_COLOR);
            side1Label = new JLabel("Side: " + inputs[2]);
            side1Label.setFont(FIELD_FONT);
            side1Label.setForeground(LIGHT_COLOR);
            sideLabel = new JLabel("Side: " + inputs[3]);
            sideLabel.setFont(FIELD_FONT);
            sideLabel.setForeground(LIGHT_COLOR);
            thicknessLabel = new JLabel("Thickness: " + inputs[1]);
            thicknessLabel.setFont(FIELD_FONT);
            thicknessLabel.setForeground(LIGHT_COLOR);
            panel1.add(inputLabel, BorderLayout.NORTH);
            panel1.add(heightLabel, BorderLayout.CENTER);
            panel1.add(side1Label, BorderLayout.SOUTH);
            panel2.add(sideLabel, BorderLayout.NORTH);
            panel2.add(thicknessLabel, BorderLayout.SOUTH);
        }
        
        //add to end panel
        endPanel.add(panel1, BorderLayout.NORTH);
        endPanel.add(panel2, BorderLayout.SOUTH);
        
        //buttons
        returnButton = new JButton ("Back");
        returnButton.addActionListener(this);
        generateButton = new JButton ("Generate Script");
        generateButton.addActionListener(this);
        buttonPanel = new JPanel(new FlowLayout());
        buttonPanel.add(returnButton);
        buttonPanel.add(generateButton);
        buttonPanel.setBackground(BK_COLOR2);
        
        //add panels
        this.add(endPanel, BorderLayout.NORTH);
        this.add(colorPanel, BorderLayout.CENTER);
        this.add(buttonPanel, BorderLayout.SOUTH);
        this.setVisible(true);
        
    }
    
    public void actionPerformed(ActionEvent e) {
        
        String command = e.getActionCommand();
        
        if (command.equals("Back"))
        {
            this.dispose();
        }
        if (command.equals("Generate Script"))
        {
            //generates a script based off the information retrieved from database
            Input inObj = new Input();
            time = inObj.specialRemover(time);
            if(inputs[inputs.length - 1].equals("1"))
            {
                SquareToCircle Stc = new SquareToCircle(name, Double.parseDouble(inputs[0]), 
                        Double.parseDouble(inputs[2]), Double.parseDouble(inputs[3]), Double.parseDouble(inputs[4]), Double.parseDouble(inputs[1]));
                try {
                    inObj.outputGenerator(Stc.getScript(), name + "-" + time);
                } catch (IOException ex) {
                    Logger.getLogger(Input.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            else if(inputs[inputs.length - 1].equals("2"))
            {
                CircleToCircle Ctc = new CircleToCircle(name, Double.parseDouble(inputs[0]), 
                        Double.parseDouble(inputs[2]), Double.parseDouble(inputs[3]), Double.parseDouble(inputs[4]), Double.parseDouble(inputs[1]));
                try {
                    inObj.outputGenerator(Ctc.getScript(), name + "-" + time);
                } catch (IOException ex) {
                    Logger.getLogger(Input.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            else
            {
                SquareToSquare Sts = new SquareToSquare(name, Double.parseDouble(inputs[0]), 
                        Double.parseDouble(inputs[2]), Double.parseDouble(inputs[3]), Double.parseDouble(inputs[1]));
                try {
                    inObj.outputGenerator(Sts.getScript(), name + "-" + time);
                } catch (IOException ex) {
                    Logger.getLogger(Input.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

        }
        
    }
    
//        
//    public static void main(String[] args) {
//        IDViewer IDObj = new IDViewer(1);
//    }
    
}
