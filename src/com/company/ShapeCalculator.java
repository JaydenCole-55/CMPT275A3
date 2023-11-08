package com.company;

import javax.swing.*;
import java.awt.*;

public class ShapeCalculator extends JFrame {
    final int FRAME_HEIGHT = 600;
    final int FRAME_WIDTH  = 600;

    final String EQ_TRI  = "Equilateral Triangle";
    final String RECT    = "Rectangle";
    final String ELLIPSE = "Ellipse";
    final String SQUARE  = "Square";
    final String CIRCLE  = "Circle";

    private Shape myShape;

    // Shape selector JPanel
    final JPanel shapeSelector = new JPanel();

    // Attribute calculator JPanel
    final JPanel attributeCalc = new JPanel();
    // This is its subPanel
    JPanel dataPanel;

    // Definitions in the output panel
    JLabel label;
    JLabel description;
    JLabel description2;

    JPanel param1Panel;
    JLabel param1Name;
    JTextField param1Val;
    JPanel param2Panel;
    JLabel param2Name = new JLabel("");
    JTextField param2Val = new JTextField("");

    final JLabel noParam2Name = new JLabel("");
    final JLabel noParam2Val  = new JLabel("");

    JPanel calcButtonRow;
    JButton calcButton;

    JPanel displayCalcHeaders;
    JLabel circumTitle;
    JLabel areaTitle;

    JPanel displayCalcValues;
    JLabel circumVal;
    JLabel areaVal;

    public ShapeCalculator(){
        // Set some frame details
        setSize(FRAME_WIDTH, FRAME_HEIGHT);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Call display setup function
        setupDisplay();
    }

    public void setupDisplay(){
        /*
        Calls functions to create the top and the bottom of the display, then adds them to the Frame
        Passed: None
        Returns: None
         */
        setLayout(new GridLayout(2, 1));
        setupTopDisplay();
        setupBottomDisplay();

        // Add the two panels
        add(shapeSelector);
        add(attributeCalc);
    }

