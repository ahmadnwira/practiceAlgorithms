import java.util.Scanner;

public class DirectAccessDemo {
    public static void main(String[] args) {
        DirectAccess dict = new DirectAccess();

        Scanner s = new Scanner(System.in);
        int quries = s.nextInt();

        for(int i=0; i<quries; i++) {
            String query = s.next();
            int number = s.nextInt();

            switch (query) {
                case "add":
                    String name = s.next();
                    dict.add(number, name);
                    break;
                case "find":
                    System.out.printf("%s \n", dict.find(number));
                    break;
                case "del":
                    dict.del(number);
                    break;
                default:
                    break;
            }
        }
        s.close();
    }
}