// Link to the main host of the web service
const SERVICE_URL = "http://localhost:8080/GuessNumber";

function getAllGames(event) {
  fetch(SERVICE_URL + "/game")
    .then((response) => response.json())
    .then((data) => {
      console.log(data);
      $("#allGamesTable .tbody tr").remove();
      if (data.length > 0) {
        for (let index = 0; index < data.length; index++) {
          var newRow = $("<tr>");
          var cols = "";
          cols += "<td> " + data[index].gameID + "</td>";
          cols += "<td> " + data[index].status + "</td>";
          cols += "<td> " + data[index].answer + "</td>";
          newRow.append(cols);
          $("#allGamesTable .tbody").append(newRow);
        }
      } else {
        var newRow = $("<tr>");
        var cols = "";
        cols += "<td>null</td>";
        cols += "<td>null</td>";
        cols += "<td>null</td>";
        newRow.append(cols);
        $("#allGamesTable .tbody").append(newRow);
      }
    })
    .catch((error) => {
      console.log("Get All Games - Error:");
      console.log(error);
    });
}

function getOneGame(event) {
  if (document.getElementById("singleGameID").value)
    fetch(
      SERVICE_URL + "/game/" + document.getElementById("singleGameID").value
    )
      .then((response) => response.json())
      .then((data) => {
        console.log(data);
        $("#singleTable .tbody tr").remove();
        var newRow = $("<tr>");
        var cols = "";
        cols += "<td> " + data.gameID + "</td>";
        cols += "<td> " + data.status + "</td>";
        cols += "<td> " + data.answer + "</td>";
        newRow.append(cols);
        $("#singleTable .tbody").append(newRow);
      })
      .catch((error) => {
        console.log("Get One Game - Error:");
        console.log(error);
      });
  else alert("Please enter a Game ID.");
}

function getRoundsForGame(event) {
  if (document.getElementById("roundsGameID").value)
    fetch(
      SERVICE_URL + "/rounds/" + document.getElementById("roundsGameID").value
    )
      .then((response) => response.json())
      .then((data) => {
        console.log(data);
        $("#roundsTable .tbody tr").remove();
        if (data.length > 0) {
          for (let index = 0; index < data.length; index++) {
            var newRow = $("<tr>");
            var cols = "";
            cols += "<td> " + data[index].roundID + "</td>";
            cols += "<td> " + data[index].gameID + "</td>";
            cols += "<td> " + data[index].guess + "</td>";
            cols += "<td> " + data[index].result + "</td>";
            cols += "<td> " + data[index].timestamp + "</td>";
            newRow.append(cols);
            $("#roundsTable .tbody").append(newRow);
          }
        } else {
          var newRow = $("<tr>");
          var cols = "";
          cols += "<td>null</td>";
          cols += "<td>null</td>";
          cols += "<td>null</td>";
          cols += "<td>null</td>";
          cols += "<td>null</td>";
          newRow.append(cols);
          $("#roundsTable .tbody").append(newRow);
        }
      })
      .catch((error) => {
        console.log("Get All Rounds For Game - Error:");
        console.log(error);
      });
  else alert("Please enter a Game ID.");
}

function createGame() {
  fetch(SERVICE_URL + "/begin", {
    method: "POST",
  })
    .then((response) => response.json())
    .then((data) => {
      console.log(data);
      document.getElementById("newGameID").innerHTML = data;
    })
    .catch((error) => {
      console.log("Get One Game - Error:");
      console.log(error);
    });
}

function makeGuess() {
  if (
    document.getElementById("guessGameID").value &&
    document.getElementById("guessNum").value
  ) {
    var guessForm = new FormData();
    guessForm.append("gameID", document.getElementById("guessGameID").value);
    guessForm.append("guess", document.getElementById("guessNum").value);
    fetch(SERVICE_URL + "/guess", {
      method: "POST",
      body: guessForm,
    })
      .then((response) => response.json())
      .then((data) => {
        console.log(data);
        getPastGuesses();
      })
      .catch((error) => {
        console.log("Get One Game - Error:");
        console.log(error);
      });
  } else
    alert(
      "Please make sure both Game ID and Guess are appropriately filled out."
    );
}

function getPastGuesses() {
  if (document.getElementById("guessGameID").value)
    fetch(
      SERVICE_URL + "/rounds/" + document.getElementById("guessGameID").value
    )
      .then((response) => response.json())
      .then((data) => {
        console.log(data);
        $("#guessTable .tbody tr").remove();
        if (data.length > 0) {
          for (let index = 0; index < data.length; index++) {
            var newRow = $("<tr>");
            var cols = "";
            cols += "<td> " + data[index].roundID + "</td>";
            cols += "<td> " + data[index].gameID + "</td>";
            cols += "<td> " + data[index].guess + "</td>";
            cols += "<td> " + data[index].result + "</td>";
            cols += "<td> " + data[index].timestamp + "</td>";
            newRow.append(cols);
            $("#guessTable .tbody").append(newRow);
          }
        } else {
          var newRow = $("<tr>");
          var cols = "";
          cols += "<td>null</td>";
          cols += "<td>null</td>";
          cols += "<td>null</td>";
          cols += "<td>null</td>";
          cols += "<td>null</td>";
          newRow.append(cols);
          $("#guessTable .tbody").append(newRow);
        }
      })
      .catch((error) => {
        console.log("Get All Rounds For Game - Error:");
        console.log(error);
      });
}
