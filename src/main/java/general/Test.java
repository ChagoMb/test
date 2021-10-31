package general;

import java.util.Arrays;

public class Test {

    public static void main(String[] args) {

        System.out.println(isRight("[()]([][[]])"));
    }


    public static boolean isRight(String regular) {
        char[] tokens = regular.toCharArray();
        int parCount = 0;
        int boxCount = 0;

        if (tokens[0] == ']' || tokens[0] == ')') {
            return false;
        }

        for (int i = 0; i < tokens.length; i++) {
            int temp = i;
            if (parCount < 0 || boxCount < 0) {
                break;
            }

            switch (tokens[i]) {
                case '[':
                    ++parCount;
                    break;

                case ']':
                    if (tokens[--temp] == '(') {
                        break;
                    } else {
                        --parCount;
                    }

                case '(':
                    ++boxCount;

                case ')':
                    if (tokens[--temp] == '[') {
                        break;
                    } else {
                        --boxCount;
                    }
            }
        }

        return parCount == 0 && boxCount == 0;
    }
}
