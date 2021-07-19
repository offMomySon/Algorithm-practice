import java.io.*;
import java.util.*;

public class Main {
    private static FastReader fr = new FastReader();
    private static StringBuilder sb = new StringBuilder();
    private static int SIZE;
    private static Point cur_point;
    private static Point des_point;
    private static boolean[][] visited;
    private static int[][] count;
    private static int[][] dirs = {{-1,-2},{-2,-1},{-2,1},{-1,2},{1,2},{2,1},{2,-1},{1,-2}};

    private static void input(){
        SIZE = fr.nextInt();

        visited = new boolean[SIZE][SIZE];
        count = new int[SIZE][SIZE];

        int temp_row = fr.nextInt();
        int temp_col = fr.nextInt();
        cur_point = new Point(temp_row, temp_col);

        temp_row = fr.nextInt();
        temp_col = fr.nextInt();
        des_point = new Point(temp_row, temp_col);
    }

    private static void bfs(Point start_point){
        Queue<Point> q = new LinkedList<>();
        q.add(start_point);

        visited[start_point.row][start_point.col] = true;
        count[start_point.row][start_point.col] = 0;

        while(!q.isEmpty()){
            Point cur_point = q.poll();
            if(cur_point.row == des_point.row && cur_point.col == des_point.col) return;

            for(int[] dir : dirs){
                int next_row = cur_point.row + dir[0];
                int next_col = cur_point.col + dir[1];

                if( next_row < 0 || next_row >= SIZE || next_col < 0 || next_col >= SIZE ) continue;
                if( visited[next_row][next_col] ) continue;

                count[next_row][next_col] = count[cur_point.row][cur_point.col] + 1;
                visited[next_row][next_col] = true;
                q.add(new Point(next_row,next_col));
            }
        }
    }

    private static void pro(){
        bfs(cur_point);
        sb.append(count[des_point.row][des_point.col]).append("\n");
    }

    public static void main(String[] args) {
        int T = fr.nextInt();
        for (int i = 0; i < T; i++) {
            input();
            pro();
        }
        System.out.println(sb.toString());
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
            while(st == null || !st.hasMoreElements()){
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


class Point{
    int row, col;

    public Point(int _row, int _col){
        row = _row;
        col = _col;
    }
}
