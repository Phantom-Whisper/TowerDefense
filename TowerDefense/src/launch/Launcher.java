package launch;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import model.entities.board.BoardModel;
import model.entities.enemy.Goblin;
import model.utils.controller.GameController;
import model.utils.display.Spawner;
import model.utils.loader.ILoader;
import model.utils.loader.TextLoader;
import model.utils.logic.AttackManager;
import model.utils.logic.CollisionManager;
import model.utils.logic.MovementManager;
import model.utils.logic.ProjectileManager;
import model.utils.thread.Ticker;
import views.Board;
import views.GameWindowController;

public class Launcher extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/GameWindow.fxml"));

        Scene scene = new Scene(loader.load());
        stage.setScene(scene);
        stage.setTitle("Tower Defense");
        stage.setResizable(false);
        //stage.setAlwaysOnTop(true);

        GameWindowController controller = loader.getController();
        controller.initGame();

        stage.show();
    }
}