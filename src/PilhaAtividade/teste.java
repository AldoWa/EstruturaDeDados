/**
 *
 * @author Aldo Wanderley Costa Junior
 */
package PilhaAtividade;

public class teste {
    public static void main(String[] args) {
        Estacionamento e = new Estacionamento();
        e.estacionar("NEX4349");
        e.estacionar("MZA3392");
        e.estacionar("EIV2040");
        e.estacionar("JEO7809");
        e.estacionar("NAD5430");
        e.estacionar("HXI4687");
        e.estacionar("JHF1063");
        e.estacionar("NAA5719");
        e.estacionar("GUS0365");
        e.estacionar("AGN3513");
        e.estacionar("JTH7571");
      
        System.out.println(e);
          e.sairDaVaga("MZA3392");
        System.out.println(e);
    }
}
