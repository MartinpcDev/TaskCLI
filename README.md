# Task Tracker - Seguimiento y Gestión de Tareas en la CLI

https://roadmap.sh/projects/task-tracker

Task Tracker es una herramienta de línea de comandos (CLI) diseñada para ayudar a los usuarios a
organizar y gestionar sus tareas diarias de manera eficiente. Esta aplicación permite registrar y
supervisar el estado de cada tarea, proporcionando un control sobre las actividades que están
pendientes, en progreso o completadas. Task Tracker es una excelente manera de practicar habilidades
de programación fundamentales, como la interacción con el sistema de archivos, la gestión de
entradas de usuario y el desarrollo de aplicaciones basadas en CLI.

## Características principales:

- **Seguimiento de tareas**: añade, edita y elimina tareas en el sistema.
- **Gestión de estados**: clasifica las tareas en “Pendiente”, “En progreso” y “Completada” para
  facilitar la supervisión.
- **Simplicidad y funcionalidad**: una interfaz CLI intuitiva que permite un fácil acceso y
  actualización de las tareas.

Este proyecto está desarrollado en Java, haciendo uso de archivos de texto para almacenar la
información de las tareas, lo que lo convierte en una solución ligera y accesible para el
seguimiento de tareas diarias.

## Documentacion

* Agregar tarea `add {nombre de la tarea}`
* Lista de tareas `list`
* Actualizar nombre `update {id} {nombre de la tarea}`
* Borrar tarea `delete`
* Actualizar status `inprogress {id}` `done {id}`
* Listar por status `listdone` `listpending` `listinprogress`
* Salir del programa `exit`