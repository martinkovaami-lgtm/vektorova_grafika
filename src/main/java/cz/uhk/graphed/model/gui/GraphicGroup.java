package cz.uhk.graphed.model.gui;

import cz.uhk.graphed.model.AbstractGraphicObject;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class GraphicGroup extends AbstractGraphicObject {

    // Doporučuji nastavit jako private pro lepší zapouzdření
    private List<AbstractGraphicObject> items = new ArrayList<>();

    public GraphicGroup() {
        super(new Point(0, 0), Color.BLACK);
    }

    @Override
    public void draw(Graphics g) {
        // Skupina vykreslí všechny své potomky
        for (AbstractGraphicObject item : items) {
            item.draw(g);
        }
    }

    @Override
    public boolean contains(Point p) {
        // Skupina obsahuje bod, pokud ho obsahuje alespoň jeden z jejích prvků
        for (AbstractGraphicObject item : items) {
            if (item.contains(p)) {
                return true;
            }
        }
        return false;
    }

    public void move(int dx, int dy) {
        super.move(dx, dy);
        items.forEach(item -> item.move(dx, dy));
    }


    public void addItem(AbstractGraphicObject item) {
        items.add(item);
    }
    public void removeItem(AbstractGraphicObject item) {
        items.remove(item);
    }
    public List<AbstractGraphicObject> getItems() {
        return items;
    }
}