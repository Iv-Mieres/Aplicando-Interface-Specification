# Aplicando-Interface-Specification

Este es un simple proyecto en el cual eh aplicado filtros de busqueda en base de datos con la interfaz Specification y Criteria API de JPA/Hibernate.

### Metodo findAllPersonas(Specification, Pageable)

* Con la interfaz Specification se crean filtros de busqueda con los atributos propios de la clase Persona (filtrar por nombre, apellido, etc) y además se realizan busquedas a travez de los atributos de la clase relacionada Provincia (filtrar por nombre de provincia, localidad, etc) 
* Con la interfaz Pageable se crea una paginación de la lista de personas obtenida, pudiendo controlar la cantidad de datos que se muestra al cliente.
