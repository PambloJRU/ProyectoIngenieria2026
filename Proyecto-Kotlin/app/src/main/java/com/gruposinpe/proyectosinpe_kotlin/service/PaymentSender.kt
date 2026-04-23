package com.gruposinpe.proyectosinpe_kotlin.service

import com.gruposinpe.proyectosinpe_kotlin.model.SinpePayment
import com.gruposinpe.proyectosinpe_kotlin.network.ApiService

class PaymentSender(private val apiService: ApiService) {

    suspend fun enviarPago(amount: Double, name: String, reference: String) {

        val payment = SinpePayment(amount, name, reference)

        try {
            val response = apiService.enviarPagoProcesado(payment)

            if (response.isSuccessful) {
                println("Pago enviado")
            } else {
                println("Error en backend")
            }

        } catch (e: Exception) {
            println("Error de red: ${e.message}")
        }
    }
}