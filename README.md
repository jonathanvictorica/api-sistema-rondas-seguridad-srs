# Sistema de Rondas de Seguridad (SRS) 

   Este repositorio contiene la parte backend del proyecto presentado como trabajo final para la carrera de Ingeniería en Sistemas de Información en la Facultad Regional Buenos Aires. El proyecto completo incluye también una interfaz Mobile y Web, pero aquí solo se presenta el código correspondiente al backend. ¡Descubre cómo se implementó la lógica detrás de la aplicación!

## Índice

- [Motivación](#-motivacin)
- [Documentación Funcional de la Solución](#-documentacin-funcional-de-la-solucin)
  - [Casos de Uso](#diagrama-de-casos-de-uso)
- [Documentación Técnica de la Solución](#-documentacin-tcnica-de-la-solucin)
  - [Diagrama de Arquitectura](#diagrama-de-arquitectura)
  - [Diagrama de Componentes](#diagrama-de-componentes)
  - [Modelo de Base de Datos](#-modelo-de-base-de-datos)
  - [Tecnologías](#-tecnologas)
  - [Endpoints](#-endpoints)
- [Ejecución](#-ejecucin)

## 🚀 Motivación

   El objetivo del proyecto fue desarrollar un Sistema de Rondas de Seguridad (SRS) que permita diseñar rondas de seguridad utilizando checkpoints con tecnología NFC. En primer lugar, se crean los checkpoints en un lugar abierto, los cuales son puntos de control por donde debe pasar la ronda de seguridad. Luego, a través de la interfaz web, se diseña la ronda de seguridad, la cual suele tener una planificación preestablecida para ejecutarse cierta cantidad de veces al día y a la semana.

El agente de seguridad, utilizando la aplicación web, recorre los checkpoints y lee el código NFC de cada punto de control. Una vez finalizada la ronda de seguridad, cierra la misma y registra en el sistema que se completó el recorrido correspondiente. 

## 🚀 Documentación Funcional de la Solución
### Diagrama de Casos de Uso
![Diagrama de Casos de Uso](https://github.com/jonathanvictorica/api-sistema-rondas-seguridad-srs/blob/develop/doc/CasosUso.png)

## 🚀 Documentación Técnica de la Solución
### Diagrama de Arquitectura
![Diagrama de Despligue](https://github.com/jonathanvictorica/api-sistema-rondas-seguridad-srs/blob/develop/doc/Arquitectura.png)


* Base de Datos Relacional: se usó como motor de base de datos Mysql
* Eventos: se usan para la planificación constante de las ejecuciones de las rondas. También para recibir y procesar de manera asincrónica
los llamados a los endpoints correspondientes para la ejecución de una ronda de seguridad. El caso de uso de esos endpoints, es que el agente de seguridad,
desde su app mobile, notifique ubicación en tiempo real, checkpoints que va marcando y cuando inicia y finaliza la ronda. 
Para los eventos se usó la cola de mensajes de Kafka

### Diagrama de Componentes
![Diagrama de Componentes](https://github.com/jonathanvictorica/api-sistema-rondas-seguridad-srs/blob/develop/doc/componentes.png)

<table>
<thead><tr><th>Componente</th><th>Descripción</th></tr></thead>
<tbody>
  <tr><td>Round</td><td>Administra las rondas de las sucursales, sus checkpoints y rutas</td></tr>
  <tr><td>Company Security</td><td>Administra las empresas de seguridad que contratan la solución</td></tr>
  <tr><td>Customer</td><td>Administra los clientes de las empresas de seguridad</td></tr>
  <tr><td>Round Execute</td><td>Administra las ejecuciones de las rondas configuradas</td></tr>
  <tr><td>Subsidiary</td><td>Administra las sucursales de los clientes</td></tr>
  <tr><td>Checkpoint</td><td>Administra los checkpoints que se configuran en cada sucursal con NFC</td></tr>
  <tr><td>User</td><td>Administra los usuarios del sistemas (no se maneja autenticación)</td></tr>
  <tr><td>Round Planning</td><td>Administra las planificaciones de las rondas en base a los parámetros cargados para ejecutarse en ciertos días y horarios</td></tr>
</tbody>
</table>

### Modelo de Base de datos
![DER](https://github.com/jonathanvictorica/api-sistema-rondas-seguridad-srs/blob/develop/doc/der.png)



###  Tecnologías

* JDK 17
* Spring Boot 2.7.5
* Maven
* Mysql
* Kafka
* RestAssured
* Spring JPA
* Spring Kafka
* Spring Security (JWT)
* Mapstruct
* Docker (BBDD Mysql y Kafka)

###  Endpoints

<table>
<thead><tr><th>Método</th><th>Path</th></tr></thead>
<tbody>
  <tr><td>POST    </td><td>/api/v1/srs/checkpoint </td></tr>
  <tr><td>PUT     </td><td>/api/v1/srs/checkpoint </td></tr>
  <tr><td>DELETE  </td><td>/api/v1/srs/checkpoint/{nfcCode} </td></tr>
  <tr><td>GET     </td><td>/api/v1/srs/checkpoint/findBySubsidiary/{subsidiaryId} </td></tr>
</tbody>
</table>


<table>
<thead><tr><th>Método</th><th>Path</th></tr></thead>
<tbody>
  <tr><td>POST    </td><td>/api/v1/srs/company-security</td></tr>
  <tr><td>PUT     </td><td>/api/v1/srs/company-security</td></tr>
  <tr><td>DELETE  </td><td>/api/v1/srs/company-security/{companySecurityId}</td></tr>
  <tr><td>GET     </td><td>/api/v1/srs/company-security/all</td></tr>
  <tr><td>GET     </td><td>/api/v1/srs/company-security/findById/{companySecurityId}</td></tr>
  <tr><td>GET     </td><td>/api/v1/srs/company-security/findByDocument/{type}/{value}</td></tr>
</tbody>
</table>

<table>
<thead><tr><th>Método</th><th>Path</th></tr></thead>
<tbody>
  <tr><td>POST   </td><td>  /api/v1/srs/customers</td></tr>
  <tr><td>PUT    </td><td>  /api/v1/srs/customers</td></tr>
  <tr><td>DELETE </td><td> /api/v1/srs/customers/{customerId}</td></tr>
  <tr><td>GET    </td><td> /api/v1/srs/customers/all</td></tr>
  <tr><td>GET    </td><td> /api/v1/srs/customers/findById/{customerId}</td></tr>
  <tr><td>GET    </td><td> /api/v1/srs/customers/findByDocument/{type}/{value}</td></tr>
</tbody>
</table>


<table>
<thead><tr><th>Método</th><th>Path</th></tr></thead>
<tbody>
  <tr><td>POST   </td><td>/api/v1/srs/round</td></tr>
  <tr><td>PUT    </td><td>/api/v1/srs/round</td></tr>
  <tr><td>DELETE </td><td>/api/v1/srs/round/{roundId}</td></tr>
  <tr><td>GET    </td><td>/api/v1/srs/round/findBySubsidiary/{subsidiaryId}</td></tr>
  <tr><td>GET    </td><td>/api/v1/srs/round/findByCustomer/{customerId}</td></tr>
  <tr><td>GET    </td><td>/api/v1/srs/round/findById/{roundId}</td></tr>
</tbody>
</table>


<table>
<thead><tr><th>Método</th><th>Path</th></tr></thead>
<tbody>
  <tr><td>POST</td><td> /api/v1/srs/round-execute/startRound</td></tr>
  <tr><td>POST</td><td> /api/v1/srs/round-execute/markCheckpoint</td></tr>
  <tr><td>POST</td><td> /api/v1/srs/round-execute/finishRound</td></tr>
  <tr><td>POST</td><td> /api/v1/srs/round-execute/notifyLocationAgentOnline</td></tr>
  <tr><td>GET </td><td>/api/v1/srs/round-execute/findOnlineById/{roundExecuteId}</td></tr>
  <tr><td>GET </td><td>/api/v1/srs/round-execute/findRoundPendingBySubsidiary/{subsidiaryId}</td></tr>
  <tr><td>GET </td><td>/api/v1/srs/round-execute/findByStateRevision</td></tr>
</tbody>
</table>


<table>
<thead><tr><th>Método</th><th>Path</th></tr></thead>
<tbody>
  <tr><td>POST  </td><td> /api/v1/srs/round-planning</td></tr>
  <tr><td>PUT   </td><td> /api/v1/srs/round-planning</td></tr>
  <tr><td>DELETE</td><td> /api/v1/srs/round-planning/{roundPlanningId}</td></tr>
  <tr><td>GET   </td><td> /api/v1/srs/round-planning/findById/{roundPlanningId}</td></tr>
  <tr><td>GET   </td><td> /api/v1/srs/round-planning/findByRoundId/{roundId}</td></tr>
</tbody>
</table>


<table>
<thead><tr><th>Método</th><th>Path</th></tr></thead>
<tbody>
  <tr><td>POST   </td><td>/api/v1/srs/subsidiaries</td></tr>
  <tr><td>PUT    </td><td>/api/v1/srs/subsidiaries</td></tr>
  <tr><td>DELETE </td><td>/api/v1/srs/subsidiaries/{subsidiaryId}</td></tr>
  <tr><td>GET    </td><td>/api/v1/srs/subsidiaries/findByCustomer/{customerId}</td></tr>
  <tr><td>GET    </td><td>/api/v1/srs/subsidiaries/findById/{subsidiaryId}</td></tr>
</tbody>
</table>


<table>
<thead><tr><th>Método</th><th>Path</th></tr></thead>
<tbody>
  <tr><td>POST   </td><td>/api/v1/srs/users</td></tr>
  <tr><td>PUT    </td><td>/api/v1/srs/users</td></tr>
  <tr><td>DELETE </td><td>/api/v1/srs/users/{userId}</td></tr>
  <tr><td>GET    </td><td>/api/v1/srs/users/findByRol/{rol}</td></tr>
  <tr><td>GET    </td><td>/api/v1/srs/users/findById/{userId}</td></tr>
  <tr><td>GET    </td><td>/api/v1/srs/users/findByDocument/{type}/{value}</td></tr>
  <tr><td>GET    </td><td>/api/v1/srs/users/roles</td></tr>
</tbody>
</table>



## 🚀 Ejecución

* Si es la primera vez que va a ejecutar el proyecto en su máquina, ejecutar el archivo execute-1-instalacion.sh
* Para inicializar el entorno de datos ejecutar execute-2-configuracion.sh
* Por último, debe ejecutar execute-3-execute.sh




