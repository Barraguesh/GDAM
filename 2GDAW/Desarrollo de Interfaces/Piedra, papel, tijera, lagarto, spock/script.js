let nombre_jugador = "";
const elementos_ordenador = ["piedra_ordenador", "papel_ordenador", "tijera_ordenador", "lagarto_ordenador", "spock_ordenador"];
let puntuacion_jugador = 0;
let puntuacion_ordenador = 0;

function comenzarPartida() {
	cogerNombre();

	let element = document.getElementById("registro_nombre");
	let op = 1;

	let timer_fade_out = setInterval(function () {
		if (op <= 0.1) {
			clearInterval(timer_fade_out);
			element.className = "ocultar";
		}
		element.style.opacity = op;
		element.style.filter = "alpha(opacity=" + op * 100 + ")";
		op -= op * 0.1;
	}, 25);
}

function cogerNombre() {
	nombre_jugador = document.getElementById("nombre_jugador").value;
	if (nombre_jugador != "" && nombre_jugador != null && nombre_jugador != " ") {
		document.getElementById("nombre_jugador_display").innerText = "Jugador: " + nombre_jugador;
	} else {
		alert("Hey, tienes que poner un nombre válido!");
	}
}

function clickElemento(element) {
	if (nombre_jugador != "") {
		let eleccion_jugador = element.id;

		switch (accionOrdenador()) {
			case "piedra_ordenador":
				ordenadorSeleccionPiedra(eleccion_jugador);
				break;

			case "papel_ordenador":
				ordenadorSeleccionPapel(eleccion_jugador);
				break;

			case "tijera_ordenador":
				ordenadorSeleccionTijera(eleccion_jugador);
				break;

			case "lagarto_ordenador":
				ordenadorSeleccionLagarto(eleccion_jugador);
				break;

			case "spock_ordenador":
				ordenadorSeleccionSpock(eleccion_jugador);
				break;

			default:
				alert("El ordenador no ha podido elegir, vuelve a internarlo más tarde.");
		}
	} else {
		alert("Hey, pon tu nombre para jugar!");
	}
}

function accionOrdenador() {
	let eleccion_ordenador = Math.floor(Math.random() * (5 - 0 + 0)) + 0;

	return elementos_ordenador[eleccion_ordenador];
}

function marcarResultado(array_resultado) {
	array_resultado.forEach((element) => {
		if (element.indexOf("jugador") >= 0) {
			if (element.indexOf("piedra") >= 0) {
				document.getElementById("resultado_jugador").src = "./media/rock.png";
			} else if (element.indexOf("papel") >= 0) {
				document.getElementById("resultado_jugador").src = "./media/paper.png";
			} else if (element.indexOf("tijera") >= 0) {
				document.getElementById("resultado_jugador").src = "./media/scissors.png";
			} else if (element.indexOf("lagarto") >= 0) {
				document.getElementById("resultado_jugador").src = "./media/lizard.png";
			} else {
				document.getElementById("resultado_jugador").src = "./media/spock.png";
			}
		} else {
			if (element.indexOf("piedra") >= 0) {
				document.getElementById("resultado_ordenador").src = "./media/rock.png";
			} else if (element.indexOf("papel") >= 0) {
				document.getElementById("resultado_ordenador").src = "./media/paper.png";
			} else if (element.indexOf("tijera") >= 0) {
				document.getElementById("resultado_ordenador").src = "./media/scissors.png";
			} else if (element.indexOf("lagarto") >= 0) {
				document.getElementById("resultado_ordenador").src = "./media/lizard.png";
			} else {
				document.getElementById("resultado_ordenador").src = "./media/spock.png";
			}
		}
	});
}

function puntuar(ganador) {
	if (ganador == "jugador") {
		puntuacion_jugador++;
		document.getElementById("puntuacion_jugador").textContent = puntuacion_jugador;
	} else if (ganador == "ordenador") {
		puntuacion_ordenador++;
		document.getElementById("puntuacion_ordenador").textContent = puntuacion_ordenador;
	}
}

