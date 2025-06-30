// Funciones para cargar selects y eventos

function limpiarSelect(idSelect) {
    const select = document.getElementById(idSelect);
    if (!select) return;
    select.innerHTML = '<option>--</option>';
}

function cargarCiudades() {
    fetch(`${API_BASE}/ciudades`)
        .then(res => res.json())
        .then(data => {
            const selectDestino = document.getElementById('destino');
            if (!selectDestino) return;
            selectDestino.innerHTML = '<option>--</option>';
            data.forEach(ciudad => {
                const option = document.createElement('option');
                option.value = ciudad.nombreCiudad;
                option.textContent = ciudad.nombreCiudad;
                selectDestino.appendChild(option);
            });
        })
        .catch(console.error);
}

function cargarAeropuertos(destino) {
    const selectAerop = document.getElementById('aeropuerto');
    if (!selectAerop) return;
    selectAerop.innerHTML = '<option>--</option>';

    if (!destino || destino === '--') return;

    fetch(`${API_BASE}/aeropuertos/por-ciudad?ciudad=${destino}`)
        .then(res => res.json())
        .then(data => {
            data.forEach(aerop => {
                const option = document.createElement('option');
                option.value = aerop.nombreAeropuerto;
                option.textContent = aerop.nombreAeropuerto;
                selectAerop.appendChild(option);
            });
        })
        .catch(console.error);
}

function cargarAerolineas(nombreAeropuerto) {
    const selectAero = document.getElementById('aerolinea');
    if (!selectAero) return;
    selectAero.innerHTML = '<option>--</option>';

    if (!nombreAeropuerto || nombreAeropuerto === '--') return;

    fetch(`${API_BASE}/aerolineas/por-aeropuerto?nombreAeropuerto=${encodeURIComponent(nombreAeropuerto)}`)
        .then(res => res.json())
        .then(data => {
            if(data.length === 0) {
                selectAero.innerHTML = '<option>No hay aerolíneas disponibles</option>';
                return;
            }

            data.forEach(aero => {
                const option = document.createElement('option');
                option.value = aero.nombreAerolinea;
                option.textContent = aero.nombreAerolinea;
                selectAero.appendChild(option);
            });
        })
        .catch(console.error);
}

function initCargaDatos() {
    cargarCiudades();

    const destinoSelect = document.getElementById('destino');
    if(destinoSelect){
        destinoSelect.addEventListener('change', (e) => {
            const destinoSeleccionado = e.target.value;
            cargarAeropuertos(destinoSeleccionado);

            limpiarSelect('aeropuerto');
            limpiarSelect('aerolinea');
            mostrarInfoParcial();
        });
    }

    const fechaInput = document.getElementById('fecha');
    if(fechaInput){
        fechaInput.addEventListener('change', () => {
            mostrarInfoParcial();
        });
    }

    const aeropuertoSelect = document.getElementById('aeropuerto');
    if(aeropuertoSelect){
        aeropuertoSelect.addEventListener('change', (e) => {
            const aeropuertoSeleccionado = e.target.value;
            if (!aeropuertoSeleccionado || aeropuertoSeleccionado === '--') {
                limpiarSelect('aerolinea');
                limpiarInfoVuelo();
                return;
            }
            cargarAerolineas(aeropuertoSeleccionado);
            mostrarInfoParcial();
        });
    }

    const aerolineaSelect = document.getElementById('aerolinea');
    if(aerolineaSelect){
        aerolineaSelect.addEventListener('change', async (e) => {
            const aerolineaSeleccionada = e.target.value;
            if (!aerolineaSeleccionada || aerolineaSeleccionada === '--') {
                tarifaActual = null;
                mostrarInfoParcial();
                return;
            }
            tarifaActual = await obtenerTarifaUnica();
            mostrarInfoParcial();
        });
    }
}
