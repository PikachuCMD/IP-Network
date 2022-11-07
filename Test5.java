import java.util.Scanner;

public class Test5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter your PI Address : ");
        String line = sc.next();
        String input[] = line.split("[. /]");

        int inA = Integer.parseInt(input[0]);
        int inB = Integer.parseInt(input[1]);
        int inC = Integer.parseInt(input[2]);
        int inD = Integer.parseInt(input[3]);
        int inE = Integer.parseInt(input[4]);

        // Class number H
        int ClassNum = 0;

        String SubnetClass = "";

        // Class A : 0 - 127
        if (inA <= 127) {
            SubnetClass = "A";
            ClassNum = 3;
        }
        // Class B: 128 - 191
        else if (inA <= 191) {
            SubnetClass = "B";
            ClassNum = 2;
        }
        // Class C: 192 - 223
        else if (inA <= 224) {
            SubnetClass = "C";
            ClassNum = 1;
        }
        // Class D: 224 - 239
        else if (inA <= 239) {
            SubnetClass = "D";
        }
        // Class E: 224 - 255
        else {
            SubnetClass = "E";
        }
        int bitBorrow = 0;
        switch (SubnetClass) {
            case "A":
                bitBorrow += Math.abs(8 * 1 - inE);
                BinaryFormatA(bitBorrow, ClassNum, inA);
                break;
            case "B":
                bitBorrow += Math.abs(8 * 2 - inE);
                BinaryFormatB(bitBorrow, ClassNum, inA, inB);
                break;
            case "C":
                bitBorrow += Math.abs(8 * 3 - inE);
                BinaryFormatC(bitBorrow, ClassNum, inA, inB, inC);
                break;
            case "D":
                break;
            case "E":
                break;
        }
    }

    static void BinaryFormatA(int bitBorrow, int ClassNum, int inA) {
        int a = bitBorrow;
        int b[] = new int[ClassNum];
        for (int i = 0; i < ClassNum; i++) {
            if (a > 8) {
                b[i] = 8;
                a -= 8;
            } else if (a > 0) {
                b[i] = a;
                break;
            }
        }
        for (int i = 0; i < b.length; i++) {
            // System.out.println(b[i]);
        }
        String output = "";
        String output2 = "";
        String output3 = "";
        int number = 0;
        int number2 = 0;
        int number3 = 0;
        String sc = "";

        for (int i = 0; i < b.length; i++) {

            for (int j = 0; j < b[i]; j++) {
                sc += "1";
            }
            if (i < b.length - 1) {
                sc += ".";
            }
        }
        // System.out.println(sc);
        String ff[] = sc.split("[.]");
        while (true) {
            int PowOwt[] = { 128, 64, 32, 16, 8, 4, 2, 1 };
            int y = 0;
            String s = "";
            for (int j = Math.abs(PowOwt.length - b[0]); j < PowOwt.length; j++) {
                if (y + PowOwt[j] > number) {
                    PowOwt[j] = 0;
                    s += "0";
                } else {
                    y += PowOwt[j];
                    s += "1";
                }
            }
            number++;
            output += s + ",";
            if (s.equals(ff[0])) {
                break;
            }
        }

        if (b[1] > 0) {
            while (true) {

                int PowOwt[] = { 128, 64, 32, 16, 8, 4, 2, 1 };
                int y = 0;
                String s = "";
                for (int j = Math.abs(PowOwt.length - b[1]); j < PowOwt.length; j++) {
                    if (y + PowOwt[j] > number2) {
                        PowOwt[j] = 0;
                        s += "0";
                    } else {
                        y += PowOwt[j];
                        s += "1";
                    }
                }

                number2++;
                output2 += s + ",";
                if (s.equals(ff[1])) {
                    break;
                }
            }

        } else {

            for (int i = 0; i < number; i++) {
                String s = "";
                for (int j = 0; j < 8; j++) {
                    s += "0";
                }
                output2 += s + ",";
            }
        }

        if (b[2] > 0) {
            while (true) {

                int PowOwt[] = { 128, 64, 32, 16, 8, 4, 2, 1 };
                int y = 0;
                String s = "";
                for (int j = Math.abs(PowOwt.length - b[2]); j < PowOwt.length; j++) {
                    if (y + PowOwt[j] > number3) {
                        PowOwt[j] = 0;
                        s += "0";
                    } else {
                        y += PowOwt[j];
                        s += "1";
                    }
                }

                number3++;
                output3 += s + ",";
                if (s.equals(ff[2])) {
                    break;
                }
            }

        } else {

            for (int i = 0; i < number; i++) {
                String s = "";
                for (int j = 0; j < 8; j++) {
                    s += "0";
                }
                output3 += s + ",";
            }
        }
        if (number2 == 0) {
            number2 = 1;
        }
        if (number3 == 0) {
            number3 = 1;
        }
        String BfA[] = output.split("[. ,]");
        String BfA_R[] = output.split("[. ,]");
        String BfB[] = output2.split("[. ,]");
        String BfB_R[] = output2.split("[. ,]");
        String BfC[] = output3.split("[. ,]");

        if (b[0] < 8) {
            for (int i = 0; i < BfA.length; i++) {
                for (int j = 0; j < 8 - b[0]; j++) {
                    BfA[i] += "0";
                    BfA_R[i] += "1";
                }
            }
        } else if (b[1] < 8) {
            for (int i = 0; i < BfB.length; i++) {
                for (int j = 0; j < 8 - b[1]; j++) {
                    BfB[i] += "0";
                    BfB_R[i] += "1";
                }
            }
        }

        String BinaryFormat = "";
        if (b[2] > 0) {
            for (int i = 0; i < BfA.length; i++) {
                for (int j = 0; j < BfB.length; j++) {
                    for (int k = 0; k < BfC.length; k++) {
                        BinaryFormat += BfA[i] + "." + BfB[j] + "." + BfC[k] + ",";
                    }

                }
            }
        } else if (b[1] > 0) {
            for (int i = 0; i < BfA.length; i++) {
                for (int j = 0; j < BfB.length; j++) {
                    BinaryFormat += BfA[i] + "." + BfB[j] + ",";
                    // System.out.println(BfA[i] + "." + BfB[j]);
                }
            }
        } else {
            for (int i = 0; i < BfA.length; i++) {
                BinaryFormat += BfA[i] + ",";
            }
        }
        String BinaryFormat2 = "";
        if (b[1] > 0) {
            for (int i = 0; i < BfA.length; i++) {
                for (int j = 0; j < BfB_R.length; j++) {
                    BinaryFormat2 += BfA[i] + "." + BfB_R[j] + ",";
                    // System.out.println(BfA[i] + "." + BfB_R[j]);
                }
            }
        }
        SubAssdressA(BinaryFormat, (number * number2 * number3), inA, b, BfA_R, BfB_R, BinaryFormat2, bitBorrow);
    }

    static void BinaryFormatB(int bitBorrow, int ClassNum, int inA, int inB) {
        int a = bitBorrow;
        int b[] = new int[ClassNum];
        for (int i = 0; i < ClassNum; i++) {
            if (a > 8) {
                b[i] = 8;
                a -= 8;
            } else if (a > 0) {
                b[i] = a;
                break;
            }
        }
        for (int i = 0; i < b.length; i++) {
            System.out.println(b[i]);
        }

        String output = "";
        String output2 = "";
        int number = 0;
        int number2 = 0;
        String sc = "";

        for (int i = 0; i < b.length; i++) {

            for (int j = 0; j < b[i]; j++) {
                sc += "1";
            }
            if (i < b.length - 1) {
                sc += ".";
            }
        }

        String ff[] = sc.split("[.]");
        while (true) {
            int PowOwt[] = { 128, 64, 32, 16, 8, 4, 2, 1 };
            int y = 0;
            String s = "";
            for (int j = Math.abs(PowOwt.length - b[0]); j < PowOwt.length; j++) {
                if (y + PowOwt[j] > number) {
                    PowOwt[j] = 0;
                    s += "0";
                } else {
                    y += PowOwt[j];
                    s += "1";
                }
            }
            number++;
            output += s + ",";
            if (s.equals(ff[0])) {
                break;
            }
        }
        System.out.println("Number " + number);
        if (b[1] > 0) {
            while (true) {

                int PowOwt[] = { 128, 64, 32, 16, 8, 4, 2, 1 };
                int y = 0;
                String s = "";
                for (int j = Math.abs(PowOwt.length - b[1]); j < PowOwt.length; j++) {
                    if (y + PowOwt[j] > number2) {
                        PowOwt[j] = 0;
                        s += "0";
                    } else {
                        y += PowOwt[j];
                        s += "1";
                    }
                }

                number2++;
                output2 += s + ",";
                if (s.equals(ff[1])) {
                    break;
                }
            }

        } else {

            for (int i = 0; i < number; i++) {
                String s = "";
                for (int j = 0; j < 8; j++) {
                    s += "0";
                }
                output2 += s + ",";
            }
        }

        if (number2 == 0) {
            number2 = 1;
        }

        String BfA[] = output.split("[. ,]");
        String BfA_R[] = output.split("[. ,]");
        String BfB[] = output2.split("[. ,]");
        if (b[0] < 8) {
            for (int i = 0; i < BfA.length; i++) {
                for (int j = 0; j < 8 - b[0]; j++) {
                    BfA[i] += "0";
                    BfA_R[i] += "1";
                }
            }
        }

        String BinaryFormat = "";
        if (b[1] > 0) {
            for (int i = 0; i < BfA.length; i++) {
                for (int j = 0; j < BfB.length; j++) {
                    BinaryFormat += BfA[i] + "." + BfB[j] + ",";
                }
            }
        } else {
            for (int i = 0; i < BfA.length; i++) {
                BinaryFormat += BfA[i] + ",";
            }
        }
        // System.out.println(BinaryFormat);

        SubAssdressB(BinaryFormat, (number * number2), inA, inB, b, BfA_R, bitBorrow);
    }

    static void BinaryFormatC(int bitBorrow, int ClassNum, int inA, int inB, int inC) {
        String output = "";
        int number = 0;
        String sc = "";
        for (int j = 0; j < bitBorrow; j++) {
            sc += "1";
        }
        System.out.println(sc + " " + bitBorrow);
        while (true) {
            int PowOwt[] = { 128, 64, 32, 16, 8, 4, 2, 1 };
            int y = 0;
            String s = "";
            for (int j = Math.abs(PowOwt.length - bitBorrow); j < PowOwt.length; j++) {
                if (y + PowOwt[j] > number) {
                    PowOwt[j] = 0;
                    s += "0";
                } else {
                    y += PowOwt[j];
                    s += "1";
                }
            }
            number++;
            output += s + ",";
            if (s.equals(sc)) {
                break;
            }
        }
        // System.out.println(output);
        SubAssdressC(output, (number), inA, inB, inC, bitBorrow);

    }

    static void SubAssdressA(String BinaryFormat, int number, int inA, int[] b, String[] BfA_R, String[] BfB_R,
            String BinaryFormat2, int bitBorrow) {

        String BFL[] = BinaryFormat.split("[ , ]");
        String BFR[] = BinaryFormat.split("[ , ]");

        String BFR_CB[] = BinaryFormat2.split("[ , ]");

        int PowOwt[] = { 128, 64, 32, 16, 8, 4, 2, 1 };

        if (b[2] > 0) {

            for (int i = 0; i < BFL.length; i++) {
                for (int j = 0; j < 8 - b[2]; j++) {
                    BFL[i] += "0";
                }
            }
            for (int i = 0; i < BFR.length; i++) {

                for (int j = 0; j < 8 - b[2]; j++) {
                    BFR[i] += "1";
                }
            }

        } else if (b[1] > 0) {
            for (int i = 0; i < BFL.length; i++) {
                BFL[i] += ".00000000";
                BFR_CB[i] += ".111111111";
            }

        }

        else {
            for (int i = 0; i < BFL.length; i++) {
                BFL[i] += ".";
                for (int j = 0; j < 8; j++) {
                    BFL[i] += "0";
                }
            }
            for (int i = 0; i < BFL.length; i++) {
                BFL[i] += ".";
                for (int j = 0; j < 8; j++) {
                    BFL[i] += "0";
                }
            }

            for (int i = 0; i < BFR.length; i++) {
                BfA_R[i] += ".";
                for (int j = 0; j < 8; j++) {
                    BfA_R[i] += "1";
                }
                BFR[i] = BfA_R[i];
            }
            for (int i = 0; i < BFR.length; i++) {
                BfA_R[i] += ".";
                for (int j = 0; j < 8; j++) {
                    BfA_R[i] += "1";
                }
                BFR[i] = BfA_R[i];
            }

        }

        if (b[1] > 0 && b[1] < 8) {
            String BFL_A = "";
            String BFL_B = "";
            for (int i = 0; i < BFL.length; i++) {
                String[] str = BFL[i].split("[ . ]");
                int subA_A = 0;
                int subA_B = 0;
                int subA_C = 0;
                for (int j = 0; j < PowOwt.length; j++) {
                    if (str[0].charAt(j) == '1') {
                        subA_A += PowOwt[j];
                    }
                    if (str[1].charAt(j) == '1') {
                        subA_B += PowOwt[j];
                    }
                    if (str[2].charAt(j) == '1') {
                        subA_C += PowOwt[j];
                    }
                }
                String spA = "";
                String spB = "";
                if (subA_A < 10) {
                    spA = "   ";
                } else if (subA_A < 100) {
                    spA = "  ";
                } else {
                    spA = " ";
                }

                if (subA_B < 10) {
                    spB = "   ";
                } else if (subA_B < 100) {
                    spB = "  ";
                } else {
                    spB = " ";
                }
                BFL_A += inA + "." + subA_A + "." + subA_B + "." + subA_C + spA + spB + ",";
                BFL_B += inA + "." + subA_A + "." + subA_B + "." + (subA_C + 1) + spA + spB + ",";
            }

            String BFR_AA = "";
            String BFR_BB = "";
            for (int i = 0; i < BFR_CB.length; i++) {
                String[] str = BFR_CB[i].split("[ . ]");
                int subA_A = 0;
                int subA_B = 0;
                int subA_C = 0;
                for (int j = 0; j < PowOwt.length; j++) {
                    if (str[0].charAt(j) == '1') {
                        subA_A += PowOwt[j];
                    }
                    if (str[1].charAt(j) == '1') {
                        subA_B += PowOwt[j];
                    }
                    if (str[2].charAt(j) == '1') {
                        subA_C += PowOwt[j];
                    }
                }
                String spA = "";
                String spB = "";
                if (subA_A < 10) {
                    spA = "   ";
                } else if (subA_A < 100) {
                    spA = "  ";
                } else {
                    spA = " ";
                }

                if (subA_B < 10) {
                    spB = "   ";
                } else if (subA_B < 100) {
                    spB = "  ";
                } else {
                    spB = " ";
                }
                BFR_AA += inA + "." + subA_A + "." + subA_B + "." + subA_C + spA + spB + ",";
                BFR_BB += inA + "." + subA_A + "." + subA_B + "." + (subA_C - 1) + spA + spB + ",";
            }
            String nB[] = BFR_AA.split("[,]");
            String nA[] = BFL_A.split("[,]");
            String mA[] = BFL_B.split("[,]");
            String mB[] = BFR_BB.split("[,]");
            String sp_i = "";
            for (int i = 0; i < number; i++) {
                if (i < 10) {
                    sp_i = "    ";
                } else if (i < 100) {
                    sp_i = "   ";
                } else if (i < 1000) {
                    sp_i = "  ";
                } else if (i < 10000) {
                    sp_i = " ";
                }
               /* if (i == 5000) {
                    break;
                }*/
                System.out.println(i + sp_i + " : " + bitBorrow + " | " + BFR[i] + " | " + nA[i] + " | " + mA[i]
                        + " -  " + mB[i] + " | " + nB[i] + " | " + BFR_CB[i]);

            }

        } else if (b[2] > 0) {
            String BFL_A = "";
            String BFL_B = "";
            for (int i = 0; i < BFL.length; i++) {
                String[] str = BFL[i].split("[ . ]");
                int subA_A = 0;
                int subA_B = 0;
                int subA_C = 0;
                for (int j = 0; j < PowOwt.length; j++) {
                    if (str[0].charAt(j) == '1') {
                        subA_A += PowOwt[j];
                    }
                    if (str[1].charAt(j) == '1') {
                        subA_B += PowOwt[j];
                    }
                    if (str[2].charAt(j) == '1') {
                        subA_C += PowOwt[j];
                    }
                }
                String spA = "";
                String spB = "";
                String spC = "";
                if (subA_A < 10) {
                    spA = "   ";
                } else if (subA_A < 100) {
                    spA = "  ";
                } else {
                    spA = " ";
                }

                if (subA_B < 10) {
                    spB = "   ";
                } else if (subA_B < 100) {
                    spB = "  ";
                } else {
                    spB = " ";
                }

                if (subA_C < 10) {
                    spC = "   ";
                } else if (subA_C < 100) {
                    spC = "  ";
                } else {
                    spC = " ";
                }
                BFL_A += inA + "." + subA_A + "." + subA_B + "." + subA_C + spA + spB + spC + ",";
                BFL_B += inA + "." + subA_A + "." + subA_B + "." + (subA_C + 1) + spA + spB + spC + ",";
            }

            String BFR_AA = "";
            String BFR_BB = "";
            for (int i = 0; i < BFR.length; i++) {
                String[] str = BFR[i].split("[ . ]");
                int subA_A = 0;
                int subA_B = 0;
                int subA_C = 0;
                for (int j = 0; j < PowOwt.length; j++) {
                    if (str[0].charAt(j) == '1') {
                        subA_A += PowOwt[j];
                    }
                    if (str[1].charAt(j) == '1') {
                        subA_B += PowOwt[j];
                    }
                    if (str[2].charAt(j) == '1') {
                        subA_C += PowOwt[j];
                    }
                }

                String spA = "";
                String spB = "";
                String spC = "";
                if (subA_A < 10) {
                    spA = "   ";
                } else if (subA_A < 100) {
                    spA = "  ";
                } else {
                    spA = " ";
                }

                if (subA_B < 10) {
                    spB = "   ";
                } else if (subA_B < 100) {
                    spB = "  ";
                } else {
                    spB = " ";
                }

                if (subA_C < 10) {
                    spC = "   ";
                } else if (subA_C < 100) {
                    spC = "  ";
                } else {
                    spC = " ";
                }
                BFR_AA += inA + "." + subA_A + "." + subA_B + "." + subA_C + spA + spB + spC + ",";
                BFR_BB += inA + "." + subA_A + "." + subA_B + "." + (subA_C - 1) + spA + spB + spC + ",";
            }

            String nB[] = BFR_AA.split("[,]");
            String nA[] = BFL_A.split("[,]");
            String mA[] = BFL_B.split("[,]");
            String mB[] = BFR_BB.split("[,]");
            String sp_i = "";
            for (int i = 0; i < number; i++) {
                if (i < 10) {
                    sp_i = "    ";
                } else if (i < 100) {
                    sp_i = "   ";
                } else if (i < 1000) {
                    sp_i = "  ";
                } else if (i < 10000) {
                    sp_i = " ";
                }

                System.out.println(i + sp_i + " : " + bitBorrow + " | " + BFR[i] + " | " + nA[i] + " | " + mA[i]
                        + " -  " + mB[i] + " | " + nB[i] + " | " + BFR[i]);
                ;

            }
        } else {
            String BFL_A = "";
            String BFL_B = "";
            for (int i = 0; i < BFL.length; i++) {
                String[] str = BFL[i].split("[ . ]");
                int subA_A = 0;
                int subA_B = 0;
                int subA_C = 0;
                for (int j = 0; j < PowOwt.length; j++) {
                    if (str[0].charAt(j) == '1') {
                        subA_A += PowOwt[j];
                    }
                    if (str[1].charAt(j) == '1') {
                        subA_B += PowOwt[j];
                    }
                    if (str[2].charAt(j) == '1') {
                        subA_C += PowOwt[j];
                    }
                }
                String spA = "";
                if (subA_A < 10) {
                    spA = "   ";
                } else if (subA_A < 100) {
                    spA = "  ";
                } else {
                    spA = " ";
                }
                BFL_A += inA + "." + subA_A + "." + subA_B + "." + subA_C + spA + ",";
                BFL_B += inA + "." + subA_A + "." + subA_B + "." + (subA_C + 1) + spA + ",";
            }

            String BFR_AA = "";
            String BFR_BB = "";
            for (int i = 0; i < BFR.length; i++) {
                String[] str = BFR[i].split("[ . ]");
                int subA_A = 0;
                int subA_B = 0;
                int subA_C = 0;
                for (int j = 0; j < PowOwt.length; j++) {
                    if (str[0].charAt(j) == '1') {
                        subA_A += PowOwt[j];
                    }
                    if (str[1].charAt(j) == '1') {
                        subA_B += PowOwt[j];
                    }
                    if (str[2].charAt(j) == '1') {
                        subA_C += PowOwt[j];
                    }
                }

                String spA = "";
                if (subA_A < 10) {
                    spA = "   ";
                } else if (subA_A < 100) {
                    spA = "  ";
                } else {
                    spA = " ";
                }
                BFR_AA += inA + "." + subA_A + "." + subA_B + "." + subA_C + spA + ",";
                BFR_BB += inA + "." + subA_A + "." + subA_B + "." + (subA_C - 1) + spA + ",";
            }

            String nB[] = BFR_AA.split("[,]");
            String nA[] = BFL_A.split("[,]");
            String mA[] = BFL_B.split("[,]");
            String mB[] = BFR_BB.split("[,]");
            String sp_i = "";
            for (int i = 0; i < number; i++) {
                if (i < 10) {
                    sp_i = "    ";
                } else if (i < 100) {
                    sp_i = "   ";
                } else if (i < 1000) {
                    sp_i = "  ";
                } else if (i < 10000) {
                    sp_i = " ";
                }
             
                System.out.println(i + sp_i + " : " + bitBorrow + " | " + BFR[i] + " | " + nA[i] + " | " + mA[i]
                        + " -  " + mB[i] + " | " + nB[i] + " | " + BFR[i]);

            }
        }

    }

    static void SubAssdressB(String BinaryFormat, int number, int inA, int inB, int[] b, String[] BfA_R,
            int bitBorrow) {

        String BFL[] = BinaryFormat.split("[ , ]");
        String BFR[] = BinaryFormat.split("[ , ]");
        int PowOwt[] = { 128, 64, 32, 16, 8, 4, 2, 1 };
        if (b[1] > 0) {

            for (int i = 0; i < BFL.length; i++) {
                for (int j = 0; j < 8 - b[1]; j++) {
                    BFL[i] += "0";
                }

            }
            for (int i = 0; i < BFR.length; i++) {

                for (int j = 0; j < 8 - b[1]; j++) {
                    BFR[i] += "1";
                }

            }

        } else {
            for (int i = 0; i < BFL.length; i++) {
                BFL[i] += ".";
                for (int j = 0; j < 8; j++) {
                    BFL[i] += "0";
                }
            }
            for (int i = 0; i < BFR.length; i++) {
                BfA_R[i] += ".";
                for (int j = 0; j < 8; j++) {
                    BfA_R[i] += "1";
                }
                BFR[i] = BfA_R[i];
            }
        }
        if (b[1] == 0) {
            String BFL_A = "";
            String BFL_B = "";
            for (int i = 0; i < BFL.length; i++) {
                String[] str = BFL[i].split("[ . ]");
                int subB_A = 0;
                int subB_B = 0;
                for (int j = 0; j < PowOwt.length; j++) {
                    if (str[0].charAt(j) == '1') {
                        subB_A += PowOwt[j];
                    }
                    if (str[1].charAt(j) == '1') {
                        subB_B += PowOwt[j];
                    }
                }
                String spA = "    ";

                if (subB_A < 10) {
                    spA = "   ";
                } else if (subB_A < 100) {
                    spA = "  ";
                } else {
                    spA = " ";
                }

                BFL_A += inA + "." + inB + "." + subB_A + "." + subB_B + spA + ",";
                BFL_B += inA + "." + inB + "." + subB_A + "." + (subB_B + 1) + spA + ",";
            }
            String BFR_A = "";
            String BFR_B = "";
            for (int i = 0; i < BFR.length; i++) {
                String[] str = BFR[i].split("[ . ]");
                int subB_A = 0;
                int subB_B = 0;
                for (int j = 0; j < PowOwt.length; j++) {
                    if (str[0].charAt(j) == '1') {
                        subB_A += PowOwt[j];
                    }
                    if (str[1].charAt(j) == '1') {
                        subB_B += PowOwt[j];
                    }
                }

                String spA = "    ";
                String spB = "    ";
                if (subB_A < 10) {
                    spA = "   ";
                } else if (subB_A < 100) {
                    spA = "  ";
                } else {
                    spA = " ";
                }

                if (subB_B < 10) {
                    spB = "   ";
                } else if (subB_B < 100) {
                    spB = "  ";
                } else {
                    spB = " ";
                }

                BFR_A += inA + "." + inB + "." + subB_A + "." + subB_B + spA + ",";
                BFR_B += inA + "." + inB + "." + subB_A + "." + (subB_B - 1) + spA + ",";
            }
            String nB[] = BFR_A.split("[,]");
            String nA[] = BFL_A.split("[,]");
            String mA[] = BFL_B.split("[,]");
            String mB[] = BFR_B.split("[,]");
            String sp_i = "";
            for (int i = 0; i < number; i++) {
                if (i < 10) {
                    sp_i = "    ";
                } else if (i < 100) {
                    sp_i = "   ";
                } else if (i < 1000) {
                    sp_i = "  ";
                } else if (i < 10000) {
                    sp_i = " ";
                }
                System.out.println(i + sp_i + " : " + bitBorrow + " | " + BFR[i] + " | " + nA[i] + " | " + mA[i]
                        + " -  " + mB[i] + " | " + nB[i] + " | " + BFR[i]);

            }
        } else {
            String BFL_A = "";
            String BFL_B = "";
            for (int i = 0; i < BFL.length; i++) {
                String[] str = BFL[i].split("[ . ]");
                int subB_A = 0;
                int subB_B = 0;
                for (int j = 0; j < PowOwt.length; j++) {
                    if (str[0].charAt(j) == '1') {
                        subB_A += PowOwt[j];
                    }
                    if (str[1].charAt(j) == '1') {
                        subB_B += PowOwt[j];
                    }
                }
                String spA = "    ";
                String spB = "    ";
                if (subB_A < 10) {
                    spA = "   ";
                } else if (subB_A < 100) {
                    spA = "  ";
                } else {
                    spA = " ";
                }

                if (subB_B < 10) {
                    spB = "   ";
                } else if (subB_B < 100) {
                    spB = "  ";
                } else {
                    spB = " ";
                }
                BFL_A += inA + "." + inB + "." + subB_A + "." + subB_B + spA + spB + ",";
                BFL_B += inA + "." + inB + "." + subB_A + "." + (subB_B + 1) + spA + spB + ",";
            }
            String BFR_A = "";
            String BFR_B = "";
            for (int i = 0; i < BFR.length; i++) {
                String[] str = BFR[i].split("[ . ]");
                int subB_A = 0;
                int subB_B = 0;
                for (int j = 0; j < PowOwt.length; j++) {
                    if (str[0].charAt(j) == '1') {
                        subB_A += PowOwt[j];
                    }
                    if (str[1].charAt(j) == '1') {
                        subB_B += PowOwt[j];
                    }
                }

                String spA = "    ";
                String spB = "    ";
                if (subB_A < 10) {
                    spA = "   ";
                } else if (subB_A < 100) {
                    spA = "  ";
                } else {
                    spA = " ";
                }

                if (subB_B < 10) {
                    spB = "   ";
                } else if (subB_B < 100) {
                    spB = "  ";
                } else {
                    spB = " ";
                }

                BFR_A += inA + "." + inB + "." + subB_A + "." + subB_B + spA + spB + ",";
                BFR_B += inA + "." + inB + "." + subB_A + "." + (subB_B - 1) + spA + spB + ",";
            }
            String nB[] = BFR_A.split("[,]");
            String nA[] = BFL_A.split("[,]");
            String mA[] = BFL_B.split("[,]");
            String mB[] = BFR_B.split("[,]");
            String sp_i = "";
            for (int i = 0; i < number; i++) {
                if (i < 10) {
                    sp_i = "    ";
                } else if (i < 100) {
                    sp_i = "   ";
                } else if (i < 1000) {
                    sp_i = "  ";
                } else if (i < 10000) {
                    sp_i = " ";
                }
                System.out.println(i + sp_i + " : " + bitBorrow + " | " + BFR[i] + " | " + nA[i] + " | " + mA[i]
                        + " -  " + mB[i] + " | " + nB[i] + " | " + BFR[i]);

            }
        }

    }

    static void SubAssdressC(String BinaryFormat, int number, int inA, int inB, int inC, int bitBorrow) {
        String BFL[] = BinaryFormat.split("[ , ]");
        String BFR[] = BinaryFormat.split("[ , ]");
        int PowOwt[] = { 128, 64, 32, 16, 8, 4, 2, 1 };
        if (bitBorrow < 8) {
            for (int i = 0; i < number; i++) {
                for (int j = 0; j < 8 - bitBorrow; j++) {
                    BFL[i] += "0";
                }
            }
            for (int i = 0; i < number; i++) {
                for (int j = 0; j < 8 - bitBorrow; j++) {
                    BFR[i] += "1";
                }
            }
        }

        for (int i = 0; i < BFL.length; i++) {
            int subL_A = 0;
            int subR_B = 0;
            for (int j = 0; j < PowOwt.length; j++) {
                if (BFL[i].charAt(j) == '1') {
                    subL_A += PowOwt[j];
                }
                if (BFR[i].charAt(j) == '1') {
                    subR_B += PowOwt[j];
                }
            }
            String spA = "";
            String spB = "";
            if (subL_A < 10) {
                spA = "   ";
            } else if (subL_A < 100) {
                spA = "  ";
            } else {
                spA = " ";
            }

            if (subR_B < 10) {
                spB = "   ";
            } else if (subR_B < 100) {
                spB = "  ";
            } else {
                spB = " ";
            }
            String sp_i = "";
            if (i < 10) {
                sp_i = "   ";
            } else if (i < 100) {
                sp_i = "  ";
            } else {
                sp_i = " ";
            }
            System.out.println(i + sp_i + ": " + bitBorrow + " | " + BFL[i] + " | " + inA + "." + inB + "." + inC + "."
                    + subL_A + spA
                    + " | " + inA + "." +
                    inB + "." + inC + "." + (subL_A + 1) + spA + " -  " + inA + "." + inB + "." + inC + "."
                    + (subR_B - 1) + spB + " | " + inA
                    + "." + inB + "." + inC + "." + subR_B + spB + " | " + BFR[i]);

        }

    }

}
