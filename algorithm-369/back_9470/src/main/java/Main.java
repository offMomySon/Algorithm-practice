//날짜 - 2021/08/02
//시작 - 19:41
//종료 - 02:30
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
    private static int K, M, P;
    private static ArrayList<Integer>[] adj;
    private static int[] indegree;
    private static int[] mostBigIndegree;
    private static int[] count;

    private static void input(){
        K = fr.nextInt();
        M = fr.nextInt();
        P = fr.nextInt();

        adj = new ArrayList[M+1];
        for (int i = 0; i < adj.length; i++) {
            adj[i] = new ArrayList<>();
        }

        indegree = new int[M+1];
        mostBigIndegree = new int[M+1];
        count = new int[M+1];

        for (int i = 1; i <= P ; i++) {
            int from = fr.nextInt();
            int to = fr.nextInt();

            adj[from].add(to);
            indegree[to]++;
        }
    }


    private static void pro(){
        Deque<Integer> deque = new LinkedList<>();

        for (int i = 1; i <= M ; i++) {
            if(indegree[i] == 0) {
                deque.add(i);
                mostBigIndegree[i] = 1;
            }
        }

        while(!deque.isEmpty()){
            int vertex = deque.poll();

            for(int next : adj[vertex]){
                if( mostBigIndegree[next] < mostBigIndegree[vertex] ){
                    mostBigIndegree[next] = mostBigIndegree[vertex];
                    count[next] = 1;
                }else if( mostBigIndegree[next] == mostBigIndegree[vertex] ){
                    count[next] ++;
                }

                indegree[next]--;
                if(indegree[next] == 0) {
                    deque.add(next);

                    if(count[next] >=2 ) mostBigIndegree[next]++;
                }
            }
        }

        sb.append(K).append(" ").append(mostBigIndegree[M]).append("\n");
    }

    public static void main(String[] args) {
        int loop = fr.nextInt();

        for (int i = 0; i < loop ; i++) {
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
