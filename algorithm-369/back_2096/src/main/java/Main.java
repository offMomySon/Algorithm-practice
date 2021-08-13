import java.io.*;
import java.util.StringTokenizer;

//날짜 - 2021/08/11
//시작 - 19:14
//종료 - 02:30
//실수 -
//참조 -

public class Main {
    private static FastReader fr = new FastReader();
    private static StringBuilder sb = new StringBuilder();
    private static int[][] max_dp;
    private static int[][] min_dp;
    private static int[][] map;
    private static int N;


    public static void input(){
        N = fr.nextInt();

        max_dp = new int[N+1][3];
        min_dp = new int[N+1][3];
        map = new int[N+1][3];

        for (int i = 1; i <= N ; i++){
            map[i][0] = fr.nextInt();
            map[i][1] = fr.nextInt();
            map[i][2] = fr.nextInt();
        }

        max_dp[1][0] =map[1][0];
        max_dp[1][1] =map[1][1];
        max_dp[1][2] =map[1][2];

        min_dp[1][0] =map[1][0];
        min_dp[1][1] =map[1][1];
        min_dp[1][2] =map[1][2];
    }

    public static void pro(){
        for (int i = 2; i <= N; i++) {
            max_dp[i][0] = Math.max(max_dp[i-1][0], max_dp[i-1][1])+map[i][0];
            min_dp[i][0] = Math.min(min_dp[i-1][0], min_dp[i-1][1])+map[i][0];

            max_dp[i][1] = Math.max(Math.max(max_dp[i-1][0], max_dp[i-1][1]),max_dp[i-1][2]) + map[i][1];
            min_dp[i][1] = Math.min(Math.min(min_dp[i-1][0], min_dp[i-1][1]),min_dp[i-1][2]) + map[i][1];

            max_dp[i][2] = Math.max(max_dp[i-1][2], max_dp[i-1][1])+map[i][2];
            min_dp[i][2] = Math.min(min_dp[i-1][2], min_dp[i-1][1])+map[i][2];
        }

        sb.append(Math.max(Math.max(max_dp[N][0], max_dp[N][1]),max_dp[N][2])).append(" ");
        sb.append(Math.min(Math.min(min_dp[N][0], min_dp[N][1]),min_dp[N][2]));

    }

    public static void main(String[] args) {
        input();
        pro();

        System.out.println(sb.toString());
    }

    public static class FastReader{
        private BufferedReader br;
        private StringTokenizer st;

        public FastReader(){
            br = new BufferedReader(new InputStreamReader(System.in));
        }
        public FastReader(String file) throws FileNotFoundException {
            br = new BufferedReader(new FileReader(new File(file)));
        }

        private String next(){
            while( st == null || !st.hasMoreElements()){
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
        public long nextLong(){
            return Long.parseLong(next());
        }
        public double nextDouble(){
            return Double.parseDouble(next());
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

