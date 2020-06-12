/*
This is a class of the SquareToSquare funnel object
It contains vertex, face, and script managing methods
 */
//package heskethfunnelfinder;

import java.util.Arrays;

/**
 *
 * 
 */
public class SquareToSquare {
    
    private String name;
    private double thickness;
    private double side;
    private double sideE;
    private double height;
    private double side1;
    private double side1E;
    private double[][] vertices;
    private double[][][] faces;
    private int vertNum;
    private int faceNum;
    private String script;

    //getters and setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public double getThickness()
    {
        return thickness;
    }

    public void setThickness(double thickness) {
        this.thickness = thickness;
    }

    public double getSide() {
        return side;
    }

    public void setSide(double side) {
        this.side = side;
    }

    public double getSideE() {
        return sideE;
    }

    public void setSideE(double sideE) {
        this.sideE = sideE;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getSide1() {
        return side1;
    }

    public void setSide1(double side1) {
        this.side1 = side1;
    }

    public double getSide1E() {
        return side1E;
    }

    public void setSide1E(double side1E) {
        this.side1E = side1E;
    }

    public double[][] getVertices() {
        return vertices;
    }

    public void setVertices(double[][] vertices) {
        this.vertices = vertices;
    }

    public double[][][] getFaces() {
        return faces;
    }

    public void setFaces(double[][][] faces) {
        this.faces = faces;
    }

    public int getVertNum() {
        return vertNum;
    }

    public void setVertNum(int vertNum) {
        this.vertNum = vertNum;
    }

    public int getFaceNum() {
        return faceNum;
    }

    public void setFaceNum(int faceNum) {
        this.faceNum = faceNum;
    }

    public void setString(String script) {
        this.script = script;
    }
    public String getScript() {
        return this.script;
    }
    
    public SquareToSquare()
    {
        this.side = 0;
        this.height = 0;
        this.side1 = 0;
        this.sideE = 0;
        this.side1E = 0;
        this.vertices = new double[0][0];
        this.faces = new double[0][0][0];
        this.script = "";
    }
    
    public SquareToSquare(String name, double height, double side, double side1, double thickness)
    {
        this.name = name;
        this.side = side;
        this.sideE = this.side + 2*thickness;
        this.thickness = thickness;
        this.height = height;
        this.side1 = side1;
        this.side1E = this.side1 + 2*thickness;
        this.vertNum = 8;
        this.faceNum = 4;
        this.vertices = new double[vertNum * 2][3];
        this.faces = new double[(faceNum * 2) + 8][4][3];
        this.script = "";
        verticesCreate();
        facesCreate();
        scriptWriter();
        System.out.println(this.script);
        System.out.println(Arrays.deepToString(this.vertices));
        System.out.println(Arrays.deepToString(this.faces));
    }
    
    //this method constructs all the vertices inside SquareToSquare
    private void verticesCreate()
    {
        //verticies for first layer
        //construct first 4 vertices for first square
        this.vertices[0][0]= (this.side)/2;
        this.vertices[0][1]= (this.side)/2;
        this.vertices[0][2]= 0;
        //
        this.vertices[1][0]= - (this.side)/2;
        this.vertices[1][1]= (this.side)/2;
        this.vertices[1][2]= 0;
        //
        this.vertices[2][0]= - (this.side)/2;
        this.vertices[2][1]= - (this.side)/2;
        this.vertices[2][2]= 0;
        //
        this.vertices[3][0]= (this.side)/2;
        this.vertices[3][1]= - (this.side)/2;
        this.vertices[3][2]= 0;
        //contruct second 4 vertices for second square
        this.vertices[4][0]= (this.side1)/2;
        this.vertices[4][1]= (this.side1)/2;
        this.vertices[4][2]= height;
        //
        this.vertices[5][0]= - (this.side1)/2;
        this.vertices[5][1]= (this.side1)/2;
        this.vertices[5][2]= this.height;
        //
        this.vertices[6][0]= - (this.side1)/2;
        this.vertices[6][1]= - (this.side1)/2;
        this.vertices[6][2]= this.height;
        //
        this.vertices[7][0]= (this.side1)/2;
        this.vertices[7][1]= - (this.side1)/2;
        this.vertices[7][2]= this.height; 
        //verticies for second layer
        //construct first 4 vertices for first square
        this.vertices[8][0]= (this.sideE)/2;
        this.vertices[8][1]= (this.sideE)/2;
        this.vertices[8][2]= 0;
        //
        this.vertices[9][0]= - (this.sideE)/2;
        this.vertices[9][1]= (this.sideE)/2;
        this.vertices[9][2]= 0;
        //
        this.vertices[10][0]= - (this.sideE)/2;
        this.vertices[10][1]= - (this.sideE)/2;
        this.vertices[10][2]= 0;
        //
        this.vertices[11][0]= (this.sideE)/2;
        this.vertices[11][1]= - (this.sideE)/2;
        this.vertices[11][2]= 0;
        //contruct second 4 vertices for second square
        this.vertices[12][0]= (this.side1E)/2;
        this.vertices[12][1]= (this.side1E)/2;
        this.vertices[12][2]= height;
        //
        this.vertices[13][0]= - (this.side1E)/2;
        this.vertices[13][1]= (this.side1E)/2;
        this.vertices[13][2]= this.height;
        //
        this.vertices[14][0]= - (this.side1E)/2;
        this.vertices[14][1]= - (this.side1E)/2;
        this.vertices[14][2]= this.height;
        //
        this.vertices[15][0]= (this.side1E)/2;
        this.vertices[15][1]= - (this.side1E)/2;
        this.vertices[15][2]= this.height; 
    }
    
    //this method properly orders the vertices and feeds them into an array
    private void facesCreate()
    {
        //faces for first layer
        // 4 faces, each contain 4 vertices
        this.faces[0][0] = this.vertices[0];
        this.faces[0][1] = this.vertices[1];
        this.faces[0][2] = this.vertices[5];
        this.faces[0][3] = this.vertices[4];
        //
        this.faces[1][0] = this.vertices[1];
        this.faces[1][1] = this.vertices[2];
        this.faces[1][2] = this.vertices[6];
        this.faces[1][3] = this.vertices[5];
        //
        this.faces[2][0] = this.vertices[2];
        this.faces[2][1] = this.vertices[3];
        this.faces[2][2] = this.vertices[7];
        this.faces[2][3] = this.vertices[6];
        //
        this.faces[3][0] = this.vertices[3];
        this.faces[3][1] = this.vertices[0];
        this.faces[3][2] = this.vertices[4];
        this.faces[3][3] = this.vertices[7];
        //faces for second layer
        this.faces[4][0] = this.vertices[8];
        this.faces[4][1] = this.vertices[9];
        this.faces[4][2] = this.vertices[13];
        this.faces[4][3] = this.vertices[12];
        //
        this.faces[5][0] = this.vertices[9];
        this.faces[5][1] = this.vertices[10];
        this.faces[5][2] = this.vertices[14];
        this.faces[5][3] = this.vertices[13];
        //
        this.faces[6][0] = this.vertices[10];
        this.faces[6][1] = this.vertices[11];
        this.faces[6][2] = this.vertices[15];
        this.faces[6][3] = this.vertices[14];
        //
        this.faces[7][0] = this.vertices[11];
        this.faces[7][1] = this.vertices[8];
        this.faces[7][2] = this.vertices[12];
        this.faces[7][3] = this.vertices[15];
        //faces for capping
        //bot capping
        this.faces[8][0] = this.vertices[0];
        this.faces[8][1] = this.vertices[8];
        this.faces[8][2] = this.vertices[9];
        this.faces[8][3] = this.vertices[1];
        //
        this.faces[9][0] = this.vertices[1];
        this.faces[9][1] = this.vertices[9];
        this.faces[9][2] = this.vertices[10];
        this.faces[9][3] = this.vertices[2];
        //
        this.faces[10][0] = this.vertices[2];
        this.faces[10][1] = this.vertices[10];
        this.faces[10][2] = this.vertices[11];
        this.faces[10][3] = this.vertices[3];
        //
        this.faces[11][0] = this.vertices[3];
        this.faces[11][1] = this.vertices[11];
        this.faces[11][2] = this.vertices[8];
        this.faces[11][3] = this.vertices[0];
        //top capping
        this.faces[12][0] = this.vertices[4];
        this.faces[12][1] = this.vertices[12];
        this.faces[12][2] = this.vertices[13];
        this.faces[12][3] = this.vertices[5];
        //
        this.faces[13][0] = this.vertices[5];
        this.faces[13][1] = this.vertices[13];
        this.faces[13][2] = this.vertices[14];
        this.faces[13][3] = this.vertices[6];
        //
        this.faces[14][0] = this.vertices[6];
        this.faces[14][1] = this.vertices[14];
        this.faces[14][2] = this.vertices[15];
        this.faces[14][3] = this.vertices[7];
        //
        this.faces[15][0] = this.vertices[7];
        this.faces[15][1] = this.vertices[15];
        this.faces[15][2] = this.vertices[12];
        this.faces[15][3] = this.vertices[4];
        
    }
    
    //writes script based off settings and arrays
    private void scriptWriter()
    {
        this.script = this.script + ";Script generated by FunnelFinder \r\n";
        this.script = this.script + ";Height: " + this.height + " Side1: " + this.side + " Side2: " + this.side1 + " Thickness: " + this.thickness + "\r\n";
        this.script = this.script + ";Square To Square" + "\r\n";
        //settings
        this.script = this.script + "UCSDETECT\r\n" + "0" + "\r\n";
        this.script = this.script + "OSMODE\r\n" + "0" + "\r\n";
        this.script = this.script + "ORTHOMODE\r\n" + "0" + "\r\n";
        this.script = this.script + "SNAPMODE\r\n" + "0" + "\r\n";
        this.script = this.script + "-COLOR\r\n" + "t\r\n" + DbClient.getSetting(3) + "," + DbClient.getSetting(4) + "," + DbClient.getSetting(5) +"\r\n";
        this.script = this.script + "-LWEIGHT\r\n" + DbClient.getSetting(1) + "\r\n";
        this.script = this.script + "SHADEMODE\r\n" + "2D" + "\r\n";
        this.script = this.script + "-LAYER\r\nM\r\n" + this.name + "\r\n\r\n";
        //f is the current face
        for(int f = 0; f <= (this.faceNum)*2 + 7; f++)
        {
            //faces
            this.script = this.script + "3dface\r\n";
            this.script = this.script + this.faces[f][0][0] + "," + this.faces[f][0][1] + "," + this.faces[f][0][2] + "\r\n";
            this.script = this.script + this.faces[f][1][0] + "," + this.faces[f][1][1] + "," + this.faces[f][1][2] + "\r\n";
            this.script = this.script + this.faces[f][2][0] + "," + this.faces[f][2][1] + "," + this.faces[f][2][2] + "\r\n";
            this.script = this.script + this.faces[f][3][0] + "," + this.faces[f][3][1] + "," + this.faces[f][3][2] + "\r\n";
            this.script = this.script + "\r\n";
        }
        //end settings 
        this.script = this.script + "VSCURRENT\r\n" + DbClient.getSetting(2) + "\r\n";
        this.script = this.script + "MESHSMOOTH\r\n" + "ALL" + "\r\n\r\n"; 
        this.script = this.script + "CONVTOSURFACE\r\n" + "ALL" + "\r\n\r\n"; 
        this.script = this.script + "SURFSCULPT\r\n" + "ALL" + "\r\n\r\n"; 
        this.script = this.script + "-VPOINT\r\n" + "-1,-1,1" + "\r\n"; 
    }
    
//    public static void main(String[] args) {
//         TODO code application logic here
//        SquareToSquare SObj = new SquareToSquare("name", 2, 2, 2, 2);
//        
//    }
    
}
