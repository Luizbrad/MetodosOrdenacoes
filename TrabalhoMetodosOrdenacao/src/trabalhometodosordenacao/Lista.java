package trabalhometodosordenacao;

public class Lista 
{
    private No inicio,fim;
    private int TL;
    public Lista() 
    {      
        this.inicio=this.fim=null;
        this.TL=0; 
    }
    
    public void Inicializa()
    {
        this.inicio=this.fim=null;
        this.TL=0;
    }

    public No getInicio() {
        return inicio;
    }

    public void setInicio(No inicio) {
        this.inicio = inicio;
    }
    public void initRev(int tam)
    {
        for(int i=0;i<=tam;i++)
        {
            insFim(i);
        }
    }
    public void init(int tam)
    {
        for(int i = 0;i <= tam;i++)
        {
            insFim(tam-i);           
        }
    }
    public void initRand(int tam)
    {
        int num;
        for (int i = 0; i <=tam; i++)
        {
          num = (int) (Math.random() * 1000 + 1);  
          insFim(num);
        }
    }
    
    public void insFim(int info)
    {
        No caixa = new No(fim,null,info);
        if(fim==null)
            inicio=fim=caixa;
        else
        {
            fim.setProx(caixa);
            fim=caixa;
        }
        TL++;
    }
    
    public void exibir()
    {
        No perc=inicio;
        while(perc!=null)
        {
            System.out.println(perc.getInfo()+" ");
            perc=perc.getProx();
        }
        System.out.println("");
    }
    public No perc(int max)
    {
        No aux = inicio;
        int vezes=0;
        
        while(aux != null && vezes<max)
        {
            aux = aux.getProx();
            vezes++;
        }
        return aux;
    }   
    private int buscabinaria(int num,int i)
    {     
        No ini;
        No fim;
        No meio;
        int ini2 = 0,end = i,mid = (ini2+end)/2;
        ini = this.inicio;
        fim = perc(i);
        meio = perc(mid);
        
        while(ini != fim && meio.getInfo() != num)
        {           
            if(meio.getInfo() > num)
            {
                if(meio.getAnt() == null)
                {
                  fim = inicio;  
                  end= 0;
                }
               
                else
                {
                  fim = meio.getAnt();
                  end = mid-1;
                }                   
            }              
            else
            {
                ini = meio.getProx();
                ini2 = mid+1;
            }                          
            mid = (ini2+end)/2;         
            meio = perc(mid);         
        }
        
        if(num > meio.getInfo())
                return mid+1;
        return mid;              
    }
    public int insercaodiretaBucket()
    {
        int bucket=0;
        int aux;
        No pos;
        No auxn = inicio;       
        
        
        while(auxn != null)
        {           
            aux = auxn.getInfo();
            pos = auxn;
            bucket+=2;
            while(pos.getAnt() != null && aux < pos.getAnt().getInfo())
            {                
                pos.setInfo(pos.getAnt().getInfo());
                pos = pos.getAnt();
                bucket+=3;
            }
            
            pos.setInfo(aux);
            bucket++;
            auxn = auxn.getProx();
        }
        return bucket;
    }
    private No particaoOne(int v)
    {
        No aux = inicio;
        No l = null;
        for(int i = 0;i < TL/2;i++)
        {
            aux = perc(v+i);
            l = insere(aux.getInfo(), l);
        }
        return l;
    }
    public No insere(int info, No aux)
    {
        No auxA;
        No lc = new No(null, null,info);
        if(aux == null)
            aux = lc;
        else
        {
            auxA = aux;
            while(auxA.getProx()!=null)
                auxA = auxA.getProx();
            auxA.setProx(lc);
            lc.setAnt(auxA);
        }
        return aux;
    }
    private void fusao1(Lista l1, Lista l2, int seq)
    {
        No aux = inicio, n1, n2;
        int aseq = seq, i = 0, j = 0, k = 0, v;
        while(k < TL)
        {
            while(i < seq && j < seq)
            {
                n1 = l1.perc(i);
                n2 = l2.perc(j);
                if(n1.getInfo() < n2.getInfo())
                {
                    n1 = l1.perc(i++);
                    aux = perc(k++);
                    aux.setInfo(n1.getInfo());
                }
                else
                {
                    n2 = l2.perc(j++);
                    aux = perc(k++);
                    aux.setInfo(n2.getInfo());
                }
            }
            while(i < seq)
            {
                n1 = l1.perc(i++);
                aux = perc(k++);
                aux.setInfo(n1.getInfo());
            }
            while(j < seq)
            {
                n2 = l2.perc(j++);
                aux = perc(k++);
                aux.setInfo(n2.getInfo());
            }
            seq+=aseq;
        }
    }
     private No loop(int info, int tl)
    {
        No aux = null;
        for(int i = 0;i < tl;i++)
        {
            aux=insere(info, aux);
        }
        return aux;
    }
     private void merge(Lista aux, int l, int r)
    {
        int m;
        if(l < r)
        {
            m = (l+r)/2;
            merge(aux, l, m);
            merge(aux, m+1, r);
            fusao(aux, l, m, m+1, r);
        }
    }
     private void fusao(Lista aux, int ini1, int fim1, int ini2, int fim2)
    {
        int i = ini1, j = ini2, k = 0;
        No aux1, aux2, auxA;
        while(i <= fim1 && j <= fim2)
        {
            aux1 = perc(i);
            aux2 = perc(j);
            if(aux1.getInfo() < aux2.getInfo())
            {
                auxA = aux.perc(k++);
                auxA.setInfo(aux1.getInfo());
                i++;
            }
            else
            {
                auxA = aux.perc(k++);
                auxA.setInfo(aux2.getInfo());
                j++;
            }
        }
        while(i <= fim1)
        {
            aux1= perc(i++);
            auxA = aux.perc(k++);
            auxA.setInfo(aux1.getInfo());
        }
        while(j <= fim2)
        {
            aux2 = perc(j++);
            auxA = aux.perc(k++);
            auxA.setInfo(aux2.getInfo());
        }
        for(i = 0;i < k;i++)
        {
            aux1 = perc(i+ini1);
            auxA = aux.perc(i);
            aux1.setInfo(auxA.getInfo());
        }
    }
    private int findHighest()
    {
        No aux = inicio;
        int maior = aux.getInfo();
        aux=aux.getProx();
        while(aux != null)
        {
            if(aux.getInfo() > maior)
            {
                maior = aux.getInfo();
            }
            aux = aux.getProx();
        }
        return maior;
    }
    private No increment(No count)
    {
        No aux;
        No auxCount = count;
        for(int i = 0;auxCount!=null;i++)
        {
            aux = inicio;
            while(aux != null)
            {
                if(aux.getInfo() == i)
                    auxCount.setInfo(auxCount.getInfo()+1);
                aux = aux.getProx();
            }
            auxCount = auxCount.getProx();
        }
        return count;
    }
    private No sum(No count)
    {
        No aux = count;
        aux = aux.getProx();
        while(aux != null)
        {
            aux.setInfo(aux.getInfo()+aux.getAnt().getInfo());
            aux = aux.getProx();
        }
        return count;
    }
    
