## [Máster en Ingeniería Web por la Universidad Politécnica de Madrid (miw-upm)](http://miw.etsisi.upm.es)

## Arquitectura y Patrones para Aplicaciones Web

> Este proyecto es un apoyo docente de la asignatura. Cada release liberada corresponde al código utilizado en clase del
> curso indicado

### Estado del código

[![DevOps](https://github.com/miw-upm/apaw/actions/workflows/continuous-integration.yml/badge.svg)](https://github.com/miw-upm/apaw/actions/workflows/continuous-integration.yml)
[![Quality Gate](https://sonarcloud.io/api/project_badges/measure?project=es.upm.miw%3Aapaw&metric=alert_status)](https://sonarcloud.io/dashboard?id=es.upm.miw%3Aapaw)

### Tecnologías necesarias

`Java` `Maven` `GitHub` `GitHub Actions CI` `Sonarcloud` `Better Code Hub` `Slack` `Spring-boot` `Heroku` `OpenAPI`

### :gear: Instalación del proyecto

1. Clonar el repositorio en tu equipo, **mediante consola**:

```sh
> cd <folder path>
> git clone https://github.com/miw-upm/apaw
```

2. Importar el proyecto mediante **IntelliJ IDEA**
    1. **Open Project**, y seleccionar la carpeta del proyecto.
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

Por ejemplo: `story:sport`, `story:team`... no puede haber repetidas. En todos los issues# creados, se deberá asociar
dicha etiqueta, además de la etiquita de estimación (puntos). Los nombres de los paquetes, deben coincidir exactamante
con la historia, ejemplo, `story:winter-games`, paquete: `winter_games`.

#### 2. Diseñar el Modelo (0,5 pto)

Crear un **:one: issue#** (por ejemplo: **Team model**). Debe colocarse el diagrama de clases del modelo en los detalles
del issue y debe estar **siempre actualizado**. Para resolverlo se utilizará un flujo de trabajo ramificado, y una vez
finalizado e incorporado a **develop** y añadido el **tiempo consumido**, se debe avisar al profesor mediante
**Slack** dando en el mensaje privado la **url del issue**, si es correcto el **profesor autorizará** el cierre del
issue y se podrá continuar, sino, se deberán realizar los cambios.

* Crear 4 documentos. No puede haber 2 documentos, con el mismo nombre en toda la aplicación, ni dos atributos dentro de
  la misma práctica.
    * Cada documento: >=3 atributos, y en total >= 12 atributos, con al menos uno **LocalDateTime o LocalDate**,
      **Boolean** y uno **numérico (Integer, Double, Long o BigDecimal)**.
    * Los atributos para manejo de dinero deben ser BigDecimal.
    * Relaciones necesarias: 1..n, n..1 y n..n.

#### 3. Diseñar la persistencia (**:two: issue#**) (1 pto)

* Crear el modelo de entidades.
* Crear los DAOs (Repositorios).
* Crear una clase para poblar las BD: **&lt;_Story_>SeederService** e integrarlo con **DatabaseSeederService**.

#### 4. Crear 5 end-points (mediante :three:..:seven: issue#) (4 ptos)

* **GET, POST, PUT, DELETE** (0,75 ptos/end-point).
* **PATCH** (1 pto).
* Repartidos proporcionalmente entre el modelo.
* Los end-points deben estar 100% probados y los servicios también.

#### 5. Búsquedas y Patrones (4,5 ptos)

* Una vez finalizado los seis issues anteriores, se debe avisar al profesor por **Slack**, y el profesor añadirá :
    * :eight:..:nine: issues# para realizar end-points de búsquedas. **Recordar que en búsquedas, a cualquier nivel,
      resource, service, repository... siempre se coloca en el tipo de lo devuelto**.
    * :keycap_ten:..:one::one: issues# con la aplicación de dos patrones.

### :white_check_mark: Criterios de evaluación

* Uso correcto del flujo de trabajo ramificado. **Hasta -3 ptos**.
* Adecuación de la temporalidad de desarrollo según el enunciado. **Hasta -3 ptos**.
* Mantenimiento de calidad del código según GitHub Actions y Sonar. Cobertura >= 80%. **Hasta -3 ptos**. Todos los
  aspectos vistos en teoría, y poniendo espeacial enfásis en:
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

Indicar como texto en la subida:

* Nombre de la historía:
* Cuenta de GitHub:
* Nombre aparecen en los commits:
* Estimación total y tiempo total consumido:

> **NOTA. Acordarse de dar al botón de envío.**