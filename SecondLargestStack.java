import java.util.*;

public class SecondLargestStack {
    public static int second(Stack<Integer> st) {
        int first = Integer.MIN_VALUE;
        int second = Integer.MIN_VALUE;

        while(!st.isEmpty()){
            int x = st.pop();
            if(x > first){
                second = first;
                first = x;
            } else if(x > second && x != first){
                second = x;
            }
        }
        return second;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Stack<Integer> st = new Stack<>();
        for(int i=0;i<n;i++)
            st.push(sc.nextInt());
        System.out.println(second(st));
    }
}
