package PostfixEvaluator;

import java.util.Scanner;

public class PostfixEvalClient {

    private static String WELCOME = "Welcome to the Postfix Evaluator";
    private static String GOODBYE = "Thanks for using the Postfix Evaluator";
    private static String INPUT_PROMPT =
            "Enter a space-delimited postfix expression: ";
    private static String ERROR_MESSAGE =
            "That doesn't look like a valid postfix expression.";
    private static String GO_AGAIN = "Compute another? (Y/N) ";
    private static char REPEAT_CHAR = 'Y';

    private static Scanner keyb = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println(WELCOME);
        while (true) {
            System.out.println(INPUT_PROMPT);
            String expr = keyb.nextLine();
            String[] parts = expr.split(" ");
            if (!isValidExpression(parts)) {
                System.out.println(ERROR_MESSAGE);
            } else {
                double value = evaluate(parts);
                String outStr = String.format("%s = %f", expr, value);
                System.out.println(outStr);
            }
            // ask whether to repeat for another input
            System.out.print(GO_AGAIN);
            char user_choice = Character.toUpperCase(keyb.nextLine().charAt(0));
            if (user_choice != REPEAT_CHAR) break;
        }
        System.out.println(GOODBYE);
    }

    private static final String SUPPORTED_OPERATORS = "+-*/^";

    private static double evaluate(String[] tokens) {
        return 0;
    }

    private static boolean isValidExpression(String[] tokens) {
        System.out.print("isValidExpression({");
        for (String tkn : tokens) System.out.print(tkn + " ");
        System.out.println("})");
        boolean result = true;
        /*
        the total number of tokens must be odd
         */

        /*
        1st two tokens must be values
         */

        /*
        final token must be an operator
         */

        /*
        there must be one more value than operator
         */

        return result;
    }
}
