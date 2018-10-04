$(document).ready(function () {
    var units = [];
    $.ajax({
        url: "/rest/item/units"
    }).done(function (data) {

        $('#usersTable thead tr').clone(true).appendTo('#usersTable thead');
        $('#usersTable thead tr:eq(1) th').each(function (i) {
            var title = $(this).text();
            switch (title) {
                case "Precio":
                    $(this).html('');
                    break;
                case "Unidad":
                    var select = '<select class="select"><option value="" selected="selected">Todo</option>';
                    data.forEach(function (unit) {
                        select += '<option value="' + unit.id + '">' + unit.name + '</option>';
                    });
                    select += '</select>';
                    $(this).html(select);
                    $('select').change( function () {
                        if (table.column(i).search() !== $(this).val()) {
                            table.column(i).search($(this).val()).draw();
                        }
                    });
                    break;
                default:
                    $(this).html('<input type="text" placeholder="Buscar ' + title + '" />');
                    $('input', this).on('keyup change', function () {
                        if (table.column(i).search() !== this.value) {
                            table.column(i).search(Number(this.value)).draw();
                        }
                    });
                    break;
            }

        });

        var table = $('#usersTable').DataTable({
            processing: true,
            serverSide: true,
            //searching: false,
            ajax: {
                url: "/rest/item/list",
                type: 'POST',
                contentType: 'application/json',
                data: function (d) {
                    return JSON.stringify(d);
                }
            },
            orderCellsTop: true,
            columnDefs: [
                { targets: 2, orderable: false }
            ],
            columns: [
                { data: "id", name: "id" },
                { data: "name", name: "name" },
                { data: "barCode", name: "barCode" },
                { data: "priceUnit", name: "priceUnit" },
                { data: "unit.name", name: "unit_id" }
            ]
        });

        table.columns().every(function () {
            var that = this;
            $('input', this.header()).on('keyup change', function () {
                if (that.search() !== this.value) {
                    that
                        .search(this.value)
                        .draw();
                }
            });
        });
    });

    /*table.columns().flatten().each(function (colIdx) {
        // Create the select list and search operation
        var select = $('<select />')
        .appendTo(
            table.column(colIdx).header()
            )
            .on('change', function () {
                table
                .column(colIdx)
                .search($(this).val())
                .draw();
            });
            
            // Get the search data for the first column and add to the select list
            table
            .column(colIdx)
            .cache('search')
            .sort()
            .unique()
            .each(function (d) {
                select.append($('<option value="' + d + '">' + d + '</option>'));
            });
     });*/
});