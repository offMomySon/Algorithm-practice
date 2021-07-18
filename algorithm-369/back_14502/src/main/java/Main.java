import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    private static FastReader fr = new FastReader();
    private static StringBuilder sb = new StringBuilder();
    private static int ROW, COL;
    private static int[][] map;
    private static boolean[][] visited;
    private static int ans = 0;
    private static ArrayList<Point> blank;
    private static ArrayList<Point> virus = new ArrayList<>();
    private static int[][] dirs = {{-1,0},{0,1},{1,0},{0,-1}};

    private static void input(){
        ROW = fr.nextInt();
        COL = fr.nextInt();

        map = new int[ROW][COL];
        visited = new boolean[ROW][COL];

        for (int i = 0; i < ROW; i++) {
            for (int j = 0; j < COL; j++) {
                map[i][j] = fr.nextInt();
            }
        }
    }

    private static void dfs(int select_cnt){
        if(select_cnt == 3){
            bfs();
            return;
        }

        for (int i = 0; i < ROW; i++) {
            for (int j = 0; j < COL; j++) {
                if(map[i][j] != 0) continue;

                map[i][j] = 1;
                dfs(select_cnt+1);
                map[i][j] = 0;
            }
        }
    }

    private static void bfs(){
        Queue<Point> q = new LinkedList<>();

        for (int i = 0; i < ROW; i++) {
            for (int j = 0; j < COL; j++) {
                visited[i][j] = false;
                if(map[i][j] == 2) {
                    q.add(new Point(i,j));
                    visited[i][j] = true;
                }
            }
        }

        while(!q.isEmpty()){
            Point cur_point = q.poll();
            int row = cur_point.row;
            int col = cur_point.col;

            for(int dir[] : dirs){
                int next_row = row + dir[0];
                int next_col = col + dir[1];

                if(next_row <0 || next_row >= ROW || next_col <0 || next_col>= COL) continue;
                if(map[next_row][next_col] != 0) continue;
                if(visited[next_row][next_col]) continue;

                visited[next_row][next_col] = true;
                q.add(new Point(next_row,next_col));
            }
        }


        int cnt = 0;
        for (int i = 0; i < ROW; i++) {
            for (int j = 0; j < COL; j++) {
                if(map[i][j] == 2 || map[i][j] == 1) continue;
                if(visited[i][j]) continue;
                cnt++;
            }
        }
        ans = Math.max(ans, cnt);
    }

    private static void dfs2(int idx, int select_cnt){
        if(select_cnt == 3){
            bfs();
            return;
        }
        if(idx >= blank.size()) return;

        for (int i = 0; i < blank.size(); i++) {
            Point point = blank.get(i);

            int row = point.row;
            int col = point.col;

            map[row][col] = 1;
            dfs2(i+1, select_cnt+1);

            map[row][col] = 0;
            dfs2(i+1, select_cnt);
        }

    }

    private static void pro2(){
        blank = new ArrayList<>();

        for (int i = 0; i < ROW; i++) {
            for (int j = 0; j < COL; j++) {
                if(map[i][j] == 0) blank.add(new Point(i,j));
            }
        }

        dfs2(0,0);
        System.out.println(ans);
    }

    private static void pro(){
        dfs(0);
        System.out.println(ans);
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
class Point{
    public int col;
    public int row;

    public Point(int row,int col){
        this.row = row;
        this.col = col;
    }
}