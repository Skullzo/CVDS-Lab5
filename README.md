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

### 8. En el navegador revise la dirección https://jsonplaceholder.typicode.com/todos/1. Intente cambiando diferentes números al final del ```path``` de la url.
Al dejar primero el número 1 al final de la URL, vemos que nos aparece lo siguiente.
<img  src="https://github.com/JuanMunozD/CVDS5/blob/master/Im%C3%A1genes/CambioPathURL1.PNG">

Luego, al ingresar el número 2 al final de la URL, vemos que cambia el valor del atributo **id** de **1** a **2** y el valor del atributo de **delectus aut autem** a **quis ut nam facilis et officia qui**.
<img  src="https://github.com/JuanMunozD/CVDS5/blob/master/Im%C3%A1genes/CambioPathURL2.PNG">

Después al ingresar el número 3 al final de la URL, vemos que cambia el valor del atributo **id** de **2** a **3** y el valor del atributo **title** de **quis ut nam facilis et officia qui** a **fugiat veniam minus**.
<img  src="https://github.com/JuanMunozD/CVDS5/blob/master/Im%C3%A1genes/CambioPathURL3.PNG">

### 9. Basado en la respuesta que le da el servicio del punto anterior, cree la clase ```edu.eci.cvds.servlet.model.Todo``` con un constructor vacío y los métodos ```getter``` y ```setter``` para las propiedades de los "To Dos" que se encuentran en la url indicada.
A continuación, creamos primero la clase **Todo** dentro del paquete ```edu.eci.cvds.servlet.model```, la cual le ingresamos los atributos ```userId```, ```id```, ```title``` y ```completed``` y creamos los respectivos ```getter``` y ```setter```.
<img  src="https://github.com/JuanMunozD/CVDS5/blob/master/Im%C3%A1genes/CreacionGetterSetter.PNG">

Luego al crear los ```getter``` y ```setter``` en la imagen anterior, vemos que quedan de la siguiente forma en la clase **Todo**.
<img  src="https://github.com/JuanMunozD/CVDS5/blob/master/Im%C3%A1genes/GetterYSetter.PNG">

### 10. Utilice la siguiente clase para consumir el servicio que se encuentra en la dirección url del punto anterior:
```
package edu.eci.cvds.servlet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;

import com.google.gson.Gson;

import edu.eci.cvds.servlet.model.Todo;

public class Service {

   public static Todo getTodo(int id) throws MalformedURLException, IOException {
       URL urldemo = new URL("https://jsonplaceholder.typicode.com/todos/" + id);
       URLConnection yc = urldemo.openConnection();
       BufferedReader in = new BufferedReader(new InputStreamReader(yc.getInputStream()));
       Gson gson = new Gson();
       Todo todo = gson.fromJson(in, Todo.class);
       in.close();
       return todo;
   }

   private static String todoToHTMLRow(Todo todo) {
       return new StringBuilder("<tr>")
           .append("<td>")
           .append(todo.getUserId())
           .append("</td><td>")
           .append(todo.getId())
           .append("</td><td>")
           .append(todo.getTitle())
           .append("</td><td>")
           .append(todo.getCompleted())
           .append("</td>")
           .append("</tr>")
           .toString();
   }

   public static String todosToHTMLTable(List<Todo> todoList) {
       StringBuilder stringBuilder = new StringBuilder("<table>")
           .append("<tr>")
           .append("<th>User Id</th>")
           .append("<th>Id</th>")
           .append("<th>Title</th>")
           .append("<th>Completed</th>")
           .append("</tr>");

       for (Todo todo : todoList) {
           stringBuilder.append(todoToHTMLRow(todo));
       }

       return stringBuilder.append("</table>").toString();
   }
}
```
En nuestro proyecto de Eclipse, creamos la clase **Service** en el paquete ```edu.eci.cvds.servlet```, quedando de la siguiente forma.

<img  src="https://github.com/JuanMunozD/CVDS5/blob/master/Im%C3%A1genes/ClaseService.PNG">

### 11. Cree una clase que herede de la clase HttpServlet (similar a SampleServlet), y para la misma sobrescriba el método heredado ```doGet```. Incluya la anotación ```@Override``` para verificar –en tiempo de compilación- que efectivamente se esté sobreescribiendo un método de las superclases.

Primero, creamos la clase **SampleServletService** que hereda de la clae **HttpServlet**, en la cual sobreescribimos el método heredado ```doGet```, quedando de la siguiente forma.

<img  src="https://github.com/JuanMunozD/CVDS5/blob/master/Im%C3%A1genes/CreacionClaseServlet.PNG">

### 12. Para indicar en qué URL el servlet interceptará las peticiones GET, agregue al método la anotación ```@WebServlet```, y en dicha anotación, defina la propiedad ```urlPatterns```, indicando la URL (que usted defina) a la cual se asociará el servlet.

A continuación, agregamos la anotación ```@WebServlet``` y definimos la propiedad ```urlPatterns``` con el URL definido que es ```/cosasPorHacer```.

