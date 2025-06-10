import java.util.Random;
import java.util.Scanner;

public class Sistema {
    Random rng = new Random();
    Scanner scan = new Scanner(System.in);

    int PA, PB, temp;

    int pontoEspecifico[][] = new int[8][8];
    String Mapa[][] = new String[8][8];
    //         Li Co
    
    //depois substituir "public" das funções por "private" e criar uma função Iniciar().
    /*

    public void Iniciar() {
        CriarMapa();
        EnterrarTesouro();
        EnterrarArmadilha();
        MostrarMapa();
    }

     */ 
    
    public void CriarMapa() {
        for (int i = 0; i < Mapa.length; i++) {
            for (int j = 0; j < Mapa[i].length; j++) {
                Mapa[i][j] = "~";
                
            } 
            
        }
        
    }

    public void MostrarMapa() {
        System.out.print("   "); 

        for (int coluna = 0; coluna < Mapa[0].length; coluna++) {
            System.out.print(coluna + " ");
        }

        System.out.println();

        for (int i = 0; i < Mapa.length; i++) {
            System.out.print(i + "  ");

            for (int j = 0; j < Mapa[i].length; j++) {
                System.out.print(Mapa[i][j] + " ");
            }
            System.out.println();
        }
    
    }

//__________________________________________________________________
    //teste de randomizar os itens
    
    public void EnterrarTesouro() {
        for (int i = 0; i <= 7; i++) {
           int linha;
           int coluna;
           do {
            linha = rng.nextInt(Mapa.length);
            coluna = rng.nextInt(Mapa.length);
           } while (!Mapa[linha][coluna].equals("~"));
           
           temp = (linha * 10) + coluna;
           Mapa[linha][coluna] = "t";       
        }

    }

    public void EnterrarArmadilha() {
        for (int i = 0; i <= 4; i++) {
           int linha;
           int coluna;
           do {
            linha = rng.nextInt(Mapa.length);
            coluna = rng.nextInt(Mapa.length);
           } while (!Mapa[linha][coluna].equals("~"));
           
           temp = (linha * 10) + coluna;
           Mapa[linha][coluna] = "a";      
        }
        
    }



//________________________________________________________________
     public void Juntar(int PA, int PB) {
        this.PA = PA;
        this.PB = PB;

        int soma = (PA * 10) + PB;

        if (PA < 0 || PA > 7 && PB < 0 || PB > 7) {
            System.out.println("Entrada inválida");
            return;
        }
        else {
            
        }


    } 



    
}

