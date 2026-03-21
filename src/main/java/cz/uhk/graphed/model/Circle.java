package cz.uhk.graphed.model;

import java.awt.*;

public class Circle extends AbstractGraphicObject {

    protected int r; // poloměr kružnice

    public Circle(Point position, Color color, int r) {
        super(position, color);
        this.r = r;
    }

    @Override
    public boolean contains(Point p) {
        return false;
    }

    @Override
    public void draw(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        g2.setColor(color);
        // Kreslíme ovál. Šířka i výška je dvojnásobek poloměru (průměr).
        g2.drawOval(position.x, position.y, 2 * r, 2 * r);
    }
}