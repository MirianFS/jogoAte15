package Modelo;

import br.ufsc.inf.leobr.cliente.Jogada;

public class Jogador implements Jogada{
    
    protected boolean jogadorDaVez;
    protected boolean vencedor;
    protected String nome;
    protected int[] posicao = new int[5];
    protected int numeroDeVitorias;
    protected int posicaoLivre = 0;
    
    public Jogador (String nome){
        this.nome = nome;
    }
    public Jogador (String nome, String cor, int[] posicao){
      this.nome = nome;
      this.posicao = posicao;
    }
    
    public int calcularPontuacaoAtual (){
        int pontuacaoAtual = 0;
        for(int i=0; i<posicao.length; i++){
            pontuacaoAtual = pontuacaoAtual + posicao[i];
        }
        return pontuacaoAtual;
    }
    
    public void calcularPontuacao(){
        int potuacaAtual = 0;
        int posibilidade[] = new int[20];
        
        // posicoes 1 e 2
        posibilidade[0] =posicao[1]+posicao[2];
        
        // posicoes 1 e 3
        posibilidade[1] =posicao[1]+posicao[3];
        
        //posicoes 1 e 4
        posibilidade[2] =posicao[1]+posicao[4];
        // posicoes 1 e 5
        posibilidade[3] =posicao[1]+posicao[5];
        
        // posicoes 2 e 3
        posibilidade[4] =posicao[2]+posicao[3];
        
        //posicoes 2 e 4
        posibilidade[5] =posicao[2]+posicao[4];
        
        // posicoes 2 e 5
        posibilidade[6] =posicao[2]+posicao[5];
        
        // posicoes 3 e 4
        posibilidade[7] =posicao[3]+posicao[4];
        
        // posicoes 3 e 5
        posibilidade[8] =posicao[3]+posicao[5];
        
        // posicoes 4 e 5
        posibilidade[9] =posicao[4]+posicao[5];
        
        // posicoes 1,2 e 3
        posibilidade[10] =posicao[1]+posicao[2]+posicao[3];
        
        // posicoes 1,2 e 4
        posibilidade[11] =posicao[1]+posicao[2]+posicao[4];
        
        // posicoes 1, 2 e 5
        posibilidade[12] =posicao[1]+posicao[2]+posicao[5];
        
        //posicoes 1, 3 e 4
        posibilidade[13] =posicao[1]+posicao[3]+posicao[4];
        
        // posicoes 1,3 e 5
        posibilidade[14] =posicao[1]+posicao[3]+posicao[5];
        
        // posicoes 1,4 e 5
        posibilidade[15] =posicao[1]+posicao[4]+posicao[5];
        
        // posicoes 2,3 e 4
        posibilidade[16] =posicao[2]+posicao[3]+posicao[4];
        
        //posicoes 2,3 e 5
        posibilidade[17] =posicao[2]+posicao[3]+posicao[5];
        
        //posicoes 2,4 e 5
        posibilidade[18] =posicao[2]+posicao[4]+posicao[5];
        
        //posicoes 3,4 e 5
        posibilidade[19] =posicao[3]+posicao[4]+posicao[5];
        
    }
    
    public void gravarJogada(int novaJogada){
        posicao[posicaoLivre] = novaJogada;
        posicaoLivre++;
    }
    
    public void ehVencedor (){
        if(calcularPontuacaoAtual() == 15)
            vencedor = true;
        else
            vencedor = false;
    }

    public boolean isJogadorDaVez() {
        return jogadorDaVez;
    }

    public void setJogadorDaVez(boolean jogadorDaVez) {
        this.jogadorDaVez = jogadorDaVez;
    }

    public boolean isVencedor() {
        return vencedor;
    }

    public void setVencedor(boolean vencedor) {
        this.vencedor = vencedor;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int[] getPosicao() {
        return posicao;
    }

    public void setPosicao(int[] posicao) {
        this.posicao = posicao;
    }    

    public int getNumeroDeVitorias() {
        return numeroDeVitorias;
    }

    public void setNumeroDeVitorias(int numeroDeVitorias) {
        this.numeroDeVitorias = numeroDeVitorias;
    }
    
}
