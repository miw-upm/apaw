## [Máster en Ingeniería Web por la Universidad Politécnica de Madrid (miw-upm)](http://miw.etsisi.upm.es)
## Arquitectura y Patrones para Aplicaciones Web
> Este proyecto es un apoyo docente de la asignatura. Cada release liberada corresponde al código utilizado en clase del curso indicado

### Estado del código
[![DevOps](https://github.com/miw-upm/apaw/actions/workflows/test-sonar.yml/badge.svg)](https://github.com/miw-upm/apaw/actions/workflows/test-sonar.yml)
[![Quality Gate](https://sonarcloud.io/api/project_badges/measure?project=es.upm.miw%3Aapaw&metric=alert_status)](https://sonarcloud.io/dashboard?id=es.upm.miw%3Aapaw)
[![BCH compliance](https://bettercodehub.com/edge/badge/miw-upm/apaw?branch=develop)](https://bettercodehub.com/)

### Tecnologías necesarias
`Java` `Maven` `GitHub` `Travis-ci` `Sonarcloud` `Better Code Hub` `Slack` `Spring-boot` `Heroku` `OpenAPI`

### :gear: Instalación del proyecto
1. Clonar el repositorio en tu equipo, **mediante consola**:
```sh
> cd <folder path>
> git clone https://github.com/miw-upm/apaw
```
2. Importar el proyecto mediante **IntelliJ IDEA**
   1. **Import Project**, y seleccionar la carpeta del proyecto.
   1. Marcar **Create Project from external model**, elegir **Maven**.
   1. **Next** … **Finish**.


### :book: Diapositivas (/docs)
* [Diapositivas en docs/miw-apaw-slides.pdf](docs/miw-apaw-slides.pdf)   

### :movie_camera: Videos (www.youtube.com/miw-upm)

* Lista de reproducción: **APAW. Arquitectura y Patrones para Aplicaciones Web**

### :page_with_curl: Enunciado de la práctica
> La practica consiste en ampliar de forma colaborativa una aplicación: https://github.com/miw-upm/apaw-practice.  
> **NOTA. Todo el software deberá estar en ingles.**

#### 1. Clonar el proyecto y crear una etiqueta en GitHub con el nombre de la ampliación
Por ejemplo: `story:sport`, `story:team`... no puede haber repetidas. En todos los issues# creados, se deberá asociar dicha etiqueta,
además de la etiquite de estimación (puntos).

#### 2. Diseñar el Modelo de Entidades (1 pto) 
Crear un **:one: issue#** (por ejemplo: **Team entities model**) para resolverlo 
y una vez finalizado e incorporado a **develop** y añadido el tiempo consumido, 
se debe avisar al profesor mediante **Slack**,
si es correcto el **profesor cerrará** la tarea y se podrá continuar, sino, se resolverá mediante el foro del issue en GitHub.

* Crear 4 documentos. No puede haber 2 documentos con el mismo nombre en toda la aplicación.
   * Cada documento: >=2 atributos + [id:String].
   * Total >= 16 atributos, con al menos LocalDateTime, Boolean y uno numérico (Integer, Double, Long o BigDecimal).
   * Los atributos para manejo de dinero deben ser BigDecimal.
   * Relaciones necesarias: 1..n, n..1 y n..n.
* Crear los DAOs (Repositorios).
* Crear una clase para poblar las BD: **Seeder&lt;_Story_>Service** e integrarlo con **DatabaseSeederService**.

#### 3. Crear 5 end-points (mediante :two:..:six: issue#): **GET, POST, PUT, PATCH Y DELETE** repartidos entre los documentos (PATCH: 1 pto, resto: 0,75 ptos)

#### 4. Una vez finalizado los cinco issues anteriores, se debe avisar al profesor por **Slack**, y el profesor añadirá (5 ptos):
* :seven:..:eight: issues# para realizar end-points de búsquedas.
* :nine:..:keycap_ten: issues# con la aplicación de dos patrones.

### :white_check_mark: Criterios de evaluación
* Uso correcto del flujo de trabajo ramificado. **Hasta -3 ptos**. 
* Adecuación de la temporalidad de desarrollo según el enunciado. **Hasta -3 ptos**. 
* Mantenimiento de calidad del código según Travis-CI y Sonar. Cobertura >= 80%. **Hasta -3 ptos**. Todos los aspectos vistos en teoría, y poniendo espeacial enfásis en:
   * Formatear.
      * Herramienta del IDE.
      * Líneas en blanco.
      * Ordenar métodos.
      * Repasar nombres de clases, métodos, atributos, parámetros y variables.
   * Sencillez del código.
      * Simplificar el código.
      * Eliminar comentarios.
      * Estructuras anidadas: <3.
      * Complejidad ciclomática: <8-12.
   * Métricas.
      * Paquete: <20 clases.
      * Clases: <500-200 líneas, <20 métodos.
      * Métodos: <3-4 parámetros, <15 líneas.
   * Eliminar redundancias (copy & paste).
   * Eliminar código muerto.
   * Tratamiento de errores. 
   * Calidad de la arquitectura (GRASP, SOLID, **patrones**...).
* Gestión adecuada, completa y equilibrada (estimación, tiempo real...) durante el desarrollo. **Hasta -3 ptos**. 
* Uso del ingles. **Hasta -1 pto**.

### :clap: Entraga de la práctica
Indicar como texto en la subida en nombre de la historía y la cuenta de GitHub.
> **NOTA. Acordarse de dar al botón de envío.**