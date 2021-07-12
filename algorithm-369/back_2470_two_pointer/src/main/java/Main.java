import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    private static FastScanner fs = new FastScanner();
    private static StringBuilder sb = new StringBuilder();
    private static int N;
    private static int nums[];

    public static void input(){
        N = fs.nextInt();

        nums = new int[N+1];
        for (int i = 1; i <= N; i++) nums[i] = fs.nextInt();
    }

    private static void pro(){
        Arrays.sort(nums, 1, nums.length);

        int L = 1;
        int R = N;
        int cur = Integer.MAX_VALUE;
        int ans[] = new int[2];

        while(L<R){

            if(Math.abs(cur) > Math.abs(nums[R]+nums[L])){
                cur = nums[R] + nums[L];
                ans[0] = nums[R];
                ans[1] = nums[L];
            }

            if(nums[R] + nums[L] > 0){
                R--;
            }else{
                L++;
            }
        }

        Arrays.sort(ans);

        System.out.println(ans[0] + " " + ans[1]);
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
