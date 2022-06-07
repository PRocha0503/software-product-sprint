/**
 * Adds a random greeting to the page.
 */
function addRandomGreeting() {
	//Possible fun facts
	const funFacts = [
		"Avocados are a fruit, not a vegetable.",
		"The Eiffel Tower can be 15 cm taller during the summer",
		"The heart of a shrimp is located in its head.",
		"Baby rabbits are called kits",
		"The Easter Island heads have bodies.",
		"Ketchup was once sold as medicine.",
	];

	// Pick a random fun fact
	const selectedFunFact = funFacts[Math.floor(Math.random() * funFacts.length)];

	// Add it to the page.
	const funFactContainer = document.getElementById("name");
	funFactContainer.innerText = selectedFunFact;
	//Make animation happen again
	funFactContainer.style.animation = "none";
	funFactContainer.offsetHeight;
	funFactContainer.style.animation = null;
}
/**
 * Navigates to another url.
 */

const navigate = (url) => {
	window.location.href = url;
};
