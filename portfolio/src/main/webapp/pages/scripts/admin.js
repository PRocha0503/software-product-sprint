const main = () => {
	addRows();
};

const addRows = async () => {
	let response = await fetch("/getContacts");
	let json = await response.text();
	let contacts = JSON.parse(json);
	// const contacts = [
	// 	{
	// 		name: "Test",
	// 		email: "test@example.com",
	// 		reason: "TEST",
	// 		recruiter: false,
	// 		active: true,
	// 		time: "1213213",
	// 		id: 12321,
	// 	},
	// 	{
	// 		name: "Test",
	// 		email: "test@example.com",
	// 		reason: "TEST",
	// 		recruiter: false,
	// 		active: true,
	// 		time: "1213213",
	// 		id: 12321,
	// 	},
	// ];
	let table = document.getElementById("contactsTable");
	contacts.map((ob, i) => {
		let row = table.insertRow(i + 1);
		Object.keys(ob).map(function (key, index) {
			let cel = row.insertCell(index);
			cel.innerHTML = ob[key];
		});
		let cel = row.insertCell(7);
		var btn = document.createElement("input");
		btn.type = "button";
		btn.className = "deleteBtn";
		btn.value = "❌";
		btn.onclick = (function () {
			return async () => {
				try {
					console.log(`/deleteContact?id:${ob["id"]}`);
					await fetch(`/deleteContact?id:${ob["id"]}`, {
						method: "DELETE",
					});
				} catch (e) {
					console.log(e);
				}
			};
		})();
		cel.appendChild(btn);
	});
};
