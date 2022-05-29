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
	const greeting = funFacts[Math.floor(Math.random() * funFacts.length)];

	// Add it to the page.
	const greetingContainer = document.getElementById("name");
	greetingContainer.innerText = greeting;
	//Make animation happen again
	greetingContainer.style.animation = "none";
	greetingContainer.offsetHeight;
	greetingContainer.style.animation = null;
}
/**
 * Navigates to another url.
 */

const navigate = (url) => {
	window.location.href = url;
};
