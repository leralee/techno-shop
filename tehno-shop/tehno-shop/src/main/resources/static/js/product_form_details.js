$(document).ready(function () {
    $("a[name='linkRemoveDetail']").each(function (index) {
        $(this).click(function () {
            removeDetailSectionByIndex(index);
        })
    })
});

function addNextDetailSection(){
    allDivDetails = $("[id^='divDetail']");
    divDetailsCount = allDivDetails.length;

    htmlDetailSection = `
        <div class="form-inline" id="divDetail${divDetailsCount}">
            <input type="hidden" name="detailIDs" value="0"/>
            <label class="m-3">Название: </label>
            <input type="text" class="form-control w-25" name="detailNames"/>
            <label class="m-3">Значение: </label>
            <input type="text" class="form-control w-25" name="detailValues"/>
        </div>
    `;

    $("#divProductDetails").append(htmlDetailSection);

    previousDivDetailSection = allDivDetails.last();
    previousDivDetailID = previousDivDetailSection.attr("id");

    htmlLinkRemove = `
        <a class="btn fas fa-times-circle fa-2x icon-grey"
        href="javascript:removeDetailSectionById('${previousDivDetailID}')"
        title="Удалить значение"></a>
    `;


    previousDivDetailSection.append(htmlLinkRemove);

    $("input[name='detailNames']").last().focus();
}

function removeDetailSectionById(id) {
    $("#" + id).remove();
}

function removeDetailSectionByIndex(index) {
    $("#divDetail" + index).remove();
}