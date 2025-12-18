package model.utils.thread;

import javafx.application.Platform;
import javafx.scene.shape.Circle;
import model.entities.board.BoardModel;
import model.entities.enemy.Enemy;
import model.entities.enemy.Goblin;

public class Ticker extends Thread {
    private int ticks = 0;
    private BoardModel board;

    private final int TICKS_VISIBLE = 10; // nombre de ticks où le goblin reste visible
    private final int FPS = 60;            // 60 ticks par seconde
    private final long WAIT_BETWEEN = 5000;

    public Ticker(BoardModel board){
        this.board = board;
    }

    @Override
    public void run() {
        try {
            while (!interrupted()) {

                // 1️⃣ Créer un goblin
                Goblin goblin = new Goblin(0, 0);

                // 2️⃣ Ajouter le goblin sur le Board (UI thread)
                Platform.runLater(() -> board.addEnemy(goblin));

                // 3️⃣ Laisser le goblin visible pendant 10 ticks
                for (int i = 0; i < TICKS_VISIBLE; i++) {
                    Thread.sleep(1000 / FPS);
                }

                // 4️⃣ Retirer le goblin (UI thread)
                Platform.runLater(() -> board.removeEnemy(goblin));

                // 5️⃣ Attendre 5 secondes avant le prochain goblin
                Thread.sleep(WAIT_BETWEEN);
            }
        } catch (InterruptedException e) {
            // Arrêt du thread propre
        }
    }

    /*
    @Override
    public void run(){
        while(!interrupted()){
            ticks += 1%60;
            Platform.runLater(() -> {
                board.addEnemy(new Goblin(0, 0) {
                });
            });
            try{
                sleep(1000/60);
            } catch (InterruptedException e) {
                break;
            }
        }
    }
    */
}
