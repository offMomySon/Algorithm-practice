import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    private static FastScanner fs = new FastScanner();
    private static int REPEAT_TEST_COUNT, aSize, bSize;
    private static int left, right, count;
    private static int[] A_group;
    private static int[] B_group;

    private static void input(){
        aSize = fs.nextInt();
        bSize = fs.nextInt();
        count = 0;

        A_group = new int[aSize+1];
        B_group = new int[bSize+1];

        left = 1;
        right = bSize;

        for (int i = 1; i <= aSize; i++) A_group[i] = fs.nextInt();
        for (int i = 1; i <= bSize; i++) B_group[i] = fs.nextInt();
    }


    public static int lower_bound(int[] arr, int target){
        int left = 1;
        int right = arr.length-1;
        int result = 0;

        while(left<=right){
            int mid = (left+right)/2;

            if(arr[mid] < target){
                result = mid;
                left = mid+1;
            } else if(target <= arr[mid]){
                right = mid-1;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        REPEAT_TEST_COUNT = fs.nextInt();

        for (int i = 0; i < REPEAT_TEST_COUNT; i++) {
            input();

            Arrays.sort(A_group);
            Arrays.sort(B_group);

            for (int index = 1; index <= aSize ; index++) {
                count += lower_bound(B_group, A_group[index]);
            }

            System.out.println(count);
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
