package com.joni;

import javafx.scene.control.TextFormatter;

public class MaxLengthTextFormatter extends TextFormatter<String> {
    private int maxLength;

    public MaxLengthTextFormatter(int maxLength) {
        super(change -> {

            //If the user is deleting the text (i.e. full selection, ignore max to allow the change to happen)
            if(change.isDeleted()) {

                //If the user is pasting in, then the change could be longer
                //ensure it stops at max length of the field
                if(change.getControlNewText().length() > maxLength){
                    change.setText(change.getText().substring(0, maxLength));
                }
            }

            // Get length of original text + length of new character(s) and check against maxLength
            else if (change.getControlText().length() + change.getText().length() >= maxLength) {
                int maxPos = maxLength - change.getControlText().length();
                change.setText(change.getText().substring(0, maxPos));
            }

            return change;
        });

        this.maxLength = maxLength;
    }

    public int getMaxLength() {
        return maxLength;
    }
}