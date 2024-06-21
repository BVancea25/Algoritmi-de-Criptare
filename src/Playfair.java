public class Playfair implements Algorithm{
    private String key;
    private String phrase;

    public Playfair(){}

    public Playfair(String key,String phrase){
        this.key=key;
        this.phrase=phrase;
    }

    @Override
    public String encrypt() {
        char[][] matrix = new char[5][5];
        int k = 0;
        char s = 'A';
        int i=0;
        int j=0;
        while(i< matrix.length){
            while (j<matrix.length){
                if (k < key.length()) {
                    matrix[i][j] = key.charAt(k);
                    k++;
                    j++;
                } else {
                    if (s == 'J' || inKey(s)) { // SKIP LETTER

                        s++;
                    }else {
                        matrix[i][j] = s;

                        j++;
                        s++;
                    }

                }

            }
            i++;
            j=0;
        }


        for (char[] rowArray : matrix) {

            System.out.println(rowArray);
        }


        if (phrase.length() % 2 != 0) {
            phrase += 'X';
        }

        String encrypted = "";

        for (int l = 0; l < phrase.length(); l += 2) {
            char m = phrase.charAt(l);
            char n = phrase.charAt(l + 1);

            if (m == n) {
                n = 'X';
                l--;
            }

            int xm = 0, ym = 0, xn = 0, yn = 0;

            for (int z = 0; z < matrix.length; z++) {
                for (int w = 0; w < matrix[z].length; w++) {
                    if (matrix[z][w] == m) {
                        xm = z;
                        ym = w;
                    }
                    if (matrix[z][w] == n) {
                        xn = z;
                        yn = w;
                    }
                }
            }

            if (xm == xn) {
                encrypted += matrix[xm][(ym + 1) % matrix.length];
                encrypted += matrix[xn][(yn + 1) % matrix.length];
            } else if (ym == yn) {
                encrypted += matrix[(xm + 1) % matrix.length][ym];
                encrypted += matrix[(xn + 1) % matrix.length][yn];
            } else {
                encrypted += matrix[xm][yn];
                encrypted += matrix[xn][ym];
            }

        }

        return  encrypted;

    }

    public boolean inKey(char letter){
        return key.indexOf(letter) != -1;
    }


    @Override
    public String decrypt() {
        char[][] matrix = new char[5][5];
        int k = 0;
        char s = 'A';
        int i=0;
        int j=0;
        while(i< matrix.length){
            while (j<matrix.length){
                if (k < key.length()) {
                    matrix[i][j] = key.charAt(k);
                    k++;
                    j++;
                } else {
                    if (s == 'J' || inKey(s)) { // SKIP LETTER
                        s++;
                    }else {
                        matrix[i][j] = s;
                        j++;
                        s++;
                    }

                }

            }
            i++;
            j=0;
        }
        if (phrase.length() % 2 != 0) {
            phrase += 'X';
        }

        String decrypted = "";

        for (int l = 0; l < phrase.length(); l += 2) {
            char m = phrase.charAt(l);
            char n = phrase.charAt(l + 1);
            int xm = 0, ym = 0, xn = 0, yn = 0;

            for (int z = 0; z < matrix.length; z++) {
                for (int w = 0; w < matrix[z].length; w++) {
                    if (matrix[z][w] == m) {
                        xm = z;
                        ym = w;
                    }
                    if (matrix[z][w] == n) {
                        xn = z;
                        yn = w;
                    }
                }
            }

            if (ym == yn) {
                decrypted += matrix[xm][(ym - 1 + matrix.length) % matrix.length];
                decrypted += matrix[xn][(yn - 1 + matrix.length) % matrix.length];
            } else if (xm == xn) {
                decrypted += matrix[(xm - 1 + matrix.length) % matrix.length][ym];
                decrypted += matrix[(xn - 1 + matrix.length) % matrix.length][yn];
            } else {
                decrypted += matrix[xm][yn];
                decrypted += matrix[xn][ym];
            }

        }

        return decrypted;
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
