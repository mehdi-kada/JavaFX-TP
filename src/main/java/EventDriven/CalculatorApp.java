package EventDriven;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import javafx.geometry.Insets;
import javafx.geometry.Pos;

public class CalculatorApp extends Application {
@Override
    public void start(Stage stage) {
        // --- Labels & TextFields ---
        Label label1 = new Label("Nombre 1:");
        Label label2 = new Label("Nombre 2:");
        Label labelResult = new Label("Résultat:");

        TextField txtNombre1 = new TextField();
        TextField txtNombre2 = new TextField();
        TextField txtResultat = new TextField();
        txtResultat.setEditable(false);

        // Set preferred width for text fields to make them shorter
        txtNombre1.setPrefWidth(80);
        txtNombre2.setPrefWidth(80);
        txtResultat.setPrefWidth(80);

        // Arrange them horizontally
        HBox inputBox = new HBox(10); // spacing = 10
        inputBox.setAlignment(Pos.CENTER);
        inputBox.getChildren().addAll(label1, txtNombre1, label2, txtNombre2, labelResult, txtResultat);

        // --- Buttons ---
        Button btnAdd = new Button("+");
        Button btnSub = new Button("-");
        Button btnMul = new Button("*");
        Button btnDiv = new Button("/");

        // Set same size for buttons
        btnAdd.setPrefWidth(40);
        btnSub.setPrefWidth(40);
        btnMul.setPrefWidth(40);
        btnDiv.setPrefWidth(40);

        HBox buttonBox = new HBox(10);
        buttonBox.setAlignment(Pos.CENTER);
        buttonBox.setPadding(new Insets(10));
        buttonBox.getChildren().addAll(btnAdd, btnSub, btnMul, btnDiv);

        // --- Main Layout (BorderPane) ---
        BorderPane root = new BorderPane();
        root.setTop(inputBox);
        root.setBottom(buttonBox);
        root.setPadding(new Insets(20));

        // --- Button Actions ---
        btnAdd.setOnAction(e -> {
            double n1 = getNumber(txtNombre1);
            double n2 = getNumber(txtNombre2);
            txtResultat.setText(String.valueOf(n1 + n2));
        });

        btnSub.setOnAction(e -> {
            double n1 = getNumber(txtNombre1);
            double n2 = getNumber(txtNombre2);
            txtResultat.setText(String.valueOf(n1 - n2));
        });

        btnMul.setOnAction(e -> {
            double n1 = getNumber(txtNombre1);
            double n2 = getNumber(txtNombre2);
            txtResultat.setText(String.valueOf(n1 * n2));
        });

        btnDiv.setOnAction(e -> {
            double n1 = getNumber(txtNombre1);
            double n2 = getNumber(txtNombre2);
            if (n2 != 0)
                txtResultat.setText(String.valueOf(n1 / n2));
            else
                txtResultat.setText("Erreur");
        });

        // --- Scene setup ---
        Scene scene = new Scene(root, 400, 170);
        stage.setScene(scene);
        stage.setTitle("Calculette");
        stage.show();
    }

    private double getNumber(TextField txt) {
        try {
            return Double.parseDouble(txt.getText());
        } catch (NumberFormatException e) {
            return 0;
        }
    }

    public static void main(String[] args) {
        launch();
    }
}
