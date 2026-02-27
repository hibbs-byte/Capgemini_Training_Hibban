import java.util.*;

public class LongestSubarray {
    public static void find(int[] arr, int k) {
        int maxLen = 0;
        int start = -1;
        int end = -1;

        for (int i = 0; i < arr.length; i++) {
            int sum = 0;
            for (int j = i; j < arr.length; j++) {
                sum += arr[j];
                if (sum == k) {
                    int len = j - i + 1;
                    System.out.println("Length: " + len);
                    if (len > maxLen) {
                        maxLen = len;
                        start = i;
                        end = j;
                    }
                }
            }
        }

        if (start != -1)
            System.out.println(start + " " + end);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i=0;i<n;i++) arr[i]=sc.nextInt();
        int k = sc.nextInt();
        find(arr, k);
    }
}
