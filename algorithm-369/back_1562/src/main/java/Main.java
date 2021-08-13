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
    private static long[][][] dp;
    private static int N;
    private static int MAXBITMASK = (1<<10)-1;
    private static int div = 1000000000;

    public static void input(){
        N = fr.nextInt();

        dp = new long[N+1][10][1024];

        for (int i = 1; i <= 9 ; i++)
            dp[1][i][1<<i] = 1;
    }

    public static void pro(){

        for (int i = 2; i <= N; i++) {
            for (int j = 0; j <=9 ; j++) {
                for (int k = 1; k <= 1023; k++) {
                    if(j == 0){
                        dp[i][j][k|1<<0] += dp[i-1][j+1][k] % div;
                    }else if(j == 9){
                        dp[i][j][k|1<<9] += dp[i-1][j-1][k] % div;
                    }else{
                        dp[i][j][k|1<<j] += dp[i-1][j-1][k] % div;
                        dp[i][j][k|1<<j] += dp[i-1][j+1][k] % div;
                    }
                }
            }
        }

        long sum = 0;
        for (int i = 0; i <=9 ; i++) {
            sum = (sum + dp[N][i][MAXBITMASK])%div;
        }
        System.out.println(sum);
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

