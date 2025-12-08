package launch;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import model.entities.BoardModel;
import model.utils.loader.ILoader;
import model.utils.loader.TextLoader;
import views.Board;

public class Launcher extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/Board.fxml"));
        primaryStage.setScene(new Scene(fxmlLoader.load()));
        Board board = fxmlLoader.getController();
        TextLoader loader = new TextLoader();
        BoardModel model = loader.Load("rsrc/maps/map1.txt");
        board.display(model);
        primaryStage.show();
    }
}
