using ProyectoIngenieriaBACKEND_POS.Models.Dtos;
using ProyectoIngenieriaBACKEND_POS.Services.Interfaces;

namespace ProyectoIngenieriaBACKEND_POS.Services
{
    public class SmsReceiverService : ISmsReceiverService
    {
        public async Task<bool> ProcessIncomingSmsAsync(SmsRequestDTO smsData)
        {


            // Aquí en el futuro (HU-02) llamaremos al código que extrae el monto y referencia.
            // Por ahora, para cumplir la Tarea 02 de la HU-01, solo validaremos que llegue bien.
            if (string.IsNullOrWhiteSpace(smsData.MessageBody))
            {
                
                return false;
            }

            Console.WriteLine($"[NUEVO SMS RECIBIDO] De: {smsData.SenderNumber} a las {smsData.ReceivedAt}");
            Console.WriteLine($"Contenido: {smsData.MessageBody}");

            return await Task.FromResult(true);
        }
    }
}
