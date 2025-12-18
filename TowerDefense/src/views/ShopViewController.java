package views;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.util.Callback;
import model.entities.tower.Tower;

import java.util.List;

public class ShopViewController {
    @FXML
    private ListView<Tower> towerListView;

    public void initialize() {
        // Exemple : ajouter des tours
        List<Tower> towers = List.of(
                new model.entities.tower.FixedTower(0, 0, 10, 1, 50),
                new model.entities.tower.RangingTower(0, 0, 5, 2, 80)
        );

        towerListView.getItems().addAll(towers);

        // Cell factory personnalisé
        towerListView.setCellFactory(new Callback<ListView<Tower>, ListCell<Tower>>() {
            @Override
            public ListCell<Tower> call(ListView<Tower> param) {
                return new ListCell<>() {
                    @Override
                    protected void updateItem(Tower tower, boolean empty) {
                        super.updateItem(tower, empty);
                        if (empty || tower == null) {
                            setText(null);
                            setGraphic(null);
                        } else {
                            // Nom en gras
                            Label nameLabel = new Label(tower.getName());
                            nameLabel.setStyle("-fx-font-weight: bold; -fx-text-fill: white;");

                            // Description
                            Label descLabel = new Label(tower.getDescription());
                            descLabel.setStyle("-fx-text-fill: lightgray;");
                            descLabel.setWrapText(true); // <-- active le retour à la ligne
                            descLabel.setMaxWidth(200);
                            // Coût
                            Label costLabel = new Label("$" + tower.getCost());
                            costLabel.setStyle("-fx-text-fill: yellow; -fx-font-weight: bold;");

                            VBox vbox = new VBox(nameLabel, descLabel);
                            vbox.setSpacing(2);
                            HBox hbox = new HBox(vbox, costLabel);
                            HBox.setHgrow(vbox, Priority.ALWAYS);
                            hbox.setSpacing(10);
                            hbox.setPadding(new Insets(5));

                            setGraphic(hbox);
                        }
                    }
                };
            }
        });
    }
}
