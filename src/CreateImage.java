import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.font.FontRenderContext;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;

public class CreateImage {
	
	
	public static void main(String[] args) throws Exception {
		int  width = 100;
		int height = 100;
		String s = "ÄãºÃ";
		
		File f = new File("C:/Users/Administrator/Desktop/1.jpg"); 
		
		Font font = new Font("ºÚÌå",Font.BOLD, 2);
		BufferedImage bi = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
		Graphics2D g2 = (Graphics2D)bi.getGraphics();
		g2.setBackground(Color.WHITE);
		g2.clearRect(0, 0, width, height);
		g2.setColor(Color.RED);
		
		FontRenderContext context = g2.getFontRenderContext();
		Rectangle2D bounds = font.getStringBounds(s, context);
		double x = (width - bounds.getWidth()) / 2;
		double y = (height -bounds.getHeight()) /2;
		double ascent = -bounds.getY();
		double baseY = y + ascent;
		
		g2.drawString(s, (int)x, (int)y);
		
		Graphics g = bi.getGraphics();
		int x1 = 10;
		int y1 = 20;
		int x2 = 30;
		int y2 = 40;
		g.setColor(Color.BLUE);
		g.drawLine(x1, y1, x2, y2);
		
		ImageIO.write(bi, "jpg", f);
	}

}
