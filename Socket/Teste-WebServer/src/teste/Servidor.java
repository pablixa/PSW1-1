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
import java.util.Date;

/**
 *
 * @author Rafael.Soares
 */
public class Servidor {
    
    public static void main(String[] args){
        try{
           System.out.println("Aguardando uma "
                   + "conexao na porta 5555");

           ServerSocket server = new ServerSocket(5555); // Prepara o servidor para receber conexoes na porta 1234
           Socket socket = server.accept(); //Interrompe a execução esperando um cliente
           System.out.println("recebi uma conexao!");
           
           BufferedReader inputReader = 
                   new BufferedReader(
                           new InputStreamReader(
                                   socket.getInputStream())); //Prepara as classes para leitura dos dados 
	   
           String lido = "";
           String comando = "";
           do{
                lido = inputReader.readLine(); //Le a informação enviada
                
                if(lido.indexOf("GET") == 0){
                    System.out.println("li:" + lido);
                    comando = lido.substring(lido.indexOf("GET")+"GET".length());
                    System.out.println("comando:" + comando);
                    comando = comando.substring(0,comando.indexOf("HTTP"));
                    comando = comando.trim();
                    System.out.println("comando:" + comando);
                }
                    
                    
                System.out.println("li:" + lido);
           }while(!lido.equals(""));
         
           
           DataOutputStream out = 
                   new DataOutputStream(socket.getOutputStream()); //Prepara as classes para envio dos dados 
           
           if(comando.equals("/batata.html")){
               out.writeBytes("<h1>Batata" + new Date() + "</h1>");
           }
           if(comando.equals("/banana.html")){
               out.writeBytes("<h1>BANANA</h1>");
           }
           
           out.writeBytes("<h1>Ola mundo!</h1>" + '\n'); //envia a mensagem (msg deve ser String)
           out.close();
           
           
        }
        catch(Exception e){
            System.out.println("Erro ao esperar conexao:" + e.getMessage());
        }
        System.out.println("Fim!");
    }
}
