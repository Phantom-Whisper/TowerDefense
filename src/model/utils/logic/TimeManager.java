package model.utils.logic;

import model.entities.board.BoardModel;
import model.utils.observer.Observer;
import views.InfoViewController;

public class TimeManager extends Observer {
    private final BoardModel model;
    private final InfoViewController infoView;

    public TimeManager(BoardModel model, InfoViewController infoView) {
        this.model = model;
        this.infoView = infoView;
    }

    @Override
    public void update() {
        model.updateTimer();

        infoView.updateInfo(model);
    }
}
