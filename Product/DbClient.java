/*
This class statically communicates with the JavaDb class to view, delete, or insert to database
 */
//package heskethfunnelfinder;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ArrayList;
/**
 *
 * 
 */
public class DbClient {
    
    //orders all the database records by ID
    public static void funnelOrder()
    {
        JavaDb objDb = new JavaDb("FunnelDb");
        Connection myDbConn;
        myDbConn = objDb.getDbConn();   
        String dbQuery1 = "SELECT * FROM Funnels " + "ORDER BY Funnel_ID";
        try 
        {
            PreparedStatement ps = myDbConn.prepareStatement(dbQuery1);
            ps.execute(); 
        }
        catch(Exception e)
        {
            System.out.println("didn't order: " + e);
        }
        String dbQuery2 = "SELECT * FROM Body " + "ORDER BY Funnel_ID";
        try 
        {
            PreparedStatement ps = myDbConn.prepareStatement(dbQuery2);
            ps.execute(); 
        }
        catch(Exception e)
        {
            System.out.println("didn't order: " + e);
        }
        String dbQuery3 = "SELECT * FROM Sides " + "ORDER BY Funnel_ID";
        try 
        {
            PreparedStatement ps = myDbConn.prepareStatement(dbQuery3);
            ps.execute(); 
        }
        catch(Exception e)
        {
            System.out.println("didn't order: " + e);
        }
        String dbQuery4 = "SELECT * FROM Radii " + "ORDER BY Funnel_ID";
        try 
        {
            PreparedStatement ps = myDbConn.prepareStatement(dbQuery4);
            ps.execute(); 
        }
        catch(Exception e)
        {
            System.out.println("didn't order: " + e);
        }
        String dbQuery5 = "SELECT * FROM Sectors " + "ORDER BY Funnel_ID";
        try 
        {
            PreparedStatement ps = myDbConn.prepareStatement(dbQuery5);
            ps.execute(); 
        }
        catch(Exception e)
        {
            System.out.println("didn't order: " + e);
        }
    }
    
    //assigns funnel to funnel table
    public static void funnelAdd(int pID, String pName, String pTime)
    {
    
        JavaDb objDb = new JavaDb("FunnelDb");
        Connection myDbConn;
        myDbConn = objDb.getDbConn();   
        int iDVar = pID;
        String nameVar = pName;
        String timeVar = pTime;
        String dbQuery1 = "INSERT INTO Funnels VALUES " + "(?,?,?)";  
        try 
        {
            PreparedStatement ps = myDbConn.prepareStatement(dbQuery1);
            ps.setInt(1, iDVar);
            ps.setString(2, nameVar);
            ps.setString(3, timeVar);
            System.out.println(dbQuery1);
            System.out.println(iDVar + nameVar + timeVar);
            ps.executeUpdate(); 
        }
        catch(Exception e)
        {
            System.out.println("didn't insert: " + e);
        }
   
    }
    
    //adds a stc funnel to tables
    public static void addStc(int pID, String pHeight, String pSide, String pRadius, String pSectors, String pThickness)
    {
        JavaDb objDb = new JavaDb("FunnelDb");
        Connection myDbConn;
        myDbConn = objDb.getDbConn(); 
        int iDVar = pID;
        String heightVar = pHeight;
        String sideVar = pSide;
        String radiusVar = pRadius;
        String sectorsVar = pSectors;
        String thicknessVar = pThickness;
        
        String dbQuery1 = "INSERT INTO Body VALUES " + "(?,?,?)";  
        try 
        {
            PreparedStatement ps = myDbConn.prepareStatement(dbQuery1);
            ps.setInt(1, iDVar);
            ps.setString(2, heightVar);
            ps.setString(3, thicknessVar);
            System.out.println(dbQuery1);
            ps.executeUpdate(); 
        }
        catch(Exception e)
        {
            System.out.println("didn't insert: " + e);
        }
        
        String dbQuery2 = "INSERT INTO Sides VALUES " + "(?,?)";  
        try 
        {
            PreparedStatement ps = myDbConn.prepareStatement(dbQuery2);
            ps.setInt(1, iDVar);
            ps.setString(2, sideVar);
            System.out.println(dbQuery2);
            ps.executeUpdate(); 
        }
        catch(Exception e)
        {
            System.out.println("didn't insert: " + e);
        }
        
        String dbQuery3 = "INSERT INTO Radii VALUES " + "(?,?)";  
        try 
        {
            PreparedStatement ps = myDbConn.prepareStatement(dbQuery3);
            ps.setInt(1, iDVar);
            ps.setString(2, radiusVar);
            System.out.println(dbQuery3);
            ps.executeUpdate(); 
        }
        catch(Exception e)
        {
            System.out.println("didn't insert: " + e);
        }
        
        String dbQuery4 = "INSERT INTO Sectors VALUES " + "(?,?)";  
        try 
        {
            PreparedStatement ps = myDbConn.prepareStatement(dbQuery4);
            ps.setInt(1, iDVar);
            ps.setString(2, sectorsVar);
            System.out.println(dbQuery4);
            ps.executeUpdate(); 
        }
        catch(Exception e)
        {
            System.out.println("didn't insert: " + e);
        }   
    }
    
