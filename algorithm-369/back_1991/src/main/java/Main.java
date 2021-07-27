import java.io.*;
import java.util.StringTokenizer;

public class Main {
    private static FastReader fr = new FastReader();
    private static StringBuilder sb = new StringBuilder();

    private static int N;
    private static int[][] adj;

    public static void input(){
        N = fr.nextInt();

        adj = new int[31][3];

        for (int i = 0; i < N; i++) {

            int row = (int)(fr.next().charAt(0)-'A');

            for (int j = 1; j <= 2; j++) {
                int tempCh = fr.next().charAt(0);
                if(tempCh == '.') adj[row][j] = -1;
                else adj[row][j] = (int)(tempCh - 'A');
            }
        }
    }

    public static void inOrder(int pos){
        if(pos == -1) return;
        inOrder(adj[pos][1]);
        sb.append((char)(pos + 'A'));
        inOrder(adj[pos][2]);
    }

    public static void preOrder(int pos){
        if(pos == -1 ) return;
        sb.append((char)(pos + 'A'));
        preOrder(adj[pos][1]);
        preOrder(adj[pos][2]);
    }

    public static void postOrder(int pos){
        if(pos == -1) return;
        postOrder(adj[pos][1]);
        postOrder(adj[pos][2]);
        sb.append((char)(pos + 'A'));
    }

    public static void pro(){
        preOrder(0);
        sb.append("\n");
        inOrder(0);
        sb.append("\n");
        postOrder(0);

        System.out.println(sb.toString());
    }

    public static void main(String[] args) {
        input();
        pro();
    }

    static class FastReader{
        private BufferedReader br;
        private StringTokenizer st;

        public FastReader(){
            br = new BufferedReader(new InputStreamReader(System.in));
        }
        public FastReader(String f) throws FileNotFoundException {
            br = new BufferedReader(new FileReader(new File(f)));
        }

        public String next(){
            while(st == null || !st.hasMoreElements()){
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        private int nextInt(){
            return Integer.parseInt(next());
        }
        private long nextLong(){
            return Long.parseLong(next());
        }
        private double nextDouble(){
            return Double.parseDouble(next());
        }
        private String nextLine(){
            String str = "";
            try {
                str = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }
    }
}
