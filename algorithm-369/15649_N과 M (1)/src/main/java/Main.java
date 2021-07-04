import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static FastScanner fs;
    public static StringBuffer sb;
    public static int N,M;
    public static int selected[];
    public static boolean used[];

    public static void input(){
        fs = new FastScanner();
        sb = new StringBuffer();
        N = fs.nextInt();
        M = fs.nextInt();
        selected = new int[M+1];
        used = new boolean[N+1];
    }

    static void rec_func(int k){
        if(k == M+1){
            for (int i = 1; i <= M ; i++) {
                sb.append(selected[i]).append(" ");
            }
            sb.append("\n");
            return;
        }

        for (int cand = 1; cand <= N; cand++) {
            if(used[cand])
                continue;

            used[cand] = true;
            selected[k] = cand;

            rec_func(k+1);

            used[cand] = false;
            selected[k] = 0;
        }

    }

    public static void main(String[] args) {
        input();

        rec_func(1);
        System.out.println(sb.toString());
    }

    static class FastScanner{
        private BufferedReader bf;
        private StringTokenizer st;

        public FastScanner(){
            bf = new BufferedReader(new InputStreamReader(System.in));
        }
        public FastScanner(String f) throws FileNotFoundException {
            bf = new BufferedReader(new FileReader(new File(f)));
        }

        private String next(){
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
