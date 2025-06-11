import java.util.Random;
import java.util.Scanner;

public class Sistema {
    Random rng = new Random();
    Scanner scan = new Scanner(System.in);

    int pontos=0, PA, PB;
    int tesouroEncontrado=0, armadilhaEncontrada=0, tentativa=0;

    int Armadilhas[] = new int[5];
    int Tesouros[] = new int[8];
    String MapaFim[][] = new String[8][8];
    String Mapa[][] = new String[8][8];
    //         Li Co

//________________________________________________________________
    public void Iniciar() {
        CriarMapa();
        EnterrarTesouro();
        EnterrarArmadilha();
    }
//________________________________________________________________
    public void Mostrar() {

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
    public void CriarMapa() {
        for (int i = 0; i < Mapa.length; i++) {
            for (int j = 0; j < Mapa[i].length; j++) {
                Mapa[i][j] = "~";                        
            } 
        }
        
    }
//________________________________________________________________
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
//________________________________________________________________
    public void MostrarMapaDesvendado() {
        System.out.print("   "); 

        for (int i = 0; i < Armadilhas.length; i++) {
            int[] valor = separar(Armadilhas[i]);
            Mapa[valor[0]][valor[1]] = "a";
        }
        for (int i = 0; i < Tesouros.length; i++) {
            int[] valor = separar(Tesouros[i]);
            Mapa[valor[0]][valor[1]] = "t";
        }
    
        MostrarMapa();

    }
//________________________________________________________________
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
//________________________________________________________________
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
//________________________________________________________________
    public int[] separar(int val) {
        return new int[]{val / 10, val % 10};
    }
//________________________________________________________________
    public void Verificar(int PA, int PB) {
        boolean achou = false;
        int pmp = Juntar(PA, PB);

        // VERIFICAÇÃO DE ARMADILHA ENCONTRADA
        if (!Mapa[PB][PA].equals("A")) {
            for (int i = 0; i < Armadilhas.length; i++) {
                if (pmp == Armadilhas[i]) {
                    Mapa[PB][PA] = "A";
                    pontos -= 5;
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
        
        // VERIFICAÇÃO DE TESOURO ENCONTRADA
        if (!Mapa[PB][PA].equals("T")) {
            for (int i2 = 0; i2 < Tesouros.length; i2++) {
                if (pmp == Tesouros[i2]) {
                    Mapa[PB][PA] = "T";
                    pontos += 10;
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

        // VERIFICAÇÃO DE AREIA ENCONTRADA
        if (!Mapa[PB][PA].equals("O")) {
            if (!achou) {
                System.out.println("\nApenas areia..."); 
                Mapa[PB][PA] = "O";  
                tentativa++; 
            } 
        }
        // COORDENADA JÁ UTILIZADA
        else {
            System.out.println("Coordenada já utilizada.");
        }

    }
//________________________________________________________________

    public void Pontuacao() {

        System.out.println("\nNível de explorador > ");

        if (pontos < 30) {
            System.out.println("\n[QUE PENA, VOCÊ PERDEU]");
            System.out.println("Precisa de mais prática na exploração");
            System.out.println("Pontos > "+pontos);
        }
        else if (pontos >= 30 && pontos <= 49) {
            System.out.println("\n[QUE PENA, VOCÊ PERDEU]");
            System.out.println("Aventureiro Iniciante");
            System.out.println("Pontos > "+pontos);
        }
        else if (pontos >= 50 && pontos <= 69) {
            System.out.println("\n[QUE PENA, VOCÊ PERDEU]");
            System.out.println("Caçador de Tesouros Experiente!");
            System.out.println("Pontos > "+pontos);
        }
        else if (pontos >= 70) {
            System.out.println("\n[PARABÉNS, VOCÊ VENCEU]");
            System.out.println("Explorador Lendário!");
            System.out.println("Pontos > "+pontos);
        }   
        
    }
//________________________________________________________________
   
}

