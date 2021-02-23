package trabalhometodosordenacao;

import java.io.IOException;
import java.io.RandomAccessFile;

public class Arquivo 
{
    public int amount;
    private String nomearquivo;
    private RandomAccessFile arquivo;
    private int comparison,moves;

    public Arquivo(int amount, String nomearquivo) 
    {
        try
        {
           this.amount = amount;
           this.nomearquivo = nomearquivo;
           this.arquivo = new RandomAccessFile(nomearquivo,"rw");
           this.comparison=this.moves=0;
        }
        catch(IOException e)
        {
            
        }
    }
    
    public int getComparison() 
    {
        return comparison;
    }

    public int getMoves() 
    {
        return moves;
    }

    public RandomAccessFile getArquivo()
    {
        return arquivo;
    }
    
    public void seekArq(int pos)
    {
        try
        {
            arquivo.seek(pos * Registro.length());
        } 
        catch (IOException e)
        { 
        }
    }

    public void setComparison(int comparison)
    {
        this.comparison = comparison;
    }

    public void setMoves(int moves)
    {
        this.moves = moves;
    }
    
    public boolean eof()
    {       
        boolean resul = false;       
        try
        {           
            if(arquivo.getFilePointer() == arquivo.length())
                    return true;
        }
        catch(IOException e){}
        
        return resul;
    }
    
    
    public void exibeArq()
    {
        int i;
        Registro aux = new Registro();
        seekArq(0);
        i = 0;
        
        while (i<amount)
        {
           
            aux.leDoArq(arquivo);
            aux.exibeRegistro();
            i++;
        }
    }
    public void gerarArqZerado()
    {
        seekArq(0);
        Registro reg;
        for(int i = 0;i < amount;i++)
        {
            reg = new Registro(0);
            reg.gravaNoArq(arquivo);
        }
    }
    public void gerarArqOrd()
    {
        seekArq(0);
        Registro reg;
        for (int i = 0; i < amount; i++) 
        {
            
            reg = new Registro(i);
            reg.gravaNoArq(arquivo);
        }
    }
    
    public void gerarArqRev()
    {
        seekArq(0);
        Registro reg;
        
        for (int i = amount; i > 0; i--) 
        {           
            reg = new Registro(i);
            reg.gravaNoArq(arquivo);
        }
    }
    
    public void gerarArqRand()
    {  
         Registro reg;
         int num;
         
         for (int i = 0; i < amount; i++) 
         {          
             num = (int) (Math.random() * 1000 + 1);
             reg = new Registro(num);
             reg.gravaNoArq(arquivo);
        }
    }
    public void CopiaArq(Arquivo aux)
    {       
        Registro reg = new Registro();
        this.seekArq(0);
        aux.seekArq(0);
        
        while(!aux.eof()){
            
            reg.leDoArq(aux.getArquivo());
            reg.gravaNoArq(this.arquivo);          
        }
       
    }
    private int BuscaBinaria(int num,int i)
    {     
        int l=0,meio=0;
        Registro aux = new Registro();
        
        while(l <= i)
        {      
            meio=(l+i)/2;
            seekArq(meio);
            aux.leDoArq(arquivo);
            comparison++;
            if(aux.getNumero() > num)
            {
                i=meio-1;             
            }
            else
            {
                l=meio+1;
            }
                     
        }
        comparison++;
        if(num > aux.getNumero())
                return meio+1;
        return meio;              
    }
    private int getNextGap(int gap)
    {
        gap = (gap*10)/13;

        if(gap < 1)
            return 1;
        return gap;
    }
    private int findHighest()
    {
        Registro reg = new Registro();
        seekArq(0);
        reg.leDoArq(arquivo);
        int maior = reg.getNumero();
        reg.leDoArq(arquivo);
        for(int i = 1;i < amount;i++)
        {
            if(reg.getNumero() > maior)
                maior = reg.getNumero();
            reg.leDoArq(arquivo);
        }
        return maior;
    }
    private int findLowest()
    {
        Registro reg = new Registro();
        seekArq(0);
        reg.leDoArq(arquivo);
        int menor = reg.getNumero();
        reg.leDoArq(arquivo);
        for(int i = 1;i < amount;i++)
        {
            if(reg.getNumero() < menor)
                menor = reg.getNumero();
            reg.leDoArq(arquivo);
        }
        return menor;
    }
    private void increment(int v)
    {
        Registro reg = new Registro();
        seekArq(v);
        reg.leDoArq(arquivo);
        seekArq(v);
        reg.setNumero(reg.getNumero()+1);
        reg.gravaNoArq(arquivo);
    }
    private void sum(int maior)
    {
        Registro reg1 = new Registro();
        Registro reg2 = new Registro();
        for(int i = 1;i < maior;i++)
        {
            seekArq(i);
            reg1.leDoArq(arquivo);
            seekArq(i-1);
            reg2.leDoArq(arquivo);
            reg1.setNumero(reg1.getNumero()+reg2.getNumero());
            reg1.gravaNoArq(arquivo);
        }
    }
    private int getPos(int v)
    {
        Registro reg = new Registro();
        seekArq(v);
        reg.leDoArq(arquivo);
        return reg.getNumero();
    }
    
