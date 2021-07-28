import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

//날짜 - 2021/07/29
//시작 - 03:17
//종료 - 03
//실수 - 문체 출력 형식을 잘못 지정함 "YES" -> "Yes" 로 변경.
//참조 -

public class Main {
    private static FastReader fr = new FastReader();
    private static int N;
    private static ArrayList<Integer>[] adj;

    private static void input(){
        N = fr.nextInt();

        adj = new ArrayList[N+1];
        for (int i = 0; i < adj.length; i++) {
            adj[i] = new ArrayList<>();
        }

        for (int i = 1; i <=N-1; i++) {
            int x = fr.nextInt();
            int y = fr.nextInt();

            adj[x].add(y);
            adj[y].add(x);
        }
    }

    private static long dfs(int cur, int par, int cur_depth){
        if(adj[cur].size() == 1 && par != -1) return  cur_depth;

        long total_depth = 0;
        for(int child : adj[cur]){
            if(child == par) continue;
            total_depth += dfs(child, cur, cur_depth+1);
        }
        return total_depth;
    }

    private static void pro(){
        long total_depth = dfs(1, -1,0);

//        System.out.println(total_depth);

        if(total_depth%2 == 0) System.out.println("No");
        else System.out.println("Yes");
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
