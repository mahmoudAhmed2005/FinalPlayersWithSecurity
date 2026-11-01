const playersTableBody =
    document.getElementById("playersTableBody");

const refreshButton =
    document.getElementById("refreshButton");

const message =
    document.getElementById("message");


async function loadPlayers() {

    try {

        const response = await fetch("/players");


        if (!response.ok) {

            const error = await response.text();

            throw new Error(error);
        }


        const players = await response.json();


        playersTableBody.innerHTML = "";


        if (players.length === 0) {

            const row = document.createElement("tr");

            const cell = document.createElement("td");

            cell.colSpan = 5;

            cell.textContent = "No players found";

            row.appendChild(cell);

            playersTableBody.appendChild(row);

            return;
        }


        players.forEach(function (player) {

            const row = document.createElement("tr");


            const idCell = document.createElement("td");

            idCell.textContent = player.id;


            const nameCell = document.createElement("td");

            nameCell.textContent = player.name;


            const numberCell = document.createElement("td");

            numberCell.textContent = player.number;


            const salaryCell = document.createElement("td");

            salaryCell.textContent = player.salary;


            const actionsCell = document.createElement("td");


            // زر التعديل
            const updateButton = document.createElement("button");

            updateButton.type = "button";

            updateButton.textContent = "Update";

            updateButton.addEventListener("click", function () {

                window.location.href =
                    "/update-player.html?id=" + player.id;
            });


            // زر الحذف
            const deleteButton = document.createElement("button");

            deleteButton.type = "button";

            deleteButton.textContent = "Delete";

            deleteButton.addEventListener("click", function () {

                deletePlayer(player.id, player.name);
            });


            actionsCell.appendChild(updateButton);

            actionsCell.appendChild(
                document.createTextNode(" ")
            );

            actionsCell.appendChild(deleteButton);


            row.appendChild(idCell);

            row.appendChild(nameCell);

            row.appendChild(numberCell);

            row.appendChild(salaryCell);

            row.appendChild(actionsCell);


            playersTableBody.appendChild(row);
        });


        message.textContent = "";

    } catch (error) {

        message.textContent =
            "Error loading players: " + error.message;
    }
}


async function deletePlayer(playerId, playerName) {

    const confirmed = confirm(
        "Are you sure you want to delete player "
        + playerName + "?"
    );


    if (!confirmed) {

        return;
    }


    try {

        const response = await fetch(
            "/players/" + playerId,
            {
                method: "DELETE"
            }
        );


        if (!response.ok) {

            const error = await response.text();

            throw new Error(error);
        }


        message.textContent =
            "Player deleted successfully: " + playerName;


        await loadPlayers();

    } catch (error) {

        message.textContent =
            "Error deleting player: " + error.message;
    }
}


refreshButton.addEventListener("click", loadPlayers);


loadPlayers();