    //adds a ctc funnel to tables
    public static void addCtc(int pID, String pHeight, String pRadius, String pRadius1, String pSectors, String pThickness)
    {
        
        JavaDb objDb = new JavaDb("FunnelDb");
        Connection myDbConn;
        myDbConn = objDb.getDbConn(); 
        int iDVar = pID;
        String heightVar = pHeight;
        String radiusVar = pRadius;
        String radius1Var = pRadius1;
        String sectorsVar = pSectors;
        String thicknessVar = pThickness;
        
        String dbQuery1 = "INSERT INTO Body VALUES " + "(?,?,?)";  
        try 
        {
            PreparedStatement ps = myDbConn.prepareStatement(dbQuery1);
            ps.setInt(1, iDVar);
            ps.setString(2, heightVar);
            ps.setString(3, thicknessVar);
            System.out.println(dbQuery1);
            ps.executeUpdate(); 
        }
        catch(Exception e)
        {
            System.out.println("didn't insert: " + e);
        }
        
        String dbQuery2 = "INSERT INTO Radii VALUES " + "(?,?)";  
        try 
        {
            PreparedStatement ps = myDbConn.prepareStatement(dbQuery2);
            ps.setInt(1, iDVar);
            ps.setString(2, radius1Var);
            System.out.println(dbQuery2);
            ps.executeUpdate(); 
        }
        catch(Exception e)
        {
            System.out.println("didn't insert: " + e);
        }
        
        String dbQuery3 = "INSERT INTO Radii VALUES " + "(?,?)";  
        try 
        {
            PreparedStatement ps = myDbConn.prepareStatement(dbQuery3);
            ps.setInt(1, iDVar);
            ps.setString(2, radiusVar);
            System.out.println(dbQuery3);
            ps.executeUpdate(); 
        }
        catch(Exception e)
        {
            System.out.println("didn't insert: " + e);
        }
        
        String dbQuery4 = "INSERT INTO Sectors VALUES " + "(?,?)";  
        try 
        {
            PreparedStatement ps = myDbConn.prepareStatement(dbQuery4);
            ps.setInt(1, iDVar);
            ps.setString(2, sectorsVar);
            System.out.println(dbQuery4);
            ps.executeUpdate(); 
        }
        catch(Exception e)
        {
            System.out.println("didn't insert: " + e);
        }   
        
    }
        
    //adds an sts funnel to tables
    public static void addSts(int pID, String pHeight, String pSide, String pSide1, String pThickness)
    {   
        
        JavaDb objDb = new JavaDb("FunnelDb");
        Connection myDbConn;
        myDbConn = objDb.getDbConn(); 
        int iDVar = pID;
        String heightVar = pHeight;
        String sideVar = pSide;
        String side1Var = pSide1;
        String thicknessVar = pThickness;
        
        String dbQuery1 = "INSERT INTO Body VALUES " + "(?,?,?)";  
        try 
        {
            PreparedStatement ps = myDbConn.prepareStatement(dbQuery1);
            ps.setInt(1, iDVar);
            ps.setString(2, heightVar);
            ps.setString(3, thicknessVar);
            System.out.println(dbQuery1);
            ps.executeUpdate(); 
        }
        catch(Exception e)
        {
            System.out.println("didn't insert: " + e);
        }
        
        String dbQuery2 = "INSERT INTO Sides VALUES " + "(?,?)";  
        try 
        {
            PreparedStatement ps = myDbConn.prepareStatement(dbQuery2);
            ps.setInt(1, iDVar);
            ps.setString(2, side1Var);
            System.out.println(dbQuery2);
            ps.executeUpdate(); 
        }
        catch(Exception e)
        {
            System.out.println("didn't insert: " + e);
        }
        
        String dbQuery3 = "INSERT INTO Sides VALUES " + "(?,?)";  
        try 
        {
            PreparedStatement ps = myDbConn.prepareStatement(dbQuery3);
            ps.setInt(1, iDVar);
            ps.setString(2, sideVar);
            System.out.println(dbQuery3);
            ps.executeUpdate(); 
        }
        catch(Exception e)
        {
            System.out.println("didn't insert: " + e);
        }
        
    }
    
