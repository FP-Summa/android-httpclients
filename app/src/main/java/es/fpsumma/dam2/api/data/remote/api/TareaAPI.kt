package es.fpsumma.dam2.api.data.remote.api

import es.fpsumma.dam2.api.data.remote.dto.TareaCreateRequestDTO
import es.fpsumma.dam2.api.data.remote.dto.TareaDTO
import es.fpsumma.dam2.api.data.remote.dto.TareaUpdateRequestDTO
import retrofit2.Response
import retrofit2.http.*

interface TareaAPI {
    @GET("api/tareas")
    suspend fun listar(): Response<List<TareaDTO>>

    @DELETE("api/tareas/{id}")
    suspend fun eliminar(@Path("id") id: Int): Response<Unit>

    @POST("api/tareas")
    suspend fun crear(@Body request: TareaCreateRequestDTO): Response<TareaDTO>

    @PUT("api/tareas/{id}")
    suspend fun actualizar(
        @Path("id") id: Int,
        @Body request: TareaUpdateRequestDTO
    ): Response<TareaDTO>

    @GET("api/tareas/{id}")
    suspend fun detalle(@Path("id") id: Int): Response<TareaDTO>
}