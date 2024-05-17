package ExecutorService;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.concurrent.*;

import static java.awt.image.BufferedImage.TYPE_INT_RGB;

public class EditPicturesRGB {
    public static void main(String[] args) throws IOException, ExecutionException, InterruptedException {
        ExecutorService poolService = Executors.newFixedThreadPool(12);
        BufferedImage bi = read("D:\\JetBrains\\IdeaProjects\\JAVA\\src\\main\\java\\ExecutorService\\cc.jpg");
        double[] blackandwhite = {0.33, 0.33, 0.33};
        double[] grayscale = {0.2989, 0.587, 0.114};
        blackAndWhite(bi, blackandwhite, poolService);
        grayScale(bi, grayscale, poolService);
        poolService.shutdown();
    }

    public static BufferedImage read(String file) throws IOException {
        BufferedImage picture = ImageIO.read(new File(file));
        return picture;
    }

    public static void blackAndWhite(BufferedImage picture, double[] change, ExecutorService poolService) throws IOException, ExecutionException, InterruptedException {
        BufferedImage out = new BufferedImage(picture.getWidth(), picture.getHeight(), TYPE_INT_RGB);
        for (int i = 0; i < picture.getWidth(); ++i) {
            Future<BufferedImage> future = poolService.submit(new Task(i, out, picture, change));
            out = future.get();
        }
        ImageIO.write(out, "JPG", new FileOutputStream("D:\\JetBrains\\IdeaProjects\\JAVA\\src\\main\\java\\ExecutorService\\cc1.jpg"));
    }

    public static void grayScale(BufferedImage picture, double[] change, ExecutorService poolService) throws IOException, ExecutionException, InterruptedException {
        BufferedImage out = new BufferedImage(picture.getWidth(), picture.getHeight(), TYPE_INT_RGB);
        for (int i = 0; i < picture.getWidth(); ++i) {
            Future<BufferedImage> future = poolService.submit(new Task(i, out, picture, change));
            out = future.get();
        }
        ImageIO.write(out, "JPG", new FileOutputStream(new File("D:\\JetBrains\\IdeaProjects\\JAVA\\src\\main\\java\\ExecutorService\\cc2.jpg")));
    }

    public static class Task implements Callable<BufferedImage> {
        private int i;
        private final BufferedImage out;
        private final BufferedImage picture;
        private final double[] change;

        Task(int i, BufferedImage out, BufferedImage picture, double[] change) {
            this.i = i;
            this.out = out;
            this.picture = picture;
            this.change = change;
        }

        public BufferedImage call() {
            for (int j = 0; j < picture.getHeight(); ++j) {
                int red = ((picture.getRGB(i, j) >> 16) & 0xff);
                int green = ((picture.getRGB(i, j) >> 8) & 0xff);
                int blue = (picture.getRGB(i, j) & 0xff);
                int bw = (int) (red * change[0] + green * change[1] + blue * change[2]);
                Color blackAndWhite = new Color(bw, bw, bw);
                int rgb = blackAndWhite.getRGB();
                out.setRGB(i, j, rgb);
            }
            return out;
        }
    }

}
