import java.io.*;
import java.util.StringTokenizer;

public class Main {

    private static FastScanner fs;
    private static StringBuffer sb;
    private static int N,M;
    private static int[] selected;

    public static void input(){
        fs = new FastScanner();
        sb = new StringBuffer();
        N = fs.nextInt();
        M = fs.nextInt();
        selected = new int[M+1];
    }

    static void recFunc(int k){
        if(k==M+1){
            for (int i = 1; i <= M; i++) {
                sb.append(selected[i]).append(" ");
            }
            sb.append("\n");
            return;
        }

        for(int cand = 1; cand <= N; cand++){
            selected[k] = cand;
            recFunc(k+1);
            selected[k] = 0;
        }
    }

    public static void main(String[] args) {
        input();

        recFunc(1);

        System.out.println(sb.toString());
    }


    static class FastScanner{
        private BufferedReader bf;
        private StringTokenizer st;


        public FastScanner() {
            this.bf = new BufferedReader(new InputStreamReader(System.in));
        }

        public FastScanner(String f) throws FileNotFoundException {
            this.bf = new BufferedReader(new FileReader(new File(f)));
        }

        public String next(){
            String str = "";
            while((st == null || !st.hasMoreTokens())) {
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
        public String nextLine(){
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
