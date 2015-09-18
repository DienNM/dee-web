

var Student = function(email, name) {
	this.email = email;
	this.name = name;

	this.enroll = function() {
		console.log(this.email + " enrolled");
	}
}

Student.prototype.go2School = function() {
	console.log(this.email + " goes to school now");
}