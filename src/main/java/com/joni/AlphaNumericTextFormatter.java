package com.joni;

import javafx.scene.control.TextFormatter;

import java.util.function.UnaryOperator;

public class AlphaNumericTextFormatter extends TextFormatter<String> {

    /** The Constant ALPHA_NUMERIC_ONLY. */
    private static final String ALPHA_NUMERIC_ONLY = "^[a-zA-Z0-9]*$";

    /**
     * Instantiates a new alpha numeric text formatter.
     */
    public AlphaNumericTextFormatter() {
        super(applyFilter(null));
    }

    /**
     * Instantiates a new alpha numeric text formatter.
     *
     * @param maxLength
     *            the max length
     */
    public AlphaNumericTextFormatter(int maxLength) {
        super(applyFilter(new MaxLengthTextFormatter(maxLength).getFilter()));
    }

    /**
     * Apply filter.
     *
     * @param filter
     *            the filter
     * @return the unary operator
     */
    private static UnaryOperator<Change> applyFilter(UnaryOperator<Change> filter) {
        return change -> {
            change.getControlNewText();
            if (change.getControlNewText().matches(ALPHA_NUMERIC_ONLY)) {
                if (filter != null) {
                    filter.apply(change);
                }
                return change;
            }
            return null;
        };
    }

}