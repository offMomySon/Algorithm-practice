public class Main {
    private static StringBuilder sb = new StringBuilder();

    public static int solution(int[] x, int[] y, int[] r, int[] v) {
        int L = Integer.MAX_VALUE;
        int R = Integer.MIN_VALUE;
        int B = Integer.MAX_VALUE;
        int T = Integer.MIN_VALUE;

        for (int i = 0; i <x.length ; i++) {
            L = Math.min(L, x[i]-r[i]);
            R = Math.max(R, x[i]+r[i]);
            B = Math.min(B, y[i]-r[i]);
            T = Math.max(T, y[i]+r[i]);
        }

        int count = 0;

        for (int i = 0; i < v.length ; i= i+2) {
            int converted_x = L + v[i] % (R - L);
            int converted_y = B + v[i+1] % (T - B);


            for (int j = 0; j < x.length; j++) {
                if((converted_x-x[j])*(converted_x-x[j])
                        + (converted_y-y[j])*(converted_y-y[j])
                        <= r[j]*r[j]){
                    count++;
                    break;
                }
            }
        }

        double ratio = (double)count/(double)(v.length/2);
        int rectangle_area = (T-B)*(R-L);

        double rec_area = Math.floor(rectangle_area*ratio);

        return (int)rec_area;
    }


    public static void main(String[] args) {
        int[] x = {3,4};
        int[] y = {3,5};
        int[] r = {2,3};

        int[] v = {12, 83, 54, 35, 686, 337, 258, 95, 170, 831, 8, 15};

        solution(x, y, r, v);
    }
}
