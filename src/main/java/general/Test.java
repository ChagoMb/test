package general;

import java.util.Arrays;

public class Test {

    public static void main(String[] args) {

        System.out.println(isRight("[()]([][[]])"));
    }


    public static boolean isRight(String regular) {
        char[] tokens = regular.toCharArray();
        int squareBracketsCount = 0;
        int roundBracketsCount = 0;
        System.out.println(Arrays.toString(tokens));
        System.out.println(regular);
        for (int i = 0; i < tokens.length; i++) {
            int temp = i;
            if (squareBracketsCount < 0 || roundBracketsCount < 0) {
                break;
            }
            if (tokens[i] == '[') {
                ++squareBracketsCount;
            }
            if (tokens[i] == ']') {
                if (tokens[--temp] == '(') {
                    break;
                } else {
                    --squareBracketsCount;
                }
            }
            if (tokens[i] == '(') {
                ++roundBracketsCount;
            }
            if (tokens[i] == ')') {
                if (tokens[--temp] == '[') {
                    break;
                } else {
                    --roundBracketsCount;
                }
            }
        }
        return squareBracketsCount == 0 && roundBracketsCount == 0;
    }
}