    private void decrement(int v)
    {
        Registro reg = new Registro();
        seekArq(v);
        reg.leDoArq(arquivo);
        reg.setNumero(reg.getNumero()-1);
        seekArq(v);
        reg.gravaNoArq(arquivo);
    }
    
    private void gravaOutput(int pos,int v)
    {
        Registro reg = new Registro();
        seekArq(pos);
        reg.setNumero(v);
        reg.gravaNoArq(arquivo);
    }
    
    private int getValue(int i)
    {
        Registro reg = new Registro();
        seekArq(i);
        reg.leDoArq(arquivo);
        return reg.getNumero();
    }
    
    private void putV(int i, int v)
    {
        Registro reg = new Registro();
        seekArq(i);
        reg.leDoArq(arquivo);
        reg.setNumero(v);
        seekArq(i);
        reg.gravaNoArq(arquivo);
        moves++;
    }
    
    private void particao(Arquivo arq,Arquivo arq2)
    {
        Registro reg = new Registro();
        for(int i = 0;i < amount/2;i++)
        {
            seekArq(i);
            reg.leDoArq(arquivo);
            arq.putV(i, reg.getNumero());
            
            seekArq((amount/2)+i);
            reg.leDoArq(arquivo);
            arq2.putV(i, reg.getNumero());
        }
    }
    
    private void fusao(Arquivo arq, Arquivo arq2, int seq)
    {
        Registro reg = new Registro();
        int v1 = 0, v2 = 0;
        int aseq = seq, i =0 , j =0, k =0;
        while(k < amount)
        {
            while(i < seq && j < seq)
            {
                v1 = arq.getValue(i);
                v2 = arq2.getValue(j);
                comparison++;
                if(v1 < v2)
                {
                    seekArq(k);
                    reg.leDoArq(arquivo);
                    reg.setNumero(v1);
                    i++;
                    seekArq(k++);
                    reg.gravaNoArq(arquivo);
                    moves++;
                }
                else
                {
                    seekArq(k);
                    reg.leDoArq(arquivo);
                    reg.setNumero(v2);
                    j++;
                    seekArq(k++);
                    reg.gravaNoArq(arquivo);
                    moves++;
                }
            }
            while(i < seq)
            {
                v1 = arq.getValue(i);
                seekArq(k);
                reg.leDoArq(arquivo);
                reg.setNumero(v1);
                i++;
                seekArq(k++);
                reg.gravaNoArq(arquivo);
                moves++;
            }
            while(j < seq)
            {
                v2 = arq2.getValue(j);
                seekArq(k);
                reg.leDoArq(arquivo);
                reg.setNumero(v2);
                j++;
                seekArq(k++);
                reg.gravaNoArq(arquivo);
                moves++;
            }
            seq+=aseq;
        }
    }
    
