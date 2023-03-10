$(document).ready(function() {
  let developerIds = [];
  $.ajax({
	  url: "/Vortex/DeveloperTable",
	  type: "GET",
	  dataType: "json",
	  success: function(response) {
		  for(bean of response) {
			  if(!developerIds.includes(bean.developerId)) {
				  developerIds.push(bean.developerId)
			  }
		  }
	  },
	  error: function(error) {
		  console.log(error);
	  }
  })
  var columnDefs = [{
    data: "gameId",
    title: "game_id",
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
    width: "100px"

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
    options : developerIds,
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
$(document).ready(function() {
	function isValidHttpUrl(string) {
	  let url;
	  try {
	    url = new URL(string);
	  } catch (_) {
	    return false;
	  }
	  return url.protocol === "http:" || url.protocol === "https:";
	}
    let gameIds = [];
    $.ajax({
	    url: "/Vortex/GameTable",
	    type: "GET",
	    dataType: "json",
	    success: function(response) {
		    for(bean of response) {
			    if(!gameIds.includes(bean.gameId)) {
				    gameIds.push(bean.gameId)
			    }
		    }
	    },
	    error: function(error) {
		    console.log(error);
	    }
    })
  var columnDefs = [{
    data: "mediaId",
    title: "media_id",
    type: "readonly",
    "defaultContent": "pending"
  },
  {
    data: "resource",
    title: "resource",
    render: function(data, type, row, meta) {
        if (data) {
	        if (data.startsWith("data:")) { 
		        return `<a download="image.${data.substring(data.indexOf("/") + 1, data.indexOf(";"))}"`
		               +" href='"+data+"'>"
		        	   +"<img style='max-width:150px;max-height:150px;' src='"
      		           + data +"'></img>"+"</a>";
			   }else if(isValidHttpUrl(data)){
				  return `<a href="${data}" target="_blank">${data}</a>`;
			   }else {
				  return data; 
			   };
	        };
    },
    "defaultContent": ""
  }, 
  {
    data: "resourceType",
    title: "resource_type",
    type : "select",
    options : ['title image', 'title gif','video url','article image'],
    "defaultContent": ""
  },
  {
    data: "gameId",
    title: "game_id",
    type : "select",
    options : gameIds,
    "defaultContent": ""
  },
  {
    name: "upload_resource",
    data: null,
    render: function(data, type, row, meta) {
        return "My file";
    },
    type: "file",
    title: "Avatar (base64 upload)",
    "defaultContent": "",
    visible: false
  },
];

  var myTable;

  // local URL's are not allowed
  var url_get = "/Vortex/GameMediaTable";
  var url_fun = "/Vortex/EditGameMediaTable";
  
  myTable = $('#gamemediatable').DataTable({
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