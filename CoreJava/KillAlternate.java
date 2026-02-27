import java.util.*;

public class KillAlternate {
    public static int findWinner(int n, int k) {
        List<Integer> players = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            players.add(i);
        }

        int index = 0;

        while (players.size() > 1) {
            index = (index + k - 1) % players.size();
            players.remove(index);
        }

        return players.get(0);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        System.out.println(findWinner(n, k));
    }
}
