package cz.uhk.graphed.model;

import java.awt.*;

public class Rectangle extends AbstractGraphicObject{

    protected int a; // Doporučuji přidat i "int b" a upravit konstruktor i vykreslování

    protected int b;

    public Rectangle(Point position, Color color, int a, int b) {
        super(position, color);
        // public Rectangle(); <-- TENTO ŘÁDEK BYL SMAZÁN
        this.a = a;
        this.b=b;
    }

    @Override
    public boolean contains(Point p) {
        return false;
    }

    @Override
    public void draw(Graphics g){
        Graphics2D g2 = (Graphics2D) g;
        g2.setColor(color);
        g2.drawRect(position.x, position.y, a, b); // Pro obdélník by zde mělo být "a, b"
    }
}