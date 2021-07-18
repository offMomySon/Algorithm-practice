import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    private static FastReader fr = new FastReader();
    private static StringBuilder sb = new StringBuilder();
    private static int N;
    private static int[] parent;
    private static boolean[] visited;
    private static ArrayList<Integer>[] adj;

    private static void input(){
        N = fr.nextInt();

        visited = new boolean[N+1];

        parent = new int[N+1];
        for (int i = 1; i <= N; i++) {
            parent[i] = -1;
        }

        adj = new ArrayList[N+1];
        for (int i = 0; i <adj.length ; i++) {
            adj[i] = new ArrayList<>();
        }

        for (int i = 1; i <= N-1; i++) {
            int x = fr.nextInt();
            int y = fr.nextInt();

            adj[x].add(y);
            adj[y].add(x);
        }
    }

    private static boolean dfs(int v){
        if(v == 1) return true;

        visited[v] = true;

        for(int nextV : adj[v]){
            if(visited[nextV]) continue;

            if(parent[nextV] !=-1){
                parent[v] = nextV;
                return true;
            }

            if(dfs(nextV)){
                parent[v] = nextV;
                return true;
            }else{
                parent[nextV] = v;
            }
        }

        return false;
    }

    private static void bfs(int v){
        Queue<Integer> q = new LinkedList<>();
        q.add(v);
        visited[v] = true;

        while(!q.isEmpty()){
            int curV = q.poll();

            for(int nextV : adj[curV]){
                if(visited[nextV]) continue;

                q.add(nextV);
                parent[nextV] = curV;
                visited[nextV] = true;
            }

        }

    }

    private static void pro2(){

        bfs(1);

        for (int i = 2; i <= N; i++) {
            sb.append(parent[i]).append("\n");
        }
        System.out.println(sb.toString());
    }

    private static void pro(){

        for (int i = 2; i <= N ; i++) {
            if(parent[i] != -1) continue;

            for (int j = 0; j < visited.length; j++) {
                visited[j] = false;
            }
            dfs(i);
        }

        for (int i = 2; i <= N; i++) {
            sb.append(parent[i]).append("\n");
        }
        System.out.println(sb.toString());
    }

    public static void main(String[] args) {
        input();
        //pro();
        pro2();
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
            while(st == null || !st.hasMoreElements()){
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
        public double nextDouble(){
            return Double.parseDouble(next());
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
