package trabalhometodosordenacao;

import java.io.FileWriter;
import java.io.IOException;

public class TrabalhoMetodosOrdenacao {

    public static void gravarLin(String nome_ord,int compORD,int comp2ORD,int movORD,int mov2ORD,double tempORD,int compREV,int comp2REV,int movREV,int mov2REV,double tempREV,int compRAND,int comp2RAND,int movRAND,int mov2RAND,double tempRAND)
    {       
        try{
            
            int tam = nome_ord.length();
            String numero;
            
            FileWriter writer = new FileWriter("Métodos Ordenação.txt", true);
            
            writer.write(nome_ord);
            for (int i = 0; i < 18-tam+5; i++) {
                writer.write(" ");
            }
         
            writer.write("  ");
            writer.write(""+compORD);
            numero = ""+compORD;
            tam = numero.length();
            writer.write("  ");
            
            for (int i = 0; i < 9-tam; i++) {
                writer.write(" ");
            }
            
            writer.write("  ");
            writer.write(""+comp2ORD);
            numero = ""+comp2ORD;
            tam = numero.length();
            writer.write("  ");
            
            for (int i = 0; i < 9-tam; i++) {
                writer.write(" ");
            }
            
            writer.write("  ");
            writer.write(""+movORD);
            numero = ""+movORD;
            tam = numero.length();
            writer.write("  ");
            
            for (int i = 0; i < 9-tam; i++) {
                writer.write(" ");
            }
           
            writer.write("  ");
            writer.write(""+mov2ORD);
            numero = ""+mov2ORD;
            tam = numero.length();
            writer.write("  ");
            
            for (int i = 0; i < 9-tam; i++) {
                writer.write(" ");
            }
            
            writer.write("  ");
            writer.write(""+tempORD);
            numero = ""+tempORD;
            tam = numero.length();
            writer.write("  ");
            
            for (int i = 0; i < 9-tam; i++) {
                writer.write(" ");
            }
            
            writer.write("  ");
            writer.write(""+compREV);
            numero = ""+compREV;
            tam = numero.length();
            writer.write("  ");
            
            for (int i = 0; i < 9-tam; i++) {
                writer.write(" ");
            }
            
            writer.write("  ");
            writer.write(""+comp2REV);
            numero = ""+comp2REV;
            tam = numero.length();
            writer.write("  ");
            
            for (int i = 0; i < 9-tam; i++) {
                writer.write(" ");
            }
            
            writer.write("  ");
            writer.write(""+movREV);
            numero = ""+movREV;
            tam = numero.length();
            writer.write("  ");
            
            for (int i = 0; i < 9-tam; i++) {
                writer.write(" ");
            }
           
            writer.write("  ");
            writer.write(""+mov2REV);
            numero = ""+mov2REV;
            tam = numero.length();
            writer.write("  ");
            
            for (int i = 0; i < 9-tam; i++) {
                writer.write(" ");
            }
            
            writer.write("  ");
            writer.write(""+tempREV);
            numero = ""+tempREV;
            tam = numero.length();
            writer.write("  ");
            
            for (int i = 0; i < 9-tam; i++) {
                writer.write(" ");
            }
            
            writer.write("  ");
            writer.write(""+compRAND);
            numero = ""+compRAND;
            tam = numero.length();
            writer.write("  ");
            
            for (int i = 0; i < 9-tam; i++) {
                writer.write(" ");
            }
            
            writer.write("  ");
            writer.write(""+comp2RAND);
            numero = ""+comp2RAND;
            tam = numero.length();
            writer.write("  ");
            
            for (int i = 0; i < 9-tam; i++) {
                writer.write(" ");
            }
            
            writer.write("  ");
            writer.write(""+movRAND);
            numero = ""+movRAND;
            tam = numero.length();
            writer.write("  ");
            
            for (int i = 0; i < 9-tam; i++) {
                writer.write(" ");
            }
           
            writer.write("  ");
            writer.write(""+mov2RAND);
            numero = ""+mov2RAND;
            tam = numero.length();
            writer.write("  ");
            
            for (int i = 0; i < 9-tam; i++) {
                writer.write(" ");
            }
            
            writer.write("  ");
            writer.write(""+tempRAND);
            numero = ""+tempRAND;
            tam = numero.length();
            writer.write("  ");
            
            for (int i = 0; i < 9-tam; i++) {
                writer.write(" ");
            }
            
            writer.write("\r\n");
            writer.close();
        }catch(IOException e){
            System.out.println(e.getMessage());
        }
    }

