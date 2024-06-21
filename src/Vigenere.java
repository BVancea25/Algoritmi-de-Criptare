public class Vigenere implements Algorithm{

    public Vigenere(){}

    public Vigenere(String key,String phrase){
        this.key=key;
        this.phrase=phrase;
    }
    private String key;
    private String phrase;
    @Override
    public String encrypt() {
        StringBuilder encryptedText = new StringBuilder();
        int j = 0;

        for (char charText : phrase.toCharArray()) {
            if (Character.isLetter(charText)) {
                int shift = key.charAt(j % key.length()) - 'A';
                char newChar = (char) ((charText + shift - 'A' + 26) % 26 + 'A');
                encryptedText.append(newChar);
                j++;
            } else {
                encryptedText.append(charText);
            }
        }

        return encryptedText.toString();

    }

    @Override
    public String decrypt() {

        StringBuilder decryptedText = new StringBuilder();
        int j = 0;

        for (char charText : phrase.toCharArray()) {
            if (Character.isLetter(charText)) {
                int shift = key.charAt(j % key.length()) - 'A';
                char newChar = (char) ((charText - shift + 'A') % 26 + 'A');
                decryptedText.append(newChar);
                j++;
            } else {
                decryptedText.append(charText);
            }
        }

        return decryptedText.toString();
    }



    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getPhrase() {
        return phrase;
    }

    public void setPhrase(String phrase) {
        this.phrase = phrase;
    }
}
