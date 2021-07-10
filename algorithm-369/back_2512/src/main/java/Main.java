import java.io.*;
import java.util.StringTokenizer;

public class Main {
    private static FastScanner fs = new FastScanner();
    private static StringBuilder sb = new StringBuilder();
    private static int N, GOVERMENT_BUDGET;
    private static int budgets[];

    public static void input(){
        N = fs.nextInt();

        budgets = new int[N+1];
        for (int i = 1; i <= N; i++) budgets[i] = fs.nextInt();

        GOVERMENT_BUDGET = fs.nextInt();
    }

    private static boolean determination(int budgets[], int candidate){
        long total_budget = 0;
        for(int budget : budgets){
            if(budget > candidate) total_budget += candidate;
            else total_budget += budget;
        }
        return GOVERMENT_BUDGET>= total_budget;
    }


    private static long lower_bound(int budgets[], int left, int right){
        int res =left-1 ;

        while(left<=right){
            int mid = (left+right)/2;

            if(determination(budgets,mid)){
                res = mid;
                left = mid+1;
            }else{
                right = mid-1;
            }
        }

        return res;
    }

    private static int maxValueResult() {
        int maxValue = Integer.MIN_VALUE;

        for (int i = 1; i <= N; i++) {
            if(maxValue < budgets[i]) maxValue = budgets[i];
        }

        return maxValue;
    }

    private static void pro(){
        long total_budget =0 ;
        for (int i = 1; i <= N; i++) {
            total_budget += budgets[i];
        }

        if(total_budget <= GOVERMENT_BUDGET){
            System.out.println(maxValueResult());
        }else{
            System.out.println(lower_bound(budgets,1,100000));
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