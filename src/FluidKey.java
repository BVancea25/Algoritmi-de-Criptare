import java.util.Arrays;

public class FluidKey implements Algorithm{

    private int key=5;
    private String phrase;



    public FluidKey(String phrase) {
        this.phrase = phrase;
    }

    public FluidKey(){}


    public void setPhrase(String phrase){
        this.phrase=phrase;
    }

    @Override
    public String encrypt() {
        StringBuilder encryptedMessage = new StringBuilder();
        int[] keyStream = generateKeyStream(key);
        int index = 0;

        for (char character : phrase.toCharArray()) {
            if (Character.isAlphabetic(character)) { // Check if it's an alphabet
                //System.out.println(keyStream[index] + " key " + character + " character ");
                int encryptedChar = encryptChar(character, keyStream[index]);
                //System.out.println(encryptedChar + " encrypted character");
                encryptedMessage.append(numberToChar(encryptedChar));
            }
            index++;
        }

        return encryptedMessage.toString();
    }
    private int[] generateKeyStream(int key) {
        int[] keyStream = new int[phrase.length()];
        keyStream[0] = key;
        for (int i = 1; i < keyStream.length; i++) {
            //verifica -1
            //keyStream[i] = (2 * keyStream[i - 1]+2) % 26;
           // System.out.println("2* "+keyStream[i-1]+" % 26 = "+keyStream[i]);
            keyStream[i] =keyStream[i-1];
        }
        return keyStream;
    }

    public char numberToChar(int number) {
        if (number < 0 || number > 25) {
            throw new IllegalArgumentException("Number must be between 0 and 25");
        }
        return (char) ('A' + number);
    }

    private int encryptChar(char character, int key) {
        int charValue = character - 'A';
        return   (3 * charValue + key) % 26 ;
    }

    private static int decryptChar(char character, int key) {
        int charValue = character - 'A';
        return (charValue - key + 26) % 26 ;
    }

    private int messageLength(int key) {
        String message = String.valueOf(key);
        return message.length();
    }
    @Override
    public String decrypt() {
        StringBuilder decryptedMessage = new StringBuilder();
        int[] keyStream = generateKeyStream(key);
        System.out.println(Arrays.toString(keyStream));
        int index = 0;

        for (char character : phrase.toCharArray()) {
            int decryptedChar = decryptChar(character, keyStream[index]);
            System.out.println(decryptedChar);
            decryptedMessage.append(numberToChar(decryptedChar));
            index++;
        }
        System.out.println(decryptedMessage);
        return decryptedMessage.toString();
    }
}
