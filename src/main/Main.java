package main;

public class Main {

    public static void main(String[] args) {
        AbrirVentana.getInstance().vLogin();
    }
    
    private static Main instancia;
    
    public static Main getInstance() {
        if (instancia == null) {
            instancia = new Main();
        }
        return instancia;
    }
  
    private Main(){} 
    
    int id;
    
    public void setId(int id){
        this.id = id;      
    }  
    public int getId(){     
        return id;      
    }
    
}