<img  src="https://github.com/JuanMunozD/CVDS5/blob/master/Im%C3%A1genes/WebServlet.PNG">

### 13. Teniendo en cuenta las siguientes métodos disponibles en los objetos ServletRequest y ServletResponse recibidos por el método doGet:

* response.setStatus(N); <- Indica con qué código de error N se generará la respuesta. Usar la clase HttpServletResponse para indicar el código de respuesta.
* request.getParameter(param); <- Consulta el parámetro recibido, asociado al nombre ‘param’.
* response.getWriter() <- Retorna un objeto PrintWriter a través del cual se le puede enviar la respuesta a quien hizo la petición.
* response.setContentType(T) <- Asigna el tipo de contenido (MIME type) que se entregará en la respuesta.

Implemente dicho método de manera que:

* Asuma que la petición HTTP recibe como parámetro el número de id de una lista de cosas por hacer (todo), y que dicha identificación es un número entero.
* Con el identificador recibido, consulte el item por hacer de la lista de cosas por hacer, usando la clase "Service" creada en el punto 10.
* Si el item existe:
  * Responder con el código HTTP que equivale a ‘OK’ (ver referencia anterior), y como contenido de dicha respuesta, el código html correspondiente a una página con una tabla que tenga los detalles del item, usando la clase "Service" creada en el punto 10 par crear la tabla.
* Si el item no existe:
  * Responder con el código correspondiente a ‘no encontrado’, y con el código de una página html que indique que no existe un item con el identificador dado.
  * Si no se paso parámetro opcional, o si el parámetro no contiene un número entero, devolver el código equivalente a requerimiento inválido.
  * Si se genera la excepcion MalformedURLException devolver el código de error interno en el servidor
  * Para cualquier otra excepcion, devolver el código equivalente a requerimiento inválido.

