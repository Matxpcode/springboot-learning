# Spring Boot Fundamentals

> Implementación de fundamentos de Spring Boot: Controladores REST, manejo de parámetros, inyección de propiedades y configuración de entorno.

## 🛠 Tecnologías y Versiones

- **Java:** 21
- **Spring Boot:** 4.1.1
- **Build Tool:** Maven 3.9.11
- **Entorno:** WSL (Windows Subsystem for Linux)

## 📋 Objetivos de la Lección

Esta lección se centra en los fundamentos de la creación de APIs REST con Spring Boot, cubriendo:
1.  **Controladores REST:** Uso de `@RestController`, `@RequestMapping`, `@GetMapping`, `@PostMapping`.
2.  **Manejo de Parámetros:**
    -   `@PathVariable`: Extracción de parámetros dinámicos de la URL.
    -   `@RequestParam`: Parámetros de consulta (query params) con valores por defecto.
    -   `HttpServletRequest`: Acceso directo a los parámetros brutos de la solicitud.
3.  **Inyección de Propiedades:**
    -   `@Value`: Carga de propiedades de `application.properties` o archivos `.properties` personalizados.
    -   **Spring Expression Language (SpEL):** Uso de expresiones avanzadas para manipular listas y mapas desde el archivo de configuración.
    -   `Environment`: Acceso programático a propiedades del contexto.
4.  **Manipulación de Datos:**
    -   Transformación de objetos (`User`).
    -   Devolución de respuestas JSON usando `Map`, `List` y DTOs personalizados.
5.  **Configuración:**
    -   Clase `@Configuration` con `@PropertySources` para cargar propiedades externas de forma modular.
