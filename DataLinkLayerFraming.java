import java.util.Scanner;

public class DataLinkLayerFraming {
    private static final char FLAG = 'F';
    private static final char ESCAPE = 'E';
    private static final String BIT_FLAG = "01111110";
    public static String characterStuffing(String data) {
        StringBuilder stuffedData = new StringBuilder();
        stuffedData.append(FLAG);
        for (int i = 0; i < data.length(); i++) {
            char ch = data.charAt(i);
            if (ch == FLAG || ch == ESCAPE) {
                stuffedData.append(ESCAPE);
            }
            stuffedData.append(ch);
        }
        stuffedData.append(FLAG);
        return stuffedData.toString();
    }
    public static String characterDeStuffing(String stuffedData) {
        StringBuilder destuffedData = new StringBuilder();
        boolean isEscaped = false;
        for (int i = 1; i < stuffedData.length() - 1; i++) {
            char ch = stuffedData.charAt(i);
            if (isEscaped) {
                destuffedData.append(ch);
                isEscaped = false;
            } else if (ch == ESCAPE) {
                isEscaped = true;
            } else {
                destuffedData.append(ch);
            }
        }
        return destuffedData.toString();
    }
    public static String bitStuffing(String data) {
        StringBuilder stuffedData = new StringBuilder();
        stuffedData.append(BIT_FLAG);
        int consecutiveOnes = 0;
        for (int i = 0; i < data.length(); i++) {
            char bit = data.charAt(i);
            stuffedData.append(bit);
            if (bit == '1') {
                consecutiveOnes++;
                if (consecutiveOnes == 5) {
                    stuffedData.append('0');
                    consecutiveOnes = 0;
                }
            } else {
                consecutiveOnes = 0;
            }
        }
        stuffedData.append(BIT_FLAG);
        return stuffedData.toString();
    }
    public static String bitDeStuffing(String stuffedData) {
        StringBuilder destuffedData = new StringBuilder();
        String data = stuffedData.substring(BIT_FLAG.length(), stuffedData.length() - BIT_FLAG.length());
        int consecutiveOnes = 0;
        for (int i = 0; i < data.length(); i++) {
            char bit = data.charAt(i);
            if (bit == '1') {
                consecutiveOnes++;
                destuffedData.append(bit);
                if (consecutiveOnes == 5) {
                    i++;
                    consecutiveOnes = 0;
                }
            } else {
                consecutiveOnes = 0;
                destuffedData.append(bit);
            }
        }
        return destuffedData.toString();
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the data for Character Stuffing:");
        String charData = sc.nextLine();
        String charStuffed = characterStuffing(charData);
        System.out.println("Character Stuffed Data: " + charStuffed);
        System.out.println("De-Stuffed Data: " + characterDeStuffing(charStuffed));
        System.out.println("\nEnter the data for Bit Stuffing (binary string):");
        String bitData = sc.nextLine();
        String bitStuffed = bitStuffing(bitData);
        System.out.println("Bit Stuffed Data: " + bitStuffed);
        System.out.println("De-Stuffed Data: " + bitDeStuffing(bitStuffed));
        sc.close();
    }
}
