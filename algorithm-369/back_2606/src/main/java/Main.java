import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    private static FastReader fr = new FastReader();
    private static int computerCount = 0;
    private static int connectCount = 0;
    private static ArrayList<Integer>[] adj;
    private static boolean visited[];
    private static int infectedCount = 0;

    public static void input(){
        computerCount = fr.nextInt();
        connectCount = fr.nextInt();

        visited = new boolean[computerCount+1];

        adj = new ArrayList[computerCount+1];
        for (int i = 0; i <= computerCount; i++) {
            adj[i] = new ArrayList<Integer>();
        }

        for (int i = 0; i < connectCount; i++) {
            int x = fr.nextInt();
            int y = fr.nextInt();

            adj[x].add(y);
            adj[y].add(x);
        }
    }

    public static void dfs(int v){
        visited[v] = true;
        infectedCount++;

        for(int nextV : adj[v]){
            if(visited[nextV]) continue;

            dfs(nextV);
        }
    }

    public static void pro(){
        dfs(1);
        System.out.println(infectedCount-1);
    }

    public static void main(String[] args) {
        input();
        pro();
    }

    static class FastReader{
        private BufferedReader bf;
        private StringTokenizer st;

        public FastReader(){
            bf = new BufferedReader(new InputStreamReader(System.in));
        }
        public FastReader(String f) throws FileNotFoundException {
            bf = new BufferedReader(new FileReader(new File(f)));
        }

        public String next(){
            while(st == null || !st.hasMoreElements()){
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
        public long nextLone(){
            return Long.parseLong(next());
        }
        public Double nextDouble(){
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
