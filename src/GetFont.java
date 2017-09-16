import java.awt.GraphicsEnvironment;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStream;

public class GetFont {

	public static void main(String[] args) throws IOException {
		FileWriter fw = new FileWriter("C:/Users/Administrator/Desktop/fontName.txt");
		GraphicsEnvironment e = GraphicsEnvironment.getLocalGraphicsEnvironment();
		String[] fontName = e.getAvailableFontFamilyNames();
		for(int i = 0; i < fontName.length; i++){
			fw.write(fontName[i]+"\n");
			fw.flush();
			System.out.printf("%s\n",fontName[i]);
		}
		fw.close();
	}

}
