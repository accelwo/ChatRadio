/**
 * @author Accel Willian 
 */
package br.ufs.dcomp.radiochat;

import java.net.*;
import java.io.*;
import java.util.Scanner;

public class RadioA{
    public static void main(String[] args){
        
        try {
            String texto;
           
            Scanner entrada = new Scanner(System.in);
            
            
            System.out.print("[ Iniciando Servidor TCP    .........................  ");
            ServerSocket ss = new ServerSocket(3300, 5, InetAddress.getByName("127.0.0.1"));
            System.out.println("[OK] ]");
            
            System.out.print("[ Aquardando pedidos de conexão (conversa)............  ");
            Socket sock = ss.accept(); // Operação bloqueante (aguardando pedido de conexão)
            System.out.println("[OK] ]");
            
            InputStream is = sock.getInputStream(); //Canal de entrada de dados
            OutputStream os = sock.getOutputStream(); //Canal de saída de dados
            //byte[] buf = new byte[144]; // buffer de recepção
            System.out.println("[Conversa aberto, aguardando primeira mensagem.......]");


            do {
            byte[] buf = new byte[144];
            System.out.print("[<<<<] ");
            is.read(buf); // Operação bloqueante (aguardando chegada de dados)
            //System.out.println("[OK] ]");
            
            String msg = new String(buf); // Mapeando vetor de bytes recebido para String
            
            //System.out.println("[<<<<]"+ msg);
            System.out.println(msg);
            
            //Envio de mensagem de retorno ao cliente
            
            System.out.print("[>>>>] ");
            texto = entrada.nextLine();
            byte[] carrega = texto.getBytes();
            
            //System.out.print("[>>>>] ");
            os.write(carrega);
            //System.out.println("[OK]]");
            //System.out.println("");
            }while(!texto.equals("#close"));

        }catch(Exception e){System.out.println(e);}    
        System.out.println("[ FIM ]");
    }
}