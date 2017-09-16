import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.*;

import javax.imageio.ImageIO;

public class Code {
	private int width=300;
	private int height = 150;
	private Random r = new Random();
	private String[] fontNames = {"宋体","华文楷体","黑体","微软雅黑"};
	private Color bgcolor = new Color(255,255,255);
	private String codes = "23456789zxcvbnmasdfghjkqwertyui";
	private String text;
	
	public BufferedImage getImage() throws IOException{
		BufferedImage image=createImage();
		Graphics g = image.getGraphics();
		StringBuilder sb = new StringBuilder();
		
		for(int i = 0; i < 4; i++){
			String str=randomChar()+"";
			sb.append(str);
			g.setFont(randomFont());
			g.setColor(randomColor());
			g.drawString(str, r.nextInt(width), height/2);
		}
		this.text = sb.toString();
		drawLine(image);
		output(image);
		return image;
		
	}
	
	private String randomString(int n){
		String code = "0123456789qwertyuiopasdfghjklzxcvbnm";
		StringBuffer sb = new StringBuffer();
		for(int i = 0; i < n; i++){
			int index = r.nextInt(code.length());
			sb.append(code.charAt(index));
		}
		return sb.toString();
	}
	
	private void output(BufferedImage bi) throws IOException{
		File f = new File("C:/Users/Administrator/Desktop/" + 
				randomString(6) + ".jpg"); 
		ImageIO.write(bi, "jpg", f);
	}
	
	private BufferedImage createImage(){
		BufferedImage image = new BufferedImage(width, height, 
				BufferedImage.TYPE_INT_RGB);
		Graphics2D g2 = (Graphics2D)image.getGraphics();	
		g2.setBackground(Color.WHITE);
		g2.clearRect(0, 0, width, height);
		return image;
	}
	
	private char randomChar(){
		int index = r.nextInt(codes.length());
		char y = codes.charAt(index);
		return y;
	}
	
	private Font randomFont(){
		int index = r.nextInt(fontNames.length);
		int style = r.nextInt(4);
		int size = r.nextInt(22) + 50;
		Font f = new Font(fontNames[index],style, size);
		return f;
	}
	
	private Color randomColor(){
		int red = r.nextInt(150);
		int green = r.nextInt(150);
		int blue = r.nextInt(150);
		return new Color(red,green,blue);
	}
	
	private void drawLine(Image im){
		Graphics g = im.getGraphics();
		for(int i = 0; i < 10; i++){
			int x1 = r.nextInt(width);
			int y1 = r.nextInt(height);
			int x2 = r.nextInt(width);
			int y2 = r.nextInt(height);
			g.setColor(new Color(r.nextInt(150),
					r.nextInt(150),r.nextInt(150)));
			g.drawLine(x1, y1, x2, y2);
		}
	}
	public static void main(String[] args) throws IOException {
		Code c = new Code();
		for(int i = 0; i < 3; i++){
			c.getImage();
		}
	}
}
