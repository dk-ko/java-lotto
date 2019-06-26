package camp.nextstep.edu.calculator;

import java.util.Objects;
import java.util.stream.Stream;

public class StringAdditionCalculator {

    private static final String EMPTY_STRING = "";
    private static final String REGEX_DELIMITERS = "[,:]";
    private static final int ZERO = 0;

    private static final String PREFIX_OF_CUSTOM_DELIMITER = "//";
    private static final int MINIMUM_LENGTH_OF_CUSTOM_DELIMITER_INPUT = 4;
    private static final int INDEX_OF_CUSTOM_DELIMITER = 2;
    private static final int INDEX_OF_POSTFIX_CUSTOM_DELIMITER = 3;
    private static final int INDEX_OF_BEGINNING_TOKENS = 4;
    private static final char NEW_LINE_CHARACTER = '\n';

    public int calculate(String input) {
        if (input == null) {
            return ZERO;
        }
        if (this.isValidFormatOfCustomDelimiter(input)) {
            final char customDelimiterCharacter = input.charAt(INDEX_OF_CUSTOM_DELIMITER);
            final String customDelimiter = String.valueOf(customDelimiterCharacter);
            final String restOfInput = input.substring(INDEX_OF_BEGINNING_TOKENS);
            return this.resolve(customDelimiter, restOfInput);
        }
        return this.resolve(REGEX_DELIMITERS, input);
    }

    private int resolve(String regexOfDelimiter, String tokens) {
        if (EMPTY_STRING.equals(tokens)) {
            return ZERO;
        }
        final String[] splitString = tokens.split(regexOfDelimiter);
        if (this.hasNegativeNumber(splitString)) {
            throw new RuntimeException("All numbers must be greater than or equal to " + ZERO);
        }
        return Stream.of(splitString)
                .map(Integer::parseInt)
                .reduce(ZERO, Integer::sum);
    }

    private boolean isValidFormatOfCustomDelimiter(String input) {
        return input.startsWith(PREFIX_OF_CUSTOM_DELIMITER)
                && input.length() >= MINIMUM_LENGTH_OF_CUSTOM_DELIMITER_INPUT
                && Objects.equals(NEW_LINE_CHARACTER, input.charAt(INDEX_OF_POSTFIX_CUSTOM_DELIMITER));
    }

    private boolean hasNegativeNumber(String[] splitString) {
        return Stream.of(splitString)
                .map(Integer::parseInt)
                .anyMatch(number -> number < ZERO);
    }

}