//날짜 - 2021/08/07
//시작 - 17:06
//종료 - 17:38
//실수 -
//참조 -

import java.io.*;
import java.util.*;

class Info{
    public int idx;
    public int dist;

    public Info(int idx, int dist){
        this.idx = idx;
        this.dist = dist;
    }
}

class Edge{
    public int weight;
    public int to;

    public Edge(int weight, int to){
        this.weight = weight;
        this.to = to;
    }
}

public class Main {
    private static FastReader fr = new FastReader();
    private static StringBuilder sb = new StringBuilder();
    private static int V, E;
    private static int START_VERTEX;
    private static ArrayList<Edge>[] edges;
    private static int[] dist;

    private static void input(){
        V = fr.nextInt();
        E = fr.nextInt();

        dist = new int[V+1];
        edges = new ArrayList[V+1];
        for (int i = 0; i < edges.length; i++) {
            edges[i] = new ArrayList<>();
        }

        START_VERTEX = fr.nextInt();

        for (int i = 0; i < E; i++) {
            int from = fr.nextInt();
            int to = fr.nextInt();
            int w = fr.nextInt();

            edges[from].add(new Edge(w,to));
        }

        Arrays.fill(dist, Integer.MAX_VALUE);
    }

    private static void pro(){
        dist[START_VERTEX] =0;

        PriorityQueue<Info> pq = new PriorityQueue<>((o1, o2)-> o1.dist - o2.dist);

        pq.add(new Info(START_VERTEX,0));

        while(!pq.isEmpty()){
            Info cur_info = pq.poll();

            if( dist[cur_info.idx] < cur_info.dist) continue;

            for( Edge edge : edges[cur_info.idx]){
                if( edge.weight + dist[cur_info.idx] > dist[edge.to]) continue;

                dist[edge.to] = edge.weight + dist[cur_info.idx];
                pq.add(new Info(edge.to, dist[edge.to]));
            }
        }

        for (int i = 1; i <= V; i++) {
            if(dist[i] == Integer.MAX_VALUE)
                sb.append("INF").append("\n");
            else
                sb.append(dist[i]).append("\n");
        }

        System.out.println(sb.toString());
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
