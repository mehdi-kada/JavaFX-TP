package test;

import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;


public class Grid extends Application {


   @Override
   public void start(Stage primaryStage) {


       GridPane gridPane = new GridPane();
       gridPane.setPadding(new Insets(15, 15, 15, 15));
       gridPane.setHgap(10);
       gridPane.setVgap(10);
       gridPane.setAlignment(Pos.CENTER);


       gridPane.add(new Label("Enter your password:"), 0, 0);
       TextField txtf = new TextField();
       txtf.setPrefColumnCount(20);
       gridPane.add(txtf, 1, 0);


       HBox buttonBox = new HBox(10);
       buttonBox.getChildren().addAll(new Button("Cancel"), new Button("Login"));
       buttonBox.setAlignment(Pos.CENTER);


       gridPane.add(buttonBox, 0, 1, 2, 1);
       GridPane.setHalignment(buttonBox, HPos.CENTER);


       Scene scene = new Scene(gridPane, 600, 150);
       primaryStage.setTitle("More Complex Layout GUI Example");
       primaryStage.setScene(scene);
       primaryStage.show();
   }


   public static void main(String[] args) {
       launch(args);
   }
}


