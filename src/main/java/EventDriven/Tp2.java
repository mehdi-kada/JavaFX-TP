package EventDriven;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class Tp2 extends Application {
    @Override
    public void start(Stage primaryStage){
        HBox pane = new HBox(10);
        pane.setAlignment(Pos.CENTER);
        Button btnOk = new Button("OK");
        btnOk.setOnAction(e -> System.out.println("Ok button clicked : " + e));
        Button btnCancel = new Button("Cancel");
        CancelHandlerClass handler2 = new CancelHandlerClass();
        btnCancel.setOnAction(handler2);
        pane.getChildren().addAll(btnOk, btnCancel);

        Scene scene = new Scene(pane, 400, 300);
        primaryStage.setTitle("HandleEvent");
        primaryStage.setScene(scene);
        primaryStage.show();

    }
    public static void main(String[] args) {
        launch(args);
    }
}

class OkHandlerClass implements EventHandler<ActionEvent>{
    @Override
    public void handle(ActionEvent e){
        System.out.println("Ok button clicked : " + e);
    }
}

class CancelHandlerClass implements EventHandler<ActionEvent>{
    @Override
    public void handle(ActionEvent e){
        System.out.println("Cancel button clicked : " + e);
    }
}