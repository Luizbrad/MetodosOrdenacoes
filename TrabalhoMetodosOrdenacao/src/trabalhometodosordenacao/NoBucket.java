/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalhometodosordenacao;

/**
 *
 * @author User
 */
public class NoBucket 
{
    public int min;
    public int max;
    public Lista ListaOrd;
    public NoBucket prox;
    public NoBucket ant;

    public NoBucket(int min, int max, Lista l, NoBucket prox, NoBucket ant) 
    {
        this.min = min;
        this.max = max;
        this.ListaOrd = l;
        this.prox = prox;
        this.ant = ant;
    }
    public NoBucket()
    {
        this.min=this.max=0;
        this.ListaOrd=null;
        this.prox=this.ant=null;
    }

    public int getMin() 
    {
        return min;
    }

    public void setMin(int min)
    {
        this.min = min;
    }

    public int getMax() 
    {
        return max;
    }

    public void setMax(int max) 
    {
        this.max = max;
    }

    public Lista getListaOrd() 
    {
        return ListaOrd;
    }

    public void setListaOrd(Lista l) 
    {
        this.ListaOrd = l;
    }

    public NoBucket getProx() 
    {
        return prox;
    }

    public void setProx(NoBucket prox)
    {
        this.prox = prox;
    }

    public NoBucket getAnt() 
    {
        return ant;
    }

    public void setAnt(NoBucket ant)
    {
        this.ant = ant;
    }
}
