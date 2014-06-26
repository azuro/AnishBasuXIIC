import java.util.*;
class Checkers{
    public static void main(String[] args){
        Scanner in = new Scanner(System.in).useDelimiter("[,]+");
        Point mP = new Point(in.nextInt(),in.nextInt());
        Point[] enemies = new Point[in.nextInt()];
        for(int i = 0; i < enemies.length; i++){
            enemies[i] = new Point(in.nextInt(), in.nextInt());
        }
        System.out.print("Jumps Possible: "+jumpsPossible(mp, enemies));
    }
    private static int jumpsPossible(Point cPoint, Point[] nearestPoint){
        
    }
    class Point{
        public int x,y;
        Point(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
}