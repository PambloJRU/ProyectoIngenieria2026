using ProyectoIngenieriaBACKEND_POS.Models.Dtos;

namespace ProyectoIngenieriaBACKEND_POS.Services.Interfaces
{
    public interface ISmsReceiverService
    {
        Task<bool> ProcessIncomingSmsAsync(SmsRequestDTO smsData);
    }
}
