import java.util.Arrays;

public class Hill implements Algorithm{

    private final double[][] matrix= {{1,2,3},{3,1,2},{1,3,1}};

    private final double[][] inverseMatrix={{-5d,1d,3d},{-1d,0d,1d},{8d,-1d,-5d}};
    private String phrase;

    public Hill(){

    }

    private int[] convertBlockToNumbers(String block) {
        int[] charVector = new int[block.length()];
        for (int i = 0; i < block.length(); i++) {
            charVector[i] = block.charAt(i) - 'A';
        }
        return charVector;
    }

    private int[] multiplyMatrixVector(double[][] matrix, int[] vector) {
        int[] result = new int[matrix.length];
        System.out.println(Arrays.toString(vector));
        for (int i = 0; i < matrix.length; i++) {
            int sum = 0;
            for (int j = 0; j < matrix[i].length; j++) {
                sum += matrix[i][j] * vector[j];
                System.out.println("Matrix value:"+matrix[i][j]+" vector value"+vector[j]);
            }

            result[i] = sum % 26; // Modulo 26 to stay within alphabet range (0-25)

        }
        return result;
    }



    private  String convertNumbersToChars(int[] numbers) {
        StringBuilder sb = new StringBuilder();
        for (int number : numbers) {
            sb.append((char) (number + 'A'));
        }
        return sb.toString();
    }
    @Override
    public String encrypt() {
        StringBuilder encryptedMessage = new StringBuilder();

        // Validate key matrix size


        int blockSize = matrix.length;

        // Process message in blocks
        for (int i = 0; i < phrase.length(); i += blockSize) {
            int[] charVector = convertBlockToNumbers(phrase.substring(i, Math.min(i + blockSize, phrase.length())));

            int[] encryptedBlock = multiplyMatrixVector(matrix, charVector);
            encryptedMessage.append(convertNumbersToChars(encryptedBlock));
        }

        return encryptedMessage.toString();
    }

    @Override
    public String decrypt() {
        StringBuilder decryptedMessage = new StringBuilder();



        int blockSize = inverseMatrix.length;

        // Process ciphertext in blocks
        for (int i = 0; i < phrase.length(); i += blockSize) {
            int[] cipherVector = convertBlockToNumbers(phrase.substring(i, Math.min(i + blockSize, phrase.length())));
            System.out.println(Arrays.toString(cipherVector));
            int[] decryptedBlock = multiplyMatrixVector(inverseMatrix, cipherVector);
            decryptedMessage.append(convertNumbersToChars(decryptedBlock));
        }

        return decryptedMessage.toString();
    }

    public String getPhrase() {
        return phrase;
    }

    public void setPhrase(String phrase) {
        this.phrase = phrase;
    }
}
