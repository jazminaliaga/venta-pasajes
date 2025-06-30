// Funciones para cargar datos personales, pago y volver a buscar

async function cargarDatos() {
    const dni = document.getElementById('dni')?.value.trim();
    const nombre = document.getElementById('nombre')?.value.trim();
    const apellido = document.getElementById('apellido')?.value.trim();

    if (!dni || !nombre || !apellido) {
        alert('Por favor, completá todos tus datos.');
        return;
    }

    try {
        const res = await fetch(`${API_BASE}/usuarios`, {
            method: 'POST',
            headers: { 'Content-Type': 'application/json' },
            body: JSON.stringify({
              dniPersona: parseInt(dni),
              nombrePersona: nombre,
              apellidoPersona: apellido
            }),
        });

        if (!res.ok) {
            const errorText = await res.text();
            throw new Error(`Error creando usuario: ${res.status} - ${errorText}`);
        }

        const usuarioCreado = await res.json();
        console.log('Usuario creado:', usuarioCreado);

        // Mostrar datos en la UI igual que antes
        const infoVueloDiv = document.getElementById('infoVuelo');
        if (!infoVueloDiv) return;

        let textoExistente = infoVueloDiv.innerHTML || '';

        if (!textoExistente.includes('DNI:')) {
            textoExistente += `
              <hr>
              <p><strong>DNI:</strong> ${dni}</p>
              <p><strong>Nombre:</strong> ${nombre}</p>
              <p><strong>Apellido:</strong> ${apellido}</p>
            `;
        } else {
            textoExistente = textoExistente.replace(/<p><strong>DNI:<\/strong>.*?<\/p>/, `<p><strong>DNI:</strong> ${dni}</p>`);
            textoExistente = textoExistente.replace(/<p><strong>Nombre:<\/strong>.*?<\/p>/, `<p><strong>Nombre:</strong> ${nombre}</p>`);
            textoExistente = textoExistente.replace(/<p><strong>Apellido:<\/strong>.*?<\/p>/, `<p><strong>Apellido:</strong> ${apellido}</p>`);
        }

        infoVueloDiv.innerHTML = textoExistente;

    } catch (error) {
        console.error(error);
        alert('Error al guardar los datos personales. Intentá nuevamente.');
    }
}

function pagar() {
    const nroTarjeta = document.getElementById('nroTarjeta')?.value.trim();
    const tipoTarjeta = document.getElementById('tipoTarjeta')?.value;

    if (!nroTarjeta) {
        alert('Por favor, ingresá el número de tarjeta.');
        return;
    }
    if (!tipoTarjeta || tipoTarjeta === '--') {
        alert('Por favor, seleccioná el tipo de tarjeta.');
        return;
    }

    const tarjeta = {
        numeroTarjeta: parseInt(nroTarjeta),
        tipoTarjeta: tipoTarjeta,
        cantidadPago: 55000
    };

    fetch(`${API_BASE}/tarjetas`, {
        method: 'POST',
        headers: { 'Content-Type': 'application/json' },
        body: JSON.stringify(tarjeta)
    })
    .then(res => {
        if (!res.ok) throw new Error('Error al registrar tarjeta');
        return res.json();
    })
    .then(data => {
        console.log('Tarjeta registrada:', data);
        alert('Pago realizado con éxito');

        const infoVueloDiv = document.getElementById('infoVuelo');
        if (!infoVueloDiv) return;

        let contenido = infoVueloDiv.innerHTML;

        if (!contenido.includes('Nro tarjeta:')) {
            contenido += `
              <hr>
              <p><strong>Nro tarjeta:</strong> ${nroTarjeta}</p>
              <p><strong>Tipo de tarjeta:</strong> ${tipoTarjeta}</p>
            `;
        } else {
            contenido = contenido.replace(/<p><strong>Nro tarjeta:<\/strong>.*?<\/p>/, `<p><strong>Nro tarjeta:</strong> ${nroTarjeta}</p>`);
            contenido = contenido.replace(/<p><strong>Tipo de tarjeta:<\/strong>.*?<\/p>/, `<p><strong>Tipo de tarjeta:</strong> ${tipoTarjeta}</p>`);
        }

        infoVueloDiv.innerHTML = contenido;
    })
    .catch(err => {
        console.error('Error al guardar tarjeta:', err);
        alert('Hubo un problema al guardar la tarjeta.');
    });
}

function volverABuscar() {
    window.location.href = '/';
}
