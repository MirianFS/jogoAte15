package rede;

import br.ufsc.inf.leobr.cliente.Jogada;
import br.ufsc.inf.leobr.cliente.OuvidorProxy;
import br.ufsc.inf.leobr.cliente.Proxy;
import br.ufsc.inf.leobr.cliente.exception.NaoConectadoException;
import br.ufsc.inf.leobr.cliente.exception.NaoJogandoException;
import Controle.Tabuleiro;
import Tela.AtorJogador;
import javax.swing.JOptionPane;

public class AtorNetGames implements OuvidorProxy {

    private static final long serialVersionUID = 0L;
    protected AtorJogador atorJogador;
    protected Proxy proxy;

    public AtorNetGames(AtorJogador ator) {
        super();
        this.atorJogador = ator;
        this.proxy = Proxy.getInstance();
        this.proxy.addOuvinte(this);
    }

    public void conectar(String servidor, String idJogador) throws Exception {
        proxy.conectar(servidor, idJogador);
    }

    public void desconectar() throws NaoConectadoException {
        proxy.desconectar();
    }

    public void iniciarPartida() throws NaoConectadoException {
        proxy.iniciarPartida(2);
    }

    public void reiniciarPartida() throws NaoConectadoException, NaoJogandoException {
        proxy.reiniciarPartida();
    }

    public void iniciarNovaPartida(Integer posicao) {
        atorJogador.iniciarNovaPartida(posicao);
    }

    public void finalizarPartidaComErro(String message) {
        this.atorJogador.notificarErro("O outro jogador desconectou da partida.");
    }

    public void receberMensagem(String msg) {
        this.atorJogador.notificar(msg);
    }

    public void receberJogada(Jogada jogada) {
        Tabuleiro tab = (Tabuleiro) jogada;
        
        try {
            this.atorJogador.receberJogada(tab);
        } catch (NaoConectadoException e) {
            e.printStackTrace();
        } catch (NaoJogandoException e) {
            e.printStackTrace();
        }
        
    }

    public void tratarConexaoPerdida() {
        this.atorJogador.notificar("Conexão perdida. Por favor, conecte-se novamente.");
    }

    public void tratarPartidaNaoIniciada(String message) {
        this.atorJogador.notificarErro(
            "Não foi possível iniciar a partida.\nProvavelmente não existem outros jogadores conectados.");
    }

    public String getNomeAdversario(int posicao) {
        return proxy.obterNomeAdversarios().get(0);
    }

    public void enviarJogada(Tabuleiro tab) throws NaoJogandoException {
        Jogada jogada = (Jogada) tab;
        proxy.enviaJogada(jogada);
    }

}
