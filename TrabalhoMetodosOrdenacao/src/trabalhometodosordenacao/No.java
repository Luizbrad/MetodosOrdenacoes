package trabalhometodosordenacao;

public class No 
{
    No prox;
    No ant;
    int info;

    public No(No ant, No prox, int info)
    {
        this.prox = prox;
        this.ant = ant;
        this.info = info;
    }

    public No(int info) 
    {
        this.info=info;
        this.prox=this.ant=null;
    }
    
    public No()
    {
        this.ant=this.prox=null;
    }
    
    public No getProx() 
    {
        return prox;
    }

    public void setProx(No prox) 
    {
        this.prox = prox;
    }

    public No getAnt()
    {
        return ant;
    }

    public void setAnt(No ant)
    {
        this.ant = ant;
    }

    public int getInfo() 
    {
        return info;
    }

    public void setInfo(int info)
    {
        this.info = info;
    }
}
