import java.util.Scanner;
import java.util.Random;

public class Test3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random r = new Random();
        String line = "";
        for (int j = 0; j < 1000000; j++) {

            int PowOwt[] = { 128, 64, 32, 16, 8, 4, 2, 1 };
            int y = 0;
            String s = "";

            for (int i = 0; i < PowOwt.length; i++) {
                if (y + PowOwt[i] > r.nextInt(256)) {
                    PowOwt[i] = 0;
                    s += "0";
                } else {
                    y += PowOwt[i];
                    s += "1";
                }

            }
            line += s + ".";

        }
        String result[] = line.split("[.]");
        int count[] = new int[result.length];

        for (int i = 0; i < result.length; i++) {
            if (!result[i].equals("100")) {
                count[i] = 1;
                for (int j = i + 1; j < count.length; j++) {
                    if (!result[i].equals("100")) {
                        if (result[i].equals(result[j])) {
                            count[i] += 1;
                            result[j] = "100";
                        }
                    }
                }
            }
        }
        int sum  = 0;
        for (int i = 0; i < count.length; i++) {

             sum+= count[i];
        }

        for (int i=0;i< result.length;i++) {
            if (!result[i].equals("100")) {
                System.out.println(result[i]+":"+ count[i]);
            }
        }
         
        System.out.println("ramdom from to :"+sum);
       
    }
}