    private void fusao(Arquivo aux, int ini1, int fim1, int ini2, int fim2)
    {
        Registro reg = new Registro();
        Registro reg1 = new Registro();
        Registro reg2 = new Registro();
        int i = ini1, j = ini2, k = 0;
        int auxA;
        while(i <= fim1 && j <=fim2)
        {
            seekArq(i);
            reg1.leDoArq(arquivo);
            seekArq(j);
            reg2.leDoArq(arquivo);
            comparison++;
            if(reg1.getNumero() < reg2.getNumero())
            {
                auxA = reg1.getNumero();
                aux.putV(k++, auxA);
                i++;
            }
            else
            {
                auxA = reg2.getNumero();
                aux.putV(k++, auxA);
                j++;
            }
        }
        while(i <= fim1)
        {
            seekArq(i++);
            reg1.leDoArq(arquivo);
            auxA = reg1.getNumero();
            aux.putV(k++, auxA);
        }
        while(j <= fim2)
        {
            seekArq(j++);
            reg2.leDoArq(arquivo);
            auxA = reg2.getNumero();
            aux.putV(k++, auxA);
        }
        for(i = 0;i <k;i++)
        {
            seekArq(i+ini1);
            reg1.leDoArq(arquivo);
            auxA = aux.getValue(i);
            reg1.setNumero(auxA);
            seekArq(i+ini1);
            reg1.gravaNoArq(arquivo);
            moves++;
        }
    }
    
    private void merge(Arquivo aux, int l, int r)
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
    
    private void RadixCountingSort(int exp)
    {
        int pos;
        Registro reg = new Registro();
        Arquivo auxArq = new Arquivo(10, "auxArq");
        Arquivo output = new Arquivo(amount, "output");
        output.gerarArqZerado();
        auxArq.gerarArqZerado();
        seekArq(0);
        reg.leDoArq(arquivo);
        for(int i = 1;i <= amount;i++)
        {
            auxArq.increment((reg.getNumero()/exp)%10);
            reg.leDoArq(arquivo);
        }
        auxArq.sum(10);
        for(int i = amount-1;i >-1;)
        {
            seekArq(i);
            reg.leDoArq(arquivo);
            pos = auxArq.getPos((reg.getNumero()/exp)%10);
            output.gravaOutput(pos-1, reg.getNumero());
            auxArq.decrement((reg.getNumero()/exp)%10);
            i--;
        }
        for(int i = 0;i < amount;i++)
        {
            seekArq(i);
            reg.leDoArq(arquivo);
            reg.setNumero(output.getValue(i));
            seekArq(i);
            reg.gravaNoArq(arquivo);
            moves++;
        }
    }
    
    private void insertionTimSort(int l, int r)
    {
        Registro reg1 = new Registro();
        Registro regJ = new Registro();
        for(int i = l+1;i <= r;i++)
        {
            seekArq(i);
            reg1.leDoArq(arquivo);
            int temp = reg1.getNumero();
            int j = i - 1;
            seekArq(j);
            regJ.leDoArq(arquivo);
            comparison++;
            while(j >= l && regJ.getNumero() > temp)
            {
                seekArq(j+1);
                reg1.leDoArq(arquivo);
                reg1.setNumero(regJ.getNumero());
                seekArq(j+1);
                reg1.gravaNoArq(arquivo);
                seekArq(--j);
                regJ.leDoArq(arquivo);
                moves++;
                comparison++;
            }
            seekArq(j+1);
            reg1.leDoArq(arquivo);
            reg1.setNumero(temp);
            seekArq(j+1);
            reg1.gravaNoArq(arquivo);
            moves++;
        }
    }
    
