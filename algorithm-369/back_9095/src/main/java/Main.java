import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    private static FastReader fr = new FastReader();
    private static StringBuilder sb = new StringBuilder();
    private static ArrayList<Integer> query;
    private static int[] dp;

    public static void input(){
        int n = fr.nextInt();
        query = new ArrayList<>();
        dp = new int[11+1];

        for (int i = 0; i < n; i++) {
            int target = fr.nextInt();
            query.add(target);
        }

    }

    public static void init(){
        dp[1] =1;
        dp[2] = 2;
        dp[3] = 4;
    }

    public static void pro(){
        init();

        for (int i = 4; i <= 11; i++) {
            dp[i] = dp[i-1]+dp[i-2]+dp[i-3];
        }

        for(int target : query) sb.append(dp[target]).append("\n");
        System.out.println(sb.toString());
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
