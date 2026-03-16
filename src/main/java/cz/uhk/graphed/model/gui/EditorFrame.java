package cz.uhk.graphed.model.gui;

import cz.uhk.graphed.model.Rectangle;
import cz.uhk.graphed.model.Square;

import javax.swing.*;
import java.awt.*;

public class EditorFrame extends JFrame {
    private Canwas canwas= new Canwas();

    public EditorFrame() throws HeadlessException {
        super("FIM Graphic Editor");

        add(canwas, BorderLayout.CENTER);

        initSampleData();

        pack();
    }

    private void initSampleData() {
        canwas.add(new Square(new Point(100, 100), Color.BLACK, 50));
        canwas.add(new Square(new Point(150, 100), Color.BLACK, 50));
        canwas.add(new Square(new Point(100, 150), Color.BLACK, 50));

        canwas.add(new Rectangle(new Point(100, 150), Color.BLACK, 60, 40));

    }
}
