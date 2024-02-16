package it.unibo.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.io.File;
import java.lang.reflect.InvocationTargetException;
import java.nio.file.FileSystems;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import it.unibo.controller.api.Controller;
import it.unibo.controller.impl.ControllerImpl;

public class GUIKitchen {

    private static final String SEP = File.separator;
    private static final String PATH_TO_THE_ROOT = FileSystems.getDefault().getPath(new String()).toAbsolutePath().toString();
    private static final String PATH_TO_RESOURCES = SEP + "src" + SEP + "main" + SEP + "resources" + SEP;

    private final Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    private final int screenWidth = (int)screenSize.getWidth();
    private final int screenHeight = (int)screenSize.getHeight();

    private final JFrame frame = new JFrame("KITCHEN");
    
    public GUIKitchen(final Controller controller) {
        frame.setSize(screenWidth, screenHeight);
        final Image background = Toolkit.getDefaultToolkit().getImage(PATH_TO_THE_ROOT + PATH_TO_RESOURCES + 
            "Preparation_Zone.png");
        ImagePanel imagePanel = new ImagePanel(background);
        frame.getContentPane().setLayout(new BorderLayout());
        frame.getContentPane().add(imagePanel, BorderLayout.CENTER);
        imagePanel.setLayout(new BorderLayout());
        
        displayInfoLabels(imagePanel);

        final JPanel lowPanel = new JPanel(new BorderLayout());
        lowPanel.setOpaque(false);
        final Image garbageBin = Toolkit.getDefaultToolkit().getImage(PATH_TO_THE_ROOT + PATH_TO_RESOURCES + 
            "KitchenComponentsImages" + SEP + "GarbageBin.png");
        final JButton btnGarbageBin = new JButton();
        btnGarbageBin.setBackground(new Color(195, 195, 195, 255));
        btnGarbageBin.setBorderPainted(false);
        lowPanel.add(btnGarbageBin, BorderLayout.EAST);
        displayGarbageBinButton(btnGarbageBin, garbageBin, frame.getWidth(), frame.getHeight(), lowPanel);
        imagePanel.add(lowPanel, BorderLayout.SOUTH);

        frame.addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(final ComponentEvent e) {
                int width = frame.getContentPane().getWidth();
                int height = frame.getContentPane().getHeight();
                displayInfoLabels(imagePanel);
                displayGarbageBinButton(btnGarbageBin, garbageBin, width, height, lowPanel);
            }
        });

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private void displayInfoLabels(final ImagePanel imagePanel) {
        final JPanel highPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, (int)(frame.getWidth() / 35), 10));
        final JLabel lblDay = new JLabel("Day: 16/02/2024");
        highPanel.add(lblDay);
        highPanel.add(new JLabel("18:15"));
        highPanel.add(new JLabel("Balance: 50€"));
        imagePanel.add(highPanel, BorderLayout.NORTH);
    }

    private void displayGarbageBinButton(final JButton bin, final Image garbageBin, final int width, final int height, final JPanel lowPanel) {
        bin.setSize(new Dimension((int)(width * 0.08), (int)(height * 0.15)));
        bin.setIcon(new ImageIcon(garbageBin
            .getScaledInstance((int)(bin.getWidth()-10), (int)(bin.getHeight()-5), 0)));
        lowPanel.setBorder(new EmptyBorder((int)(height*0.2), (int)(width*0.2), 
            (int)(height*0.09), (int)(width*0.12)));
    }

    public void start() {
        frame.setVisible(true);
    }

    public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException {
        new GUIKitchen(new ControllerImpl()).start();;
    }

}