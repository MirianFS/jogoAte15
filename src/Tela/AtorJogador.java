package Tela;

import Controle.Tabuleiro;
import br.ufsc.inf.leobr.cliente.exception.NaoConectadoException;
import br.ufsc.inf.leobr.cliente.exception.NaoJogandoException;
import rede.AtorNetGames;

// só copiei
public class AtorJogador {

    protected Tabuleiro tabuleiro;
    protected AtorNetGames rede;
    protected String idUsuario;
    protected TelaInicial tela;

    public AtorJogador(TelaInicial tela, Tabuleiro tabuleiro) {
        this.tabuleiro = tabuleiro;
        this.tela = tela;
        this.rede = new AtorNetGames(this);
        tela.setVisible(true);
    }

    public void conectar(String servidor,String idUsuario) throws Exception {
        this.idUsuario = idUsuario;
        rede.conectar(servidor,idUsuario);
    }
    
    public void IniciarPartida() throws NaoConectadoException {
        rede.iniciarPartida();
    }
    
    public Tabuleiro getTabuleiro() {
        return this.tabuleiro;
    }
    
    public void desconectar() throws NaoConectadoException {
        rede.desconectar();
    }

    /*
    public void realizaJogada(int tipoMovimento, int posicao) throws Exception {
        //tratamento de jogador da vez
        if (tabuleiro.getJogador1().isJogadorDaVez()) {
            tabuleiro.realizaJogada(tipoMovimento, posicao);
            if (tabuleiro.getJogador1().isVencedor()) {
                this.notificar("Venceu a campanha");
                if (tabuleiro.getJogador1().getNumeroDeVitorias() < 2) {
                    this.notificar("Uma nova campanha será iniciada, o outro jogador inicia. Aguarde.");
                } else {
                    this.notificar("Venceu o jogo");
                }
            }
            //enviar a jogada
            this.enviarJogada();

            this.tela.limpar();
            this.tela.setaImagemJogador();
        } else {
            throw new Exception("Não é sua vez");
        }
    }
    */


    public void notificar(String mensagem) {
        tela.notificar(mensagem);
    }

    public void notificarErro(String erro) {
        this.tabuleiro.setPartidaEmAndamento(false);
        tela.notificar(erro);
    }
    
    public void enviarJogada() throws NaoJogandoException {
        this.rede.enviarJogada(this.tabuleiro);
    }

    /*
    public void receberJogada(Tabuleiro tab) throws NaoConectadoException, NaoJogandoException {
        if (tab == null) {
            int opt = this.tela.perguntar("O outro jogador deseja reiniciar a partida. Você iniciará com o lado branco.");
            if (opt == 0) {
                this.reiniciar();
                return;
            } else {
                this.enviarJogada();
                return;
            }
        }
        if (tab.isReiniciado()) {
            this.tabuleiro = tab;
            this.reiniciar();
        }
        this.tabuleiro.setJogador1(tab.getJogador2());
        this.tabuleiro.setJogador2(tab.getJogador1());
        this.tabuleiro.setReiniciado(false);

        this.tabuleiro.getJogador1().setJogadorDaVez(true);
        // se ataque atualiza interface
        if (tab.getUltimoMovimento() == 1) {
            this.tela.limpar();
            this.tela.atualizaInterface(tab.getUltimaPosClicJogador1());

        }
        if (this.tabuleiro.getJogador2().isVencedor()) {
            this.notificar("Derrota!");
            this.tabuleiro.setPartidaEmAndamento(false);
            if (tabuleiro.getJogador2().getNumeroDeVitorias() < 2) {
                this.notificar("Uma nova campanha será iniciada, você inicia.");
                this.iniciarNovaCampanha(1);
            } else {
                this.tela.notificar("Perdeu a melhor de 3");
                return;
            }
        }
        this.tela.notificar("É a sua vez " + this.tabuleiro.getJogador1().getNome());
        tela.setaImagemJogador();
    }

    public void iniciarNovaCampanha(Integer posicao) {
        tabuleiro.setPartidaEmAndamento(true);
        tela.limpar();
        tela.notificar("Nova campanha iniciada");
        tela.iniciarPartida.setEnabled(false);
        tela.conectar.setEnabled(false);
        tabuleiro.getJogador1().setCodigo(posicao);
        tabuleiro.getJogador1().criarPosicoes();
        tabuleiro.getJogador1().obterPosicaoInicial();
        tabuleiro.getJogador2().setCodigo(posicao == 1 ? 2 : 1);
        tabuleiro.getJogador2().criarPosicoes();
        tabuleiro.getJogador2().obterPosicaoInicial();
        tela.setaImagemJogador();

    }
    */

}
