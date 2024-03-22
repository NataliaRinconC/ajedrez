document.addEventListener('DOMContentLoaded', function () {
    let fichaSeleccionada = null;

    // Función para seleccionar una ficha
    function seleccionarFicha(elemento) {
        if (fichaSeleccionada === null) {
            fichaSeleccionada = elemento;
            elemento.classList.add('seleccionada');
        } else {
            moverFicha(elemento);
        }
    }

    // Función para mover la ficha seleccionada
    function moverFicha(casilla) {
        if (fichaSeleccionada !== null) {
            // Verifica si la ficha seleccionada y la casilla seleccionada son las mismas
            if (fichaSeleccionada === casilla) {
                // Si son las mismas, cancela la selección de la ficha
                fichaSeleccionada.classList.remove('seleccionada');
                fichaSeleccionada = null;
            } else {
                // Mueve la ficha a la nueva casilla
                casilla.innerHTML = fichaSeleccionada.innerHTML;
                casilla.classList.add('ocupada');
                // Limpia la casilla original
                fichaSeleccionada.innerHTML = '';
                fichaSeleccionada.classList.remove('seleccionada');
                // Limpia la selección
                fichaSeleccionada = null;
                // Quita la clase 'ocupada' de todas las casillas
                let casillas = document.querySelectorAll('.tablero div');
                casillas.forEach(casilla => casilla.classList.remove('ocupada'));
            }
        }
    }

    // Event listener para clic en las fichas
    let fichas = document.querySelectorAll('.tablero div');
    fichas.forEach(ficha => {
        ficha.addEventListener('click', function () {
            seleccionarFicha(this);
        });
    });

    // Event listener para clic en las casillas
    let casillas = document.querySelectorAll('.tablero div:not(.a)');
    casillas.forEach(casilla => {
        casilla.addEventListener('click', function () {
            moverFicha(this);
        });
    });
});
