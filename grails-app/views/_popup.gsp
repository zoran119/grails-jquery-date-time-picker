<r:require module="${function=='datepicker' ? 'jquery-ui' : 'timepicker'}" />
<g:javascript>
    $('#${name}').${function}({
        dateFormat: "${datepickerDateFormat}",
        timeFormat: "${datepickerTimeFormat}"
    });
</g:javascript>
<g:textField name="${name}" value="${formatDate(date:value, format:valueFormat)}" />
