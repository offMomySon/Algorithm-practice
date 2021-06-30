import java.io.*;
import java.util.StringTokenizer;

public class Main {
    private static FastScanner fs;
    private static StringBuffer sb;
    private static int N,M;
    private static int[] visited;

    private static void input(){
        fs = new FastScanner();
        sb = new StringBuffer();
        N = fs.nextInt();
        M = fs.nextInt();
        visited = new int[M+1];
    }

    private static void rec_func(int k){
        if(M+1 == k){
            for (int i = 1; i <= M ; i++) {
                sb.append(visited[i]).append(" ");
            }
            sb.append("\n");
            return;
        }

        int start = visited[k-1] == 0 ?1:visited[k-1];

        for (int cand = start; cand <= N; cand++) {
            visited[k] = cand;
            rec_func(k+1);
            visited[k] = 0;
        }
    }

    public static void main(String[] args) {
        input();

        rec_func(1);

        System.out.println(sb.toString());
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
