# Smart Parking

Proyecto 1er año - Equipo 5Ctrl

## Manual de uso y ejecución
### Se asumió la siguiente lógica para desarrollar la aplicación



## Ambiente y pre condiciones de ambiente

Éstas son las características del ambiente donde se desarrolló la aplicación, para correcto uso de la app se asume que los siguientes requerimietos son mandatorios:

* Java version 1.8
* Maven 3.3.9
* Chrome

Ejecute los siguientes comandos para corroborar su sistema: (opcional)

```sh-session
mvn -version
```
```sh-session
java -version
```

* Se asume que tiene maven instalado y configurado para manejar desde un terminal.
* Se asume que tiene java instalado y configurado para manejar desde un terminal.
* Esta guía esta basada en el uso de un terminal basado en MAC OS/ Windows.


## Iniciar la aplicacion smart-bici
En primer lugar se debe buildear la app y bajar las librerias que correspondan para eso se deben ejecutar los siguientes comandos:

```sh-session
mvn clean install
```
```sh-session
mvn clean package
```

Abra una terminal y ubíquese dentro de la carpeta del proyecto
Ejecute el siguiente comando
```sh-session
mvn spring-boot:run
```
Se debe de abrir browser ingresando la siguiente URL: `http://localhost:8080/smartParking/`

### Persistencia
 Smart-bici esta apuntando a la base productiva alojada en Heroku por ende no es necesario configurar la persistencia localmente
 


### Terminal
Puede seguir el log trace de la aplicación en el terminal donde ejecutó `mvn spring-boot:run`.
```sh-session
2019-03-23 00:39:10.486  INFO 13272 --- [           main] o.a.c.c.C.[.[localhost].[/smartParking]  : Initializing Spring embedded WebApplicationContext
2019-03-23 00:39:10.487  INFO 13272 --- [           main] o.s.web.context.ContextLoader            : Root WebApplicationContext: initialization completed in 5868 ms
2019-03-23 00:39:11.518  INFO 13272 --- [           main] o.s.s.concurrent.ThreadPoolTaskExecutor  : Initializing ExecutorService 'applicationTaskExecutor'
2019-03-23 00:39:12.200  INFO 13272 --- [           main] o.s.b.a.w.s.WelcomePageHandlerMapping    : Adding welcome page template: index
2019-03-23 00:39:13.402  INFO 13272 --- [           main] o.s.b.w.embedded.tomcat.TomcatWebServer  : Tomcat started on port(s): 8080 (http) with context path '/smartParking'
2019-03-23 00:39:13.409  INFO 13272 --- [           main] c.p.smartBici.SmartBiciApplication       : Started SmartBiciApplication in 11.204 seconds (JVM running for 26.431)
2019-03-23 00:39:40.662  INFO 13272 --- [nio-8080-exec-2] o.a.c.c.C.[.[localhost].[/smartParking]  : Initializing Spring DispatcherServlet 'dispatcherServlet'
2019-03-23 00:39:40.663  INFO 13272 --- [nio-8080-exec-2] o.s.web.servlet.DispatcherServlet        : Initializing Servlet 'dispatcherServlet'
2019-03-23 00:39:40.834  INFO 13272 --- [nio-8080-exec-2] o.s.web.servlet.DispatcherServlet        : Completed initialization in 171 ms
```

Gracias 
