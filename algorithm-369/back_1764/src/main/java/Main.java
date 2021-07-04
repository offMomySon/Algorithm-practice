import java.io.*;
import java.util.*;

public class Main {
    private static FastScanner fs = new FastScanner();
    private static int N,M,COUNT;
    private static String[] N_group;
    private static String[] M_group;
    private static List<String> result_name;

    private static void input(){
        N = fs.nextInt();
        M = fs.nextInt();

        result_name = new ArrayList<>();
        N_group = new String[N];
        M_group = new String[M];

        for (int i = 0; i <= N-1; i++) N_group[i] = fs.readLine();
        for (int i = 0; i <= M-1; i++) M_group[i] = fs.readLine();
    }

    public static void main(String[] args) {
        input();

        Arrays.sort(M_group);

        for (int i = 0; i < N_group.length; i++) {
            int resultIndex = Arrays.binarySearch(M_group,N_group[i]);

            if( resultIndex >=0){
                result_name.add(M_group[resultIndex]);
            }
        }

        Collections.sort(result_name);

        System.out.println(result_name.size());
        for(String name : result_name){
            System.out.println(name);
        }
    }

    static class FastScanner{
        private StringTokenizer st;
        private BufferedReader br;

        public FastScanner() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }
        public FastScanner(String f) throws FileNotFoundException {
            br = new BufferedReader(new FileReader(new File(f)));
        }

        private String next(){
            while((st == null || !st.hasMoreTokens())){
                try {
                    st = new StringTokenizer(br.readLine());
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
                str = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }
    }

}
