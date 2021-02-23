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
public class ListaBucket 
{
    private int tl;
    private NoBucket inicio;
    private NoBucket fim;

    public ListaBucket() 
    {
        this.tl=0;
        this.inicio=this.fim=null;
    }

    public int getTl() 
    {
        return tl;
    }

    public NoBucket getInicio()
    {
        return inicio;
    }
    
    private void Inserir(int min,int max)
    {
        Lista l = new Lista();
        NoBucket novo =  new NoBucket(min,max,l,null,fim);
        if(fim == null)
        {
            fim=inicio=novo;
        }           
        else
        {
            fim.setProx(novo);
            fim = novo;
        }
        tl++;
    }
    public void CriaListaBucket(int med,int min,int max)
    {
        int cmin=min-1,cmax=med;
        for (int i = min; i < max; i+=med)
        {
            Inserir(cmin,cmax);
            cmin=cmax;
            cmax=cmax+med;
        }
    }
    public void insLis(int num)
    {
        NoBucket aux;
        aux=inicio;
        boolean finished=false;
        while(aux!=null && !finished)
        {
            if(num>aux.getMin() && num<=aux.getMax())
            {               
              aux.getListaOrd().insFim(num);
              finished=true;
            }      
            aux=aux.getProx();
        }
    }
    public int Ordena()
    {
        NoBucket aux;
        int movcom=0;
        aux=inicio;
        while(aux!=null)
        {
            movcom+=aux.getListaOrd().insercaodiretaBucket();
            aux=aux.getProx();
        }
        return movcom;
    }
}
