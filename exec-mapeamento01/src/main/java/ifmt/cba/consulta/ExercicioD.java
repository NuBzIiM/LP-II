package ifmt.cba.consulta;

import java.util.List;

import ifmt.cba.util.EntityManagerUtil;

import ifmt.cba.vo.ItemVenda;
import ifmt.cba.vo.Venda;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;

public class ExercicioD {
    
    public static void main(String[] args) {
        try {
            EntityManager em = EntityManagerUtil.getEntityManager();
            em.getTransaction().begin();

            Query query = em.createQuery("SELECT v FROM Venda v ORDER BY data");
            @SuppressWarnings("unchecked")
            List <Venda> v = (List <Venda>)query.getResultList();

            for(Venda v1 : v) {
                System.out.println("Codigo: " + v1.getCodigo_venda() + " Data da venda: " + v1.getDataFormata());
                
                for(ItemVenda iv1 : v1.getItem_venda()) {
                    System.out.println("\tCodigo: " + iv1.getCodigo_item() + " Quantidade: " + iv1.getQuantidade() + 
                    " Preco de venda: " + iv1.getPreco_venda() + " Percentual de Desconto: " + iv1.getPerDesconto());
                }
            }

            em.getTransaction().commit();
        } catch (Exception ex) {
            System.out.println(ex.toString());
        }
    }
}
