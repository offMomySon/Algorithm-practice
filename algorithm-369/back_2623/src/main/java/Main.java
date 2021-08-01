import java.io.*;
import java.util.*;

//날짜 - 2021/08/02
//시작 - 01:52
//종료 - 01:44
//실수 - None
//참조 - None

public class Main {
    private static FastReader fr = new FastReader();
    private static StringBuilder sb = new StringBuilder();
    private static int N,M;
    private static ArrayList<Integer>[] adj;
    private static boolean[] visited;
    private static boolean[] progress;
    private static int[] tempArr;
    private static int[] indegree;

    private static void input(){
        N = fr.nextInt();
        M = fr.nextInt();

        indegree = new int[N+1];
        visited = new boolean[N+1];
        progress = new boolean[N+1];
        adj = new ArrayList[N+1];

        for (int i = 0; i < adj.length; i++) {
            adj[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            int n  = fr.nextInt();
            tempArr = new int[n+1];

            for (int j = 1; j <= n; j++) {
                tempArr[j] = fr.nextInt();
            }

            for (int j = 1; j <=n-1; j++) {
                adj[tempArr[j]].add(tempArr[j+1]);
                indegree[tempArr[j+1]]++;
            }
        }
    }

    private static boolean isCyclic(int vertex){
        visited[vertex] = true;
        progress[vertex] = true;

        for(int next : adj[vertex]){
            if(!visited[next]) {
                if (isCyclic(next)) return true;
            }
            else if(progress[next])
                return true;
        }

        progress[vertex] = false;
        return false;
    }

    private static void topologicalSort(){
        Deque<Integer> deque = new LinkedList<>();

        for (int i = 1; i <=N ; i++) {
            if(indegree[i] == 0)
                deque.add(i);
        }

        while (!deque.isEmpty()){
            int vertex = deque.poll();

            sb.append(vertex).append("\n");

            for(int next: adj[vertex]){
                indegree[next]--;
                if(indegree[next] == 0) deque.add(next);
            }
        }
    }

    private static void pro(){
        if(isCyclic(tempArr[1])){
            sb.append("0");
        }else{
            topologicalSort();
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
