import java.util.Scanner;

public class Test4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num[] = new int[5];
        int count[] = new int[5];

        for (int i = 0; i < num.length; i++) {
            num[i] = sc.nextInt();
        }

        for (int i = 0; i < num.length; i++) {
            if (num[i] < 100) {
                count[i] = 1;
                for (int j = i + 1; j < count.length; j++) {
                    if (num[i] < 100) {
                        if (num[i] == num[j]) {
                            count[i] += 1;
                            num[j] = 100;
                        }
                    }
                }
            }
        }

        for (int i = 0; i < num.length; i++) {
            if (num[i] < 100) {
                System.out.println(num[i] + " : " + count[i]);
            }

        }
    }
}
