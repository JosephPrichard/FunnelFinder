/*
This is a class of the CircleToCircle funnel object
It contains vertex, face, and script managing methods
 */
//package heskethfunnelfinder;

import java.util.Arrays;

/**
 *
 * 
 */
public class CircleToCircle {
    
    private String name;
    private double thickness;
    private double radius;
    private double radiusE;
    private double height;
    private double radius1;
    private double radius1E;
    private double divisions;
    private double angle;
    private double sectors;
    private double[][] vertices;
    private double[][][] faces;
    private int vertNum;
    private int faceNum;
    private String script;

    //setters and getters
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

    public double getRadius1() {
        return radius1;
    }

    public void setRadius1(double radius1) {
        this.radius1 = radius1;
    }

    public double getRadius1E() {
        return radius1E;
    }

    public void setRadius1E(double radius1E) {
        this.radius1E = radius1E;
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
    
    public String getScript()
    {
        return this.script;
    }
    
    public CircleToCircle()
    {
        this.radius = 0;
        this.height = 0;
        this.radiusE = 0;
        this.radius1 = 0;
        this.radius1E = 0;
        this.divisions = 0;
        this.angle = 0;
        this.sectors = 0;
        this.vertices = new double[0][0];
        this.faces = new double[0][0][0];
        this.script = "";
    }
    
    public CircleToCircle(String name, double height, double radius, double radius1, double sectors, double thickness)
    {
        this.name = name;
        this.radius = radius;
        this.radiusE = this.radius + thickness;
        this.thickness = thickness;
        this.height = height;
        this.radius1 = radius1;
        this.radius1E = this.radius1 + thickness;
        this.sectors = sectors;
        this.divisions = 4 * this.sectors;
        this.angle = 90/this.sectors;
        this.vertNum = (int)(2 * (this.divisions));
        this.faceNum = this.vertNum/2;
        this.vertices = new double[this.vertNum * 2][3];
        this.faces = new double[this.faceNum * 4][4][3];
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
        //first layer
        //construct vertices for pseudo-circle
        //d is the current division
        //i is the current vertex
        int i = 0;
        for (double d = 0; d <= this.divisions - 1; d++)
        { 
            if (!(this.radius * Math.cos(Math.toRadians(this.angle * d)) < 0.1 && this.radius * Math.cos(Math.toRadians(this.angle * d)) > -0.1))
            {
                this.vertices[i][0] = this.radius * Math.cos(Math.toRadians(this.angle * d));
            }
            else
            {
                this.vertices[i][0] = 0;
            }
            if (!(this.radius * Math.sin(Math.toRadians(this.angle * d)) < 0.1 && this.radius * Math.sin(Math.toRadians(this.angle * d)) > -0.1))
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
        //construct vertices for 2nd pseudo-circle
        //d is the current division
        //j is the current vertex
        int j = (int) this.divisions;
        for (double d = 0; d <= this.divisions - 1; d++)
        { 
            if (!(this.radius1 * Math.cos(Math.toRadians(this.angle * d)) < 0.00001 && this.radius1 * Math.cos(Math.toRadians(this.angle * d)) > -0.00001))
            {
                this.vertices[j][0] = this.radius1 * Math.cos(Math.toRadians(this.angle * d));
                //System.out.println(j);
            }
            else
            {
                this.vertices[j][0] = 0;
                //System.out.println(j);
            }
            if (!(this.radius1 * Math.sin(Math.toRadians(this.angle * d)) < 0.00001 && this.radius1 * Math.sin(Math.toRadians(this.angle * d)) > -0.00001))
            {
                this.vertices[j][1] = this.radius1 * Math.sin(Math.toRadians(this.angle * d));
            }
            else
            {
                this.vertices[j][1] = 0;  
            }
            this.vertices[j][2] = this.height;
            j++;
        }
        //second layer
        //construct vertices for pseudo-circle
        //d is the current division
        //i is the current vertex
        int l = (int) this.divisions * 2;
        for (double d = 0; d <= this.divisions - 1; d++)
        { 
            if (!(this.radiusE * Math.cos(Math.toRadians(this.angle * d)) < 0.1 && this.radiusE * Math.cos(Math.toRadians(this.angle * d)) > -0.1))
            {
                this.vertices[l][0] = this.radiusE * Math.cos(Math.toRadians(this.angle * d));
            }
            else
            {   
                this.vertices[l][0] = 0;
            }
            if (!(this.radiusE * Math.sin(Math.toRadians(this.angle * d)) < 0.1 && this.radiusE * Math.sin(Math.toRadians(this.angle * d)) > -0.1))
            {
                this.vertices[l][1] = this.radiusE * Math.sin(Math.toRadians(this.angle * d));
            }
            else
            {
                this.vertices[l][1] = 0;
            }
            this.vertices[l][2] = 0;
            l++;
        }
        //construct vertices for 2nd pseudo-circle
        //d is the current division
        //j is the current vertex
        int k = (int) this.divisions * 3;
        for (double d = 0; d <= this.divisions - 1; d++)
        { 
            if (!(this.radius1E * Math.cos(Math.toRadians(this.angle * d)) < 0.00001 && this.radius1E * Math.cos(Math.toRadians(this.angle * d)) > -0.00001))
            {
                this.vertices[k][0] = this.radius1E * Math.cos(Math.toRadians(this.angle * d));
                //System.out.println(j);
            }
            else
            {
                this.vertices[k][0] = 0;
                //System.out.println(j);
            }
            if (!(this.radius1E * Math.sin(Math.toRadians(this.angle * d)) < 0.00001 && this.radius1E * Math.sin(Math.toRadians(this.angle * d)) > -0.00001))
            {
                this.vertices[k][1] = this.radius1E * Math.sin(Math.toRadians(this.angle * d));
            }
            else
            {
                this.vertices[k][1] = 0;
            }
            this.vertices[k][2] = this.height;
            k++;
        }
    }
    
     //this method properly orders the vertices and feeds them into an array
    private void facesCreate()
    {
        //first layer
        //f is the current face
        int i = 0;
        for(int f = 0; f <= this.faceNum - 1; f++)
        {
            if (!(f == this.faceNum - 1))
            {
                this.faces[f][0] = this.vertices[i];
                this.faces[f][1] = this.vertices[i+1];   
                this.faces[f][2] = this.vertices[(this.vertNum/2)+i+1]; 
                this.faces[f][3] = this.vertices[(this.vertNum/2)+i];  
            }
            else 
            {   
                this.faces[f][0] = this.vertices[i];
                this.faces[f][1] = this.vertices[0]; 
                this.faces[f][2] = this.vertices[(this.vertNum/2)]; 
                this.faces[f][3] = this.vertices[(this.vertNum/2)+i];   
            }
            i++;
        }
        //second layer
        //f is the current face
        int j = this.vertNum;
        for(int f = this.faceNum; f <= (2*this.faceNum) - 1; f++)
        {
            if (!(f == (this.faceNum*2) - 1))
            {
                this.faces[f][0] = this.vertices[j];
                this.faces[f][1] = this.vertices[j+1];   
                this.faces[f][2] = this.vertices[(this.vertNum/2)+j+1]; 
                this.faces[f][3] = this.vertices[(this.vertNum/2)+j]; 
            }
            else 
            {
//              System.out.println("hi");
                this.faces[f][0] = this.vertices[j];
                this.faces[f][1] = this.vertices[this.vertNum]; 
                this.faces[f][2] = this.vertices[(this.vertNum/2) + this.vertNum]; 
                this.faces[f][3] = this.vertices[(this.vertNum/2)+j];              
            }
            j++;
        }
        //capping for bottom
        //f is current face
        //k is layer one vertex counter
        //l is layer two vertex counter
        int k = 0;
        int l = this.vertNum;
        for(int f = (2 * this.faceNum); f <= (3 * this.faceNum) - 1; f++)
        {
            if (!(f == (this.faceNum * 3) - 1))
            {
//                System.out.println("a");
                this.faces[f][0] = this.vertices[k];
                this.faces[f][1] = this.vertices[k+1];
                this.faces[f][2] = this.vertices[l+1];
                this.faces[f][3] = this.vertices[l];
            }
            else
            {
//                System.out.println("b");
                this.faces[f][0] = this.vertices[k];
                this.faces[f][1] = this.vertices[0];
                this.faces[f][2] = this.vertices[this.vertNum];
                this.faces[f][3] = this.vertices[l];        
            }
            k++;
            l++;
        }
        //capping for top
        //f is current face
        //m is layer one vertex counter
        //n is layer two vertex counter
        int m = this.vertNum/2;
        int n = 3 * this.vertNum/2;
        for(int f = (3 * this.faceNum); f <= (4 * this.faceNum) - 1; f++)
        {
            if (!(f == (this.faceNum * 4) - 1))
            {
//                System.out.println("c");
                this.faces[f][0] = this.vertices[m];
                this.faces[f][1] = this.vertices[m+1];
                this.faces[f][2] = this.vertices[n+1];
                this.faces[f][3] = this.vertices[n];
            }
            else
            {
                this.faces[f][0] = this.vertices[m];
                this.faces[f][1] = this.vertices[this.vertNum/2];
                this.faces[f][2] = this.vertices[3 * this.vertNum/2];
                this.faces[f][3] = this.vertices[n];      
//                System.out.println("d");
            }
            m++;
            n++;
        }
    }
    
    //writes script based off settings and arrays
    private void scriptWriter()
    {
        this.script = this.script + ";Script generated by FunnelFinder \r\n";
        this.script = this.script + ";Height: " + this.height + " Radius1: " + this.radius + " Radius2: " + this.radius1 + " Sectors: " + this.sectors + " Thickness: " + this.thickness + "\r\n";
        this.script = this.script + ";Circle To Circle" + "\r\n";
       //settings
        this.script = this.script + "UCSDETECT\r\n" + "0" + "\r\n";
        this.script = this.script + "OSMODE\r\n" + "0" + "\r\n";
        this.script = this.script + "ORTHOMODE\r\n" + "0" + "\r\n";
        this.script = this.script + "SNAPMODE\r\n" + "0" + "\r\n";
        this.script = this.script + "-COLOR\r\n" + "t\r\n" + DbClient.getSetting(3) + "," + DbClient.getSetting(4) + "," + DbClient.getSetting(5) +"\r\n";
        this.script = this.script + "-LWEIGHT\r\n" + DbClient.getSetting(1) + "\r\n";
        this.script = this.script + "SHADEMODE\r\n" + "2D" + "\r\n";
        this.script = this.script + "-LAYER\r\nM\r\n" + this.name + "\r\n\r\n";
        for(int f = 0; f <= 4*(this.faceNum) - 1; f++)
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
//        //TODO code application logic here
//        CircleToCircle CObj = new CircleToCircle("name", 2, 2, 2, 72, 8);
//        
//    }
    
}
