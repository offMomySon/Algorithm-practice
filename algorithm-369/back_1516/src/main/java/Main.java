//날짜 - 2021/08/05
//시작 - 01:50
//종료 - 02:20
//실수 -
//참조 -

import java.io.*;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
    private static FastReader fr = new FastReader();
    private static StringBuilder sb = new StringBuilder();
    private static ArrayList<Integer>[] adj;
    private static int build_time[];
    private static int min_time[];
    private static int indegree[];
    private static int N;

    private static void input(){
        N = fr.nextInt();

        adj = new ArrayList[N+1];
        for (int i = 0; i < adj.length; i++) {
            adj[i] = new ArrayList<>();
        }
        build_time = new int[N+1];
        min_time = new int[N+1];
        indegree = new int[N+1];

        for (int i = 1; i <= N ; i++) {
            build_time[i] = fr.nextInt();
            while(true){
                int from = fr.nextInt();

                if(from == -1) break;

                indegree[i]++;
                adj[from].add(i);
            }
        }
    }

    private static void pro(){
        Deque<Integer> deque = new LinkedList<>();

        for (int i = 1; i <=N ; i++) {
            if(indegree[i] == 0){
                deque.add(i);
                min_time[i] = build_time[i];
            }
        }

        while(!deque.isEmpty()){
            int cur_vertex = deque.poll();

            for(int next_vertex: adj[cur_vertex]){
                indegree[next_vertex]--;

                min_time[next_vertex] = Math.max(build_time[next_vertex]+min_time[cur_vertex], min_time[next_vertex]);

                if(indegree[next_vertex] == 0){
                    deque.add(next_vertex);
                }
            }
        }

        for (int i = 1; i <= N; i++) {
            sb.append(min_time[i]).append("\n");
        }

    }

    public static void main(String[] args) {
        input();
        pro();

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
