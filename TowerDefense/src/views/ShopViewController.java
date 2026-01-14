package views;

import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.scene.SnapshotParameters;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.ClipboardContent;
import javafx.scene.input.Dragboard;
import javafx.scene.input.TransferMode;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import model.entities.tower.FixedTower;
import model.entities.tower.RangingTower;
import model.entities.tower.Tower;
import model.utils.catalog.TowerCatalog;

import java.util.Objects;

public class ShopViewController {
    @FXML
    private ListView<Tower> towerListView;

    public void initialize() {
        towerListView.getItems().addAll(TowerCatalog.getAvailableTowers());

        towerListView.setCellFactory(param -> new ListCell<>() {
            @Override
            protected void updateItem(Tower tower, boolean empty) {
                super.updateItem(tower, empty);

                if (empty || tower == null) {
                    setText(null);
                    setGraphic(null);
                } else {
                    ImageView iv = new ImageView(new Image(Objects.requireNonNull(getClass().getResourceAsStream(tower.getSpritePath()))));
                    iv.setFitHeight(40);
                    iv.setFitWidth(40);

                    Label nameLabel = new Label(tower.getName());
                    nameLabel.setStyle("-fx-font-weight: bold; -fx-text-fill: white;");

                    Label damageLabel = new Label("(" + (int)tower.getDamage() + " dmg)");
                    damageLabel.setStyle("-fx-text-fill: #e74c3c; -fx-font-weight: bold; -fx-font-size: 11px;");

                    HBox nameAndDamage = new HBox(nameLabel, damageLabel);
                    nameAndDamage.setSpacing(5);
                    nameAndDamage.setAlignment(javafx.geometry.Pos.BASELINE_LEFT);

                    Label descLabel = new Label(tower.getDescription());
                    descLabel.setStyle("-fx-text-fill: lightgray; -fx-font-size: 11px;");
                    descLabel.setWrapText(true);
                    descLabel.setMaxWidth(160);

                    Label costLabel = new Label(tower.getCost() + "$");
                    costLabel.setStyle("-fx-text-fill: gold; -fx-font-weight: bold; -fx-font-size: 14px;");

                    VBox textContainer = new VBox(nameAndDamage, descLabel);
                    textContainer.setSpacing(2);

                    HBox mainBox = new HBox(iv, textContainer, costLabel);
                    mainBox.setSpacing(5);
                    mainBox.setPadding(new Insets(5));
                    mainBox.setAlignment(javafx.geometry.Pos.CENTER_LEFT);

                    HBox.setHgrow(textContainer, Priority.ALWAYS);
                    setGraphic(mainBox);

                    setOnDragDetected(event -> {
                        Dragboard db = startDragAndDrop(TransferMode.COPY);
                        ClipboardContent content = new ClipboardContent();
                        content.putString(tower.getClass().getSimpleName());
                        db.setContent(content);
                        SnapshotParameters sp = new SnapshotParameters();
                        sp.setFill(Color.TRANSPARENT);
                        db.setDragView(iv.snapshot(sp, null));

                        event.consume();
                    });
                }
            }
        });
    }
}