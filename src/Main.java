import br.com.dio.desafio.dominio.*;

import java.time.Clock;
import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        Curso curso = new Curso();
        Mentoria mentoria = new Mentoria();

        mentoria.setTitulo("Mentoria do Curso java");
        mentoria.setDescricao("Feita pela Dio");
        mentoria.setData(LocalDate.now());


        curso.setTitulo("Curso Java");
        curso.setDescricao("Curso teste feito para a analise das operações de Poo");
        curso.setCargaHoraria(3);

        Curso curso1 = new Curso();
        curso1.setTitulo("Curso Fireworks Java");
        curso1.setDescricao("Curso de fireworks do Java");
        curso1.setCargaHoraria(5);

        BootCamp bootCamp = new BootCamp();
        bootCamp.setNome("Bootcamp Java.");
        bootCamp.setDescricao("Bootcamp Java feito com Poo e seus fireworks");
        bootCamp.getConteudosBootCamp().add(curso);
        bootCamp.getConteudosBootCamp().add(curso1);
        bootCamp.getConteudosBootCamp().add(mentoria);

        Dev devGabriel = new Dev();
        devGabriel.setNome("Gabriel");
        devGabriel.inscreverBootcamp(bootCamp);
        System.out.println("Conteúdos Inscritos(Gabriel): " + devGabriel.getConteudosInscritos());
        devGabriel.progredir();
        System.out.println("----");
        System.out.println("Conteúdos Concluídos(Gabriel): "+devGabriel.getConteudosInscritos());
        System.out.println("Conteúdos Inscritos(Gabriel): "+ devGabriel.getConteudosInscritos());
        System.out.println("XP adquirido: " + devGabriel.calcularXPTotal());

        System.out.println("--------------------------------");

        Dev devCraudin = new Dev();
        devCraudin.setNome("Craudin");
        devCraudin.inscreverBootcamp(bootCamp);
        System.out.println("Conteúdos Inscritos(Craudin): " + devCraudin.getConteudosInscritos());
        devCraudin.progredir();
        devCraudin.progredir();
        devCraudin.progredir();
        System.out.println("----");
        System.out.println("Conteúdos Concluídos(Craudin): "+ devCraudin.getConteudosConcluidos());
        System.out.println("Conteúdos Inscritos(Craudin):" + devCraudin.getConteudosInscritos());
        System.out.println("XP adquirido: "+ devCraudin.calcularXPTotal());
    }
}