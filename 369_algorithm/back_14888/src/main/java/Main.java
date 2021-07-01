import java.io.*;
import java.util.StringTokenizer;

public class Main {
    private static FastScanner fs;
    private static StringBuffer sb;
    private static int N;
    private static int[] nums, op, order;
    private static int max, min;

    private static void input(){
        fs = new FastScanner();
        sb = new StringBuffer();

        N = fs.nextInt();
        nums = new int[N+1];
        op = new int[5];
        order = new int[N+1];

        for (int i = 1; i <= N ; i++) nums[i] = fs.nextInt();
        for (int i = 1; i <= 4 ; i++) op[i] = fs.nextInt();

        max = Integer.MIN_VALUE;
        min = Integer.MAX_VALUE;
    }


    static void barec_fun(int k ){
        if(k == N){
            int cal = nums[1];
            for (int i = 1; i < N ; i++) {
                switch (order[i]){
                    case 1:
                        cal = cal+nums[i+1];
                        break;
                    case 2:
                        cal = cal-nums[i+1];
                        break;
                    case 3:
                        cal = cal*nums[i+1];
                        break;
                    case 4:
                        cal = cal/nums[i+1];
                }
            }

            max = max< cal? cal: max;
            min = min > cal? cal:min;
            return;
        }

        for (int i = 1; i <= 4 ; i++) {
            if(op[i] <= 0)
                continue;

            op[i]--;

            order[k] = i;
            barec_fun(k+1);

            op[i]++;
        }
    }


    public static void main(String[] args) {
        input();

        barec_fun(1);
        sb.append(max).append("\n").append(min);

        System.out.println(sb);
    }

    static class FastScanner{
        private StringTokenizer st;
        private BufferedReader br;

        public FastScanner() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }
        public FastScanner(String f) throws FileNotFoundException {
            br = new BufferedReader(new FileReader(new File(f)));
        }

        private String next(){
            while((st == null || !st.hasMoreTokens())){
                try {
                    st = new StringTokenizer(br.readLine());
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
                str = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }
    }
}
