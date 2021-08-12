package jogo;
public abstract class ObjetoEscolhido 
{
    String mensagem;
    String pedra = "Pedra";
    String papel = "Papel";
    String tesoura = "Tesoura";    
    
    public abstract String Acao(String valor1, String valor2);
    //public void Empate();
}
