public class Aeroportos {
    static ListaSimplesDesordenada<Aeroporto> listaDeAeroportos = new ListaSimplesDesordenada<>();
    //static int indiceAero;
    static String nomeCidade = null;
    static String codAeroporto = null;



    public static void cadastraAeroporto()throws Exception{

        ListaSimplesDesordenada<Aeroporto> listaCopia1 = (ListaSimplesDesordenada<Aeroporto>) listaDeAeroportos.clone();
        ListaSimplesDesordenada<Aeroporto> listaCopia2 = (ListaSimplesDesordenada<Aeroporto>) listaDeAeroportos.clone();


        System.out.println("*************** Cadastro de Aeroporto *****************");
        System.out.println();

        /*
        System.out.println("Digite o indice do Aeroporto: ");
        indiceAero = Teclado.getUmInt();

        if(indiceAero<0){
            throw new Exception("Indice invalido");
        }

        for (int i = 0; i < listaDeAeroportos.getQuantidade(); i++) {
            if (indiceAero == listaCopia1.recupereItemDoInicio().getIndiceAeroporto()) {
                throw new Exception("Já existe um Aeroporto com este indece !!!");
            }
            listaCopia1.removaItemDoInicio();
        }

         */

        System.out.println("Digite o Nome da cidade do Aeroporto: ");
        nomeCidade = Teclado.getUmString();
        nomeCidade = nomeCidade.toUpperCase();

        if (nomeCidade == null || nomeCidade.equals("")) {
            throw new Exception("Não foi fornecido nenhum nome!!!");
        }

        System.out.println("Digite o código do Aeroporto: ");
        codAeroporto = Teclado.getUmString();

        codAeroporto = codAeroporto.toUpperCase();

        if(codAeroporto == null || codAeroporto.equals("")){
            throw new Exception("O Aeroporto deve conter um codigo !!!");
        }

        for (int i = 0; i < listaDeAeroportos.getQuantidade(); i++) {
            if (codAeroporto.equals(listaCopia2.recupereItemDoInicio().getCodigoAeroporto())) {
                throw new Exception("Já existe um Aeroporto com este código !!!");
            }
            listaCopia2.removaItemDoInicio();
        }

        ListaSimplesDesordenada<Voo>listaVoos = new ListaSimplesDesordenada<>();

        Aeroporto aeroporto = new Aeroporto(nomeCidade, codAeroporto, listaVoos);

        System.out.println("Aeroporto cadastrado com sucesso!");

        listaDeAeroportos.guardeUmItemNoFinal(aeroporto);

        System.out.println("**************** Lista de Aeroportos *****************");
        System.out.println(listaDeAeroportos);


    }

    public static Aeroporto recuperaAeroporto(String codAeroporto) throws Exception {

        ListaSimplesDesordenada<Aeroporto> listaCopia1 = (ListaSimplesDesordenada<Aeroporto>) listaDeAeroportos.clone();

        Aeroporto a1 = new Aeroporto(codAeroporto);

        for(int i=0; i<listaDeAeroportos.getQuantidade(); i++){
            if(listaCopia1.recupereItemDoInicio().getCodigoAeroporto().equals(a1.getCodigoAeroporto())){
                a1 = listaCopia1.recupereItemDoInicio();
                break;
            }
            listaCopia1.removaItemDoInicio();
        }

        return a1;
    }

    public static void insereVoo(Aeroporto a1, Voo v1) throws Exception {

        if(a1 == null)
            throw new Exception("Aeroporto nao pode ser nulo!");

        if(v1 == null)
            throw new Exception("Lista de Voos nao pode ser nulo!");

        //a1.getListaDeVoos().guardeUmItemNoFinal(v1);
        a1.getListaDeVoos().guardeUmItemNoFinal(v1);


    }

    /* Como eu queria a remoção
    public static void removaVoo(Aeroporto a1, Voo v1) throws Exception {
        if(a1 == null)
            throw new Exception("Aeroporto nao pode ser nulo!");

        if(v1 == null)
            throw new Exception("Voo nao pode ser nulo!");

        a1.removaVoo(v1);
    }
     */

    public void excluiAeroporto(){

    }

    public String listaAeroportos(){
        String ret = "";


        return ret;
    }

}
