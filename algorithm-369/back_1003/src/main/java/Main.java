import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

class Count{
    public  int zero_count;
    public  int one_count;

    public Count(int zero_count, int one_count) {
        this.zero_count = zero_count;
        this.one_count = one_count;
    }


}

public class Main {
    private static FastReader fr = new FastReader();
    private static StringBuilder sb = new StringBuilder();
    private static Count[] dp;
    private static int N;

    public static void input(){
        N = fr.nextInt();
        dp = new Count[40+1];

    }

    public static void init(){
        dp[0] = new Count(1,0);
        dp[1] = new Count(0,1);

        for (int i = 2; i <= 40; i++) {
            dp[i] =  new Count(dp[i-1].zero_count+dp[i-2].zero_count,
                    dp[i-1].one_count+ dp[i-2].one_count);
        }
    }

    public static void pro() {

        for (int i = 0; i < N; i++) {
            int target_number = fr.nextInt();
            sb.append(dp[target_number].zero_count).append(" ").append(dp[target_number].one_count).append("\n");
        }

        System.out.println(sb.toString());
    }

    public static void main(String[] args) {
        input();
        init();
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
