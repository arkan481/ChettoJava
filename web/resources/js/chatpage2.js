var chatBox=document.getElementById("chatid");
var input=document.getElementById("inputid");
var songs=["https://open.spotify.com/embed/track/1BKer1j3IYeAN07Su5f55P","https://open.spotify.com/embed/track/2wAiFWjRupWmnDkQcu91MF","https://open.spotify.com/embed/track/5drW6PGRxkE6MxttzVLNk5","https://open.spotify.com/embed/track/2dIBMHByUGcNPzmYBJ6OAj","https://open.spotify.com/embed/track/4qOpQXiEDEvt8MhYCGcwB6","https://open.spotify.com/embed/track/4YSOlJJoFu4vfZYJUiewl9","https://open.spotify.com/embed/track/3CBxVM0zGj41BQtE6m7gwb","https://open.spotify.com/embed/track/08OPqLv99g8avzmxQepmiw","https://open.spotify.com/embed/track/3kj14iUwv0rvTweOr9P2ut","https://open.spotify.com/embed/track/1BKer1j3IYeAN07Su5f55P","https://open.spotify.com/embed/track/0QnONzv3TvHAWk294h6DaQ","https://open.spotify.com/embed/track/1OE5l6sedVcIFELMuxQOPI","https://open.spotify.com/embed/track/2yBVeksU2EtrPJbTu4ZslK","https://open.spotify.com/embed/track/4VGvosVIeFMCUwHibq7a9Z"];
var userNotes = [];

function append(){
    chatBox.appendChild(createuserchat());
    var userInput = input.value;
    var command = userInput.split(".");
    if (command[0] == "--img") {
        chatBox.appendChild(replyimage(command[1]));
    }else if (command[0]=="--wiki") {
        chatBox.appendChild(replywiki(command[1]));
    }else if (command[0]=="--spot") {
        chatBox.appendChild(replyspot());
    }else if(command[0]=="--clear") {
        chatBox.textContent = "";
    }else if(command[0]=="--savenote") {
        var notes = command[1].split(",");
        chatBox.appendChild(saveNote(notes));
    }else if(command[0]=="--seenote") {
        chatBox.appendChild(seeNote());
    }
    updateState();
}

function updateState() {
    chatBox.scrollTop = chatBox.scrollHeight;
//    input.value="";
}

function saveNote(notes) {
    // Pushing the array into a global variable
    notes.forEach(element => { 
        userNotes.push(element)
    });
    
    var div = document.createElement("div");
    var img = document.createElement("img");
    img.src ="https://cdn.dribbble.com/users/42048/screenshots/8350927/robotintro_dribble.gif";
    img.width = "550";
    img.height = "380";
    img.style.borderTopRightRadius = "15px";
    img.style.borderTopLeftRadius = "15px";

    div.style.marginTop = "20px";
    div.style.width = "550px";
    div.style.height = "auto";
    div.style.boxShadow="darkgrey 5px 5px 5px 5px";
    div.style.marginLeft="20px";
    div.style.borderRadius = "15px";
    div.style.textAlign = "right";
    div.style.marginTop= "35px";
    div.style.display = "flex";
    div.style.flexDirection = "column";

    var span=document.createElement("span");
    span.style.borderBottomLeftRadius = "15px";
    span.style.borderBottomRightRadius = "15px";
    span.style.paddingTop ="10px";
    span.style.paddingBottom ="10px";
    span.style.textAlign = "center";
    span.style.backgroundColor ="#4c89d4";
    span.style.color = "white";
    span.style.fontFamily = "productsans";
    span.style.fontSize = "1em";
    span.textContent = "Your Note Was Successfully Saved!";
    div.appendChild(img);
    div.appendChild(span);
    div.style.marginBottom = "40px";
    return div;
}

function seeNote() {
    var div=document.createElement("div");
    var span=document.createElement("span");
    span.style.borderRadius = "15px";
    span.style.paddingTop = "12px";
    span.style.paddingBottom = "12px";
    span.style.paddingRight = "25px";
    span.style.paddingLeft = "25px";
    span.style.backgroundColor ="#4c89d4";
    span.style.color = "white";
    span.style.fontFamily = "productsans";
    span.style.whiteSpace = "pre-line";
    span.style.height = "auto";
    span.style.fontSize = "1em";
    div.style.height = "auto";
    div.style.display = "flex";
    div.style.borderRadius = "15px";
    div.style.marginTop= "35px";
    span.innerHTML = "Your Notes Are:\n\n";
    var i =1;
    userNotes.forEach(element => {
        span.textContent += i+". "+element+"\n"
        i++;
    });
    div.style.marginLeft= "20px";
    div.style.marginBottom = "40px";
    div.appendChild(span);
    return div;
}

function createuserchat(){
    var div=document.createElement("div");
    var span=document.createElement("span");
    span.style.borderRadius = "15px";
    span.style.marginRight = "30px";
    span.style.paddingTop = "12px";
    span.style.paddingBottom = "12px";
    span.style.paddingRight = "25px";
    span.style.paddingLeft = "25px";
    span.style.backgroundColor ="#4c89d4";
    span.style.color = "white";
    span.style.fontFamily = "productsans";
    span.style.fontSize = "1em";
    div.style.borderRadius = "15px";
    div.style.textAlign = "right";
    div.style.marginTop= "35px";
    span.textContent = input.value;
    div.appendChild(span);
    return div;
}

