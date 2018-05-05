package br.ufs.dcomp.radiochat;

/**
 * Hello world!
 *
 */
 
import java.util.Scanner;
public class App 
{
    public static void main( String[] args )
    {
        String nome;
        int i = 1;
        
        
        Scanner entrada = new Scanner(System.in);
        
        do{
        System.out.print("Digite seu nome: ");
        nome = entrada.nextLine();
        
        
        System.out.println( "Seu nome é:  "+nome+"");
        
        i++;
        }while(!nome.equals("#close"));
        
    }
}
