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

$.ajax({
	url: "/Vortex/UserTable",
	method: "POST",
	datatype: "json",
	success: function(response) {
		let totalUsers = 0,
			totalMales = 0,
			totalFemales = 0;
		for (bean of response) {
			totalUsers += 1;
			if (bean.gender.trim() === "male") totalMales += 1;
			if (bean.gender.trim() === "female") totalFemales += 1;
		}
		animateValue("userCounts", 0, totalUsers, 1, 1000);
		animateValue("maleCounts", 0, totalMales, 1, 1000);
		animateValue("femaleCounts", 0, totalFemales, 1, 1000);
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
		let totalGames = 0;
		for (bean of response) {
			totalGames += 1;
		}
		animateValue("gameCounts", 0, totalGames, 1, 1000);

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
		let	totalDevelopers = 0;
		for (bean of response) {
			totalDevelopers += 1;
		}
		animateValue("developerCounts", 0, totalDevelopers, 1, 1000);

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
		let	totalMedia = 0;
		for (bean of response) {
			totalMedia += 1;
		}
		animateValue("gameMediaCounts", 0, totalMedia, 1, 1000);

	},
	error: (err) => {
		console.log(err);
	}
})