import java.io.*;
import java.util.StringTokenizer;

//날짜 - 2021/08/10
//시작 - 04:04
//종료 - 04:31
//실수 -
//참조 -

public class Main {
    private static FastReader fr = new FastReader();
    private static StringBuilder sb = new StringBuilder();
    private static long[] num;
    private static long[] dp;
    private static String line;

    public static void input(){
        line = fr.nextLine();

        dp = new long[5000+1];
        num = new long[5000+1];

        for (int i = 1; i <= line.length() ; i++) {
            num[i] = line.charAt(i-1)- '0';
        }

        if(num[1] != 0)
            dp[1] = 1;

        if(line.length()>=2 ){
            if(num[2] != 0)
                dp[2] += dp[1];
        }

        if(line.length()>=2) {
            long doubleDigit = num[1] *10  + num[2];

            if(doubleDigit<=26 && doubleDigit>=10){
                dp[2] +=1;
            }
        }
    }

    public static void pro(){
        for (int i = 3; i <= line.length(); i++) {
            if(num[i] != 0)
                dp[i] = (dp[i] + dp[i-1])%1000000;

            long doubleDigit = num[i-1] *10  + num[i];

            if(10<= doubleDigit&& doubleDigit <=26)
                dp[i] = (dp[i - 2] + dp[i]) % 1000000;
        }

        System.out.println(dp[line.length()]);
    }

    public static void main(String[] args) {
        input();
        pro();
    }

    public static class FastReader{
        private BufferedReader br;
        private StringTokenizer st;

        public FastReader(){
            br = new BufferedReader(new InputStreamReader(System.in));
        }
        public FastReader(String file) throws FileNotFoundException {
            br = new BufferedReader(new FileReader(new File(file)));
        }

        private String next(){
            while( st == null || !st.hasMoreElements()){
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
        public String nextLine(){
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


