package rmerezha;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

import java.util.concurrent.atomic.AtomicInteger;

public class App extends Application {

    private final Module1Interface module1 = new Module1InterfaceImpl();
    private final Module2Interface module2 = new Module2InterfaceImpl();
    private final Module3Interface module3 = new Module3InterfaceImpl();

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        Button project1 = new Button("Project1");
        Button project2 = new Button("Project2");

        project1.setOnAction(e -> {
            stage.close();
            module1.run();
        });

        project2.setOnAction(e -> {
            stage.close();
            var code = new AtomicInteger();
            runModule2(code);
        });

        HBox hbox = new HBox(10, project1, project2);

        Scene scene = new Scene(hbox, 500, 250);
        stage.setScene(scene);
        stage.setTitle("runner");
        stage.show();
    }

    private void runModule2(AtomicInteger code) {
        Platform.runLater(() -> {
            Stage module2Stage = new Stage();
            module2.run(code, module2Stage);
            module2Stage.setOnHiding(event -> handleCodeUpdate(code));
            module2Stage.show();
        });
    }

    private void runModule3(AtomicInteger code) {
        Platform.runLater(() -> {
            Stage module3Stage = new Stage();
            module3.run(code, module3Stage);
            module3Stage.setOnHiding(event -> handleCodeUpdate(code));
            module3Stage.show();
        });
    }

    private void handleCodeUpdate(AtomicInteger code) {
        if (code.get() == 1) {
            runModule3(code);
        } else if (code.get() == -1) {
            runModule2(code);
        }
    }
}