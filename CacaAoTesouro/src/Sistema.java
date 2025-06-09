import java.util.Random;
import java.util.Scanner;

public class Sistema {
    Random rng = new Random();
    Scanner scan = new Scanner(System.in);

    String Mapa[][] = new String[8][8];

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

    //verificar se A e B tem tesouro, armadilha ou areia
    public void tentativa(byte a, byte b) {
        
    }

    //teste de randomizar os itens
    public void Enterrar() {
        for (int i = 0; i <= 8; i++) {
            int linha = rng.nextInt(Mapa.length);
            int coluna = rng.nextInt(Mapa[0].length); 
    
            for (int j = 0; j <=8; j++){
              Mapa[linha][coluna] = "t";
            
            }             
        }

        
    }



    
}

