from config import get_channel

def enviar_emergencia():
    connection, channel = get_channel()

    tipo_emergencia = input('Digite o tipo de emergência: ')
    local = input('Digite o local da emergência: ')
    descricao = input('Digite a descrição da emergência: ')

    mensagem = f"🚨 EMERGÊNCIA REGISTRADA 🚨\n\n" + \
               f"Tipo: {tipo_emergencia}\n" + \
               f"Local: {local}\n" + \
               f"Descrição: {descricao}\n\n" + \
               "Equipe de emergência acionada!"

    channel.basic_publish(
        exchange='topic-exchange',
        routing_key='hotel.emergencia',
        body=mensagem
    )

    print("\n" + "="*50)
    print("🚨 EMERGÊNCIA REGISTRADA 🚨")
    print("="*50)
    print(f"⚠️ Tipo: {tipo_emergencia}")
    print(f"📍 Local: {local}")
    print(f"📝 Descrição: {descricao}")
    print("="*50 + "\n")

    connection.close()