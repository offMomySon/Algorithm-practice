import java.io.*;
import java.util.*;

class Point{
    int row,col;
    public Point(int _row, int _col){
        row = _row;
        col = _col;
    }
}

public class Main {
    public static FastReader fr = new FastReader();
    public static StringBuilder sb = new StringBuilder();
    private static int ROW,COL;
    private static String[] map;
    private static boolean[][] visited;
    private static int[][] dist_water;
    private static int[][] dist_hedgehog;
    private static int count = 0;
    private static int[][] dirs = {{-1,0},{0,1},{1,0},{0,-1}};

    public static void input(){
        ROW = fr.nextInt();
        COL = fr.nextInt();

        map = new String[ROW];
        visited = new boolean[ROW][COL];
        dist_water = new int[ROW][COL];
        dist_hedgehog = new int[ROW][COL];

        for (int i = 0; i < ROW; i++) {
            map[i] = fr.nextLine();
        }
    }
//
//    public static boolean bfs(Point hedgehog, List<Point> waters){
//        Queue<Point> hq= new LinkedList<>();
//        Queue<Point> wq = new LinkedList<>();
//
//        hq.add(hedgehog);
//        visited[hedgehog.row][hedgehog.col] = 1;
//
//        for(Point water:waters){
//            wq.add(water);
//            visited[water.row][water.col] = 2;
//        }
//
//        while (!hq.isEmpty() || !wq.isEmpty()){
//            List<Point> temp_waters = new LinkedList<>();
//
//            while (!wq.isEmpty()){
//                Point cur_water_pos = wq.poll();
//                for(int[] dir: dirs){
//                    int n_row = cur_water_pos.row + dir[0];
//                    int n_col = cur_water_pos.col + dir[1];
//
//                    if(n_row<0 || n_row>=ROW || n_col <0 || n_col >= COL) continue;
//                    if(map[n_row].charAt(n_col) == 'X' || map[n_row].charAt(n_col) == 'D') continue;
//                    if(visited[n_row][n_col] == 2) continue;
//
//                    visited[n_row][n_col] = 2;
//                    temp_waters.add(new Point(n_row,n_col));
//                }
//            }
//            wq.addAll(temp_waters);
//
//            List<Point> temp_hedgehogs = new LinkedList<>();
//            while (!hq.isEmpty()){
//                Point cur_hed_pos = hq.poll();
//                if(map[cur_hed_pos.row].charAt(cur_hed_pos.col) == 'D') return true;
//
//                for(int[] dir: dirs){
//                    int n_row = cur_hed_pos.row + dir[0];
//                    int n_col = cur_hed_pos.col + dir[1];
//
//                    if(n_row<0 || n_row>=ROW || n_col <0 || n_col >= COL) continue;
//                    if(map[n_row].charAt(n_col) == 'X') continue;
//                    if(visited[n_row][n_col] == 2 || visited[n_row][n_col] == 1) continue;
//
//                    visited[n_row][n_col] = 1;
//                    temp_hedgehogs.add(new Point(n_row,n_col));
//                    }
//                }
//                hq.addAll(temp_hedgehogs);
//
//                count++;
//            }
//
//            return false;
//        }
//
//        public static void pro(){
//            Point start = null;
//            List<Point> waters = new ArrayList<>();
//            for (int i = 0; i < ROW; i++) {
//                for (int j = 0; j < COL; j++) {
//                    if(map[i].charAt(j) == 'S') start = new Point(i,j);
//                    else if(map[i].charAt(j) == '*') waters.add(new Point(i,j));
//                }
//            }
//
//        boolean res = bfs(start, waters);
//
//        if(res){
//            System.out.println(count);
//        }else{
//            System.out.println("KAKTUS");
//        }
//
//
//    }

    public static void bfs_water(){
        Queue<Point> q = new LinkedList();

        for (int row = 0; row < ROW; row++) {
            for (int col = 0; col < COL; col++) {
                visited[row][col] = false;
                dist_water[row][col] = -1;

                if(map[row].charAt(col) == '*'){
                    visited[row][col] = true;
                    dist_water[row][col] = 0;

                    q.add(new Point(row,col));
                }
            }
        }

        while(!q.isEmpty()){
            Point poll = q.poll();

            for(int[] dir: dirs){
                int next_row = poll.row + dir[0];
                int next_col = poll.col + dir[1];

                if(next_row<0 || next_row>= ROW || next_col <0 || next_col >= COL) continue;
                if(map[next_row].charAt(next_col) != '.' ) continue;
                if(visited[next_row][next_col]) continue;

                q.add(new Point(next_row,next_col));
                visited[next_row][next_col] = true;
                dist_water[next_row][next_col] = dist_water[poll.row][poll.col] + 1;
            }
        }
    }

    public static void bfs_hedgehog(){
        Queue<Point> q  = new LinkedList<>();

        for (int row = 0; row < ROW; row++) {
            for (int col = 0; col < COL; col++) {
                visited[row][col] =false;
                dist_hedgehog[row][col] = -1;

                if(map[row].charAt(col) == 'S'){
                    visited[row][col] = true;
                    dist_hedgehog[row][col] = 0;
                    q.add(new Point(row,col));
                }
            }
        }

        while(!q.isEmpty()){
            Point point = q.poll();

            for(int[] dir: dirs){
                int next_row = point.row + dir[0];
                int next_col = point.col + dir[1];

                if(next_row<0 || next_row>= ROW || next_col <0 || next_col >= COL) continue;
                if(map[next_row].charAt(next_col) == 'X' || map[next_row].charAt(next_col) == '*' ) continue;
                if(dist_water[next_row][next_col] != -1 &&  dist_hedgehog[point.row][point.col] + 1 >= dist_water[next_row][next_col] ) continue;
                if(visited[next_row][next_col]) continue;

                q.add(new Point(next_row,next_col));
                visited[next_row][next_col] = true;
                dist_hedgehog[next_row][next_col] = dist_hedgehog[point.row][point.col] + 1;
            }

        }

    }

    public static void pro(){
        bfs_water();

        bfs_hedgehog();

        for (int i=0;i<ROW;i++){
            for (int j=0;j<COL;j++){
                if (map[i].charAt(j) == 'D'){
                    if (dist_hedgehog[i][j] == -1) System.out.println("KAKTUS");
                    else System.out.println(dist_hedgehog[i][j]);
                }
            }
        }
    }

    public static void main(String[] args) {
        input();
        pro();
    }

    static class FastReader{
        private BufferedReader br;
        private StringTokenizer st;

        public FastReader(){
            br = new BufferedReader(new InputStreamReader(System.in));
        }
        public FastReader(String f) throws FileNotFoundException {
            br = new BufferedReader(new FileReader(new File(f)));
        }

        private String next(){
            while(st == null || !st.hasMoreElements()){
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        private int nextInt(){
            return Integer.parseInt(next());
        }
        private long nextLong(){
            return Long.parseLong(next());
        }
        private double nextDouble(){
            return Double.parseDouble(next());
        }
        private String nextLine(){
            String str = "";
            try {
                str = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }

    }
}
