import java.math.BigInteger;
import java.util.Scanner;

public class Interpretor {
    public Scanner scanner=new Scanner(System.in);
    public Interpretor(){}

    public void closeScanner(){
        this.scanner.close();
    }
    public void interpreteaza(String s){

        switch (s){
            case "caesar encrypt":
                handleCaesarEncrypt();
                break;
            case "caesar decrypt":
                handleCaesarDecrypt();
                break;
            case "vigenere encrypt":
                handleVigenereEncrypt();
                break;
            case "vigenere decrypt":
                handleVigenereDecrypt();
                break;
            case "playfair encrypt":
                handlePlayFairEncrypt();
                break;
            case "playfair decrypt":
                handlePlayFairDecrypt();
                break;
            case "fluid encrypt":
                handleFluidEncrypt();
                break;
            case "fluid decrypt":
                handleFluidDecrypt();
                break;
            case "hill encrypt":
                handleHillEncrypt();
                break;
            case "hill decrypt":
                handleHillDecrypt();
                break;
            case "affine encrypt":
                handleAffineEncrypt();
                break;
            case "affine decrypt":
                handleAffineDecrypt();
                break;
            case "square and multiply":
                handleSquareAndMultiply();
                break;
            case "discrete logarithm":
                handleDiscreteLogarithm();
                break;
        }
    }

    private void handleDiscreteLogarithm() {
        DiscreteLogarithm algo=new DiscreteLogarithm();

        System.out.println("Please enter a prime modulo");
        int mod=scanner.nextInt();
        scanner.nextLine();

        System.out.println("Please enter a generator");
        int g=scanner.nextInt();
        scanner.nextLine();

        System.out.println("Please enter a target");
        int t=scanner.nextInt();
        scanner.nextLine();

        algo.setBase(BigInteger.valueOf(g));
        algo.setModulo(BigInteger.valueOf(mod));
        algo.setTarget(BigInteger.valueOf(t));

        BigInteger result = algo.discreteLog();
        if (result != null) {
            System.out.println("The discrete logarithm is: " + result);
        } else {
            System.out.println("No solution found.");
        }

    }

    private void handleSquareAndMultiply() {
        SquareMultiply algo=new SquareMultiply();
        System.out.println("Please enter a base");
        int base=scanner.nextInt();
        scanner.nextLine();

        System.out.println("Please enter a power");
        int exponent=scanner.nextInt();
        scanner.nextLine();

        algo.setBase(base);
        algo.setPower(exponent);

        System.out.println("The result is : "+algo.squareAndMultiply().toString());
    }

    private void handleAffineDecrypt() {
        Affine algo=new Affine();
        System.out.println("Please enter the encrypted phrase");
        String phrase=scanner.nextLine();
        algo.setPhrase(phrase);

        System.out.println("The decrypted phrase is: "+algo.decrypt());
    }

    private void handleAffineEncrypt() {
        Affine algo=new Affine();
        System.out.println("Please enter a phrase");
        String phrase=scanner.nextLine();
        algo.setPhrase(phrase);

        System.out.println("The encrypted phrase is: "+algo.encrypt());
    }

    private void handleHillDecrypt() {
        Hill algo=new Hill();
        System.out.println("Please enter the encrypted phrase");
        String phrase=scanner.nextLine();
        algo.setPhrase(phrase);

        System.out.println("The decrypted phrase is: "+algo.decrypt());
    }

    private void handleHillEncrypt() {
        Hill algo=new Hill();
        System.out.println("Please enter a phrase");
        String phrase=scanner.nextLine();
        algo.setPhrase(phrase);

        System.out.println("The encrypted phrase is: "+algo.encrypt());
    }

    private void handleFluidDecrypt() {
        FluidKey algo=new FluidKey();

        System.out.println("Please enter a phrase");
        String phrase=scanner.nextLine();
        algo.setPhrase(phrase);

        System.out.println("The decrypted phrase is: "+algo.decrypt());
    }

    private void handleFluidEncrypt() {
        FluidKey algo=new FluidKey();

        System.out.println("Please enter a phrase");
        String phrase=scanner.nextLine();
        algo.setPhrase(phrase);

        System.out.println("The encrypted phrase is: "+algo.encrypt());
    }

    private void handlePlayFairDecrypt() {
        Playfair algo=new Playfair();

        System.out.println("Please enter the key");
        String key=scanner.nextLine();
        algo.setKey(key);

        System.out.println("Enter the encrypted phrase:");
        String phrase=scanner.nextLine();
        algo.setPhrase(phrase);

        System.out.println("The decrypted phrase is: "+algo.decrypt());
    }

    private void handlePlayFairEncrypt() {
        Playfair algo=new Playfair();

        System.out.println("Please enter a key in capital letters");
        String key=scanner.nextLine();
        algo.setKey(key);

        System.out.println("Enter a phrase in capital letters:");
        String phrase=scanner.nextLine();
        algo.setPhrase(phrase);

        System.out.println("The encrypted phrase is: "+algo.encrypt());
    }

    private void handleVigenereDecrypt() {
        Vigenere algo=new Vigenere();

        System.out.println("Please enter the key");
        String key=scanner.nextLine();
        algo.setKey(key);

        System.out.println("Enter the encrypted phrase");
        String phrase=scanner.nextLine();
        algo.setPhrase(phrase);

        System.out.println("The decrypted phrase is: "+algo.decrypt());
    }

    private void handleVigenereEncrypt() {
        Vigenere algo=new Vigenere();

        System.out.println("Please enter a key in capital letters");
        String key=scanner.nextLine();
        algo.setKey(key);

        System.out.println("Enter a phrase in capital letters:");
        String phrase=scanner.nextLine();
        algo.setPhrase(phrase);

        System.out.println("The encrypted phrase is: "+algo.encrypt());

    }

    private void handleCaesarEncrypt() {
        Caesar algo=new Caesar();

        System.out.println("Please enter a shift");


        int shift=scanner.nextInt();
        algo.setShift(shift);
        scanner.nextLine();
        System.out.println("Please enter a phrase to encrypt");

        String phrase=scanner.nextLine();
        algo.setPhrase(phrase);

        System.out.println("The encrypted phrase is: "+algo.encrypt());

    }

    private void handleCaesarDecrypt(){
        Caesar algo=new Caesar();
        System.out.println("Please enter the encrypted phrase");


        String phrase=scanner.nextLine();
        algo.setPhrase(phrase);

        System.out.println("Please enter the shift");
        int shift=scanner.nextInt();
        algo.setShift(shift);

        System.out.println("The decrypted phrase is: "+algo.decrypt());
    }
}
