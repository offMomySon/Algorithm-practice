//날짜 - 2021/08/03
//시작 - 20:11
//종료 - 20:35
//실수 -
//참조 -

import java.io.*;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
    private static FastReader fr = new FastReader();
    private static StringBuilder sb = new StringBuilder();
    private static int N,K;
    private static int build_time[];
    private static int pass_time[];
    private static int indegree[];
    private static ArrayList<Integer>[] adj;
    private static int TARGET;

    private static void input(){
        N = fr.nextInt();
        K = fr.nextInt();

        build_time = new int[N+1];
        pass_time = new int[N+1];
        indegree = new int[N+1];
        adj = new ArrayList[N+1];
        for (int i = 0; i < adj.length; i++) {
            adj[i] = new ArrayList<>();
        }

        for (int i = 1; i <= N; i++) {
            build_time[i] = fr.nextInt();
        }

        for (int i = 0; i < K; i++) {
            int from = fr.nextInt();
            int to = fr.nextInt();

            adj[from].add(to);

            indegree[to]++;
        }

        TARGET = fr.nextInt();
    }

    private static void pro(){
        Deque<Integer> deque = new LinkedList<>();

        for (int i = 1; i <= N ; i++) {
            if(indegree[i]== 0){
                deque.add(i);
                pass_time[i] = build_time[i];
            }
        }

        while(!deque.isEmpty()){
            int cur_vertex = deque.poll();

            for(int next_vertex: adj[cur_vertex]){

                pass_time[next_vertex] = Math.max(pass_time[cur_vertex] + build_time[next_vertex], pass_time[next_vertex]);

                indegree[next_vertex]--;
                if(indegree[next_vertex] == 0){
                    deque.add(next_vertex);
                }
            }
        }

        sb.append(pass_time[TARGET]).append("\n");
    }

    public static void main(String[] args) {
        int loop = fr.nextInt();

        for (int i = 0; i < loop; i++) {
            input();
            pro();
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
