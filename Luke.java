import java.util.*;
public class Luke
{
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        System.out.print("Lucas-Carmichael Number: ");
        System.out.println((isLuke(in.nextInt())?"Is a Lucas-Carmichael number":"Is not a Lucas-Carmichael number"));
    }
    private static boolean isLuke(int n){
        List<Integer> factors = new ArrayList<Integer>();
        for(int i = 3; i < Math.sqrt(n);i+=2){
            if(n%i==0){
                if(!isPrime(i))
                    return false;
                factors.add(i);
            }
        }
        n+=1;
        for(int factor:factors){
            if(n%(factor+1)!=0)
                return false;
        }
        return true;
    }
    private static boolean isPrime(int n){
        if(n%2==0)
            return false;
        for(int i = 3; i < Math.sqrt(n); i+=2){
            if(n%i==0)
                return false;
        }
        return true;
    }
}
/*
 * Lucas-Carmichael Number: 935
 * Is a Lucas-Carmichael number
 * 
 */