package ExecutorService;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferByte;
import java.awt.image.DataBufferInt;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;

import static java.awt.image.BufferedImage.TYPE_INT_RGB;

public class ImgUtil {

    public static void main(String[] args) throws IOException {
        BufferedImage bi = read("test.jpg");
        write(bi);
    }

    public static BufferedImage read(String file) throws IOException {
        BufferedImage picture = ImageIO.read(new File(file));
        return picture;
    }

    public static void write(BufferedImage picture) throws IOException {

        BufferedImage out = new BufferedImage(picture.getWidth(), picture.getHeight(), TYPE_INT_RGB);
        for(int i = 0; i < picture.getWidth(); ++i)
            for (int j = 0; j < picture.getHeight(); ++j) {
                out.setRGB(i,j,picture.getRGB(i,j));
            }
        ImageIO.write(out, "JPG", new FileOutputStream(new File("test1.jpg")));
    }
}