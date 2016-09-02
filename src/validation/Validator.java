/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package validation;

import java.awt.Graphics;
import java.awt.Point;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;
import javax.imageio.ImageIO;
import javax.swing.JComponent;
import javax.swing.JViewport;
import javax.swing.SwingUtilities;


/**
 *
 * @author PC
 */
public class Validator extends JComponent{
    
    private Set<JComponent> invalidFields = new HashSet<JComponent>();
    private BufferedImage warningIcon;

    public Validator() {
        loadImages();
    }

    public void removeWarning(JComponent field) {
        if (invalidFields.contains(field)) {
            invalidFields.remove(field);
            repaintBadge(field);

        }
    }

    public void addWarning(JComponent field) {
        invalidFields.add(field);
        repaintBadge(field);
    }

    private void repaintBadge(JComponent field) {
        Point p = field.getLocationOnScreen();
        SwingUtilities.convertPointFromScreen(p, this);
        int x = p.x +field.getWidth() - warningIcon.getWidth() / 2;
        int y = (int) (p.y + field.getHeight()
                - warningIcon.getHeight() / 1.5);
        repaint(x, y, warningIcon.getWidth(),
                warningIcon.getHeight());
    }

    private void loadImages() {
        try {
            warningIcon = ImageIO.read(getClass().getResource(
                    "/validation/11.jpg"));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        
    }

    @Override
    protected void paintComponent(Graphics g) {
        //System.out.println("painting...in...");
        for (JComponent invalid : invalidFields) {
            if (invalid.getParent() instanceof JViewport) {
                JViewport viewport = (JViewport) invalid.getParent();
// the parent of the viewport is a JScrollPane
                invalid = (JComponent) viewport.getParent();
            }
            Point p = invalid.getLocationOnScreen();
            SwingUtilities.convertPointFromScreen(p, this);
            int x = p.x + invalid.getWidth() - warningIcon.getWidth() / 2;
            int y = (int) (p.y + invalid.getHeight() - warningIcon.getHeight() / 1.5);




            if (g.getClipBounds().intersects(x, y,
                    warningIcon.getWidth(), warningIcon.getHeight())) {
                g.drawImage(warningIcon, x, y, null);
            }
        }
    }
    
}
