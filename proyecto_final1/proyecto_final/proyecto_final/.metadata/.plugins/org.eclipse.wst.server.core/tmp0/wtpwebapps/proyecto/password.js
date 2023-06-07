// Archivo: script.js

class PasswordManager {
  enviarContraseña() {
    const contraseña = document.getElementById('contrasena').value;
    const request = new XMLHttpRequest();
    request.open('POST', 'procesarContraseña.jsp');
    request.setRequestHeader('Content-type', 'application/x-www-form-urlencoded');
    request.onreadystatechange = function() {
      if (request.readyState === 4) {
        if (request.status === 200) {
          console.log('Contraseña enviada con éxito');
          // Realizar cualquier otra acción después de enviar la contraseña
        } else {
          console.log('Error al enviar la contraseña');
        }
      }
    };
    const params = 'contraseña=' + encodeURIComponent(contraseña);
    request.send(params);
  }
}

const passwordManager = new PasswordManager();
