import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    private static FastScanner fs = new FastScanner();
    private static StringBuilder sb = new StringBuilder();
    private static int N,K;
    private static int makgeolli[];

    public static void input(){
        N = fs.nextInt();
        K = fs.nextInt();

        makgeolli = new int[N+1];

        for (int i = 1; i <= N; i++) makgeolli[i] = fs.nextInt();
    }

    private static boolean detemine(int makgeolli[], long amount){
        long count = 0;

        for (int i = 1; i <= makgeolli.length-1; i++) {
            count += makgeolli[i]/amount;
        }

        return count>=K;
    }


    private static long lower_bound(int makgeolli[], long left, long right){
        long res = 0;

        while(left <= right){
            long mid = (left+right)/2;

            if(detemine(makgeolli, mid) ){
                res = mid;
                left = mid+1;
            }else{
                right = mid -1;
            }
        }

        return res;
    }

    public static void main(String[] args) {
        input();

        Arrays.sort(makgeolli, 1, makgeolli.length);

        System.out.println(lower_bound(makgeolli,0,Integer.MAX_VALUE));
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
