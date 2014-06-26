import java.util.*;
class WordSwap{
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        System.out.println("WordSwap:(Positive = Earn, Negative = Lose)");
        int n = in.nextInt();
        for(int i=0;i<n;i++){
            System.out.println(costToSwap(in.next(),in.next()));
        }
    }
    static int costToSwap(String from, String to){
        int ret = 0;
        for(int i=0;i<from.length();i++){
            ret+=(from.charAt(i) - to.charAt(i));
        }
        return ret;
    }
}