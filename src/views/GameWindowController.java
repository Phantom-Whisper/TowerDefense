package views;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import model.entities.board.BoardModel;
import model.utils.display.Spawner;
import model.utils.loader.ILoader;
import model.utils.loader.TextLoader;
import model.utils.logic.*;
import model.utils.thread.Ticker;

import java.io.IOException;

public class GameWindowController {
    @FXML
    private Board boardViewController;
    @FXML
    private InfoViewController infoViewController;
    @FXML
    private VBox gameOverOverlay;
    @FXML
    private Label gameOverTimeLabel;

    private BoardModel model;
    private Ticker ticker;

    public void initGame() throws IOException {
        ILoader<BoardModel> mapLoader = new TextLoader();
        this.model = mapLoader.load("rsrc/maps/map1.txt");

        boardViewController.setModel(model);
        boardViewController.display(model);

        ticker = new Ticker();

        CollisionManager collisionManager = new CollisionManager(model, ticker, this::triggerGameOver);

        ProjectileManager projectileManager = new ProjectileManager();
        boardViewController.setProjectileManager(projectileManager);
        TimeManager timeManager = new TimeManager(model, infoViewController);

        ticker.attach(timeManager);

        ticker.attach(new Spawner(boardViewController, model));
        ticker.attach(new MovementManager(model));
        ticker.attach(collisionManager);
        ticker.attach(projectileManager);
        ticker.attach(new AttackManager(model, projectileManager));

        Thread thread = new Thread(ticker);
        thread.setDaemon(true);
        thread.start();
    }

    private void triggerGameOver() {
        String finalTime = model.getFormattedTime();

        Platform.runLater(() -> {
            gameOverTimeLabel.setText("Time survived : " + finalTime);
            gameOverOverlay.setVisible(true);
        });
    }

    @FXML
    private void restartGame() throws IOException {
        if (ticker != null) ticker.stop();
        gameOverOverlay.setVisible(false);
        initGame();
    }
}
