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
mvn springBoot:run
```


### Persistencia
 Smart-bici esta apuntando a la base productiva alojada en Heroku por ende no es necesario configurar la persistencia localmente
 


### Terminal
Puede seguir el log trace de la aplicación en el terminal donde ejecutó `mvn springBoont:run`.

```sh-session

```

Gracias 
