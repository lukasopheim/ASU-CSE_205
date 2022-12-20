// Assignment #: Arizona State University CSE205 #6
//         Name: Lukas Opheim
//    StudentID: 1224151695
//      Lecture: CSE205 T,TH 10:30am
//  Description: The DrawPane class creates a canvas where we can use
//               mouse key to draw either a Rectangle, a Circle or an Arc with different
//               colors. We can also use the the two buttons to erase the last
//				 drawn shape or clear them all.

//import any classes necessary here
//----
import javafx.scene.shape.Shape;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Arc;
import javafx.scene.shape.ArcType;
import javafx.scene.shape.Circle;
import javafx.scene.paint.Color;
import javafx.geometry.Pos;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;

// the following are imports I imported 
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.*;
import java.util.ArrayList;

public class DrawPane extends BorderPane
{
   private Button undoBtn, eraseBtn;
   private ComboBox<String> colorCombo;
   private RadioButton rbRect, rbCircle, rbArc;
   private ArrayList<Shape> shapeList;
   private Pane canvas;
   //declare any other necessary instance variables here
   //----
   private Color currentColor;
   private Circle circle;
   private Rectangle rect;
   private Arc arc;
   private double x1, y1, x2, y2;

   //Constructor
   public DrawPane()
   {
      //Step #1: initialize each instance variable and set up layout
      undoBtn = new Button("Undo");
      eraseBtn = new Button("Erase");
      undoBtn.setMinWidth(80.0);
      eraseBtn.setMinWidth(80.0);

	  //initialize instance variables and set up the layout
      //----
      //----
      x1 = 0;
      x2 = 0;
      y1 = 0;
      y2 = 0;
      this.currentColor = Color.BLACK;//ShapeList where
      this.shapeList = new ArrayList<Shape>();
   
      // initializing the combo box for color choices 
      colorCombo = new ComboBox<String>();
      colorCombo.setStyle("-fx-color:white");
      colorCombo.setStyle("-fx-border-color: blue");
      colorCombo.getItems().addAll("Black", "Blue", "Green", "Red", "Yellow", "Orange", "Pink");
      colorCombo.setValue("Black");
       
      //initializing radio buttons for shape 
      rbRect = new RadioButton("Rectangle");
      rbCircle = new RadioButton("Circle");
      rbArc = new RadioButton("Arc");
      
      //Add radio Buttons to the same group so only one can be clicked at a time
      ToggleGroup tg1 = new ToggleGroup();
      rbRect.setToggleGroup(tg1);
      rbCircle.setToggleGroup(tg1);
      rbArc.setToggleGroup(tg1);
      
      rbRect.setSelected(true);
      
      circle=null;
      rect=null;
      arc=null;
      
      //initialize shapeList, it is a data structure we used
      //to track the shape we drew
      //----
      this.shapeList = new ArrayList<Shape>();
      

      //canvas is a Pane where we will draw rectagles, circles and arcs on it
      canvas = new Pane();
      canvas.setStyle("-fx-background-color: Azure;");
      canvas.setMaxSize(490, 345);
      
      //------LAYOUT----
      // this vbox is on the left on the pane, holding the radio buttons and the and the combo box 
      VBox vbox1 = new VBox(colorCombo, rbRect, rbCircle, rbArc);
      vbox1.setMinSize(110, 20);
      vbox1.setAlignment(Pos.TOP_LEFT);
      vbox1.setSpacing(35); 
      // hbox for bottom node of borderpane 
      HBox bottom_hbox = new HBox(20, undoBtn,eraseBtn);
      bottom_hbox.setMinSize(20, 55); 
      bottom_hbox.setAlignment(Pos.CENTER);
      // borderpane layout
      super.setCenter(canvas);
      super.setLeft(vbox1);
      super.setBottom(bottom_hbox);

      //Step #3: Register the source nodes with its handler objects
      canvas.setOnMousePressed(new MouseHandler());
      //----
      //----
      EventHandler<ActionEvent> handler = new ShapeHandler();
      rbRect.setOnAction(handler);
      rbCircle.setOnAction(handler);
      rbArc.setOnAction(handler);
      canvas.setOnMousePressed(new MouseHandler());
      canvas.setOnMouseDragged(new MouseHandler());
      canvas.setOnMouseReleased(new MouseHandler());
      colorCombo.setOnAction(new ColorHandler());
      rbCircle.setOnAction(new ShapeHandler());
      rbRect.setOnAction(new ShapeHandler());
      rbArc.setOnAction(new ShapeHandler());
      undoBtn.setOnAction(new ButtonHandler());
      eraseBtn.setOnAction(new ButtonHandler());
    }

