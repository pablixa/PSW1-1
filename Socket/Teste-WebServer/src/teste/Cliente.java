/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package teste;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author Rafael.Soares
 */
public class Cliente {
        public static void main(String[] args){
        try{
            
            System.out.println("Escolha Pedra, papel ou tesoura");
            BufferedReader inFromUser = new BufferedReader(
                    new InputStreamReader(System.in)); //Prepara para ler do teclado
            
            String opcao = inFromUser.readLine(); //Le do teclado
           
            System.out.println("Conectando uma "
                   + "conexao na porta 1234");

           Socket clientSocket = new Socket("localhost", 1234); // Conecta-se ao servidor remoto na porta indicada
           System.out.println("Conectado!");
           
           
           DataOutputStream out = 
                   new DataOutputStream(
                           clientSocket.getOutputStream()); //Prepara as classes para envio dos dados 
	   out.writeBytes(opcao + '\n'); //envia a mensagem (msg deve ser String)
           
           BufferedReader inputReader = 
                   new BufferedReader(
                           new InputStreamReader(
                                   clientSocket.getInputStream())); //Prepara as classes para leitura dos dados 
	
           String lido = inputReader.readLine(); //Le a informação enviada
           
            System.out.println("O servidor jogou:" + lido);
           
        }
        catch(Exception e){
            System.out.println("Erro ao conectar");
        }
    }
}
