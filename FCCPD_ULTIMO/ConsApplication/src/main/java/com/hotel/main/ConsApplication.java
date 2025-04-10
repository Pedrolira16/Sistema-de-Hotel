package com.hotel.main;

import com.hotel.gerencia.GerenciaApplication;
import com.hotel.secretaria.SecretariaApplication;
import com.hotel.auditoria.AuditoriaApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Scanner;

@SpringBootApplication
public class ConsApplication {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Escolha um setor do hotel:");
        System.out.println("1 - Gerência");
        System.out.println("2 - Secretaria");
        System.out.println("3 - Auditoria");
        System.out.print("Digite sua opção: ");

        int opcao = scanner.nextInt();

        switch (opcao) {
            case 1 -> {
                System.out.println("Iniciando consumidor da Gerência...");
                GerenciaApplication.gerenciaRun(args);
            }
            case 2 -> {
                System.out.println("Iniciando consumidor da Secretaria...");
                SecretariaApplication.secretariaRun(args);
            }
            case 3 -> {
                System.out.println("Iniciando consumidor da Auditoria...");
                AuditoriaApplication.auditoriaRun(args);
            }
            default -> System.out.println("Opção inválida.");
        }
    }
} 