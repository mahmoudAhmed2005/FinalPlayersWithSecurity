const loadPlayerButton =
    document.getElementById("loadPlayerButton");

const updatePlayerForm =
    document.getElementById("updatePlayerForm");

const message =
    document.getElementById("message");


/*
    دالة تجيب بيانات اللاعب بالـID.
*/
async function loadPlayer(playerId) {

    if (playerId === "") {

        message.textContent = "Player ID is required";

        return;
    }


    try {

        const response = await fetch(
            "/players/" + playerId
        );


        if (!response.ok) {

            const error = await response.text();

            throw new Error(error);
        }


        const player = await response.json();


        document.getElementById("playerId").value =
            player.id;

        document.getElementById("searchPlayerId").value =
            player.id;

        document.getElementById("playerName").value =
            player.name;

        document.getElementById("playerNumber").value =
            player.number;

        document.getElementById("playerSalary").value =
            player.salary;


        message.textContent =
            "Player loaded successfully";

    } catch (error) {

        message.textContent =
            "Error loading player: " + error.message;
    }
}


/*
    لو المستخدم كتب ID وضغط Load Player.
*/
loadPlayerButton.addEventListener("click", function () {

    const playerId =
        document.getElementById("searchPlayerId").value;


    loadPlayer(playerId);
});


/*
    تعديل اللاعب.
*/
updatePlayerForm.addEventListener("submit", async function (event) {

    event.preventDefault();


    const playerId =
        document.getElementById("playerId").value;


    if (playerId === "") {

        message.textContent =
            "Load the player before updating";

        return;
    }


    const player = {

        id: Number(playerId),

        name: document.getElementById("playerName").value,

        number: Number(
            document.getElementById("playerNumber").value
        ),

        salary: Number(
            document.getElementById("playerSalary").value
        )
    };


    try {

        const response = await fetch("/players", {

            method: "PUT",

            headers: {
                "Content-Type": "application/json"
            },

            body: JSON.stringify(player)
        });


        if (!response.ok) {

            const error = await response.text();

            throw new Error(error);
        }


        const updatedPlayer = await response.json();


        message.textContent =
            "Player updated successfully: "
            + updatedPlayer.name;

    } catch (error) {

        message.textContent =
            "Error updating player: " + error.message;
    }
});


/*
    قراءة الـID الموجود داخل رابط الصفحة.

    مثال:
    /update-player.html?id=13
*/
const urlParameters =
    new URLSearchParams(window.location.search);

const playerIdFromUrl =
    urlParameters.get("id");


/*
    لو يوجد ID داخل الرابط:
    يتم تحميل بيانات اللاعب تلقائيًا.
*/
if (playerIdFromUrl !== null) {

    loadPlayer(playerIdFromUrl);
}