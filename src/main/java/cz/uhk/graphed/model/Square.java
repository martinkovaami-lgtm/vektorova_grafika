package cz.uhk.graphed.model;

import java.awt.*;

public class Square extends AbstractGraphicObject{

    protected int a;
    public Square(Point position, Color color, int a) {
        super(position, color);
        public Square();
        this.position = position;
        this.color = color;
    }
    @Override
    public boolean contains(Point p) {
        return false;
    }

    public void draw(Graphics g){
        Graphics2D g2 = (Graphics2D) g;
        g2.setColor(color);
        g2.drawRect(position.x, position.y, a, a);
    }
}
