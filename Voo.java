public class Voo implements Cloneable{

    private int numeroDoVoo;

    //private int indiceCidadeDestino;

    private String codAeroDestino;

    public Voo(int numVoo, String codAeroDestino/*int indiceCidadeDestino*/){
        this.numeroDoVoo = numVoo;
        this.codAeroDestino = codAeroDestino;
        //this.indiceCidadeDestino = indiceCidadeDestino;
    }

    public Voo(int numVoo){
        this.numeroDoVoo = numVoo;
    }

    /****** Getters ******/
    public int getNumeroDoVoo() {
        return numeroDoVoo;
    }

    public String getCodAeroDestino() {
        return codAeroDestino;
    }

    /*
    public int getIndiceCidadeDestino(){
        return indiceCidadeDestino;
    }
     */

    /****** Setters ******/
    public void setNumeroDoVoo(int numeroDoVoo){
        this.numeroDoVoo = numeroDoVoo;
    }

    /*

    public void setIndiceCidadeDestino(int indiceCidadeDestino) {
        this.indiceCidadeDestino = indiceCidadeDestino;
    }
     */

    /******* Metodos obrigatórios ******/
    @Override
    public String toString(){
        String ret = "(N°:" + this.numeroDoVoo + ", Aeroporto Destino:" + this.codAeroDestino/*this.indiceCidadeDestino*/ +")";

        return ret;
    }

    @Override
    public boolean equals (Object obj){
        if (this==obj)
            return true;

        if (obj==null)
            return false;

        if (!(obj instanceof Voo))
            return false;

        Voo voo = (Voo)obj;

        if (this.numeroDoVoo == voo.numeroDoVoo)
            return true;

        /*
        if (this.indiceCidadeDestino != voo.indiceCidadeDestino)
            return false;
         */

        return false;
    }

    @Override
    public int hashCode() {

        final int PRIMO = 13;

        int ret=5;

        ret = PRIMO * ret +  Integer.valueOf(this.numeroDoVoo).hashCode();
        ret = PRIMO * ret +  this.codAeroDestino.hashCode();
        //ret = PRIMO * ret +  Integer.valueOf(this.indiceCidadeDestino).hashCode();

        if (ret<0) ret = -ret;

        return ret;

    }

    /****** Construtor de cópia ********/
    public Voo (Voo modelo) throws Exception
    {
        if (modelo==null)
            throw new Exception ("Modelo ausente");

        this.numeroDoVoo = modelo.numeroDoVoo;
        this.codAeroDestino = modelo.codAeroDestino;
        //this.indiceCidadeDestino = modelo.indiceCidadeDestino;

    }

    public Object clone ()
    {
        Voo ret=null;

        try
        {
            ret = new Voo (this);
        }
        catch (Exception erro)
        {} // sei que this NUNCA é null e o contrutor de copia da erro quando seu parametro é null

        return ret;
    }




}
