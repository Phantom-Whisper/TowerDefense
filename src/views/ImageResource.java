package views;

import javafx.scene.image.Image;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class ImageResource {
    private static final Map<String, Image> cache = new HashMap<>();

    public static Image getImage(String path) {
        if (!cache.containsKey(path)) {
            cache.put(path, new Image(Objects.requireNonNull(ImageResource.class.getResourceAsStream(path))));
        }
        return cache.get(path);
    }
}