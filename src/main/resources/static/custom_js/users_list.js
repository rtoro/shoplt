$(document).ready(function () {
    $('#usersTable').DataTable({
        processing: true,
        serverSide: true,
        ajax: {
            url: "/rest/users/list",
            dataFilter: function(data){
                var json = jQuery.parseJSON( data );
                json.recordsTotal = json.totalElements;
                json.recordsFiltered = json.totalElements;
                json.data = json.content;
      
                return JSON.stringify( json ); // return JSON string
            }
        },
        columns: [
            { data: "id" },
            { data: "login" },
            { data: "firstName" },
            { data: "lastName" },
            { data: "email" },
            { data: "activated" }
        ]
    })
});