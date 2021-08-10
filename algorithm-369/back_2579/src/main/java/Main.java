import java.io.*;
import java.util.StringTokenizer;

public class Main {
    private static FastReader fr = new FastReader();
    private static StringBuilder sb = new StringBuilder();
    private static int[] stair;
    private static int[][] dp;
    private static int N;

    public static void input(){
        N = fr.nextInt();

        stair = new int[300+10];
        dp = new int[300+10][2];

        for (int i = 1; i <=N ; i++) {
            stair[i] = fr.nextInt();
        }

        dp[1][0] = 0;
        dp[1][1] = stair[1];

        if(N>=2){
            dp[2][0] = stair[2];
            dp[2][1] = stair[2] + stair[1];
        }
    }

    public static void pro(){
        for (int i = 3; i <= N ; i++) {
            dp[i][0] = Math.max(dp[i-2][0], dp[i-2][1] ) + stair[i];
            dp[i][1] = dp[i-1][0] + stair[i];
        }

        if(N==1)
            System.out.println(dp[1][1]);
        else
            System.out.println(Math.max(dp[N][0], dp[N][1]));
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

