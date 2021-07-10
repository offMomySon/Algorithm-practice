import java.io.*;
import java.util.StringTokenizer;

public class Main {
    private static FastScanner fs = new FastScanner();
    private static StringBuilder sb = new StringBuilder();
    private static int N;
    private static long TARGET_LENGTH;
    private static long trees[];

    public static void input(){
        N = fs.nextInt();
        TARGET_LENGTH = fs.nextLong();

        trees = new long[N+1];
        for (int i = 1; i <= N; i++) trees[i] = fs.nextLong();
    }

    private static boolean determination(long trees[], long candidate){
        long total_length = 0;
        for(long tree : trees){
            if(tree <= candidate) continue;

            total_length += tree - candidate;
        }

        return TARGET_LENGTH <= total_length;
    }


    private static long lower_bound(long trees[], long left, long right){
        long res =left-1 ;

        while(left<=right){
            long mid = (left+right)/2;

            if(determination(trees,mid)){
                res = mid;
                left = mid+1;
            }else{
                right = mid-1;
            }
        }

        return res;
    }

    private static void pro(){
        System.out.println(lower_bound(trees,1, 1000000000));
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