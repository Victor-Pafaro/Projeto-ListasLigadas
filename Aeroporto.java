public class Aeroporto implements Cloneable{

    //private int indiceAeroporto;
    private String nomeCidade;
    private String codigoAeroporto;
    ListaSimplesDesordenada<Voo> listaDeVoos = new ListaSimplesDesordenada<>();

    public Aeroporto(String cidade, String codigo, ListaSimplesDesordenada<Voo> voos){
        this.nomeCidade = cidade;
        this.codigoAeroporto = codigo;
        this.listaDeVoos = voos;
    }

    /*
    public Aeroporto(int indice, String cidade, String codigo, ListaSimplesDesordenada<Voo> voos){
        this.indiceAeroporto = indice;
        this.nomeCidade = cidade;
        this.codigoAeroporto = codigo;
        this.listaDeVoos = voos;
    }
     */
    public Aeroporto(/*int indice,*/ String cidade, String codigo){
        //this.indiceAeroporto = indice;
        this.nomeCidade = cidade;
        this.codigoAeroporto = codigo;
    }

    public Aeroporto(String codigo){
        this.codigoAeroporto = codigo;
    }



    /****** Getters ******/
    /*
    public int getIndiceAeroporto() {
        return indiceAeroporto;
    }

     */

    public String getNomeCidade() {
        return nomeCidade;
    }

    public String getCodigoAeroporto() {
        return codigoAeroporto;
    }

    public ListaSimplesDesordenada<Voo> getListaDeVoos() {
        return this.listaDeVoos;
    }

    /****** Setters ******/
    /*
    public void setIndiceAeroporto(int indiceAeroporto) {
        this.indiceAeroporto = indiceAeroporto;
    }

     */

    public void setNomeCidade(String nomeCidade) {
        this.nomeCidade = nomeCidade;
    }

    public void setCodigoAeroporto(String codigoAeroporto) {
        this.codigoAeroporto = codigoAeroporto;
    }

    public void setListaDeVoos(Voo novoVoo) throws Exception {
        listaDeVoos.guardeUmItemNoFinal(novoVoo);
    }


    public int qtdDeVoos(){
        return this.listaDeVoos.getQuantidade();
    }

    /*Como eu queria a remoção
    public void removaVoo(Voo voo) throws Exception {
        this.listaDeVoos.removaItemIndicado(voo);
    }

     */


    public void removaUmVoo(ListaSimplesDesordenada<Voo>listaVoos, int numVoo)throws Exception{

        ListaSimplesDesordenada<Voo> listaCopia = (ListaSimplesDesordenada<Voo>) listaDeVoos.clone();

        ListaSimplesDesordenada<Voo> lista = new ListaSimplesDesordenada<>();

        if(listaVoos == null){
            throw new Exception();
        }

        for(int i=0; i<listaDeVoos.getQuantidade();i++){
            if(numVoo==listaCopia.recupereItemDoInicio().getNumeroDoVoo()){
                listaCopia.removaItemDoInicio();
            }else {
                lista.guardeUmItemNoInicio(listaCopia.recupereItemDoInicio());
                listaCopia.removaItemDoInicio();
            }
        }

        this.listaDeVoos = lista;
    }


    /******* Metodos obrigatórios ******/

    @Override
    public String toString(){
        String ret = "";

        ret = "[" + /*this.indiceAeroporto + "-" +*/ this.nomeCidade + ":" + this.codigoAeroporto + "] " + "Lista de vôos: " + this.listaDeVoos + "\n"; //+"]" ;

        return ret;
    }

    @Override
    public boolean equals (Object obj){
        if (this==obj)
            return true;

        if (obj==null)
            return false;

        if (!(obj instanceof Aeroporto))
            return false;

        Aeroporto aero = (Aeroporto)obj;

        /*
        if (this.indiceAeroporto != aero.indiceAeroporto)
            return false;
         */

        if (!this.nomeCidade.equals(aero.nomeCidade))
            return false;

        if (!this.codigoAeroporto.equals(aero.codigoAeroporto))
            return false;

        return true;
    }

    @Override
    public int hashCode() {

        final int PRIMO = 13;

        int ret=5;

       // ret = PRIMO * ret +  Integer.valueOf(this.indiceAeroporto).hashCode();

        if(this.nomeCidade != null)
            ret = PRIMO * ret + this.nomeCidade.hashCode();

        if(this.codigoAeroporto != null)
            ret = PRIMO * ret + this.codigoAeroporto.hashCode();

        if (ret<0) ret = -ret;

        return ret;

    }

    /****** Clone e Construtor de cópia ********/
    public Aeroporto (Aeroporto modelo) throws Exception
    {
        if (modelo==null)
            throw new Exception ("Modelo ausente");

        //this.indiceAeroporto = modelo.indiceAeroporto;
        this.nomeCidade = modelo.nomeCidade;
        this.codigoAeroporto = modelo.codigoAeroporto;
        this.listaDeVoos  = (ListaSimplesDesordenada<Voo>) modelo.listaDeVoos.clone();
    }
    public Object clone ()
    {
       Aeroporto ret=null;

        try
        {
            ret = new Aeroporto (this);
        }
        catch (Exception erro)
        {} // sei que this NUNCA é null e o contrutor de copia da erro quando seu parametro é null

        return ret;
    }




}
