$(document).ready(function() {

  var columnDefs = [{
    data: "userId",
    title: "userId",
    type: "readonly",
    "defaultContent": "pending"
  },
  {
    data: "username",
    title: "username",
    type: "text",
    "defaultContent": "",
    required: true,
    unique: true
  }, 
  {
    data: "password",
    title: "password",
    type: "text",
    "defaultContent": "",
    required: true,
  },
  {
    data: "email",
    title: "email",
    type: "text",
    "defaultContent": ""
  },
  {
    data: "regDay",
    title: "regDay",
    required: true,
    "defaultContent": "",
    datetimepicker: { timepicker: false, format : "Y-m-d"}
  },
  {
    data: "gender",
    title: "gender",
    type : "select",
    options : ['male', 'female'],
    "defaultContent": ""
  },
  {
    data: "image",
    title: "Image (base64 string)",
    render: function(data, type, row, meta) {
/*        if (data) return "<img style='max-width:50px;max-height:50px;border-radius:50%;' src='data:image/jpeg;base64, "
        + data +"'></img>"; */
        if (data) return "<a download=\"image.jpg\" href='"+data+"'>"+"<img style='max-width:50px;max-height:50px;border-radius:50%;' src='"
        + data +"'></img>"+"</a>"; 
    },
    disabled: true,
    "defaultContent": ""
  },
  {
    name: "upload_image",
    data: null,
    render: function(data, type, row, meta) {
        return "My file";
    },
    type: "file",
    title: "Avatar (base64 upload)",
    "defaultContent": "",
    visible: false
  }];

  var myTable;

  // local URL's are not allowed
  var url_get = "/Vortex/UserTable";
  var url_fun = "/Vortex/EditUserTable";
  
  myTable = $('#example').DataTable({
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
		rowdata["type_"] = "insert";
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
        rowdata_["type_"] = "delete";
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
        rowdata["type_"] = "update";
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

