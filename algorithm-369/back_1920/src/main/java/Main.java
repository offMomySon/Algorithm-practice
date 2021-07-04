import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    private static FastScanner fs = new FastScanner();
    private static int N,M;
    private static int[] N_group;
    private static int[] M_group;

    private static void input(){
        N = fs.nextInt();
        N_group = new int[N+1];
        for (int i = 1; i <= N; i++) N_group[i] = fs.nextInt();

        M = fs.nextInt();
        M_group = new int[M+1];
        for (int i = 1; i <= M; i++) M_group[i] = fs.nextInt();
    }

    public static int binarySearch(int[] arr, int target){
        int left = 1;
        int right = arr.length-1;

        while(left<=right){
            int mid = (left+right)/2;

            if(arr[mid] == target)
                return 1;

            if(arr[mid] < target) {
                left = mid+1;
            }else if( target < arr[mid]) {
                right = mid-1;
            }
        }

        return 0;
    }

    public static void main(String[] args) {
        input();

        Arrays.sort(N_group);
//        Arrays.sort(M_group);

        for (int i = 1; i <= M_group.length-1; i++) {
            System.out.println(binarySearch(N_group,M_group[i]));
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
