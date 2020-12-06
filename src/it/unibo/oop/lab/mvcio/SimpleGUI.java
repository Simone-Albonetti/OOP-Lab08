package it.unibo.oop.lab.mvcio;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;

/**
 * A very simple program using a graphical interface.
 * 
 */
public final class SimpleGUI {

    private final JFrame frame = new JFrame();

    /*
     * Once the Controller is done, implement this class in such a way that:
     * 
     * 1) It has a main method that starts the graphical application
     * 
     * 2) In its constructor, sets up the whole view
     * 
     * 3) The graphical interface consists of a JTextArea with a button "Save" right
     * below (see "ex02.png" for the expected result). SUGGESTION: Use a JPanel with
     * BorderLayout
     * 
     * 4) By default, if the graphical interface is closed the program must exit
     * (call setDefaultCloseOperation)
     * 
     * 5) The program asks the controller to save the file if the button "Save" gets
     * pressed.
     * 
     * Use "ex02.png" (in the res directory) to verify the expected aspect.
     */

    /**
     * builds a new {@link SimpleGUI}.
     */
    public SimpleGUI() {
        /*
         * Make the frame half the resolution of the screen. This very method is
         * enough for a single screen setup. In case of multiple monitors, the
         * primary is selected.
         * 
         * In order to deal coherently with multimonitor setups, other
         * facilities exist (see the Java documentation about this issue). It is
         * MUCH better than manually specify the size of a window in pixel: it
         * takes into account the current resolution.
         */
        final Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
        final int sw = (int) screen.getWidth();
        final int sh = (int) screen.getHeight();
        frame.setSize(sw / 2, sh / 2);
        /*
         * Instead of appearing at (0,0), upper left corner of the screen, this
         * flag makes the OS window manager take care of the default positioning
         * on screen. Results may vary, but it is generally the best choice.
         */
        frame.setLocationByPlatform(true);
        final JPanel panel = new JPanel(new BorderLayout());
        final JButton save = new JButton("Save");
        final JTextArea text = new JTextArea();
        final JPanel panel2 = new JPanel(new BorderLayout());
        final JTextArea text2 = new JTextArea();
        final JButton browse = new JButton("Browse");
        final Controller controller = new Controller();
        final JFileChooser fileChooser = new JFileChooser();
        panel.add(save, BorderLayout.SOUTH);
        panel.add(text);
        frame.add(panel);
        panel2.add(browse, BorderLayout.LINE_END);
        panel2.add(text2, BorderLayout.CENTER);
        text2.setText(controller.getFile().toString());
        text2.setEditable(false);
        frame.add(panel2, BorderLayout.NORTH);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        /**
         * It use the controller and a JFileChooser to change the current file
         */
        browse.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent e) {
                if (fileChooser.showSaveDialog(null) == JFileChooser.APPROVE_OPTION) {
                    controller.setFile(fileChooser.getSelectedFile().getAbsolutePath());
                } else {
                    JOptionPane.showMessageDialog(null, "Errore");
                }
                text2.setText(controller.getFile().toString());
            }

        });
        /**
         * It use the controller, and use saveStringOnFile 
         * method's to write on file
         */
        save.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent e) {
                try {
                    controller.saveStringOnFile(text.getText());
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            }
        });
    }
    public static void main(final String[] s) {
        new SimpleGUI();
    }
}
