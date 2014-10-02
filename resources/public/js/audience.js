var WEB_SOCKET_URL = 'ws://example.com:8080/api/audience';

$(function () {
    var webSocket = new WebSocket(WEB_SOCKET_URL);

    webSocket.onopen = function () {
        console.log("Connected successfully!");
    };

    webSocket.onerror = function () {
        console.log("Could not connect!");
    };

    $('#example').on('click', function () {
        console.log("Message sent!");
        webSocket.send("Some message");
    });
});
