var WEB_SOCKET_URL = 'ws://example.com:8080/api/presenter';

$(function () {
    var webSocket = new WebSocket(WEB_SOCKET_URL);

    webSocket.onopen = function () {
        console.log("Connected successfully!");
    };

    webSocket.onerror = function () {
        console.log("Could not connect!");
    };

    webSocket.onmessage = function (event) {
        console.log("Message received: " + event.data);
    };
});
