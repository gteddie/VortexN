$(document).ready(function() {
	$.ajax({
		type: 'POST',
		url: "/Vortex/GameTable",
		success: function(response) {
			$("#tableview").DataTable({
				data: response,
				columns: [
					{ data: "gameId" },
					{ data: "name" },
					{ data: "type", "defaultContent": "" ,width: "100px"},
					{ data: "releaseDate", "defaultContent": "" },
					{ data: "intro", "defaultContent": "" },
					{ data: "adult", "defaultContent": "" },
					{ data: "developerId", "defaultContent": "" }
				],
				"autoWidth": false,
				dom: "Bfrtip",
				buttons: [
					{
						extend: "copy",
						className: "btn-sm"
					},
					{
						extend: "csv",
						className: "btn-sm"
					},
					{
						extend: "excel",
						className: "btn-sm"
					},
					{
						extend: "pdfHtml5",
						className: "btn-sm"
					},
					{
						extend: "print",
						className: "btn-sm"
					},
				],
				responsive: true
			});
			console.log(response);
		},
		error: function(response) {
			alert("Error" + response.message);
			console.log('Error');
		}
	});
	$.ajax({
		type: 'POST',
		url: "/Vortex/DeveloperTable",
		success: function(response) {
			$("#tableview2").DataTable({
				data: response,
				columns: [
					{ data: "developerId" },
					{ data: "name" },
					{
						data: "url",
						title: "url",
						render: function(data, type, row, meta) {
							if (data) return `<a href="${data}" target="_blank">${data}</a>`;
						},
						"defaultContent": ""
					}

				],
				"autoWidth": false,
				dom: "Bfrtip",
				buttons: [
					{
						extend: "copy",
						className: "btn-sm"
					},
					{
						extend: "csv",
						className: "btn-sm"
					},
					{
						extend: "excel",
						className: "btn-sm"
					},
					{
						extend: "pdfHtml5",
						className: "btn-sm"
					},
					{
						extend: "print",
						className: "btn-sm"
					},
				],
				responsive: true
			});
			console.log(response);
		},
		error: function(response) {
			alert("Error" + response.message);
			console.log('Error');
		}
	});
	$.ajax({
		type: 'POST',
		url: "/Vortex/GameMediaTable",
		success: function(response) {
			$("#tableview3").DataTable({
				data: response,
				columns: [
					{ data: "mediaId", title: "media_id"},
					
					{ data: "resource",
					  title: "resource",
					  render: function(data, type, row, meta) {
					      if (data) {
							  console.log("if(data)");
						      if (data.startsWith("data:")) {
								  console.log("startsWith(data)");
								  console.log(`<a download="image.${data.substring(data.indexOf("/") + 1, data.indexOf(";"))}"`+" href='"+data+"'>"+"<img style='max-width:150px;max-height:150px;' src='"
				          		  + data +"'></img>"+"</a>") 
							      return `<a download="image.${data.substring(data.indexOf("/") + 1, data.indexOf(";"))}"`+" href='"+data+"'>"+"<img style='max-width:150px;max-height:150px;' src='"
				          		  + data +"'></img>"+"</a>";
								 }else {
									return data;
								 };
						      };
					  },
						"defaultContent": ""
					},	
					{ data: "resourceType", title:"resource_type" },				
					{ data: "gameId", title: "game_id"},

				],
				"autoWidth": false,
				dom: "Bfrtip",
				buttons: [
					{
						extend: "copy",
						className: "btn-sm"
					},
					{
						extend: "csv",
						className: "btn-sm"
					},
					{
						extend: "excel",
						className: "btn-sm"
					},
					{
						extend: "pdfHtml5",
						className: "btn-sm"
					},
					{
						extend: "print",
						className: "btn-sm"
					},
				],
				responsive: true
			});
			console.log(response);
		},
		error: function(response) {
			alert("Error" + response.message);
			console.log('Error');
		}
	});
});