    private No place(No count, No output)
    {
        No aux = inicio, auxCount, auxOutput;
        while(aux != null)
        {
            auxCount = count;
            auxOutput = output;
            for(int i = 0;i < aux.getInfo();i++)
            {
                auxCount = auxCount.getProx();
            }
            for(int i = 0;i < (auxCount.getInfo()-1);i++)
            {
                auxOutput = auxOutput.getProx();
            }
            auxOutput.setInfo(aux.getInfo());
            auxCount.setInfo(auxCount.getInfo()-1);
            aux = aux.getProx();
        }
        return output;
    }
    private int findLowest()
    {
        No aux = inicio;
        int menor=aux.getInfo();
        aux=aux.getProx();
        while(aux!=null)
        {
            if(aux.getInfo()<menor)
                menor=aux.getInfo();
            aux=aux.getProx();
        }
        return menor;
    }
    private No increment(No count, int exp)
    {
        No aux;
        No auxCount = count;
        for(int i = 0;auxCount!=null;i++)
        {
            aux = inicio;
            while(aux != null)
            {
                if(((aux.getInfo()/exp)%10) == i)
                    auxCount.setInfo(auxCount.getInfo()+1);
                aux = aux.getProx();
            }
            auxCount = auxCount.getProx();
        }
        return count;
    }
    private No place(No count, No output, int exp)
    {
        No aux = inicio, auxCount, auxOutput;
        while(aux.getProx() != null)
            aux = aux.getProx();
        while(aux != null)
        {
            auxCount = count;
            auxOutput = output;
            for(int i = 0;i < (aux.getInfo()/exp)%10;i++)
            {
                auxCount = auxCount.getProx();
            }
            for(int i = 0;i < (auxCount.getInfo()-1);i++)
            {
                auxOutput = auxOutput.getProx();
            }
            auxOutput.setInfo(aux.getInfo());
            auxCount.setInfo(auxCount.getInfo()-1);
            aux = aux.getAnt();
        }
        return output;
    }
    private int getNextGap(int gap)
    {
        gap = (gap*10)/13;

        if(gap < 1)
            return 1;
        return gap;
    }
    private No getNodeGap(No aux, int t)
    {
        for(int i = 0;i < t;i++)
        {
            aux = aux.getProx();
        }
        return aux;
    }
    private void insertionTimSort(int l, int r)
    {
        for(int i = l + 1;i <= r;i++)
        {
            int temp = perc(i).getInfo();
            int j = i - 1;
            while(j >= l && perc(j).getInfo() > temp)
            {
                perc(j+1).setInfo(perc(j).getInfo());
                j--;
            }
            perc(j+1).setInfo(temp);
        }
    }
    
