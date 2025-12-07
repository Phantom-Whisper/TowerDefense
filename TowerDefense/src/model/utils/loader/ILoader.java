package model.utils.loader;

import java.io.IOException;
import java.util.List;

public interface ILoader<T> {
    public T Load(String path) throws IOException;
}
