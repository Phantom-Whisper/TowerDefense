package launch;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import model.entities.board.BoardModel;
import model.entities.enemy.Goblin;
import model.utils.controller.GameController;
import model.utils.loader.ILoader;
import model.utils.loader.TextLoader;
import model.utils.thread.Ticker;
import views.Board;
import views.GameWindowController;

public class Launcher extends Application {
    /*
    @Override
    public void start(Stage primaryStage) throws Exception {
        ILoader loader = new TextLoader();
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/Board.fxml"));
        // Stage config
        primaryStage.setScene(new Scene(fxmlLoader.load()));
        primaryStage.setTitle("Tower Defense");
        primaryStage.setResizable(false);

        Board board = fxmlLoader.getController();
        BoardModel model = (BoardModel)loader.load("rsrc/maps/map1.txt");
        Ticker ticker = new Ticker(model);
        ticker.start();
        model.addEnemy(new Goblin(5,0,0));
        board.display(model);
        primaryStage.show();

    } */

    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/GameWindow.fxml"));

        Scene scene = new Scene(loader.load());
        stage.setScene(scene);
        stage.setTitle("Tower Defense");
        stage.setResizable(false);
        //stage.setAlwaysOnTop(true);

        ILoader<BoardModel> mapLoader = new TextLoader();
        BoardModel model = mapLoader.load("rsrc/maps/map1.txt");

        GameWindowController view = loader.getController();

        new GameController(model, view);

        stage.show();
    }
}
