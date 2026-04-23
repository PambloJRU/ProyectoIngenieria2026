package com.gruposinpe.proyectosinpe_kotlin.model

//este modelo tiene que ser igual al dto c#
data class SmsRequest(
    val senderNumber: String,
    val messageBody: String,
    val receivedAt: String
)

