import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
import java.util.stream.IntStream;

public class Main {
    private static FastReader fr = new FastReader();
    private static int N, M ;
    private static int[] distance;
    private static boolean[] visited;
    private static ArrayList<Integer>[] adj;

    public static void input() {
        N = fr.nextInt();
        M = fr.nextInt();

        distance = new int[N + 1];
        visited = new boolean[N + 1];
        adj = new ArrayList[N + 1];

        for (int i = 0; i <= N; i++) {
            adj[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            int x = fr.nextInt();
            int y = fr.nextInt();

            adj[x].add(y);
            adj[y].add(x);
        }
    }

    public static void bfs(int start){
        Queue<Integer> q = new LinkedList<>();
        q.add(start);

        visited[start] = true;
        distance[start]  = 0;

        while(!q.isEmpty()){
            Integer cur_pos = q.poll();

            for(int next_pos : adj[cur_pos]){
                if(visited[next_pos]) continue;

                visited[next_pos] = true;
                distance[next_pos] = distance[cur_pos] + 1;
                q.add(next_pos);
            }
        }


    }

    public static void init() {
        for (int j = 0; j < distance.length; j++) {
            distance[j] = 0;
        }

        for (int i = 0; i < visited.length; i++) {
            visited[i] = false;
        }
    }

    public static  void pro(){
        int cur_max = Integer.MAX_VALUE;
        int ans = 0;

        for (int i = 1; i <= N; i++) {
            init();
            bfs(i);

            int cal = IntStream.of(distance).sum();

            if( cal < cur_max){
                ans = i;
                cur_max = cal;
            }
        }

        System.out.println(ans);
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
