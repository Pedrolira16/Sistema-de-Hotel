import pika
import os

def get_channel():
    url = os.environ.get(
        'CLOUDAMQP_URL',
        'amqps://jqpopift:XfY2NHxk3yQ0hkOMMpP_glURWGCrakaL@jackal.rmq.cloudamqp.com/jqpopift'
    )
    params = pika.URLParameters(url)
    connection = pika.BlockingConnection(params)
    channel = connection.channel()
    channel.exchange_declare(exchange='hotel-exchange', exchange_type='topic', durable=True)
    return connection, channel