function adminCheck() {
    const user = JSON.parse(localStorage.getItem("currentUser"));
    if(!user){
        window.location.href = "../login.html";
        return;
    }

    if(user["@type"]!="AdminUser"){
        window.location.href = "../login.html";
        return;
    }
}
adminCheck();