package com.company;

public class Rectangle implements Shape{
    private String name = "Rectangle";
    private String param1Name;
    private String param2Name;
    private double param1;
    private double param2;

    Rectangle(){
        setName_p1("Width");
        setParam1(1.0);
        setName_p2("Height");
        setParam2(1.0);
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
        param2 = p2;
    }

    // Getter for first parameter of the shape
    public double getParam1(){
        return param1;
    }

    // Getter for second parameter of the shape (if applicable)
    public double getParam2(){
        return param2;
    }

    // Setter for the name of the first parameter
    public void setName_p1(String n1){
        param1Name = n1;
    }

    // Setter for the name of the second parameter (if applicable)
    public void setName_p2(String n2){
        param2Name = n2;
    }

    // Getter for the name of the first parameter
    public String getName_p1(){
        return param1Name;
    }

    // Getter for the name of the second parameter (if applicable)
    public String getName_p2(){
        return param2Name;
    }

    // Calculate the circumference of the rectangle
    public double calculateCircumference(){
        return param1*2+param2*2;
    }

    // Calculate the area of the rectangle
    public double calculateArea(){
        return param1*param2;
    }
}
