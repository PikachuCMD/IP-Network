import java.util.Scanner;

public class Test2 {

    static void print(int Subnet, String[] BinaryFormatA, String[] BinaryFormatB, String Address, int num,
            int bitBorrow,
            String A, String B) {

        String spaceA = "      ";

        for (int i = 0; i <= Subnet; i++) {
            String spA = "";
            String spB = "";
            int PowOwt[] = { 128, 64, 32, 16, 8, 4, 2, 1 };
            int SubnetAddressA = 0;
            int SubnetAddressB = 0;

            for (int j = 0; j < PowOwt.length; j++) {

                if (BinaryFormatA[i].charAt(j) == '1') {
                    SubnetAddressA += PowOwt[j];
                }
                if (BinaryFormatB[i].charAt(j) == '1') {
                    SubnetAddressB += PowOwt[j];
                }
            }

            if (i >= 100) {
                spaceA = "    ";
            } else if (i >= 10) {
                spaceA = "     ";
            }

            if (SubnetAddressA < 10) {
                spA = "  ";

            } else if (SubnetAddressA < 100) {
                spA = " ";
            }

            if (SubnetAddressB < 10) {
                spB = "  ";
            } else if (SubnetAddressB < 100) {
                spB = " ";
            }
            // Class A [H,N,N,N]
            if (num == 1) {
                System.out.println(spaceA + i + " | " + "           " + bitBorrow + " | " + BinaryFormatA[i] + "." + B
                        + "." + B + " | "
                        + Address + SubnetAddressA + "." + 0 + "." + 0 + spA + "       | " + Address + ""
                        + (SubnetAddressA)
                        + "." + 0 + "." + (0 + 1) + spA + " - " + Address + (SubnetAddressB) + "." + 255 + "."
                        + (255 - 1)
                        + spB + "   | "
                        + Address + (SubnetAddressB) + "." + (255) + "." + 255 + spB + "       | " + BinaryFormatB[i]
                        + "." + A
                        + "." + A);
            }
            // Class B [H,H,N,N]
            else if (num == 2) {
                System.out.println(spaceA + i + " | " + "           " + bitBorrow + " | " + BinaryFormatA[i] + "." + B
                        + " | " + Address
                        + SubnetAddressA + "." + 0 + spA + "      | " + Address + "" + (SubnetAddressA) + "." + (0 + 1)
                        + spA
                        + " - "
                        + Address + (SubnetAddressB) + "." + (255 - 1) + spB + "   | " + Address + (SubnetAddressB)
                        + "."
                        + (255) + spB + "        | " + BinaryFormatB[i] + "." + A);
            }
            // Class C [H,H,H,N]
            else if (num == 3) {

                System.out.println(spaceA + i + " | " + "           " + bitBorrow + " |      " + BinaryFormatA[i]
                        + " |     " + Address + SubnetAddressA
                        + spA + " |   " + Address + (SubnetAddressA + 1) + spA + " - " + Address + (SubnetAddressB - 1)
                        + spB + " |         "
                        + Address + SubnetAddressB + spB + " | " + BinaryFormatB[i]);
            }
            // Class D [H,H,H,H]
            else if (num == 4) {

            }
        }
    }

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

        String A = "11111111";
        String B = "00000000";
        int num = 0;

        for (int i = 0; i < input.length; i++) {
            if (Integer.parseInt(input[i]) == 0) {
                num = i;
                break;
            }
        }

        if (Math.abs((num * 8) - inE) <= 8) {
            String Address = "";

            for (int i = 0; i < input.length - 1; i++) {
                if ((Integer.parseInt(input[i]) != 0)) {
                    Address += input[i] + ".";
                }
            }
            // return the bit Borrow
            int bitBorrow = bitBorrow(input, inE);

            // return the bit array
            String BF = BinaryFormat(bitBorrow);

            // result the Subnet
            int Subnet = BF.split("[,]").length - 1;

            // return the BinaryFormat
            String BinaryFormatA[] = BF.split("[,]");
            String BinaryFormatB[] = BF.split("[,]");

            for (int i = 0; i < BinaryFormatA.length; i++) {
                for (int j = 0; j < (8 - bitBorrow); j++) {
                    BinaryFormatA[i] += "0";
                }
            }

            for (int i = 0; i < BinaryFormatB.length; i++) {
                for (int j = 0; j < (8 - bitBorrow); j++) {
                    BinaryFormatB[i] += "1";
                }
            }

            switch (num) {
                case 1:
                    String print1 = "Subnet#" + " | " + "#Bits Borrow" + " | " + "Binary Format             " + " | "
                            + "IP Subnet Address" + " | " + "Host Range (Useable Host Range)" + " | " +
                            "PI Brooadcast Address" + " | " + "Binary Foemat";
                    for (int i = 0; i < print1.length() + 13; i++) {
                        System.out.print("=");
                    }

                    System.out.println("\n" + print1);
                    for (int i = 0; i < print1.length() + 13; i++) {
                        System.out.print("=");
                    }
                    System.out.println();
                    break;
                case 2:
                    String print2 = "Subnet#" + " | " + "#Bits Borrow" + " | " + "Binary Format    " + " | "
                            + "IP Subnet Address" + " | " + "Host Range (Useable Host Range)" + " | " +
                            "PI Brooadcast Address" + " | " + "Binary Foemat";
                    for (int i = 0; i < print2.length() + 4; i++) {
                        System.out.print("=");
                    }

                    System.out.println("\n" + print2);
                    for (int i = 0; i < print2.length() + 4; i++) {
                        System.out.print("=");
                    }
                    System.out.println();

                    break;
                case 3:
                    String print3 = "Subnet#" + " | " + "#Bits Borrow" + " | " + "Binary Format" + " | "
                            + "IP Subnet Address" + " | " + "Host Range (Useable Host Range)" + " | " +
                            "PI Brooadcast Address" + " | " + "Binary Foemat";
                    for (int i = 0; i < print3.length(); i++) {
                        System.out.print("=");
                    }

                    System.out.println("\n" + print3);
                    for (int i = 0; i < print3.length(); i++) {
                        System.out.print("=");
                    }
                    System.out.println();

                    break;
            }
            print(Subnet, BinaryFormatA, BinaryFormatB, Address, num, bitBorrow, A, B);
        } else {
            System.out.println("=====================================================");
            System.out.println(
                    "  Your input is Exceeded [" + (Math.abs((num * 8) - inE) - 8) + "] bits, please try again_");
            System.out.println("=====================================================");
        }

    }

    static int bitBorrow(String a[], int b) {
        int bit = 0;
        for (int i = 0; i < a.length - 1; i++) {

            if (Integer.parseInt(a[i]) == 0) {
                bit += (i * 8);
                break;
            }
        }
        return Math.abs(bit - b);
    }

    static String BinaryFormat(int a) {

        String output = "";
        int number = 0;
        String sc = "";
        for (int i = 0; i < a; i++) {
            sc += "1";
        }
        while (true) {

            int PowOwt[] = { 128, 64, 32, 16, 8, 4, 2, 1 };

            int y = 0;
            String s = "";

            for (int i = Math.abs(PowOwt.length - a); i < PowOwt.length; i++) {
                if (y + PowOwt[i] > number) {
                    PowOwt[i] = 0;
                    s += "0";
                } else {
                    y += PowOwt[i];
                    s += "1";
                }
            }
            number++;
            output += s + ",";
            if (s.equals(sc)) {
                break;
            }
        }
        return output;
    }
}
