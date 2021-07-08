import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    private static FastScanner fs = new FastScanner();
    private static StringBuilder sb = new StringBuilder();
    private static int N,K;
    private static int nums[][];

    public static void input(){
        N = fs.nextInt();

        nums = new int[N+1][3];

        for (int i = 1; i <= N; i++) {
            nums[i][0] = fs.nextInt();
            nums[i][1] = fs.nextInt();
            nums[i][2] = fs.nextInt();
        }
    }

    public static long count(int a, int c, int b, int x){
        if(x<a) return 0;
        if(c<x) return (c-a)/b+1;
        return (x-a)/b +1;
    }

    public static boolean determination(int candidate){
        long sum =0 ;

        for (int i = 1; i <= N ; i++) {
            sum += count(nums[i][0], nums[i][1], nums[i][2], candidate);
        }
        return sum%2 == 1;
    }

    private  static long lower_bound(long left, long right){
        long res = left-1;

        while(left<= right){
            long mid = (left+right)/2;

            if(determination((int)mid)){
                res = mid;
                right= mid-1;
            }else{
                left = mid+1;
            }
        }
        return res;
    }

    private static int countResult(long res){
        int count =0 ;
        for (int i = 1; i <= N; i++) {
            if(res < nums[i][0] || nums[i][1] < res) continue;

            if( (res - nums[i][0])%nums[i][2]  != 0 ) continue;

            count++;
        }
        return count;
    }

    private static void pro(){
        long res = lower_bound(1, Integer.MAX_VALUE);

        int countResult = countResult(res);

        if(countResult ==0){
            System.out.println("NOTHING");
        } else{
            System.out.println(res + " " + countResult);
        }

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