    private void mergeTimSort(int l, int m, int r)
    {
        int tam1 = m - l + 1, tam2 = r - m;
        Lista left = new Lista();
        Lista right = new Lista();
        left.setInicio(left.loop(0, tam1));
        right.setInicio(right.loop(0, tam2));
        for(int x = 0;x < tam1;x++)
            left.perc(x).setInfo(perc(l + x).getInfo());
        for(int x = 0;x < tam2;x++)
            right.perc(x).setInfo(perc(m + 1 + x).getInfo());
        int i = 0;
        int j = 0;
        int k = l;
        while(i < tam1 && j < tam2)
        {
            if(left.perc(i).getInfo() <= right.perc(j).getInfo())
                perc(k).setInfo(left.perc(i++).getInfo());
            else
                perc(k).setInfo(right.perc(j++).getInfo());
            k++;
        }
        while(i < tam1)
            perc(k++).setInfo(left.perc(i++).getInfo());
        while(j < tam2)
            perc(k++).setInfo(right.perc(j++).getInfo());
    }
    
    
    
    public void insercaodireta()
    {
        No ppos,pi=inicio.getProx();
        int aux;
        while(pi!=null)
        {
            aux=pi.getInfo();
            ppos=pi;
            while(ppos!=inicio && aux<ppos.getAnt().getInfo())
            {
                ppos.setInfo(ppos.getAnt().getInfo());
                ppos=ppos.getAnt();
            }
            ppos.setInfo(aux);
            pi=pi.getProx();
        }
    }   
    public void insercaobinaria()
    {
        No auxN,ini=inicio.getProx();
        int aux,i=1,j,pos;
        while(ini!=null)
        {
            aux=ini.getInfo();
            pos=buscabinaria(aux,i-1);
            auxN = ini;
            j = i;
            while(j>pos)
            {                
                if(auxN.getAnt() != null)
                {
                    auxN.setInfo(auxN.getAnt().getInfo());
                    auxN = auxN.getAnt();
                }              
                j--;
            }
            
            auxN.setInfo(aux);
            ini = ini.getProx();
            i++;   
        }   
    }
    public void selecaodireta()
    {
        int menorv;
        No menor=null;
        No aux=null;
        No atual=inicio;
        while(atual.getProx()!=null)
        {
            menor=atual;
            menorv=atual.getInfo();
            aux=atual.getProx();
            while(aux!=null)
            {
                if(aux.getInfo()<menorv)
                {
                    menorv=aux.getInfo();
                    menor=aux;
                }
                aux=aux.getProx();
            }
            menor.setInfo(atual.getInfo());
            atual.setInfo(menorv);
            atual=atual.getProx();
        }
    }
    public void bubblesort()
    {
        No aux=inicio;
        No tl2=fim;
        int auxiliar;
        while(tl2!=inicio)
        {
            aux=inicio;
            while(aux!=tl2)
            {
                if(aux.getProx()!=null && aux.getInfo()>aux.getProx().getInfo())
                {
                    auxiliar=aux.getInfo();
                    aux.setInfo(aux.getProx().getInfo());
                    aux.getProx().setInfo(auxiliar);
                }
                aux=aux.getProx();
            }
            tl2=tl2.getAnt();
        }
    }
    public void shakesort()
    {
        No aux=inicio;
        No tl2=fim;
        No tl3=inicio;
        int auxiliar,tlaux=this.TL;
        while(tlaux>TL/2 && tl2!=tl3)
        {
            aux=inicio;
            while(aux!=tl2)
            {
                if(aux.getProx()!=null && aux.getInfo()>aux.getProx().getInfo())
                {
                    auxiliar=aux.getInfo();
                    aux.setInfo(aux.getProx().getInfo());
                    aux.getProx().setInfo(auxiliar);
                }
                aux=aux.getProx();
            }
            aux=tl2.getAnt();

            while(aux!=tl3)
            {
                if(aux.getAnt()!=null && aux.getInfo()<aux.getAnt().getInfo())
                {
                    auxiliar=aux.getInfo();
                    aux.setInfo(aux.getAnt().getInfo());
                    aux.getAnt().setInfo(auxiliar);
                }
                aux=aux.getAnt();
            }
            tl2=tl2.getAnt();
            tl3=tl3.getProx();
            tlaux--;
        }
    }
    public void ShellSort()
    {
        No aux, aux2;
        int i, j, k, auxA, dist = TL/3;
        while(dist > 0)
        {
            i = 0;
            while(i < dist)
            {
                j = i;
                while((j+dist)<TL)
                {
                    aux = perc(j);
                    aux2 = perc(j+dist);
                    if(aux.getInfo() > aux2.getInfo())
                    {
                        auxA = aux.getInfo();
                        aux.setInfo(aux2.getInfo());
                        aux2.setInfo(auxA);
                        k = j;
                        if(k-dist>=0)
                        {
                            aux2 = perc(k-dist);
                            aux = perc(k);
                        }
                        while((k-dist)>=i && aux2.getInfo() > aux.getInfo())
                        {
                            auxA = aux2.getInfo();
                            aux2.setInfo(aux.getInfo());
                            aux.setInfo(auxA);
                            k-=dist;
                            if(k-dist>=0)
                            {
                                aux2 = perc(k-dist);
                                aux = perc(k);
                            }
                        }
                    }
                    j+=dist;
                }
                i++;
            }
            dist /=2;
        }
    }
    public void heapsort()
    {
        No aux, aux2;
        int pai, tl2 = TL, fe, fd, maior, auxA;
        while(tl2 > 1)
        {
            pai = (tl2/2)-1;
            while(pai != -1)
            {
                fe = 2*pai+1;
                fd = 2*pai+2;
                
                maior = fe;
                aux = perc(fd);
                aux2 = perc(maior);
                if(fd < tl2 && aux.getInfo() > aux2.getInfo())
                {
                    maior = fd;
                    aux2 = perc(maior);
                }
                aux = perc(pai);
                if(aux2.getInfo() > aux.getInfo())
                {
                    auxA = aux.getInfo();
                    aux.setInfo(aux2.getInfo());
                    aux2.setInfo(auxA);
                }
                pai--;
            }
            aux = perc(0);
            aux2 = perc(tl2-1);
            auxA = aux.getInfo();
            aux.setInfo(aux2.getInfo());
            aux2.setInfo(auxA);
            tl2--;
        }     
    }
    private void quick(No ini,No fi)
    {
        No i=ini,j=fi;
        int aux;
        while(i!=null && i!=j)
        {
            while(i!=j && i.getInfo()<=j.getInfo())
            {
                i=i.getProx();
            }
            if(j.getInfo()!=i.getInfo())
            {
                aux=i.getInfo();
                i.setInfo(j.getInfo());
                j.setInfo(aux);
                j=j.getAnt();
            }
            
            while(i!=j && j.getInfo()>=i.getInfo())
            {
                j=j.getAnt();
            }
            if(j.getInfo()!=i.getInfo())
            {
                aux=i.getInfo();
                i.setInfo(j.getInfo());
                j.setInfo(aux);
                i=i.getProx();
            }
            
        }
        if(ini!=i)
            quick(ini,i.getAnt());
        if(fi!=j)
            quick(j.getProx(),fi);        
    }
    public void QuickSemPivo()
    {
        this.quick(inicio, fim);
    }
    public void QuickComPivo()
    {
        QuickCPivo(0, TL-1);
    }
    private void QuickCPivo(int ini, int fim)
    {
        int i = ini, j = fim, auxA;
        No auxI, auxJ;
        auxI = perc((ini+fim)/2);
        int pivo = auxI.getInfo();
        while(i < j)
        {
            auxI = perc(i);
            auxJ = perc(j);
            while(auxI.getInfo() < pivo)
            {
                i++;
                auxI = auxI.getProx();
            }
            while(auxJ.getInfo() > pivo)
            {
                j--;
                auxJ = auxJ.getAnt();
            }
            if(i <= j)
            {
                auxA = auxI.getInfo();
                auxI.setInfo(auxJ.getInfo());
                auxJ.setInfo(auxA);
                i++;
                j--;
            }
        }
        if(ini < j)
            QuickCPivo(ini, j);
        if(i < fim)
            QuickCPivo(i, fim);
    }
    public void MergeSortOne()
    {
        Lista l1 = new Lista(), l2 = new Lista();
        int seq = 1;
        while(seq < TL)
        {
            l1.setInicio(particaoOne(0));
            l2.setInicio(particaoOne(TL/2));
            fusao1(l1, l2, seq);
            seq*=2;
        }
    }
    public void MergeSortSecond()
    {
        Lista l1 = new Lista();
        l1.setInicio(l1.loop(0, TL));
        merge(l1, 0, TL-1);
    }
    public void CountingSort()
    {
        No count, output;
        int maior = findHighest();
        count = loop(0, maior+1);
        output = loop(0, TL);
        count = increment(count);
        count = sum(count);
        inicio = place(count, output);
    }
    public void BucketSort()
    {
        int min,max,med,i;
        No aux = new No();
        aux=inicio;
        ListaBucket lis = new ListaBucket();
        min=findLowest();
        max=findHighest();
        med=(max-min)/4;
        
        lis.CriaListaBucket(med,min,max);
        while(aux!=null)
        {
            lis.insLis(aux.getInfo());
            aux=aux.getProx();
        }
        lis.Ordena();
        NoBucket auxiliar = lis.getInicio();
        No aux2;
        aux=inicio;
        while(auxiliar!=null)
        {
            aux2=auxiliar.getListaOrd().getInicio();
            while(aux2!=null)
            {
                aux.setInfo(aux2.getInfo());
                aux2=aux2.getProx();
                aux=aux.getProx();
            }
            auxiliar=auxiliar.getProx();
        }
    }
    private void RadixCountingSort(int exp)
    {
        No count, output;
        count = loop(0, 10);
        output = loop(0, TL);
        count = increment(count, exp);
        count = sum(count);
        inicio = place(count, output, exp);
    }
    
