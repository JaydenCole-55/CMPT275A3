package com.company;

public class Ellipse implements Shape{
    private String name;
    private String param1Name;
    private String param2Name;
    private double param1;
    private double param2;

    Ellipse(){
        setName("Ellipse");
        setName_p1("Radius 1 (cm)");
        setParam1(1.0);
        setName_p2("Radius 2 (cm)");
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

    // Calculate the circumference of the
    public double calculateCircumference(){
        // Very complicated to calculate the circumference of an ellipse using integrals.. ect
        // However, this website: https://www.easycalculation.com/code-java-program-ellipse-circumference.html
        // claims to calculate the circumference of an ellipse using the below formula:
        return 2*3.14*Math.sqrt((Math.pow(param1,2)+Math.pow(param2,2))/2);
    }

    // Calculate the area of the ellipse
    public double calculateArea(){
        return param1*param2*Math.PI;
    }
}
