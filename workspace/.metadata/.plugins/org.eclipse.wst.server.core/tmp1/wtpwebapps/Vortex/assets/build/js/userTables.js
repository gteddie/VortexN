$(document).ready(function() {
	$.ajax({
		type: 'POST',
		url: "/Vortex/UserTable",
		success: function(response) {
			$("#tableview").DataTable({
				data: response,
				columns: [{ data: "userId" },
				{ data: "username" },
				{ data: "password" },
				{ data: "email" },
				{
				data: "image",
				render: function(data, type, row, meta) {
					if (data) return "<a download=\"image.jpg\" href='" + data + "'>" + "<img style='max-width:50px;max-height:50px;border-radius:50%;' src='"
						+ data + "'></img>" + "</a>";
				},
				"defaultContent": "",
				disabled: true
				},
				{ data: "regDay" },
				{ data: "gender" }],
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
			/*console.log(response);*/
		},
		error: function(response) {
			alert("Error" + response.message);
			console.log('Error');
		}
	});
});

