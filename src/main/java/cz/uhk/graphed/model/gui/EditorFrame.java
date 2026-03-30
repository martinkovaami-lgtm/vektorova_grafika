package cz.uhk.graphed.model.gui;

import cz.uhk.graphed.model.Circle;
import cz.uhk.graphed.model.Rectangle;
import cz.uhk.graphed.model.Square;
import cz.uhk.graphed.model.Triangle;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class EditorFrame extends JFrame {
    private Canwas canwas= new Canwas();

    public EditorFrame() throws HeadlessException {
        super("FIM Graphic Editor");

        add(canwas, BorderLayout.CENTER);

        private JToolBar createToolbar(){
            JToolBar tb = new JToolBar(JToolBar.HORIZONTAL);
            Action actSquare = new AbstractAction(){
                public void actionPerformed(ActionEvent e) {
                    canwas.add(new Square(new Point(0,0), Color.BLACK, 50));
                    repaint();
                }
            }
        };

        Action actSquare = new AbstractAction(){
            public void actionPerformed(ActionEvent e) {
                canwas.add(new Square(new Point(0,0), Color.BLACK, 50));
            }
        };
        actSquare.putValue(Action.SHORT_DESCRIPTION, "Namalujte Čtverec");


        JButton btCircle = new JButton("Circle");
        btCircle.addActionListener(e->canwas.add(new Circle(new Point(0,0), Color.BLACK, 50)));
        add(createToolbar, BorderLayout.NORTH);
        tb.add(actSquare);
        return(Circle);
        initSampleData();

        pack();
    }

    private void initSampleData() {
        canwas.add(new Square(new Point(100, 100), Color.BLACK, 50));
        canwas.add(new Square(new Point(150, 100), Color.BLACK, 50));
        canwas.add(new Square(new Point(100, 150), Color.BLACK, 50));

        canwas.add(new Rectangle(new Point(250, 150), Color.BLACK, 60, 40));

        canwas.add(new Circle(new Point(200,200),Color.BLACK, 25));

        canwas.add(new Triangle(new Point(300,300), Color.BLACK, 50));

        GraphicGroup group = new GraphicGroup();
        canwas.add(group);
        group.addItem(new Circle(new Point(10,20), Color.BLACK, 50));

    }
}
