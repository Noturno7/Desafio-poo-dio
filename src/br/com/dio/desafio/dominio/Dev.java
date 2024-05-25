package br.com.dio.desafio.dominio;

import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;

public class Dev {

    private String nome;
    private Set<Conteudo> conteudosInscritos = new LinkedHashSet<>();
    private Set<Conteudo> conteudosConcluidos = new LinkedHashSet<>();

    // Lógica para se inscrever em um bootcamp.
    public void inscreverBootcamp(BootCamp bootCamp){
        this.conteudosInscritos.addAll(bootCamp.getConteudosBootCamp());
        bootCamp.getDevsInscritos().add(this);
    }
    // Lógica de quando o dev concluí um curso.
    public void progredir(){
        Optional<Conteudo> primeiroConteudo = this.conteudosInscritos.stream().findFirst();
        if(primeiroConteudo.isPresent()){
            this.conteudosInscritos.remove(primeiroConteudo.get());
            this.conteudosConcluidos.add(primeiroConteudo.get());
        } else{
            System.err.println("Você não está matriculado em nenhum conteúdo.");
        }
    }
    // Lógica para calcular o xp total adquirido.
    public double calcularXPTotal(){
    return this.conteudosConcluidos.stream().mapToDouble(conteudo -> conteudo.calcularXP()).sum();
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Set<Conteudo> getConteudosInscritos() {
        return conteudosInscritos;
    }

    public void setConteudosInscritos(Set<Conteudo> conteudosInscritos) {
        this.conteudosInscritos = conteudosInscritos;
    }

    public Set<Conteudo> getConteudosConcluidos() {
        return conteudosConcluidos;
    }

    public void setConteudosConcluidos(Set<Conteudo> conteudosConcluidos) {
        this.conteudosConcluidos = conteudosConcluidos;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Dev dev = (Dev) o;
        return Objects.equals(nome, dev.nome) && Objects.equals(conteudosInscritos, dev.conteudosInscritos) && Objects.equals(conteudosConcluidos, dev.conteudosConcluidos);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome, conteudosInscritos, conteudosConcluidos);
    }
}
