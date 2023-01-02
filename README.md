# api-sistema-rondas-seguridad-srs
Proyecto Final de la Carrera Ingeniería en Sistemas de Información UTN FRBA

## Índice

* [Motivación](#-motivacin)
* [Arquitectura](#-arquitectura)
* [Modelo de Base de Datos](#-modelo-de-base-de-datos)
* [Tecnologías](#-tecnologas)
* [Endpoints](#-endpoints)
* [Ejecución](#-ejecucin)

## 🚀 Motivación

   Esta API backend corresponde al proyecto presentado como trabajo final para la carrera de Ingeniería en Sistemas de Información - Facultad Regional Buenos Aires.
El proyecto completo tiene una interfaz Mobile y Web, pero en este repositorio solo se presenta la parte backend. El proyecto tuvo como objetivo
la creación de un Sistema de Rondas de Seguridad (SRS) en el que se diseñan rondas de seguridad con ayuda de checkpoint con tecnología NFC.
Primero se crean los checkpoint en un lugar abierto, que son puntos de control por donde debe pasar la ronda de seguridad, y luego se crea a través de la web, dicha ronda.
Las rondas de seguridad por lo general, tienen una planificación ya estipulada, para ejecutarse X cantidad de veces por día y también por semana. 
A través de la aplicación web, el agente de seguridad, va a hacer el recorrido pasando por todos los checkpoint y leyendo el código NFC de cada punto de control. 
Una vez finalizada la ronda de seguridad, cierra la misma, dejando asentado en el sistema que se hizo el recorrido correspondiente. 

## 🚀 Arquitectura
![Diagrama de Componentes](https://github.com/jonathanvictorica/api-sistema-rondas-seguridad-srs/blob/develop/doc/Arquitectura.png)

En la solución del lado del backend se plantean los siguientes puntos:
* Base de Datos Relacional: se usó como motor de base de datos Mysql
* Eventos: se usó eventos para la planificación constante de las ejecuciones de las rondas. También para recibir y procesar de manera asincrónica
los llamados a los endpoints correspondientes para la ejecución de una ronda de seguridad. El caso de uso de esos endpoints, es que el agente de seguridad,
desde su app mobile, notifique ubicación en tiempo real, checkpoints que va marcando y cuando inicia y finaliza la ronda. 
Para los eventos se usó la cola de mensajes de Kafka

## 🚀 Modelo de Base de datos
![DER](https://github.com/jonathanvictorica/api-sistema-rondas-seguridad-srs/blob/develop/doc/der.png)

Parebens

## 🚀 Tecnologías

* JDK 17
* Spring Boot 2.7.5
* Maven
* Mysql
* Kafka
* RestAssured
* Spring JPA
* Spring Kafka
* Mapstruct
* Docker (BBDD Mysql y Kafka)

## 🚀 Endpoints

Endpoins

## 🚀 Ejecución

* Si es la primera vez que va ejecutar el proyecto en su máquina, ejecutar el archivo execute-1-instalacion.sh
* Para inicializar el entorno de datos ejecutar execute-2-configuracion.sh
* Por último, debe ejecutar execute-3-execute.sh




