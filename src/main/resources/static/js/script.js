// URL base del backend
const API_BASE = 'http://localhost:9000/api';
let tarifaActual = null;

window.addEventListener('DOMContentLoaded', () => {
    cargarCiudades();

    document.getElementById('destino').addEventListener('change', (e) => {
        const destinoSeleccionado = e.target.value;
        cargarAeropuertos(destinoSeleccionado);

        limpiarSelect('aeropuerto');
        limpiarSelect('aerolinea');
        mostrarInfoParcial();
    });

    document.getElementById('fecha').addEventListener('change', (e) => {
        mostrarInfoParcial();
    });

    document.getElementById('aeropuerto').addEventListener('change', (e) => {
        const aeropuertoSeleccionado = e.target.value;
        if (!aeropuertoSeleccionado || aeropuertoSeleccionado === '--') {
            limpiarSelect('aerolinea');
            limpiarInfoVuelo();
            return;
        }
        cargarAerolineas(aeropuertoSeleccionado);
        mostrarInfoParcial();
    });

    document.getElementById('aerolinea').addEventListener('change', async (e) => {
        const aerolineaSeleccionada = e.target.value;
        if (!aerolineaSeleccionada || aerolineaSeleccionada === '--') {
            tarifaActual = null;
            mostrarInfoParcial();
            return;
        }
        tarifaActual = await obtenerTarifaUnica();
        mostrarInfoParcial();
    });

});

function limpiarSelect(idSelect) {
    const select = document.getElementById(idSelect);
    select.innerHTML = '<option>--</option>';
}

function limpiarInfoVuelo() {
    const infoDiv = document.getElementById('infoVuelo');
    infoDiv.innerHTML = '<p>Seleccione un vuelo para ver detalles.</p>';
}

function cargarCiudades() {
    fetch(`${API_BASE}/ciudades`)
        .then(res => res.json())
        .then(data => {
            const selectDestino = document.getElementById('destino');
            selectDestino.innerHTML = '<option>--</option>'; // limpio antes de cargar
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
    selectAerop.innerHTML = '<option>--</option>'; // limpio antes de cargar

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
    selectAero.innerHTML = '<option>--</option>'; // limpio antes de cargar

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

async function obtenerTarifaUnica() {
    const res = await fetch(`${API_BASE}/tarifas`);
    const tarifas = await res.json();
    return tarifas[0]; // asumimos que solo hay una
}

function mostrarInfoParcial() {
    const destino = document.getElementById('destino').value || 'No seleccionado';
    const fecha = document.getElementById('fecha').value || 'No seleccionada';
    const aeropuerto = document.getElementById('aeropuerto').value || 'No seleccionado';
    const aerolinea = document.getElementById('aerolinea').value || 'No seleccionado';

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
    const destinoId = document.getElementById('destino').value;
    const aeropuertoId = document.getElementById('aeropuerto').value;
    const aerolineaNombre = document.getElementById('aerolinea').value;
    const fecha = document.getElementById('fecha').value;

    if (!destinoId || !aeropuertoId || !aerolineaNombre || !fecha) {
        alert('Por favor completá todos los campos.');
        return;
    }

    const tarifa = await obtenerTarifaUnica();

    const vueloNuevo = {
        fecha: {
            fecha: fecha
        },
        aerolinea: {
            nombreAerolinea: aerolineaNombre
        },
        aeropuertos: [{
            nombreAeropuerto: aeropuertoId
        }],
        destino: {
            nombreCiudad: destinoId
        },
        tarifas: [{
            numeroTarifa: tarifa.numeroTarifa
        }]
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
    .catch(err => console.error('Error al crear vuelo:', err));
}

window.onload = function() {
    if (window.location.pathname.endsWith('/reserva') || window.location.pathname.endsWith('/reserva.html')) {
        const vuelo = JSON.parse(localStorage.getItem('vueloSeleccionado'));
        if (vuelo) {
            // Sumar precioTarifa + impuestoTarifa (de la primera tarifa)
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
                console.error('No se encontró el elemento con id "infoVuelo" en la página');
            }

            const totalDiv = document.getElementById('total');
            if (totalDiv) {
                totalDiv.innerText = '$' + total;
            } else {
                console.error('No se encontró el elemento con id "total" en la página');
            }
        } else {
            console.warn('No hay vuelo seleccionado en localStorage');
        }
    }
}

function cargarDatos() {
  // Obtener valores de inputs
  const dni = document.getElementById('dni').value.trim();
  const nombre = document.getElementById('nombre').value.trim();
  const apellido = document.getElementById('apellido').value.trim();

  if (!dni || !nombre || !apellido) {
    alert('Por favor, completá todos tus datos.');
    return;
  }

  // Mostrar los datos debajo de la info del vuelo
  const infoVueloDiv = document.getElementById('infoVuelo');

  let textoExistente = infoVueloDiv.innerHTML || '';

  // Añadir los datos personales (si ya existen, no repite)
  if (!textoExistente.includes('Tus datos')) {
    textoExistente += `
      <hr>
      <p><strong>DNI:</strong> ${dni}</p>
      <p><strong>Nombre:</strong> ${nombre}</p>
      <p><strong>Apellido:</strong> ${apellido}</p>
    `;
  } else {
    // Actualizamos si ya existe
    textoExistente = textoExistente.replace(/<p><strong>DNI:<\/strong>.*?<\/p>/, `<p><strong>DNI:</strong> ${dni}</p>`);
    textoExistente = textoExistente.replace(/<p><strong>Nombre:<\/strong>.*?<\/p>/, `<p><strong>Nombre:</strong> ${nombre}</p>`);
    textoExistente = textoExistente.replace(/<p><strong>Apellido:<\/strong>.*?<\/p>/, `<p><strong>Apellido:</strong> ${apellido}</p>`);
  }

  infoVueloDiv.innerHTML = textoExistente;
}

function pagar() {
   const nroTarjeta = document.getElementById('nroTarjeta').value.trim();
   const tipoTarjeta = document.getElementById('tipoTarjeta').value;

   if (!nroTarjeta) {
     alert('Por favor, ingresá el número de tarjeta.');
     return;
   }
   if (tipoTarjeta === '--') {
     alert('Por favor, seleccioná el tipo de tarjeta.');
     return;
   }

   // Agregar datos de pago al panel derecho, debajo de los datos del vuelo y usuario
   const infoVueloDiv = document.getElementById('infoVuelo');

   // Verificamos si ya existe la sección de Pago para actualizarla
   let contenido = infoVueloDiv.innerHTML;

   if (!contenido.includes('Datos de pago')) {
     contenido += `
       <hr>
       <p><strong>Nro tarjeta:</strong> ${nroTarjeta}</p>
       <p><strong>Tipo de tarjeta:</strong> ${tipoTarjeta}</p>
     `;
   } else {
     // Actualizamos los valores existentes
     contenido = contenido.replace(/<p><strong>Nro tarjeta:<\/strong>.*?<\/p>/, `<p><strong>Nro tarjeta:</strong> ${nroTarjeta}</p>`);
     contenido = contenido.replace(/<p><strong>Tipo de tarjeta:<\/strong>.*?<\/p>/, `<p><strong>Tipo de tarjeta:</strong> ${tipoTarjeta}</p>`);
   }

   infoVueloDiv.innerHTML = contenido;

   alert('Pago realizado con éxito');
 }

function volverABuscar() {
    window.location.href = '/';
}