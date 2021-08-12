package jogo;

import java.util.ArrayList;
import java.util.Random;

public class IniciarConfronto 
{
    int OpComputador = -1;
    
    public String Jogar(int escolhaJogador)
    {
        Pedra objPedra = new Pedra();
        Papel objPapel = new Papel();
        Tesoura objTesoura = new Tesoura();
        
        String resposta = "";
        
        

        //O Random servirá para escolher valores para Pedra(0), Papel(1) e Tesoura(2)
        Random gerador = new Random();

        ArrayList confronto = new ArrayList(); //cria um Array para inserir os valores de acordo com o sorteio
         
        switch (gerador.nextInt(3))
        {
            case 0:
                confronto.add(objPedra);
                System.out.println("0");
                OpComputador = 0;
                break;

            case 1:
                confronto.add(objPapel);
                System.out.println("1");
                OpComputador = 1;
                break;

            case 2:
                confronto.add(objTesoura);
                System.out.println("2");
                OpComputador = 2;
                break;
        }
        

        //Se o resultado for Pedra x Pedra
        if (confronto.get(0).equals(objPedra) && escolhaJogador == 0)
        {
            resposta = objPedra.Acao("Pedra", "Pedra");
        }

        //Se o resultado for Pedra x Papel
        if (confronto.get(0).equals(objPedra) && escolhaJogador == 1)
        {
            resposta = objPapel.Acao("Pedra", "Papel");
        }

        //Se o resultado for Pedra x Tesoura
        if (confronto.get(0).equals(objPedra) && escolhaJogador == 2)
        {
            resposta = objTesoura.Acao("Pedra", "Tesoura");
        }

        //Se o resultado for Papel x Pedra
        if (confronto.get(0).equals(objPapel) && escolhaJogador == 0)
        {
            resposta = objPedra.Acao("Papel","Pedra");
        }

        //Se o resultado for Papel x Papel
        if (confronto.get(0).equals(objPapel) && escolhaJogador == 1)
        {
            resposta = objPapel.Acao("Papel", "Papel");
        }

        //Se o resultado for Papel x Tesoura
        if (confronto.get(0).equals(objPapel) && escolhaJogador == 2)
        {
            resposta = objTesoura.Acao("Papel","Tesoura");
        }

        //Se o resultado for Tesoura x Pedra
        if (confronto.get(0).equals(objTesoura) && escolhaJogador == 0)
        {
            resposta = objPedra.Acao("Tesoura","Pedra");
        }

        //Se o resultado for Tesoura x Papel
        if (confronto.get(0).equals(objTesoura) && escolhaJogador == 1)
        {
            resposta = objPapel.Acao("Tesoura","Papel");
        }

        //Se o resultado for Tesoura x Tesoura
        if (confronto.get(0).equals(objTesoura) && escolhaJogador == 2)
        {
            resposta = objTesoura.Acao("Tesoura","Tesoura");
        }
        //System.out.println("a resposta foi: " + resposta);
        return resposta;
    }
    
    public int OpcaoComputador()
    {
        return this.OpComputador;
    }
    
    
}
