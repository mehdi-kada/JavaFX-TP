package EventDriven;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class BalleMobile extends Application {

    // Ball properties
    private double x = 100;
    private double y = 80;
    private final double radius = 20;

    private GraphicsContext gc;

    // For dragging logic
    private boolean dragging = false;
    private double offsetX, offsetY;

    @Override
    public void start(Stage stage) {
        // --- Canvas (Drawing Area) ---
        Canvas canvas = new Canvas(400, 250);
        gc = canvas.getGraphicsContext2D();
        drawBall();

        // --- Buttons ---
        Button btnGauche = new Button("Gauche");
        Button btnDroite = new Button("Droite");
        Button btnHaut = new Button("Haut");
        Button btnBas = new Button("Bas");

        btnGauche.setPrefWidth(70);
        btnDroite.setPrefWidth(70);
        btnHaut.setPrefWidth(70);
        btnBas.setPrefWidth(70);

        // --- Button Box Layout ---
        HBox controls = new HBox(10);
        controls.setAlignment(Pos.CENTER);
        controls.setPadding(new Insets(10));
        controls.getChildren().addAll(btnGauche, btnDroite, btnHaut, btnBas);

        // --- Main Layout ---
        BorderPane root = new BorderPane();
        root.setCenter(canvas);
        root.setBottom(controls);

        Scene scene = new Scene(root, 400, 300);
        stage.setScene(scene);
        stage.setTitle("Balle-Mobile");
        stage.show();

        // --- Button Events ---
        btnGauche.setOnAction(e -> moveBall(-10, 0));
        btnDroite.setOnAction(e -> moveBall(10, 0));
        btnHaut.setOnAction(e -> moveBall(0, -10));
        btnBas.setOnAction(e -> moveBall(0, 10));

        // --- Mouse Events (Drag) ---
        canvas.addEventHandler(MouseEvent.MOUSE_PRESSED, e -> {
            if (isInsideBall(e.getX(), e.getY())) {
                dragging = true;
                offsetX = e.getX() - x;
                offsetY = e.getY() - y;
            }
        });

        canvas.addEventHandler(MouseEvent.MOUSE_DRAGGED, e -> {
            if (dragging) {
                x = e.getX() - offsetX;
                y = e.getY() - offsetY;
                keepInsideCanvas(canvas);
                drawBall();
            }
        });

        canvas.addEventHandler(MouseEvent.MOUSE_RELEASED, e -> dragging = false);
    }

    // Move ball with buttons
    private void moveBall(double dx, double dy) {
        x += dx;
        y += dy;
        keepInsideCanvas(gc.getCanvas());
        drawBall();
    }

    // Draw ball at current position
    private void drawBall() {
        gc.clearRect(0, 0, 400, 250);
        gc.setFill(Color.LIGHTGRAY);
        gc.fillRect(0, 0, 400, 250);

        gc.setFill(Color.CORNFLOWERBLUE);
        gc.fillOval(x, y, radius * 2, radius * 2);
        gc.setStroke(Color.BLACK);
        gc.strokeOval(x, y, radius * 2, radius * 2);
    }

    // Check if mouse click is inside ball
    private boolean isInsideBall(double mouseX, double mouseY) {
        double centerX = x + radius;
        double centerY = y + radius;
        double dx = mouseX - centerX;
        double dy = mouseY - centerY;
        return dx * dx + dy * dy <= radius * radius;
    }

    // Keep ball inside canvas boundaries
    private void keepInsideCanvas(Canvas canvas) {
        if (x < 0) x = 0;
        if (y < 0) y = 0;
        if (x > canvas.getWidth() - 2 * radius) x = canvas.getWidth() - 2 * radius;
        if (y > canvas.getHeight() - 2 * radius) y = canvas.getHeight() - 2 * radius;
    }

    public static void main(String[] args) {
        launch();
    }
}
