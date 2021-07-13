import java.io.*;
import java.util.StringTokenizer;

public class Main {
    private static FastScanner fs = new FastScanner();
    private static StringBuilder sb = new StringBuilder();
    private static int N;
    private static String LINE;
    private static int alpabet[];

    public static void input(){
        N = fs.nextInt();
        LINE = fs.readLine();
        alpabet = new int[26+1];
    }

    private static void pro(){
        int max_len = 0;
        int cur_alpabet_count = 0;

        for (int L = 0, R = -1; L <= LINE.length()-1; L++) {
            while( (R+1 <= LINE.length()-1) &&
                    !( cur_alpabet_count >=N && alpabet[LINE.charAt(R+1)-'a'] == 0 ) ){
                R++;
                if(alpabet[LINE.charAt(R)-'a'] == 0) cur_alpabet_count++;
                alpabet[LINE.charAt(R)-'a']++;
            }

            if(max_len < R-L+1) max_len = R-L+1;

            alpabet[LINE.charAt(L) - 'a']--;
            if(alpabet[LINE.charAt(L) - 'a'] == 0) cur_alpabet_count--;
        }

        System.out.println(max_len);
    }

    public static void main(String[] args) {
        input();
        pro();
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

