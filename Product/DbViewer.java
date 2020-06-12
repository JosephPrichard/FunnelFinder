/*
This program constructs a JTable containing the funnels table stored within the database
It also provides a GUI to Delete/view a specific ID, or clear the entire database
 */
//package heskethfunnelfinder;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;
import javax.swing.table.JTableHeader;

/**
 *
 *
 */
public class DbViewer extends JFrame implements ActionListener {
    
    //table
    private final String[] COLUMN_HEADER = {"Funnel_ID", "Name", "Timestamp"};
    private JTable funnelsTable;
    private JScrollPane paneFul;
    private JTableHeader header;
    private JButton returnButton;
    private JButton clearButton;
    private JButton iDButton;
    private JPanel buttonPanel;
    
    //error?
    private boolean error;
    
    //declaring constants of classes related to JFrame
    public final Color LIGHT_COLOR = new Color(192,192,192);
    public final Color BK_COLOR2 = new Color(0,0,0);
    public final Color BK_COLOR = new Color(255,255,255);
    public final Font TEXT_FONT = new Font("Comic Sans MS", Font.BOLD | Font.ITALIC, 15);
    public final Font TITLE_FONT = new Font("Comic Sans MS", Font.BOLD | Font.ITALIC, 30);
    
    public DbViewer()
    {
        super("Funnel Table");
        this.setBounds(350,40,1190,950);
//        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        this.getContentPane().setBackground(Color.LIGHT_GRAY);
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.setLayout(new BorderLayout());
        
        //database transfer
        Object[][] funnels = DbClient.getFunnels();
        
        //table
        funnelsTable = new JTable(funnels,COLUMN_HEADER);
        paneFul = new JScrollPane();
        paneFul.getViewport().add(funnelsTable);
        funnelsTable.setFillsViewportHeight(true);
        header = funnelsTable.getTableHeader();
        header.setFont(TITLE_FONT);
        funnelsTable.setBackground(BK_COLOR2);
        funnelsTable.setFont(TEXT_FONT);
        paneFul.setBackground(BK_COLOR2);
        funnelsTable.setForeground(LIGHT_COLOR);
        
        //buttons
        returnButton = new JButton ("Back");
        returnButton.addActionListener(this);
        clearButton = new JButton ("Clear Database");
        clearButton.addActionListener(this);
        iDButton = new JButton ("Select ID");
        iDButton.addActionListener(this);
        buttonPanel = new JPanel(new FlowLayout());
        buttonPanel.add(returnButton);
        buttonPanel.add(clearButton);
        buttonPanel.add(iDButton);
//        buttonPanel.setBackground(BK_COLOR2);

        //adding panels 
        this.add(paneFul, BorderLayout.CENTER);
        this.add(buttonPanel, BorderLayout.SOUTH);
        this.setVisible(true);
    }
//     public static void main(String[] args){
//         DbViewer DbObj = new DbViewer();
//     }
     
    @Override
    public void actionPerformed(ActionEvent e) {
        
        String command = e.getActionCommand();
        
        if (command.equals("Back"))
        {
            this.dispose();
        }
        if (command.equals("Select ID"))
        {
            //error
            error = false;
            
            //dialog box will either delete an id or display it
            int id = 1;
            try 
            {
                id = Integer.parseInt(JOptionPane.showInputDialog(null, "Enter Funnel_ID"));
            }
            catch(NumberFormatException err)
            {
                error = true;
            }
            
            if(DbClient.searchName(id).equals(""))
            {
                error = true;
            }
            
            if (error == false)
            {
            
                Object[] options = {"View", "Delete"};
                int option = JOptionPane.showOptionDialog(null, "Do what with ID?", "Options", 
                    JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[1]);
                //System.out.println(option);
                if (option == 0)
                {
                    IDViewer obj2 = new IDViewer(id);
                }
                if (option == 1)
                {
                    DbClient.deleteFunnel(id);
                    DbClient.funnelOrder(); 
                    
                    this.dispose();
                    DbViewer ViewObj = new DbViewer();
                }
            }
            else
            {
                //error dialog box
                JOptionPane.showMessageDialog(null, "Invalid funnel ID.");
            }

        }
        if(command.equals("Clear Database"))
        {

            
             Object[] options = {"Yes", "No"};
                int option = JOptionPane.showOptionDialog(null, "Are you sure? This action cannot be undone.", "Confirm", 
                    JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[1]);
                //System.out.println(option);
                if (option == 0)
                {
                    DbClient.resetFunInputs();
            
                    this.dispose();
                    DbViewer ViewObj = new DbViewer();
                }
        }
        
    }
//        public static void main(String[] args) {
//        DbViewer ViewObj = new DbViewer();
//    }
    
    
}
