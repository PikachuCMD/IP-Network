import java.util.Scanner;

class Test1 {
    public static void main(String[] args) {
       Scanner sc = new Scanner(System.in);
       while (true) {       
       int input = sc.nextInt();
        
       int PowOwt []= {128,64,32,16,8,4,2,1};
       int y=0;
       String s = "";

       for (int i=0; i< PowOwt.length; i++) {
            if (y+PowOwt[i]>input) {
                PowOwt[i] = 0;
                s+="0";
            }
            else {
                y+=PowOwt[i];
                s+="1";
            }

       }
       System.out.println(s);
    }
       
    }
}