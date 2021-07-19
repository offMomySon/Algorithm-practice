import java.io.*;
import java.util.*;

public class Main {
    private static FastReader fr = new FastReader();
    private static StringBuilder sb = new StringBuilder();
    private static int N, start, target;
    private static int count;
    private static ArrayList<Integer>[] adj;
    private static int distance[];
    private static boolean visited[];

    private static void input(){
        N = fr.nextInt();
        adj = new ArrayList[N+1];

        for (int i = 0; i <= N; i++) {
            adj[i] = new ArrayList<>();
        }

        distance = new int[N+1];
        visited = new boolean[N+1];

        start = fr.nextInt(); target = fr.nextInt();
        count = fr.nextInt();

        for (int i = 0; i < count; i++) {
            int parent = fr.nextInt();
            int child = fr.nextInt();

            adj[parent].add(child);
            adj[child].add(parent);
        }
    }

    private static void bfs(int start){
        Queue<Integer> q = new LinkedList<>();
        q.add(start);

        visited[start] = true;
        distance[start] = 0;

        while(!q.isEmpty()){
            Integer cur_position = q.poll();

            if(cur_position == target) return;

            for(int next_position : adj[cur_position]){
                if(visited[next_position]) continue;

                distance[next_position] = distance[cur_position] +1;
                visited[next_position] = true;

                q.add(next_position);
            }
        }
    }

    private static void pro(){
        bfs(start);

        if(!visited[target]){
            System.out.println(-1);
        }else{
            System.out.println(distance[target]);
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

        public String nextLine(){
            String str = "";
            try {
                str = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
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
    }
}
