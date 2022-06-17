package GUI;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class ImageCanvas extends Canvas{

    public void paint(Graphics graphics) {

        BufferedImage bufferedImage;
        try {
            bufferedImage = ImageIO.read(new File("src/GUI/erase.png"));
            graphics.drawImage(bufferedImage, 0, 0, 40,40,null);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
