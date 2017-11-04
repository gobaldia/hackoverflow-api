# hackoverflow

## Requerimientos 
Para correr la API es necesario tener un PostgreSQL corriendo con la BD
que usa el backend. Para ver el nombre de la BD, user y pwd ver las properties del proyecto.
Por ahora son:

- BD_NAME: hackoverflow
- BD_USER: postgres
- BD_PASS: postgres

## Ejecución
mvn spring-boot:run

El proyecto levanta una API Rest y a su vez carga unos datos de prueba. Tener en cuenta que esta
configurado para que cada vez que se le de Run se re-crea la BD. Para cambiar esto tocar la propiedad

spring.jpa.hibernate.ddl-auto=create

cambiar por

spring.jpa.hibernate.ddl-auto=update