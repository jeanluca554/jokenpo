package jogo;
public class Papel extends ObjetoEscolhido
{
    String resultadoVencer = "Papel envolveu pedra";
    String resultadoPerder = "Tesoura cortou Papel";
    Jogador jogador = new Jogador();
    @Override
    public String Acao(String valorComputador, String valorJogador)
    {
        //System.out.println(resultado);
        System.out.println("Os tipos foram " + valorComputador + " x " + valorJogador);
        
        if (valorComputador.equals(tesoura) && valorJogador.equals(papel))
        {
            mensagem = "Você perdeu! " + resultadoPerder;
        }
        if (valorComputador.equals(pedra) && valorJogador.equals(papel))
        {
            mensagem = "Você ganhou! " + resultadoVencer;
        }
        
        if (valorComputador.equals(papel) && valorJogador.equals(papel))
        {
            mensagem = "Houve empate. Deu Papel x Papel";
        }
        
        return mensagem;
    }
}