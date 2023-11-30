import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import javax.imageio.ImageIO;
import javax.swing.*;

// This panel represent the animated part of the view with the car images.

public class DrawPanel extends JPanel{


    // Just a single image, TODO: Generalize
    Map<String, BufferedImage> imageMap = new HashMap<String, BufferedImage>();
    BufferedImage bgImage;

    CarController cc;

    // To keep track of a singel cars position
    Point volvoPoint = new Point();
    double direction = 0;

    // TODO: Make this genereal for all cars


    void turnit(double degrees) {
        direction = degrees;
    }

    // Initializes the panel and reads the images
    public DrawPanel(int x, int y, CarController cc) {
        this.setDoubleBuffered(true);
        this.cc = cc;
        // Print an error message in case file is not found with a try/catch block
        try {
            // You can remove the "pics" part if running outside of IntelliJ and
            // everything is in the same main folder.
            // volvoImage = ImageIO.read(new File("Volvo240.jpg"));

            // Rememember to rightclick src New -> Package -> name: pics -> MOVE *.jpg to pics.
            // if you are starting in IntelliJ.
            imageMap.put("Volvo240", ImageIO.read(DrawPanel.class.getResourceAsStream("pics/carVolvo.png")));
            imageMap.put("Saab95", ImageIO.read(DrawPanel.class.getResourceAsStream("pics/Saab95.png")));
            imageMap.put("CarTransport", ImageIO.read(DrawPanel.class.getResourceAsStream("pics/carTransport.png")));

            bgImage = ImageIO.read(DrawPanel.class.getResourceAsStream("pics/bilmatta.png"));
            this.setPreferredSize(new Dimension(500, 500));
            this.setBackground(Color.green);
        } catch (IOException ex)
        {
            ex.printStackTrace();
        }

    }

    // This method is called each time the panel updates/refreshes/repaints itself
    // TODO: Change to suit your needs.
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(bgImage, 0, 0,2000 ,800 ,null);

        for(Car car: cc.getCars()) {
            BufferedImage img = imageMap.get(car.getModelName());
            double rotationRequired = direction;
            double locationX = img.getWidth() / 2;
            double locationY = img.getHeight() / 2;
            AffineTransform tx = AffineTransform.getRotateInstance(rotationRequired, locationX, locationY);
            AffineTransformOp op = new AffineTransformOp(tx, AffineTransformOp.TYPE_BILINEAR);

            g.drawImage(op.filter(img, null), (int) car.getPositionX(),(int) car.getPositionY(),null); // see javadoc for more info on the parameters
        }

    }
}
