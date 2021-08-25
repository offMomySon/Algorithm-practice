import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    private static FastScanner fs = new FastScanner();
    private static StringBuilder sb = new StringBuilder();
    private static int N;
    private static int[][] junp_point;
    private static int MAX_JUNP = 19;

    public static void input(){
        N = fs.nextInt();

        junp_point = new int[MAX_JUNP+1][N+1];

        for (int i = 1; i <= N ; i++) {
            junp_point[0][i] = fs.nextInt();
        }

        for (int depth = 1; depth <= MAX_JUNP ; depth++) {
            for( int num = 1 ; num <= N; num++){
                junp_point[depth][num] = junp_point[depth-1][junp_point[depth-1][num]];
            }
        }

    }

    private static void pro(int n, int x){

        for (int i = MAX_JUNP; i >=0 ; i--) {
            if( n >= 1<< i){
                n -= 1<< i;
                x = junp_point[i][x];
            }
        }
        sb.append(x).append("\n");
    }

    public static void main(String[] args) {
        input();
        int loop = fs.nextInt();
        for (int i = 0; i < loop; i++) {
            int n = fs.nextInt();
            int x = fs.nextInt();
            pro(n,x);
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
