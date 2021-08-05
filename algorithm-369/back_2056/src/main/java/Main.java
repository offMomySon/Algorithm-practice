//날짜 - 2021/08/06
//시작 - 04:15
//종료 - 04:53
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
    private static int N;
    private static ArrayList<Integer>[] adj;
    private static int[] indegree;
    private static int[] min_time;
    private static int[] build_time;

    private static void input(){
        N = fr.nextInt();

        adj = new ArrayList[N+1];
        for (int i = 0; i < adj.length; i++) {
            adj[i] = new ArrayList<>();
        }

        indegree = new int[N+1];
        min_time = new int[N+1];
        build_time = new int[N+1];

        for (int i = 1; i <= N; i++) {
            build_time[i] = fr.nextInt();

            int count = fr.nextInt();
            for (int j = 0; j < count; j++) {
                int prev_vertex = fr.nextInt();

                adj[prev_vertex].add(i);
                indegree[i]++;
            }
        }

    }

    private static void pro(){
        Deque<Integer> deque = new LinkedList<>();

        for (int i = 1; i <= N ; i++) {
            if(indegree[i] == 0){
                deque.add(i);
                min_time[i] = build_time[i];
            }
        }

        while(!deque.isEmpty()){
            int cur_vertex = deque.poll();

            for(int next_vertex : adj[cur_vertex]){
                min_time[next_vertex] = Math.max(min_time[next_vertex], min_time[cur_vertex] + build_time[next_vertex]);

                indegree[next_vertex]--;
                if (indegree[next_vertex] == 0){
                    deque.add(next_vertex);
                }
            }
        }
        int result = 0;

        for (int i = 1; i <= N ; i++) {
            result = Math.max(result, min_time[i]);
        }

        sb.append(result);
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
