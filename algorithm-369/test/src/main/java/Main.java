import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    private static FastScanner fr = new FastScanner();
    private static List<Integer>[] subway;
    private static int[] dist;
    private static boolean[] isvisited;
    private static int N,END;

    public static void bfs(int end){
        Queue<Integer> q = new LinkedList<>();
        boolean isTrue = false;

        for (int i = 1; i <= N; i++) {
            for (int j = 0; j < subway[i].size(); j++) {
                if(0 == subway[i].get(j)){
                    isvisited[i] = true;
                    dist[i] = 0;
                    q.add(i);
                }
            }
        }

        while (!q.isEmpty()){
            int cur_line = q.poll();

            for (int i = 0; i < subway[cur_line].size(); i++) {
                if (subway[cur_line].get(i) == END) {
                    System.out.println(dist[cur_line]);
                    isTrue = true;
                    break;
                }
            }

            for (int i = 0; i < subway[cur_line].size(); i++) {
                for (int j = 1; j<= N ;j++) {
                    if(cur_line != j) {
                        for (int k = 0; k < subway[j].size(); k++) {
                            if(subway[cur_line].get(i).equals(subway[j].get(k)) && !isvisited[j]){
                                isvisited[j] = true;
                                dist[j] = dist[cur_line]+1;
                                q.add(j);
                            }
                        }
                    }
                }
            }
            if (isTrue == true) {
                break;
            }
        }

        if (isTrue == false) {
            System.out.println(-1);
        }
    }

    public static void input(){
        N = fr.nextInt();
        subway = new ArrayList[N+1];
        dist = new int[N+1];
        isvisited = new boolean[N+1];

        for (int i = 0; i < subway.length; i++) {
            subway[i] = new ArrayList<>();
        }


        for (int i = 1; i <= N; i++) {
            int len = fr.nextInt();
            for (int j = 0; j < len; j++) {
                subway[i].add(fr.nextInt());
            }
        }
        END = fr.nextInt();
    }

    public static void main(String[] args) {
//        String[] str = {"1 2 3 1", "0 9 4 7 99", "8 10 7 9"};
//
//        solution(str, 0, 10);
//        String[] str = {"0 2 3", "2 5 7 10", "10 8"};
        input();
        bfs(END);
    }
    static class FastScanner{
        private StringTokenizer st;
        private BufferedReader bf;

        public FastScanner(){
            bf = new BufferedReader(new InputStreamReader(System.in));
        }
        public FastScanner(String f) throws FileNotFoundException {
            bf = new BufferedReader(new FileReader(new File(f)));
        }

        private String next(){
            while(st == null || !st.hasMoreTokens()){
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

        public long nextLong(){
            return Long.parseLong(next());
        }

        public double nextDouble(){
            return Double.parseDouble(next());
        }

        public String readLine(){
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
