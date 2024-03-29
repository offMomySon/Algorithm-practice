import java.io.*;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

public class Main {
    private static FastReader fr = new FastReader();
    private static StringBuilder sb = new StringBuilder();
    private static int N, ROOT, ERASE;
    private static int[] parent;
    private static ArrayList<Integer>[] child;
    private static int[] leaf;

    private static void input(){
        N = fr.nextInt();

        parent = new int[N+1];
        child = new ArrayList[N+1];
        for (int i = 0; i < child.length ; i++) {
            child[i] = new ArrayList<>();
        }
        leaf = new int[N+1];

        for (int i = 0; i < N; i++) {
            parent[i] = fr.nextInt();

            if(parent[i] == -1){
                ROOT  = i;
                continue;
            }

            child[parent[i]].add(i);
        }

        ERASE = fr.nextInt();
    }


    private static void dfs(int cur){
        if(child[cur].size() == 0){
            leaf[cur]++;
            return;
        }

        for(int next : child[cur]){
            dfs(next);
            leaf[cur] += leaf[next];
        }
    }

    private static void pro(){
        for (int i = 0; i < N; i++) {
            if(child[i].contains(ERASE)){
                child[i].remove(child[i].indexOf(ERASE));
            }
        }

        if(ROOT != ERASE) dfs(ROOT);

        System.out.println(leaf[ROOT]);
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
