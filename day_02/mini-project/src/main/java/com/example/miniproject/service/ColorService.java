package com.example.miniproject.service;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;

@Service
public class ColorService {
    public String randomColor(int type) {
        return switch (type) {
            case 1 -> randomColorName();
            case 2 -> randomHexColor();
            case 3 -> randomRgbColor();
            default -> throw new RuntimeException("Type không hợp lệ");
        };
    }

    private String randomColorName() {
//        List<String> colors = List.of("black", "white", "blue", "green");
        return "red";
    }

    private String randomRgbColor() {
        Random rd = new Random();
        int r = rd.nextInt(256);
        int g = rd.nextInt(256);
        int b = rd.nextInt(256);
        return "rgb(" + r + "," + g + "," + b + ")";
//        return "rgb(22,14,123)";
    }

    // 0 -> 9; a -> f
    private String randomHexColor() {
        return "#7928a9";
    }


}
