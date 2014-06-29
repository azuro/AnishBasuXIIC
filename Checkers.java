import java.util.*;
class Checkers{
    public static void main(String[] args){
        System.out.println("Checkers:");
        Scanner in = new Scanner(System.in).useDelimiter("[,\\s]+");
        Point mP = new Point(in.nextInt(),in.nextInt());
        Point[] enemies = new Point[in.nextInt()];
        for(int i = 0; i < enemies.length; i++){
            enemies[i] = new Point(in.nextInt(), in.nextInt());
        }
        System.out.print("Jumps Possible: "+jumpsPossible(mP, enemies));
    }
    private static int jumpsPossible(Point cPoint, Point[] nearestPoint){
        int ret = 0;
        for(int i=0;i<nearestPoint.length;i++){
            nearestPoint = sortByNearest(i,cPoint,nearestPoint);
            int jpPt = -1;
            for(int j=i;j<nearestPoint.length;j++){
                if(getEuclideanDist(nearestPoint[j], cPoint)==Math.sqrt(2)){
                    jpPt = j;
                    ret++;
                    break;
                }
            }
            if(jpPt==-1){
                return ret;
            }
            cPoint = nearestPoint[jpPt].mirror(cPoint);
        }
        return ret;
    }
    private static double getEuclideanDist(Point p1,Point p2){
        return Math.sqrt(Math.pow(p1.x-p2.x,2)+Math.pow(p1.y-p2.y,2));
    }
    private static Point[] sortByNearest(int start,Point cPoint, Point[] nearestPoint){
        for(int i=start;i<nearestPoint.length;i++){
            int min = i;
            for(int j=i;j<nearestPoint.length;j++){
                if(getEuclideanDist(cPoint,nearestPoint[j])<getEuclideanDist(cPoint,nearestPoint[min])){
                    min = j;
                }
            }
            Point tmp = nearestPoint[i];
            nearestPoint[i] = nearestPoint[min];
            nearestPoint[min] = tmp;
        }
        return nearestPoint;
    }
    
}
class Point{
        public int x,y;
        Point(int x, int y){
            this.x = x;
            this.y = y;
        }
        public Point mirror(Point p2){
            return new Point(p2.x+2*(this.x-p2.x),p2.y+2*(this.y-p2.y));
        }
        @Override
        public String toString(){
            return "("+x+","+y+")";
        }
}
/*
 * Checkers:
 * 1, 5, 3, 2, 6, 4, 6, 6, 6
 * Jumps Possible: 3
 */