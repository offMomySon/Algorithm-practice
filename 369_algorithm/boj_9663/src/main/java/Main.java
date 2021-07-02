import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    public static FastScanner fs;
    public static int N, count;
    public static ArrayList<Integer> candidate;

    public static void input(){
        fs = new FastScanner();
        N = fs.nextInt();
        candidate = new ArrayList<>();
    }

    public static boolean isAvailable(int selectedCol){
        int row = candidate.size();

        for (int index = 0; index < candidate.size(); index++) {
            if( candidate.get(index) == selectedCol ||
            Math.abs(selectedCol - candidate.get(index)) == row - index )
                return false;
        }
        return true;
    }

    public static void positionQueen(int k){
        if(k == N){
            count++;
            return;
        }

        for (int col = 0; col < N; col++) {
            if(!isAvailable(col))
                continue;

            candidate.add(col);
            positionQueen(k+1);
            candidate.remove(candidate.size()-1);
        }

    }

    public static void main(String[] args) {
        input();

        positionQueen(0);
        System.out.println(count);
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
