import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);

        Interpretor interpretor=new Interpretor();

        String s="";

        do{
            s=scanner.nextLine();
            interpretor.interpreteaza(s);
        }while(!s.equals("close"));

        scanner.close();
        interpretor.closeScanner();

    }
}