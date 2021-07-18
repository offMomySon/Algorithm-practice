import java.io.*;
import java.util.StringTokenizer;

public class Main {
    private static FastReader fr = new FastReader();
    private static StringBuilder sb = new StringBuilder();
    private static int N;
    private static int [][] map;
    private static int [][] ans;

    public static void input(){
        N = fr.nextInt();

        map = new int[N][N];
        ans = new int[N][N];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                map[i][j] = fr.nextInt();
            }
        }
    }


    private static void dfs(int startRow,int row, boolean isFirstStep){
        if(!isFirstStep) ans[startRow][row] = 1;

        for (int col = 0; col < map[row].length; col++) {
            if(map[row][col] == 0) continue;
            if(ans[startRow][col] == 1) continue;

            dfs(startRow, col,false);
        }
    }

    public static void pro(){
        for (int row = 0; row < N; row++) {
            dfs(row, row, true);
        }

        for (int row = 0; row < N; row++) {
            for (int col = 0; col < N; col++) {
                sb.append(ans[row][col]).append(" ");
            }
            sb.append("\n");
        }

        System.out.println(sb.toString());
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
