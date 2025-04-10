from config import get_channel

def enviar_alteracao_reserva():
    connection, channel = get_channel()

    nome_hospede = input('Digite o nome do hóspede: ')
    numero_quarto = input('Digite o número do quarto: ')
    nova_data_checkin = input('Digite a nova data de check-in (DD-MM-YYYY): ')
    nova_data_checkout = input('Digite a nova data de check-out (DD-MM-YYYY): ')

    mensagem = f"{nome_hospede}!\n\n" + \
               f"Fez uma mudança na reserva {numero_quarto} foi alterada com sucesso!\n" + \
               f"Novo Check-in: {nova_data_checkin}\n" + \
               f"Novo Check-out: {nova_data_checkout}"

    channel.basic_publish(
        exchange='topic-exchange',
        routing_key='hotel.alteracao_reserva',
        body=mensagem
    )

    print("\n" + "="*50)
    print("🔄 ALTERAÇÃO DE RESERVA REGISTRADA 🔄")
    print("="*50)
    print(f"👤 Hóspede: {nome_hospede}")
    print(f"🔢 Quarto: {numero_quarto}")
    print(f"📅 Novo Check-in: {nova_data_checkin}")
    print(f"📅 Novo Check-out: {nova_data_checkout}")
    print("="*50 + "\n")

    connection.close()