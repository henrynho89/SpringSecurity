package org.diembo.base.utils.impl;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

import javax.imageio.ImageIO;

import org.apache.tomcat.util.codec.binary.Base64;
import org.diembo.base.enums.ErrorCode;
import org.diembo.base.utils.SaphirException;


public class ImageUtils {
	
	//----------------------------------------------------------------------------------------------------------------
	public static String concatImages(String imgData1 , String imgData2) {
		
	    try {
		BufferedImage img1,img2;
		
		img1 = getImageFromBytes(imgData1);
		img2 = getImageFromBytes(imgData2);
		
        int heightTotal = img1.getHeight()+img2.getHeight();
        int withtTotal = img1.getWidth() < img2.getWidth() ? img2.getWidth()  : img1.getWidth();
        
        int heightCurr = 0;
        BufferedImage concatImage = new BufferedImage(withtTotal, heightTotal, BufferedImage.TYPE_INT_RGB);
        Graphics2D g2d = concatImage.createGraphics();
        
        g2d.drawImage(img1, 0, heightCurr, null);
        heightCurr += img1.getHeight();
        
        g2d.drawImage(img2, 0, heightCurr, null);
        heightCurr += img2.getHeight();
        
        g2d.dispose();
        
        
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        ImageIO.write(concatImage, "JPEG", out);
        byte[] bytes = out.toByteArray();

        String base64bytes = Base64.encodeBase64String(bytes);
        String src = base64bytes;
        
        return src;
        
	    } catch (IOException e) {
	    	throw new SaphirException(ErrorCode.backend_error, e.getMessage());
	    }
	}
	//-------------------------------------------------------------------------------------------

	
	//-------------------------------------------------------------------------------------------
	private static BufferedImage getImageFromBytes(String imageData) {
		byte[] imageBytes = null;
	    BufferedImage image = null;
	    
	    try {
	    	
	    	 imageBytes = javax.xml.bind.DatatypeConverter.parseBase64Binary(imageData);
	    	 ByteArrayInputStream bis = new ByteArrayInputStream(imageBytes);
	    	 image = ImageIO.read(bis);
	    	 bis.close();

	    } catch (IOException e) {
	    	throw new SaphirException(ErrorCode.backend_error, e.getMessage());
	    }
	    
	    return image;
	}
	//-------------------------------------------------------------------------------------------
	
}
