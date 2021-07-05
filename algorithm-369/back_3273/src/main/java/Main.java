import java.io.*;
import java.util.*;

public class Main {
    private static FastScanner fs = new FastScanner();
    private static int N,X,COUNT;
    private static int[] nums;

    private static void input(){
        N = fs.nextInt();

        nums = new int[N+1];

        for (int i = 1; i <= N; i++) nums[i] = fs.nextInt();

        X = fs.nextInt();
    }

    public static int binarySearch(int arr[], int left, int right, int target){
        int res = left;

        while(left<=right){
            int mid = (left+right)/2;

            if(arr[mid] == target)
                return mid;

            if(arr[mid]< target){
                left = mid+1;
            }else if( target <arr[mid] ){
                right = mid-1;
            }
        }

        return res-1;
    }

    public static void main(String[] args) {
        input();

        Arrays.sort(nums,1,nums.length);

        for (int i = 1; i <= nums.length-2; i++) {
            if(binarySearch(nums, i+1,nums.length-1, X - nums[i]) >=i+1 ) COUNT++;
        }

        System.out.println(COUNT);
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
