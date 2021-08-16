import java.io.*;
import java.util.StringTokenizer;

//날짜 - 2021/08/11
//시작 - 19:10
//종료 - 02:30
//실수 -
//참조 -

public class Main {
    private static FastReader fr = new FastReader();
    private static StringBuilder sb = new StringBuilder();
    private static long[][] dp;
    private static int N;

    public static void input(){
        N = fr.nextInt();

        dp = new long[10000+10][2];

        dp[1][0] = 0;
        dp[1][1] = 1;
    }

    public static void pro(){
        for (int i = 2; i <= N ; i++) {
            dp[i][0] = dp[i-1][1] + dp[i-1][0];
            dp[i][1] = dp[i-1][0];
        }

        System.out.println(dp[N][0] + dp[N][1]);
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

