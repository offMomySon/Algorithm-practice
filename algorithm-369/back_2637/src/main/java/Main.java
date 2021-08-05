//날짜 - 2021/08/06
//시작 - 05:20
//종료 - 07:35
//실수 -
//참조 -

import java.io.*;
import java.util.*;

public class Main {
    private static FastReader fr = new FastReader();
    private static StringBuilder sb = new StringBuilder();
    private static int N, M;
    private static int indegree[];
    private static HashMap<Integer,Integer>[] composited;
    private static ArrayList<Integer>[] adj;
    private static ArrayList<Integer> basic;

    private static void input(){
        N = fr.nextInt();
        M = fr.nextInt();

        basic = new ArrayList<>();
        indegree = new int[N+1];
        composited = new HashMap[N+1];
        adj = new ArrayList[N+1];

        for (int i = 0; i < adj.length ; i++) {
            composited[i] = new HashMap<>();
            adj[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            int to = fr.nextInt();
            int from = fr.nextInt();
            int count = fr.nextInt();

            adj[from].add(to);
            indegree[to]++;
            composited[to].put(from,count);
        }

        for (int i = 1; i <= N ; i++) {
            if(indegree[i] ==0){
//                composited[i].put(i,1);
                basic.add(i);
            }
        }

    }

    private static void pro(){
        Deque<Integer> deque = new LinkedList<>();

        for (int i = 1; i <= N; i++) {
            if(indegree[i] ==0){
                deque.add(i);
            }
        }

        while(!deque.isEmpty()){
            int cur_vertex = deque.poll();

            for(int next_vertex: adj[cur_vertex]){
                int cur_vertex_count = composited[next_vertex].get(cur_vertex);

                for(int keys:  composited[cur_vertex].keySet()){
//                    if(basic.contains(keys)) continue;

                    composited[next_vertex].put(
                            keys,
                            composited[next_vertex].containsKey(keys) ?
                                    composited[next_vertex].get(keys) + cur_vertex_count * composited[cur_vertex].get(keys) :
                                    cur_vertex_count * composited[cur_vertex].get(keys) );

                }

                indegree[next_vertex]--;
                if(indegree[next_vertex] == 0){
                    deque.add(next_vertex);
                }
            }
        }


        for (Integer integer : basic) {
            if(composited[N].containsKey(integer))
                sb.append(integer).append(" ").append(composited[N].get(integer)).append("\n");
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
