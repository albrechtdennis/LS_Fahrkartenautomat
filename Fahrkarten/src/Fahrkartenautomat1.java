import java.util.Scanner;

class Fahrkartenautomat1
{
    public static double fahrkartenbestellungErfassen()
    {
       double zuZahlenderBetrag = 0;
       int ticketAuswahl = 0;
       Scanner tastatur = new Scanner(System.in);
       double zuZahlenderBetrag1 = 0;
       
       
       do {
    	   System.out.println("Wählen Sie ihre Wunschfahrkarte für Berlin AB aus: ");
    	   System.out.println("Einzelfahrschein Regltarif AB [2,90 EUR] (1)");
    	   System.out.println("Tageskarte Regltarif AB [8,60 EUR] (2)");
    	   System.out.println("Kleingruppen-Tageskarte Regltarif AB [23,50 EUR] (3)");
    	   System.out.println("Bezahlen (8)");
       
    	   System.out.println("\n");
    	   System.out.println("Ihre Wahl: ");
    	   ticketAuswahl =  tastatur.nextInt();
       
         switch(ticketAuswahl) 
         {
          case 1:
            zuZahlenderBetrag1 = 2.90;
            break;
         
          case 2:
            zuZahlenderBetrag1 =  8.60;
            break;
          
          case 3:
            zuZahlenderBetrag1 = 23.50;
            break;
            
          case 8:
        	  System.out.println("Bezahlen");
        	  break;
        	  
          default:
            System.out.println(">>falsche Eingabe<< \n");
            
         }
        //zuZahlenderBetrag += zuZahlenderBetrag1;
       //System.out.printf("%.2f\n" , zuZahlenderBetrag);
       //}while((ticketAuswahl !=8));
      
       
       //Anzahl der Tickets
       //------------------
       //Anzahl der Tickets wird bei falscher Eingabe auf 0 gesetzt
       /*int anzahlDerTickets = 0;
       System.out.println("Bitte geben Sie ihre Ticketanzahl an zwischen 1 und 10: ");
       anzahlDerTickets = tastatur.nextInt();
       
       if((1 <= anzahlDerTickets)&&(anzahlDerTickets<=10)){
         System.out.println("Die Ticketanzahl ist korrekt.");
       }
       else {
    	   anzahlDerTickets=1;
    	   System.out.println("Tickets wurden auf 1 gesetzt: ");  
       }*/
       if(ticketAuswahl!=8) {
       int anzahlDerTickets = 0;
       System.out.println("Bitte geben Sie ihre Ticketanzahl an: ");
       anzahlDerTickets = tastatur.nextInt();
       
       while((anzahlDerTickets < 1)||(anzahlDerTickets > 10)){
         System.out.println("Die Ticketanzahl kann nur zwischen 1 und 10 liegen.");
         System.out.println("Geben Sie eine gültige Anzahl an: "); 
         anzahlDerTickets = tastatur.nextInt();
       }
       zuZahlenderBetrag1 *= anzahlDerTickets;
       zuZahlenderBetrag += zuZahlenderBetrag1;
       }
       }while(ticketAuswahl !=8);
       
       return zuZahlenderBetrag;
    
    }
    
    public static double fahrkartenBezahlen(double zuZahlenderBetrag){
       double eingezahlterGesamtbetrag;
         double eingeworfeneMünze;
         Scanner tastatur = new Scanner(System.in);
       
       // Geldeinwurf
       // -----------
       eingezahlterGesamtbetrag = 0.0;
       while(eingezahlterGesamtbetrag < zuZahlenderBetrag)
       {
         System.out.format("Noch zu zahlen: %4.2f €%n" , (zuZahlenderBetrag - eingezahlterGesamtbetrag));
         System.out.print("Eingabe (mind. 5Ct, höchstens 10 Euro): ");
         eingeworfeneMünze = tastatur.nextDouble();
           eingezahlterGesamtbetrag += eingeworfeneMünze;
       }
       return eingezahlterGesamtbetrag - zuZahlenderBetrag;
    }

    public static void fahrkartenAusgeben() {
       // Fahrscheinausgabe
       // -----------------
       System.out.println("\nFahrschein wird ausgegeben");
       for (int i = 0; i < 8; i++)
       {
          System.out.print("=");
          try {
      Thread.sleep(250);
          } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
          }
        }
        System.out.println("\n\n");
    }
    
    public static void rueckgeldAusgeben(double rückgabebetrag) {
       // Rückgeldberechnung und -Ausgabe
       // -------------------------------
       if(rückgabebetrag > 0.0)
       {
         System.out.format("Der Rückgabebetrag in Höhe von %4.2f € \n" , rückgabebetrag );
         System.out.println("wird in folgenden Münzen ausgezahlt:");

          while(rückgabebetrag >= 10.0) // 10 EURO-Schein
          {
            System.out.println("10 EURO");
            rückgabebetrag -= 10.0;
          }
          while(rückgabebetrag >= 5.0) // 5 EURO-Schein
          {
            System.out.println("5 EURO");
            rückgabebetrag -= 5.0;
          }
          while(rückgabebetrag >= 2.0) // 2 EURO-Münzen
           {
            System.out.println("2 EURO");
            rückgabebetrag -= 2.0;
           }
           while(rückgabebetrag >= 1.0) // 1 EURO-Münzen
           {
            System.out.println("1 EURO");
            rückgabebetrag -= 1.0;
           }
           while(rückgabebetrag >= 0.5) // 50 CENT-Münzen
           {
            System.out.println("50 CENT");
            rückgabebetrag -= 0.5;
           }
           while(rückgabebetrag >= 0.2) // 20 CENT-Münzen
           {
            System.out.println("20 CENT");
            rückgabebetrag -= 0.2;
           }
           while(rückgabebetrag >= 0.1) // 10 CENT-Münzen
           {
            System.out.println("10 CENT");
            rückgabebetrag -= 0.1;
           }
           while(rückgabebetrag >= 0.05)// 5 CENT-Münzen
           {
            System.out.println("5 CENT");
            rückgabebetrag -= 0.05;
           }
       }
    }
    
    public static void muenzeAusgeben(int betrag, String einheit) {
      System.out.println("" + betrag + " " + einheit);
    }
    
    public static void main(String[] args) {
      double zuZahlenderBetrag;
        double rueckgabebetrag;
        int x = 0;
        
        do {
        zuZahlenderBetrag = fahrkartenbestellungErfassen();
        rueckgabebetrag = fahrkartenBezahlen(zuZahlenderBetrag);
        fahrkartenAusgeben();
        rueckgeldAusgeben(rueckgabebetrag);
    
       System.out.println("\nVergessen Sie nicht, den Fahrschein\n"+
                          "vor Fahrtantritt entwerten zu lassen!\n"+
                          "Wir wünschen Ihnen eine gute Fahrt.\n");
        }while(x==0);
    }
}