    //changes a value of a setting
    public static void settingChange(String pSetting, int pID)
    {
    
        JavaDb objDb = new JavaDb("FunnelDb");
        Connection myDbConn;
        String settingVar = pSetting;
        int iDVar = pID;
    
        myDbConn = objDb.getDbConn();   
    
        //String dbQuery1 = "INSERT INTO Settings VALUES " + "(?)";
        String dbQuery1 = "UPDATE Settings " + "SET Setting = " + "?" + "WHERE SETTING_ID = " + "?";
//      String dbQuery1 = "UPDATE Settings\n" + "SET Setting = " + "'" + settingVar + "'" + "\n" + "WHERE Index = " + iDVar;
    
        try 
        {
            PreparedStatement ps = myDbConn.prepareStatement(dbQuery1);
            ps.setString(1, settingVar);
            ps.setInt(2, iDVar);
            ps.executeUpdate(); 
        }
        catch(Exception e)
        {
            System.out.println("didn't insert: " + e);
        }
    
    }
    
    //deletes a funnel from tables
    public static void deleteFunnel(int pID)
    {
        
        JavaDb objDb = new JavaDb("FunnelDb");
        Connection myDbConn;
        myDbConn = objDb.getDbConn();   
        int iDVar = pID;
        
        String dbQuery1 = "DELETE FROM Funnels WHERE FUNNEL_ID = " + "?";  
        try 
        {
            PreparedStatement ps = myDbConn.prepareStatement(dbQuery1);
            ps.setInt(1, iDVar);
            System.out.println(dbQuery1);
            ps.executeUpdate(); 
        }
        catch(Exception e)
        {
            System.out.println("didn't insert: " + e);
        }
        
        String dbQuery2 = "DELETE FROM Body WHERE FUNNEL_ID = " + "?";  
        try 
        {
            PreparedStatement ps = myDbConn.prepareStatement(dbQuery2);
            ps.setInt(1, iDVar);
            System.out.println(dbQuery2);
            ps.executeUpdate(); 
        }
        catch(Exception e)
        {
            System.out.println("didn't insert: " + e);
        }
        
        String dbQuery3 = "DELETE FROM Sides WHERE FUNNEL_ID = " + "?";  
        try 
        {
            PreparedStatement ps = myDbConn.prepareStatement(dbQuery3);
            ps.setInt(1, iDVar);
            System.out.println(dbQuery3);
            ps.executeUpdate(); 
        }
        catch(Exception e)
        {
            System.out.println("didn't insert: " + e);
        }
        
        String dbQuery4 = "DELETE FROM Radii WHERE FUNNEL_ID = " + "?";  
        try 
        {
            PreparedStatement ps = myDbConn.prepareStatement(dbQuery4);
            ps.setInt(1, iDVar);
            System.out.println(dbQuery4);
            ps.executeUpdate(); 
        }
        catch(Exception e)
        {
            System.out.println("didn't insert: " + e);
        }
        
        String dbQuery5 = "DELETE FROM Sectors WHERE FUNNEL_ID = " + "?";  
        try 
        {
            PreparedStatement ps = myDbConn.prepareStatement(dbQuery5);
            ps.setInt(1, iDVar);
            System.out.println(dbQuery5);
            ps.executeUpdate(); 
        }
        catch(Exception e)
        {
            System.out.println("didn't insert: " + e);
        }
        
        
    }
    
