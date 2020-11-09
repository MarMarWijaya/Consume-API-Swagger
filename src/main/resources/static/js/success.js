function myFunction() {
    var t = 3000;

    console.log("timer started t = " + t);


    setInterval(function () {
        if (t >= 0) {
            document.getElementById("timer").innerHTML = t;
            console.log(t);
            t--;
        } else {
            console.log("Time up");
            document.getElementById("timer").innerHTML = "Time Up!";
        }
    }, 1000);


    console.log("timer stopped t = " + t);
}

function deleteNotif() {
    Swal.fire({
        title: 'Do you want to save the changes?',
        showDenyButton: true,
        showCancelButton: true,
        confirmButtonText: `Save`,
        denyButtonText: `Don't save`,
    }).then((result) => {
        /* Read more about isConfirmed, isDenied below */
        if (result.isConfirmed) {
            Swal.fire('Saved!', '', 'success')
        } else if (result.isDenied) {
            Swal.fire('Changes are not saved', '', 'info')
        }
    })
}
