package org.grails.plugins.jquerydatetimepicker;

import org.springframework.beans.PropertyEditorRegistrar;
import org.springframework.beans.PropertyEditorRegistry;

import grails.util.GrailsConfig;
import java.util.Date;
import java.util.List;
import java.util.ArrayList;

public class JqueryDateTimePickerEditorRegistrar implements PropertyEditorRegistrar {
    public void registerCustomEditors(PropertyEditorRegistry reg) {
        String timeFormat = GrailsConfig.get("datePicker.format.java.datetime", String.class);
        if (timeFormat == null) {
            timeFormat = "dd/MM/yyyy HH:mm";
        }

        String dateFormat = GrailsConfig.get("datePicker.format.java.date", String.class);
        if (dateFormat == null) {
            dateFormat = "dd/MM/yyyy";
        }

        List<String> formats = new ArrayList<String>();
        formats.add(timeFormat);
        formats.add(dateFormat);

        reg.registerCustomEditor(Date.class, new JqueryDateTimePickerDateBinder(formats));
    }
}
