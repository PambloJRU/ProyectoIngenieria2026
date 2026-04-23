package com.gruposinpe.proyectosinpe_kotlin.network
import com.gruposinpe.proyectosinpe_kotlin.model.SmsRequest
import com.gruposinpe.proyectosinpe_kotlin.model.SinpePayment
import okhttp3.ResponseBody
import retrofit2.http.Body
import retrofit2.http.POST
import retrofit2.Response

// TODO: Implementar cliente HTTP para enviar pagos al backend .NET

interface ApiService {

    @POST("api/Sms/receive")
    suspend fun enviarSmsAlServidor(@Body sms: SmsRequest): Response<ResponseBody>

    @POST("api/Sinpe/receive")
    suspend fun enviarPagoProcesado(@Body payment: SinpePayment): Response<ResponseBody>


}