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

public class Devoir extends Application {

    @Override
    public void start(Stage primaryStage) {


        BorderPane borderPane = new BorderPane();
        borderPane.setPadding(new Insets(10, 10, 10, 10));

        GridPane rightGrid = new GridPane();
        rightGrid.setHgap(10);
        rightGrid.setVgap(10);

        Button btnEnHaut = new Button("enHaut");
        Button btnAGauche = new Button("AGauche");
        Button btnADroite = new Button("ADroite");
        Button btnEnBas = new Button("enBas");

        btnEnHaut.setMaxWidth(Double.MAX_VALUE);
        btnAGauche.setMaxWidth(Double.MAX_VALUE);
        btnADroite.setMaxWidth(Double.MAX_VALUE);
        btnEnBas.setMaxWidth(Double.MAX_VALUE);

        GridPane.setHgrow(btnEnHaut, Priority.ALWAYS);
        GridPane.setHgrow(btnAGauche, Priority.ALWAYS);
        GridPane.setHgrow(btnADroite, Priority.ALWAYS);
        GridPane.setHgrow(btnEnBas, Priority.ALWAYS);
        GridPane.setVgrow(btnEnHaut, Priority.ALWAYS);
        GridPane.setVgrow(btnAGauche, Priority.ALWAYS);
        GridPane.setVgrow(btnADroite, Priority.ALWAYS);
        GridPane.setVgrow(btnEnBas, Priority.ALWAYS);

        rightGrid.add(btnEnHaut, 1, 0);    
        rightGrid.add(btnAGauche, 0, 1);   
        rightGrid.add(btnADroite, 2, 1);   
        rightGrid.add(btnEnBas, 1, 2);     

        VBox centerContainer = new VBox(5);
        
        Label topLabel = new Label("ceci est ma future zone de dessin");
        topLabel.setStyle("-fx-font-size: 12;");
        topLabel.setMaxWidth(Double.MAX_VALUE);
        topLabel.setAlignment(Pos.CENTER);
        
        StackPane centerPane = new StackPane();
        centerPane.setStyle("-fx-border-color: lightgray; -fx-background-color: white;");
        VBox.setVgrow(centerPane, Priority.ALWAYS);
        
        centerContainer.getChildren().addAll(topLabel, centerPane);
        HBox.setHgrow(centerContainer, Priority.ALWAYS);

        HBox mainContent = new HBox(10);
        mainContent.getChildren().addAll(centerContainer, rightGrid);
        HBox.setHgrow(rightGrid, Priority.ALWAYS);
        mainContent.setAlignment(Pos.CENTER_LEFT);
        
        borderPane.setCenter(mainContent);
        BorderPane.setMargin(rightGrid, new Insets(0, 0, 0, 10));

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
        BorderPane.setMargin(bottomBox, new Insets(5, 0, 0, 0));

        Scene scene = new Scene(borderPane, 400, 300);
        primaryStage.setTitle("jeu_v2");
        primaryStage.setScene(scene);
        primaryStage.show();

    }

    public static void main(String[] args) {
        launch(args);
    }
}