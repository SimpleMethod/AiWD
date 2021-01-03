package com.simplemethod.aiwd.services;

import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Service;


import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

@Service
public class PNGMaker {

    @Autowired
    ResourceLoader resourceLoader;

    /**
     * Generuje obraz na podstawie atrybutów
     *
     * @param ctAlive    liczba żyjących członków CT
     * @param tAlive     liczba żyjących członków T
     * @param winRound   Wygrana runda przez określoną stronę
     * @param flashValue Wartość użytych granatów błyskowych
     * @param smokeValue Wartość użytych granatów dymnnych
     * @param maps       Mapa
     * @return zwraca obraz jako tablicę bitową
     */
    @SneakyThrows()
    public byte[] makePng(double ctAlive, double tAlive, int winRound, double flashValue, double smokeValue, int maps) {

        BufferedImage result = new BufferedImage(500, 282, BufferedImage.TYPE_INT_RGB);
        Graphics g = result.getGraphics();

        BufferedImage mapsBI = ImageIO.read(resourceLoader.getResource("classpath:static/" + maps + ".png").getFile());
        g.drawImage(mapsBI, 0, 0, null);

        BufferedImage winBI = ImageIO.read(resourceLoader.getResource("classpath:static/5_" + Math.round(winRound) + ".png").getFile());
        g.drawImage(winBI, 100, 0, null);

        BufferedImage tAliveBI = ImageIO.read(resourceLoader.getResource("classpath:static/2_" + tAlive + ".png").getFile());
        g.drawImage(tAliveBI, 0, 10, null);

        BufferedImage ctAliveBI = ImageIO.read(resourceLoader.getResource("classpath:static/1_" + ctAlive + ".png").getFile());
        g.drawImage(ctAliveBI, 260, 10, null);

        BufferedImage flashBI = ImageIO.read(resourceLoader.getResource("classpath:static/3_" + flashValue + ".png").getFile());
        g.drawImage(flashBI, 0, 180, null);

        BufferedImage smokeBI = ImageIO.read(resourceLoader.getResource("classpath:static/4_" + smokeValue + ".png").getFile());
        g.drawImage(smokeBI, 0, 220, null);

        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ImageIO.write(result, "png", baos);
        byte[] bytes = baos.toByteArray();
        return bytes;
    }

    public PNGMaker() {
        super();
    }
}
