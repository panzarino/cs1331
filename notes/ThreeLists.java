import javafx.application.Application;
import javafx.beans.binding.Bindings;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class ThreeLists extends Application {

    @Override
    public void start(Stage stage) {
        ObservableList<String> todoList = FXCollections.observableArrayList();
        ObservableList<Button> buttonList = FXCollections.observableArrayList();
        ObservableList<String> playList = FXCollections.observableArrayList();
        ListView<String> listView1 = new ListView<String>(todoList);
        ListView<Button> listView2 = new ListView<Button>(buttonList);
        ListView<String> listView3 = new ListView<String>(playList);

        Button addButton = new Button();
        addButton.setText("Add");

        TextField inputField = new TextField();

        addButton.setOnAction(e -> {
            todoList.add(inputField.getText());
            Button b = new Button(inputField.getText());
            b.setOnAction(x -> {
                playList.add(b.getText());
            });
            buttonList.add(b);
            inputField.setText("");
            inputField.requestFocus();
        });

        addButton.disableProperty()
            .bind(Bindings.isEmpty(inputField.textProperty()));

        HBox entryBox = new HBox();
        entryBox.getChildren().addAll(inputField, addButton);

        VBox vbox1 = new VBox();
        vbox1.getChildren().addAll(listView1, entryBox);

        VBox vbox2 = new VBox();
        vbox2.getChildren().addAll(listView2);

        VBox vbox3 = new VBox();
        vbox3.getChildren().addAll(listView3);

        HBox page = new HBox();
        page.getChildren().addAll(vbox1, vbox2, vbox3);

        Scene scene = new Scene(page);
        stage.setScene(scene);
        stage.setTitle("Todos");
        stage.show();
    }
}
