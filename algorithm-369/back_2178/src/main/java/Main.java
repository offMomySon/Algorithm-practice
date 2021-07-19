import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Point{
    int row;
    int col;

    public Point(int _row, int _col){
        row = _row;
        col = _col;
    }
}

public class Main {
    private static FastReader fr = new FastReader();
    private static StringBuilder sb = new StringBuilder();
    private static int ROW, COL;
    private static String[] map;
    private static boolean[][] visited;
    private static int[][] distance;
    private static int[][] dirs = {{-1,0}, {0,1}, {1,0}, {0,-1}};

    private static void input(){
        ROW = fr.nextInt();
        COL = fr.nextInt();

        map = new String[ROW];

        for (int i = 0; i < ROW; i++) {
            map[i] = fr.nextLine();
        }

        visited = new boolean[ROW][COL];
        distance = new int[ROW][COL];
    }

    private static void bfs(Point start_point){
        Queue<Point> q = new LinkedList<>();
        q.add(start_point);
        visited[start_point.row][start_point.col] = true;
        distance[start_point.row][start_point.col] = 1;

        while (!q.isEmpty()){
            Point cur_point = q.poll();

            for(int dir[]: dirs){
                int next_row = cur_point.row + dir[0];
                int next_col = cur_point.col + dir[1];

                if(next_row<0 || next_row >= ROW || next_col<0 || next_col>= COL) continue;
                if(map[next_row].charAt(next_col) != '1') continue;
                if(visited[next_row][next_col]) continue;

                q.add(new Point(next_row, next_col));
                visited[next_row][next_col] = true;
                distance[next_row][next_col] = distance[cur_point.row][cur_point.col]+1;
            }
        }

    }

    private static void pro(){
        bfs(new Point(0,0));

        System.out.println(distance[ROW-1][COL-1]);
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

        public String next(){
            while( st == null || !st.hasMoreElements()){
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
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
        public int nextInt(){
            return Integer.parseInt(next());
        }
        public long nextLong(){
            return Long.parseLong(next());
        }
        public double nextDouble(){
            return Double.parseDouble(next());
        }
    }
}
