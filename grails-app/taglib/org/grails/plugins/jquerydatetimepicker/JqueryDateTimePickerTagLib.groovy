package org.grails.plugins.jquerydatetimepicker

class JqueryDateTimePickerTagLib {

    static namespace = "jqueryPicker"

    def grailsApplication

    def time = { attrs,body ->
        def valueFormat = grailsApplication.config.jqueryDateTimePicker.format.java.datetime ?: "dd/MM/yyyy HH:mm"
        popup('datetimepicker', valueFormat, attrs, body)
    }

    def date = { attrs,body ->
        def valueFormat = grailsApplication.config.jqueryDateTimePicker.format.java.date ?: "dd/MM/yyyy"
        popup('datepicker', valueFormat, attrs, body)
    }

    private popup = { function,valueFormat,attrs,body ->
        def value = attrs.remove('value')
        def name = attrs.remove('name')
        def id = attrs.remove('id') ?: name
        def pickerOptions = attrs.remove('pickerOptions') ?: [:]
        pickerOptions.dateFormat = grailsApplication.config.jqueryDateTimePicker.format.picker.date ?: "'dd/mm/yy'"
        pickerOptions.timeFormat = grailsApplication.config.jqueryDateTimePicker.format.picker.time ?: "'HH:mm'"
        out << render(template: '/popup', plugin: 'jqueryDateTimePicker', model: [function: function, value: value, valueFormat: valueFormat, name: name, id: id, pickerOptions: formatPickerOptions(pickerOptions), attrs: formatAttributes(attrs)])
    }

    private formatAttributes(attributeMap) {
        def attrStr = ''
        attributeMap.each { k,v ->
            attrStr += "${k}=\"${v.encodeAsHTML()}\""
        }
        attrStr
    }

    private formatPickerOptions(optionsMap) {
        def optionsStr = optionsMap.toString()
        optionsStr.substring(1, optionsStr.length()-1)
    }

}
