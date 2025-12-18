package model.utils.controller;

import model.entities.board.BoardModel;
import model.entities.enemy.Goblin;
import model.utils.thread.Ticker;
import views.GameWindowController;

public class GameController {

    private final BoardModel model;
    private final GameWindowController view;
    private final Ticker ticker;

    public GameController(BoardModel model, GameWindowController view) {
        this.model = model;
        this.view = view;

        view.getBoardView().display(model);

        ticker = new Ticker(model);
        ticker.start();

        model.addEnemy(new Goblin(0, 0));
    }
}
