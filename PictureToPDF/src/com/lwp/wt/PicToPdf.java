package com.lwp.wt;

import com.lowagie.text.Document;
import com.lowagie.text.Image;
import com.lowagie.text.Rectangle;
import com.lowagie.text.pdf.PdfWriter;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.FileOutputStream;
import java.io.File;

/**
 * 工具类  将文件下的图片逐个输出为PDF
 * author :lwp
 * date :2019-01-09
 */
public class PicToPdf {
    /**
     *
     * @param imageFolderPath 图片输入路径
     * @param pdfPath PDF输出路径
     */
    public  static  void picToPdf(String imageFolderPath, String pdfPath){
        try {
            //图片地址
            String imagePath = null;
            //图片读入流
            BufferedImage img = null;
            //输出流
            FileOutputStream fos = null;
            //文档对象
            Document doc = null;
            //实例化图片
            Image image = null;
            // 获取图片文件夹对象
            File  file = new File(imageFolderPath);
            File[] files = file.listFiles();
            //循环获取文件夹的图片
            for(File file1 : files){
                if(file1.getName().endsWith(".jpg") ||
                        file1.getName().endsWith(".png") ||
                        file1.getName().endsWith(".gif") ||
                        file1.getName().endsWith(".jpeg") ||
                        file1.getName().endsWith(".tif")){
                    //System.out.println("图片名称："+file1.getName());
                    imagePath = imageFolderPath + file1.getName();
                    System.out.println("图片名称："+file1.getName());
                    //输出流  拿到图片名字去掉扩展名
                    fos = new FileOutputStream(pdfPath + file1.getName().substring(0,file1.getName()
                            .lastIndexOf('.'))+".pdf");
                    //创建PDF文档
                    doc = new Document(null, 0, 0, 0, 0);
                    //写入PDF文档
                    PdfWriter.getInstance(doc, fos);

                    // 读取图片流
                    img = ImageIO.read(new File(imagePath));
                    // 根据图片大小设置文档大小
                    doc.setPageSize(new Rectangle(img.getWidth(), img
                            .getHeight()));
                    // 实例化图片
                    image = Image.getInstance(imagePath);
                    // 添加图片到文档
                    doc.open();
                    doc.add(image);
                    //关闭文档
                    doc.close();

                }
            }


        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static  void main(String[] args ){
        long time1 = System.currentTimeMillis();
        String pdfPath = "D:\\outputPdf\\";
        picToPdf("D:/picture/",pdfPath);
        long time2 = System.currentTimeMillis();
        int time = (int)((time2 - time1) / 1000);
        System.out.println("执行了："+time+"秒！");
    }

}
