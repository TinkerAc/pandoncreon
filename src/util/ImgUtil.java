package util;

import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;

/**
 * 图像读取的工具类
 *
 */
public class ImgUtil {
	/**
	 * get jpg img
	 * @param name
	 * @return
	 */
	public static BufferedImage getJpgImgByName(String name){
		BufferedImage bfimg = null;
		try {
			bfimg = ImageIO.read(ClassLoader.getSystemResourceAsStream("img"+"/"+name+".jpg"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		return bfimg;
	}
	
	/**
	 * get png img
	 * @param name
	 * @return
	 */
	public static BufferedImage getPngImgByName(String name){
		BufferedImage bfimg = null;
		try {
			bfimg = ImageIO.read(ClassLoader.getSystemResourceAsStream("img"+"/"+name+".png"));
		} catch (Exception e) {
			System.out.println("异常name:"+name);
			e.printStackTrace();
		}
		return bfimg;
	}
	
}
