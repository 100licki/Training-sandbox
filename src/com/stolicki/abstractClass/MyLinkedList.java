package com.stolicki.abstractClass;

public class MyLinkedList implements NodeList {
    private ListItem root;

    public MyLinkedList(ListItem root) {
        this.root = root;
    }

    @Override
    public ListItem getRoot() {
        return root;
    }

    @Override
    public boolean addItem(ListItem listItem) {
        if (this.root == null) {
            this.root = listItem;
            return true;
        }
        ListItem currentItem = this.root;
        while (currentItem != null) {
            int comparison = (currentItem.compareTo(listItem));
            if (comparison < 0) {
                if (currentItem.next() != null) {
                    currentItem = currentItem.next();
                } else {
                    currentItem.setNext(listItem);
                    listItem.setPrevious(currentItem);
                    return true;
                }
            } else if (comparison > 0) {
                if (currentItem.previous() != null) {
                    currentItem.previous().setNext(listItem);
                    listItem.setPrevious(currentItem.previous());
                    listItem.setNext(currentItem);
                    currentItem.setPrevious(listItem);
                } else {
                    listItem.setNext(this.root);
                    this.root.setPrevious(listItem);
                    this.root = listItem;
                }
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean removeItem(ListItem listItem) {
        if (this.root == null) {
            return false;
        }
        ListItem currentItem = this.root;
        while (currentItem != null) {
            int comparison = currentItem.compareTo(listItem);
            if (comparison == 0) {
                currentItem.previous().setNext(currentItem.next());
                currentItem.next().setPrevious(currentItem.previous());
                return true;
            } else if (comparison > 0) {
                currentItem = currentItem.previous();
            } else {
                currentItem = currentItem.next();
            }
        }
        return false;
    }

    @Override
    public void traverse(ListItem root) {
        if (root == null) {
            System.out.println("The list is empty");
        } else {
            while (root != null) {
                System.out.println((String) root.getValue());
                root = root.next();
            }
        }
    }
}