    public static void main(String[] args) 
    {       
        int num=1024;
        try
        {          
            FileWriter writer = new FileWriter("Métodos Ordenação.txt", false);
            writer.write("Elementos = "+num);
            writer.write("\r\n");
            writer.write("Métodos                ");
            writer.write("Ordenado                                                         ");
            writer.write("Reverso                                                          ");
            writer.write("Randômico                                                ");
            writer.write("\r\n");
            writer.write("                       ");
            writer.write("Comp Prog *  ");
            writer.write("Comp Equa #  ");
            writer.write("Mov Prog +   ");
            writer.write("Mov Equa -   ");
            writer.write("Tempo        ");
            writer.write("Comp Prog *  ");
            writer.write("Comp Equa #  ");
            writer.write("Mov Prog +   ");
            writer.write("Mov Equa -   ");
            writer.write("Tempo        ");
            writer.write("Comp prog *  ");
            writer.write("Comp equa #  ");
            writer.write("Mov Prog +   ");
            writer.write("Mov Equa -   ");
            writer.write("Tempo        ");
            writer.write("\r\n");
            
            writer.close();
         }
         catch(IOException e){System.out.println(e.getMessage());}
        
        //Lista l=new Lista();
        //testeLista(l,num);
        long tinio,tfimo,tinir,tfimr,tinirand,tfimrand;
        int cord,mord,crev,mrev,crand,mrand;
        Arquivo arqRev = new Arquivo(num,"Reverso");
        Arquivo arqOrd = new Arquivo(num,"Ordenado");
        Arquivo arqRand = new Arquivo(num,"Random");       
        Arquivo auxRev = new Arquivo(num,"AuxRev");
        Arquivo auxRand = new Arquivo(num,"AuxRand");
        arqRev.gerarArqRev();
        arqOrd.gerarArqOrd();
        arqRand.gerarArqRand();

        //InsercaoDireta 
        tinio=System.currentTimeMillis();
        arqOrd.InsercaoDireta();
        tfimo=System.currentTimeMillis();
        cord=arqOrd.getComparison();
        mord=arqOrd.getMoves();
        
        auxRev.CopiaArq(arqRev); 
        tinir=System.currentTimeMillis();
        auxRev.InsercaoDireta();
        tfimr=System.currentTimeMillis();
        crev=auxRev.getComparison();
        mrev=auxRev.getMoves();
        
        auxRand.CopiaArq(arqRand);
        tinirand=System.currentTimeMillis();
        auxRand.InsercaoDireta();
        tfimrand=System.currentTimeMillis();
        crand=auxRand.getComparison();
        mrand=auxRand.getMoves();
        gravarLin("Inserção Direta", cord, arqOrd.amount-1, mord, 3*(arqOrd.amount-1), (tfimo-tinio)/1000, 
                crev,(auxRev.amount*auxRev.amount+auxRev.amount-4)/4, mrev, (auxRev.amount*auxRev.amount+(3*auxRev.amount)-4)/2, (tfimr-tinir)/1000, 
                crand,((auxRand.amount*auxRand.amount)+auxRand.amount-2)/4, mrand,((auxRand.amount*auxRand.amount)+9*auxRand.amount-10)/4, (tfimrand-tinirand)/1000);
       //InsercaoBinaria
        arqOrd.setComparison(0);
        arqOrd.setMoves(0);
        auxRev.setComparison(0);
        auxRev.setMoves(0);
        auxRand.setComparison(0);
        auxRand.setMoves(0);
        tinio=System.currentTimeMillis();
        arqOrd.InsercaoBinaria();
        tfimo=System.currentTimeMillis();
        cord=arqOrd.getComparison();
        mord=arqOrd.getMoves();
        
        auxRev.CopiaArq(arqRev); 
        tinir=System.currentTimeMillis();
        auxRev.InsercaoBinaria();
        tfimr=System.currentTimeMillis();
        crev=auxRev.getComparison();
        mrev=auxRev.getMoves();
        
        auxRand.CopiaArq(arqRand);
        tinirand=System.currentTimeMillis();
        auxRand.InsercaoBinaria();
        tfimrand=System.currentTimeMillis();
        crand=auxRand.getComparison();
        mrand=auxRand.getMoves();
        gravarLin("Inserção Binária", cord, (int) (arqOrd.amount * (Math.log(arqOrd.amount) - Math.log(1.44269) + 0.5)), mord, 3*(arqOrd.amount-1), (tfimo-tinio)/1000, 
                crev,(int) (arqRev.amount * (Math.log(auxRev.amount) - Math.log(1.44269) + 0.5)), mrev, (int)(Math.pow(auxRev.amount, 2) + 3*auxRev.amount -4)/2, (tfimr-tinir)/1000, 
                crand,(int) (arqRand.amount * (Math.log(auxRand.amount) - Math.log(1.44269) + 0.5)), mrand,(int)(Math.pow(auxRand.amount, 2) + 9*auxRand.amount - 10)/4, (tfimrand-tinirand)/1000);
       //SelecaoDireta
        arqOrd.setComparison(0);
        arqOrd.setMoves(0);
        auxRev.setComparison(0);
        auxRev.setMoves(0);
        auxRand.setComparison(0);
        auxRand.setMoves(0);
        tinio=System.currentTimeMillis();
        arqOrd.SelecaoDireta();
        tfimo=System.currentTimeMillis();
        cord=arqOrd.getComparison();
        mord=arqOrd.getMoves();
        
        auxRev.CopiaArq(arqRev); 
        tinir=System.currentTimeMillis();
        auxRev.SelecaoDireta();
        tfimr=System.currentTimeMillis();
        crev=auxRev.getComparison();
        mrev=auxRev.getMoves();
        
        auxRand.CopiaArq(arqRand);
        tinirand=System.currentTimeMillis();
        auxRand.SelecaoDireta();
        tfimrand=System.currentTimeMillis();
        crand=auxRand.getComparison();
        mrand=auxRand.getMoves();
        gravarLin("Seleção Direta", cord, (int)(Math.pow(arqOrd.amount, 2) - arqOrd.amount)/2, mord, 3*(arqOrd.amount-1), (tfimo-tinio)/1000, 
                crev,(int)(Math.pow(auxRev.amount, 2) - auxRev.amount)/2, mrev, (int) ((Math.pow(auxRev.amount,2)/4) + 3 * (auxRev.amount-1)), (tfimr-tinir)/1000, 
                crand,(int)(Math.pow(auxRand.amount, 2) - auxRand.amount)/2, mrand,(int) (auxRand.amount * (Math.log(auxRand.amount) + 0.577216)), (tfimrand-tinirand)/1000);
       //BubbleSort
        arqOrd.setComparison(0);
        arqOrd.setMoves(0);
        auxRev.setComparison(0);
        auxRev.setMoves(0);
        auxRand.setComparison(0);
        auxRand.setMoves(0);
        tinio=System.currentTimeMillis();
        arqOrd.BubbleSort();
        tfimo=System.currentTimeMillis();
        cord=arqOrd.getComparison();
        mord=arqOrd.getMoves();
        
        auxRev.CopiaArq(arqRev); 
        tinir=System.currentTimeMillis();
        auxRev.BubbleSort();
        tfimr=System.currentTimeMillis();
        crev=auxRev.getComparison();
        mrev=auxRev.getMoves();
        
        auxRand.CopiaArq(arqRand);
        tinirand=System.currentTimeMillis();
        auxRand.BubbleSort();
        tfimrand=System.currentTimeMillis();
        crand=auxRand.getComparison();
        mrand=auxRand.getMoves();
        gravarLin("Bubble", cord, (int) ((Math.pow(num,2)-num)/2), mord, 0, (tfimo-tinio)/1000, 
                crev,(int) ((Math.pow(num,2)-num)/2), mrev, (int) (3*(Math.pow(num,2)-num)/4), (tfimr-tinir)/1000, 
                crand,(int) ((Math.pow(num,2)-num)/2), mrand,(int) (3*(Math.pow(num,2)-num)/2), (tfimrand-tinirand)/1000);
       //Shake
        arqOrd.setComparison(0);
        arqOrd.setMoves(0);
        auxRev.setComparison(0);
        auxRev.setMoves(0);
        auxRand.setComparison(0);
        auxRand.setMoves(0);
        tinio=System.currentTimeMillis();
        arqOrd.Shake();
        tfimo=System.currentTimeMillis();
        cord=arqOrd.getComparison();
        mord=arqOrd.getMoves();
        
        auxRev.CopiaArq(arqRev); 
        tinir=System.currentTimeMillis();
        auxRev.Shake();
        tfimr=System.currentTimeMillis();
        crev=auxRev.getComparison();
        mrev=auxRev.getMoves();
        
        auxRand.CopiaArq(arqRand);
        tinirand=System.currentTimeMillis();
        auxRand.Shake();
        tfimrand=System.currentTimeMillis();
        crand=auxRand.getComparison();
        mrand=auxRand.getMoves();
        gravarLin("Shake", cord, (int) ((Math.pow(num,2)-num)/2), mord, 0, (tfimo-tinio)/1000, 
                crev,(int) ((Math.pow(num,2)-num)/2), mrev, (int) (3*(Math.pow(num,2)-num)/4), (tfimr-tinir)/1000, 
                crand,(int) ((Math.pow(num,2)-num)/2), mrand,(int) (3*(Math.pow(num,2)-num)/2), (tfimrand-tinirand)/1000);
       //Shell
        arqOrd.setComparison(0);
        arqOrd.setMoves(0);
        auxRev.setComparison(0);
        auxRev.setMoves(0);
        auxRand.setComparison(0);
        auxRand.setMoves(0);
        tinio=System.currentTimeMillis();
        arqOrd.Shell();
        tfimo=System.currentTimeMillis();
        cord=arqOrd.getComparison();
        mord=arqOrd.getMoves();
        
        auxRev.CopiaArq(arqRev); 
        tinir=System.currentTimeMillis();
        auxRev.Shell();
        tfimr=System.currentTimeMillis();
        crev=auxRev.getComparison();
        mrev=auxRev.getMoves();
        
        auxRand.CopiaArq(arqRand);
        tinirand=System.currentTimeMillis();
        auxRand.Shell();
        tfimrand=System.currentTimeMillis();
        crand=auxRand.getComparison();
        mrand=auxRand.getMoves();
        gravarLin("Shell", cord, 0, mord, 0, (tfimo-tinio)/1000, 
                crev,0, mrev, 0, (tfimr-tinir)/1000, 
                crand,0, mrand, 0, (tfimrand-tinirand)/1000);
       //Heap
        arqOrd.setComparison(0);
        arqOrd.setMoves(0);
        auxRev.setComparison(0);
        auxRev.setMoves(0);
        auxRand.setComparison(0);
        auxRand.setMoves(0);
        tinio=System.currentTimeMillis();
        arqOrd.HeapSort();
        tfimo=System.currentTimeMillis();
        cord=arqOrd.getComparison();
        mord=arqOrd.getMoves();
        
        auxRev.CopiaArq(arqRev); 
        tinir=System.currentTimeMillis();
        auxRev.HeapSort();
        tfimr=System.currentTimeMillis();
        crev=auxRev.getComparison();
        mrev=auxRev.getMoves();
        
        auxRand.CopiaArq(arqRand);
        tinirand=System.currentTimeMillis();
        auxRand.HeapSort();
        tfimrand=System.currentTimeMillis();
        crand=auxRand.getComparison();
        mrand=auxRand.getMoves();
        gravarLin("Heap", cord, 0, mord, 0, (tfimo-tinio)/1000, 
                crev,0, mrev, 0, (tfimr-tinir)/1000, 
                crand,0, mrand, 0, (tfimrand-tinirand)/1000);
       //QuickComPivo
        arqOrd.setComparison(0);
        arqOrd.setMoves(0);
        auxRev.setComparison(0);
        auxRev.setMoves(0);
        auxRand.setComparison(0);
        auxRand.setMoves(0);
        tinio=System.currentTimeMillis();
        arqOrd.QuickComPivo();
        tfimo=System.currentTimeMillis();
        cord=arqOrd.getComparison();
        mord=arqOrd.getMoves();
        
        auxRev.CopiaArq(arqRev); 
        tinir=System.currentTimeMillis();
        auxRev.QuickComPivo();
        tfimr=System.currentTimeMillis();
        crev=auxRev.getComparison();
        mrev=auxRev.getMoves();
        
        auxRand.CopiaArq(arqRand);
        tinirand=System.currentTimeMillis();
        auxRand.QuickComPivo();
        tfimrand=System.currentTimeMillis();
        crand=auxRand.getComparison();
        mrand=auxRand.getMoves();
        gravarLin("Quick c/ Pivô", cord, 0, mord, 0, (tfimo-tinio)/1000, 
                crev,0, mrev, 0, (tfimr-tinir)/1000, 
                crand,0, mrand, 0, (tfimrand-tinirand)/1000);
       //QuickSemPivo
        arqOrd.setComparison(0);
        arqOrd.setMoves(0);
        auxRev.setComparison(0);
        auxRev.setMoves(0);
        auxRand.setComparison(0);
        auxRand.setMoves(0);
        tinio=System.currentTimeMillis();
        arqOrd.QuickSemPivo();
        tfimo=System.currentTimeMillis();
        cord=arqOrd.getComparison();
        mord=arqOrd.getMoves();
        
        auxRev.CopiaArq(arqRev); 
        tinir=System.currentTimeMillis();
        auxRev.QuickSemPivo();
        tfimr=System.currentTimeMillis();
        crev=auxRev.getComparison();
        mrev=auxRev.getMoves();
        
        auxRand.CopiaArq(arqRand);
        tinirand=System.currentTimeMillis();
        auxRand.QuickSemPivo();
        tfimrand=System.currentTimeMillis();
        crand=auxRand.getComparison();
        mrand=auxRand.getMoves();
        gravarLin("Quick s/ Pivô", cord, 0, mord, 0, (tfimo-tinio)/1000, 
                crev,0, mrev, 0, (tfimr-tinir)/1000, 
                crand,0, mrand, 0, (tfimrand-tinirand)/1000);
        //Merge 1
        arqOrd.setComparison(0);
        arqOrd.setMoves(0);
        auxRev.setComparison(0);
        auxRev.setMoves(0);
        auxRand.setComparison(0);
        auxRand.setMoves(0);
        tinio=System.currentTimeMillis();
        arqOrd.Merge1();
        tfimo=System.currentTimeMillis();
        cord=arqOrd.getComparison();
        mord=arqOrd.getMoves();
        
        auxRev.CopiaArq(arqRev); 
        tinir=System.currentTimeMillis();
        auxRev.Merge1();
        tfimr=System.currentTimeMillis();
        crev=auxRev.getComparison();
        mrev=auxRev.getMoves();
        
        auxRand.CopiaArq(arqRand);
        tinirand=System.currentTimeMillis();
        auxRand.Merge1();
        tfimrand=System.currentTimeMillis();
        crand=auxRand.getComparison();
        mrand=auxRand.getMoves();
        gravarLin("Merge 1", cord, 0, mord, 0, (tfimo-tinio)/1000, 
                crev,0, mrev, 0, (tfimr-tinir)/1000, 
                crand,0, mrand, 0, (tfimrand-tinirand)/1000);
        //Merge 2
        arqOrd.setComparison(0);
        arqOrd.setMoves(0);
        auxRev.setComparison(0);
        auxRev.setMoves(0);
        auxRand.setComparison(0);
        auxRand.setMoves(0);
        tinio=System.currentTimeMillis();
        arqOrd.Merge2();
        tfimo=System.currentTimeMillis();
        cord=arqOrd.getComparison();
        mord=arqOrd.getMoves();
        
        auxRev.CopiaArq(arqRev); 
        tinir=System.currentTimeMillis();
        auxRev.Merge2();
        tfimr=System.currentTimeMillis();
        crev=auxRev.getComparison();
        mrev=auxRev.getMoves();
        
        auxRand.CopiaArq(arqRand);
        tinirand=System.currentTimeMillis();
        auxRand.Merge2();
        tfimrand=System.currentTimeMillis();
        crand=auxRand.getComparison();
        mrand=auxRand.getMoves();
        gravarLin("Merge 2", cord, 0, mord, 0, (tfimo-tinio)/1000, 
                crev,0, mrev, 0, (tfimr-tinir)/1000, 
                crand,0, mrand, 0, (tfimrand-tinirand)/1000);
       //Counting
        arqOrd.setComparison(0);
        arqOrd.setMoves(0);
        auxRev.setComparison(0);
        auxRev.setMoves(0);
        auxRand.setComparison(0);
        auxRand.setMoves(0);
        tinio=System.currentTimeMillis();
        arqOrd.Counting();
        tfimo=System.currentTimeMillis();
        cord=arqOrd.getComparison();
        mord=arqOrd.getMoves();
        
        auxRev.CopiaArq(arqRev); 
        tinir=System.currentTimeMillis();
        auxRev.Counting();
        tfimr=System.currentTimeMillis();
        crev=auxRev.getComparison();
        mrev=auxRev.getMoves();
        
        auxRand.CopiaArq(arqRand);
        tinirand=System.currentTimeMillis();
        auxRand.Counting();
        tfimrand=System.currentTimeMillis();
        crand=auxRand.getComparison();
        mrand=auxRand.getMoves();
        gravarLin("Counting", cord, 0, mord, 0, (tfimo-tinio)/1000, 
                crev,0, mrev, 0, (tfimr-tinir)/1000, 
                crand,0, mrand, 0, (tfimrand-tinirand)/1000);
        //Bucket
        arqOrd.setComparison(0);
        arqOrd.setMoves(0);
        auxRev.setComparison(0);
        auxRev.setMoves(0);
        auxRand.setComparison(0);
        auxRand.setMoves(0);
        tinio=System.currentTimeMillis();
        arqOrd.Bucket();
        tfimo=System.currentTimeMillis();
        cord=arqOrd.getComparison();
        mord=arqOrd.getMoves();
        
        auxRev.CopiaArq(arqRev); 
        tinir=System.currentTimeMillis();
        auxRev.Bucket();
        tfimr=System.currentTimeMillis();
        crev=auxRev.getComparison();
        mrev=auxRev.getMoves();
        
        auxRand.CopiaArq(arqRand);
        tinirand=System.currentTimeMillis();
        auxRand.Bucket();
        tfimrand=System.currentTimeMillis();
        crand=auxRand.getComparison();
        mrand=auxRand.getMoves();
        gravarLin("Bucket", cord, 0, mord, 0, (tfimo-tinio)/1000, 
                crev,0, mrev, 0, (tfimr-tinir)/1000, 
                crand,0, mrand, 0, (tfimrand-tinirand)/1000);
       //Radix
        arqOrd.setComparison(0);
        arqOrd.setMoves(0);
        auxRev.setComparison(0);
        auxRev.setMoves(0);
        auxRand.setComparison(0);
        auxRand.setMoves(0);
        tinio=System.currentTimeMillis();
        arqOrd.Radix();
        tfimo=System.currentTimeMillis();
        cord=arqOrd.getComparison();
        mord=arqOrd.getMoves();
        
        auxRev.CopiaArq(arqRev); 
        tinir=System.currentTimeMillis();
        auxRev.Radix();
        tfimr=System.currentTimeMillis();
        crev=auxRev.getComparison();
        mrev=auxRev.getMoves();
        
        auxRand.CopiaArq(arqRand);
        tinirand=System.currentTimeMillis();
        auxRand.Radix();
        tfimrand=System.currentTimeMillis();
        crand=auxRand.getComparison();
        mrand=auxRand.getMoves();
        gravarLin("Radix", cord, 0, mord, 0, (tfimo-tinio)/1000, 
                crev,0, mrev, 0, (tfimr-tinir)/1000, 
                crand,0, mrand, 0, (tfimrand-tinirand)/1000);
        //CombSort
        arqOrd.setComparison(0);
        arqOrd.setMoves(0);
        auxRev.setComparison(0);
        auxRev.setMoves(0);
        auxRand.setComparison(0);
        auxRand.setMoves(0);
        tinio=System.currentTimeMillis();
        arqOrd.Comb();
        tfimo=System.currentTimeMillis();
        cord=arqOrd.getComparison();
        mord=arqOrd.getMoves();
        
        auxRev.CopiaArq(arqRev); 
        tinir=System.currentTimeMillis();
        auxRev.Comb();
        tfimr=System.currentTimeMillis();
        crev=auxRev.getComparison();
        mrev=auxRev.getMoves();
        
        auxRand.CopiaArq(arqRand);
        tinirand=System.currentTimeMillis();
        auxRand.Comb();
        tfimrand=System.currentTimeMillis();
        crand=auxRand.getComparison();
        mrand=auxRand.getMoves();
        gravarLin("Comb", cord, 0, mord, 0, (tfimo-tinio)/1000, 
                crev,0, mrev, 0, (tfimr-tinir)/1000, 
                crand,0, mrand, 0, (tfimrand-tinirand)/1000);
       //Gnome
        arqOrd.setComparison(0);
        arqOrd.setMoves(0);
        auxRev.setComparison(0);
        auxRev.setMoves(0);
        auxRand.setComparison(0);
        auxRand.setMoves(0);
        tinio=System.currentTimeMillis();
        arqOrd.Gnome();
        tfimo=System.currentTimeMillis();
        cord=arqOrd.getComparison();
        mord=arqOrd.getMoves();
        
        auxRev.CopiaArq(arqRev); 
        tinir=System.currentTimeMillis();
        auxRev.Gnome();
        tfimr=System.currentTimeMillis();
        crev=auxRev.getComparison();
        mrev=auxRev.getMoves();
        
        auxRand.CopiaArq(arqRand);
        tinirand=System.currentTimeMillis();
        auxRand.Gnome();
        tfimrand=System.currentTimeMillis();
        crand=auxRand.getComparison();
        mrand=auxRand.getMoves();
        gravarLin("Gnome", cord, 0, mord, 0, (tfimo-tinio)/1000, 
                crev,0, mrev, 0, (tfimr-tinir)/1000, 
                crand,0, mrand, 0, (tfimrand-tinirand)/1000);
        //Tim
        arqOrd.setComparison(0);
        arqOrd.setMoves(0);
        auxRev.setComparison(0);
        auxRev.setMoves(0);
        auxRand.setComparison(0);
        auxRand.setMoves(0);
        tinio=System.currentTimeMillis();
        arqOrd.Tim();
        tfimo=System.currentTimeMillis();
        cord=arqOrd.getComparison();
        mord=arqOrd.getMoves();
        
        auxRev.CopiaArq(arqRev); 
        tinir=System.currentTimeMillis();
        auxRev.Tim();
        tfimr=System.currentTimeMillis();
        crev=auxRev.getComparison();
        mrev=auxRev.getMoves();
        
        auxRand.CopiaArq(arqRand);
        tinirand=System.currentTimeMillis();
        auxRand.Tim();
        tfimrand=System.currentTimeMillis();
        crand=auxRand.getComparison();
        mrand=auxRand.getMoves();
        gravarLin("Tim", cord, 0, mord, 0, (tfimo-tinio)/1000, 
                crev,0, mrev, 0, (tfimr-tinir)/1000, 
                crand,0, mrand, 0, (tfimrand-tinirand)/1000);
    }
}
