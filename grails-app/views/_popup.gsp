<%@page defaultCodec="none" %>
<r:require module="${function=='datepicker' ? 'jquery-ui' : 'timepicker'}" />
<g:javascript>
    $('#${id}').${function}({
        ${pickerOptions}
    });
</g:javascript>
<input type="text" name="${name}" id="${id}" <g:if test="${value}">value="${formatDate(date:value, format:valueFormat)}"</g:if> ${attrs} />