    public void setupTopDisplay(){
        /*
        Will set up the shape selection panel at the top of the program's UI.
        Passed: None
        Returns: None
         */

        // Set up shape selection display
        shapeSelector.setLayout(new GridLayout(4, 1));

        JLabel instructions = new JLabel("  Please select a shape:");

        // Add a shape drawing panel
        JPanel shapeDrawings = new JPanel();
        shapeDrawings.setLayout(new GridLayout(1, 5));

        // Now draw each shape to the panel
        ShapePanel EqTri   = new ShapePanel(EQ_TRI);
        ShapePanel Rect    = new ShapePanel(RECT);
        ShapePanel Ellipse = new ShapePanel(ELLIPSE);
        ShapePanel Square  = new ShapePanel(SQUARE);
        ShapePanel Circle  = new ShapePanel(CIRCLE);

        shapeDrawings.add(EqTri);
        shapeDrawings.add(Rect);
        shapeDrawings.add(Ellipse);
        shapeDrawings.add(Square);
        shapeDrawings.add(Circle);

        // Make Radio button panel
        JPanel radButtons = new JPanel();
        ButtonGroup chooseButtons = new ButtonGroup();

        radButtons.setLayout(new GridLayout(1, 5));

        JRadioButton triButton    = new JRadioButton();
        JRadioButton rectButton   = new JRadioButton();
        JRadioButton ovalButton   = new JRadioButton();
        JRadioButton squareButton = new JRadioButton();
        JRadioButton circleButton = new JRadioButton();

        // Set identifying names for each button
        triButton.setName(EQ_TRI);
        rectButton.setName(RECT);
        ovalButton.setName(ELLIPSE);
        squareButton.setName(SQUARE);
        circleButton.setName(CIRCLE);

        // Initialize one button to start
        triButton.setSelected(true);
        myShape = new EquilateralTri();

        // Add buttons to button group
        chooseButtons.add(triButton);
        chooseButtons.add(rectButton);
        chooseButtons.add(ovalButton);
        chooseButtons.add(squareButton);
        chooseButtons.add(circleButton);

        // Need to make the buttons centred within their grid
        triButton.setHorizontalAlignment(0);
        rectButton.setHorizontalAlignment(0);
        ovalButton.setHorizontalAlignment(0);
        squareButton.setHorizontalAlignment(0);
        circleButton.setHorizontalAlignment(0);

        // Add Radio buttons to their JPanel display
        radButtons.add(triButton);
        radButtons.add(rectButton);
        radButtons.add(ovalButton);
        radButtons.add(squareButton);
        radButtons.add(circleButton);

        // Add the "select shape" button below the radio buttons
        // First make JPanel divided into 5 parts and put button in middle
        JPanel selButPanel = new JPanel();
        selButPanel.setLayout(new GridLayout(1, 5, 5, 20));
        selButPanel.add(new JLabel(""));
        selButPanel.add(new JLabel(""));

        // Make and add select shape button to Panel, add what its' action listener is for
        JButton selectShapeButton = new JButton();
        selectShapeButton.setText("Select Shape");
        selectShapeButton.addActionListener(e -> {
            if(triButton.isSelected()){
                myShape = new EquilateralTri();
            } else if(rectButton.isSelected()){
                myShape = new Rectangle();
            } else if(ovalButton.isSelected()){
                myShape = new Ellipse();
            } else if( squareButton.isSelected() ){
                myShape = new Square();
            } else{
                myShape = new Circle();
            }

            // Make the bottom display reflect the selected shape
            updateBottomDisplay();
            calcButton.doClick();
        });
        selButPanel.add(selectShapeButton);

        // Format rest of the select shape button panel
        selButPanel.add(new JLabel(""));
        selButPanel.add(new JLabel(""));

        // Finally combine all the four components into the top JPanel of the UI
        shapeSelector.add(instructions);
        shapeSelector.add(shapeDrawings);
        shapeSelector.add(radButtons);
        shapeSelector.add(selButPanel);
    }

