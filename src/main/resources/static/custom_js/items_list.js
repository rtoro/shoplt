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
            {data: "id",        name: "id",        searchable: false},
            {data: "name",      name: "name",      searchable: true},
            {data: "barCode",   name: "barCode",   searchable: true},
            {data: "priceUnit", name: "priceUnit", searchable: false},
            {data: "unit",      name: "unit",      searchable: false}
        ]
    });
});