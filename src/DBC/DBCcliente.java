package DBC;

import Bean.cliente;
import com.db4o.Db4oEmbedded;
import com.db4o.ObjectContainer;
import com.db4o.ObjectSet;
import com.db4o.query.Query;
import java.util.ArrayList;
import javax.swing.JOptionPane;


public class DBCcliente {
    
    
    public boolean cpfExistente(String cpf){
       com.db4o.ObjectContainer db = Db4oEmbedded.openFile(Db4oEmbedded.newConfiguration(),"Banco1");
       try{
           ObjectSet<cliente> result = db.queryByExample(new cliente(cpf, null, null));
           return !result.isEmpty();
       }
       finally{
           db.close();
       }
    }
    public void insert(cliente p, String cpf){
        com.db4o.ObjectContainer db = Db4oEmbedded.openFile(Db4oEmbedded.newConfiguration(),"Banco1");
        try{
            if(cpfExistente(p.getCpf())){
                JOptionPane.showMessageDialog(null,"Cpf ja cadastrado");
                return;
            }
            db.store(p);
            JOptionPane.showMessageDialog(null,"Usuário cadastrado com sucesso!");
        }finally{
            db.close();

        }   
    }


    
    public void delete(cliente p, String cpf){
        com.db4o.ObjectContainer db = Db4oEmbedded.openFile(Db4oEmbedded.newConfiguration(),"Banco1");
        try{
            ObjectSet<cliente> result = db.queryByExample(new cliente(cpf, null,null));
            if( result.hasNext()){
                cliente clienteEncontrado = result.next();
                db.delete(clienteEncontrado);
                JOptionPane.showMessageDialog(null,"Cliente deletado com sucesso!");
            }   
            else{
                JOptionPane.showMessageDialog(null,"Cliente não encontrado");
            }
        }finally{
            db.close();
            
        }
        }
    public ArrayList<cliente> listarTudo(){
        com.db4o.ObjectContainer db = Db4oEmbedded.openFile(Db4oEmbedded.newConfiguration(),"Banco1");
        ArrayList<cliente> lista = new ArrayList();
        try{
            cliente p = new cliente();
            ObjectSet<cliente> queryByExample = db.queryByExample(p);
            while(queryByExample.hasNext()){
                cliente Cliente = queryByExample.next();
                lista.add(Cliente);
        }
        }finally{
            db.close();
            return lista;
        }
        }
}