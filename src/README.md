#EJERCICIO 4

### REQUISITOS FUNCIONALES

1. No puede habver dos equipos con el mismo codigo en el intervalo
2. Al registrar un equipo este será inmediatamente disponible (consultar inventario)
3. Poder buscar equipos por su codigó
4. Poder cotizar un equipo en base al equipo y la duración
5. pcmfirmar cotisación (confirmar aluqiler)
6. No se puede alquilar un equipo que ya está alquilado
7. registrar devoluciones
8. obtener reporte general
9. tarifas, luminosidad, reslucion, potencia: todas > 0

decimal,format

Equipo:
- codigo
- marca
- modelo
- tarifa diaria
- disponible

Proyector extends Equipo
- lumenes
- inalambrico

Camara
- resolución

Sonido
- potencial

Inventario
- lista<equipo>
- registarEquipo()
- consultaEquipo(codigoEquipo)
- cotizar(codigoEquipo, duracionDias)
- confirmarCotisacion()
- devolverEquipo(codigoEquipo)