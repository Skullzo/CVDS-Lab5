# Laboratorio 5
## Parte I. - Jugando a ser un cliente HTTP
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

La diferencia entre los métodos **GET** y **POST** radica en la forma de enviar los datos a la página cuando se pulsa el botón “Enviar”. Mientras que el método **GET** envía los datos usando la URL, el método **POST** los envía de forma que no podemos verlos (en un segundo plano u "ocultos" al usuario). [aprendeaprogramar.com](https://aprenderaprogramar.com/index.php?option=com_content&view=article&id=527:get-y-post-html-method-formas-de-envio-de-datos-en-formulario-diferencias-y-ventajas-ejemplos-cu00721b&catid=69&Itemid=192#:~:text=La%20diferencia%20entre%20los%20m%C3%A9todos,%22ocultos%22%20al%20usuario)

### 6. En la practica no se utiliza ```telnet``` para hacer peticiones a sitios web sino el comando ```curl``` con ayuda de la linea de comandos:

```curl www.httpbin.org```

Utilice ahora el parámetro ```-v``` y con el parámetro ```-i```:

```
curl -v www.httpbin.org
curl -i www.httpbin.org
```

¿Cuáles son las diferencias con los diferentes parámetros?

Luego de ejecutar el comando ```curl www.httpbin.org```, vemos que nos aparece todo el código HTML de la página web **www.httpbin.org**.
<img  src="https://github.com/JuanMunozD/CVDS5/blob/master/Im%C3%A1genes/CURLwww.httpbin.org.PNG">
Después, al ejecutar el comando ```curl -v www.httpbin.org```, vemos que nos muestra detalladamente que hizo una conexión a la dirección IP **3.221.81.55** por el puerto **80**, realiza el **GET** al host **www.httpbin.org**, el cual muestra que ha sido **Aceptado**, y después si muestra el HTML de la página web.
<img  src="https://github.com/JuanMunozD/CVDS5/blob/master/Im%C3%A1genes/CURL-vwww.httpbin.org.PNG">
Ahora, al ejecutar el comando ```curl -i www.httpbin.org```, vemos que a diferencia del comando ```curl -v www.httpbin.org```, este al principio no muestra información detallada del **GET**, sino que muestra la fecha y hora en que se realizó la consulta del HTML, acompañado del tipo, que es **HTML**, la longitud, el tipo de conexión, el servidor al que se conectó, y luego si el código HTML.
<img  src="https://github.com/JuanMunozD/CVDS5/blob/master/Im%C3%A1genes/CURL-iwww.httpbin.org.PNG">

## Parte II. - Haciendo una aplicación Web dinámica a bajo nivel.
En este ejercicio, va a implementar una aplicación Web muy básica, haciendo uso de los elementos de más bajo nivel de Java-EE (Enterprise Edition), con el fin de revisar los conceptos del protocolo HTTP. En este caso, se trata de un módulo de consulta de clientes Web que hace uso de una librería de acceso a datos disponible en un repositorio Maven local.

Para esto, cree un proyecto maven nuevo usando el arquetipo de aplicación Web estándar maven-archetype-webapp y realice lo siguiente:
### 1. Revise la clase SampleServlet incluida a continuacion, e identifique qué hace:
```
package edu.eci.cvds.servlet;

import java.io.IOException;
import java.io.Writer;
import java.util.Optional;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(
    urlPatterns = "/helloServlet"
)
public class SampleServlet extends HttpServlet{
    static final long serialVersionUID = 35L;

    @Override
   protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       Writer responseWriter = resp.getWriter();
       Optional<String> optName = Optional.ofNullable(req.getParameter("name"));
       String name = optName.isPresent() && !optName.get().isEmpty() ? optName.get() : "";

       resp.setStatus(HttpServletResponse.SC_OK);
       responseWriter.write("Hello" + name + "!");
       responseWriter.flush();
   }
}
```
Revise qué valor tiene el parámetro ‘urlPatterns’ de la anotación @WebServlet, pues este indica qué URLs atiende las peticiones el servlet.

El valor del parámetro 'urlPatterns' de la anotación @WebServlet es ```/helloServlet```, el cual utilizaremos posteriormente para realizar el localhost.
La clase lo que hace es principalmente imprimir un Hello junto con el parámetro que le ingresemos en el URL, y si no ingresamos ningún parámetro, imprime simplemente **Hello World!**

Para realizar el siguiente procedimiento, primero creamos el proyecto **Servlet**, el cual lo hacemos mediante Maven.
<img  src="https://github.com/JuanMunozD/CVDS5/blob/master/Im%C3%A1genes/CreacionProyectoServlet.PNG">

### 2. En el pom.xml, modifique la propiedad "packaging" con el valor "war". Agregue la siguiente dependencia:
```
<dependency>
     <groupId>javax</groupId>
     <artifactId>javaee-web-api</artifactId>
     <version>7.0</version>
     <scope>provided</scope>
</dependency>
```
A continuación, agregamos la siguiente dependencia en el ```pom.xml``` a nuestro proyecto que hemos abierto en Eclipse.
<img  src="https://github.com/JuanMunozD/CVDS5/blob/master/Im%C3%A1genes/DependenciaPOM.PNG">
Y luego agregamos la seccion build al final del tag ```project``` en el archivo ```pom.xml```:
```
<build>
   <plugins>
       <plugin>
           <groupId>org.apache.maven.plugins</groupId>
           <artifactId>maven-compiler-plugin</artifactId>
           <version>3.8.0</version>
           <configuration>
               <source>1.8</source>
               <target>1.8</target>
           </configuration>
       </plugin>
       <plugin>
           <groupId>org.apache.maven.plugins</groupId>
           <artifactId>maven-war-plugin</artifactId>
           <version>2.3</version>
           <configuration>
               <failOnMissingWebXml>false</failOnMissingWebXml>
           </configuration>
       </plugin>
       <plugin>
           <groupId>org.apache.maven.plugins</groupId>
           <artifactId>maven-dependency-plugin</artifactId>
           <version>2.6</version>
           <executions>
               <execution>
                   <phase>validate</phase>
                   <goals>
                       <goal>copy</goal>
                   </goals>
                   <configuration>
                       <silent>true</silent>
                       <artifactItems>
                           <artifactItem>
                               <groupId>javax</groupId>
                               <artifactId>javaee-endorsed-api</artifactId>
                               <version>7.0</version>
                               <type>jar</type>
                           </artifactItem>
                       </artifactItems>
                   </configuration>
               </execution>
           </executions>
       </plugin>

       <!-- Tomcat embedded plugin. -->
       <plugin>
           <groupId>org.apache.tomcat.maven</groupId>
           <artifactId>tomcat7-maven-plugin</artifactId>
           <version>2.2</version>
           <configuration>
               <port>8080</port>
               <path>/</path>
           </configuration>
       </plugin>
   </plugins>
</build>
```
### 3. Revise en el pom.xml para qué puerto TCP/IP está configurado el servidor embebido de Tomcat (ver sección de plugins).

El puerto TCP/IP al que está configurado el servidor embebido de Tomcat es el **8080**, que es el puerto de **Tomcat**.

### 4. Compile y ejecute la aplicación en el servidor embebido Tomcat, a través de Maven con:
```
mvn package
mvn tomcat7:run
```
Primero compilamos el proyecto con el comando ```mvn package```. Vemos que la compilación ha sido satisfactoria.
<img  src="https://github.com/JuanMunozD/CVDS5/blob/master/Im%C3%A1genes/CompilacionWebApp.PNG">
Luego ejecutamos la aplicación en el servidor embebido Tomcat usando el comando ```mvn tomcat7:run``` de la siguiente forma.
<img  src="https://github.com/JuanMunozD/CVDS5/blob/master/Im%C3%A1genes/CompilacionTomcat.PNG">
### 5. Abra un navegador, y en la barra de direcciones ponga la URL con la cual se le enviarán peticiones al ‘SampleServlet’. Tenga en cuenta que la URL tendrá como host ‘localhost’, como puerto, el configurado en el pom.xml y el path debe ser el del Servlet. Debería obtener un mensaje de saludo.
En nuestro navegador ingresamos el URL ```localhost:8080```. Vemos que nos retorna **Hello World!**, lo cual nos indica que el procedimiento realizado ha sido un éxito.
<img  src="https://github.com/JuanMunozD/CVDS5/blob/master/Im%C3%A1genes/HelloWorldTomcat.PNG">
### 6. Observe que el Servlet ‘SampleServlet’ acepta peticiones GET, y opcionalmente, lee el parámetro ‘name’. Ingrese la misma URL, pero ahora agregando un parámetro GET (si no sabe como hacerlo, revise la documentación en http://www.w3schools.com/tags/ref_httpmethods.asp).
Para probar que el código funciona correctamente, ingresamos en nuestro navegador web la URL ```localhost:8080/helloServlet?name=Alejandro```. Vemos que ahora nos retorna **Hello Alejandro!** en la página web.
<img  src="https://github.com/JuanMunozD/CVDS5/blob/master/Im%C3%A1genes/MensajeSaludoWebApp.PNG">
### 7. Busque el artefacto ```gson``` en el repositorio de ```maven``` y agregue la dependencia.
A continuación, agregamos la dependencia del artefacto ```gson``` en el proyecto en Eclipse de la siguiente forma.

<img  src="https://github.com/JuanMunozD/CVDS5/blob/master/Im%C3%A1genes/DependenciaGSON.PNG">
