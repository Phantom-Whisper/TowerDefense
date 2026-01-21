package model.utils.loader;

import java.io.IOException;

public interface ILoader<T> {
    T load(String path) throws IOException;
}
