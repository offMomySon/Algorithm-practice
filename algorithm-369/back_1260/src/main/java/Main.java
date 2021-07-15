import java.io.*;
import java.util.*;

public class Main {
    public static FastReader fs = new FastReader();
    public static StringBuilder sb = new StringBuilder();
    public static int N,M,V;
    public static ArrayList<Integer>[] adj;
    public static boolean visited[];


    public static void input() {
        N = fs.nextInt();
        M = fs.nextInt();
        V = fs.nextInt();

        visited = new boolean[N+1];
        adj = new ArrayList[N+1];
        for (int i = 1; i <= N ; i++) {
            adj[i] = new ArrayList<>();
        }

        for (int i = 1; i <= M ; i++) {
            int x = fs.nextInt();
            int y = fs.nextInt();

            adj[x].add(y);
            adj[y].add(x);
        }
        for (int i = 1; i <= N ; i++) {
            Collections.sort(adj[i]);
        }
    }

    public static void dfs(int v){
        sb.append(v).append(" ");
        visited[v] = true;

        for(int next : adj[v]){
            if(visited[next] == true) continue;

            dfs(next);
        }
    }

    public static void bfs(int v){
        Queue<Integer> q = new LinkedList<>();

        q.add(v);
        visited[v] = true;

        while(!q.isEmpty()){
            int curV = q.poll();

            sb.append(curV).append(" ");

            for(int next : adj[curV]){
                if(visited[next]) continue;

                q.add(next);
                visited[next] = true;
            }
        }
    }

    public static void pro(){
        dfs(V);
        sb.append("\n");
        for (int i = 1; i <= N; i++) visited[i] = false;
        bfs(V);
        System.out.println(sb);
    }

    public static void main(String[] args) {
        input();
        pro();
    }


    static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        public FastReader(String s) throws FileNotFoundException {
            br = new BufferedReader(new FileReader(new File(s)));
        }

        public String next(){
            while(st == null || !st.hasMoreElements()){
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
            return st.nextToken();
        }


        public double nextDouble(){
            return Double.parseDouble(next());
        }
        public int nextInt(){
            return Integer.parseInt(next());
        }
        public long nextLong(){
            return Long.parseLong(next());
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
