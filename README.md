## [Máster en Ingeniería Web por la Universidad Politécnica de Madrid (miw-upm)](http://miw.etsisi.upm.es)
## Arquitectura y Patrones para Aplicaciones Web
> Este proyecto es un apoyo docente de la asignatura

### Estado del código

[![Build Status](https://travis-ci.org/miw-upm/apaw.svg?branch=develop)](https://travis-ci.org/miw-upm/apaw)
[![Quality Gate](https://sonarcloud.io/api/project_badges/measure?project=es.upm.miw%3Aapaw&metric=alert_status)](https://sonarcloud.io/dashboard?id=es.upm.miw%3Aapaw)

### Tecnologías necesarias
* Java
* Maven
* Spring
* GitHub
* Travis-ci
* Sonarcloud
* Bettercodehub
* Heroku

### Clonar en repositorio en tu equipo mediante consola:
1. Situarse en una carpeta raíz donde se encuentran los proyectos, mediante la consola:  
 **>cd %ruta-de-la-carpeta%**
1. Clonar el repositorio, se visualizará el contenido de la rama por defecto:  
 **>git clone https://github.com/miw-upm/apaw**

### Importar el proyecto mediante IntelliJ IDEA
1. **Import Project**, y seleccionar la carpeta del proyecto
1. Marcar **Create Project from external model**, elegir **Maven**
1. **Next** … **Finish**

### :book: Diapositivas (/docs)
* [Diapositivas de Patrones](docs/miw-apaw-diapositivas-pd.pdf)   
* [Diapositivas de Patrones Web](docs/miw-apaw-diapositivas-web.pdf)
* [Diapositivas de practica_themes](docs/miw-apaw-diapositivas-ep-themes.pdf)

### :movie_camera: Videos (www.youtube.com/miw-upm)
* [Videos](https://www.youtube.com/playlist?list=PLj2IVmcP-_QNaYYCV7kWMpEBvoXu0JPt-)

### :page_with_curl: Enunciado de la práctica
* Nombre del proyecto: **apaw-ep-_nombre-apellido_**.
* Detalles del enunciado en la entrega: `APAW. EP. Diagrama de Clases & API (0%)(OBLIGATORIO)`, junto con su `retroalimentación`.
   * **Crear el proyecto local y remoto**. **Issue#**. Preparar un proyecto de gestión (tipo **Scrum**) en GitHub.
   * **Issue#**. Crear el ecosistema completo y las 8 end-points en el proyecto de gestión. **Hito: viernes, 4 de octubre, 16:00**.
   * **8 x Issues#**. Se deben implementar un **API con 8 end-points**, cada **end-point** asociado a un **issue#** diferente. Deberá tener un GET, PUT, PATCH, DELETE, POST con relación 0..1, POST con relación 0..n y una búsqueda (query). Se debe aplicar la arquitectura dada en la retroalimentación (**layers** VS **resources**).
      * **Issue#**. **1ª liberación (v1.0.0-release)**, una vez cerrado el **4º end-point**.
      * **Issue#**. **2ª liberación (v1.1.0-release)**, una vez cerrado el **8º end-point**.
   * **Issue#**. Aplicar el patrón **Builder**.
   * **Issue#**. Aplicar el patrón **Composite**.
   * **Issue#**. Aplicar el patrón **Observer**.
   * **Issue#**. **3ª liberación (v1.2.0-release)**, una vez cerrado los patrones.
   * Además, se podrán utilizar las issues adicionales que se consideren convenientes.

### :dvd: Material de apoyo de la práctica
*  [Plantilla de la práctica en: _docs/apaw-ep-template.zip_](docs/apaw-ep-template.zip).
*  [Proyecto de ejemplo: _https://github.com/miw-upm/apaw-ep-themes_](https://github.com/miw-upm/apaw-ep-themes)

### :clap: Entraga de la práctica
Indicar como texto en la subida de la práctica las siguientes URLs:
* URL de GitHub.
* URL de Travis-CI.
* URL de Sonarcloud.
* URL de Better Code Hub.
* URL del despliegue en Heroku.
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
