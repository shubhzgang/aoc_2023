package com.shubhzgang.dayone;

import java.io.File;
import java.io.FileNotFoundException;
import java.net.URL;
import java.util.Objects;
import java.util.Scanner;

public class Trebuchet {
    public static void main(String[] args) throws FileNotFoundException {
        URL path = Trebuchet.class.getResource("input.txt");
        File file = new File(Objects.requireNonNull(path).getFile());
        Scanner sc = new Scanner(file);
        int sum = 0;
        while(sc.hasNextLine()) {
            String line = sc.nextLine();
            for (int i = 0; i < line.length(); i++) {
                char c = line.charAt(i);
                if (c <= '9' && c >= '0') {
                    sum += (c - '0') * 10;
                    break;
                }
            }
            for (int i = line.length() - 1; i >= 0; i--) {
                char c = line.charAt(i);
                if (c <= '9' && c >= '0') {
                    sum += (c - '0');
                    break;
                }
            }
        }
        System.out.println("answer: " + sum);
    }
}
