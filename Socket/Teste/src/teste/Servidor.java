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
public class Servidor {
    
    public static void main(String[] args){
        try{
           System.out.println("Aguardando uma "
                   + "conexao na porta 1234");

           ServerSocket server = new ServerSocket(1234); // Prepara o servidor para receber conexoes na porta 1234
           Socket socket = server.accept(); //Interrompe a execução esperando um cliente
           System.out.println("recebi uma conexao!");
           
           BufferedReader inputReader = 
                   new BufferedReader(
                           new InputStreamReader(
                                   socket.getInputStream())); //Prepara as classes para leitura dos dados 
	   String lido = inputReader.readLine(); //Le a informação enviada
         
           System.out.println("Li:" + lido);
           String resposta = "papel";
           if(lido.trim().equals("tesoura")){
               resposta = "pedra";
           }
           else if(lido.trim().equals("papel")){
               resposta = "tesoura";
           }
           
            System.out.println("Escolhi :" + resposta);
           DataOutputStream out = 
                   new DataOutputStream(socket.getOutputStream()); //Prepara as classes para envio dos dados 
           out.writeBytes(resposta + '\n'); //envia a mensagem (msg deve ser String)
           //out.close();
           
            System.out.println("Fim. mandei :" + resposta);
           
        }
        catch(Exception e){
            System.out.println("Erro ao esperar conexao");
        }
        System.out.println("Fim!");
    }
}
