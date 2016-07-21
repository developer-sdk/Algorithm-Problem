package sdk.algo;

import java.util.HashMap;
import java.util.Scanner;

/**
 * 비밀편지
 * 처리
 * @author whitebeard
 *
 */
public class Problem1239 {
    
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        String input = in.next();
        in.close();
        
//        int n = 3;
//        String input = "001111000000011100";
        
//        int n = 5;
//        String input = "011111000000111111000000111111";
        
        HashMap<String, String> map = new HashMap<>();
        map.put("000000", "A");
        map.put("001111", "B");
        map.put("010011", "C");
        map.put("011100", "D");
        map.put("100110", "E");
        map.put("101001", "F");
        map.put("110101", "G");
        map.put("111010", "H");

        StringBuffer buffer = new StringBuffer();
        for(int i = 0; i < n; i++ ) {
            // 입력 받은 문자열을 6개씩 끊어서 
            String str = input.substring(6*i, 6*(i+1));
            String result = map.get(str);
            
            if(result == null) {
                for(String key : map.keySet()) {
                    char[] keys = key.toCharArray();
                    char[] strs = str.toCharArray();
                    
                    int count = 0;
                    for(int j = 0; j < keys.length; j++) {
                        if(keys[j] != strs[j]) {
                            count++;
                        }
                    }
                
                    if(count == 1) {
                        result = map.get(key);
                        break;
                    }
                }
            }
            
            
            if(result != null) {
                buffer.append(result);
            } else {
                System.out.println(i+1);
                return;
            }
        }
        
        System.out.println(buffer.toString());
    }
    
}