//날짜 - 2021/07/29
//시작 - 05:47
//종료 - 02:30
//실수 -
//참조 -

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    private static FastReader fr = new FastReader();
    private static StringBuilder sb = new StringBuilder();
    private static boolean[] visited;
    private static int N,Q;

    private static void input(){
        N = fr.nextInt();
        Q = fr.nextInt();

        visited = new boolean[N+1];
    }

    private static void pro(){
        for (int i = 0; i < Q; i++) {
            int x = fr.nextInt();

            sb.append(dfs(x)+"\n");

            visited[x] = true;
        }

        System.out.println(sb.toString());
    }

    private static int dfs(int cur){
        if(cur == 0) return 0;

        int prev_result = dfs(cur / 2);
        if(prev_result == 0 && visited[cur]) return cur;

        return prev_result;
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
