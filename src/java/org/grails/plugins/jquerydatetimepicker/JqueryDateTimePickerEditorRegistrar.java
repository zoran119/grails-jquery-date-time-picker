package org.grails.plugins.jquerydatetimepicker;

import java.util.Arrays;
import java.util.Date;

import org.codehaus.groovy.grails.commons.GrailsApplication;
import org.codehaus.groovy.grails.plugins.support.aware.GrailsApplicationAware;
import org.springframework.beans.PropertyEditorRegistrar;
import org.springframework.beans.PropertyEditorRegistry;

public class JqueryDateTimePickerEditorRegistrar implements PropertyEditorRegistrar, GrailsApplicationAware {

    private GrailsApplication grailsApplication;

    public void registerCustomEditors(PropertyEditorRegistry reg) {
        String timeFormat = get("datePicker.format.java.datetime", "dd/MM/yyyy HH:mm");
        String dateFormat = get("datePicker.format.java.date", "dd/MM/yyyy");
        reg.registerCustomEditor(Date.class, new JqueryDateTimePickerDateBinder(Arrays.asList(timeFormat, dateFormat)));
    }

    private String get(String key, String defaultIfNotSet) {
        Object value = grailsApplication.getFlatConfig().get(key);
        return (value instanceof CharSequence) ? value.toString() : defaultIfNotSet;
    }

    public void setGrailsApplication(GrailsApplication grailsApplication) {
        this.grailsApplication = grailsApplication;
    }
}
