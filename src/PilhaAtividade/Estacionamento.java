/**
 *
 * @author Aldo Wanderley Costa Junior
 */
package PilhaAtividade;

import ListaDuplamenteEncadeada.ListaEncadeadaDupla;

import estruturadedados.PilhaAoContrario;

public class Estacionamento {
   PilhaAoContrario<Carro> carros = new ListaEncadeadaDupla<>();
   PilhaAoContrario<Carro> carrosRemovidos = new ListaEncadeadaDupla<>();
   int total = 0;
   public void estacionar(String placa){
      if(total < 10){
          System.out.println("Existe Vaga!");
          Carro carro = new Carro(placa);
          carros.PushI(carro);
          this.total++;
      }else{
          System.out.println("Estacionamento ja lotado, volte na proxima");
      }
      
   }
   
   public void sairDaVaga(String placa){
       int pos = localizarPosicaoCarro(placa);
       if(pos == 0){
           this.carros.PopI();
           System.out.println(1);
       }else{
           Carro carroR;
           for (int i = 0; i <= pos; i++) {
               if(!this.carros.TopI().getPlaca().equals(placa)){
                   carroR = this.carros.PopI();
                   this.carrosRemovidos.PushI(carroR);
                 
               }else{
                   this.carros.PopI();
               }
           }
           System.out.println(this.carrosRemovidos.size());
           System.out.println(this.carrosRemovidos);
           
           while(!this.carrosRemovidos.isEmpty()){
               Carro carro = this.carrosRemovidos.PopI();
               this.carros.PushI(carro);
               System.out.println(carros);
           }
           
       }
       System.out.println(this.carrosRemovidos);
   }
   
   public int localizarPosicaoCarro(String placa){
       int pos, contador = 0;
       for(Carro carro: this.carros){
           contador ++;
           if(carro.getPlaca().equals(placa)){
               return (pos=contador)-1;
           }
       }
       return -1;
   }

    @Override
    public String toString() {
        return "" + "Carros=" + carros + "";
    }

}
