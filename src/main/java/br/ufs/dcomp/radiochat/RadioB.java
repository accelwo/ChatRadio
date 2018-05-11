/**
 * @author Accel Willian
 */
package br.ufs.dcomp.radiochat;

import java.net.*;
import java.io.*;
import java.util.Scanner;

public class RadioB{
    public static void main(String[] args){
        try {
            String texto;
            
            Scanner entrada = new Scanner(System.in);
            
            
            
            System.out.print("[ Conectando com o Servidor TCP    ..................  ");
            Socket sock = new Socket("127.0.0.1", 3300);
            System.out.println("[OK] ]");
            
            InputStream is = sock.getInputStream(); // Canal de entrada de dados
            OutputStream os = sock.getOutputStream(); // Canal de saída de dados
            do {
            System.out.print("Digite sua mensagem: ");
            texto = entrada.nextLine();
            //String msg = "Olá, DCOMP!";
            byte[] buf = texto.getBytes(); // Obtendo a respresntação em bytes da mensagem

            System.out.print("[ Enviando mensagem    ..............................  ");
            os.write(buf);
            System.out.println("[OK] ]");
            
            //Aguarda a mensagem de retorno do servidor
            byte[] retorno = new byte[144];
            System.out.print("[ Aguardando mensagem de resposta ....");
            is.read(retorno);
            String msgRetorno = new String(retorno);
            System.out.println("[OK]]");
            if (!msgRetorno.equals(" teste")){
                
                System.out.print(msgRetorno);
                System.out.print("---Dentro do if:");
                //break;
            }
            
            //String msgRetorno = new String(retorno);
            System.out.println(" Mensagem de retorno: "+msgRetorno);
            
            }while(!texto.equals("#close"));
            
        }catch(Exception e){System.out.println(e);}    
        System.out.println("[ FIM ]");
    }
}