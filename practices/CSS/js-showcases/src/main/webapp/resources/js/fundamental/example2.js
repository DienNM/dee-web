

function getRandomNumber(size) {
	return Math.floor(Math.random() * size);
}

var width = 500;
var height = 500;

var target = {
	x : getRandomNumber(width),
	y : getRandomNumber(height)
};

$("#anchor").offset({
	left: target.x,
	top: target.y
});

var click = 0;



function getDistance(event, target) {
	var diffX = event.offsetX - target.x;
	var diffY = event.offsetY - target.y;

	return Math.sqrt((diffX * diffX) + (diffY * diffY));
}


var getDistanceHint = function (distance) {
	if (distance< 10) {
		return "Boiling hot!";
	} else if (distance< 20) {
		return "Really hot";
	} else if (distance< 40) {
		return "Hot";
	} else if (distance< 80) {
		return "Warm";
	} else if (distance< 160) {
		return "Cold";
	} else if (distance< 320) {
		return "Really cold";
	} else {
		return "Freezing!";
	}
};

$("#treasuremap").click(function (event){
	click++;
	$("#click").text(click);
	var distance =getDistance(event,target);
	$("#distance1").text(distance);
	var distanceHint =getDistanceHint(distance);
	$("#distance").text(distanceHint);
	if (distance < 8) {
		alert("Found the treasure in " + click + " clicks!");
	}
});

