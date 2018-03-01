package github.banana;

import javax.swing.*;
import java.awt.*;

public class Bounce {

    public static void main(String args[]) {
        EventQueue.invokeLater(() -> {
            JFrame frame = new BounceFrame();
            frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
            frame.setVisible(true);
        });
    }
}
