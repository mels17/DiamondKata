package main;

import java.util.ArrayList;
import java.util.List;

public class Diamond {
    private String middleLine;
    private final String STAR = "*";
    private final String SPACE = " ";
    private final String NEWLINE = "\n";

    private final int STARS_REDUCED_PER_LINE = 2;

    private boolean isOdd(int number) {
        return (number % 2 == 0);
    }

    private boolean isPositiveInteger(int number) {
        return (number > 0);
    }

    private String getMiddleLine() {
        return this.middleLine;
    }

    private void setMiddleLine(int noOfStars) {
        StringBuffer middleLine = new StringBuffer();

        for ( int i = 0; i < noOfStars; i++) {
            middleLine.append("*");
        }

        middleLine.append("\n");
        this.middleLine = middleLine.toString();
    }

    private String concatenateStrings(List<String> input) {
        StringBuffer output = new StringBuffer();

        for (String entry: input) {
            output.append(entry);
        }
        return output.toString();
    }

    private String getReversedString(List<String> input) {
        StringBuffer output = new StringBuffer();

        for (int i = input.size() - 1; i >= 0; i--) {
            output.append(input.get(i));
        }
        return output.toString();
    }

    private List<String> getLineStrings(int noOfLines) {
        int middleLine = (noOfLines - 1) / 2;
        int previousNoOfStars = noOfLines;
        int noOfStars;
        int count = 1;

        List<String> lines = new ArrayList<String>();

        StringBuffer line;

        for ( int i = middleLine + 1; i < noOfLines; i++) {
            line = new StringBuffer();
            noOfStars = 0;
            for (int k = 0; k < count; k++) {
                line.append(SPACE);
            }

            for (int j = 0; j < previousNoOfStars - STARS_REDUCED_PER_LINE; j++) {
                line.append(STAR);
                noOfStars++;
            }
            line.append(NEWLINE);

            previousNoOfStars = noOfStars;
            count++;

            lines.add(line.toString());
        }
        return lines;
    }

    public String print(int noOfLines) {
        return (isOdd(noOfLines) && isPositiveInteger(noOfLines)) ? getOutputString(noOfLines) : null;
    }

    private String getOutputString(int noOfLines) {
        StringBuffer output = new StringBuffer();
        setMiddleLine(noOfLines);

        List<String> lines = getLineStrings(noOfLines);

        output.append(getReversedString(lines));
        output.append(getMiddleLine());
        output.append(concatenateStrings(lines));

        return output.toString();
    }
}
