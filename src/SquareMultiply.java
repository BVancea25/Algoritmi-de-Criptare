import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SquareMultiply {
    private int base;
    private int power;

    public SquareMultiply() {
    }

    public BigInteger squareAndMultiply() {
        BigInteger result=new BigInteger(String.valueOf(this.base));
        int[] exponentBytes = convertToByteArray(this.power);
        int squares=0;
        int multiplications=0;
        for (int i = 1; i < exponentBytes.length; i++) {
            if (exponentBytes[i] == 0) {
                result=result.multiply(result);
                squares++;
            } else {
                result=result.multiply(result).multiply(BigInteger.valueOf(this.base));
                squares++;
                multiplications++;
            }
        }
        System.out.println("Needed "+multiplications+" multiplications and "+squares+" squares");
        return result;
    }

    public int[] convertToByteArray(int decimal) {
        if (decimal == 0) {
            return new int[]{0};
        }

        ArrayList<Integer> binaryList = new ArrayList<>();

        while (decimal > 0) {
            int remainder = decimal % 2;
            binaryList.add(remainder);
            decimal /= 2;
        }

        // Reverse the list to get the correct binary representation
        Collections.reverse(binaryList);

        // Convert ArrayList to array
        int[] binaryArray = new int[binaryList.size()];
        for (int i = 0; i < binaryList.size(); i++) {
            binaryArray[i] = binaryList.get(i);
        }

        return binaryArray;
    }



    public int getPower() {
        return power;
    }

    public void setPower(int power) {
        this.power = power;
    }

    public int getBase() {
        return base;
    }

    public void setBase(int base) {
        this.base = base;
    }
}
