import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

//날짜 - 2021/08/01
//시작 - 17:19
//종료 - 17:36
//실수 -
// 1) ROOT node 의 size 가 1 인 케이스에서 예외 처리를 하지않았습니다.
// 2) DP 점화식으로 코드를 구현하지 않음. - DP 로 변경후 불필요한 return 문 사라짐.
//참조 -

public class Main {
    private static int N, ROOT, LOOP;
    private static ArrayList<Integer>[] adj;
    private static FastReader fr  = new FastReader();
    private static StringBuilder sb = new StringBuilder();
    private static int[] count;

    private static void input(){
        N = fr.nextInt();
        ROOT = fr.nextInt();
        LOOP = fr.nextInt();

        adj = new ArrayList[N+1];
        for (int i = 0; i < adj.length ; i++) {
            adj[i] = new ArrayList<>();
        }
        count = new int[N+1];

        for (int i = 1; i <= N-1; i++) {
            int x = fr.nextInt();
            int y = fr.nextInt();

            adj[x].add(y);
            adj[y].add(x);
        }
    }

    private static void dfs(int cur, int parent){
        count[cur] = 1;

        for(int next : adj[cur]){
            if(next == parent) continue;
            dfs(next,cur);
            count[cur] += count[next];
        }
    }

    private static void pro(){
        dfs(ROOT,-1);

        for (int i = 0; i < LOOP; i++) {
            int target = fr.nextInt();

            sb.append(count[target]).append("\n");
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
