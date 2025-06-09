import java.util.Random;
import java.util.Scanner;

public class Sistema {
    Random rng = new Random();
    Scanner scan = new Scanner(System.in);

    int a=9, b=9;

    int Armadilhas[] = new int[5];
    String Mapa[][] = new String[8][8];
    
    //depois substituir "public" das funções por "private" e criar uma função Iniciar().
    
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
           }
           while (!Mapa[linha][coluna].equals("~"));
           
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
           }
           while (!Mapa[linha][coluna].equals("~"));
           
           Mapa[linha][coluna] = "a";           
        }
        
        
    }

//precisa-se fazer verificação da randomização, pois está sobrepondo

//________________________________________________________________
    public int Juntar(int a, int b) {
        this.a = a;
        this.b = b;

        this.a *= 10;
        int soma = this.a + this.b;

        return soma;
    }



    
}

