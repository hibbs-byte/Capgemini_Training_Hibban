import java.util.*;

public class CountDigits {
    public static int count(int num) {
        int c = 0;
        if (num == 0) return 1;
        if (num < 0) num = -num;

        while (num > 0) {
            num = num / 10;
            c++;
        }
        return c;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println(count(n));
    }
}
