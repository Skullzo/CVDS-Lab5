# Laboratorio 5
## Preguntas del Laboratorio
### 1. Abra una terminal Linux o consola de comandos Windows.
### 2. Realice una conexión síncrona TCP/IP a través de Telnet al siguiente servidor:
* Host: www.escuelaing.edu.co
* Puerto: 80
* Teniendo en cuenta los parámetros del comando telnet: ```telnet HOST PORT```

Para realizar este procedimiento, ejecutamos el siguiente comando en la consola de comandos Windows.
<img  src="https://github.com/JuanMunozD/CVDS5/blob/master/Im%C3%A1genes/TelnetHostYPuerto.PNG">

### 3. Antes de que el servidor cierre la conexión por falta de comunicación:
* Revise la página 36 del RFC del protocolo HTTP, sobre cómo realizar una petición GET. Con esto, solicite al servidor el recurso ‘sssss/abc.html’, usando la versión 1.0 de HTTP.
* Asegúrese de presionar ENTER dos veces después de ingresar el comando.
* Revise el resultado obtenido. ¿Qué codigo de error sale?, revise el significado del mismo en la lista de códigos de estado HTTP.
* ¿Qué otros códigos de error existen?, ¿En qué caso se manejarán?

Al ejecutar el comando del paso anterior, vemos que no podemos ver lo que escribimos, junto con la consola de comandos de Windows negra totalmente.
<img  src="https://github.com/JuanMunozD/CVDS5/blob/master/Im%C3%A1genes/TelnetConectado.PNG">
Después, vemos que aparece el error **400**, que representa **Bad Request** o una solicitud incorrecta, que significa que el servidor no puede o no procesará la solicitud debido a un aparente error del cliente.
<img  src="https://github.com/JuanMunozD/CVDS5/blob/master/Im%C3%A1genes/TelnetError.PNG">
Los otros errores que existen son los siguientes:
* **Error 401: Unauthorized**
  
  Similar al **Error 403: Forbidden**, pero específicamente para usar cuando se requiere autenticación y ha fallado o aún no se ha proporcionado. La respuesta debe incluir un campo de encabezado WWW-Authenticate que contenga un desafío aplicable al recurso solicitado. Consulte Autenticación de acceso básica y Autenticación de acceso Digest. 401 semánticamente significa "no autorizado", el usuario no tiene credenciales de autenticación válidas para el recurso de destino. [Wikipedia](https://en.wikipedia.org/wiki/List_of_HTTP_status_codes)
* **Error 402: Payment Required**

  Reservado para uso futuro. La intención original era que este código se pudiera usar como parte de alguna forma de efectivo digital o esquema de micropagos, como lo propuso, por ejemplo, GNU Taler, pero eso aún no ha sucedido y este código no se usa ampliamente. La API de Google Developers usa este estado si un desarrollador en particular ha superado el límite diario de solicitudes. Sipgate usa este código si una cuenta no tiene fondos suficientes para iniciar una llamada. Shopify usa este código cuando la tienda no ha pagado sus tarifas y está temporalmente inhabilitada. Stripe usa este código para pagos fallidos donde los parámetros eran correctos, por ejemplo, pagos fraudulentos bloqueados. [Wikipedia](https://en.wikipedia.org/wiki/List_of_HTTP_status_codes)
* 
* 
* 
* 
* 
* 
