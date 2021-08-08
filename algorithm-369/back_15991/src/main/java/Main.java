import java.io.*;
import java.util.StringTokenizer;

public class Main {
    private static FastReader fr = new FastReader();
    private static StringBuilder sb = new StringBuilder();
    private static long[] dp;
    private static int N,TIME;

    public static void input(){
        TIME = fr.nextInt();
        dp = new long[1000000+1];

        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 2;
        dp[4] = 3;
        dp[5] = 3;
        dp[6] = 6;
        dp[7] = 6;
    }

    public static void pro(){
        for (int i = 8; i <= 1000000; i++) {
            dp[i] = (dp[i-2]+dp[i-4]+dp[i-6])%1000000009;
        }
    }

    public static void main(String[] args) {
        input();
        pro();

        for (int i = 0; i < TIME; i++) {
            N = fr.nextInt();
            sb.append(dp[N]).append("\n");
        }

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


