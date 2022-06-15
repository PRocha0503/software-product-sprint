const main = () => {
	addRows();
};

const addRows = () => {
	const response = await fetch("/getContacts");
	const json = await response.text();
	const contacts = JSON.parse(json);
	let table = document.getElementById("contactsTable");
	contacts.map((ob, i) => {
		let row = table.insertRow(i + 1);
		Object.keys(ob).map(function (key, index) {
			let cel = row.insertCell(index);
			cel.innerHTML = ob[key];
		});
	});
};
