package rmerezha;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollBar;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;



public class Module1InterfaceImpl implements Module1Interface {

    @Override
    public void run() {
        Stage stage = new Stage();
        ScrollBar scrollBar = new ScrollBar();
        scrollBar.setMin(1);
        scrollBar.setMax(100);
        scrollBar.setPrefWidth(200);

        Button yesButton = new Button("Так");
        Button cancelButton = new Button("Відміна");

        Label selectedValueLabel = new Label();
        yesButton.setOnAction(event -> {
            int selectedValue = (int) scrollBar.getValue();
            selectedValueLabel.setText(selectedValue + "");
        });
        cancelButton.setOnAction(e -> {
            stage.close();
        });
        HBox hbox = new HBox(10, yesButton, cancelButton);
        VBox vbox = new VBox(20, scrollBar, selectedValueLabel, hbox);

        Scene scene = new Scene(vbox, 500, 250);
        stage.setScene(scene);
        stage.setTitle("module1");
        stage.show();
    }
}
