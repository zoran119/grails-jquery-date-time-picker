package org.grails.plugins.jquerydatetimepicker;

import java.beans.PropertyEditorSupport;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class JqueryDateTimePickerDateBinder extends PropertyEditorSupport {

    private final List<String> formats;

    public JqueryDateTimePickerDateBinder(List<?> formats) {
        List<String> formatList = new ArrayList<String>(formats.size());
        for (Object format : formats) {
            formatList.add(format.toString()); // Force String values (eg. for GStrings)
        }
        this.formats = Collections.unmodifiableList(formatList);
    }

    @Override
    public void setAsText(String s) throws IllegalArgumentException {
        if (s == null) {
            return;
        }

        for (String format : formats) {
            // Need to create the SimpleDateFormat every time, since it's not thead-safe
            SimpleDateFormat df = new SimpleDateFormat(format);
            try {
                setValue(df.parse(s));
                return;
            } catch (ParseException e) {
                // Ignore
            }
        }
    }
}
