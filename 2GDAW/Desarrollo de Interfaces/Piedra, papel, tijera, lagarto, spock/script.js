var nombre_jugador = "";

function comenzar_partida() {
	coger_nombre();
}

function coger_nombre() {
	nombre_jugador = document.getElementById("nombre_jugador").value;
	document.getElementById("nombre_jugador_display").innerText = "Jugador: " + nombre_jugador;
}

function click_elemento(element) {
	alert(element.id);
}
