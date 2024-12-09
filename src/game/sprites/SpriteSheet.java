package game.sprites;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

public class SpriteSheet {
	private BufferedImage image;
	private int width, height;
	private int[] pixels;
	
	public SpriteSheet(String filePath) {
		image = loadImageFromFile(filePath);
		width = image.getWidth();
		height = image.getHeight();
		pixels = image.getRGB(0, 0, width, height, null, 0, width);
	}

	public BufferedImage getSprite(int x, int y, int w, int h) {
		BufferedImage sprite = new BufferedImage(w, h, BufferedImage.TYPE_INT_ARGB);
		int[] spritePixels = new int[w * h]; 	
		for (int i = y, k = 0; i < y + h; i++) {
            for (int j = x; j < x + w; j++) {
            	spritePixels[k++] = pixels[i * width + j];
            }
        }
		sprite.setRGB(0, 0, w, h, spritePixels, 0, w);
		return sprite;
	}
	
	private BufferedImage loadImageFromFile(String filePath) {
		try {
			image = ImageIO.read(getClass().getResourceAsStream(filePath));
		} catch (IOException e) {
			e.printStackTrace();
		}
		return image;
	}
}
