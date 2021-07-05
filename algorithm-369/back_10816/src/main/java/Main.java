import java.io.*;
import java.util.*;

public class Main {
    private static FastScanner fs = new FastScanner();
    private static StringBuilder sb = new StringBuilder();
    private static int N,M;
    private static int[] group_A;
    private static int[] group_B;

    private static void input(){
        N = fs.nextInt();
        group_A = new int[N+1];
        for (int i = 1; i <= N; i++) group_A[i] = fs.nextInt();

        M = fs.nextInt();
        group_B = new int[M+1];
        for (int i = 1; i <= M; i++) group_B[i] = fs.nextInt();
    }

    public static int binarySearch(int arr[], int left, int right, int target){
        int res = left-1;

        while(left<=right){
            int mid = (left+right)/2;

            if(arr[mid] == target) return mid;

            if(target < arr[mid]){
                right = mid-1;
            }else{
                left = mid+1;
            }
        }
        return res;
    }

    public static int lower_bound(int arr[], int left, int right, int target){
        int res = right+1;

        while(left<=right){
            int mid = (left+right)/2;

            if(target <= arr[mid] ){
                res = mid;
                right = mid-1;
            }else if(arr[mid] < target){
                left = mid+1;
            }
        }
        return res;
    }

    public static int upper_bound(int arr[], int left, int right, int target){
        int res = right+1;

        while(left <= right){
            int mid = (left+right)/2;

            if(target < arr[mid]){
                res = mid;
                right = mid -1;
            }else{
                left = mid+1;
            }
        }

        return res;
    }


    public static void main(String[] args) {
        input();

        Arrays.sort(group_A, 1, group_A.length);

        for (int i = 1; i <= group_B.length-1 ; i++) {

            int lower_bound = lower_bound(group_A, 1, group_A.length - 1, group_B[i]);
            int upper_bound = upper_bound(group_A, 1, group_A.length - 1, group_B[i]);
            sb.append(upper_bound-lower_bound).append(" ");

        }

        System.out.println(sb);
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
