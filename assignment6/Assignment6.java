// Assignment #: Arizona State University CSE205 #6
//         Name: Lukas Opheim
//    StudentID: 1224151695
//      Lecture: CSE205 T,TH 10:30am
//  Description: The Assignment6 class creates a DrawPane object
//               on which we can draw different shapes with different
//               colors and erase one or all, etc.
//               see DrawPane.java

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.layout.StackPane;

public class Assignment6 extends Application
{
   public void start(Stage primaryStage)
   {
      //create a DrawPane object. See DrawPane.java for details.
      DrawPane gui = new DrawPane();

      //put gui on top of the rootPane
      StackPane rootPane = new StackPane();
      rootPane.getChildren().add(gui);

      // Create a scene and place rootPane in the stage
      Scene scene = new Scene(rootPane, 600, 400);
      primaryStage.setTitle("Shape Drawing");
      primaryStage.setScene(scene); // Place the scene in the stage
      primaryStage.show(); // Display the stage
   }
   public static void main(String[] args)
   {
      Application.launch(args);
   }
}