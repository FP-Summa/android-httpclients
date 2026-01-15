package es.fpsumma.dam2.api.ui.navegation

// es.fpsumma.dam2.api.ui.navegation/Routes.kt
object Routes {
    const val TAREAS_LISTADO = "tareas_listado"
    const val TAREA_ADD = "tarea_add"
    const val TAREA_VIEW = "tarea_view/{id}"

    // Rutas para modo API
    const val TAREAS_LISTADO_API = "tareas_listado_api"
    const val TAREA_ADD_API = "tarea_add_api"
    const val TAREA_VIEW_API = "tarea_view_api/{id}"

    fun tareaView(id: Int) = "tarea_view/$id"
    fun tareaViewApi(id: Int) = "tarea_view_api/$id"
}