    //resets Funnels table
    public static void resetFunInputs()
    {
        JavaDb objDb = new JavaDb("FunnelDb");
        Connection myDbConn;
        myDbConn = objDb.getDbConn(); 
        
        //clear
//        String dbQuery2 = "DELETE FROM FunInputs WHERE Index = ?";
//        for (int i = 1; i < rowCounter() + 1; i++)
//        {
//            try 
//            {
//                PreparedStatement ps = myDbConn.prepareStatement(dbQuery2);
//                ps.setInt(1, i);  
//                ps.executeUpdate(); 
//                System.out.println("Removed");
//                System.out.println(dbQuery2);
//            }
//            catch(Exception e)
//            {
//                System.out.println("didn't clear: " + e);
//            }
//        }
        String dbQuery1 = "DELETE FROM Funnels";
        try 
        {
                PreparedStatement ps = myDbConn.prepareStatement(dbQuery1);
                ps.executeUpdate(); 
                System.out.println("Removed");
                System.out.println(dbQuery1);
        }
        catch(Exception e)
        {
                System.out.println("didn't clear: " + e);
        }
        
        String dbQuery2 = "DELETE FROM Body";
        try 
        {
                PreparedStatement ps = myDbConn.prepareStatement(dbQuery2);
                ps.executeUpdate(); 
                System.out.println("Removed");
                System.out.println(dbQuery2);
        }
        catch(Exception e)
        {
                System.out.println("didn't clear: " + e);
        }
        
        String dbQuery3 = "DELETE FROM Sides";
        try 
        {
                PreparedStatement ps = myDbConn.prepareStatement(dbQuery3);
                ps.executeUpdate(); 
                System.out.println("Removed");
                System.out.println(dbQuery3);
        }
        catch(Exception e)
        {
                System.out.println("didn't clear: " + e);
        }
        
        String dbQuery4 = "DELETE FROM Radii";
        try 
        {
                PreparedStatement ps = myDbConn.prepareStatement(dbQuery4);
                ps.executeUpdate(); 
                System.out.println("Removed");
                System.out.println(dbQuery4);
        }
        catch(Exception e)
        {
                System.out.println("didn't clear: " + e);
        }
        
        String dbQuery5 = "DELETE FROM Sectors";
        try 
        {
                PreparedStatement ps = myDbConn.prepareStatement(dbQuery5);
                ps.executeUpdate(); 
                System.out.println("Removed");
                System.out.println(dbQuery5);
        }
        catch(Exception e)
        {
                System.out.println("didn't clear: " + e);
        }
        
    }
    
    //returns the number of rows in the database
    public static int rowCounter()
    {
        Object[][] funnels = DbClient.getFunnels();     
        if (funnels.length == 0)
        {
            return 0;
        }
        else 
        {
            return Integer.parseInt(String.valueOf(funnels[funnels.length - 1][0]));
        }
        
    }
    
    //returns the value of a setting
    public static String getSetting(int settingNum)
    {
        JavaDb objDb = new JavaDb("FunnelDb");
        String[] column = {"Setting_ID", "Setting"};
        Object[][] settings = objDb.getData("Settings", column);
        Object setting = settings[settingNum][1];
        System.out.println(setting);
        return setting.toString();  
    }
    
    //restores all setting defaults
    public static void restoreDefaults()
    {   
 
        JavaDb objDb = new JavaDb("FunnelDb");
        Connection myDbConn;
        myDbConn = objDb.getDbConn(); 
        String path;
        //program is designed for windows, automatically generates default if windows
        //failsafe if user isn't using windows
        //user must install database on own computer for proper set up
        String OS = System.getProperty("os.name");
        OS = OS.substring(0, Math.min(OS.length(), 7));
        System.out.println(OS);
        if (OS.equals("Windows"))
        {
            path = System.getenv("USERPROFILE") + "\\";
        }
        else 
        {
            path = "ENTER_A_PATH";
        }
       
        String[] defaultArray = new String[] {path, "0.5", "S", "255", "0" , "0"};
        
        //clear
        String dbQuery2 = "DELETE FROM Settings";
        try 
        {
                PreparedStatement ps = myDbConn.prepareStatement(dbQuery2);
                ps.executeUpdate(); 
                System.out.println("Removed");
                System.out.println(dbQuery2);
        }
        catch(Exception e)
        {
                System.out.println("didn't clear: " + e);
        }

        //assign defaults
        String dbQuery1 = "INSERT INTO Settings VALUES " + "(?,?)";
        
        for (int i = 0; i < defaultArray.length; i++)
        {
            try 
            {
                PreparedStatement ps = myDbConn.prepareStatement(dbQuery1);
                ps.setInt(1, i);
                ps.setString(2, defaultArray[i]);
                ps.executeUpdate(); 
                System.out.println(defaultArray[i]);
            }
            catch(Exception e)
            {
                System.out.println("didn't insert: " + e);
            }
        }
    }
    
