import java.io.*;
import java.util.StringTokenizer;

public class Main {
    private static FastScanner fs = new FastScanner();
    private static StringBuilder sb = new StringBuilder();
    private static int N, TIMES;
    private static int amount[];

    public static void input(){
        N = fs.nextInt();
        TIMES = fs.nextInt();

        amount = new int[N+1];
        for (int i = 1; i <= N; i++) amount[i] = fs.nextInt();
    }

    private static boolean determination(int amount[], int candidate){
        int count = 1;
        int money = candidate;

        for (int i = 1; i <= N ; i++) {

            if(money < amount[i]){
                money = candidate - amount[i];
                count++;
            }else{
                money -= amount[i];
            }
        }

        return TIMES>= count;
    }


    private static long lower_bound(int budgets[], int left, int right){
        int res =left-1 ;

        while(left<=right){
            int mid = (left+right)/2;

            if(determination(budgets,mid)){
                res = mid;
                right = mid-1;
            }else{
                left = mid+1;
            }
        }

        return res;
    }

    private static int maxNum(int[] amount){
        int max = 0;
        for(int money: amount){
            if(max < money)
                max = money;
        }
        return max;
    }

    private static void pro(){
        System.out.println(lower_bound(amount, maxNum(amount), 10000));
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