    public void RadixSort()
    {
        int maior = findHighest();
        for(int exp = 1;maior/exp > 0;exp *= 10)
        {
            RadixCountingSort(exp);
        }
    }
    public void GnomeSort()
    {
        No aux = inicio, auxJ;
        int auxV;
        aux = aux.getProx();
        auxJ = aux.getProx();
        while(aux != null)
        {
            if(aux.getAnt().getInfo() > aux.getInfo())
            {
                auxV = aux.getInfo();
                aux.setInfo(aux.getAnt().getInfo());
                aux.getAnt().setInfo(auxV);
                aux = aux.getAnt();
                if(aux.getAnt() == null)
                    aux = aux.getProx();
            }
            else
            {
                aux = auxJ;
                if(aux != null)
                    auxJ = aux.getProx();
            }
        }
    }

    public void CombSort()
    {
        No aux, auxJ;
        int auxA;
        int gap = TL;
        boolean swapped = true;

        while(gap!=1 || swapped)
        {
            gap = getNextGap(gap);
            swapped = false;
            aux = inicio;

            for(int i = 0;i < TL-gap;i++)
            {
                auxJ = getNodeGap(aux, gap);
                if(aux.getInfo() > auxJ.getInfo())
                {
                    auxA = aux.getInfo();
                    aux.setInfo(auxJ.getInfo());
                    auxJ.setInfo(auxA);
                    swapped = true;
                }
                aux = aux.getProx();
            }
        }
    }
    
    public void TimSort()
    {
        int run = 32;
        for(int i = 0;i < TL;i+=run)
            insertionTimSort(i, Math.min((i + 31), (TL - 1)));
        for(int size = run; size < TL; size *= 2)
        {
            for(int l = 0;l < TL;l += 2*size)
            {
                int m = l + size - 1;
                int r = Math.min((l + 2 * size - 1), (TL - 1)); 
                mergeTimSort(l, m, r);
            }
        }
    }
}
