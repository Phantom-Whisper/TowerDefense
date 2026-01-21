package model.utils.catalog;

import model.entities.tower.RangingTower;
import model.entities.tower.Tower;

import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;

public class TowerCatalog {
    private static final Map<String, Tower> towerCatalog = new LinkedHashMap<>();

    static {
        //register(new FixedTower(0,0,15, 0.5, 80));
        register(new RangingTower(0,0,15,1,80));
    }

    private static void register(Tower tower)
    {
        towerCatalog.put(tower.getClass().getSimpleName(), tower);
    }

    public static Collection<Tower> getAvailableTowers() {
        return towerCatalog.values();
    }

    public static Tower getTowerTemplate(String id) {
        return towerCatalog.get(id);
    }
}
