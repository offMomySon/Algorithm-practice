import java.io.*;
import java.util.Arrays;
import java.util.Stack;
import java.util.StringTokenizer;

//날짜 - 2021/08/17
//시작 - 20:08
//종료 -
//실수 - 결과 값 자료형 int -> long 으로 변환해야한다.
//참조 -

public class Main {
    private static FastScanner fs = new FastScanner();
    private static StringBuilder sb = new StringBuilder();
    private static int N,K;
    private static int[] nums;

    public static void input(){
        N = fs.nextInt();
        nums = new int[N+1];

        for (int i = 1; i <= N ; i++) {
            nums[i] = fs.nextInt();
        }
    }

    private static void pro(){
        long benefit =0;
        int msb = 0;

        for (int i = N; i >=1; i--) {
            if(msb>nums[i]) benefit += (msb-nums[i]);
            else msb = nums[i];
        }

        sb.append(benefit).append("\n");
    }

    public static void main(String[] args) {
        int loop = fs.nextInt();
        for (int i = 0; i < loop; i++) {

            input();
            pro();
        }
        System.out.println(sb.toString());
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
