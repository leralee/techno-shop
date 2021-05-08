function clearFilter(){
    window.location = moduleURL;
}

function showDeleteConfirmModal(link, entityName) {
    entityId = link.attr("entityId");

    $("#yesButton").attr("href", link.attr("href"));
    $("#confirmText").text("Вы уверены что хотите удалить "
        + entityName + " с ID " + entityId + "?");
    $("#confirmModal").modal();

}