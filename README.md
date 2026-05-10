## 👨‍💻 Autor

**Estudiante:** Alejandro Aguirre
**Asignatura:** Programación Orientada a Objetos  
**Institución:** Escuela Politécnica Nacional - Escuela de Formación de Tecnólogos  

# 📦 Sistema de Entregas con Drones Autónomos - Prueba 1 POO

## 🎥 Video Explicativo de las Partes más Complicadas

[**[Enlace al video de 10 minutos](https://youtu.be/3mj0QJK5xpg)**] — (Aquí explica qué fue lo que más se me complico)

---

## 📌 Descripción del Proyecto

Este proyecto simula un sistema de logística inteligente que utiliza diferentes tipos de drones autónomos para realizar entregas.  
Se implementan los principios de **Programación Orientada a Objetos (POO)** en Java, incluyendo:

- Herencia
- Encapsulamiento
- Clases abstractas
- Métodos abstractos
- Sobrescritura (`@Override`)
- Polimorfismo
- Validaciones en setters
- Entrada de datos con `Scanner`
- Cálculo dinámico de costos de entrega

---

## 🧱 Estructura de Clases

| Clase              | Tipo               | Descripción                                                                 |
|--------------------|--------------------|-----------------------------------------------------------------------------|
| `Dron`             | Clase abstracta    | Clase padre con atributos comunes y métodos abstractos                      |
| `DronLiviano`      | Clase hija         | Entregas rápidas: carga ≤ 5 kg, alcance ≤ 20 km, horas ≥ 2                  |
| `DronCarga`        | Clase hija         | Cargas pesadas: hasta 30 kg, alcance ≤ 50 km, horas ≥ 5                      |
| `DronEmergencia`   | Clase hija         | Prioridad máxima (niveles 1–3), carga ≤ 10 kg, horas ≥ 3                    |

---

## 🧾 Atributos Comunes (clase `Dron`)

| Atributo        | Tipo     | Descripción                                |
|----------------|----------|--------------------------------------------|
| `codigo`       | String   | Identificador único del dron               |
| `modelo`       | String   | Nombre del modelo                          |
| `distanciaKm`  | double   | Distancia del recorrido                     |
| `pesoPaquete`  | double   | Peso del paquete (kg)                      |
| `horasVuelo`   | double   | Horas estimadas de vuelo                   |
| `costoBase`    | double   | Costo base según tipo de dron (protected)  |

---

## 💰 Costos Base por Tipo de Dron

| Tipo de Dron       | Costo Base |
|--------------------|-------------|
| `DronLiviano`      | $3.00       |
| `DronCarga`        | $6.00       |
| `DronEmergencia`   | $8.00       |

---

## ✅ Validaciones Implementadas (Setters y métodos `validarDatos()`)

### Validaciones comunes en `Dron` (setters):
- `codigo` y `modelo` no vacíos.
- `distanciaKm > 0`
- `pesoPaquete > 0`
- `horasVuelo > 0`

### Validaciones específicas por subclase (método `validarDatos()`):

- **DronLiviano**:  
  `pesoPaquete ≤ 5` && `horasVuelo ≤ 2` && `distanciaKm ≤ 20`

- **DronCarga**:  
  `pesoPaquete ≤ 30` && `horasVuelo ≤ 5` && `distanciaKm ≤ 50`

- **DronEmergencia**:  
  `pesoPaquete ≤ 10` && `horasVuelo ≤ 3` && `nivelPrioridad` entre 1 y 3

---

## 🧮 Cálculo de Costo de Entrega (método `calcularCostoEntrega()`)

| Tipo de Dron       | Fórmula de cálculo                                                                 |
|--------------------|------------------------------------------------------------------------------------|
| `DronLiviano`      | `costoBase + (distanciaKm * 0.50)`                                                 |
| `DronCarga`        | `costoBase + (distanciaKm * 0.70) + (pesoPaquete * costoPorKg)`                     |
| `DronEmergencia`   | `costoBase + (distanciaKm * 1) + recargoUrgencia`                                   |

> Si `validarDatos()` retorna `false`, el costo de entrega es `0`.

---

## 🧪 Datos Iniciales (Valores Quemados por Constructor sin Parámetros)

| Dron             | Código     | Modelo      | Distancia | Peso | Horas | Costo Base |
|------------------|------------|-------------|-----------|------|-------|-------------|
| `DronLiviano`    | `DL-000`   | `LivianoX`  | 5.0 km    | 2 kg | 1.0 h | $3.00       |
| `DronCarga`      | `DC-000`   | `CargaMax`  | 5.0 km    | 2 kg | 1.0 h | $6.00       |
| `DronEmergencia` | `DE-000`   | `Emergente` | 5.0 km    | 2 kg | 1.0 h | $8.00       |

---

## ▶️ Ejecución del Programa (Flujo Principal en `Main`)

1. **Información inicial**  
   Se crean tres drones (uno de cada tipo) con valores de prueba.

2. **Listado inicial**  
   Se muestra la información completa de cada dron.

3. **Menú de actualización**  
   El usuario elige qué tipo de dron actualizar.

4. **Ingreso de nuevos datos**  
   Se solicitan los nuevos valores según el tipo de dron.

5. **Validación**  
   Se verifica si los nuevos datos cumplen con las reglas del negocio.

6. **Confirmación**  
   Si los datos son válidos, el usuario decide si guardar los cambios.

7. **Demostración de polimorfismo**  
   - Se recorre una lista de tipo `Dron` mostrando costos.
   - Se invoca `mostrarInformacion()` desde referencia de la clase padre.

8. **Constructores por defecto**  
   Se crean drones adicionales con valores quemados y se muestran.

9. **Fin del programa**  
   Mensaje de despedida.

---

## 🛠️ Tecnologías y Conceptos Usados

- Java (JDK 11+)
- Programación Orientada a Objetos
- Herencia y abstracción
- Encapsulamiento con `private` / `protected`
- Métodos abstractos y sobrescritura
- Polimorfismo
- Manejo de excepciones básico (`try-catch`)
- `ArrayList` y `Scanner`
- Entrada/salida por consola

