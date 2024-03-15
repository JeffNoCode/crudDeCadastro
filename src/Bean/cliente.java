
package Bean;

      //variaveis
public class cliente {
    private String nome;
    private String cpf;
    private String endereco;
    
    //construtores
    public cliente(){}
    
    public cliente(String nome, String cpf, String endereco){
        this.nome = nome;
        this.cpf = cpf;
        this.endereco = endereco;
    }
    
    //gets e sets
    public String getNome() {
        return nome;
    }

    
    public void setNome(String nome) {
        this.nome = nome;
    }

    
    public String getCpf() {
        return cpf;
    }

    
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

   
    public String getEndereco() {
        return endereco;
    }

   
    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }
    @Override
    public String toString() {
        
     return String.format("%s %s %s", cpf, nome, endereco);
}
    }

   
    
        

