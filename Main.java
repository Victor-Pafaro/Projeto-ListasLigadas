public class Main {
    public static void main(String[] args) throws Exception {

        Voo vooBrasilia1 = new Voo(107,"SSA");
        ListaSimplesDesordenada<Voo>listaVooBrasilia = new ListaSimplesDesordenada<>();
        listaVooBrasilia.guardeUmItemNoFinal(vooBrasilia1);


        Voo vooBH1 = new Voo(214,"SSA");
        Voo vooBH2  = new Voo(555,"GIG");
        Voo vooBH3  = new Voo(101,"GRU");
        ListaSimplesDesordenada<Voo>listaVooBH = new ListaSimplesDesordenada<>();
        listaVooBH.guardeUmItemNoFinal(vooBH1);
        listaVooBH.guardeUmItemNoFinal(vooBH2);
        listaVooBH.guardeUmItemNoFinal(vooBH3);


        Voo vooRio1 = new Voo(554,"CNF");
        Voo vooRio2 = new Voo(90,"GRU");
        ListaSimplesDesordenada<Voo>listaVooRio = new ListaSimplesDesordenada<>();
        listaVooRio.guardeUmItemNoFinal(vooRio1);
        listaVooRio.guardeUmItemNoFinal(vooRio2);


        Voo vooSP1 = new Voo(50,"BSB");
        Voo vooSP2 = new Voo(89,"GIG");
        Voo vooSP3 = new Voo(102,"CNF");
        ListaSimplesDesordenada<Voo>listaVooSP = new ListaSimplesDesordenada<>();
        listaVooSP.guardeUmItemNoFinal(vooSP1);
        listaVooSP.guardeUmItemNoFinal(vooSP2);
        listaVooSP.guardeUmItemNoFinal(vooSP3);


        Voo vooSalvador1 = new Voo(215,"CNF");
        ListaSimplesDesordenada<Voo>listaVooSalvador = new ListaSimplesDesordenada<>();
        listaVooSalvador.guardeUmItemNoFinal(vooSalvador1);

        Aeroporto aeroBrasilia = new Aeroporto("BRASILIA","BSB", listaVooBrasilia);

        Aeroporto aeroBH = new Aeroporto("BELO HORIZONTE","CNF", listaVooBH);

        Aeroporto aeroRio = new Aeroporto("RIO DE JANEIRO","GIG", listaVooRio);

        Aeroporto aeroSP = new Aeroporto("SÃO PAULO","GRU", listaVooSP);

        Aeroporto aeroSalvador = new Aeroporto("SALVADOR","SSA", listaVooSalvador);

        //Aeroportos.listaDeAeroportos.guardeUmItemNoFinal(aeroBrasilia);
        //Aeroportos.listaDeAeroportos.guardeUmItemNoFinal(aeroBH);
        //Aeroportos.listaDeAeroportos.guardeUmItemNoFinal(aeroRio);
        //Aeroportos.listaDeAeroportos.guardeUmItemNoFinal(aeroSP);
        //Aeroportos.listaDeAeroportos.guardeUmItemNoFinal(aeroSalvador);

        //System.out.println(Aeroportos.listaDeAeroportos);


        char opcao = ' ';

        do{
            try {
                opcao = Menu.mostraMenu();
            }catch (Exception e){
                System.err.println(e.getMessage());
                System.err.flush();
            }
            switch (opcao){
                case 'a':
                try{
                    Aeroportos.cadastraAeroporto();
                    break;
                }catch (Exception e){
                    System.err.println(e.getMessage());
                    System.err.flush();
                    break;
                }

                case 'b':
                try{
                    Voos.cadastraVoo();
                    break;
                }catch (Exception e){
                    System.err.println(e.getMessage());
                    System.err.flush();
                    break;
                }

                case 'c':
                    try {
                        Voos.removaVoo();
                        break;
                    }catch (Exception e){
                        System.err.println(e.getMessage());
                        System.err.flush();
                        break;
                    }

                case 'd':
                    try {
                        System.out.println(Voos.listaVoos());
                        break;
                    }catch (Exception e){
                        System.err.println(e.getMessage());
                        System.err.flush();
                        break;
                    }

                case 'e':
                    try {
                        System.out.println("Até mais!");
                        System.exit(0);
                    }catch (Exception e){
                        System.err.println(e.getMessage());
                        System.err.flush();
                        break;
                    }
                default:
                    System.err.println("Por favor, digite alguma opção que esteja no menu!");
            }

        }while (opcao!='e');
    }
}