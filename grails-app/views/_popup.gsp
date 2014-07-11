<%@page defaultCodec="none" %>
<r:require module="${function=='datepicker' ? 'jquery-ui' : 'timepicker'}" />
<g:set var="inputId" value="${id.replace('.', '\\\\.').replace('[','\\\\[').replace(']', '\\\\]')}" />
${inputId}
<g:javascript>
    $('#${inputId}').${function}({
        ${pickerOptions}
    });
</g:javascript>
<input type="text" name="${name}" id="${id}" <g:if test="${value}">value="${formatDate(date:value, format:valueFormat)}"</g:if> ${attrs} />
