package DP;

import java.util.ArrayList;
import java.util.List;

abstract class component1 {
    protected String name;
    protected int size;

    public component1(String name) {
        this.name = name;
    }

    abstract public void showDetails();

    abstract public int getSize();
}

class file extends component1 {
    public file(String name, int size) {
        super(name);
        this.size = size;
    }

    public void showDetails() {
        System.out.println("Name : " + name + "    Size : " + size);
    }

    public int getSize() {
        return size;
    }
}

class folder extends component1 {
    List<component1> ls = new ArrayList<component1>();

    public folder(String name) {
        super(name);
    }

    public void addcomponent1(component1 c1) {
        ls.add(c1);
    }

    public void removecomponent1(component1 c1) {
        ls.remove(c1);
    }

    public void showDetails() {
        System.out.println("\nFolder : " + name + "\nFiles :::::: ");
        for (component1 c : ls) {
            c.showDetails();
        }
        System.out.println(" ");
    }

    public int getSize() {
        int total = 0;
        for (component1 c : ls) {
            total = total + c.getSize();
        }
        return total;
    }
}

public class Composite_File_prog {
    public static void main(String[] args) {
        component1 c1 = new file("index.html", 200);
        component1 c2 = new file("page1.html", 120);
        component1 c3 = new file("page2.html", 400);
        component1 c4 = new file("page3.html", 70);
        component1 c5 = new file("page4.html", 100);

        folder c6 = new folder("First");
        folder c7 = new folder("Second");
        folder c8 = new folder("Third");

        c6.addcomponent1(c1);
        c6.addcomponent1(c2);
        c7.addcomponent1(c3);
        c8.addcomponent1(c4);
        c8.addcomponent1(c5);

        c1.showDetails();
        c2.showDetails();
        c3.showDetails();
        c4.showDetails();
        c5.showDetails();

        c6.showDetails();

        System.out.println("Size of 'First' Folder : " + c6.getSize());
        System.out.println("Size of 'Second' Folder : " + c7.getSize());
        System.out.println("Size of 'Third' Folder : " + c8.getSize());
    }
}