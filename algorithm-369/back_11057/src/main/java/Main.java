import java.io.*;
import java.util.StringTokenizer;

//날짜 - 2021/08/11
//시작 - 20:22
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

        dp = new long[1001][10];

        dp[1][0] = 1;
        dp[1][1] = 1;
        dp[1][2] = 1;
        dp[1][3] = 1;
        dp[1][4] = 1;
        dp[1][5] = 1;
        dp[1][6] = 1;
        dp[1][7] = 1;
        dp[1][8] = 1;
        dp[1][9] = 1;
    }

    public static void pro(){
        for (int i = 2; i <=N ; i++) {
            for (int j = 0; j <= 9; j++) {
                for (int inner = 0; inner <=j ; inner++) {
                    dp[i][j] = (dp[i][j] + dp[i-1][inner] )%10007;
                }
            }
        }

        long sum = 0;
        for (int i = 0; i < 10; i++) {
            sum = (sum+dp[N][i])%10007;
        }
        System.out.println(sum);
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

