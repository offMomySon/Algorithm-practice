import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    public static FastReader fr = new FastReader();
    public static int N,M;
    public static ArrayList<Integer>[] adj;
    public static boolean[] visited;

    public static void main(String[] args) {
        input();
        pro();
    }

    private static void dfs(int v){
        visited[v] = true;

        for(int nextV : adj[v]){
            if(visited[nextV]) continue;

            dfs(nextV);
        }
    }

    private static void pro(){
        int count = 0;

        for (int i = 1; i <= N ; i++) {
            if(visited[i]) continue;
            count++;
            dfs(i);
        }

        System.out.println(count);
    }

    private static void input() {
        N = fr.nextInt();
        M = fr.nextInt();

        visited = new boolean[N+1];
        adj = new ArrayList[N+1];
        for (int i = 0; i <= N; i++) {
            adj[i] = new ArrayList<>();
        }

        for (int i = 0; i <M; i++) {
            int u = fr.nextInt();
            int v = fr.nextInt();

            adj[u].add(v);
            adj[v].add(u);
        }
    }

    static class FastReader{
        private BufferedReader br;
        private StringTokenizer st;

        public FastReader(){
            br = new BufferedReader(new InputStreamReader(System.in));
        }
        public FastReader(String f) throws FileNotFoundException {
            br = new BufferedReader(new FileReader(new File(f)));
        }

        public String next(){
            while(st == null ||!st.hasMoreElements()){
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
