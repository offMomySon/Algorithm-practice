//날짜 - 2021/08/07
//시작 - 20:15
//종료 - 20:39
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

    public Edge(int to, int weight){
        this.to = to;
        this.weight = weight;
    }
}

public class Main {
    private static FastReader fr = new FastReader();
    private static int N, M;
    private static int START_VERTEX, END_VERTEX;
    private static ArrayList<Edge>[] edges;
    private static int[] dist;

    private static void input(){
        N = fr.nextInt();
        M = fr.nextInt();

        dist = new int[N +1];
        edges = new ArrayList[N +1];
        for (int i = 0; i < edges.length; i++) {
            edges[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            int from = fr.nextInt();
            int to = fr.nextInt();
            int w = fr.nextInt();

            edges[from].add(new Edge(to,w));
        }

        Arrays.fill(dist, Integer.MAX_VALUE);

        START_VERTEX = fr.nextInt();
        END_VERTEX = fr.nextInt();
    }

    private static void pro(){

        PriorityQueue<Info> pq = new PriorityQueue<>((o1,o2)->o1.dist - o2.dist);

        pq.add(new Info(START_VERTEX,0));
        dist[START_VERTEX] = 0;

        while(!pq.isEmpty()){
            Info min_info = pq.poll();

            if(min_info.dist > dist[min_info.idx]) continue;

            for(Edge edge : edges[min_info.idx]){
                if(dist[min_info.idx] + edge.weight >= dist[edge.to]) continue;

                dist[edge.to] = dist[min_info.idx] + edge.weight;
                pq.add(new Info(edge.to, dist[edge.to]));
            }
        }

        System.out.println(dist[END_VERTEX]);

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
