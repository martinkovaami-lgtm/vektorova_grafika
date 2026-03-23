package cz.uhk.graphed.model;

import java.awt.*;

public class Triangle extends AbstractGraphicObject {

    protected int a;

    public Triangle(Point position, Color color, int a) {
        super(position, color);
        this.a = a;
    }

    @Override
    public boolean contains(Point p) {
        int dx = (int) Math.round((p.y - position.y) * Math.tan(Math.PI / 6)); //vzdálenost od středu do strany pro výšku dy
        int dy = p.y - position.y; // y-ová vzdálenost kliknutí od špičky trojúhelníku
        return (dy >= 0 && dy <= a * Math.sqrt(3) / 2.0) && (p.x >= position.x - dx && p.x <= position.x + dx);    }

    @Override
    public void draw(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setColor(color);

        int v = (int) (a * Math.sqrt(3) / 2.0);

        int[] xPoints = {
                position.x,
                position.x - (a / 2),
                position.x + (a / 2)
        };

        int[] yPoints = {
                position.y,
                position.y + v,
                position.y + v
        };

        g2.drawPolygon(xPoints, yPoints, 3);
    }
}