Grails Plugin: jQuery Date and Time Pickers
===========================================

This plugin aims to make it easy to use jQuery [date picker](http://jqueryui.com/datepicker/) and [time
picker](https://github.com/trentrichardson/jQuery-Timepicker-Addon). It will set up the picker popups and configure date
parameter binding.

Usage
-----

Install [jQuery UI resources plugin](http://grails.org/plugin/jquery-ui), followed by this plugin. Then simply use the
provided tags on the properties of `Date` type:

    <jqueryPicker:date name="dateOfBirth" value="personInstance.dateOfBirth" />
    <jqueryPicker:time name="startTime" value="meetingInstance.startTime" />

You can pass configuration options to to date and time picker using `pickerOptions` map:

    <jqueryPicker:date name="dateOfBirth" value="personInstance.dateOfBirth" pickerOptions="[maxDate: '\'+1M +10D\'']" />

Note that if an option is a string, pass it as string (note the `'\'`). Take care as none of the options are encoded!


Configuration
-------------

Default date and time formatting is set to suit Australia. It can be easily changed in `Config.groovy`:

    jqueryDateTimePicker {
        format {
            java {
                datetime = "dd-MM-yyyy HH:mm"
                date = "dd-MM-yyyy"
            }
            picker {
                date = "'dd-mm-yy'"
                time = "'H-mm'"
            }
        }
    }

The `java` property is used to configure the data binding and `picker` property is used to configure the jQuery date
picker popup. Needless to say, you want these to be the same (in terms of the date they produce) but due to different
configuration mechanisms each needs to be specified separately (for example, month in `java` is `MM` but in `picker` it
is `mm`). Here are some resources to help with formatting:

* [Java](http://docs.oracle.com/javase/6/docs/api/java/text/SimpleDateFormat.html
* [picker Date](http://api.jqueryui.com/datepicker/#utility-formatDate)
* [picker Time](http://trentrichardson.com/examples/timepicker/)

Note that the `picker` property has `date` and `time` where as `java` has `datetime` and `time`. Also, the `picker`
property values need to be 'strings inside strings' (see Usage). 


Contributing
------------

* All code contributions and bug reports are much appreciated
* Please raise issues on [github](https://github.com/zoran119/grails-jquery-date-time-picker)
* Spaces in preference to tabs
* Keep commit messages clean (short, capitalised summary, 72 columns or so wrapped details)
