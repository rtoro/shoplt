$(document).ready(function () {
    $('#usersTable').DataTable({
        processing: true,
        serverSide: true,
        ajax: {
            url: "/rest/item/list",
            type: 'POST',
            contentType: 'application/json',
            data: function (d) {
                return JSON.stringify(d);
            }
        },
        columns: [
            { data: "id" },
            { data: "name" },
            { data: "barCode" },
            { data: "priceUnit" },
            { data: "unit" }
        ]
    })
});