import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Main {

    private static Integer[] selected;
    private static int parts_len =0;
    private static int max_count =0;

    private static void dfs(int[][] parts, int K,int R){
        if( K == R){
            Set<Integer> set = new HashSet<>(Arrays.asList(selected));
            int count =0 ;

            for (int i = 0; i <parts.length ; i++) {
                boolean isMakeable = true;
                for (int j = 0; j <parts[i].length ; j++) {
                    if(parts[i][j] ==1){
                        if(!set.contains(j)){
                            isMakeable = false;
                            break;
                        }
                    }
                }

                if(isMakeable)
                    count++;
            }

            max_count = Math.max(count,max_count);

            return;
        }

        int start;
        if(K==0){
            start =0 ;
        }
        else{
            start = selected[K-1]+1;
        }

        for (int i = start; i < parts_len ; i++) {
            selected[K] = i;
            dfs(parts,K+1, R);
            selected[K] = 0;
        }
    }

    private static void process(int[][] parts, int r){
        for (int i = 0; i < parts.length; i++) {
            parts_len = Math.max(parts_len,parts[i].length);
        }
        selected = new Integer[r];
        Arrays.fill(selected,-1);

        dfs(parts,0,r);

        System.out.println(max_count);
    }



    public static void main(String[] args) {
        int[][] parts = {
                { 1, 0, 0 },
                {1, 1, 0, 1, 1},
                {1, 0, 0,1},
                {1, 0, 1},
                {1, 1, 0},
                {0, 1, 1,1}};
        process(parts,1);
    }

}
