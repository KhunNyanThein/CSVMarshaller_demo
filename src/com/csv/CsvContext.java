package com.csv;

public class CsvContext<T> {

    private static final String EMPTY = "";

    public static final char DEFAULT_SEPARATOR = ',';

    public static final String DEFAULT_LINE_SEPARATOR = System.getProperty("line.separator");

    public static final char DEFAULT_QUOTE = '\'';

    public static final char DEFAULT_COMMENT = '#';

    private boolean withHeader = true;

    private char separator = DEFAULT_SEPARATOR;

    private char quote = DEFAULT_QUOTE;

    private char comment = DEFAULT_COMMENT;

    private String lineSeparator = DEFAULT_LINE_SEPARATOR;

    public CsvContext() {
    }

    public boolean isWithHeader() {
        return withHeader;
    }

    public void setWithHeader(boolean withHeader) {
        this.withHeader = withHeader;
    }

    public char getSeparator() {
        return separator;
    }

    public void setSeparator(char separator) {
        this.separator = separator;
    }

    public char getQuote() {
        return quote;
    }

    public void setQuote(char quote) {
        this.quote = quote;
    }

    public char getComment() {
        return comment;
    }

    public void setComment(char comment) {
        this.comment = comment;
    }

    public String getLineSeparator() {
        return lineSeparator;
    }

    public void setLineSeparator(String lineSeparator) {
        this.lineSeparator = lineSeparator;
    }
}
