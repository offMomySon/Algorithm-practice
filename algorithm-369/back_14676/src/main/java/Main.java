//날짜 - 2021/08/02
//시작 - 19:41
//종료 - 02:30
//실수 -
//참조 -

import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    private static FastReader fr = new FastReader();
    private static StringBuilder sb = new StringBuilder();
    private static int N,M,K;
    private static ArrayList<Integer>[] adj;
    private static int[] indegree;
    private static int[] construct;

    private static void input(){
        N = fr.nextInt();
        M = fr.nextInt();
        K = fr.nextInt();

        adj = new ArrayList[N+1];
        for (int i = 0; i < adj.length; i++) {
            adj[i] = new ArrayList<>();
        }
        indegree = new int[N+1];
        construct = new int[N+1];

        for (int i = 0; i < M; i++) {
            int from = fr.nextInt();
            int to = fr.nextInt();

            adj[from].add(to);
            indegree[to]++;
        }
    }

    private static boolean judge(int op, int cur){
        if(op == 1){
            if(indegree[cur] == 0){
                construct[cur]++;

                if(construct[cur] == 1){
                    for (int next : adj[cur]){
                        indegree[next]--;
                    }
                }
            }
            else
                return false;
        }else{
            if(construct[cur]>0){
                construct[cur]--;
                if(construct[cur] == 0){
                    for(int next: adj[cur]){
                        indegree[next]++;
                    }
                }
            }
            else
                return false;
        }
        return true;
    }

    private static void pro(){
        boolean isPass = true;

        for (int i = 0; i < K; i++) {
            int op = fr.nextInt();
            int cur = fr.nextInt();

            if(!judge(op,cur)){
                isPass = false;
                break;
            }
        }

        if(isPass) System.out.println("King-God-Emperor");
        else System.out.println("Lier!");
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
