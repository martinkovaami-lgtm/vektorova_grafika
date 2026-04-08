package cz.uhk.graphed.model.gui;

import cz.uhk.graphed.model.AbstractGraphicObject;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JPanel;

public class Canwas extends javax.swing.JPanel {
    private List<AbstractGraphicObject> graphicsObjects=new ArrayList<AbstractGraphicObject>();

    private AbstractGraphicObject selectedObject = null; // Právě držený objekt
    private int dx;
    private int dy;

    public Canwas() {
        setBackground(Color.white);
        setPreferredSize(new Dimension(800,600));

        addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {

                AbstractGraphicObject o = findObjectContaining(e.getPoint());

                if (o != null) {
                    selectedObject = o;

                    dx = e.getX() - o.getPosition().x;
                    dy = e.getY() - o.getPosition().y;

                } else {
                    selectedObject = null;
                }
            }
        });

        addMouseMotionListener(new MouseAdapter() {
            @Override
            public void mouseDragged(MouseEvent e) {
                if (selectedObject != null) {
                    var deltaX = e.getX() - selectedObject.getPosition().x - dx;
                    var deltaY = e.getY() - selectedObject.getPosition().y - dy;
                    selectedObject.move(deltaX, deltaY);
                    repaint();
                }
            }
        });

        addMouseMotionListener(new MouseAdapter() {
            @Override
            public void mouseDragged(MouseEvent e) {
                AbstractGraphicObject o = FindObjectContaining(e.getPoint());
                if (o != null) {
                    o.setPosition(e.getX()-dx, e.getY()-dy);
                    repaint();
                }
            }

            private AbstractGraphicObject FindObjectContaining(Point point) {
                AbstractGraphicObject result=null;
                for (var object : graphicsObjects) {
                    if (object.contains(point)) {
                        result= object;
                    }
                }
                return result;
            }
        });

    }

    private AbstractGraphicObject findObjectContaining(Point p) {
        for (int i = graphicsObjects.size() - 1; i >= 0; i--) {
            AbstractGraphicObject obj = graphicsObjects.get(i);
            if (obj.contains(p)) {
                return obj;
            }
        }
        return null;
    }

    public void add(AbstractGraphicObject object) {
        graphicsObjects.add(object);
        repaint();
    }

    public void paint(Graphics g) {
        super.paint(g);
        for (var o : graphicsObjects) {
            o.draw(g);
        }
    }
}
