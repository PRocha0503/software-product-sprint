/**
 * Gets a random fact from the server
 */
const getRandomFact = async () => {
	const serverFunFact = await fetch("/funFact");
	const textFunFact = await serverFunFact.text()
    // Add it to the page.
	const funFactContainer = document.getElementById("name");
	funFactContainer.innerText = textFunFact;
	//Make animation happen again
	funFactContainer.style.animation = "none";
	funFactContainer.offsetHeight;
	funFactContainer.style.animation = null;

};

/**
 * Navigates to another url.
 */

const navigate = (url) => {
	window.location.href = url;
};
