const addPlayerForm = document.getElementById("addPlayerForm");
const message = document.getElementById("message");


addPlayerForm.addEventListener("submit", async function (event) {

    // منع الـForm من عمل Refresh للصفحة
    event.preventDefault();


    // تكوين Player Object من البيانات الموجودة في الـForm
    const player = {

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

            method: "POST",

            headers: {
                "Content-Type": "application/json"
            },

            body: JSON.stringify(player)
        });


        if (!response.ok) {

            const error = await response.text();

            throw new Error(error);
        }


        const savedPlayer = await response.json();


        message.textContent =
            "Player added successfully. Player ID: "
            + savedPlayer.id;


        // تفريغ حقول الـForm بعد الحفظ
        addPlayerForm.reset();

    } catch (error) {

        message.textContent =
            "Error adding player: " + error.message;
    }

});