package jlang.util.exception;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.Scanner;

public class InitException extends RuntimeException {
    public InitException(Exception e) {
        super(getExceptionMessage(e));
    }

    private static String getExceptionMessage(Exception e) {
        var stringBuilder = new StringBuilder();
        var exceptionText = exceptionToString(e);
        stringBuilder.append("Something wrong in init!");
        stringBuilder.append(System.lineSeparator()).append(System.lineSeparator());
        stringBuilder.append("Exception text: ");
        stringBuilder.append(exceptionText);
        return stringBuilder.toString();
    }

    private static String exceptionToString(Exception e) {
        var stringBuilder = new StringBuilder();
        var stringWriter = new StringWriter();
        var printWriter = new PrintWriter(stringWriter);
        e.printStackTrace(printWriter);
        var exceptionText = stringWriter.toString();
        var scanner = new Scanner(exceptionText);

        for (int i = 0; scanner.hasNext(); i++) {

            if (i != 0) {
                stringBuilder.append("\t");
            }

            stringBuilder.append(scanner.nextLine());
            stringBuilder.append(System.lineSeparator());
        }

        return stringBuilder.toString();
    }
}
