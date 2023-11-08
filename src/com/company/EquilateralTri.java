package com.company;

public class EquilateralTri implements Shape{
    private String name = "Equilateral Triangle";
    private String param1Name;
    private double param1;

    EquilateralTri(){
        setName_p1("Side length");
        setParam1(1.0);
    }

    // Setter for name of the shape
    public void setName(String n){
        this.name = n;
    }

    // Getter for name of the shape
    public String getName(){
        return name;
    }

    // Setter for first parameter of the shape
    public void setParam1(double p1){
        param1 = p1;
    }

    // Setter for second parameter of the shape (if applicable)
    public void setParam2(double p2){
        // Not applicable
    }

    // Getter for first parameter of the shape
    public double getParam1(){
        return param1;
    }

    // Getter for second parameter of the shape (if applicable)
    public double getParam2(){
        // Not applicable
        return -1.0;
    }

    // Setter for the name of the first parameter
    public void setName_p1(String n1){
        param1Name = n1;
    }

    // Setter for the name of the second parameter (if applicable)
    public void setName_p2(String n2){
        // Not applicable
    }

    // Getter for the name of the first parameter
    public String getName_p1(){
        return param1Name;
    }

    // Getter for the name of the second parameter (if applicable)
    public String getName_p2(){
        return "";
    }

    // Calculate the circumference of the triangle
    public double calculateCircumference(){
        return 3*param1;
    }

    // Calculate the area of the triangle
    public double calculateArea(){
        return (1.0/4.0)*param1*param1*Math.sqrt(3);
    }
}
