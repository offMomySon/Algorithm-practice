import java.io.*;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
    private static FastScanner fs = new FastScanner();
    private static StringBuilder sb = new StringBuilder();
    private static int N,K;
    private static long lanLine[];

    public static void input(){
        N = fs.nextInt();
        K = fs.nextInt();

        lanLine = new long[N+1];

        for (int i = 1; i <= N; i++) lanLine[i] = fs.nextLong();
    }

    private static boolean detemine(long lanLine[], long canditate){
        int count = 0;
        for (int i = 1; i <= lanLine.length-1; i++) {
            count += lanLine[i] / canditate;
        }
        return count>=K;
    }


    private static long lower_bound(long lanLine[], long left, long right){
        long res =left-1 ;

        while(left<=right){
            long mid = (left+right)/2;

            if(detemine(lanLine,mid)){
                res = mid;
                left = mid+1;
            }else{
                right = mid-1;
            }
        }

        return res;
    }

    private static void pro(){
        Arrays.sort(lanLine,1,lanLine.length);


        System.out.println(lower_bound(lanLine, 1, lanLine[lanLine.length-1]));
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