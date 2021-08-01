import java.io.*;
import java.util.*;

//날짜 - 2021/08/01
//시작 - 20:55
//종료 - 21:17
//실수 - None
//참조 - None

public class Main {
    private static FastReader fr = new FastReader();
    private static StringBuilder sb = new StringBuilder();
    private static int N,M;
    private static int[] indegree;
    private static ArrayList<Integer>[] adj;

    private static void input(){
        N = fr.nextInt();
        M = fr.nextInt();

        indegree = new int[N+1];
        adj = new ArrayList[N+1];
        for (int i = 0; i < adj.length; i++) {
            adj[i] = new ArrayList<>();
        }

        for (int i = 0; i < M ; i++) {
            int from = fr.nextInt();
            int to = fr.nextInt();

            adj[from].add(to);
            indegree[to]++;
        }
    }

    private static void pro(){
        Deque<Integer> deque = new LinkedList();

        for (int i = 1; i <=N ; i++) {
            if(indegree[i] == 0) deque.add(i);
        }

        while(!deque.isEmpty()) {
            Integer vertex = deque.poll();

            sb.append(vertex).append(" ");
            for(int next_vertex : adj[vertex]) {
                indegree[next_vertex]--;
                if(indegree[next_vertex] == 0) deque.add(next_vertex);
            }
        }

        System.out.println(sb.toString()) ;
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
