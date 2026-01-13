package views;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.Dragboard;
import javafx.scene.input.TransferMode;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import model.entities.board.BoardModel;
import model.entities.enemy.Enemy;
import model.entities.projectile.Projectile;
import model.entities.tile.Tile;
import model.entities.tower.Tower;
import model.utils.logic.ProjectileManager;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Board {
    @FXML private StackPane board;
    @FXML private GridPane grid;
    @FXML private Pane entityPane;
    private ProjectileManager projectileManager;

    private BoardModel model;

    public void setModel(BoardModel model) {
        this.model = model;

        entityPane.setStyle("-fx-background-color: transparent;");
        entityPane.setPickOnBounds(false);

        setupDragAndDrop();
    }

    public void setProjectileManager(ProjectileManager pm) {
        this.projectileManager = pm;
    }

    /**
     * Configure la réception du Drag & Drop sur le plateau
     */
    private void setupDragAndDrop() {
        entityPane.setOnDragOver(event -> {
            if (event.getDragboard().hasString()) {
                event.acceptTransferModes(TransferMode.COPY);
            }
            event.consume();
        });

        entityPane.setOnDragDropped(event -> {
            Dragboard db = event.getDragboard();
            boolean success = false;

            if (db.hasString()) {
                int col = (int) (event.getX() / 64);
                int row = (int) (event.getY() / 64);

                if (model.isPlacementValid(col, row)) {
                    try {
                        spawnTower(db.getString(), col, row);
                        success = true;
                    } catch (Exception e) {
                        System.err.println("Erreur au spawn : " + e.getMessage());
                    }
                } else {
                    return;
                }
            }
            event.setDropCompleted(success);
            event.consume();
        });
    }


    public void display(BoardModel model) {
        this.model = model;
        grid.getChildren().clear();
        entityPane.getChildren().clear();

        for (int x = 0; x < model.getWidth(); x++) {
            for (int y = 0; y < model.getHeight(); y++) {
                Tile tile = model.getTile(x, y);
                if (tile != null) {
                    TileView tileView = new TileView(tile);
                    grid.add(tileView, x, y);
                }
            }
        }

        if (model.getCastle() != null) {
            double cellSize = 64.0;
            CastleView castleView = new CastleView(model.getCastle(), cellSize);
            entityPane.getChildren().add(castleView);
        }

        for (Tower tower : model.getTowers()) {
            drawTower(tower);
        }
    }

    private void drawTower(Tower tower) {
        ImageView towerView = new ImageView(ImageResource.getImage(tower.getSpritePath()));
        towerView.setFitWidth(64);
        towerView.setFitHeight(64);
        towerView.setLayoutX(tower.getX() * 64);
        towerView.setLayoutY(tower.getY() * 64);
        towerView.setMouseTransparent(true);
        entityPane.getChildren().add(towerView);
    }

    /**
     * Appelée par ton Ticker 60 fois par seconde pour la fluidité
     */
    public void updateView() {
        if (model == null || projectileManager == null) {
            return;
        }
        List<Enemy> enemies = new ArrayList<>(model.getEnemies());
        List<Projectile> projectiles = new ArrayList<>(projectileManager.getProjectiles());

        Platform.runLater(() -> {
            entityPane.getChildren().removeIf(node -> node instanceof EnemyView || node instanceof ProjectileView);

            for (Enemy e : enemies) {
                EnemyView ev = new EnemyView(e);
                ev.setLayoutX(e.getX() * 64);
                ev.setLayoutY(e.getY() * 64);
                entityPane.getChildren().add(ev);
            }

            for (Projectile p : projectiles) {
                ProjectileView pv = new ProjectileView(p);
                entityPane.getChildren().add(pv);
            }
        });
    }

    private void spawnTower(String towerClassName, int col, int row) {
        model.createTower(towerClassName, col, row);

        List<Tower> towers = model.getTowers();
        Tower lastTower = towers.getLast();

        ImageView towerView = new ImageView(ImageResource.getImage(lastTower.getSpritePath()));
        towerView.setFitWidth(64);
        towerView.setFitHeight(64);
        towerView.setLayoutX(col * 64);
        towerView.setLayoutY(row * 64);
        towerView.setMouseTransparent(true);

        entityPane.getChildren().add(towerView);
    }
}