# 🏦 Simulador de Cajero Automático (ATM)

Proyecto desarrollado para la asignatura **Programación III** en la **UNLaR** (Departamento Académico de Ciencias Exactas, Físicas y Naturales).

<p align="center">
  <img src="https://resizer.iproimg.com/unsafe/768x/filters:format(webp):quality(75):max_bytes(102400)/https://assets.iprofesional.com/assets/jpg/2023/09/560256.jpg" alt="Cajero refencia" width="900"/>
</p>

## 🎯 Objetivo
Introducir conceptos de estado, inmutabilidad y manejo de errores en sistemas transaccionales, aplicando estructuras de control avanzadas y principios de encapsulamiento estricto.

## 🚀 Funcionalidades Principales
* **Modelo de Dominio Robusto:** Implementación de cuentas bancarias con número de cuenta inmutable y estados definidos.
* **Operaciones Transaccionales:** * Depósitos con validación de montos positivos.
    * Extracciones con control de saldo y límites operativos ($10,000 por operación).
    * Transferencias atómicas entre cuentas del sistema.
    * Consultas de saldo sin modificación de estado.
* **Logging y Auditoría:** Registro detallado de cada operación (timestamp, tipo, monto y saldo resultante) utilizando `StringBuilder` para optimización.
* **Interfaz de Usuario:** Menú interactivo en consola mediante `switch expressions` y validación de entrada de datos (manejo de `InputMismatchException`).

<p align="center">
  <img src="https://i.pinimg.com/originals/be/79/3e/be793efbdfe10acc8e91540a0efe29eb.gif" alt="Cajero refencia" width="900"/>
</p>

## 🛠️ Manejo de Excepciones
El sistema garantiza la integridad mediante una jerarquía de excepciones personalizadas:
1. `SaldoInsuficienteException`: Se dispara cuando el monto solicitado supera el saldo disponible.
2. `LimiteExtraccionExcedidoException`: Controla el límite de retiro por operación.
3. `CuentaInactivaException`: Restringe operaciones en cuentas desactivadas por administración.

## 🏗️ Estructura del Proyecto
El código está organizado de manera modular siguiendo la estructura de paquetes obligatoria:
* `model`: Clases de dominio y lógica de datos.
* `exception`: Definiciones de errores personalizados.
* `service`: Lógica de negocio y procesamiento de transacciones.
* `ui`: Interfaz de usuario por consola.
* `util`: Herramientas auxiliares y formateo.

<h3 align="center">Diagrama de estados</h3>
<p align="center">
  <img src="Imagenes necesarias/Diagrama de estado - Cajero automatico.png" alt="Diagrama de estados" width="700"/>
</p>

## 📋 Requisitos Técnicos
* **Inmutabilidad:** Atributos `final` para identificadores críticos como `numeroCuenta`.
* **Precisión Financiera:** Uso de `double` (o `BigDecimal`) para el manejo de saldos.
* **Colecciones:** Gestión de historial mediante `ArrayList<String>`.

---

---

## 👨‍💻 Desarrolladores / Integrantes del equipo

<p align="center">
  <table align="center">
    <tr>
      <td align="center" valign="top" width="30%">
        <a href="https://github.com/IsmaDeveloper16">
          <img src="Imagenes necesarias/Isma.jpeg" width="250"/><br />
          <sub><b>Ismael Flores</b></sub>
        </a>
      </td>
      <td align="center" valign="top" width="30%">
        <a href="https://github.com/franlar020">
          <img src="Imagenes necesarias/Fran.jpeg" width="260"/><br />
          <sub><b>Francisco Antonio Gonzalez</b></sub>
        </a>
      </td>
      <td align="center" valign="top" width="30%">
        <a href="https://github.com/VirginiaVeraHerrera">
          <img src="Imagenes necesarias/Vir.jpeg" width="325"/><br />
          <sub><b>Virginia Vera</b></sub>
        </a>
      </td>
    </tr>
  </table>
</p>