function replyhi(){
    var div = document.createElement("div");
    var img = document.createElement("img");
    img.src = "https://fast.customer.io/s/cio-mascot-hello-wave.gif";
    img.width = "550";
    img.height = "300";

    img.style.marginLeft = "10px";
    div.style.boxShadow="darkgrey 5px 5px 5px 5px";
    div.style.marginTop = "20px";
    div.style.width = "550px";
    div.style.height = "300px";
    div.style.borderRadius = "10px";
    div.style.marginLeft="20px";
    div.style.padding = "10px";
    div.appendChild(img);

    chatBox.appendChild(div);

    getName();
}

function replyFromUser(message){
    var div = document.createElement("div");
    var p = document.createElement("p");
    p.value = message;

    div.style.boxShadow="darkgrey 5px 5px 5px 5px";
    div.style.marginTop = "20px";
    div.style.width = "550px";
    div.style.height = "300px";
    div.style.borderRadius = "10px";
    div.style.marginLeft="20px";
    div.style.padding = "10px";
    div.appendChild(p);
    
    
    chatBox.appendChild(div);
}

function replyimage(gambar){
    var div = document.createElement("div");
    var img = document.createElement("img");
    img.src =`https://source.unsplash.com/1600x900/?${gambar}`;
    img.width = "550";
    img.height = "380";
    img.style.borderRadius="10px";

    div.style.marginTop = "20px";
    div.style.width = "550px";
    div.style.height = "380px";
    div.style.boxShadow="darkgrey 5px 5px 5px 5px";
    div.style.borderRadius = "10px";
    div.style.marginLeft="20px";
    div.appendChild(img);
    div.style.marginBottom = "40px";
    return div;
}

function replywiki(wiki){
    var div = document.createElement("div");
    var iframe = document.createElement("iframe");
    iframe.style.marginLeft = "10px";
    iframe.src = `https://en.wikipedia.org/w/index.php?title=${wiki}&printable=yes`;
    iframe.frameBorder = "0";
    iframe.allowtransparency = "true";
    iframe.width = "550";
    iframe.height = "380";
    iframe.style.borderRadius = "10px";
    div.appendChild(iframe);
    div.style.padding = "10px";
    div.style.width = "550px";
    div.style.height = "380px";
    div.style.boxShadow="darkgrey 5px 5px 5px 5px";
    div.style.borderRadius = "10px";
    div.style.marginLeft = "20px";
    div.style.marginBottom = "40px";
    return div;
}

function replyspot(){
    var div = document.createElement("div");
    var spot = document.createElement("iframe");
    var randomIndex=Math.floor(Math.random() *songs.length);
    spot.src = songs[randomIndex];
    spot.allow = "encrypted-media";
    spot.frameBorder = "0";
    spot.allowtransparency = "true";
    spot.width = "300";
    spot.height = "380";
    spot.style.borderRadius = "10px";

    div.style.marginTop = "20px";
    div.style.width = "300px";
    div.style.height = "380px";
    div.style.borderRadius = "10px";
    div.style.marginLeft = "20px";
    div.style.marginBottom = "40px";
    div.style.boxShadow="darkgrey 5px 5px 5px 5px";
    div.appendChild(spot);
    return div;

}

function showPopUp() {
    var popUpBox = document.getElementById("blackboxid");
    popUpBox.style.display = "flex";
}

function hidePopUp() {
    var popUpBox = document.getElementById("blackboxid");
    popUpBox.style.display = "none";
}

function redirectToIndex() {
    // TODO : ADD SESSION CLEAR HERE
    window.location = "./index.xhtml";
}

function getName() {
    // TODO : PUT SESSION USERNAME HERE
    var usernameP = document.getElementById("unp");
}

function popUpGroup() {
    var groupPopUp = document.getElementById("popupGroup");
    groupPopUp.style.display = "flex";
}

function closeGroupPopup() {
    var groupPopUp = document.getElementById("popupGroup");
    groupPopUp.style.display = "none";
}

function popUpFriend() {
    var groupPopUp = document.getElementById("popupFriend");
    groupPopUp.style.display = "flex";
}

function closeFriendPopup() {
    var groupPopUp = document.getElementById("popupFriend");
    groupPopUp.style.display = "none";
}

function popUpInvite(userID) {
    var inputInvite = document.getElementById("inputInvite");
    var groupPopUp = document.getElementById("popupInvite");
    groupPopUp.style.display = "flex";
//    inputInvite.value = userID;
    $("#inputInvite").val(userID);
    console.log("this: "+userID);
}

function popupMember() {
    var inputInvite = document.getElementById("inputInvite");
    var groupPopUp = document.getElementById("popupMember");
    groupPopUp.style.display = "flex";
//    inputInvite.value = userID;
}

function closeMemberPopup() {
    var groupPopUp = document.getElementById("popupMember");
    groupPopUp.style.display = "none";
}

function closeInvitePopup() {
    var groupPopUp = document.getElementById("popupInvite");
    groupPopUp.style.display = "none";
}

function popUpPW() {
    var groupPopUp = document.getElementById("popupPW");
    groupPopUp.style.display = "flex";
}

function closePWPopUp() {
    var groupPopUp = document.getElementById("popupPW");
    groupPopUp.style.display = "none";
}