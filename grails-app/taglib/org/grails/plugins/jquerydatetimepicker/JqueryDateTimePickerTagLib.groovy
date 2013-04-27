package org.grails.plugins.jquerydatetimepicker

class JqueryDateTimePickerTagLib {

    static namespace = "jqueryPicker"

    def grailsApplication

    private def popup = { function,valueFormat,attrs,body ->
        def datepickerDateFormat = grailsApplication.config.jqueryDateTimePicker.format.picker.date ?: 'dd/mm/yy'
        def datepickerTimeFormat = grailsApplication.config.jqueryDateTimePicker.format.picker.time ?: 'HH:mm'
        out << render(template: '/popup', plugin: 'jqueryDateTimePicker', model: [function: function, value: attrs.value, valueFormat: valueFormat, datepickerDateFormat: datepickerDateFormat, datepickerTimeFormat: datepickerTimeFormat, name: attrs.name])
    }

    def time = { attrs,body ->
        def valueFormat = grailsApplication.config.jqueryDateTimePicker.format.java.datetime ?: 'dd/MM/yyyy HH:mm'
        popup('datetimepicker', valueFormat, attrs, body)
    }

    def date = { attrs,body ->
        def valueFormat = grailsApplication.config.jqueryDateTimePicker.format.java.date ?: 'dd/MM/yyyy'
        popup('datepicker', valueFormat, attrs, body)
    }

}
