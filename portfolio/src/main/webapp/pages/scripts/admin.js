const main = () => {
	addRows();
};

const addRows = async () => {
	const response = await fetch("/getContacts");
	const json = await response.text();
	const contacts = JSON.parse(json);
	// const contacts = [
	// 	{
	// 		name: "Test",
	// 		email: "test@example.com",
	// 		reason: "TEST",
	// 		recruiter: false,
	// 		active: true,
	// 		time: "1213213",
	// 	},
	// 	{
	// 		name: "Test",
	// 		email: "test@example.com",
	// 		reason: "TEST",
	// 		recruiter: false,
	// 		active: true,
	// 		time: "1213213",
	// 	},
	// ];
	let table = document.getElementById("contactsTable");
	contacts.map((ob, i) => {
		let row = table.insertRow(i + 1);
		Object.keys(ob).map(function (key, index) {
			let cel = row.insertCell(index);
			cel.innerHTML = ob[key];
		});
		let cel = row.insertCell(6);
		var btn = document.createElement("input");
		btn.type = "button";
		btn.className = "btn";
		btn.value = "ss";
		btn.onclick = (function () {
			return function async() {
				try{
					await fetch(`/deleteContact?email:${ob["email"]}`, {
						method: "DELETE",
					});
				}catch(e){
					console.log(e)
				}
			};
		})();
		cel.appendChild(btn);
	});
};
