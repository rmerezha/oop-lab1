package rmerezha;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

import java.util.concurrent.atomic.AtomicInteger;

public class Module3InterfaceImpl implements Module3Interface {
    @Override
    public void run(AtomicInteger code, Stage stage) {
        Button prevButton = new Button("< Назад");
        Button yesButton = new Button("Так");
        Button cancelButton = new Button("Відміна");

        prevButton.setOnAction(e -> {
            code.set(-1);
            stage.close();
        });

        cancelButton.setOnAction(e -> {
            code.set(0);
            stage.close();
        });

        HBox hbox = new HBox(10, prevButton, yesButton, cancelButton);

        Scene scene = new Scene(hbox, 500, 250);
        stage.setScene(scene);
        stage.setTitle("module2_2");
    }
}
