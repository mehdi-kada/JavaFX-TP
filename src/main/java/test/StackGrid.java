package test;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;


public class StackGrid extends Application {


   @Override
   public void start(Stage primaryStage) {
 BorderPane borderPane = new BorderPane();
       borderPane.setPadding(new Insets(10,10,10,10));


       // this are those two buttons
       HBox bottomBox = new HBox(10);
       Button btnAccelerer = new Button("Accélérer");
       Button btnRalentir = new Button("Ralentir");
       btnAccelerer.setMaxWidth(Double.MAX_VALUE);
       btnRalentir.setMaxWidth(Double.MAX_VALUE);
       HBox.setHgrow(btnAccelerer, Priority.ALWAYS);
       HBox.setHgrow(btnRalentir, Priority.ALWAYS);
       bottomBox.getChildren().addAll(btnAccelerer, btnRalentir);
       bottomBox.setAlignment(Pos.CENTER);
       borderPane.setBottom(bottomBox);
       BorderPane.setMargin(bottomBox, new Insets(5,0,0,0));


       // this is the right grid
       GridPane rightGrid = new GridPane();
       rightGrid.setHgap(0);
       rightGrid.setVgap(0);
      
       Button btnADroit = new Button("ADroit");
       btnADroit.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
       Button btnAGauche = new Button("AGAuche");
       btnAGauche.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
       Button btnEnHaut = new Button("enHaut");
       btnEnHaut.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
       Button btnEnBas = new Button("enBAS");
       btnEnBas.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
      
       GridPane.setHgrow(btnADroit, Priority.ALWAYS);
       GridPane.setVgrow(btnADroit, Priority.ALWAYS);
       GridPane.setHgrow(btnAGauche, Priority.ALWAYS);
       GridPane.setVgrow(btnAGauche, Priority.ALWAYS);
       GridPane.setHgrow(btnEnHaut, Priority.ALWAYS);
       GridPane.setVgrow(btnEnHaut, Priority.ALWAYS);
       GridPane.setHgrow(btnEnBas, Priority.ALWAYS);
       GridPane.setVgrow(btnEnBas, Priority.ALWAYS);
      
       rightGrid.add(btnADroit, 0, 0);
       rightGrid.add(btnAGauche, 1, 0);
       rightGrid.add(btnEnHaut, 0, 1);
       rightGrid.add(btnEnBas, 1, 1);
       borderPane.setRight(rightGrid);
       BorderPane.setMargin(rightGrid,new Insets(0,0,0,20));


       // group the label and stackpane together
       VBox centerContainer = new VBox();
       Label topLabel = new Label("ceci est ma future zone de dessin");
       topLabel.setAlignment(Pos.CENTER);
       topLabel.setMaxWidth(Double.MAX_VALUE);
       VBox.setMargin(topLabel, new Insets(0,10,5,0));
      
       StackPane centerPane = new StackPane();
       centerPane.setStyle("-fx-border-color: lightgray; -fx-background-color: white");
       centerPane.setMinSize(150, 130);
       VBox.setVgrow(centerPane, Priority.ALWAYS);
      
       centerContainer.getChildren().addAll(topLabel, centerPane);
       centerContainer.setAlignment(Pos.TOP_CENTER);
       borderPane.setCenter(centerContainer);


       Scene scene = new Scene(borderPane, 700,200);
       primaryStage.setTitle("jeu_v1");
       primaryStage.setScene(scene);
       primaryStage.show();


   }


   public static void main(String[] args) {
       launch(args);
   }
}
