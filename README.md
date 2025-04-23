Cajero Automático en Java
Autor: Alan Jehovani Castillo Donis

Este es un programa en Java que simula un cajero automático básico. Permite consultar el saldo y retirar dinero, manteniendo la información en un archivo de almacenamiento local.

Características:

- Consulta de saldo: Muestra el saldo actual almacenado en el archivo.

- Retiro de dinero: Permite retirar dinero si el saldo es suficiente.

- Persistencia de datos: Guarda y actualiza el saldo en un archivo saldo.dat.


Requisitos:

- Tener instalado Java 8 o superior.

- Un entorno de desarrollo compatible con Java (Eclipse, IntelliJ, VS Code, etc.).


Instalación y Ejecución:

- Clonar el repositorio o copiar el código en un archivo cajeroautomatico.java.

- Compilar el programa desde la terminal o consola:

  javac cajeroautomatico.java

- Ejecutar el programa:

 java cajeroautomatico


Uso:

- Al ejecutar el programa, se mostrará un menú con las siguientes opciones:

----- Menú Cajero Automático -----
1. Consultar saldo
2. Retirar dinero
3. Salir
Seleccione una opción:

Opción 1: Muestra el saldo disponible.

Opción 2: Permite ingresar un monto para retirar, verificando si hay saldo suficiente.

Opción 3: Cierra el programa.


Funcionamiento Interno: 

- inicializarSaldo(): Crea el archivo saldo.dat si no existe y le asigna un saldo inicial de $1000.00.

- consultarSaldo(): Lee y muestra el saldo almacenado en el archivo.

- retirarDinero(Scanner scanner): Lee el saldo actual, verifica si el retiro es posible y actualiza el archivo con el nuevo saldo.