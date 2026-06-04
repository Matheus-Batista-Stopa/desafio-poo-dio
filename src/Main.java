import br.com.dio.desafio.dominio.*;

public class Main {
    public static void main(String[] args) {

        Bootcamp bootcamp1 = new Bootcamp("Backend Alma Viva", "Java para Backend", 60);
        Bootcamp bootcamp2 = new Bootcamp("Backend Goblant", "Java para Backend");

        Conteudo conteudo1 = new Mentoria("Apresentação", "Apresentação do Bootcamp Backend Alma Viva", "01/06/2026 20:00");
        Conteudo conteudo2 = new Mentoria("Apresentação", "Apresentação do Bootcamp Backend Goblant", "08/06/2026 21:00");
        Conteudo conteudo3 = new Curso("Fundamentos", "Fundamentos de Java", 6);
        Conteudo conteudo4 = new Curso("Spring", "FrameWork Spring", 5);
        Conteudo conteudo5 = new Curso("SpringBoot", "SpringBoot", 7);

        bootcamp1.adicionarConteudo(conteudo1);
        bootcamp1.adicionarConteudo(conteudo3);
        bootcamp1.adicionarConteudo(conteudo4);
        bootcamp1.adicionarConteudo(conteudo5);

        bootcamp2.adicionarConteudo(conteudo2);
        bootcamp2.adicionarConteudo(conteudo3);
        bootcamp2.adicionarConteudo(conteudo4);

        Dev dev1 = new Dev("Matheus");
        Dev dev2 = new Dev("Kayky");
        Dev dev3 = new Dev("Carlos");

        bootcamp1.inscreverDev(dev1);
        bootcamp1.inscreverDev(dev2);
        bootcamp2.inscreverDev(dev3);

        System.out.println(bootcamp1.getDevsInscritos());
        System.out.println("=======");
        System.out.println(bootcamp2.getDevsInscritos());

        dev1.progredir();
        dev2.progredir();
        dev3.progredir();
        System.out.println(dev1);
        System.out.println(dev2);
        System.out.println(dev3);

        System.out.println("=======");

        dev1.progredir();
        dev2.progredir();
        System.out.println(dev1);
        System.out.println(dev2);

        System.out.println("=======");

        dev1.progredir();
        System.out.println(dev1);

        System.out.println("=======");

        dev1.progredir();
        System.out.println(dev1);

        System.out.println("=======");

        bootcamp2.inscreverDev(dev1);
        System.out.println(dev1);

        System.out.println("=======");

        dev1.progredir();
        System.out.println(dev1);

    }

}
