package com.simplemethod.aiwd.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Service;


import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;

@Service
public class pngMaker {

    @Autowired
    ResourceLoader resourceLoader;

   // @Value("classpath:static/1.png")
   // Resource resource;

    public byte[] makePng( int ctAlive,int tAlive,int winRound,float flashValue, float smokeValue, int maps) throws IOException {



        BufferedImage result = new BufferedImage(500, 282,BufferedImage.TYPE_INT_RGB);
        Graphics g = result.getGraphics();

        BufferedImage mapsBI = ImageIO.read(  resourceLoader.getResource("classpath:static/"+maps+".png").getFile());
        g.drawImage(mapsBI, 0, 0, null);

        BufferedImage winBI = ImageIO.read(  resourceLoader.getResource("classpath:static/5_"+Math.round(winRound)+".png").getFile());
        g.drawImage(winBI, 100, 0, null);

        BufferedImage tAliveBI = ImageIO.read(  resourceLoader.getResource("classpath:static/2_"+ Math.round(tAlive)+".png").getFile());
        g.drawImage(tAliveBI, 0, 10, null);

        BufferedImage ctAliveBI = ImageIO.read(  resourceLoader.getResource("classpath:static/1_"+Math.round(ctAlive)+".png").getFile());
        g.drawImage(ctAliveBI, 260, 10, null);

        BufferedImage flashBI = ImageIO.read(  resourceLoader.getResource("classpath:static/3_"+Math.round(flashValue)+".png").getFile());
        g.drawImage(flashBI, 0, 180, null);

        BufferedImage smokeBI = ImageIO.read(  resourceLoader.getResource("classpath:static/4_"+Math.round(smokeValue)+".png").getFile());
        g.drawImage(smokeBI, 0, 220, null);



        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ImageIO.write(result, "png", baos);
        byte[] bytes = baos.toByteArray();
        //System.out.println(baos.toString());
        return bytes;
    }


    public pngMaker() {
        super();
    }
}
