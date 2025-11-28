package model.utils.loader;

import java.io.IOException;
import java.util.List;

public interface ILoader<T> {
    public void Load(String path) throws IOException;
}
