import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    private static FastScanner fs = new FastScanner();
    private static StringBuilder sb = new StringBuilder();
    private static int N, k;
    public static void input(){
        N = fs.nextInt();
        k = fs.nextInt();

    }

    public static long binarySearch(){
        long left = 1;
        long right = (long)N*N;
        long res = 0;
        while(left <= right){
            long mid = (left+right)/2;

            if(determine(mid)) {
                res = mid;
                right = mid-1;
            }else{
                left = mid+1;
            }
        }
        return res;
    }

    private static boolean determine(long mid) {
        long count =0;
        for (int i = 1; i <=N ; i++) {
            count += Math.min(N,mid/i );
        }

        return count >= k;
    }


    public static void main(String[] args) {
        input();

        System.out.println(binarySearch());
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
