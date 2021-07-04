import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    private static FastScanner fs = new FastScanner();
    private static int N, COUNT;

    private static void input(){
        N = fs.nextInt();
    }

    public static int converter(int targetNum){
        int resultNum = 0;

        while( targetNum/10 > 0){
            resultNum += targetNum%10;
            targetNum = targetNum/10;
        }
        resultNum += targetNum%10;

        return resultNum;
    }

    public static boolean isMultipleOfThree(int targetNum){
        // 1 자리 수인지 확인.
        if(targetNum/10 <= 0){
            if(targetNum % 3 == 0) return true;
            else return false;
        }

        // convert 하는 부분
        int convertedNum = converter(targetNum);
        COUNT++;

        // 재귀 호출.
        return isMultipleOfThree(convertedNum);
    }

    public static void main(String[] args) {
//        input();

        boolean result;
        for (int i = 6509142; i <= 10000000 ; i++) {
            System.out.println("num = " + i);
            COUNT = 0;

            result = isMultipleOfThree(i);

            System.out.println(COUNT);
            if(result) System.out.println("YES");
            else System.out.println("NO");
        }
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
