package jogo;
public class Pedra extends ObjetoEscolhido
{
    String resultadoVencer = "Pedra quebrou Tesoura";
    String resultadoPerder = "Papel envolveu Pedra";
    Jogador jogador = new Jogador();
    @Override
    public String Acao(String valorComputador, String valorJogador)
    {
        System.out.println("Os tipos foram " + valorComputador + " x " + valorJogador);
        
        if (valorComputador.equals(papel) && valorJogador.equals(pedra))
        {
            mensagem = "Você perdeu! " + resultadoPerder;
        }
        if (valorComputador.equals(tesoura) && valorJogador.equals(pedra))
        {
            mensagem = "Você ganhou! " + resultadoVencer;  
        }
        
        if (valorComputador.equals(pedra) && valorJogador.equals(pedra))
        {
            mensagem = "Houve empate. Deu Pedra x Pedra";
        }
        System.out.println(mensagem);
        return mensagem;
    }
}
