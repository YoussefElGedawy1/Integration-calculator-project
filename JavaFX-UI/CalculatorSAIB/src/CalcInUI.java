import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class CalcInUI extends Application {

    private static final String FILE_PATH = "C:\\Users\\ammar\\OneDrive\\Desktop\\INPUT\\CalcReadInput.txt";

    @Override
    public void start(Stage primaryStage) {
        TextField opAField = new TextField();
        TextField opBField = new TextField();
        ComboBox<String> operationBox = new ComboBox<>();
        operationBox.getItems().addAll("+", "-", "*", "/");

        Button writeButton = new Button("Add Operation to File");
        Button clearButton = new Button("Clear File");

        Label statusLabel = new Label();

        writeButton.setOnAction(e -> {
            try {
                float opA = Float.parseFloat(opAField.getText());
                float opB = Float.parseFloat(opBField.getText());
                String operation = operationBox.getValue();

                if (operation == null) {
                    statusLabel.setText("Select an operation.");
                    return;
                }

                FileWriter writer = new FileWriter(FILE_PATH, true);
                writer.write(opA + "|" + opB + "|" + operation + "\r\n");
                writer.close();

                statusLabel.setText("Operation added.");
                opAField.clear();
                opBField.clear();
                operationBox.getSelectionModel().clearSelection();

            } catch (NumberFormatException nfe) {
                statusLabel.setText("Please enter valid float numbers.");
            } catch (IOException ioe) {
                statusLabel.setText("Error writing to file.");
            }
        });

        clearButton.setOnAction(e -> {
            try {
                Files.write(Paths.get(FILE_PATH), "".getBytes());
                statusLabel.setText("File cleared.");
            } catch (IOException ioe) {
                statusLabel.setText("Error clearing file.");
            }
        });

        VBox root = new VBox(10,
                new Label("Enter First Float:"), opAField,
                new Label("Enter Second Float:"), opBField,
                new Label("Select Operation:"), operationBox,
                writeButton, clearButton, statusLabel
        );
        root.setPadding(new Insets(15));

        primaryStage.setTitle("Calculator Input UI");
        primaryStage.setScene(new Scene(root, 300, 350));
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