    public static Object[][] getFunnels()
    {
        //method that returns the content of the database so it can be assigned into an array
        String[] column = {"Funnel_ID", "Name", "Timestamp"};
        JavaDb objDb = new JavaDb("FunnelDb");
        return objDb.getData("Funnels", column);
    }
    
    public static Object[][] getBodies()
    {
        //method that returns the content of the database so it can be assigned into an array
        String[] column = {"Funnel_ID", "Height", "Thickness"};
        JavaDb objDb = new JavaDb("FunnelDb");
        return objDb.getData("Body", column);
    }
    
    public static Object[][] getSides()
    {
        //method that returns the content of the database so it can be assigned into an array
        String[] column = {"Funnel_ID", "Side"};
        JavaDb objDb = new JavaDb("FunnelDb");
        return objDb.getData("Sides", column);
    }
        
    public static Object[][] getRadii()
    {
        //method that returns the content of the database so it can be assigned into an array
        String[] column = {"Funnel_ID", "Radius"};
        JavaDb objDb = new JavaDb("FunnelDb");
        return objDb.getData("Radii", column);
    }
            
    public static Object[][] getSectors()
    {
        //method that returns the content of the database so it can be assigned into an array
        String[] column = {"Funnel_ID", "Sector"};
        JavaDb objDb = new JavaDb("FunnelDb");
        return objDb.getData("Sectors", column);
    }
    
    //returns name of an id
    public static String searchName(int id)
    {
        String sid = Integer.toString(id);
        Object[][] funnels = getFunnels();
        
        String name = "";
        
        for(int i=0; i<funnels.length; i++)
        {
            if(String.valueOf(funnels[i][0]).equals(sid))
            {
                name = String.valueOf(funnels[i][1]);
            }
        }
        
        return name;
    }
    
    //returns timestamp of an id
    public static String searchTime(int id)
    {
        String sid = Integer.toString(id);
        Object[][] funnels = getFunnels();
        
        String time = "";
        
        for(int i=0; i<funnels.length; i++)
        {
            if(String.valueOf(funnels[i][0]).equals(sid))
            {
                time = String.valueOf(funnels[i][2]);
            }
        }
        
        return time;
    }
            
    //returns funnel values in an array of a particular funnel id
    public static String[] searchIndex(int id)
    {
        String sid = Integer.toString(id);
        int mem = 1;
        int sideCounter = 0;
        int sectorCounter = 0;
        String type;
        
        ArrayList<String> inputs = new ArrayList<>();
        
        Object[][] bodies = getBodies();
        Object[][] sides = getSides();
        Object[][] Radii = getRadii();     
        Object[][] sectors = getSectors();
        
        for(int i=0; i<bodies.length; i++)
        {
            if(String.valueOf(bodies[i][0]).equals(sid))
            {
                inputs.add(String.valueOf(bodies[i][1]));
                inputs.add(String.valueOf(bodies[i][2]));
                mem++;
                mem++;
            }
        }
        
        for(int i=0; i<sides.length; i++)
        {
            if(String.valueOf(sides[i][0]).equals(sid))
            {
                inputs.add(String.valueOf(sides[i][1]));
                mem++;
                sideCounter++;
            }
        }
                
        for(int i=0; i<Radii.length; i++)
        {
            if(String.valueOf(Radii[i][0]).equals(sid))
            {
                inputs.add(String.valueOf(Radii[i][1]));
                mem++;
            }
        }
                        
        for(int i=0; i<sectors.length; i++)
        {
            if(String.valueOf(sectors[i][0]).equals(sid))
            {
                inputs.add(String.valueOf(sectors[i][1]));
                mem++;
                sectorCounter++;
            }
        }
        
        if(sectorCounter == 0)
        {
            type = "3";
        }
        else if(sideCounter > 0)
        {
            type = "1";
        }
        else 
        {
            type = "2";
        }
        
        inputs.add(type);
        
        String[] inputsArr = new String[mem];
        
        for(int i=0; i<mem; i++)
        {
            inputsArr[i] = inputs.get(i);
        }

        return inputsArr;
    }
                
    
    
    
}
