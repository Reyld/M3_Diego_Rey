# M3_Diego_Rey

Esta práctica consiste en una base de datos donde se puede registrar usuarios, y estos de almacenan en una base de datos, y se reflejan en el navegador.

Partes restantes:
  - Login y logout, con sus sistemas correspondientes.
  - Pantalla de registro.
  
 A implementar:
  - Un usuario administrador con poder para editar y/o eliminar al resto de usuarios.
  - Que el resto de usuarios tengan un nivel básico.

Aspectos que hay que corregir:
  - Update. En lugar de poder actualizar los datos de un usuario, se genera uno nuevo, a pesar de que carga el id del usuario a editar.
  - En ocasiones la página carga mal, ignorando la ruta y dependiendo únicamente del UserController.
  - En la lista de usuarios, no aparece ningún dato si no se pasa antes por la página de creación/edición de usuario.
