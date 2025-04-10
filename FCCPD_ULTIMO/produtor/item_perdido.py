from config import get_channel

def enviar_item_perdido():
    connection, channel = get_channel()

    nome_hospede = input('Digite o nome do hóspede: ')
    item = input('Digite o item perdido: ')
    local = input('Digite o local onde o item foi perdido: ')
    descricao = input('Digite a descrição do item: ')

    mensagem = f"foi perdido no nome de {nome_hospede}!\n\n" + \
               f"o item: {item}\n" + \
               f"Local: {local}\n" + \
               f"Descrição: {descricao}"

    channel.basic_publish(
        exchange='topic-exchange',
        routing_key='hotel.item_perdido',
        body=mensagem
    )

    print("\n" + "="*50)
    print("🔍 ITEM PERDIDO REGISTRADO 🔍")
    print("="*50)
    print(f"👤 Hóspede: {nome_hospede}")
    print(f"📦 Item: {item}")
    print(f"📍 Local: {local}")
    print(f"📝 Descrição: {descricao}")
    print("="*50 + "\n")

    connection.close()