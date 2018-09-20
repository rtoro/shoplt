$(document).ready(function () {
    var table = $('#usersTable').DataTable({
        "serverSide": true,
        "ajax": {
            "url": "/rest/users/list",
        },
        "columns": [
            { "mData": "id" },
            { "mData": "login" },
            { "mData": "firstName" },
            { "mData": "lastName" },
            { "mData": "email" },
            { "mData": "activated" }
        ]
    })
});