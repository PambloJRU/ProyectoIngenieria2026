namespace ProyectoIngenieriaBACKEND_POS.Models.Dtos
{
    public class SmsRequestDTO
    {

        public string SenderNumber { get; set; } = string.Empty;

        public string MessageBody { get; set; } = string.Empty;

        public DateTime ReceivedAt { get; set; }
    }
}
