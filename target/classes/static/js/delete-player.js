const deletePlayerForm =
    document.getElementById("deletePlayerForm");

const message =
    document.getElementById("message");


deletePlayerForm.addEventListener("submit", async function (event) {

    event.preventDefault();


    const playerId =
        document.getElementById("playerId").value;


    try {

        const response = await fetch("/players/" + playerId, {

            method: "DELETE"
        });


        if (!response.ok) {

            const error = await response.text();

            throw new Error(error);
        }


        message.textContent =
            "Player deleted successfully. Player ID: "
            + playerId;


        deletePlayerForm.reset();

    } catch (error) {

        message.textContent =
            "Error deleting player: " + error.message;
    }

});