import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Point{
    int height;
    int row;
    int col;

    public Point(int height, int row, int col) {
        this.height = height;
        this.row = row;
        this.col = col;
    }
}

public class Main {
    public static FastReader fr = new FastReader();
    public static int[][][] map;
    public static boolean[][][] visited;
    public static int[][][] distance;
    public static int ROW,COL,HEIGHT;
    public static int[][]dirs = {{1,0,0},{-1,0,0},{0,1,0},{0,-1,0},{0,0,1},{0,0,-1}};

    public static void input(){
        COL = fr.nextInt();
        ROW = fr.nextInt();
        HEIGHT = fr.nextInt();

        map = new int[ROW][COL][HEIGHT];
        visited = new boolean[ROW][COL][HEIGHT];
        distance = new int[ROW][COL][HEIGHT];

        for (int h = 0; h < HEIGHT; h++) {
            for (int row = 0; row < ROW; row++) {
                for (int col = 0; col < COL ; col++) {
                    map[row][col][h] = fr.nextInt();
                }
            }
        }
    }

    public static void bfs(){
        Queue<Point> q = new LinkedList<>();

        for (int h = 0; h < HEIGHT; h++) {
            for (int row = 0; row < ROW; row++) {
                for (int col = 0; col < COL ; col++) {
                    if(map[row][col][h] == 1){
                        q.add(new Point(h,row,col));

                        visited[row][col][h] = true;
                        distance[row][col][h] = 0;
                    }
                }
            }
        }

        while(!q.isEmpty()){
            Point point = q.poll();

            for(int[] dir:dirs){
                int next_row = point.row + dir[0];
                int next_col = point.col + dir[1];
                int next_height = point.height + dir[2];

                if(next_row <0 ||next_row>=ROW || next_col < 0 || next_col >= COL || next_height <0 || next_height >= HEIGHT) continue;
                if(map[next_row][next_col][next_height] == -1) continue;
                if(visited[next_row][next_col][next_height]) continue;

                q.add(new Point(next_height,next_row,next_col));
                visited[next_row][next_col][next_height] = true;
                distance[next_row][next_col][next_height] = distance[point.row][point.col][point.height] + 1;
            }
        }
    }

    public static void pro(){
        bfs();

        int ans = 0;
        for (int h = 0; h < HEIGHT; h++) {
            for (int row = 0; row < ROW; row++) {
                for (int col = 0; col < COL ; col++) {
                    if(map[row][col][h] != -1 && !visited[row][col][h]){
                        System.out.println("-1");
                        return;
                    }
                    ans = Math.max(ans, distance[row][col][h]);
                }
            }
        }
        System.out.println(ans);
    }

    public static void main(String[] args) {
        input();
        pro();
    }



    static class FastReader{
        private StringTokenizer st;
        private BufferedReader br;

        public FastReader() {
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

        public int nextInt(){
            return Integer.parseInt(next());
        }

        public double nextDouble(){
            return Double.parseDouble(next());
        }

        public long nextLong(){
            return Long.parseLong(next());
        }

        public String nextLine(){
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
