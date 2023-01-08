function animateValue(id, start, end, step, duration) {
	if (start === end) return;
	let range = end - start,
		current = start,
		increment = end > start ? step : -step,
		stepTime = Math.abs(Math.floor(duration / range)),
		obj = document.querySelector("#" + id);
	var timer = setInterval(function() {

		current += increment;
		if (current >= end) {
			obj.innerHTML = end;
			clearInterval(timer);
			return;
		}
		obj.innerHTML = current;
		if (current == end) {
			clearInterval(timer);
		}
	}, stepTime);
}
function dynamicCharts() {	
	$.ajax({
		url: "/Vortex/UserTable",
		method: "POST",
		datatype: "json",
		success: function(response) {
			let initUsers = Number($("#userCounts").text()),
			    initMales = Number($("#maleCounts").text()),
				initFemales = Number($("#femaleCounts").text()),
				totalUsers = 0,
				totalMales = 0,
				totalFemales = 0;
			for (bean of response) {
				totalUsers += 1;
				if (bean.gender.trim() === "male") totalMales += 1;
				if (bean.gender.trim() === "female") totalFemales += 1;
			}
			animateValue("userCounts", initUsers, totalUsers, 1, 1000);
			animateValue("maleCounts", initMales, totalMales, 1, 1000);
			animateValue("femaleCounts", initFemales, totalFemales, 1, 1000);
		},
		error: (err) => {
			console.log(err);
		}
	})
	$.ajax({
		url: "/Vortex/GameTable",
		method: "POST",
		datatype: "json",
		success: function(response) {
			let totalGames = 0,
				initGames = Number($("#gameCounts").text());
			for (bean of response) {
				totalGames += 1;
			}
			animateValue("gameCounts", initGames, totalGames, 1, 1000);
	
		},
		error: (err) => {
			console.log(err);
		}
	})
	$.ajax({
		url: "/Vortex/DeveloperTable",
		method: "POST",
		datatype: "json",
		success: function(response) {
			let	totalDevelopers = 0,
				initDevelopers = Number($("#developerCounts").text());
			for (bean of response) {
				totalDevelopers += 1;
			}
			animateValue("developerCounts",initDevelopers, totalDevelopers, 1, 1000);
	
		},
		error: (err) => {
			console.log(err);
		}
	})
	$.ajax({
		url: "/Vortex/GameMediaTable",
		method: "POST",
		datatype: "json",
		success: function(response) {
			let	totalMedia = 0,
			    initMedia = Number($("#gameMediaCounts").text());
			console.log(initMedia);
			for (bean of response) {
				totalMedia += 1;
			}
			animateValue("gameMediaCounts", initMedia, totalMedia, 1, 1000);
	
		},
		error: (err) => {
			console.log(err);
		}
	})
}
$(document).ready(()=>{
	dynamicCharts();
	setInterval(dynamicCharts, 10000);
})

