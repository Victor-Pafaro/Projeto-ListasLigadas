public class Voos {
    private static ListaSimplesDesordenada<Voo>listaDeVoos = new ListaSimplesDesordenada<>();
    static String codAeroporto = null;

    static String codAeroportoDestino = null;

    static int numDoVoo;
    public static void cadastraVoo() throws Exception {

        ListaSimplesDesordenada<Aeroporto> listaCopia1 = (ListaSimplesDesordenada<Aeroporto>) Aeroportos.listaDeAeroportos.clone();
        ListaSimplesDesordenada<Aeroporto> listaCopia2 = (ListaSimplesDesordenada<Aeroporto>) Aeroportos.listaDeAeroportos.clone();

        System.out.println("**************** Cadastro de Aeroporto  *****************");
        System.out.println();

        System.out.println("Digite o codigo do Aeroporto que voce deseja inserir um voo:");
        codAeroporto = Teclado.getUmString();
        codAeroporto = codAeroporto.toUpperCase();

        if(codAeroporto == null || codAeroporto.equals("")){
            throw new Exception("Insira o codigo do Aeroporto !!!");
        }

        Aeroporto aeroportoTeste = null;
        int i=0;
        while (i<Aeroportos.listaDeAeroportos.getQuantidade()){
            if (listaCopia1.recupereItemDoInicio().getCodigoAeroporto().equals(codAeroporto)) {
                aeroportoTeste = listaCopia1.recupereItemDoInicio();
                break;
            }
            listaCopia1.removaItemDoInicio();
            i++;
            if(i==Aeroportos.listaDeAeroportos.getQuantidade()){
                throw new Exception("Nao foi encontrado um aeroporto com este codigo");
            }
        }

        System.out.println("Insira o numero do Vôo:");
        numDoVoo = Teclado.getUmInt();
        if (numDoVoo < 0) {
            throw new Exception("Numero inválido");
        }

        Aeroporto aeroporto1 = Aeroportos.recuperaAeroporto(codAeroporto);

        /* Questionar: Quando eu altero a copia do aeroporto1 também altera o aeroporto1, porque?
        Aeroporto aeroportoClone = new Aeroporto(aeroporto1);

        for(int a=0; a<aeroporto1.qtdDeVoos(); a++) {
            if(aeroportoClone.getListaDeVoos().recupereItemDoInicio().getNumeroDoVoo() == numDoVoo)
                throw new Exception("Ja existe um vôo cadastrado com este numero neste Aeroporto");
            aeroportoClone.getListaDeVoos().removaItemDoInicio();
        }

         */


        Voo voo = new Voo(numDoVoo);

        if(voo.equals(aeroportoTeste.listaDeVoos.recupereItemIndicado(voo))){
            throw new Exception("Já existe um vôo cadastrado com esse número neste Aeroporto!");
        }


        System.out.println("Insira o código do Aeroporto de Destino: ");
        codAeroportoDestino = Teclado.getUmString();
        codAeroportoDestino = codAeroportoDestino.toUpperCase();

        if(codAeroportoDestino == null || codAeroportoDestino.equals("")){
            throw new Exception("Passe o codigo do Aeroporto destino !!!");
        }

        Aeroporto aeroporto2 = null;

        int b=0;
        while (b<Aeroportos.listaDeAeroportos.getQuantidade()){
            if (listaCopia2.recupereItemDoInicio().getCodigoAeroporto().equals(codAeroportoDestino)) {
                aeroporto2 = listaCopia2.recupereItemDoInicio();
                break;
            }

            listaCopia2.removaItemDoInicio();
            b++;

            if(b==Aeroportos.listaDeAeroportos.getQuantidade())
                throw new Exception("Nao foi encontrado um aeroporto com este codigo");

        }

        if(codAeroporto.equals(codAeroportoDestino))
            throw new Exception("Voce nao pode cadastrar um vôo com o destino do mesmo Aeroporto que você está inserindo o vôo!");

        Voo v1 = new Voo(numDoVoo, aeroporto2.getCodigoAeroporto()/*getIndiceAeroporto()*/);

        Aeroportos.insereVoo(aeroporto1, v1);

        System.out.println("Voo cadastrado com sucesso!");

        System.out.println();

        System.out.println("******************** Lista de Vôos ********************");

        System.out.println(Aeroportos.listaDeAeroportos);



    }

    public Voo recuperaVoo(){
        Voo v1 = null;

        return v1;
    }

    public static void removaVoo() throws Exception {

        ListaSimplesDesordenada<Aeroporto> listaCopia1 = (ListaSimplesDesordenada<Aeroporto>) Aeroportos.listaDeAeroportos.clone();

        ListaSimplesDesordenada<Aeroporto> listaCopia2 = (ListaSimplesDesordenada<Aeroporto>) Aeroportos.listaDeAeroportos.clone();

        System.out.println("**************** Remoção de Vôo  *****************");
        System.out.println();

        System.out.println("Digite o codigo do Aeroporto que voce deseja remover um Vôo:");
        codAeroporto = Teclado.getUmString();
        codAeroporto = codAeroporto.toUpperCase();

        if(codAeroporto == null || codAeroporto.equals("")){
            throw new Exception("Insira o codigo do Aeroporto !!!");
        }


        int i=0;
        while (i<Aeroportos.listaDeAeroportos.getQuantidade()){
            if (listaCopia1.recupereItemDoInicio().getCodigoAeroporto().equals(codAeroporto)) {
                break;
            }
            listaCopia1.removaItemDoInicio();
            i++;
            if(i==Aeroportos.listaDeAeroportos.getQuantidade()){
                throw new Exception("Nao foi encontrado um aeroporto com este codigo");
            }
        }

        System.out.println("Digite o numero do Vôo que você deseja remover: ");
        numDoVoo = Teclado.getUmInt();

        if(numDoVoo<0){
            throw new Exception("Numero de vôo invalido");
        }

        Voo voo = new Voo(numDoVoo);

        Voo v1 = null;

        Aeroporto aeroporto = null;

        for(int a=0; a< Aeroportos.listaDeAeroportos.getQuantidade(); a++){
            if(v1==null){
                v1 = listaCopia2.recupereItemDoInicio().getListaDeVoos().recupereItemIndicado(voo);
                aeroporto = listaCopia2.recupereItemDoInicio();
            }
            if(v1!=null){
                break;
            }
            listaCopia2.removaItemDoInicio();
        }

        if(v1 == null){
            throw new Exception("Numero de Vôo inexistente!!!");
        }

        //Como eu queria: Aeroportos.removaVoo(aeroporto,v1);

        Aeroportos.listaDeAeroportos.removaItemIndicado(aeroporto);

        aeroporto.removaUmVoo(aeroporto.getListaDeVoos(),numDoVoo);

        Aeroportos.listaDeAeroportos.guardeUmItemNoFinal(aeroporto);

        System.out.println("Vôo removido com sucesso!");

        //System.out.println(Aeroportos.listaDeAeroportos);

    }

    public static String listaVoos() throws Exception {

        String ret = "";

        int qtdVoos;
        ListaSimplesDesordenada<Aeroporto> listaCopia1 = (ListaSimplesDesordenada<Aeroporto>) Aeroportos.listaDeAeroportos.clone();
        ListaSimplesDesordenada<Aeroporto> listaCopia2 = (ListaSimplesDesordenada<Aeroporto>) Aeroportos.listaDeAeroportos.clone();

        System.out.println("****************  Listagem de Voos *************");
        System.out.println();

        System.out.println("Digite o código do Aeroporto que voce deseja listar os vôos: ");
        codAeroporto = Teclado.getUmString();

        codAeroporto = codAeroporto.toUpperCase();

        if (codAeroporto == null || codAeroporto.equals("")) {
            throw new Exception("Insira o codigo do Aeroporto !!!");
        }

        Aeroporto aeroporto = null;

        int i = 0;
        while (i < Aeroportos.listaDeAeroportos.getQuantidade()) {
            if (listaCopia1.recupereItemDoInicio().getCodigoAeroporto().equals(codAeroporto)) {
                aeroporto = listaCopia1.recupereItemDoInicio();
                break;
            }
            listaCopia1.removaItemDoInicio();
            i++;
            if (i == Aeroportos.listaDeAeroportos.getQuantidade()) {
                throw new Exception("Nao foi encontrado um aeroporto com este codigo");
            }
        }

            qtdVoos = aeroporto.qtdDeVoos();

            Aeroporto aeroporto2 = new Aeroporto(aeroporto.getNomeCidade(), aeroporto.getCodigoAeroporto(), aeroporto.getListaDeVoos());

            if (aeroporto.qtdDeVoos() == 0)
                aeroporto = aeroporto2;

            if (qtdVoos == 0) {
                ret += "O Aeroporto " + aeroporto.getCodigoAeroporto() + " não tem nenhum Voo cadastrado no momento!";
                return ret;
            }

            int[] numerosVoo = new int[qtdVoos];
            String[] codigoDestinoVoos = new String[qtdVoos];
            String[] nomesAeroDestino = new String[qtdVoos];

            //Aeroporto aeroportoCopia =  (Aeroporto) aeroporto.clone();


            Aeroporto aeroportoCopia = new Aeroporto(aeroporto);

            for (int a = 0; a < qtdVoos; a++) {
                numerosVoo[a] = aeroportoCopia.getListaDeVoos().recupereItemDoInicio().getNumeroDoVoo();
                codigoDestinoVoos[a] = aeroportoCopia.getListaDeVoos().recupereItemDoInicio().getCodAeroDestino();
                aeroportoCopia.getListaDeVoos().removaItemDoInicio();
            }

            boolean continua = true;

            int b = 0;

            int c = 0;

            while (continua) {
                while (codigoDestinoVoos[b] != listaCopia2.recupereItemDoInicio().getCodigoAeroporto()) {
                    if (b < codigoDestinoVoos.length - 1)
                        b++;
                    else {
                        b = 0;
                        listaCopia2.removaItemDoInicio();
                    }
                }

                if (c < qtdVoos) {
                    nomesAeroDestino[b] = listaCopia2.recupereItemDoInicio().getNomeCidade();
                    listaCopia2.removaItemDoInicio();
                    b = 0;
                    c++;
                    if (c < qtdVoos == false) {
                        continua = false;
                    }
                } else {
                    continua = false;
                }
            }

            System.out.println("Listagem de Vôos do Aeroporto: " + aeroporto.getNomeCidade());
            for (int d = 0; d < qtdVoos; d++) {
                ret += "Numero do voo: " + numerosVoo[d] + " | Nome da Cidade Destino: " + nomesAeroDestino[d] + "\n";
            }

        return ret;
    }
}