   //Step #2(A) - MouseHandler
   private class MouseHandler implements EventHandler<MouseEvent>
   {
      public void handle(MouseEvent event)
      {
		 //handle MouseEvent here
		 //----
    	  // if user is drawing a circle 
    	  if(rbCircle.isSelected()) 
    	  {
    		  if (event.getEventType() == MouseEvent.MOUSE_PRESSED) 
    	  {
    			  x1 = event.getX();
    			  y1 = event.getY();
    			  circle = new Circle();
    			  circle.setCenterX(x1);
    			  circle.setCenterY(y1);
    			  shapeList.add(circle);
    			  circle.setFill(Color.WHITE);
    			  circle.setStroke(Color.BLACK);
    			  canvas.getChildren().add(circle);
    	  }
    		  else if (event.getEventType() == MouseEvent.MOUSE_DRAGGED) 
    		  {
    			  double tempX = event.getX();
    			  double tempY = event.getY();
    			  double dx = Math.abs(tempX - x1);
    			  double dy = Math.abs(tempY - y1);
    			  double radius = Math.sqrt(dx * dx + dy * dy);
    			  if( x1 >= 490) 
    			  {
    				  x1 = 440;
    			  }
    			  circle.setRadius(radius); 
    		  }
    		  //If the Mouse is released, fill the color 
    		  else if (event.getEventType() == MouseEvent.MOUSE_RELEASED) 
    		  {
    			  circle.setFill(currentColor);
    		  }
    	  }
    	  // if user is drawing a rectangle 
    	  else if (rbRect.isSelected()) {
    		  //If the Mouse is Pressed
    		  if (event.getEventType() == MouseEvent.MOUSE_PRESSED) 
    		  {
    			  x2 = event.getX();
    			  y2 = event.getY();
    			  rect = new Rectangle();
    			  rect.setX(x2);
    			  rect.setY(y2);
    			  shapeList.add(rect);
    			  rect.setFill(Color.WHITE);
    			  rect.setStroke(Color.BLACK);
    			  canvas.getChildren().add(rect);
    		  }
    		  //If the mouse gets dragged
    		  else if (event.getEventType() == MouseEvent.MOUSE_DRAGGED) 
    		  {
    			  double tempX2 = event.getSceneX();
    			  double tempY2 = event.getSceneY();
    			  double dx = Math.abs(tempX2 - x2);
    			  double dy = Math.abs(tempY2 - y2);
    			  rect.setWidth(dx);
    			  rect.setHeight(dy);
    		  }
    		  //If the Mouse is released, fill the color 
    		  else if (event.getEventType() == MouseEvent.MOUSE_RELEASED) 
    		  {
    			  rect .setFill(currentColor);
    		  }
    	  }
    	  
    		  // if the user is drawing an arc
    		  else if (rbArc.isSelected()) {
    			  if (event.getEventType() == MouseEvent.MOUSE_PRESSED) 
        		  {
        			  x2 = event.getX();
        			  y2 = event.getY();
        			  //arc properties 
        			  arc = new Arc(); 
        			  arc.setCenterX(x2); 
        		      arc.setCenterY(y2);  
        		      arc.setStartAngle(0);
        			  arc.setType(ArcType.ROUND);
        			  shapeList.add(arc);
        			  arc.setFill(Color.WHITE);
        			  arc.setStroke(Color.BLACK);
        			  //add the arc to the canvas
        			  canvas.getChildren().add(arc);
        		  }
        		  //If the mouse gets dragged
        		  else if (event.getEventType() == MouseEvent.MOUSE_DRAGGED) 
        		  {
        			  double tempX2 = event.getSceneX();
        			  double tempY2 = event.getSceneY();
        			  double dx = (tempX2 - x2);
        			  double dy = (tempY2 - y2);
        			  double angleInRadians = Math.atan2(-dy, dx);
        			  double length = Math.toDegrees(angleInRadians);
        			  //arc properties 
        		      arc.setRadiusX(dx);
        			  arc.setRadiusY(dx/2);
        		      arc.setLength(length);
        		  }
        		  //If the Mouse is released, fill the color 
        		  else if (event.getEventType() == MouseEvent.MOUSE_RELEASED) 
        		  {
        			  arc.setFill(currentColor);
        		  }
    		  }
    	 
      }//end handle()
   }//end MouseHandler
    	  
