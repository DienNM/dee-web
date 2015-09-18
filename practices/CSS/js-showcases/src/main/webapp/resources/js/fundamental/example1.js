/**
 * 
 */

function miniGameGuess() {

	var words = [
	"javascript",
	"monkey",
	"amazing",
	"pancake"
	];

	var word =words[Math.floor(Math.random() * words.length)];
	alert(word);

	var answerArray = [];
	for (var i =0;i <word.length;i++) {
		answerArray[i] = "_";
	}

	$("#guessResult").text(answerArray.join(" "));

	var remainingLetters =word.length;

	while (remainingLetters >0) {
		var guess = prompt("Guess a letter, or click Cancel to stop playing.");
		if (guess === null) {
			break;
		} else if (guess.length !==1) {
			alert("Please enter a single letter.");
		} else {
			for (var j =0;j <word.length; j++) {
				if (word[j] ===guess) {
					answerArray[j] = guess;
					remainingLetters--;

					$("#guessResult").text(answerArray.join(" "));
				}
			}
		}
	}
	alert("Good job! The answer was " + word);
}
