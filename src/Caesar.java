import java.util.Objects;

public class Caesar implements Algorithm{

    private int shift;
    private String phrase;
    public Caesar(){}
    public Caesar(int shift,String phrase){
        this.shift=shift;
        this.phrase=phrase;
    }

    public void setShift(int shift) {
        this.shift = shift;
    }

    public void setPhrase(String phrase){
        this.phrase=phrase;
    }

    public int getShift(){
       return this.shift;
    }

    public String getPhrase(){
        return this.phrase;
    }

    @Override
    public String encrypt() {
        String e = "";
        for (int i = 0; i < phrase.length(); i++) {
            if (Objects.equals(String.valueOf(phrase.charAt(i)), " ")) {
                e += " ";
            } else {
                int c = (int) phrase.charAt(i);
                c += shift;
                if (c > 90) {
                    int d = c - 90;
                    c = 65 + d;

                }
                e += String.valueOf((char) c);
            }
        }
        return e;
    }

    @Override
    public String decrypt() {
        String d = "";
        for (int i = 0; i < phrase.length(); i++) {
            if (Objects.equals(String.valueOf(phrase.charAt(i)), " ")) {
                d += " ";
            } else {
                int c = (int) phrase.charAt(i);
                c -= shift;
                if (c < 65) {
                    int diff = 65 - c;
                    c = 91 - diff;
                }
                d += String.valueOf((char) c);
            }
        }
        return d;
    }
}
