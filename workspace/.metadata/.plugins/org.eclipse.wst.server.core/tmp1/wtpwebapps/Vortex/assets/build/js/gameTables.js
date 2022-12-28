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
					{ data: "type", "defaultContent": "" },
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
});
