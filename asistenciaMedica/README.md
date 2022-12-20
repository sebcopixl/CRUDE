# Aplicación de Atención Médica
## Seminario - Programación Web - UCOM 2022
### Saúl Zalimben

## Descripción
Usando Spring Boot y Spring MVC, diseñe e implemente una aplicación de atención médica
para rastrear registros de pacientes. La aplicación debe poder guardar nuevos pacientes y sus
signos vitales, también para tener registros históricos es necesario tener registros diarios de los
signos vitales del paciente, por lo que el usuario debe poder agregar nuevos registros a un paciente
existente.

### Implementar las siguientes historias de usuario
#### Historia de Usuario 1
Como enfermera, me gustaría poder almacenar la información básica de un nuevo paciente.
#### Criterios de aceptación:
- Debe poder guardar un nuevo paciente agregando un nombre, fecha de nacimiento y signos
vitales (presión arterial y frecuencia cardíaca).
- La aplicación deberá asignar un código al nuevo paciente.
- Debería poder ver toda la información que guardé.

#### Historia de Usuario 2
Como enfermera, me gustaría poder agregar información sobre los signos vitales de cualquier
paciente en la aplicación, para poder tener un registro histórico de lo que hago cada día.
#### Criterios de aceptación:
- Debe poder ver a todos los pacientes.
- Debe ser capaz de encontrar a un paciente por su nombre o su código.
- Debe poder ver todos los signos vitales del paciente.
- Debe poder agregar signos vitales (presión arterial y frecuencia cardíaca) al paciente que
encontré en una búsqueda anterior.
#### Historia de Usuario 3
Como enfermera, me gustaría poder editar información de un paciente.
Criterios de aceptación:
Debe poder ver a todos los pacientes.
Debe ser capaz de encontrar y seleccionar un paciente por su nombre o su código.
Debe poder editar el nombre y la fecha de nacimiento del paciente que encontré en una
búsqueda anterior.
Debe poder editar los signos vitales del paciente que encontré en una búsqueda anterior.
1
#### Historia de Usuario 4
Como enfermera, me gustaría poder eliminar información de un paciente.
#### Criterios de aceptación:
- Debe poder ver a todos los pacientes.
- Debe ser capaz de encontrar y seleccionar un paciente por su nombre o su código.
- Debe ser capaz de eliminar un registro de los signos vitales del paciente que encontré en una búsqueda anterior.
- Debe ser capaz de remover a un paciente y todos sus signos vitales.

### Herramientas y Tecnologías
- Control de Versiones: Git
- Lenguaje de Programación Java
- Framework Sprint Boot y Spring MVC (Spring Initializr)
- Base de datos: PostgreSQL (u otro)
- Apache Maven: Herramienta de comprensión y gestión de proyectos de software
- Servidor de Aplicaciones: Spring Aplication
### Orientaciones
- La interfaz gráfica y los servicios del lado del servidor deben dise ̃narse e implementarse.
- Toda la información debe mantenerse en una base de datos, puede usar H2 Database Engine, Postgresql o cualquiera de sus preferencias.
- Se deben incluir los pasos para implementar el proyecto (lista de acciones, scripts o cualquier requisito especial)