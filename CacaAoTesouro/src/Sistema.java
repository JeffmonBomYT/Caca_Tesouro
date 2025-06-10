import java.util.Random;
import java.util.Scanner;

public class Sistema {
    Random rng = new Random();
    Scanner scan = new Scanner(System.in);

    int PA, PB;
    int pontos;

    int Armadilhas[] = new int[5];
    int Tesouros[] = new int[8];
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
        System.out.print("\n   "); 

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
            
            Tesouros[i] = (linha * 10) + coluna;
            //Mapa[linha][coluna] = "T";       
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

           Armadilhas[i] = (linha * 10) + coluna;
           //Mapa[linha][coluna] = "A";      
        }
        
    }



//________________________________________________________________
    public int Juntar(int PA, int PB) {
        this.PA = PA;
        this.PB = PB;

        int soma = (PA * 10) + PB;

        return soma;
    } 

    public void Verificar(int PA, int PB) {
        boolean achou = false;
        int pmp = Juntar(PA, PB);
            
        if (PA < 0 || PA > 7 && PB < 0 || PB > 7) {
            System.out.println("Entrada inválida");
        }

        for (int i = 0; i < Armadilhas.length; i++) {
            if (pmp == Armadilhas[i]) {
                Mapa[PB][PA] = "A";
                pontos-=5;
                System.out.println("\nAchou uma armadilha");
                System.out.println("Pontuação total > "+pontos);
                achou = true;
                break;
            }
           
        }

        for (int i2 = 0; i2 < Tesouros.length; i2++) {
            if (pmp == Tesouros[i2]) {
                Mapa[PB][PA] = "T";
                pontos+=10;
                System.out.println("\nParabéns, Tesouro encontrado!");
                System.out.println("Pontuação total > "+pontos);
                achou = true;
                break;
            }
            
        }

        if (!achou) {
            System.out.println("\nApenas areia...");      
        } 

      

    }


    
}

