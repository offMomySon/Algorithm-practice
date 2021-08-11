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
    private static int[][] sticky;
    private static int[][] dp;
    private static int N;

    public static void input(){
        N = fr.nextInt();

        sticky = new int[2][N+1];
        dp = new int[N+1][3];

        for (int i = 0; i <=1 ; i++) {
            for (int jIndx = 1; jIndx <= N ; jIndx++) {
                sticky[i][jIndx] = fr.nextInt();
            }
        }

        dp[1][0] = 0;
        dp[1][1] = sticky[0][1];
        dp[1][2] = sticky[1][1];
    }

    public static void pro(){
        for (int i = 2; i <= N ; i++) {
            dp[i][0] = Math.max(Math.max(dp[i-1][0], dp[i-1][1]), dp[i-1][2]);
            dp[i][1] = sticky[0][i] + Math.max(dp[i-1][0], dp[i-1][2]);
            dp[i][2] = sticky[1][i] + Math.max(dp[i-1][0], dp[i-1][1]);
        }

        System.out.println(Math.max(Math.max(dp[N][0], dp[N][1]), dp[N][2]) );
    }

    public static void main(String[] args) {
        int loop = fr.nextInt();

        for (int i = 0; i < loop; i++) {
            input();
            pro();
        }
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

