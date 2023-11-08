package com.company;

public class Circle extends Ellipse{
    private double param1;

    public Circle(){
        super();
        setName_p1("Radius (cm)");
        setParam1(1.0);
        setName_p2("");
        setParam2(-1.0);
        setName("Circle");
    }

    // Setter for first parameter of the shape
    public void setParam1(double p1){
        param1 = p1;
    }

    // Getter for second parameter of the shape (if applicable)
    public double getParam2(){
        return -1.0;
    }

    // Getter for the name of the second parameter (if applicable)
    public String getName_p2(){
        return "";
    }

    // Calculate the circumference of the circle
    public double calculateCircumference(){
        return Math.PI*param1*2;
    }

    // Calculate the area of the circle
    public double calculateArea(){
        return param1*param1*Math.PI;
    }
}
