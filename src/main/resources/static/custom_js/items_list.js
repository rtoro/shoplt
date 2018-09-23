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
        searchCols: [
            null,
            {search: "My filter"},
            {search: "My 2nd filter"},
            null,
            null
        ],
        columns: [
            {data: "id", searchable: false},
            {data: "name", searchable: true},
            {data: "barCode", searchable: true},
            {data: "priceUnit", searchable: false},
            {data: "unit", searchable: false}
        ]
    });
});