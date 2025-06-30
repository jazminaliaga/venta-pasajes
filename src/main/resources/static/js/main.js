// Código principal que arranca la app

window.addEventListener('DOMContentLoaded', () => {
    if (typeof initCargaDatos === 'function') {
        initCargaDatos();
    }
});

window.onload = () => {
    if (typeof cargarInfoReserva === 'function') {
        cargarInfoReserva();
    }
};
