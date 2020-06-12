    /*
This is a class of the SquareToCircle funnel object
It contains vertex, face, and script managing methods
 */
//package heskethfunnelfinder;

import java.util.Arrays;

/**
 *
 * 
 */
public class SquareToCircle {
    
    private String name;
    private double thickness;
    private double radius;
    private double radiusE;
    private double height;
    private double side;
    private double sideE;
    private double divisions;
    private double angle;
    private double sectors;
    private double[][] vertices;
    private double[][][] faces;
    //represents the # of verticies for a single layer
    private int vertNum;
    //represents the # of faces for a single layer
    private int faceNum;
    private String script;
    
    //getters and setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getThickness() {
        return thickness;
    }

    public void setThickness(double thickness) {
        this.thickness = thickness;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public double getRadiusE() {
        return radiusE;
    }

    public void setRadiusE(double radiusE) {
        this.radiusE = radiusE;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
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

    public double getDivisions() {
        return divisions;
    }

    public void setDivisions(double divisions) {
        this.divisions = divisions;
    }

    public double getAngle() {
        return angle;
    }

    public void setAngle(double angle) {
        this.angle = angle;
    }

    public double getSectors() {
        return sectors;
    }

    public void setSectors(double sectors) {
        this.sectors = sectors;
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
    
    public void setScript(String script) {
        this.script = script;
    }
    
    public String getScript() {
        return this.script;
    }
    
    public SquareToCircle()
    {
       this.radius = 0;
       this.radiusE = 0;
       this.height = 0;
       this.side = 0;
       this.sideE = 0;
       this.divisions = 0;
       this.angle = 0;
       this.sectors = 0;
       this.vertices = new double[0][0];
       this.faces = new double[0][0][0];
       this.script = "";
    }
    
    public SquareToCircle(String name, double height, double side, double radius, double sectors, double thickness)
    {
       this.name = name;
       this.radius = radius;
       this.radiusE = this.radius + thickness;
       this.thickness = thickness;
       this.height = height;
       this.side = side;
       this.sideE = this.side + 2*thickness;
       this.sectors = sectors;
       this.divisions = 4 * this.sectors;
       this.angle = 90/this.sectors;
       this.vertNum = (int)(4 + (this.divisions));
       this.faceNum = vertNum;
       this.vertices = new double[this.vertNum * 2][3];
       this.faces = new double[this.faceNum * 3][4][3];
       this.script = "";
       verticesCreate();
       facesCreate();
       scriptWriter();
       System.out.println(this.script);
       System.out.println(Arrays.deepToString(this.vertices));
       System.out.println(Arrays.deepToString(this.faces));
    }
    
    //this method constructs all the vertices inside SquareToCircle
    private void verticesCreate()
    {
        //first layer of funnel
        //construct first 4 vertices for first square
        this.vertices[0][0]= (this.side)/2;
        this.vertices[0][1]= (this.side)/2;
        this.vertices[0][2]= this.height;
        //
        this.vertices[1][0]= - (this.side)/2;
        this.vertices[1][1]= (this.side)/2;
        this.vertices[1][2]= this.height;
        //
        this.vertices[2][0]= - (this.side)/2;
        this.vertices[2][1]= - (this.side)/2;
        this.vertices[2][2]= this.height;
        //
        this.vertices[3][0]= (this.side)/2;
        this.vertices[3][1]= - (this.side)/2;
        this.vertices[3][2]= this.height;
        //construct vertices for pseudo-circle
        //d is the current division
        //i is the current vertex
        int i = 4;
        for (double d = 0; d <= this.divisions - 1; d++)
        { 
            if (!(this.radius * Math.cos(Math.toRadians(this.angle * d)) < 0.00001 && this.radius * Math.cos(Math.toRadians(this.angle * d)) > -0.00001))
            {
                this.vertices[i][0] = this.radius * Math.cos(Math.toRadians(this.angle * d));
                
            }
            else
            {
                this.vertices[i][0] = 0;  
            }
            if (!(this.radius * Math.sin(Math.toRadians(this.angle * d)) < 0.00001 && this.radius * Math.sin(Math.toRadians(this.angle * d)) > -0.00001))
            {
                this.vertices[i][1] = this.radius * Math.sin(Math.toRadians(this.angle * d));
            }
            else
            {
                this.vertices[i][1] = 0;
            }
            this.vertices[i][2] = 0;
            i++;
        }
        //second layer of funnel
        //construct first 4 vertices for first square
        this.vertices[this.vertNum][0]= (this.sideE)/2;
        this.vertices[this.vertNum][1]= (this.sideE)/2;
        this.vertices[this.vertNum][2]= this.height;
        //
        this.vertices[1 + this.vertNum][0]= - (this.sideE)/2;
        this.vertices[1 + this.vertNum][1]= (this.sideE)/2;
        this.vertices[1 + this.vertNum][2]= this.height;
        //
        this.vertices[2 + this.vertNum][0]= - (this.sideE)/2;
        this.vertices[2 + this.vertNum][1]= - (this.sideE)/2;
        this.vertices[2 + this.vertNum][2]= this.height;
        //
        this.vertices[3 + this.vertNum][0]= (this.sideE)/2;
        this.vertices[3 + this.vertNum][1]= - (this.sideE)/2;
        this.vertices[3 + this.vertNum][2]= this.height;
        //construct vertices for pseudo-circle
        //d is the current division
        //i is the current vertex
        int j = 4 + this.vertNum;
        for (double d = 0; d <= this.divisions - 1; d++)
        { 
            if (!(this.radiusE * Math.cos(Math.toRadians(this.angle * d)) < 0.00001 && this.radiusE * Math.cos(Math.toRadians(this.angle * d)) > -0.00001))
            {
                this.vertices[j][0] = this.radiusE * Math.cos(Math.toRadians(this.angle * d));
            }
            else
            {
                
                this.vertices[j][0] = 0;
            }
            if (!(this.radiusE * Math.sin(Math.toRadians(this.angle * d)) < 0.00001 && this.radiusE * Math.sin(Math.toRadians(this.angle * d)) > -0.00001))
            {
                this.vertices[j][1] = this.radiusE * Math.sin(Math.toRadians(this.angle * d));
                
            }
            else
            {
                this.vertices[j][1] = 0;
            }
            this.vertices[j][2] = 0;
            j++;
        }
    }
    
     //this method properly orders the vertices and feeds them into an array
    private void facesCreate()
    {
        //faces for first layer
        //first 4 faces, each contain 4 vertices
        this.faces[0][0] = this.vertices[0];
        this.faces[0][1] = this.vertices[1];
        this.faces[0][2] = this.vertices[4 + (int) this.sectors];
        this.faces[0][3] = this.faces[0][2];
        //
        this.faces[1][0] = this.vertices[1];
        this.faces[1][1] = this.vertices[2];
        this.faces[1][2] = this.vertices[4 + (int) (2 * this.sectors)];
        this.faces[1][3] = this.faces[1][2];
        //
        this.faces[2][0] = this.vertices[2];
        this.faces[2][1] = this.vertices[3];
        this.faces[2][2] = this.vertices[4 + (int) (3 * this.sectors)];
        this.faces[2][3] = this.faces[2][2];
        //
        this.faces[3][0] = this.vertices[3];
        this.faces[3][1] = this.vertices[0];
        this.faces[3][2] = this.vertices[4];
        this.faces[3][3] = this.faces[3][2];
        
        //quadrant faces
        //f is the current face
        //i is curent index of vertices[]
        int i = 4;
        for(int f = 4; f <= this.faceNum - 1; f++)
        {
            if(f <= this.sectors + 3) 
            {
                this.faces[f][0] = this.vertices[0];
                this.faces[f][1] = this.faces[f][0];
            }
            else if(f <= 2 * this.sectors + 3) 
            {
                this.faces[f][0] = this.vertices[1];
                this.faces[f][1] = this.faces[f][0];
            }
            else if(f <= 3 * this.sectors + 3) 
            {
                this.faces[f][0] = this.vertices[2];
                this.faces[f][1] = this.faces[f][0];
            }
            else 
            {
                this.faces[f][0] = this.vertices[3];
                this.faces[f][1] = this.faces[f][0];
            }
            if (!(f == this.faceNum - 1))
            {
                this.faces[f][2] = this.vertices[i];
                this.faces[f][3] = this.vertices[i+1];  

            }
            else 
            {
                this.faces[f][2] = this.vertices[i];
                this.faces[f][3] = this.vertices[4]; 
            }
            i++;
        }
        //faces for second layer
        //first 4 faces, each contain 4 vertices
        this.faces[this.faceNum][0] = this.vertices[this.vertNum];
        this.faces[this.faceNum][1] = this.vertices[1 + this.vertNum];
        this.faces[this.faceNum][2] = this.vertices[this.vertNum + 4 + (int) this.sectors];
        this.faces[this.faceNum][3] = this.faces[this.faceNum][2];
        //
        this.faces[1 + this.faceNum][0] = this.vertices[1 + this.vertNum];
        this.faces[1 + this.faceNum][1] = this.vertices[2 + this.vertNum];
        this.faces[1 + this.faceNum][2] = this.vertices[this.vertNum + 4 + (int) (2 * this.sectors)];
        this.faces[1 + this.faceNum][3] = this.faces[1 + this.faceNum][2];
        //
        this.faces[2 + this.faceNum][0] = this.vertices[2 + this.vertNum];
        this.faces[2 + this.faceNum][1] = this.vertices[3 + this.vertNum];
        this.faces[2 + this.faceNum][2] = this.vertices[this.vertNum + 4 + (int) (3 * this.sectors)];
        this.faces[2 + this.faceNum][3] = this.faces[2 + this.faceNum][2];
        //
        this.faces[3 + this.faceNum][0] = this.vertices[3 + this.vertNum];
        this.faces[3 + this.faceNum][1] = this.vertices[this.vertNum];
        this.faces[3 + this.faceNum][2] = this.vertices[4 + this.vertNum];
        this.faces[3 + this.faceNum][3] = this.faces[3 + this.faceNum][2];
        
        //quadrant faces
        //f is the current face
        //i is curent index of vertices[]
        int j = 4 + this.vertNum;
        for(int f = 4 + this.faceNum; f <= (2 * this.faceNum) - 1; f++)
        {
            if(f <= this.sectors + 3 + this.vertNum) 
            {
                //System.out.println("1");
                this.faces[f][0] = this.vertices[this.vertNum];
                this.faces[f][1] = this.faces[f][0];
            }
            else if(f <= 2 * this.sectors + 3 + this.vertNum) 
            {
                //System.out.println("2");
                this.faces[f][0] = this.vertices[1 + this.vertNum];
                this.faces[f][1] = this.faces[f][0];
            }
            else if(f <= 3 * this.sectors + 3 + this.vertNum) 
            {
                //System.out.println("3");
                this.faces[f][0] = this.vertices[2 + this.vertNum];
                this.faces[f][1] = this.faces[f][0];
            }
            else 
            {
                //System.out.println("4");
                this.faces[f][0] = this.vertices[3 + this.vertNum];
                this.faces[f][1] = this.faces[f][0];
            }
            if (!(f == (this.faceNum * 2) - 1))
            {
                //System.out.println("a");
                this.faces[f][2] = this.vertices[j];
                this.faces[f][3] = this.vertices[j+1];
                
            }
            else 
            {
                //System.out.println("b");
                this.faces[f][2] = this.vertices[j];
                this.faces[f][3] = this.vertices[4 + this.vertNum]; 
            }
            j++;
        }
        //capping for square
        //first 4 faces, each contain 4 vertices
        this.faces[2 * this.faceNum][0] = this.vertices[0];
        this.faces[2 * this.faceNum][1] = this.vertices[1];
        this.faces[2 * this.faceNum][2] = this.vertices[this.vertNum + 1];
        this.faces[2 * this.faceNum][3] = this.vertices[this.vertNum];
        //
        this.faces[(2 * this.faceNum) + 1][0] = this.vertices[1];
        this.faces[(2 * this.faceNum) + 1][1] = this.vertices[2];
        this.faces[(2 * this.faceNum) + 1][2] = this.vertices[this.vertNum + 2];
        this.faces[(2 * this.faceNum) + 1][3] = this.vertices[this.vertNum + 1];
        //
        this.faces[(2 * this.faceNum) + 2][0] = this.vertices[2];
        this.faces[(2 * this.faceNum) + 2][1] = this.vertices[3];
        this.faces[(2 * this.faceNum) + 2][2] = this.vertices[this.vertNum + 3];
        this.faces[(2 * this.faceNum) + 2][3] = this.vertices[this.vertNum + 2];
        //
        this.faces[(2 * this.faceNum) + 3][0] = this.vertices[3];
        this.faces[(2 * this.faceNum) + 3][1] = this.vertices[0];
        this.faces[(2 * this.faceNum) + 3][2] = this.vertices[this.vertNum];
        this.faces[(2 * this.faceNum) + 3][3] = this.vertices[this.vertNum + 3];
        //capping for sectors
        //f is current face
        //k is layer one vertex counter
        //l is layer two vertex counter
        int k = 4;
        int l = 4 + this.vertNum;
        for(int f = (2 * this.faceNum) + 4; f <= (3 * this.faceNum) - 1; f++)
        {
            if (!(f == (this.faceNum * 3) - 1))
            {
                this.faces[f][0] = this.vertices[k];
                this.faces[f][1] = this.vertices[k+1];
                this.faces[f][2] = this.vertices[l+1];
                this.faces[f][3] = this.vertices[l];
            }
            else
            {
                this.faces[f][0] = this.vertices[k];
                this.faces[f][1] = this.vertices[4];
                this.faces[f][2] = this.vertices[4 + this.vertNum];
                this.faces[f][3] = this.vertices[l];        
            }
            k++;
            l++;
        }
        
    }
    
    //writes script based off settings and arrays
    private void scriptWriter()
    {
        this.script = this.script + ";Script generated by FunnelFinder \r\n";
        this.script = this.script + ";Height: " + this.height + " Side: " + this.side + " Radius: " + this.radius + " Sectors: " + this.sectors + " Thickness: " + this.thickness + "\r\n";
        this.script = this.script + ";Square To Circle" + "\r\n";
        //settings
        this.script = this.script + "UCSDETECT\r\n" + "0" + "\r\n";
        this.script = this.script + "OSMODE\r\n" + "0" + "\r\n";
        this.script = this.script + "ORTHOMODE\r\n" + "0" + "\r\n";
        this.script = this.script + "SNAPMODE\r\n" + "0" + "\r\n";
        this.script = this.script + "-COLOR\r\n" + "t\r\n" + DbClient.getSetting(3) + "," + DbClient.getSetting(4) + "," + DbClient.getSetting(5) +"\r\n";
        this.script = this.script + "-LWEIGHT\r\n" + DbClient.getSetting(1) + "\r\n";
        this.script = this.script + "SHADEMODE\r\n" + "2D" + "\r\n";
        this.script = this.script + "-LAYER\r\nM\r\n" + this.name + "\r\n\r\n";
        for(int f = 0; f <= this.faceNum * 3 - 1; f++)
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
//        // TODO code application logic here
//        SquareToCircle SObj = new SquareToCircle("name", 2, 4, 1, 12, 1);
//        
//    }
}
