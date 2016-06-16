package cn.tedu.util;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.Random;


public class ImageUtil {

	// 验证码的范围
	private static final char[] chars = { 
		'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 
		'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 
		'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};
	// 验证码的长度 四个字符
	private static final int SIZE = 4;
	// 干扰线
	private static final int LINES = 5;
	// 图片宽
	private static final int WIDTH = 80;
	// 图片高
	private static final int HEIGHT = 40;
	// 字符大小
	private static final int FONT_SIZE = 30;

	/**
	 * 
	 */
	public static Object[] createImage() {
		// 建立StringBuffer 保存验证码
		StringBuffer sb = new StringBuffer();
		// 建立BufferedImage 空白图片
		BufferedImage image = new BufferedImage(
				// 传入宽 高 调用Image的常量 RGB原色
			WIDTH, HEIGHT, BufferedImage.TYPE_INT_RGB);
	
		// 获取画笔
		Graphics graphic = image.getGraphics();
		
		// 设置画笔颜色 
		graphic.setColor(Color.LIGHT_GRAY);
		
		// 设置矩形背景 
		graphic.fillRect(0, 0, WIDTH, HEIGHT);
		
		// 生成随机数从字符数组中获取字符
		// size 要生成的字符数量
		Random ran = new Random();
		for (int i = 0; i <SIZE; i++) {
			
			//  chars.length 生成字符数组的随机下标
			int n = ran.nextInt(chars.length);

			// 画笔设置随机色 
			graphic.setColor(getRandomColor());
			
			// 画字符，设置大小
			graphic.setFont(new Font(
				null, Font.BOLD + Font.ITALIC, FONT_SIZE));
			
			// 字符位置 设置
			graphic.drawString(
				chars[n] + "", i * WIDTH / SIZE, HEIGHT / 2);
			
			// 将画好的字符保存进StringBuffer 
			sb.append(chars[n]);
		}
		// 6. 干扰线
		for (int i = 0; i < LINES; i++) {
			// 
			graphic.setColor(getRandomColor());
			// 
			graphic.drawLine(ran.nextInt(WIDTH), ran.nextInt(HEIGHT),
					ran.nextInt(WIDTH), ran.nextInt(HEIGHT));
		}
		// 7. 返回数组，保存sb 与 对应图片
		return new Object[]{sb.toString(), image};
	}

	/**
	 * 随机三原色 配合生成图片用
	 */
	public static Color getRandomColor() {
		Random ran = new Random();
		Color color = new Color(ran.nextInt(256), 
				ran.nextInt(256), ran.nextInt(256));
		return color;
	}
	
//	public static void main(String[] args) throws IOException {
//		Object[] objs = createImage();
//		BufferedImage image = (BufferedImage) objs[1];
//		OutputStream os = new FileOutputStream("/Users/mac/Workspaces/MyEclipse 2015/netct/src/main/webapp/images/1.jpg");
//		ImageIO.write(image, "jpeg", os);
//		os.close();
//	}

}

