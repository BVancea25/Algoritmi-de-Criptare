public class Affine implements Algorithm{
    private final int a=3;
    private final int b=10;

    private String phrase;
    public Affine(){}
    @Override
    public String encrypt() {
        StringBuilder encryptedMessage = new StringBuilder();
        for (char c : phrase.toCharArray()) {
            int charValue = c - 'A'; // Convert character to numerical value (0-25)
            int encryptedValue = (a * charValue + b) % 26; // Apply encryption formula
            encryptedMessage.append((char) (encryptedValue + 'A')); // Convert back to character
        }
        return encryptedMessage.toString();
    }

    @Override
    public String decrypt() {
        StringBuilder decryptedMessage = new StringBuilder();
        for (char c : phrase.toCharArray()) {
            int charValue = c - 'A'; // Convert character to numerical value (0-25)
            int decryptedValue = (charValue - 10 ) * 9 % 26; // Apply decryption formula
            decryptedMessage.append((char) (decryptedValue + 'A')); // Convert back to character
        }
        return decryptedMessage.toString();
    }

    public void setPhrase(String phrase) {
        this.phrase = phrase;
    }

    public String getPhrase() {
        return phrase;
    }
}
