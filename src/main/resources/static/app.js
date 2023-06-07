let stompClient = null;

function setConnected(connected) {

	$("#connect").prop("disabled", connected);
	$("#disconnect").prop("disabled", !connected);

	if (connected) {
		$('#conversation').show();
	} else {
		$('#conversation').hide();
	}

	$("#responses").html("");
}

function connect() {
	const socket = new SockJS('/websocket-server');
	stompClient = Stomp.over(socket);
	stompClient.connect({}, function(frame) {
		setConnected(true);
		console.log('Connected: ' + frame);

		const subscription = stompClient.subscribe('/queue/responses', function(response) {
			showMsg(response, 'table-success');
		})

	})
}

function disconnect() {
	if (stompClient !== null) {
		stompClient.disconnect();
	}

	setConnected(false);
	console.log('Disconnected');
}

window.addEventListener('message', function(event) {
	if (event.origin === 'http://localhost:3000') {
			stompClient.send("/app/request", {}, event.data);
	}
});

function showMsg(response, clazz) {
	const input = response.body;
	console.log(input);
	$("#responses").append("<tr class='" + clazz + "'><td>" + input + "</td></tr>");
}

$(function() {
	$("form").on('submit', (e) => { e.preventDefault(); });
	$("#connect").click(() => { connect(); });
	$("#disconnect").click(() => { disconnect(); });
	$("#disconnect").prop("disabled", true);
	$('#conversation').hide();
})

