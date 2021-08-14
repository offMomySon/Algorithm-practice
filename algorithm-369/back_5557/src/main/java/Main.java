import java.io.*;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

public class Main {
    private static FastReader fr = new FastReader();
    private static StringBuilder sb = new StringBuilder();
    private static int N;
    private static int RESULT;
    private static long dp[][];
    private static int nums[];

    private static void input(){
        N = fr.nextInt();

        nums = new int[N+1];
        for (int i = 1; i <= N; i++) {
            nums[i] = fr.nextInt();
        }
        RESULT = nums[N];

        dp = new long[100+1][21];
        dp[1][nums[1]] = 1;
    }

    private static void pro(){
        for (int i = 2; i <= N-1 ; i++) {
            for (int j = 0; j <= 20; j++) {
                if(j - nums[i]<0){
                    dp[i][j] = dp[i-1][j+nums[i]];
                }else if(j+nums[i]>20){
                    dp[i][j] = dp[i-1][j-nums[i]];
                }else{
                    dp[i][j] = dp[i-1][j+nums[i]]+ dp[i-1][j-nums[i]];
                }
            }
        }

        System.out.println(dp[N-1][RESULT] );
    }

    public static void main(String[] args) {
        input();
        pro();
    }

    static class FastReader{
        private BufferedReader bf;
        private StringTokenizer st;

        public FastReader(){
            bf = new BufferedReader(new InputStreamReader(System.in));
        }
        public FastReader(String f) throws FileNotFoundException {
            bf = new BufferedReader(new FileReader(new File(f)));
        }

        public String next(){
            while(st == null || !st.hasMoreElements()){
                try {
                    st = new StringTokenizer(bf.readLine());
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
                str = bf.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }
    }
}