    private void mergeTimSort(int l, int m, int r)
    {
        int tam1 = m - l + 1, tam2 = r - m;
        Registro reg = new Registro();
        Arquivo auxArq = new Arquivo(tam1, "auxArq");
        Arquivo auxArq2 = new Arquivo(tam2, "auxArq2");
        for(int x = 0; x < tam1; x++)
        {
            seekArq(l + x);
            reg.leDoArq(arquivo);
            auxArq.putV(x, reg.getNumero());
            moves++;
        }
        for(int x = 0; x < tam2; x++)
        {
            seekArq(m + 1 + x);
            reg.leDoArq(arquivo);
            auxArq2.putV(x, reg.getNumero());
            moves++;
        }
        int i = 0;
        int j = 0;
        int k = l;
        while(i < tam1 && j < tam2)
        {
            comparison++;
            if(auxArq.getValue(i) <= auxArq2.getValue(j))
            {
                seekArq(k);
                reg.leDoArq(arquivo);
                reg.setNumero(auxArq.getValue(i++));
                seekArq(k);
                reg.gravaNoArq(arquivo);
                moves++;
            }
            else
            {
                seekArq(k);
                reg.leDoArq(arquivo);
                reg.setNumero(auxArq2.getValue(j++));
                seekArq(k);
                reg.gravaNoArq(arquivo);
                moves++;
            }
            k++;
        }
        while(i < tam1)
        {
            seekArq(k);
            reg.leDoArq(arquivo);
            reg.setNumero(auxArq.getValue(i++));
            seekArq(k++);
            reg.gravaNoArq(arquivo);
            moves++;
        }
        while(j < tam2)
        {
            seekArq(k);
            reg.leDoArq(arquivo);
            reg.setNumero(auxArq2.getValue(j++));
            seekArq(k++);
            reg.gravaNoArq(arquivo);
            moves++;
        }
    }
    
    //Metodos de Ordenacao
    
