import java.io.*;
import java.util.StringTokenizer;

public class Main {
    private static FastReader fr = new FastReader();
    private static StringBuilder sb = new StringBuilder();
    private static int[][] home;
    private static int[][] dp;
    private static int N;

    public static void input(){
        N = fr.nextInt();

        home = new int[1000+10][3];
        dp = new int[1000+10][3];

        for (int i = 1; i <=N ; i++) {
            home[i][0] = fr.nextInt();
            home[i][1] = fr.nextInt();
            home[i][2] = fr.nextInt();
        }

        dp[1][0] = home[1][0];
        dp[1][1] = home[1][1];
        dp[1][2] = home[1][2];
    }

    public static void pro(){
        for (int i = 2; i <= N ; i++) {
            dp[i][0] = Math.min(dp[i-1][1], dp[i-1][2]) + home[i][0];
            dp[i][1] = Math.min(dp[i-1][0], dp[i-1][2]) + home[i][1];
            dp[i][2] = Math.min(dp[i-1][0], dp[i-1][1]) + home[i][2];
        }

        System.out.println( Math.min(Math.min(dp[N][0], dp[N][1]),dp[N][2]) );
    }

    public static void main(String[] args) {
        input();
        pro();
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