Para indicar si el item existe o no existe, creamos un ArrayList con las cosas por hacer, y agregamos todo a la lista de cosas por hacer, en la cual mostramos la tabla HTML usando Service, e importamos el paquete **MalformedURLException** para manejar todas las excepciones que se generan dependiendo del tipo de error que se genera (ya sea Not Found, Bad Request o Internal Server Error, quedando de la siguiente forma.

<img  src="https://github.com/JuanMunozD/CVDS5/blob/master/Im%C3%A1genes/OverrideYdoGet.PNG">

## Parte III.

### 16. En su servlet, sobreescriba el método doPost, y haga la misma implementación del doGet.

A continuación, implementamos el método ```doPost```, quedando de la siguiente forma (similar a la implementación del ```doGet```).

<img  src="https://github.com/JuanMunozD/CVDS5/blob/master/Im%C3%A1genes/MetododoPost.PNG">

### 17. Cree el archivo ```index.html``` en el directorio ```src/main/webapp/index.html``` de la siguiente manera:
```
<!DOCTYPE html>
<html>
    <head>
        <title>Start Page</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    </head>
    <body>
        <h1>Hello World!</h1>
    </body>
</html>
```

A continuación, creamos el archivo ```index.html``` en el directorio ```src/main/webapp/index.html``` de la siguiente forma.

<img  src="https://github.com/JuanMunozD/CVDS5/blob/master/Im%C3%A1genes/indexHTML.PNG">

### 18. En la página anterior, cree un formulario que tenga un campo para ingresar un número (si no ha manejado html antes, revise http://www.w3schools.com/html/ ) y un botón. El formulario debe usar como método ‘POST’, y como acción, la ruta relativa del último servlet creado (es decir la URL pero excluyendo ‘http://localhost:8080/’).

### 19. Revise este ejemplo de validación de formularios con javascript y agruéguelo a su formulario, de manera que -al momento de hacer ‘submit’- desde el browser se valide que el valor ingresado es un valor numérico.

Ahora, para los puntos **18** y **19**, creamos un formulario que tenga un campo para ingresar un número con un botón de la siguiente forma.

<img  src="https://github.com/JuanMunozD/CVDS5/blob/master/Im%C3%A1genes/indexPOST.PNG">

### 20. Recompile y ejecute la aplicación. Abra en su navegador en la página del formulario, y rectifique que la página hecha anteriormente sea mostrada. Ingrese los datos y verifique los resultados. Cambie el formulario para que ahora en lugar de POST, use el método GET . Qué diferencia observa?

Al cambiar el método **POST** por **GET**, realizamos el siguiente cambio en el HTML.

<img  src="https://github.com/JuanMunozD/CVDS5/blob/master/Im%C3%A1genes/IndexFormulario.PNG">
 
La diferencia entre el **POST** y el **GET** es que en el **POST** no aparece el ```id=1```, y con el **GET** si aparece el ```id=1```.

### 21. ¿Qué se está viendo? Revise cómo están implementados los métodos de la clase Service.java para entender el funcionamiento interno.

En el código de **Service.java** que vemos a continuación, el método ```todoToHTMLRow``` lo que hace es realizar las filas de la tabla, y el método ```todosToHTMLTable``` lo que hace es realizar las columnas de la tabla.

<img  src="https://github.com/JuanMunozD/CVDS5/blob/master/Im%C3%A1genes/ClaseServiceHTTP.PNG">

## Parte IV. - Frameworks Web MVC – Java Server Faces / Prime Faces

En este ejercicio, usted va a desarrollar una aplicación Web basada en el marco JSF, y en una de sus implementaciones más usadas: PrimeFaces. 

Escriba una aplicación web que utilice PrimeFaces para calcular la media, la moda, la desviación estándar y varianza de un conjunto de N números reales. Este conjunto de N números reales deben ser ingresados por el usuario de manera que puedan ser utilizados para los cálculos.

**Diagrama de casos de uso de la aplicación:**

<img  src="https://github.com/JuanMunozD/CVDS5/blob/master/Im%C3%A1genes/CasoDeUsoAplicacion.PNG">

### 1. Al proyecto Maven, debe agregarle las dependencias mas recientes de ```javax.javaee-api```, ```com.sun.faces.jsf-api```, ```com.sun.faces.jsf-impl```, ```javax.servlet.jstl``` y Primefaces (en el archivo pom.xml).



### 2. Para que configure automáticamente el descriptor de despliegue de la aplicación (archivo web.xml), de manera que el framework JSF se active al inicio de la aplicación, en el archivo ```web.xml``` agregue la siguiente configuración:
```
<servlet>
   <servlet-name>Faces Servlet</servlet-name>
   <servlet-class>javax.faces.webapp.FacesServlet</servlet-class>
   <load-on-startup>1</load-on-startup>
</servlet>
<servlet-mapping>
   <servlet-name>Faces Servlet</servlet-name>
   <url-pattern>/faces/*</url-pattern>
</servlet-mapping>
<welcome-file-list>
   <welcome-file>faces/index.jsp</welcome-file>
</welcome-file-list>
```



### 3. Revise cada una de las configuraciones agregadas anteriormente para saber qué hacen y por qué se necesitan. Elimine las que no se necesiten.



### 4. Ahora, va a crear un Backing-Bean de sesión, el cual, para cada usuario, mantendrá de lado del servidor las siguientes propiedades:
  1. El conjunto de datos ingresados por el usuario.
  2. Los resultados de las operaciones.
  3. La cantidad de números ingresados por el usuario.
  
Para hacer esto, cree una clase que tenga:

* el constructor por defecto (sin parámetros)
* los métodos ```get/set``` necesarios dependiendo si las propiedades son de escritura o lectura
* coloque las anotaciones
  * ```@ManagedBean```, incluyendo el nombre: ```@ManagedBean(name = "calculadoraBean")```.
  * ```@ApplicationScoped```.
  
A la implementación de esta clase, agregue los siguientes métodos:

* ```calculateMean```: Debe recibir como parámetro el listado de valores y retornar el promedio de los números en ella.
* ```calculateStandardDeviation```: Debe recibir como parámetro el listado de valores y retornar el la desviación estandar de los números en ella.
* ```calculateVariance```: Debe recibir como parámetro el listado de valores y retornar la varianza de los números en ella.
* ```calculateMode```: Debe recibir como parámetro el listado de valores y retornar la moda de los números en ella.
* ```restart```: Debe volver a iniciar la aplicación (Borrar el campo de texto para que el usuario agregue los datos).



### 5. Cree una página XHTML, de nombre ```calculadora.xhtml``` (debe quedar en la ruta ```src/main/webapp```). Revise en la página 13 del manual de PrimeFaces, qué espacios de nombres XML requiere una página de PrimeFaces y cuál es la estructura básica de la misma.




### 6. Con base en lo anterior, agregue un formulario con identificador ```calculadora_form``` con el siguiente contenido básico:
```
<h:body>
 <h:form id="guess_form">

 </h:form>
</h:body>
```


### 7. Al formulario, agregue:
  a. Un elemento de tipo ```<p:outputLabel>``` para el resultado de la moda, sin embargo, este elemento se debe ocultar. Para ocultarlo, se puede agregar el estilo ```display: none;``` al elemento. Una forma de hacerlo es por medio de la propiedad ```style```.
    * En una aplicacion real, no se debería tener este elemento, solo se crea con el fin de simplificar una prueba futura.
    
  b. Un elemento ```<p:inputText>``` para que el usuario ingrese los números. (Tenga en cuenta que una opción para separar los números es con “;” aunque no necesariamente debe hacerlo así) 
  Por ejemplo:
  2; 3.5; 4.8; 5.1
  
  c. Un elemento de tipo ```<p:outputLabel>``` para mostrar cada una de las operaciones resultantes. Y asocie dichos elementos al BackingBean de sesión a través de su propiedad ```value```, y usando como referencia el nombre asignado: value="#{guessBean.nombrePropiedad}"
