import java.io.*;
import java.util.StringTokenizer;

public class Main {
    private static FastScanner fs = new FastScanner();
    private static StringBuilder sb = new StringBuilder();
    private static int N, K;
    private static int nums[];

    public static void input(){
        N = fs.nextInt();
        K = fs.nextInt();

        nums = new int[N+1];
        for (int i = 1; i <= N; i++) nums[i] = fs.nextInt();

    }

    private static void pro(){
        int count = 0;
        int ans = N+1;
        int R =0;

        for (int L = 1; L <= N ; L++) {
            if(nums[L-1] == 1) count--;

            while(count<K && R+1<=N){
                R++;
                if(nums[R] == 1) count++;
            }

            if(count >=K) ans = Math.min(ans, R-L+1);
        }

        System.out.println(ans==N+1? -1: ans);
    }

    public static void main(String[] args) {
        input();
        pro();
    }

    static class FastScanner{
        private StringTokenizer st;
        private BufferedReader bf;

        public FastScanner(){
            bf = new BufferedReader(new InputStreamReader(System.in));
        }
        public FastScanner(String f) throws FileNotFoundException {
            bf = new BufferedReader(new FileReader(new File(f)));
        }

        private String next(){
            while(st == null || !st.hasMoreTokens()){
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

        public long nextLong(){
            return Long.parseLong(next());
        }

        public double nextDouble(){
            return Double.parseDouble(next());
        }

        public String readLine(){
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