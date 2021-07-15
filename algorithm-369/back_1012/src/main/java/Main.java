import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static FastReader fb = new FastReader();
    public static StringBuilder sb = new StringBuilder();
    public static int T;
    public static int N,M, K;
    public static int[][] map;
    public static boolean[][] visited;
    public static int[][] dirs= {{-1, 0},{0, 1}, {1, 0}, {0,-1}};

    public static void input(){
        M = fb.nextInt();
        N = fb.nextInt();
        K = fb.nextInt();

        map = new int[N+1][M+1];
        visited = new boolean[N+1][M+1];

        for (int i = 0; i < K; i++) {
            int col = fb.nextInt();
            int row = fb.nextInt();

            map[row][col] = 1;
        }
    }

    public static void dfs(int row, int col){
        visited[row][col] = true;

        for(int[] dir : dirs){
            int nextRow = row + dir[0];
            int nextCol = col + dir[1];

            if(nextRow < 0 ||  nextRow > N || nextCol <0 || nextCol > M) continue;
            if(map[nextRow][nextCol] == 0) continue;
            if(visited[nextRow][nextCol]) continue;

            dfs(nextRow, nextCol);
        }
    }

    public static void prob(){
        int count =0 ;

        for (int col = 0; col < M; col++) {
            for (int row = 0; row < N; row++) {
                if(map[row][col] == 0) continue;
                if(visited[row][col]) continue;

                count++;
                dfs(row,col);
            }
        }

        System.out.println(count);
    }

    public static void main(String[] args) {

        T = fb.nextInt();
        for (int i = 0; i < T; i++) {
            input();
            prob();
        }
    }

    public static class FastReader{
        private StringTokenizer st;
        private BufferedReader bf;

        public FastReader() {
            bf = new BufferedReader(new InputStreamReader(System.in));
        }
        public FastReader(String f) throws FileNotFoundException {
            bf = new BufferedReader(new FileReader(new File(f)));
        }

        public String next(){
            while(st == null || !st.hasMoreElements()){
                try {
                    st = new StringTokenizer(bf.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        public String nextLine(){
            String str = "";
            try {
                str = bf.readLine();
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
