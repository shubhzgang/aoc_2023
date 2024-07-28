package com.shubhzgang.daytwo;

import java.io.File;
import java.io.FileNotFoundException;
import java.net.URL;
import java.util.*;

//  12 red cubes, 13 green cubes, and 14 blue cubes
public class CubeConundrum {
    public static void main(String[] args) throws FileNotFoundException {
        URL path = CubeConundrum.class.getResource("input.txt");
        File file = new File(Objects.requireNonNull(path).getPath());
        Scanner scanner = new Scanner(file);
        List<String> lines = new ArrayList<>();
        while (scanner.hasNextLine()) {
            lines.add(scanner.nextLine());
        }
        long ans = 0L;
        long ans2 = 0L;
        for (int i = 0; i < lines.size(); i++) {
            String line = lines.get(i);
            String[] parts = line.split(":");
            String[] handfuls = parts[1].split(";");
            int red = 0;
            int green = 0;
            int blue = 0;
            int count = 0;
            for (String handful : handfuls) {
                String[] balls = handful.split(", ");
                //System.out.println(Arrays.toString(balls));
                // array of n color, m color2 etc.
                for (String ball : balls) {
                    //System.out.println(ball);
                    String[] numCol = ball.trim().split(" ");
                    //System.out.println(Arrays.toString(numCol));
                    switch (numCol[1]) {
                        case "red":
                            count = Integer.parseInt(numCol[0]);
                            red = Math.max(count, red);
                            break;
                        case "green":
                            count = Integer.parseInt(numCol[0]);
                            green = Math.max(count, green);
                            break;
                        default:
                            count = Integer.parseInt(numCol[0]);
                            blue = Math.max(count, blue);
                            break;
                    }
                }
            }
            if (red <= 12 && green <= 13 && blue <= 14) {
                ans += i + 1;
            }
            ans2 += ((long) red * green * blue);
        }
        System.out.println(ans);
        System.out.println(ans2);
    }
}
