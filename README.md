# Veterinaria web

Proyecto desarrollado con Spring Boot para hacer los servicios y renderizar los archivos HTML. Además se utiliza Javascript en el frontend para consumir los servicios rest del propio backend y hacer más dinámica la experiencia del usuario.

El proyecto integra carga de archivos para asignar una imagen a los registros, utilizando el servicio de [cloudinary](https://cloudinary.com/documentation) que permite fácilmente la carga y administración de activos en la nube.

Al registrarse en cloudinary obtendremos tres valores: cloud-name, api-key y api-secret. Esos valores se deben agregar en **application.properties** de la siguiente forma:

```properties
cloudinary.cloud-name=your cloud-name
cloudinary.api-key=your api key
cloudinary.api-secret=your api secret
```

## Configuración

Crear un archivo **application.properties** en la ruta **src/main/resources**

En esa carpeta existe un archivo de ejemplo con todos los valores que debe tener application.properties

```properties
spring.output.ansi.enabled=ALWAYS

spring.jpa.hibernate.ddl-auto=update
spring.datasource.url=
spring.datasource.username=
spring.datasource.password=
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
spring.jpa.show-sql: true

cloudinary.cloud-name=
cloudinary.api-key=
cloudinary.api-secret=

spring.servlet.multipart.max-file-size=10MB
spring.servlet.multipart.max-request-size=10MB
spring.main.allow-bean-definition-overriding=true
```
