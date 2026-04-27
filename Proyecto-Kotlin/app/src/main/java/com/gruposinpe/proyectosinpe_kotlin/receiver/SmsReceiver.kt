package com.gruposinpe.proyectosinpe_kotlin.receiver

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.telephony.SmsMessage
import android.util.Log
import android.widget.Toast

class SmsReceiver : BroadcastReceiver() {

    companion object{
        private const val TAG = "SmsReceiver"
    }

    override fun onReceive(context: Context?, intent: Intent?) {
        if (intent?.action == "android.provider.Telephony.SMS_RECEIVED"){
            val bundle: Bundle? = intent.extras

            if(bundle != null){
                try{
                    val pdus = bundle.get("pdus") as Array<*>

                    for(pdu in pdus){
                        val smsMessage: SmsMessage = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M){
                            val format = bundle.getString("format")
                            SmsMessage.createFromPdu(pdu as ByteArray, format)
                        }else{
                            SmsMessage.createFromPdu(pdu as ByteArray)
                        }

                        val sender = smsMessage.originatingAddress ?: ""
                        val message = smsMessage.messageBody ?: ""

                        Log.d(TAG, "Origen: $sender")
                        Log.d(TAG, "Mensaje: $message")

                        val normalizeSender = sender.replace("-", "").replace(" ", "")

                        if(normalizeSender.endsWith("60405995")){
                            Log.d(TAG, "Mensaje del Banco nacional recibido")

                            if (context != null) {
                                Toast.makeText(context, "SMS BNCR Recibido", Toast.LENGTH_SHORT).show()
                            }
                        }

                    }
                } catch(e: Exception){
                    Log.e(TAG, "Error: ${e.message}")
                }
            }
        }
    }
}
