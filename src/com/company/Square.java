package com.company;

public class Square extends Rectangle{
    private double param1;

    Square(){
        super();
        setName_p1("Side length (cm)");
        setName_p2("");
        setName("Square");
    }

    // Setter for first parameter of the shape
    public void setParam1(double p1){
        param1 = p1;
    }

    // Getter for second parameter of the shape (if applicable)
    public double getParam2(){
        return -1;
    }

    // Calculate the circumference of the square
    public double calculateCircumference(){
        return param1*2+param1*2;
    }

    // Calculate the area of the square
    public double calculateArea() { return param1*param1; }
}
