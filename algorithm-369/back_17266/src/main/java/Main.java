import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    private static FastScanner fs = new FastScanner();
    private static StringBuilder sb = new StringBuilder();
    private static int N, M;
    private static int lamp[];

    public static void input(){
        N = fs.nextInt();
        M = fs.nextInt();

        lamp = new int[M+1];

        for (int i = 1; i <= M; i++) lamp[i] = fs.nextInt();
    }

    private static boolean determination(int lanLine[], int candidate){
        int lastLight = 0;

        for (int i = 1; i <= M; i++) {
            if( lanLine[i] - candidate <= lastLight )
                lastLight = lanLine[i] + candidate;
            else
                return false;
        }

        return lastLight >= N;
    }


    private static long lower_bound(int lanLine[], int left, int right){
        int res =left-1 ;

        while(left<=right){
            int mid = (left+right)/2;

            if(determination(lanLine,mid)){
                res = mid;
                right = mid-1;
            }else{
                left = mid+1;
            }
        }

        return res;
    }

    private static void pro(){
        System.out.println(lower_bound(lamp, 1, N));
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