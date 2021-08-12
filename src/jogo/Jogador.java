package jogo;
public class Jogador 
{
    int id;
    String nickname;
    int vitorias;
    int derrotas;
    int empates;

   public Jogador() {
        }

    public Jogador(int id, String nickname, int vitorias, int derrotas, int empates) {
        this.id = id;
        this.nickname = nickname;
        this.vitorias = vitorias;
        this.derrotas = derrotas;
        this.empates = empates;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public int getVitorias() {
        return vitorias;
    }

    public void setVitorias(int vitorias) {
        this.vitorias = vitorias;
    }

    public int getDerrotas() {
        return derrotas;
    }

    public void setDerrotas(int derrotas) {
        this.derrotas = derrotas;
    }

    public int getEmpates() {
        return empates;
    }

    public void setEmpates(int empates) {
        this.empates = empates;
    }
    
    public void vencer()
    {
        this.vitorias += 1;
    }
    
    public void perder()
    {
        this.derrotas +=1;
    }
    
    public void empatar()
    {
        this.empates += 1;
    }
}
