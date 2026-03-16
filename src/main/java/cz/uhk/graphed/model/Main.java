package cz.uhk.graphed.model;

// Musíme naimportovat EditorFrame z jiného balíčku
import cz.uhk.graphed.model.gui.EditorFrame;

public class Main {
    public static void main(String[] args) {
        // 1. Vytvoříme instanci našeho okna
        EditorFrame frame = new EditorFrame();

        // 2. Nastavíme, aby se aplikace ukončila, když okno zavřeme křížkem
        frame.setDefaultCloseOperation(EditorFrame.EXIT_ON_CLOSE);

        // 3. Zviditelníme okno (tohle vám chybělo)
        frame.setVisible(true);
    }
}