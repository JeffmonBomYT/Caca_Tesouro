import java.util.Random;
import java.util.Scanner;

public class Sistema {
    Random rng = new Random();
    Scanner scan = new Scanner(System.in);

    int pontos, PA, PB;
    int tesouroEncontrado=0, armadilhaEncontrada=0, tentativa=0;

    int Armadilhas[] = new int[5];
    int Tesouros[] = new int[8];
    String Mapa[][] = new String[8][8];
    //         Li Co

//________________________________________________________________
    public void Iniciar() {
        CriarMapa();
        EnterrarTesouro();
        EnterrarArmadilha();
    }
//________________________________________________________________
    public void mostrar() {
        MostrarMapa();
        
        System.out.print("\nColuna > ");
        PA = scan.nextInt();
        System.out.print("\nLinha > ");
        PB = scan.nextInt();

        if (PA < 0 || PA >= 8 || PB < 0 || PB >= 8) {
            System.out.println("Entrada inválida");
            return;
        }

        Juntar(PA, PB);
        Verificar(PA, PB);
    }
//________________________________________________________________    
    private void CriarMapa() {
        for (int i = 0; i < Mapa.length; i++) {
            for (int j = 0; j < Mapa[i].length; j++) {
                Mapa[i][j] = "~";      
            } 
        }
        
    }
//________________________________________________________________
    private void MostrarMapa() {
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
//________________________________________________________________
    private void EnterrarTesouro() {
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
//________________________________________________________________
    private void EnterrarArmadilha() {
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
    private int Juntar(int PA, int PB) {
        this.PA = PA;
        this.PB = PB;

        int soma = (PA * 10) + PB;

        return soma;
    } 

    private void Verificar(int PA, int PB) {
        boolean achou = false;
        int pmp = Juntar(PA, PB);

        if (!Mapa[PA][PB].equals("A")) {
            for (int i = 0; i < Armadilhas.length; i++) {
                if (pmp == Armadilhas[i]) {
                    Mapa[PB][PA] = "A";
                    pontos-=5;
                    System.out.println("\nAchou uma armadilha");
                    System.out.println("Pontuação total > "+pontos);
                    tentativa++;
                    armadilhaEncontrada++;
                    achou = true;
                    break;
                }
            }
        }
        else {
            System.out.println("Coordenada já utilizada.");
        }
        
        if (!Mapa[PA][PB].equals("T")) {
            for (int i2 = 0; i2 < Tesouros.length; i2++) {
                if (pmp == Tesouros[i2]) {
                    Mapa[PB][PA] = "T";
                    pontos+=10;
                    System.out.println("\nParabéns, Tesouro encontrado!");
                    System.out.println("Pontuação total > "+pontos);
                    tentativa++;
                    tesouroEncontrado++;
                    achou = true;
                    break;
                }
                
            }
        }
        else {
            System.out.println("Coordenada já utilizada.");
        }

        if (!Mapa[PA][PB].equals("O")) {
            if (!achou) {
                System.out.println("\nApenas areia..."); 
                Mapa[PA][PB] = "O";    
                tentativa++; 
            } 
        }
        else {
            System.out.println("Coordenada já utilizada.");
        }

    }
//________________________________________________________________

    public void Pontuacao() {

        System.out.println("\nNível de explorador > ");

        if (pontos < 30) {
            System.out.println("Precisa de mais prática na exploração");
            System.out.println("Pontos > "+pontos);
        }
        else if (pontos >= 30 && pontos <= 49) {
            System.out.println("Aventureiro Iniciante");
            System.out.println("Pontos > "+pontos);
        }
        else if (pontos >= 50 && pontos <= 69) {
            System.out.println("Caçador de Tesouros Experiente!");
            System.out.println("Pontos > "+pontos);
        }
        else if (pontos >= 70) {
            System.out.println("Explorador Lendário!");
            System.out.println("Pontos > "+pontos);
        }   
        
    }
//________________________________________________________________
    






}

