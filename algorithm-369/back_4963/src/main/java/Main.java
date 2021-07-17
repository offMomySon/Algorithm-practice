import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static FastReader fr = new FastReader();
    public static StringBuilder sb = new StringBuilder();
    public static int W, H;
    public static int[][] map;
    public static boolean[][] visited;
    public static int[][] dirs = {{-1,0},{-1,1},{0,1},{1,1},{1,0},{1,-1},{0,-1},{-1,-1}};

    public static void input(){
        map = new int[H][W];
        visited = new boolean[H][W];

        for (int i = 0; i < H; i++) {
            for (int j = 0; j < W; j++) {
                map[i][j] = fr.nextInt();
            }
        }
    }


    public static void dfs(int row, int col){
        visited[row][col] = true;

        for(int[] dir : dirs){
            int nextRow = row + dir[0];
            int nextCol = col + dir[1];

            if(nextRow < 0 || nextRow >= H || nextCol < 0 || nextCol >= W) continue;
            if(map[nextRow][nextCol] == 0) continue;
            if(visited[nextRow][nextCol]) continue;

            dfs(nextRow, nextCol);
        }
    }

    public static void pro(){
        int count = 0;

        for (int i = 0; i < W; i++) {
            for (int j = 0; j < H; j++) {
                if(map[j][i]== 0) continue;
                if(visited[j][i]) continue;
                count++;
                dfs(j, i);
            }
        }

        sb.append(count).append("\n");
    }

    public static void main(String[] args) {
        while(true){
            W = fr.nextInt();
            H = fr.nextInt();

            if(W== 0 && H == 0) break;

            input();
            pro();
        }

        System.out.println(sb.toString());
    }

    static class FastReader{
        BufferedReader bf;
        StringTokenizer st;

        public FastReader(){
            bf = new BufferedReader(new InputStreamReader(System.in));
        }
        public FastReader(String f) throws FileNotFoundException {
            bf = new BufferedReader(new FileReader(new File(f)));
        }

        public String next(){
            while( st == null || !st.hasMoreElements()){
                try {
                    st = new StringTokenizer(bf.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            return st.nextToken();
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
        public String nextLine(){
            String str = "";
            try {
                str = bf.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }

    }
}
