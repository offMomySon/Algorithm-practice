import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    private static FastReader fr = new FastReader();
    private static StringBuffer sb = new StringBuffer();
    private static int MAX_NUM = 50001;
    private static int MAX_LEVEL = getMaxLevel(MAX_NUM);
    private static int N;
    private static ArrayList<Integer>[] adj;
    private static int[][] ancestor;
    private static int[] depth;

    private static int getMaxLevel(int num){
        return (int)(Math.floor(Math.log(num)/Math.log(2)));
    }

    private static void input(){
        N = fr.nextInt();

        adj = new ArrayList[N+1];
        for (int i = 0; i <= N; i++) {
            adj[i] = new ArrayList<>();
        }

        ancestor = new int[N+1][MAX_LEVEL+1];
        depth = new int[N+1];
        depth[0] = -1;

        for (int i = 0; i < N-1; i++) {
            int x = fr.nextInt();
            int y = fr.nextInt();

            adj[x].add(y);
            adj[y].add(x);
        }
    }

    private static void makeTree(int cur, int parent){
        depth[cur] = depth[parent] +1;
        ancestor[cur][0] = parent;

        for (int i = 1; i <= MAX_LEVEL; i++) {
            int temp = ancestor[cur][i-1];
            ancestor[cur][i] = ancestor[temp][i-1];
        }

        for(int next : adj[cur]){
            if( next == parent) continue;
            makeTree(next, cur);
        }
    }

    private static void findCommonAncestor(int a, int b){
        if(depth[a] != depth[b]){
            if(depth[a]> depth[b]){
                int temp = a;
                a = b;
                b = temp;
            }

            for (int i = MAX_LEVEL; i >= 0 ; i--) {
                if(depth[a] <= depth[ancestor[b][i]] ){
                    b = ancestor[b][i];
                }
            }
        }

        int lsb = a;
        if(a != b){
            for (int i = MAX_LEVEL; i >= 0; i--) {
                if(ancestor[a][i] != ancestor[b][i]){
                    a = ancestor[a][i];
                    b = ancestor[b][i];
                }
            }
            lsb = ancestor[a][0];
        }
        sb.append(lsb + "\n");
    }

    private static void pro(){
        makeTree(1,0);

        int loop = fr.nextInt();

        for (int i = 0; i < loop; i++) {
            int a = fr.nextInt();
            int b = fr.nextInt();

            findCommonAncestor(a,b);
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
