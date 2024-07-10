
![img.png](src/main/img/logoAlura.png)

# JAVA SDK 17 + Intellij IDEA
## Challenge Literatura G6 One Version 2
### Profesores: Bruno Fernández / Genesys Rondon / Eric Fraga

<hr>

![Static Badge](https://img.shields.io/badge/Lenguaje-Java%2017-blue)  ![Static Badge](https://img.shields.io/badge/Versi%C3%B3n-Beta-Yellow)  <label><img src="https://img.shields.io/badge/Estatus-En%20Desarrollo-green"></label>
<hr>
    <img src="src/main/img/logoJava.png" alt="Logo Java" width="150px">
<hr>


### Características del Reto que se personalizarán en esta versión

| Item | Descripción                                     | Observación |
|------|-------------------------------------------------|-------------|
| 1.   | Se respetará el mismo menu del trello           |             |
| 2.   | La API a usar será la recomendada en el trello. |             |
|      | http://gutendex.com/                            |             |

### Tecnologías Utilizadas

| Item | Descripción | Razón                                       |
|------|-------------|---------------------------------------------|
| 1    | Java SDK 17 | nucleo de la aplicacion                     |
| 2    | Spring Boot | framework para facilitar desarrollo         |
| 3    | Data JPA    | para facilitar el desarrollo usando bd      |
| 4    | PostgreSQL  | Base de datos a usar                        |
| 5    | Insomia     | Para validar el uso de la API               |
| 6    | GSON        | Dependencia para manejo de los Json         |
| 7    | Jackson     | Dependencia para manejo de json, 2da opción |


### Clases

| Item         | Descripción            | Observación | Tipo |
|--------------|------------------------|-------------|------|
| Modelos      |                        |             |      |
| 1            | Autor                  |             |      |
| 2            | Datos                  |             |      |
| 3            | DatosAutor             |             |      |
| 4            | DatosLibro             |             |      |
| 5            | Idioma                 |             |      |
| 6            | Libro                  |             |      |
|              |                        |             |      |
| Principal    |                        |             |      |
| 1            | Opciones               |             |      |
| 2            | Principal              |             |      |
|              |                        |             |      |
| Repositorio  |                        |             |      |
| 1            | AutorRepository        |             |      |
|              |                        |             |      |
| Servicio     |                        |             |      |
| 1            | ConsumoAPI             |             |      |
| 2            | ConvierteDatos         |             |      |
| 3            | IConvierteDatos        |             |      |
|              |                        |             |      |
| Main         |                        |             |      |
| 1            | ChallengeLiteratura    |             |      |
|              |                        |             |      |
| Recursos     |                        |             |      |
| 1            | application.properties |             |      |
|              |                        |             |      |
| Dependencias |                        |             |      |
| 1            | pom.xml                |             |      |

### Menú Principal

![img.png](src/main/img/menuPrincipal.png)

### Menú 1 Buscar Libro por titulo

![img.png](src/main/img/buscarLibroTitulo.png)

#### Menu 1 Cuando no se encuentre el titulo, validación

![img.png](src/main/img/cuandoNoSeEncuentreTitulo.png)

### Menú 2 Listar libros registrados en la BD

![img.png](src/main/img/listarLibrosEnBD.png)

### Menú 3 Listar autores registrados en la BD

![img.png](src/main/img/listadoAutoresBD.png)

### Menú 4 Listar autores vivos en determinado año en la BD

![img.png](src/main/img/listadoAutoresVivos.png)

#### Menu 4 se valida que sea un numero 1-5000, no acepta letras

![img.png](src/main/img/validacionMenu4.png)

### Menú 5 Listar libros por idioma de la BD

![img.png](src/main/img/listarLibrosIdioma.png)

#### Menu 5 Listar libros, validacion cuando seleccionan otro número o letra

![img.png](menu5Validacion.png)

### Menú 8 Salir

![img.png](src/main/img/despedida.png)


### Dependencias Gson:

    <dependency>
			<groupId>com.google.code.gson</groupId>
			<artifactId>gson</artifactId>
			<version>2.11.0</version>
    </dependency>

### Diagrama Entidad Relación en Postgresql

![img.png](src/main/img/diagramaEntidadRelacion.png)

### Mejoras y bugs pendientes por corregir

| Item | Tipo   | Descripción                                                                     | Propuesta                                            |
|------|--------|---------------------------------------------------------------------------------|------------------------------------------------------|
| 1    | Mejora | Mostrar el idioma completo                                                      | En vez de EN mostrar Ingles usando los alias en ENUM |
|      |        |                                                                                 |                                                      |
| 2    | Bug    | Cuando un idioma o dato sea null                                                | Crear control para excepciones de este tipo          |
|      |        |                                                                                 |                                                      |
| 3    | Bug    | Cuando el nombre del libro es mayor a 255 carateres da error                    | Revisar los tipos de datos y actualizar              |
|      |        |                                                                                 |                                                      |
| 4    | Mejora | Cuando un dato sea null cambiar por "Sin Informacion"                           | Agregar logica u código                              |
|      |        |                                                                                 |                                                      |
| 5    | Mejora | Revisar Ortografia de todo el proyecto                                          |                                                      |
|      |        |                                                                                 |                                                      |
| 6    | Bug    | Agregar todos los Eumns de idiomas, al no extistir da error                     | agregar excepcion cuando no exista el enum           |
|      |        |                                                                                 |                                                      |
| 7    | Mejora | Colocar en los listado un numero consecutivo, al final decir el total           |                                                      |
|      |        |                                                                                 |                                                      |
| 8    | Mejora | Arreglar las tablas de las listas, con formato                                  |                                                      |
|      |        |                                                                                 |                                                      |
| 9    | Mejora | Al buscar un libro agregar la lista completa de los titulos conseguidos a la BD |                                                      |
