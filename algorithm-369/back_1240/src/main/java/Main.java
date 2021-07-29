import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

//날짜 - 2021/07/29
//시작 - 19:57
//종료 - 02:30
//실수 -
//참조 -

class Point{
    public int distance;
    public int vertex;

    public Point(int distance, int vertex) {
        this.distance = distance;
        this.vertex = vertex;
    }
}

public class Main {
    private static FastReader fr = new FastReader();
    private static StringBuilder sb = new StringBuilder();
    private static ArrayList<Point>[] adj;
    private static boolean[] visited;
    private static int N,M;
    private static int TOTAL_DISTANCE = 0;

    private static void input(){
        N = fr.nextInt();
        M = fr.nextInt();

        adj = new ArrayList[N+1];
        for (int i = 0; i <adj.length ; i++) {
            adj[i] = new ArrayList<Point>();
        }
        visited = new boolean[N+1];

        for (int i = 0; i < N-1; i++) {
            int x = fr.nextInt();
            int y = fr.nextInt();
            int distance = fr.nextInt();

            adj[x].add(new Point(distance,y));
            adj[y].add(new Point( distance,x));
        }
    }

    private static boolean dfs(int cur, int target){
        if(cur == target) return true;

        visited[cur] = true;

        for (Point next_point : adj[cur]){
            if(visited[next_point.vertex] ) continue;

            TOTAL_DISTANCE += next_point.distance;
            if(dfs(next_point.vertex, target)){
                return true;
            }
            TOTAL_DISTANCE -= next_point.distance;

        }

        return false;
    }

    private  static void pro(int x, int y){
        Arrays.fill(visited,false);
        dfs(x,y);
        sb.append(TOTAL_DISTANCE + "\n");
        TOTAL_DISTANCE = 0;
    }


    public static void main(String[] args) {
        input();

        for (int i = 0; i < M; i++) {
            int x = fr.nextInt();
            int y = fr.nextInt();

            pro(x,y);
        }

        System.out.println(sb.toString());
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
