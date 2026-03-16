package cz.uhk.graphed.model;

import java.awt.*;

public class Square extends AbstractGraphicObject{

    protected int a;

    public Square(Point position, Color color, int a) {
        super(position, color);
        // public Square(); <-- TENTO ŘÁDEK BYL SMAZÁN
        this.a = a; // Přidáno uložení délky strany
    }

    @Override
    public boolean contains(Point p) {
        return false;
    }

    @Override // Je dobré používat anotaci Override
    public void draw(Graphics g){
        Graphics2D g2 = (Graphics2D) g;
        g2.setColor(color);
        g2.drawRect(position.x, position.y, a, a);
    }
}