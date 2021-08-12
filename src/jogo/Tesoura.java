package jogo;
public class Tesoura extends ObjetoEscolhido
{
    String resultadoVencer = "Tesoura cortou papel";
    String resultadoPerder = "Pedra quebrou Tesoura";
    
    Jogador jogador = new Jogador();
    
    @Override
    public String Acao(String valorComputador, String valorJogador)
    {
        //System.out.println(resultado);
        System.out.println("Os tipos foram " + valorComputador + " x " + valorJogador);
        
        if (valorComputador.equals(pedra) && valorJogador.equals(tesoura))
        {
            mensagem = "Você perdeu! " + resultadoPerder;
        }
        if (valorComputador.equals(papel) && valorJogador.equals(tesoura))
        {
            mensagem = "Você ganhou! " + resultadoVencer;
        }
        
        if (valorComputador.equals(tesoura) && valorJogador.equals(tesoura))
        {
            mensagem = "Houve empate. Deu Tesoura x Tesoura";
        }
        
        return mensagem;
    }
}