package cz.uhk.graphed.model;

import cz.uhk.graphed.model.gui.EditorFrame;

public class Main {
    public static void main(String[] args) {
        EditorFrame frame = new EditorFrame();

        frame.setDefaultCloseOperation(EditorFrame.EXIT_ON_CLOSE);

        frame.setVisible(true);
    }
}