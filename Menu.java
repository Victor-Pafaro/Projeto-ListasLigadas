public class Menu {

    public static char mostraMenu() throws Exception {

        char opcao = ' ';

        System.out.println();
        System.out.println("******************** MENU ************************** ");
        System.out.println("(a) Inserir um Aeroporto ");
        System.out.println("(b) Cadastrar um Voo ");
        System.out.println("(c) Remover um vôo");
        System.out.println("(d) Listar vôos de um Aeroporto");
        System.out.println("(e) Sair ");
        System.out.println("Qual sua opcao? ");
        opcao = Character.toLowerCase(Teclado.getUmChar());

        return opcao;
    }
}