//Funciones de selección de jugador para no complicar la interpretación de funciones
function ordenadorSeleccionPiedra(eleccion_jugador) {
	switch (eleccion_jugador) {
		case "piedra_jugador":
			marcarResultado(["piedra_ordenador", "piedra_jugador"]);
			puntuar("empate");
			break;

		case "papel_jugador":
			marcarResultado(["piedra_ordenador", "papel_jugador"]);
			puntuar("jugador");
			break;

		case "tijera_jugador":
			marcarResultado(["piedra_ordenador", "tijera_jugador"]);
			puntuar("ordenador");
			break;

		case "lagarto_jugador":
			marcarResultado(["piedra_ordenador", "lagarto_jugador"]);
			puntuar("ordenador");
			break;

		case "spock_jugador":
			marcarResultado(["piedra_ordenador", "spock_jugador"]);
			puntuar("jugador");
			break;
	}
}

function ordenadorSeleccionPapel(eleccion_jugador) {
	switch (eleccion_jugador) {
		case "piedra_jugador":
			marcarResultado(["papel_ordenador", "piedra_jugador"]);
			puntuar("ordenador");
			break;

		case "papel_jugador":
			marcarResultado(["papel_ordenador", "papel_jugador"]);
			puntuar("empate");
			break;

		case "tijera_jugador":
			marcarResultado(["papel_ordenador", "tijera_jugador"]);
			puntuar("jugador");
			break;

		case "lagarto_jugador":
			marcarResultado(["papel_ordenador", "lagarto_jugador"]);
			puntuar("jugador");
			break;

		case "spock_jugador":
			marcarResultado(["papel_ordenador", "spock_jugador"]);
			puntuar("ordenador");
			break;
	}
}

function ordenadorSeleccionTijera(eleccion_jugador) {
	switch (eleccion_jugador) {
		case "piedra_jugador":
			marcarResultado(["tijera_ordenador", "piedra_jugador"]);
			puntuar("jugador");
			break;

		case "papel_jugador":
			marcarResultado(["tijera_ordenador", "papel_jugador"]);
			puntuar("ordenador");
			break;

		case "tijera_jugador":
			marcarResultado(["tijera_ordenador", "tijera_jugador"]);
			puntuar("empate");
			break;

		case "lagarto_jugador":
			marcarResultado(["tijera_ordenador", "lagarto_jugador"]);
			puntuar("ordenador");
			break;

		case "spock_jugador":
			marcarResultado(["tijera_ordenador", "spock_jugador"]);
			puntuar("jugador");
			break;
	}
}

function ordenadorSeleccionLagarto(eleccion_jugador) {
	switch (eleccion_jugador) {
		case "piedra_jugador":
			marcarResultado(["lagarto_ordenador", "piedra_jugador"]);
			puntuar("jugador");
			break;

		case "papel_jugador":
			marcarResultado(["lagarto_ordenador", "papel_jugador"]);
			puntuar("ordenador");
			break;

		case "tijera_jugador":
			marcarResultado(["lagarto_ordenador", "tijera_jugador"]);
			puntuar("jugador");
			break;

		case "lagarto_jugador":
			marcarResultado(["lagarto_ordenador", "lagarto_jugador"]);
			puntuar("empate");
			break;

		case "spock_jugador":
			marcarResultado(["lagarto_ordenador", "spock_jugador"]);
			puntuar("ordenador");
			break;
	}
}

function ordenadorSeleccionSpock(eleccion_jugador) {
	switch (eleccion_jugador) {
		case "piedra_jugador":
			marcarResultado(["spock_ordenador", "piedra_jugador"]);
			puntuar("ordenador");
			break;

		case "papel_jugador":
			marcarResultado(["spock_ordenador", "papel_jugador"]);
			puntuar("jugador");
			break;

		case "tijera_jugador":
			marcarResultado(["spock_ordenador", "tijera_jugador"]);
			puntuar("ordenador");
			break;

		case "lagarto_jugador":
			marcarResultado(["spock_ordenador", "lagarto_jugador"]);
			puntuar("jugador");
			break;

		case "spock_jugador":
			marcarResultado(["spock_ordenador", "spock_jugador"]);
			puntuar("empate");
			break;
	}
}
