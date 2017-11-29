import javafx.application.Application;
import javafx.application.Platform;
import javafx.beans.binding.Bindings;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * Display of chess games with a GUI
 * @author zpanzarino3
 * @version 1.0.0
 */
public class ChessGui extends Application {

    /**
     * Create base GUI
     * @param stage Given stage
     */
    public void start(Stage stage) {
        ChessDb chessDb = new ChessDb();
        ObservableList<ChessGame> games =
            FXCollections.observableArrayList(chessDb.getGames());
        TableView<ChessGame> table = createTable(games);

        Button viewButton = new Button("View Game");
        viewButton.setOnAction(e -> {
                ChessGame game = table.getSelectionModel().getSelectedItem();
                viewDialog(game);
            });
        viewButton.disableProperty()
            .bind(Bindings.isNull(
                table.getSelectionModel().selectedItemProperty())
            );

        Button dismissButton = new Button("Dismiss");
        dismissButton.setOnAction(e -> Platform.exit());

        HBox buttonBox = new HBox();
        buttonBox.getChildren().addAll(viewButton, dismissButton);

        VBox vbox = new VBox();
        vbox.getChildren().addAll(table, buttonBox);
        Scene scene = new Scene(vbox);
        stage.setScene(scene);
        stage.setTitle("Chess Game GUI");
        stage.show();
    }

    /**
     * Generate table for GUI
     * @param games Games to be put in table
     * @return table
     */
    private TableView<ChessGame> createTable(ObservableList<ChessGame> games) {
        TableView<ChessGame> table = new TableView<ChessGame>();
        table.setItems(games);

        TableColumn<ChessGame, String> event =
            new TableColumn<ChessGame, String>("Event");
        event.setCellValueFactory(new PropertyValueFactory("event"));

        TableColumn<ChessGame, String> site =
            new TableColumn<ChessGame, String>("Site");
        site.setCellValueFactory(new PropertyValueFactory("site"));

        TableColumn<ChessGame, String> date =
            new TableColumn<ChessGame, String>("Date");
        date.setCellValueFactory(new PropertyValueFactory("date"));

        TableColumn<ChessGame, String> white =
            new TableColumn<ChessGame, String>("White");
        white.setCellValueFactory(new PropertyValueFactory("white"));

        TableColumn<ChessGame, String> black =
            new TableColumn<ChessGame, String>("Black");
        black.setCellValueFactory(new PropertyValueFactory("black"));

        TableColumn<ChessGame, String> result =
            new TableColumn<ChessGame, String>("Result");
        result.setCellValueFactory(new PropertyValueFactory("result"));

        table.getColumns().setAll(event, site, date, white, black, result);
        return table;
    }

    /**
     * Display game as alert
     * @param game Game to be displayed
     */
    private void viewDialog(ChessGame game) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(game.getEvent());
        alert.setHeaderText(String.format(
            "Event: %s%nSite: %s%nDate: %s%nWhite: %s%nBlack: %s%nResult: %s",
            game.getEvent(), game.getSite(), game.getDate(), game.getWhite(),
            game.getBlack(), game.getResult()
        ));
        String body = "";
        for (String move : game.getMoves()) {
            body += move + "\n";
        }
        alert.setContentText(body);
        alert.showAndWait();
    }
}
