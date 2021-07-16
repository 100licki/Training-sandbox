package com.stolicki.interfaces;

import java.util.List;

public interface Saveable {
    List<String> write();

    void read(List<String> list);
}