   //Step #2(B)- A handler class used to handle events from Undo & Erase buttons
   private class ButtonHandler implements EventHandler<ActionEvent>
   {
      public void handle(ActionEvent event)
      {
		  //write your codes here
		  //----
    	  // Create source for event to know whuch button is pressed
    	  Object s = event.getSource(); 
    	 //if user clicks undo, remove last shape from cnavas and the arraylist
    	  if (s == undoBtn) 
    	  {
    		  if (shapeList.size() > 0) 
    		  {
    			  shapeList.remove(shapeList.size()-1);
    			  canvas.getChildren().remove(shapeList.size());
    		  }
    	  } 
    	  //if user clicks erase, remove all shapes from both the list and the canvas, 
    	  //but from the arraylist second so we can remove the list from the canvas
    	  else if (s == eraseBtn) {
    		  canvas.getChildren().removeAll(shapeList);
    		  shapeList.removeAll(shapeList);
    	  }
      }
   }//end ButtonHandler

   //Step #2(C)- A handler class used to handle events from the three radio buttons
   private class ShapeHandler implements EventHandler<ActionEvent>
   {
      public void handle(ActionEvent event)
      {
		  //write your own codes here
		  //----
    	
    	  // no need for this class 
    	  if(rbRect.isSelected()) 
    	  {
    	  }
    	  else if(rbCircle.isSelected()) 
    	  {
    	  }
    	  else if(rbArc.isSelected()) 
    	  {
    	  }


      }
   }//end ShapeHandler

   //Step #2(D)- A handler class used to handle colors from the combo box
   private class ColorHandler implements EventHandler<ActionEvent>
   {
      public void handle(ActionEvent event)
      {
		  //write your own codes here
		  //----
    	//If Black is selected from the combo box, change current color to black
    	  if (colorCombo.getSelectionModel().getSelectedIndex() == 0) {
    		  currentColor = Color.BLACK;
    		  colorCombo.setValue("Black");
    	  }
    	  //if blue is selected
    	  	else if(colorCombo.getSelectionModel().getSelectedIndex() == 1) {
    		  currentColor = Color.BLUE;
    		  colorCombo.setValue("Blue");
    		  //if Green is selected
    	  } else if (colorCombo.getSelectionModel().getSelectedIndex() == 2) {
    		  currentColor = Color.GREEN;
    		  colorCombo.setValue("Green");

    		  //if Red is selected
    	  } else if (colorCombo.getSelectionModel().getSelectedIndex() == 3) {
    		  currentColor = Color.RED;
    		  colorCombo.setValue("Red");

    		  //if Yellow is selected
    	  } else if (colorCombo.getSelectionModel().getSelectedIndex() == 4) {
    		  currentColor = Color.YELLOW;
    		  colorCombo.setValue("Yellow");

    		  //if Orange is selected
    	  } else if (colorCombo.getSelectionModel().getSelectedIndex() == 5) {
    		  currentColor = Color.ORANGE;
    		  colorCombo.setValue("Orange");

    		  //if Pink is selected
    	  } else if (colorCombo.getSelectionModel().getSelectedIndex() == 6) {
    		  currentColor = Color.PINK;
    		  colorCombo.setValue("Pink");

    		  }
      }
   }//end ColorHandler

}//end class DrawPane