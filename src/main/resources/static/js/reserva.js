// Código para cargar la info del vuelo en la página reserva.html

function cargarInfoReserva() {
    if (window.location.pathname.endsWith('/reserva') || window.location.pathname.endsWith('/reserva.html')) {
        const vuelo = JSON.parse(localStorage.getItem('vueloSeleccionado'));
        console.log('Vuelo cargado:', vuelo);
        if (vuelo) {
            const tarifa = vuelo.tarifas?.[0];
            const total = (tarifa?.precioTarifa || 0) + (tarifa?.impuestoTarifa || 0);

            const div = document.getElementById('infoVuelo');
            if (div) {
                div.innerHTML = `
                    <p><strong>Destino:</strong> ${vuelo.aeropuertos?.[0]?.ciudad?.nombreCiudad || 'Desconocido'}</p>
                    <p><strong>Aeropuerto:</strong> ${vuelo.aeropuertos?.[0]?.nombreAeropuerto || 'Desconocido'}</p>
                    <p><strong>Aerolínea:</strong> ${vuelo.aerolinea?.nombreAerolinea || 'Desconocida'}</p>
                    <p><strong>Vuelo Nº:</strong> ${vuelo.numeroVuelo}</p>
                    <p><strong>Fecha:</strong> ${vuelo.fecha?.fecha || 'No especificada'}</p>
                    <p><strong>Tarifa total:</strong> $${total}</p>
                `;
            } else {
                console.error('No se encontró el elemento con id "infoVuelo"');
            }

            const totalDiv = document.getElementById('total');
            if (totalDiv) {
                totalDiv.innerText = '$' + total;
            } else {
                console.error('No se encontró el elemento con id "total"');
            }
        } else {
            console.warn('No hay vuelo seleccionado en localStorage');
        }
    }
}
