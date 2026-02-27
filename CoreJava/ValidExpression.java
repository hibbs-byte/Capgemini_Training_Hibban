import java.util.*;

public class ExpressionValidation {
    public static boolean valid(String s){
        Stack<Character> st=new Stack<>();
        if(s.length()==0) return false;

        if(!Character.isDigit(s.charAt(0))) return false;
        if(!Character.isDigit(s.charAt(s.length()-1))) return false;

        for(int i=0;i<s.length();i++){
            char ch=s.charAt(i);
            if(ch=='+'||ch=='-'||ch=='*'||ch=='/'){
                if(i>0){
                    char prev=s.charAt(i-1);
                    if(prev=='+'||prev=='-'||prev=='*'||prev=='/')
                        return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        String s=sc.nextLine();
        System.out.println(valid(s));
    }
}
