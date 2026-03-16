package cz.uhk.graphed.model.gui;

import cz.uhk.graphed.model.Square;

import javax.swing.*;
import java.awt.*;

public class EditorFrame extends JFrame {
    private Canvas canvas= Canvas;

    public EditorFrame() throws HeadlessException {
        super("FIM Graphic Editor");

        add(canvas, BorderLayout.CENTER);

        initSampleData();

        pack();
    }

    private void initSampleData() {
        canvas.add(new Square(new Point(100, 100), Color.BLACK, 50));
        canvas.add(new Square(new Point(150, 100), Color.BLACK, 50));
        canvas.add(new Square(new Point(100, 150), Color.BLACK, 50));
    }
}
