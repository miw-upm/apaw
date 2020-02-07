## [Máster en Ingeniería Web por la Universidad Politécnica de Madrid (miw-upm)](http://miw.etsisi.upm.es)
## Arquitectura y Patrones para Aplicaciones Web
> Este proyecto es un apoyo docente de la asignatura

### Estado del código

[![Build Status](https://travis-ci.org/miw-upm/apaw.svg?branch=develop)](https://travis-ci.org/miw-upm/apaw)
[![Quality Gate](https://sonarcloud.io/api/project_badges/measure?project=es.upm.miw%3Aapaw&metric=alert_status)](https://sonarcloud.io/dashboard?id=es.upm.miw%3Aapaw)
[![BCH compliance](https://bettercodehub.com/edge/badge/miw-upm/apaw?branch=develop)](https://bettercodehub.com/)

### Tecnologías necesarias
* Java
* Maven
* Spring
* GitHub
* Travis-ci
* Sonarcloud
* Bettercodehub
* Heroku

### :gear: Instalación del proyecto
1. Clonar en repositorio en tu equipo mediante consola:
  1. Situarse en una carpeta raíz donde se encuentran los proyectos, mediante la consola:  
     **>cd %ruta-de-la-carpeta%**
  1. Clonar el repositorio, se visualizará el contenido de la rama por defecto:  
     **>git clone https://github.com/miw-upm/apaw**

2. Importar el proyecto mediante IntelliJ IDEA
  1. **Import Project**, y seleccionar la carpeta del proyecto
  1. Marcar **Create Project from external model**, elegir **Maven**
  1. **Next** … **Finish**

### :book: Diapositivas (/docs)
* [Diapositivas de Patrones](docs/miw-apaw-diapositivas-pd.pdf)   
* [Diapositivas de Arquitectura](docs/miw-apaw-diapositivas-architecture.pdf)
* [Diapositivas de la práctica Themes](docs/miw-apaw-diapositivas-ep-themes.pdf) 

### :movie_camera: Videos (www.youtube.com/miw-upm)
* Lista de reproducción: **APAW (Curso 2019-20). Arquitectura y Patrones para Aplicaciones Web**

### :dvd: Material de apoyo de la práctica
*  [Plantilla de la práctica en: _docs/apaw-ep-template.zip_](docs/apaw-ep-template.zip).
*  [Proyecto de ejemplo: _https://github.com/miw-upm/apaw-ep-themes_](https://github.com/miw-upm/apaw-ep-themes)

### :page_with_curl: Enunciado de la práctica
* Nombre del proyecto: :point_up:**apaw-ep-_nombre-apellido_**, :couple: **apaw-ep-_n-apellido-n-apellido_**, :family: **apaw-ep-_n-apellido-n-apellido-n-apellido_**
* Todo el software deberá estar en ingles.
* **Modelo del dominio**. Práctica: `APAW. EP. Diagrama de Clases & API (0%)(OBLIGATORIO)`, junto con su `retroalimentación`.
   * End-points: al menos un GET, POST, PUT, PATCH, DELETE & /search?q=
   * :point_up: 5 documentos.
      * Cada documento: >=2 atributos + [id:String].
      * Total >= 15 atributos, con al menos LocalDateTime, Boolean, Integer.
      * Relaciones: 1 sin relación, 1..n, n..1, 1..1 o n..n.
      * 8 end-points.
      * 2 Releases.
      * Patrones: Builder, Composite & Observer.
   * :couple: 6 documentos.
      * Cada documento: >=3 atributos + [id:String].
      * Total >= 23 atributos, con al menos LocalDateTime, Boolean, Integer, Double.
      * Relaciones: 1 sin relación, 1..n, n..1 & n..n.
      * 14 end-points (2x7).
      * 2 Releases (2x1).
      * Patrones: Builder, Composite & 2X-Observer (a repartir).
   * :family: 7 documentos.
      * Cada documento: >=3 atributos + [id:String].
      * Total >= 28 atributos, con al menos LocalDateTime, Boolean, Integer, Double.
      * Relaciones: 1 sin relación, 1..n, n..1 & n..n.
      * 18 end-points (3x6).
      * 3 Releases (3x1).
      * Patrones: Singleton, Builder, Composite & 3X-Observer (a repartir).
* Crear el proyecto local y remoto a partir de la plantilla dada, con el ecosistema completo (Travis-CI, Sonarcloud, Better Code Hub & Heroku, con badges con links).
* Preparar un proyecto de gestión (tipo **Scrum**) en GitHub, con los end-points, las liberaciones y los patrones.
* Se deben implementar un **API con los end-points** dada en la retroalimentación,
cada **end-point** asociado a un **issue#** diferente, cada miembro del equipo lo hace de forma secuencial.
Se debe aplicar la arquitectura dada en la retroalimentación (**layers** VS **resources**).
   * :point_up: & :couple: **Issue#**. **1ª liberación (v1.0.0-release)**, una vez cerrado los **end-points**.
   * :family: **Issue#**. **1ª liberación** & **2ª liberación**, a mitad y al final de los **end-points**.
* Aplicar patrones, a repartir entre el equipo y un **issue#** por patrón.
* **Issue#**. **última liberación (v1.x.0-release)**, una vez cerrado los patrones.
* Además, se podrán utilizar las issues adicionales que se consideren convenientes.

### :clap: Entraga de la práctica
Indicar como texto en la subida la **URL de GitHub**
> **NOTA. Acordarse de dar al botón de envío**

### :ballot_box_with_check: Criterios de evaluación (ver rúbrica)
* Completud y corrección de lo entregado respecto al enunciado.
* Adecuación de la temporalidad de desarrollo según el enunciado.
* Mantenimiento de calidad del código (Travis-CI, Sonar, Better Code Hub,...).
* Uso correcto del flujo de trabajo ramificado (Git Workflow).
* Commits correctos y completos.
* Gestión adecuada y completa (Scrum, uso de issues, estimación, tiempo real...) durante el desarrollo.
* Planificación temporal adecuada y equilibrada en el desarrollo.
* Calidad del código. Todos los aspectos vistos en teoría, y poniendo espeacial enfásis en:
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
      * Métodos: <3-5 parámetros, <15 líneas.
      * Cobertura de test: >80%.
   * Eliminar redundancias (copy & paste).
   * Eliminar código muerto.
   * Tratamiento de errores. 
   * Calidad de la arquitectura (GRASP, SOLID, **patrones**...).
