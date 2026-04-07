package kakao;

import java.io.BufferedReader;
import java.io.*;
class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        int result = (input.charAt(0) -'0')*(input.charAt(3) -'0')-(input.charAt(1) -'0')*(input.charAt(2) -'0');
        System.out.println(result);
        //System.out.println("Hello Goorm! Your input is " + input);
    }
}
