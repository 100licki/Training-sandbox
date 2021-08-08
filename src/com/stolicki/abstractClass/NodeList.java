package com.stolicki.abstractClass;

public interface NodeList {
    ListItem getRoot();

    boolean addItem(ListItem listItem);

    boolean removeItem(ListItem listItem);

    void traverse(ListItem root);
}
