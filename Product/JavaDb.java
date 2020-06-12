/*
 This class communicates with and sends commands to the database manager
 */
//package heskethfunnelfinder;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class JavaDb {

    /**
     * 
     */
    
    public static String dbName;
    private Object [][] data;
    private Connection dbConn;
    
    public JavaDb(String dbName){
        this.dbName = dbName;
        this.data = null;
        setDbConn();
    }
    
    public JavaDb() {
        this.dbName = "";
        this.data = null;
        this.dbConn = null;
    }
    
    public static String getDbName() {
        return dbName;
    }
    
    public void setDbName(String dbName){
        this.dbName = dbName;
    }
    
    //generic method that returns an entire table
    public Object [][] getData(String tableName, String[] tableHeaders){
        int columnCount = tableHeaders.length;
        ResultSet rs = null;
        Statement s = null;
        String dbQuery = "SELECT * FROM " + tableName;
        ArrayList<ArrayList<String>> dataList = new ArrayList<>();
        
        try {
            s = this.dbConn.createStatement();
            rs = s.executeQuery(dbQuery);
            while(rs.next()){
                ArrayList<String> row = new ArrayList<>();
                for(int  i=0; i<columnCount; i++) {
                    row.add(rs.getString(tableHeaders[i]));
                }
                dataList.add(row);
            }
            this.data = new Object[dataList.size()][columnCount];
            for (int i = 0; i < dataList.size(); i++) {
                ArrayList<String> row;
                row = dataList.get(i);
                for (int j=0; j<columnCount; j++) {
                    this.data[i][j] = row.get(j);
                }
            }
        }
            catch(SQLException err) {
                    System.out.println("Database error " + err + "\n");
                    System.exit(0);
            }
        return this.data;
    }   
            
    private void setData(Object[][] data){
        this.data = data;
    }
    
    public Connection getDbConn() {
        return this.dbConn;
    }
    
    public void setDbConn() {
       String connectionURL = "jdbc:derby:" + this.dbName;
       
        this.dbConn = null;
        try {
            
            Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
            this.dbConn = DriverManager.getConnection(connectionURL);
        }
        catch(SQLException err) {
                    System.out.println("Couldn't find database");
                    
                    //System.exit(0);
        }
        catch(ClassNotFoundException ex) {
                    System.out.println("Class for name not found");
                    System.exit(0);
        }
        
    }
    
    public void closeDbConn() {
    try {
        this.dbConn.close();
    }
    catch (Exception err) {
        System.out.println("DB close error");
        System.exit(0);
    }
    }
    
    public void createDb (String newDbName) {
        this.dbName = newDbName;
        String connectionURL = "jdbc:derby:" + this.dbName + ";create=true";
        try {
            Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
            this.dbConn = DriverManager.getConnection(connectionURL);
            System.out.println("New database created");
            this.dbConn.close();
        }
        catch (Exception err) {
        System.out.println("Error creating database: " + newDbName);
        System.exit(0);
    }
    }
    
    public  void createTable(String newTable, String dbName){
        Statement s;
        
        setDbName(dbName);
        setDbConn();
            
        try{
            s = this.dbConn.createStatement();
            s.execute(newTable); 
            System.out.println("New table created");
            this.dbConn.close();
        }
        catch (Exception err) {
        System.out.println("Error creating table" + newTable);
        System.exit(0);
    }   
        
    }
       
    
//    public static void main(String[] args) {
//        JavaDb objDb = new JavaDb();
//        objDb.createDb("VectorDb");
//    }
    
}
    