    public void InsercaoDireta()
    {
    
        Registro reg1 = new Registro();
        Registro reg2 = new Registro();
        
        int TL = amount,pos;
        
        for (int i = 1; i < TL; i++) 
        {           
            seekArq(i);
            reg1.leDoArq(arquivo);
            seekArq(i-1);
            reg2.leDoArq(arquivo);
            pos = i;
            
            comparison++;
            while(pos > 0 && reg1.getNumero() < reg2.getNumero())
            {               
                seekArq(pos);
                reg2.gravaNoArq(arquivo);
                moves++;
                pos--;
                if(pos >0)
                {
                    seekArq(pos-1);
                    reg2.leDoArq(arquivo);
                }   
                comparison++;
            }                      
            seekArq(pos);
            reg1.gravaNoArq(arquivo);
            moves++;
        }
    }
    public void InsercaoBinaria()
    {        
        Registro auxList = new Registro();
        Registro auxRList = new Registro();
        int i=1,j,aux,pos;
              
        while(i<amount)
        {            
            seekArq(i);
            auxList.leDoArq(arquivo);
            aux = auxList.getNumero();
            pos = BuscaBinaria(aux, i);
            j = i;
            while(j>pos)
            {      
                seekArq(j-1);
                auxRList.leDoArq(arquivo);
                auxRList.gravaNoArq(arquivo);               
                j--;
                moves++;
            }
            seekArq(pos);
            auxList.gravaNoArq(arquivo);
            auxList.leDoArq(arquivo);
            moves++;
            i++;        
        }
    }
    public void SelecaoDireta()
    {       
        Registro aux = new Registro();
        Registro aux2 = new Registro();
        
        int menor,valor;
        
        for (int i = 0; i < amount; i++)
        {
            menor=i;
            seekArq(i);
            aux.leDoArq(arquivo);
            valor=aux.getNumero();
            
            
            for (int j = i; j < amount; j++) 
            {
               seekArq(j);
               aux2.leDoArq(arquivo);
               comparison++;
               if(aux2.getNumero() < valor)
               {
                   menor=j;
                   valor=aux2.getNumero();
               }                                   
            }     
            seekArq(menor);
            aux.gravaNoArq(arquivo);
            seekArq(i);
            aux.setNumero(valor);
            aux.gravaNoArq(arquivo);
            moves+=2;
        }    
    }
    public void BubbleSort()
    {
        Registro reg1 = new Registro(), reg2 = new Registro();
        int tl = amount;
        for(int i = 0; i < tl-1;i++)
        {
            for(int j = 0; j < tl-i-1;j++)
            {
                seekArq(j);
                reg1.leDoArq(arquivo);
                reg2.leDoArq(arquivo);
                comparison++;
                if(reg1.getNumero() > reg2.getNumero())
                {                   
                    seekArq(j);
                    reg2.gravaNoArq(arquivo);
                    reg1.gravaNoArq(arquivo);
                    moves+=2;
                }
            }
        }
    }
    public void Shake()
    {
        Registro reg1 = new Registro(), reg2 = new Registro();
        int tl = amount,tlini=0;
        int val=0;
        int i,j=0,k;
        for(i = 0; i < tl-1;i++)
        {
            if(i%2==0)
            {
                val++;
                for(j = tlini; j < tl-val;j++)
                {
                    seekArq(j);
                    reg1.leDoArq(arquivo);
                    reg2.leDoArq(arquivo);
                    comparison++;
                    if(reg1.getNumero() > reg2.getNumero())
                    {                   
                        seekArq(j);
                        reg2.gravaNoArq(arquivo);
                        reg1.gravaNoArq(arquivo);
                        moves+=2;
                    }
                }   
            }
            else
            {
              for(k = j-1; k >tlini;k--)
              {
                seekArq(k-1);
                reg1.leDoArq(arquivo);
                reg2.leDoArq(arquivo);
                comparison++;
                if(reg1.getNumero() > reg2.getNumero())
                {                   
                    seekArq(k-1);
                    reg2.gravaNoArq(arquivo);
                    reg1.gravaNoArq(arquivo);
                    moves+=2;
                }
              }  
              tlini++;
            }
        }
    }
    public void Shell()
    {
        int i,j,k,dist=amount/3;
        Registro reg = new Registro();
        Registro reg2 = new Registro();
        while(dist>0)
        {
            i=0;
            while(i<dist)
            {
                j=i;
                while((j+dist)<amount)
                {
                    seekArq(j);
                    reg.leDoArq(arquivo);
                    seekArq(j+dist);
                    reg2.leDoArq(arquivo);
                    comparison++;
                    if(reg.getNumero()>reg2.getNumero())
                    {
                        seekArq(j);
                        reg2.gravaNoArq(arquivo);
                        seekArq(j+dist);
                        reg.gravaNoArq(arquivo);
                        moves+=2;
                        k=j;
                        if(k-dist>=0)
                        {
                            seekArq(k-dist);
                            reg2.leDoArq(arquivo);
                            seekArq(k);
                            reg.leDoArq(arquivo);
                        }
                        comparison++;
                        while((k-dist)>=i && reg2.getNumero()>reg.getNumero())
                        {
                            comparison++;
                            seekArq(k-dist);
                            reg.gravaNoArq(arquivo);
                            seekArq(k);
                            reg2.gravaNoArq(arquivo);
                            moves+=2;
                            k-=dist;
                            if(k-dist>=0)
                            {
                                seekArq(k-dist);
                                reg2.leDoArq(arquivo);
                                seekArq(k);
                                reg.leDoArq(arquivo);
                            }
                        }
                    }
                    j+=dist;
                }
                i++;
            }
            dist=dist/2;
        }
    }
    public void HeapSort()
    {
        Registro reg1 = new Registro(), reg2 = new Registro();
        int pai, tl2 = amount, fe, fd, maior;
        while(tl2 > 1)
        {
            pai = (tl2/2)-1;
            while(pai != -1)
            {
                fe = 2*pai+1;
                fd = 2*pai+2;
                
                maior = fe;
                seekArq(fd);
                reg1.leDoArq(arquivo);
                seekArq(maior);
                reg2.leDoArq(arquivo);
                comparison++;
                if(fd < tl2 && reg1.getNumero()> reg2.getNumero())
                {
                    maior = fd;
                    seekArq(maior);
                    reg2.leDoArq(arquivo);
                }
                seekArq(pai);
                reg1.leDoArq(arquivo);
                comparison++;
                if(reg2.getNumero()> reg1.getNumero())
                {
                    seekArq(pai);
                    reg2.gravaNoArq(arquivo);
                    seekArq(maior);
                    reg1.gravaNoArq(arquivo);
                    moves+=2;
                }
                pai--;
            }
            seekArq(0);
            reg1.leDoArq(arquivo);
            seekArq(tl2-1);
            reg2.leDoArq(arquivo);
            seekArq(0);
            reg2.gravaNoArq(arquivo);
            seekArq(tl2-1);
            reg1.gravaNoArq(arquivo);
            moves+=2;
            tl2--;
        }
    }
    public void QuickSemPivo()
    {
        QuickSPivo(0, amount-1);
    }
    private void QuickSPivo(int ini, int fim)
    {
        int i = ini, j = fim, auxA;
        Registro regI = new Registro(), regJ = new Registro();
        boolean flag = true;
        while(i < j)
        {
            if(flag)
            {
                seekArq(j);
                regJ.leDoArq(arquivo);
                seekArq(i);
                regI.leDoArq(arquivo);
                comparison++;
                while(i < j && regI.getNumero()<= regJ.getNumero())
                {
                    i++;
                    regI.leDoArq(arquivo);
                    comparison++;
                }
            }    
            else
            {
                seekArq(i);
                regI.leDoArq(arquivo);
                seekArq(j);
                regJ.leDoArq(arquivo);
                comparison++;
                while(i < j && regI.getNumero()<= regJ.getNumero())
                {
                    j--;
                    seekArq(j);
                    regJ.leDoArq(arquivo);
                    comparison++;
                }
            }
            flag = !flag;
            seekArq(i);
            regJ.gravaNoArq(arquivo);
            seekArq(j);
            regI.gravaNoArq(arquivo);
            moves+=2;
        }
        if(ini < i-1)
            QuickSPivo(ini, i-1);
        if(j+1 < fim)
            QuickSPivo(j+1, fim);
    }
    public void QuickComPivo()
    {
        QuickCPivo(0, amount-1);
    }
    private void QuickCPivo(int ini, int fim)
    {
        int i = ini, j = fim;
        Registro regI = new Registro(), regJ = new Registro();
        seekArq((ini+fim)/2);
        regI.leDoArq(arquivo);
        int pivo = regI.getNumero();
        while(i < j)
        {
            seekArq(j);
            regJ.leDoArq(arquivo);
            seekArq(i);
            regI.leDoArq(arquivo);
            comparison++;
            while(regI.getNumero() < pivo)
            {
                i++;
                regI.leDoArq(arquivo);
                comparison++;
            }
            comparison++;
            while(regJ.getNumero() > pivo)
            {
                j--;
                seekArq(j);
                regJ.leDoArq(arquivo);
                comparison++;
            }
            if(i <= j)
            {
                seekArq(i);
                regJ.gravaNoArq(arquivo);
                seekArq(j);
                regI.gravaNoArq(arquivo);
                moves+=2;
                i++;
                j--;
            }
        }
        if(ini < j)
            QuickCPivo(ini, j);
        if(i < fim)
            QuickCPivo(i, fim);
    }
    public void Merge1()
    {
        int seq = 1;
        Arquivo auxArq = new Arquivo(amount/2, "auxArq");
        Arquivo auxArq2 = new Arquivo(amount/2, "auxArq2");
        while(seq < amount)
        {
            particao(auxArq, auxArq2);
            fusao(auxArq, auxArq2, seq);
            seq*=2;
        }
    }
    public void Merge2()
    {
        Arquivo auxArq = new Arquivo(amount, "auxArq");
        merge(auxArq, 0, amount-1);
    }
    public void Counting()
    {
        int maior = findHighest();
        int pos;
        Registro reg = new Registro();
        Arquivo auxArq = new Arquivo(maior+1, "auxArq");
        Arquivo output = new Arquivo(amount, "output");
        output.gerarArqZerado();
        auxArq.gerarArqZerado();
        seekArq(0);
        reg.leDoArq(arquivo);
        for(int i = 1;i <= amount;i++)
        {
            auxArq.increment(reg.getNumero());
            reg.leDoArq(arquivo);
        }
        auxArq.sum(maior+1);
        seekArq(0);
        reg.leDoArq(arquivo);
        for(int i = 1;i <= amount;i++)
        {
            pos = auxArq.getPos(reg.getNumero());
            output.gravaOutput(pos-1, reg.getNumero());
            auxArq.decrement(reg.getNumero());
            seekArq(i);
            reg.leDoArq(arquivo);
        }
        for(int i = 0;i < amount;i++)
        {
            seekArq(i);
            reg.leDoArq(arquivo);
            reg.setNumero(output.getValue(i));
            seekArq(i);
            reg.gravaNoArq(arquivo);
            moves++;
        }
    }
    public void Bucket()
    {
        int min,max,med,i=0;
        int auxmc=0;
        ListaBucket lis = new ListaBucket();
        Registro reg = new Registro();
        min=findLowest();
        max=findHighest();
        med=(max-min)/4;
        med++;
        lis.CriaListaBucket(med,min,max);
        for (int j = 0; j < amount; j++)
        {
            seekArq(j);
            reg.leDoArq(arquivo);
            lis.insLis(reg.getNumero());
        }
        
            
        moves+=amount;
        comparison+=amount;
        auxmc=lis.Ordena();
        comparison+=auxmc;
        moves+=auxmc;
        NoBucket auxiliar = lis.getInicio();
        No aux2;
        while(auxiliar!=null)
        {
            aux2=auxiliar.getListaOrd().getInicio();
            while(aux2!=null)
            {
                seekArq(i);
                moves++;
                reg.setNumero(aux2.getInfo());
                reg.gravaNoArq(arquivo);
                aux2=aux2.getProx();
                i++;
            }
            auxiliar=auxiliar.getProx();
        }
    }
    public void Radix()
    {
        int maior = findHighest();
        for(int exp = 1;maior/exp > 0;exp *= 10)
        {
            RadixCountingSort(exp);
        }
    }        
    public void Comb()
    {
        Registro aux = new Registro();
        Registro auxJ = new Registro();
        int gap = amount;
        boolean swapped = true;

        while(gap!=1 || swapped)
        {
            gap = getNextGap(gap);
            swapped = false;

            for(int i = 0;i < amount-gap;i++)
            {
                seekArq(i);
                aux.leDoArq(arquivo);
                seekArq(i+gap);
                auxJ.leDoArq(arquivo);
                comparison++;
                if(aux.getNumero() > auxJ.getNumero())
                {
                    seekArq(i);
                    auxJ.gravaNoArq(arquivo);
                    seekArq(i+gap);
                    aux.gravaNoArq(arquivo);
                    moves+=2;
                    swapped = true;
                }
                
            }
        }
    }
    public void Gnome()
    {
        seekArq(1);
        Registro aux = new Registro();
        aux.leDoArq(arquivo);
        Registro auxJ = new Registro();
        auxJ.leDoArq(arquivo);
        Registro ant = new Registro();
        int j=2;
        for (int i = 1; i < amount;)
        {
            seekArq(i-1);
            ant.leDoArq(arquivo);
            comparison++;
            if(ant.getNumero()>aux.getNumero())
            {
                seekArq(i-1);
                aux.gravaNoArq(arquivo);
                ant.gravaNoArq(arquivo);
                moves+=2;
                i--;             
                if(i==0)
                {
                    i=1;
                    seekArq(i);
                    aux.leDoArq(arquivo);
                }
            }
            else
            {
                i=j;
                seekArq(i);
                aux.leDoArq(arquivo);
                j++;
            }
        }
    }
    
    public void Tim()
    {
        int run = 32;
        for(int i = 0;i < amount;i+=run)
            insertionTimSort(i, Math.min((i + 31), (amount - 1)));
        for(int size = run;size < amount; size *=2)
        {
            for(int l = 0;l < amount;l+=2*size)
            {
                int m = l + size -1;
                int r = Math.min((l + 2 * size - 1), (amount - 1));
                mergeTimSort(l, m, r);
            }
        }
    }
}
