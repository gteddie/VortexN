$(document).ready(function() {

  var columnDefs = [{
    data: "gameId",
    title: "gameId",
    type: "readonly",
    "defaultContent": "pending"
  },
  {
    data: "name",
    title: "name",
    type: "text",
    "defaultContent": "",
    required: true,
    unique: true
  }, 
  {
    data: "type",
    title: "type",
    type : "select",
    options : ['動作', '角色扮演','策略','冒險','模擬','運動和競速'],
    "defaultContent": "",

  },
  {
    data: "releaseDate",
    title: "release_date",
    type: "text",
    "defaultContent": "",
    datetimepicker: { timepicker: false, format : "Y-m-d"}
  },
  {
    data: "intro",
    title: "intro",
    required: true,
    "defaultContent": ""
  },
  {
    data: "adult",
    title: "adult",
    type : "select",
    options : ['yes', 'no'],
    "defaultContent": ""
  },
  {
    data: "developerId",
    title: "developer_id",
    type : "select",
    options : ['1', '2','3','4','5'],
    required: true,
    "defaultContent": ""
  }
];

  var myTable;

  // local URL's are not allowed
  var url_get = "/Vortex/GameTable";
  var url_fun = "/Vortex/EditGameTable";
  
  myTable = $('#gametable').DataTable({
    "sPaginationType": "full_numbers",
    ajax: {
        url : url_get,
        // our data is an array of objects, in the root node instead of /data node, so we need 'dataSrc' parameter
        dataSrc : ''
    },
    columns: columnDefs,
    "autoWidth": false,
    dom: 'Bfrtip',        // Needs button container
    select: 'single',
    responsive: true,
    altEditor: true,     // Enable altEditor
    buttons: [{
            text: 'Add',
            name: 'add'        // do not change name
        },
        {
            extend: 'selected', // Bind to Selected row
            text: 'Edit',
            name: 'edit'        // do not change name
        },
        {
            extend: 'selected', // Bind to Selected row
            text: 'Delete',
            name: 'delete'      // do not change name
        },
        {
            text: 'Refresh',
            name: 'refresh'      // do not change name
        }],
    onAddRow: function(datatable, rowdata, success, error) {
		rowdata["type"] = "insert";
        $.ajax({
            // a tipycal url would be / with type='PUT'
            url: url_fun,
            type: 'POST',
            data: rowdata,
            success: success,
            error: error
        });
    },
    onDeleteRow: function(datatable, rowdata, success, error) {
    	for (rowdata_ of rowdata){
        rowdata_["type"] = "delete";
        $.ajax({
            // a tipycal url would be /{id} with type='DELETE'
            url: url_fun,
            type: 'POST',
            data: rowdata_,
            success: success,
            error: error
        });  	
      }
    },
    onEditRow: function(datatable, rowdata, success, error) {
        rowdata["type"] = "update";
        $.ajax({
            // a tipycal url would be /{id} with type='POST'
            url: url_fun,
            type: 'POST',
            data: rowdata,
            success: success,
            error: error
        });
    }
  });
});
$(document).ready(function() {

  var columnDefs = [{
    data: "developerId",
    title: "developer_id",
    type: "readonly",
    "defaultContent": "pending"
  },
  {
    data: "name",
    title: "name",
    type: "text",
    "defaultContent": "",
    required: true,
    unique: true
  }, 
  {
    data: "url",
    title: "url",
    render: function(data, type, row, meta) {
    if (data) return `<a href="${data}" target="_blank">${data}</a>`; 
    },
    "defaultContent": ""
  }
];

  var myTable;

  // local URL's are not allowed
  var url_get = "/Vortex/DeveloperTable";
  var url_fun = "/Vortex/EditDeveloperTable";
  
  myTable = $('#developertable').DataTable({
    "sPaginationType": "full_numbers",
    ajax: {
        url : url_get,
        // our data is an array of objects, in the root node instead of /data node, so we need 'dataSrc' parameter
        dataSrc : ''
    },
    columns: columnDefs,
    "autoWidth": false,
    dom: 'Bfrtip',        // Needs button container
    select: 'single',
    responsive: true,
    altEditor: true,     // Enable altEditor
    buttons: [{
            text: 'Add',
            name: 'add'        // do not change name
        },
        {
            extend: 'selected', // Bind to Selected row
            text: 'Edit',
            name: 'edit'        // do not change name
        },
        {
            extend: 'selected', // Bind to Selected row
            text: 'Delete',
            name: 'delete'      // do not change name
        },
        {
            text: 'Refresh',
            name: 'refresh'      // do not change name
        }],
    onAddRow: function(datatable, rowdata, success, error) {
		rowdata["type"] = "insert";
        $.ajax({
            // a tipycal url would be / with type='PUT'
            url: url_fun,
            type: 'POST',
            data: rowdata,
            success: success,
            error: error
        });
    },
    onDeleteRow: function(datatable, rowdata, success, error) {
    	for (rowdata_ of rowdata){
        rowdata_["type"] = "delete";
        $.ajax({
            // a tipycal url would be /{id} with type='DELETE'
            url: url_fun,
            type: 'POST',
            data: rowdata_,
            success: success,
            error: error
        });  	
      }
    },
    onEditRow: function(datatable, rowdata, success, error) {
        rowdata["type"] = "update";
        $.ajax({
            // a tipycal url would be /{id} with type='POST'
            url: url_fun,
            type: 'POST',
            data: rowdata,
            success: success,
            error: error
        });
    }
  });
});