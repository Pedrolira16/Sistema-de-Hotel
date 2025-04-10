from nova_reserva import enviar_nova_reserva
from alteracao_reserva import enviar_alteracao_reserva
from emergencia import enviar_emergencia
from item_perdido import enviar_item_perdido
from relatorio_diario import enviar_relatorio_diario

def menu():
    while True:
        print("\n=== Menu do Hotel ===")
        print("1. Nova Reserva")
        print("2. Alteração de Reserva")
        print("3. Emergência")
        print("4. Item Perdido/Encontrado")
        print("5. Relatório Diário")
        print("6. Sair")

        opcao = input("\nEscolha uma opção (1-6): ")

        if opcao == '1':
            enviar_nova_reserva()
        elif opcao == '2':
            enviar_alteracao_reserva()
        elif opcao == '3':
            enviar_emergencia()
        elif opcao == '4':
            enviar_item_perdido()
        elif opcao == '5':
            enviar_relatorio_diario()
        elif opcao == '6':
            print("Encerrando o programa...")
            break
        else:
            print("Opção inválida! Tente novamente.")

if __name__ == "__main__":
    menu()