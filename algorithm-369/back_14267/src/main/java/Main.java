import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

//날짜 - 2021/08/01
//시작 - 19:10
//종료 - 19:25
//실수 - None
//참조 - None

public class Main {
    private static FastReader fr  = new FastReader();
    private static StringBuilder sb = new StringBuilder();
    private static int N,M;
    private static int[] sum;
    private static ArrayList<Integer>[] child;
    private static int[] parent;
    private static int ROOT;

    private static void input(){
        N = fr.nextInt();
        M = fr.nextInt();

        sum = new int[N+1];
        parent = new int[N+1];
        child = new ArrayList[N+1];
        for (int i = 0; i < child.length; i++) {
            child[i] = new ArrayList<>();
        }

        for (int i = 1; i <= N; i++) {
            parent[i] = fr.nextInt();

            if(parent[i] == -1){
                ROOT = i;
                continue;
            }

            child[parent[i]].add(i);
        }
    }

    private static void dfs(int cur, int prevSum){
        if(child[cur].size() == 0){
            sum[cur] += prevSum;
            return;
        }

        sum[cur] += prevSum;
        for(int next: child[cur]){
            dfs(next, sum[cur]);
        }
    }

    private static void pro(){
        for (int i = 0; i < M; i++) {
            int idx = fr.nextInt();
            int value = fr.nextInt();
            sum[idx] += value;
        }

        dfs(ROOT,0);

        for (int i = 1; i <= N; i++) {
            sb.append(sum[i]).append(" ");
        }

        System.out.println(sb);
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
