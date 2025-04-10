from config import get_channel

def enviar_nova_reserva():
    connection, channel = get_channel()

    nome_hospede = input('Digite o nome do hóspede: ')
    numero_quarto = input('Digite o número do quarto: ')
    data_checkin = input('Digite a data de check-in (DD-MM-YYYY): ')
    data_checkout = input('Digite a data de check-out (DD-MM-YYYY): ')

    mensagem = f"{nome_hospede}!\n\n" + \
               f"Fez uma reserva no quarto {numero_quarto} que está reservado com sucesso!\n" + \
               f"Check-in: {data_checkin}\n" + \
               f"Check-out: {data_checkout}"

    channel.basic_publish(
        exchange='topic-exchange',
        routing_key='hotel.nova_reserva',
        body=mensagem
    )

    print("\n" + "="*50)
    print("🏨 NOVA RESERVA REGISTRADA 🏨")
    print("="*50)
    print(f"👤 Hóspede: {nome_hospede}")
    print(f"🔢 Quarto: {numero_quarto}")
    print(f"📅 Check-in: {data_checkin}")
    print(f"📅 Check-out: {data_checkout}")
    print("="*50 + "\n")

    connection.close()