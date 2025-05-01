# Método de Newton-Raphson - Métodos Numéricos

## Descripción
Este proyecto implementa el **método de Newton-Raphson**, un algoritmo de métodos numéricos utilizado para encontrar raíces de una función diferenciable \( f(x) \). El método utiliza la derivada de la función \( f'(x) \) y una aproximación inicial \( x_0 \) para iterar hacia la raíz de la ecuación \( f(x) = 0 \).

## Propósito
El objetivo de este código es:
- Encontrar una raíz aproximada de una ecuación no lineal utilizando el método de Newton-Raphson.
- Demostrar la implementación del método en un programa en Java con Maven.
- Proporcionar una herramienta educativa para estudiantes de métodos numéricos.

## Cómo funciona
El método de Newton-Raphson sigue estos pasos:
1. Se selecciona una aproximación inicial \( x_0 \).
2. Se calcula la siguiente aproximación usando la fórmula:
   \[
   x_{n+1} = x_n - \frac{f(x_n)}{f'(x_n)}
   \]
3. Si \( f(x_{n+1}) \) es lo suficientemente pequeño (dentro de una tolerancia), \( x_{n+1} \) es la raíz aproximada.
4. Si no, se repite el proceso hasta que se cumpla la tolerancia o se alcance un número máximo de iteraciones.

## Requisitos
- Java 8 o superior.
- Maven para la gestión de dependencias.
- Un entorno de desarrollo como IntelliJ IDEA, Eclipse o similar.

## Uso
1. Clona este repositorio:
   ```
   git clone https://github.com/Yovanygt/metodo_newton_raphson.git
   ```
2. Navega al directorio del proyecto y compila con Maven:
   ```
   mvn clean install
   ```
3. Ejecuta el programa desde tu entorno de desarrollo o con Maven:
   ```
   mvn exec:java -Dexec.mainClass="tu.paquete.principal.ClasePrincipal"
   ```
   (Ajusta `tu.paquete.principal.ClasePrincipal` según el nombre de tu clase principal).
4. Ingresa la aproximación inicial y la tolerancia cuando se soliciten.

## Estructura del Proyecto
- `src/`: Contiene el código fuente en Java.
- `pom.xml`: Archivo de configuración de Maven con las dependencias del proyecto.
- `target/`: Directorio generado por Maven con los archivos compilados (no versionado en Git).

## Licencia
Este proyecto está bajo la licencia MIT. Consulta el archivo `LICENSE` para más detalles (si aplica).

