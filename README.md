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

Los otros errores que existen (entre muchos otros más) son los siguientes:
* **Error 401: Unauthorized**
  
  Similar al **Error 403: Forbidden**, pero específicamente para usar cuando se requiere autenticación y ha fallado o aún no se ha proporcionado. La respuesta debe incluir un campo de encabezado WWW-Authenticate que contenga un desafío aplicable al recurso solicitado. Consulte Autenticación de acceso básica y Autenticación de acceso Digest. 401 semánticamente significa "no autorizado", el usuario no tiene credenciales de autenticación válidas para el recurso de destino. [Wikipedia](https://en.wikipedia.org/wiki/List_of_HTTP_status_codes)
* **Error 402: Payment Required**

  Reservado para uso futuro. La intención original era que este código se pudiera usar como parte de alguna forma de efectivo digital o esquema de micropagos, como lo propuso, por ejemplo, GNU Taler, pero eso aún no ha sucedido y este código no se usa ampliamente. La API de Google Developers usa este estado si un desarrollador en particular ha superado el límite diario de solicitudes. Sipgate usa este código si una cuenta no tiene fondos suficientes para iniciar una llamada. Shopify usa este código cuando la tienda no ha pagado sus tarifas y está temporalmente inhabilitada. Stripe usa este código para pagos fallidos donde los parámetros eran correctos, por ejemplo, pagos fraudulentos bloqueados. [Wikipedia](https://en.wikipedia.org/wiki/List_of_HTTP_status_codes)
* **Error 403: Forbidden**

  La solicitud contenía datos válidos y fue entendida por el servidor, pero el servidor rechaza la acción. Esto puede deberse a que el usuario no tiene los permisos necesarios para un recurso o necesita una cuenta de algún tipo, o al intentar una acción prohibida (por ejemplo, crear un registro duplicado donde solo se permite uno). Este código también se usa normalmente si la solicitud proporcionó autenticación respondiendo al desafío del campo de encabezado WWW-Authenticate, pero el servidor no aceptó esa autenticación. La solicitud no debe repetirse. [Wikipedia](https://en.wikipedia.org/wiki/List_of_HTTP_status_codes)
* **Error 404: Not Found**

  No se pudo encontrar el recurso solicitado, pero es posible que esté disponible en el futuro. Se permiten solicitudes posteriores por parte del cliente. [Wikipedia](https://en.wikipedia.org/wiki/List_of_HTTP_status_codes)

### 4. Realice una nueva conexión con telnet, esta vez a:
* Host: www.httpbin.org
* Puerto: 80
* Versión HTTP: 1.1
Ahora, solicite (GET) el recurso /html. ¿Qué se obtiene como resultado?

Luego de ejecutar el comando ```telnet www.httpbin.org 80```, vemos que nos aparece lo siguiente.
<img  src="https://github.com/JuanMunozD/CVDS5/blob/master/Im%C3%A1genes/HTTPbin%20correcto.PNG">

### 5. Seleccione el contenido ```HTML``` de la respuesta y copielo al cortapapeles ```CTRL-SHIFT-C```. Ejecute el comando ```wc``` (word count) para contar palabras con la opción ```-c``` para contar el número de caracteres:

```wc -c```

Pegue el contenido del portapapeles con ```CTRL-SHIFT-V``` y presione ```CTRL-D``` (fin de archivo de Linux). Si no termina el comando ```wc``` presione ```CTRL-D``` de nuevo. No presione mas de dos veces ```CTRL-D``` indica que se termino la entrada y puede cerrarle la terminal. Debe salir el resultado de la cantidad de caracteres que tiene el contenido HTML que respondió el servidor.

Claro está, las peticiones GET son insuficientes en muchos casos. Investigue: ¿Cuál es la diferencia entre los verbos GET y POST? ¿Qué otros tipos de peticiones existen?

Luego de guardar el contenido del HTML en un txt, y ejecutar el comando ```wc -c```, vemos que nos aparece el conteo total de caracteres, de la siguiente forma.

<img  src="https://github.com/JuanMunozD/CVDS5/blob/master/Im%C3%A1genes/HTTPbinWordCount.PNG">

La diferencia entre los métodos get y post radica en la forma de enviar los datos a la página cuando se pulsa el botón “Enviar”. Mientras que el método **GET** envía los datos usando la URL, el método **POST** los envía de forma que no podemos verlos (en un segundo plano u "ocultos" al usuario). [aprendeaprogramar.com](https://aprenderaprogramar.com/index.php?option=com_content&view=article&id=527:get-y-post-html-method-formas-de-envio-de-datos-en-formulario-diferencias-y-ventajas-ejemplos-cu00721b&catid=69&Itemid=192#:~:text=La%20diferencia%20entre%20los%20m%C3%A9todos,%22ocultos%22%20al%20usuario).)
