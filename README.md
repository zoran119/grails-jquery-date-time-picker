Grails Plugin: jQuery Date and Time Pickers
===========================================

This plugin aims to make it easy to use jQuery [date picker](http://jqueryui.com/datepicker/) and [time
picker](https://github.com/trentrichardson/jQuery-Timepicker-Addon). It will set up the picker popups and configure date
parameter binding.

Installation
------------

Install [jQuery UI resources plugin](http://grails.org/plugin/jquery-ui) and then add the following to the `plugins`
part of `BuildConfig.groovy`:

    compile ':jquery-date-time-picker:0.1.0'

Usage
-----

Simply use the provided tags on the properties of `Date` type:

    <jqueryPicker:date name="dateOfBirth" value="${personInstance.dateOfBirth}" />
    <jqueryPicker:time name="startTime" value="${meetingInstance.startTime}" />

You can pass configuration options to to date and time picker using `pickerOptions` map:

    <jqueryPicker:date name="dateOfBirth" value="${personInstance.dateOfBirth}" pickerOptions="[maxDate: '\'+1M +10D\'']" />

Note that if an option is a string, pass it as string (note the `'\'`). Take care as none of the options are encoded!

You can also specify the timezone to be used when displaying a date:

    <jqueryPicker:time name="startTime" value="${meetingInstance.startTime}" timeZone="${TimeZone.getTimeZone('GMT')}" />


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

* [Java](http://docs.oracle.com/javase/6/docs/api/java/text/SimpleDateFormat.html)
* [picker Date](http://api.jqueryui.com/datepicker/#utility-formatDate)
* [picker Time](http://trentrichardson.com/examples/timepicker/)

Note that the `picker` property has `date` and `time` where as `java` has `datetime` and `time`. Also, the `picker`
property values need to be 'strings inside strings' (see Usage). 

Version History
---------------

#### 0.2.0
* Timezone support ([issue #7](https://github.com/zoran119/grails-jquery-date-time-picker/issues/7))

#### 0.1.3
* Version 0.1.2 accidentally left debug code in which prints input name to the gsp page. This version removes the output.

#### 0.1.2
* Escape dots and square brackets in input names ([issue #6](https://github.com/zoran119/grails-jquery-date-time-picker/issues/6))

#### 0.1.1
* Set the page codec to `none` to prevent encoding of single quotes as UTF-8 in `Grails 2.3.x` ([pull request #4](https://github.com/zoran119/grails-jquery-date-time-picker/pull/4))


Contributing
------------

* All code contributions and bug reports are much appreciated
* Please raise issues on [github](https://github.com/zoran119/grails-jquery-date-time-picker)
* Spaces in preference to tabs
* Keep commit messages clean (short, capitalised summary, 72 columns or so wrapped details)
