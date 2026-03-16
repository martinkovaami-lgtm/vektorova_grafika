package cz.uhk.graphed.model.gui;

import cz.uhk.graphed.model.AbstractGraphicObject;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JPanel;

public class Canwas extends javax.swing.JPanel {
    private List<AbstractGraphicObject> graphicsObjects=new ArrayList<AbstractGraphicObject>();

    public Canwas() {
        setPreferredSize(new Dimension(800,600));
    }
    public void add(AbstractGraphicObject object) {
        graphicsObjects.add(object);
    }

    public void paint(Graphics g) {
        super.paint(g);
        for (var o : graphicsObjects) {
            o.draw(g);
        }
    }
}
