import org.grails.plugins.jquerydatetimepicker.JqueryDateTimePickerEditorRegistrar

class JqueryDateTimePickerGrailsPlugin {
    def version = "0.2.0"
    def grailsVersion = "2.0 > *"
    def title = "Jquery Date Time Picker Plugin"
    def author = "Zoran Stojakovic"
    def authorEmail = "stojakovic.zoran+grails@gmail.com"
    def description = 'Makes it easy to use jQuery date and time pickers.'
    def documentation = "https://github.com/zoran119/grails-jquery-date-time-picker"

    def license = 'APACHE'
    def issueManagement = [system: 'GitHub', url: 'https://github.com/zoran119/grails-jquery-date-time-picker/issues']
    def scm = [url: 'https://github.com/zoran119/grails-jquery-date-time-picker']

    def doWithSpring = {
        jqueryDateTimePickerEditorRegistrar(JqueryDateTimePickerEditorRegistrar)
    }
}
