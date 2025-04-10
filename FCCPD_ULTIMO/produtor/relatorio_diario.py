from config import get_channel

def enviar_relatorio_diario():
    connection, channel = get_channel()

    data = input('Digite a data do relatório (DD-MM-YYYY): ')
    ocupacao = input('Digite a taxa de ocupação (%): ')
    receita = input('Digite a receita do dia: ')
    observacoes = input('Digite as observações: ')

    mensagem = f"Relatório Diário - {data}\n\n" + \
               f"Taxa de Ocupação: {ocupacao}%\n" + \
               f"Receita do Dia: R$ {receita}\n" + \
               f"Observações: {observacoes}\n\n" + \
               "Relatório gerado automaticamente pelo sistema."

    channel.basic_publish(
        exchange='topic-exchange',
        routing_key='hotel.relatorio_diario',
        body=mensagem
    )

    print("\n" + "="*50)
    print("📊 RELATÓRIO DIÁRIO GERADO 📊")
    print("="*50)
    print(f"📅 Data: {data}")
    print(f"📈 Taxa de Ocupação: {ocupacao}%")
    print(f"💰 Receita: R$ {receita}")
    print(f"📝 Observações: {observacoes}")
    print("="*50 + "\n")

    connection.close()