    public void setupBottomDisplay(){
        /*
        This function prepares the bottom of the UI for the shape calculator
        Passed: None
        Returns: None
         */

        // Make a 3x3 grid bag layout to put in bottom UI panel
        attributeCalc.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        c.fill = GridBagConstraints.HORIZONTAL;

        // Set up the grid bag layout constrains
        label = new JLabel("        ");
        c.weightx = 0.5;
        c.gridx = 0;
        c.gridy = 0;
        attributeCalc.add(label, c);

        // Set up the grid bag layout constrains (setting column width)
        label = new JLabel("        ");
        c.gridx = 1;
        attributeCalc.add(label, c);

        // Set up the grid bag layout constrains (setting column width)
        label = new JLabel("        ");
        c.gridx = 2;
        attributeCalc.add(label, c);

        // Column widths are set, create the panel where our UI box exists
        dataPanel = new JPanel();
        dataPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));

        dataPanel.setLayout(new GridLayout(7, 1));

        // Start adding the components of the panel to it
        description = new JLabel(" You have selected " + myShape.getName() + ".");
        description2 = new JLabel(" Enter the parameter(s) for " + myShape.getName() + ".");

        dataPanel.add(description);
        dataPanel.add(description2);

        // Create the first parameter inputs
        param1Panel = new JPanel(new GridLayout(1, 2));
        param1Name = new JLabel(" " + myShape.getName_p1());
        param1Val  = new JTextField(Double.toString(myShape.getParam1()));

        param1Panel.add(param1Name);
        param1Panel.add(param1Val);

        dataPanel.add(param1Panel);

        // In initialization, there is no second input for an equilateral triangle
        param2Panel = new JPanel(new GridLayout(1, 2));
        param2Panel.add(noParam2Name);
        param2Panel.add(noParam2Val);

        dataPanel.add(param2Panel);

        // Make and add a calculate button (within a row so that it is smaller)
        calcButtonRow = new JPanel(new GridLayout(1, 3, 10, 5));
        calcButtonRow.add(new JLabel(""));
        calcButton = new JButton();
        calcButton.setText("Calculate");
        calcButton.addActionListener(e -> {

            // Set new parameters, detect if there is a second parameter
            try {
                myShape.setParam2(Double.parseDouble(param2Val.getText()));
            } catch (Exception noSecondParam){ /* That's fine, no second parameter for this shape */}

            // Validate that input is a double, set parameter to 0 if not
            try {
                myShape.setParam1(Double.parseDouble(param1Val.getText()));
                param1Val.setForeground(Color.BLACK);
            } catch (Exception notADouble) {
                // Input not a double so set to 0
                myShape.setParam1(0);
                param1Val.setForeground(Color.RED);
                param1Val.setText("Please enter a number");
            }

            // Validate that input is a double, set parameter to 0 if not
            if(myShape.getParam2() != -1){
                try {
                    myShape.setParam2(Double.parseDouble(param2Val.getText()));
                    param2Val.setForeground(Color.BLACK);
                } catch (Exception notADouble) {
                    // Input not a double so set to 0
                    myShape.setParam2(0);
                    param2Val.setForeground(Color.RED);
                    param2Val.setText("Please enter a number");
                }
            }

            // Calculate area and circumference and update display
            areaVal.setText( Double.toString(myShape.calculateArea()));
            circumVal.setText( " " + myShape.calculateCircumference() );

        });
        calcButtonRow.add(calcButton);
        calcButtonRow.add(new JLabel(""));
        dataPanel.add(calcButtonRow);

        // Display calculated area and circumference headers
        displayCalcHeaders = new JPanel(new GridLayout(1, 2));
        circumTitle = new JLabel(" Circumference (cm)");
        areaTitle = new JLabel("Area (cm*cm)");

        displayCalcHeaders.add(circumTitle);
        displayCalcHeaders.add(areaTitle);

        dataPanel.add(displayCalcHeaders);

        // Display calculated area circumference values
        displayCalcValues = new JPanel(new GridLayout(1,2));
        circumVal = new JLabel(" " + myShape.calculateCircumference() );
        areaVal = new JLabel(Double.toString( myShape.calculateArea() ));

        displayCalcValues.add(circumVal);
        displayCalcValues.add(areaVal);

        dataPanel.add(displayCalcValues);

        // Finish formatting our panel for the grid bag.
        c.fill = GridBagConstraints.HORIZONTAL;
        c.ipady = 20;
        c.ipadx = 50;
        c.weightx = 0.0;
        c.gridwidth = 1;
        c.gridx = 1;
        c.gridy = 1;
        attributeCalc.add(dataPanel, c);
    }

    public void updateBottomDisplay(){
        /*
        Updates the bottom UI box for a new shape
        Passed: None
        Returns: None
         */

        // Update which shape is selected
        description.setText(" You have selected " + myShape.getName() + ".");
        description2.setText(" Enter the parameter(s) for " + myShape.getName() + ".");

        param1Name.setText( " " + myShape.getName_p1() );

        // Ensure only the necessary parameters are shown to the screen
        boolean shapeHas2params = (myShape.getParam2() != -1.0);
        if(shapeHas2params) {
            param2Name.setText(" " + myShape.getName_p2());
            param2Val.setText( Double.toString(myShape.getParam2()) );
            param2Panel.remove(1);
            param2Panel.remove(0);
            param2Panel.add(param2Name);
            param2Panel.add(param2Val);
        } else {
            param2Panel.remove(1);
            param2Panel.repaint();
            param2Panel.revalidate();
            param2Name.setText("");
            param2Panel.add(noParam2Val);
        }
    }
}

