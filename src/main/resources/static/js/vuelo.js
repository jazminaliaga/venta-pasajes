// Funciones relacionadas con vuelo

function limpiarInfoVuelo() {
    const infoDiv = document.getElementById('infoVuelo');
    if (!infoDiv) return;
    infoDiv.innerHTML = '<p>Seleccione un vuelo para ver detalles.</p>';
}

async function obtenerTarifaUnica() {
    try {
        const res = await fetch(`${API_BASE}/tarifas`);
        if(!res.ok) throw new Error('Error al obtener tarifas');
        const tarifas = await res.json();
        return tarifas[0]; // asumimos que solo hay una
    } catch (error) {
        console.error(error);
        return null;
    }
}

function mostrarInfoParcial() {
    const destino = document.getElementById('destino')?.value || 'No seleccionado';
    const fecha = document.getElementById('fecha')?.value || 'No seleccionada';
    const aeropuerto = document.getElementById('aeropuerto')?.value || 'No seleccionado';
    const aerolinea = document.getElementById('aerolinea')?.value || 'No seleccionado';

    let tarifaTexto = 'No disponible';
    if (tarifaActual) {
        const total = (tarifaActual.precioTarifa || 0) + (tarifaActual.impuestoTarifa || 0);
        tarifaTexto = `$${total} (Precio: $${tarifaActual.precioTarifa}, Impuesto: $${tarifaActual.impuestoTarifa})`;
    }

    const infoDiv = document.getElementById('infoVuelo');
    if (!infoDiv) return;

    infoDiv.innerHTML = `
        <p><strong>Destino:</strong> ${destino}</p>
        <p><strong>Fecha:</strong> ${fecha}</p>
        <p><strong>Aeropuerto:</strong> ${aeropuerto}</p>
        <p><strong>Aerolínea:</strong> ${aerolinea}</p>
        <p><strong>Tarifa:</strong> ${tarifaTexto}</p>
        <p><em>Completa todos los datos y luego reservá el vuelo.</em></p>
    `;
}

async function reservarVuelo() {
    const destinoId = document.getElementById('destino')?.value;
    const aeropuertoId = document.getElementById('aeropuerto')?.value;
    const aerolineaNombre = document.getElementById('aerolinea')?.value;
    const fecha = document.getElementById('fecha')?.value;

    if (!destinoId || !aeropuertoId || !aerolineaNombre || !fecha) {
        alert('Por favor completá todos los campos.');
        return;
    }

    const tarifa = await obtenerTarifaUnica();
    if(!tarifa){
        alert('No se pudo obtener la tarifa. Intentá de nuevo más tarde.');
        return;
    }

    const vueloNuevo = {
        fecha: { fecha: fecha },
        aerolinea: { nombreAerolinea: aerolineaNombre },
        aeropuertos: [{
            nombreAeropuerto: aeropuertoId,
            ciudad: { nombreCiudad: destinoId }
        }],
        tarifas: [{ numeroTarifa: tarifa.numeroTarifa,
                    precioTarifa: tarifa.precioTarifa,
                    impuestoTarifa: tarifa.impuestoTarifa}]
    };

    fetch(`${API_BASE}/vuelos`, {
        method: 'POST',
        headers: { 'Content-Type': 'application/json' },
        body: JSON.stringify(vueloNuevo)
    })
    .then(async res => {
        if (!res.ok) {
            const errorText = await res.text();
            throw new Error(`Error en backend: ${res.status} - ${errorText}`);
        }
        return res.json();
    })
    .then(data => {
        localStorage.setItem('vueloSeleccionado', JSON.stringify(data));
        window.location.href = '/reserva';
    })
    .catch(err => {
        console.error('Error al crear vuelo:', err);
        alert('Hubo un error al reservar el vuelo.');
    });
}
