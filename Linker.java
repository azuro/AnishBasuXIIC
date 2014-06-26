import java.util.*;
class Linker{
    public static void main(String[] args){
        System.out.println("Linker:");
        Scanner in = new Scanner(System.in);
        Linker lnk = new Linker();
        int n = in.nextInt();
        in.nextLine();
        for(int i=0;i < n;i++){
            lnk.parseInput(in.nextLine());
        }
    }
    void parseInput(String x){
        Scanner sc = new Scanner(x);
        String[] dict = new String[sc.nextInt()];
        for(int i=0;i<dict.length;i++){
            dict[i] = sc.next();
        }
        String[] pairs = new String[sc.nextInt()*2];
        for(int i=0;i<pairs.length;i++){
            pairs[i] = sc.next();
        }
        for(int i=0;i<pairs.length;i+=2){
            linkWords(pairs[i],pairs[i+1],dict);
        }
    }
    protected void linkWords(String from, String to, String[] dictionary){
        dictionary = sortDict(dictionary);
        String out = linked(from, to, dictionary);
        System.out.println((out==null?("Cannot form word chain from "+from+" to "+to):out));
    }
    private String linked(String from, String to, String[] dict){
        String th = "";
        if(dx1(from,to)!='\0'){
            th = from + " -> " + to;
        }
        else{
            for(int i=0;i<dict.length;i++){
                if(!dict[i].isEmpty()&&dx1(from,dict[i])!='\0'){
                    String[] diction = dict.clone();
                    diction[i] = "";
                    String ret = linked(dict[i],to,diction);
                    if(ret!=null){
                        th = from+" -> "+ret;
                        break;
                    }
                }
            }
            if(th.isEmpty()){
                return null;
            }
        }
        return th;
    }
    protected String[] sortDict(String[] dict){
        for(int i=0;i<dict.length;i++){
            int min = i;
            for(int j = i+1;j<dict.length;j++){
                if(dict[j].compareTo(dict[min])<0){
                    min = j;
                }
            }
            String t = dict[min];
            dict[min] = dict[i];
            dict[i] = t;
        }
        return dict;
    }
    protected char dx1(String src,String target){
        int dx = 0;
        char fc = '\0';
        for(int i = 0;i < src.length(); i++){
            if(src.charAt(i)!=target.charAt(i)){
                if(dx==0){
                    fc = target.charAt(i);
                }
                dx++;
            }
        }
        dx+=target.length()-src.length();
        return dx==1?fc:'\0';
    }
}
/*
 * Output:
 * Linker:
 * 2
 * 6 abc abd acd bcd bdd xyz 2 abc bdd abc xyz
 * 10 man can con bow cow mow han ban bon how 1 man how 
 * abc -> abd -> acd -> bcd -> bdd
 * Cannot form word chain from abc to xyz
 * man -> ban -> bon -> bow -> how
 */