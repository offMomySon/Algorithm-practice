import java.io.*;
import java.util.StringTokenizer;

public class Main {
    private static FastReader fr = new FastReader();
    private static StringBuilder sb = new StringBuilder();
    private static long[] p;
    private static long[] dp;
    private static int N;

    public static void input(){
        N = fr.nextInt();
        dp = new long[N+1];
        p = new long[N+1];

        for (int i = 1; i <=N ; i++) {
            p[i] = fr.nextInt();
        }
    }

    public static void pro(){
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= i; j++) {
                dp[i] = Math.max(dp[i-j]+p[j] , dp[i]);
            }
        }

        System.out.println(dp[N]);
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


