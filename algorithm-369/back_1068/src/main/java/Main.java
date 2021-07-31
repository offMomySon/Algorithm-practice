import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

public class Main {
    private static FastReader fr = new FastReader();
    private static StringBuilder sb = new StringBuilder();
    private static int root_idx;
    private static ArrayList<Integer>[] adj;
    private static int N;
    private static int[] parent;
    private static int REMOVE_NODE;

    private static void input(){
        N = fr.nextInt();
        parent = new int[N+1];
        adj = new ArrayList[N+1];
        for (int i = 0; i < adj.length; i++) {
            adj[i] = new ArrayList<>();
        }

        for (int i = 0; i < N; i++) {
            parent[i] = fr.nextInt();

            if(parent[i] == -1){
                root_idx = i;
                continue;
            }

            adj[i].add(parent[i]);
            adj[parent[i]].add(i);
        }

        REMOVE_NODE = fr.nextInt();
        if(REMOVE_NODE != root_idx){
            List<Integer> collect = adj[parent[REMOVE_NODE]].stream()
                    .filter(num -> num != REMOVE_NODE)
                    .collect(Collectors.toList());
            adj[parent[REMOVE_NODE]] = (ArrayList<Integer>) collect;
        }
    }

    public static int dfs(int cur, int parent){
        if(cur == root_idx && adj[cur].size() == 0) return 1;
        if(adj[cur].size()==1 && cur != root_idx) return 1;

        int total = 0;
        for(int next : adj[cur]){
            if(next == parent) continue;

            total += dfs(next, cur);
        }
        return total;
    }

    public static void pro(){
        int count;
        if(root_idx == REMOVE_NODE){
            count = 0;
        }else{
            count = dfs(root_idx, -1);
        }
        System.out.println(count);
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
        public double nextDouble(){
            return Double.parseDouble(next());
        }
        public long nextLong(){
            return Long.parseLong(next());
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
