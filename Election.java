import java.util.*;
class Election{
    int[] contestant = new int[4];
    boolean end;
    Scanner in;
    Election(){
       System.out.println("Election:");
       in = new Scanner(System.in);
    }
    public static void main(String[] args){
        Election election = new Election();
        election.start();
    }
    private void start(){
        this.end = false;
        while (!this.end){
            count_votes();
            declare_results();
        }
    }
    void count_votes(){
        int votes = in.nextInt();
        if(votes == -1){
            end = true;
            return;
        }
        for(int no = 0;no < contestant.length; no++){
            contestant[no] += votes>>no & 0x1;
        }
    }
    void declare_results(){
        int total = 0;
        for(int tally:contestant){
            total+=tally;
        }
        System.out.print("Vote Distribution: ");
        for(int tally: contestant){
            System.out.print((end?tally:Math.round(((double)tally/total)*100)+"%")+" ");
        }
        System.out.println(end?"\nTotal: "+total:"");
    }
}
/*
 * Election:
 * 1
 * Vote Distribution: 100% 0% 0% 0% 
 * 14
 * Vote Distribution: 25% 25% 25% 25% 
 * 7
 * Vote Distribution: 29% 29% 29% 14% 
 * 8
 * Vote Distribution: 25% 25% 25% 25% 
 * -1
 * Vote Distribution: 2 2 2 2 
 * Total: 8
 */