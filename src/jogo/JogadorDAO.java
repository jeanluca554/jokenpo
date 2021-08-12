package jogo;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import jogo.Jogador;

public class JogadorDAO 
{

    public JogadorDAO() {
    }
    
    /*public JogadorDAO(String nickname, int vitorias, int derrotas, int empates) 
    {
        
    }*/
    
    
    public void create (Jogador jogador)
    {
        Connection con = ConexaoComBanco.getConnection();
        PreparedStatement stmt = null;
        
        try 
        {
            stmt = con.prepareStatement("INSERT INTO jogador (nickname)VALUES(?)");
            stmt.setString(1, jogador.getNickname());
            System.out.println(jogador.getNickname());
            stmt.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "Jogador criado com Sucesso!");
        } 
        catch (SQLException ex) 
        {
            JOptionPane.showMessageDialog(null, "Erro ao salvar: " + ex);
        }
        finally
        {
            ConexaoComBanco.closeConnection(con, stmt);
        }
    }
    
    
    public void update(Jogador jogador, String mensagem)
    {
        Connection con = ConexaoComBanco.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        String resultado = "";
        int acao = 0;
        
        try 
        {
            //busca o último id criado
            stmt = con.prepareStatement("SELECT * FROM jogador ORDER BY id DESC LIMIT 1");
            rs = stmt.executeQuery();
            
            //busca do banco para atualizar
            while (rs.next())
            {    
                jogador.setNickname(rs.getString("nickname"));
                
                
                
                
                if (mensagem.contains("perdeu"))
                {
                    jogador.setDerrotas(rs.getInt("derrotas"));
                    jogador.setDerrotas(jogador.getDerrotas() + 1);
                    resultado = "UPDATE jogador SET nickname = ?, derrotas = ? ORDER BY id DESC LIMIT 1";
                    acao = jogador.getDerrotas();
                    System.out.println("numero perdeu" + jogador.getDerrotas());
                }

                if (mensagem.contains("ganhou"))
                {
                    jogador.setVitorias(rs.getInt("vitorias"));
                    jogador.setVitorias(jogador.getVitorias() + 1);
                    resultado = "UPDATE jogador SET nickname = ?, vitorias = ? ORDER BY id DESC LIMIT 1";
                    acao = jogador.getVitorias();
                    System.out.println("numero ganhou" + jogador.getVitorias());
                }

                if (mensagem.contains("empate"))
                {
                    jogador.setEmpates(rs.getInt("empates"));
                    jogador.setEmpates(jogador.getEmpates()+ 1);
                    resultado = "UPDATE jogador SET nickname = ?, empates = ? ORDER BY id DESC LIMIT 1";
                    acao = jogador.getEmpates();
                    System.out.println("numero empates:" + jogador.getEmpates());
                }
            }
            
            stmt = con.prepareStatement(resultado);
            
            stmt.setString(1, jogador.getNickname());
            stmt.setInt(2, acao);
            
            stmt.executeUpdate();
            System.out.println(jogador.getNickname());
            
            //JOptionPane.showMessageDialog(null, "Resultado atualizado com Sucesso!");
        } 
        catch (SQLException ex) 
        {
            JOptionPane.showMessageDialog(null, "Erro ao atualizar: " + ex);
        }
        finally
        {
            ConexaoComBanco.closeConnection(con, stmt);
        }
    }
    
    
    public List<Jogador> read()
    {
        Connection con = ConexaoComBanco.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        java.util.List<Jogador> jogadores = new ArrayList<>();
        
        try 
        {
            stmt = con.prepareStatement("SELECT * FROM Jogador ORDER BY vitorias DESC");
            rs = stmt.executeQuery();
            
            while (rs.next())
            {
                Jogador jogador = new Jogador();
                
                jogador.setId(rs.getInt("id"));
                jogador.setNickname(rs.getString("nickname"));
                jogador.setVitorias(rs.getInt("vitorias"));
                jogador.setDerrotas(rs.getInt("derrotas"));
                jogador.setEmpates(rs.getInt("empates"));
                jogadores.add(jogador);
            }
                    
        } 
        catch (SQLException ex) 
        {
            JOptionPane.showMessageDialog(null, "Erro ao listar: " + ex);
        }
        finally
        {
            ConexaoComBanco.closeConnection(con, stmt, rs);
        }
        
        return jogadores;
        
        
    }
    
    
}
