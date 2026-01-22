# Tower Defense
## 🔎 Overview
A **Tower Defense** game developed in **Java** using **JavaFX**.<br>
The player must defend their base against successive waves of enemies by strategically placing defensive towers on the map.

This project was developed as part of a university course resource titled **"Design Patterns and JavaFX"**, conducted from **November 28, 2025 to January 14, 2026**.

It was created for **educational purposes**, with a strong focus on **software design patterns, clean architecture, object-oriented programming**, and **interactive graphical user interfaces** using JavaFX.

## 🎮 Preview
![]()

## ✨ Features
- Drag & drop
- Possibilty to implements multiple tower types with distinct behaviors
- Possibilty to implements multiple enemy types different health & speed
- Random wave system
- Resource management (gold)
- Interactive graphical interface built with JavaFX
- View loading via FXML

## 🛠️ Technologies & Tools Used
- Java 17
- JavaFX
- FXML
- Object-Oriented Programming (OOP)
- Git/GitLab/GitHub
- IDE: IntelliJ

## 🏗️​ Architecture
```mermaid
classDiagram
    direction TB

%% ======================
%%       MAP / TILES
%% ======================

    class Tile {
        +int x
        +int y
        +TileType type
    }

    class GrassTile
    class RoadTile
    class StartingTile
    class EndingTile

    Tile <|-- GrassTile
    Tile <|-- RoadTile
    Tile <|-- StartingTile
    Tile <|-- EndingTile

    class BoardModel {
        -Tile[][] tiles
        +int width
        +int height
        +Tile[][] getTiles()
        +void setTile(int x, int y, Tile tile)
    }

    class BoardView {
        -GridPane grid
        +void display(BoardModel model)
    }

    BoardModel --> Tile : contains
    BoardView --> TileView : creates


%% ======================
%%          LOADER
%% ======================

    class ILoader~T~ {
        +T load(String path)
    }

    class TextLoader {
        +BoardModel load(String path)
    }

    ILoader <|.. TextLoader
    TextLoader --> BoardModel : builds


%% ======================
%%         TILE VIEWS
%% ======================

    class TileView {
        +TileView(Tile tile)
    }

    TileView --> Tile


%% ======================
%%          ENEMY
%% ======================

    class Enemy {
        #double x
        #double y
        #double speed
        #double hp
        #boolean alive
        #List~Tile~ path
        #int currentIndex
        +void update(double dt)
        +void damage(double amount)
        +double getX()
        +double getY()
        +boolean isAlive()
        <<abstract>>
    }

    class BasicEnemy {
        +BasicEnemy(List~Tile~ path)
    }

    Enemy <|-- BasicEnemy


%% ======================
%%           TOWERS
%% ======================

    class Tower {
        #double x
        #double y
        #double range
        #double damage
        #double cooldown
        #double timer
        #TargetingStrategy targetingStrategy
        +void update(BoardModel board, double dt)
        <<abstract>>
    }

    class TowerAOE
    class TowerSingleTarget

    Tower <|-- TowerAOE
    Tower <|-- TowerSingleTarget

    class TowerFactory {
        +static Tower create(String type, double x, double y)
    }

    TowerFactory --> Tower : creates


%% ======================
%%   TARGETING STRATEGY
%% ======================

    class TargetingStrategy {
        +List~Enemy~ selectTargets(BoardModel board, double x, double y, double range)
        <<interface>>
    }

    class AoeTargetingStrategy
    class SingleTargetingStrategy

    TargetingStrategy <|.. AoeTargetingStrategy
    TargetingStrategy <|.. SingleTargetingStrategy

    Tower --> TargetingStrategy : uses
    TargetingStrategy --> Enemy : selects


%% ======================
%%        LAUNCHER
%% ======================

    class Launcher {
        +void start(Stage)
    }

    Launcher --> BoardView : loads FXML
    Launcher --> BoardModel : loads map
```

## 🚀 Installation & Run
> [!IMPORTANT]
> #### Requirements
> - Java 17 or newer
> - JavaFX properly configured
> - Recommended IDE: IntelliJ IDEA or Eclipse

### Run the project
> [!NOTE]
> Fork the project

```
git clone https://github.com/your-username/TowerDefense.git
cd TowerDefense
```

## 👤 Author
<img src="https://avatars.githubusercontent.com/u/157543647?s=400&u=1a9e5f04f782b65bb81c5f4b471495745ad92c25&v=4" align=center width=30> [**Gabriel COUDEL-KOUMBA (Phantom-Whisper)**](https://github.com/Phantom-Whisper)