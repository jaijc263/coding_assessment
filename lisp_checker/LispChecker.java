public class LispChecker {

    public static void main(String[] args) {
        String lispCode = "public void checkNum(int x) {\n" +
                "    if (x > 0) {\n" +
                "        System.out.println(\"Positive\");\n" +
                "    } else if (x < 0) {\n" +
                "        System.out.println(\"Negative\");\n" +
                "    } else {\n" +
                "        System.out.println(\"Zero\");\n" +
                "    }\n" +
                "}";

        if (isValid(lispCode)) {
            System.out.println("The parentheses in the string are properly closed and nested.");
        } else {
            System.out.println("The parentheses are not balanced.");
        }
    }
    public static boolean isValid(String code) {
        int count = 0;
        int length = code.length();

        for (int i = 0; i < length; i++) {
            char c = code.charAt(i);

            if (c == '(') {
                count++;
            } else if (c == ')') {
                count--;

                //there are more closing parentheses if count becomes negative
                if (count < 0) {
                    return false;
                }
            }
        }

        //there are more opening parentheses if count is not zero
        return count == 0;
    }
}
