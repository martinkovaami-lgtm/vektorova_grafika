package cz.uhk.graphed.model;

import java.awt.*;

public class Triangle extends AbstractGraphicObject {

    protected int a; // délka strany

    public Triangle(Point position, Color color, int a) {
        super(position, color);
        this.a = a;
    }

    @Override
    public boolean contains(Point p) {
        return false;
    }

    @Override
    public void draw(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        g2.setColor(color);

        // Výpočet výšky rovnostranného trojúhelníku (v = a * √3 / 2)
        int v = (int) (a * Math.sqrt(3) / 2.0);

        // Určení bodů trojúhelníku (pozice je chápána jako horní vrchol)
        int[] xPoints = {
                position.x,               // horní vrchol (střed)
                position.x - (a / 2),     // levý dolní vrchol
                position.x + (a / 2)      // pravý dolní vrchol
        };

        int[] yPoints = {
                position.y,               // horní vrchol
                position.y + v,           // levý dolní vrchol
                position.y + v            // pravý dolní vrchol
        };

        // Vykreslení mnohoúhelníku (3 vrcholy)
        g2.drawPolygon(xPoints, yPoints, 3);
    }
}