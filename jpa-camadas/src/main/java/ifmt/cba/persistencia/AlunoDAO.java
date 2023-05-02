package ifmt.cba.persistencia;

import java.util.ArrayList;
import java.util.List;

import ifmt.cba.vo.AlunoVO;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;

public class AlunoDAO extends DAO<AlunoVO> {
    
    public AlunoDAO(EntityManager entityManager) throws PersistenciaException {
        super(entityManager);
    }

    public AlunoVO buscarPorMatricula(int matricula) throws PersistenciaException {

        AlunoVO alu = null;

        try {
            alu = this.entityManager.find(AlunoVO.class, matricula);
        } catch (Exception ex) {
            throw new PersistenciaException("Erro na selecao por matricula - " + ex.getMessage());
        }
        return alu;
    }

    @SuppressWarnings("unchecked")
    public List<AlunoVO> buscaPorNome(String nome) throws PersistenciaException {
        List<AlunoVO> listaAluno = new ArrayList<AlunoVO>();

        try {
            Query query = this.entityManager
                .createQuery("SELECT a FROM AlunoVO a WHERE UPPER(a.nome) LIKE :pNome ORDER BY a.nome");
            query.setParameter("pNome", "%" + nome.toUpperCase().trim() + "%");
            listaAluno = query.getResultList();
        } catch (Exception ex) {
            throw new PersistenciaException("Erro na selecao por nome - " + ex.getMessage());
        }
        return listaAluno;
    }
}
