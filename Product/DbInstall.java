/*
This class creates the database and its tables
 */
//package heskethfunnelfinder;

/**
 *
 * 
 */
public class DbInstall {
    
    public static void main(String[] args)
    {
        //create database
        JavaDb objDb = new JavaDb();
        objDb.createDb("FunnelDb");
        
        //tables
        String funnelTable;
        String bodyTable;
        String sideTable;
        String RadiiTable;
        String sectorsTable;
        String settingsTable;
        
        //create tables
        //newTable = "CREATE TABLE FunInputs ( " + "Index int, " + "Date varchar(15), " + "Type varchar(20), " + "Inputs varchar(60) " + ")";
        funnelTable = "CREATE TABLE Funnels ( " + "Funnel_ID int, " + "Name varchar(30), " + "Timestamp varchar(30) " + ")";
        System.out.println(funnelTable);
        objDb.createTable(funnelTable, "FunnelDb");
        
        bodyTable = "CREATE TABLE Body ( " + "Funnel_ID int, " + "Height varchar(30), " + "Thickness varchar(30) " + ")";
        System.out.println(bodyTable);
        objDb.createTable(bodyTable, "FunnelDb");
        
        sideTable = "CREATE TABLE Sides ( " + "Funnel_ID int, " + "Side varchar(30) " + ")";
        System.out.println(sideTable);
        objDb.createTable(sideTable, "FunnelDb");
        
        RadiiTable = "CREATE TABLE Radii ( " + "Funnel_ID int, " + "Radius varchar(30) " + ")";
        System.out.println(RadiiTable);
        objDb.createTable(RadiiTable, "FunnelDb");
        
        sectorsTable = "CREATE TABLE Sectors ( " + "Funnel_ID int, " + "Sector varchar(30) " + ")";
        System.out.println(sectorsTable);
        objDb.createTable(sectorsTable, "FunnelDb");
        
        settingsTable = "CREATE TABLE Settings ( " + "Setting_ID int, " + "Setting varchar(60) " + ")";
        System.out.println(settingsTable);
        objDb.createTable(settingsTable, "FunnelDb");
        
        //setting defaults
        DbClient.restoreDefaults();

    }

//    private static void defaultSetter()
//    {
//        //assign defaults
//        JavaDb objDb = new JavaDb("FunnelDb");
//        Connection myDbConn;
//        myDbConn = objDb.getDbConn(); 
//        String dbQuery1 = "INSERT INTO Settings VALUES " + "(?,?)";
//        String path = System.getenv("USERPROFILE");
//        String[] defaultArray = new String[4];
//        defaultArray = new String[] {path, "Funnel", "1", "?"};
//        for (int i = 0; i < 4; i++)
//        {
//            try 
//            {
//                PreparedStatement ps = myDbConn.prepareStatement(dbQuery1);
//                ps.setInt(1, i);
//                ps.setString(2, defaultArray[i]);
//                ps.executeUpdate(); 
//                System.out.println(defaultArray[i]);
//            }
//            catch(Exception e)
//            {
//                System.out.println("didn't insert: " + e);
//            }
//        }
//    }
    
}
