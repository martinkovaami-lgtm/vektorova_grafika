package cz.uhk.graphed.model;

import java.awt.*;

public abstract class AbstractGraphicObject {
    protected Point position;
    protected Color color;

    public AbstractGraphicObject(Point position, Color color) {
        this.position = position;
        this.color = color;
    }

    public Point getPosition() {
        return position;
    }

    public void setPosition(Point position) {
        this.position = position;
    }

    public void setPosition(int x, int y) {
        this.position = new Point(x, y);

    }
    public Color getColor() {
        return color;
    }
    public void setColor(Color color) {
        this.color = color;
    }
    public void setColor(int r, int g, int b) {
        this.color = new Color(r, g, b);
    }

    public abstract void draw(Graphics g);
    public abstract boolean contains(Point p);
    public boolean contains(int x, int y) {
        return contains(new Point(x, y));
    }
    public void  draw(Graphics2D g) {
        draw(g);
    }

    public void move (int dx, int dy) {
        position = new Point(dx, dy);
    }
}
