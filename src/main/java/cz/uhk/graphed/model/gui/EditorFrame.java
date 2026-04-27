package cz.uhk.graphed.model.gui;

import cz.uhk.graphed.model.Circle;
import cz.uhk.graphed.model.Rectangle;
import cz.uhk.graphed.model.Square;
import cz.uhk.graphed.model.Triangle;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.Random;

public class EditorFrame extends JFrame {
    private Canwas canwas = new Canwas();
    private Random random = new Random();

    private Color RandomColor(){
        int r = random.nextInt(250);
        int g = random.nextInt(250);
        int b = random.nextInt(250);
        return new Color(r,g,b);
    }

    public EditorFrame() throws HeadlessException {
        super("FIM Graphic Editor");

        // Přidání plátna a nástrojové lišty
        add(canwas, BorderLayout.CENTER);
        add(createToolbar(), BorderLayout.NORTH);

        // Volání inicializačních metod
        initSampleData();

        pack();
    }

    private JToolBar createToolbar() {
        JToolBar tb = new JToolBar(JToolBar.HORIZONTAL);

        // Tlačítko pro vykreslení čtverce
        JButton btSquare = new JButton("Square");
        btSquare.setToolTipText("Namalujte Čtverec");
        btSquare.addActionListener(e -> canwas.add(new Square(new Point(random.nextInt(800), random.nextInt(600)), RandomColor(), 10 + random.nextInt(80))));
        tb.add(btSquare);

        // Tlačítko pro vykreslení kruhu
        JButton btCircle = new JButton("Circle");
        btCircle.addActionListener(e -> canwas.add(new Circle(new Point(random.nextInt(canwas.getWidth() - 150), random.nextInt(canwas.getHeight() - 150)), RandomColor(), 5 + random.nextInt(80) )));
        tb.add(btCircle);


        // obdelnik
        JButton btRectangle = new JButton("Rectangle");
        btRectangle.addActionListener(e -> canwas.add(new Rectangle(new Point(random.nextInt(canwas.getWidth()), random.nextInt(canwas.getHeight())), RandomColor(), 10 + random.nextInt(80), 10 + random.nextInt(80))));
        tb.add(btRectangle);

        //trojuhelnik
        JButton btTriangle = new JButton("Triangle");
        btTriangle.addActionListener(e -> canwas.add(new Triangle(new Point(random.nextInt(canwas.getWidth()), random.nextInt(canwas.getHeight())), RandomColor(), 10 + random.nextInt(80))));
        tb.add(btTriangle);
        return tb;
    }

    private void initSampleData() {
        canwas.add(new Square(new Point(100, 100), Color.BLACK, 50));
        canwas.add(new Square(new Point(150, 100), Color.BLACK, 50));
        canwas.add(new Square(new Point(100, 150), Color.BLACK, 50));

        canwas.add(new Rectangle(new Point(250, 150), Color.BLACK, 60, 40));

        canwas.add(new Circle(new Point(200, 200), Color.BLACK, 25));

        canwas.add(new Triangle(new Point(300, 300), Color.BLACK, 50));

        GraphicGroup group = new GraphicGroup();
        canwas.add(group);
        group.addItem(new Circle(new Point(10, 20), Color.BLACK, 50));
    }
}