function minDate() {
    console.log("Logging Min Date Setting");
    var date = new Date(document.getElementById("newRentStart").value);
    date.setDate(date.getDate() + 1);
    document
      .getElementById("newRentEnd")
        .setAttribute("min", date.toISOString().split("T")[0]);
    var endDate = new Date(document.getElementById("newRentEnd").value);
    if (date >= endDate)
        document.getElementById("newRentEnd").value = date
          .toISOString()
          .split("T")[0];
    console.log("New Min Date: "+date.toISOString().split("T")[0]);
}