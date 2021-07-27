import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static FastReader fr = new FastReader();
    public static ArrayList<Integer>[] adj;
    public static int[] parent;
    public static int N;

    public static void input(){
        N = fr.nextInt();

        parent = new int[N+1];
        adj = new ArrayList[N+1];

        for (int i = 0; i <= N; i++) {
            adj[i] = new ArrayList<>();
            parent[i] = -1;
        }

        for (int i = 1; i <= N-1; i++) {
            int node_one = fr.nextInt();
            int node_two = fr.nextInt();

            adj[node_one].add(node_two);
            adj[node_two].add(node_one);
        }
    }

    public static void dfs(int cur, int par){
        parent[cur] = par;
        
        for(int child : adj[cur]){
            if(child == par) continue;
            dfs(child,cur);
        }
    }

    public static void pro(){
        
        dfs(1,-1);

        for (int i = 2; i <= N; i++) {
            System.out.println(parent[i]);
        }


    }

    public static void main(String[] args) {
        input();
        pro();
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

        private String next(){
            while(st == null || !st.hasMoreElements()){
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        private int nextInt(){
            return Integer.parseInt(next());
        }
        private long nextLong(){
            return Long.parseLong(next());
        }
        private double nextDouble(){
            return Double.parseDouble(next());
        }
        private String nextLine(){
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
