import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        String amount = "1000,,000";

        System.out.println(solution(amount));
    }

    public static boolean solution(String amountText) {
        boolean answer = true;

        // 앞과 뒤에 , 가 오면 안된다.
        if(amountText.charAt(0) == ',' || amountText.charAt(amountText.length()-1)==',')
            return false;
        // 첫번째 자리에 0 이 오면 안된다.
        if(amountText.charAt(0) == '0')
            return false;

        // ,가 나오면 일관되게 , 를 검사해야한다.
        // ,가 나와야하는 위치가 아니면 나오지 않아야한다.
        if(amountText.contains(",")){
            int searchIdx = 0;
            if ( amountText.length() >=4 )
                searchIdx = amountText.length() -4;

            for (int idx = amountText.length()-1; idx >= 0; idx--) {
                if(amountText.charAt(idx) == ',' && searchIdx != idx) return false;

                if(searchIdx == idx){
                    if(amountText.charAt(idx) != ',') return false;

                    searchIdx -= 4;
                }
            }
        }

        // number detect
        for (int i = 0; i < amountText.length() ; i++) {
            if(amountText.charAt(i) == ',') continue;

            if( amountText.charAt(i) - '0'>9 || amountText.charAt(i) - '0' < 0 )
                return false;
        }
        return answer;
    }
}
