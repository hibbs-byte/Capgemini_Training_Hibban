import java.util.*;

public class ValidBrackets {
    public static boolean check(String str){
        Stack<Character> st=new Stack<>();
        for(int i=0;i<str.length();i++){
            char ch=str.charAt(i);
            if(ch=='('||ch=='{'||ch=='[') st.push(ch);
            else{
                if(st.isEmpty()) return false;
                char top=st.pop();
                if(ch==')'&&top!='(') return false;
                if(ch=='}'&&top!='{') return false;
                if(ch==']'&&top!='[') return false;
            }
        }
        return st.isEmpty();
    }

    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        String s=sc.nextLine();
        System.out.println(check(s));
    }
}
