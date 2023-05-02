package ifmt.cba.negocio;

import java.util.List;

import ifmt.cba.persistencia.AlunoDAO;
import ifmt.cba.persistencia.FabricaEntityManager;
import ifmt.cba.persistencia.PersistenciaException;
import ifmt.cba.vo.AlunoVO;

public class AlunoNegocio {

    private AlunoDAO alunoDAO;

    public AlunoNegocio() throws NegocioException {
        try {
            this.alunoDAO = new AlunoDAO(FabricaEntityManager.getEntityManager());
        } catch (PersistenciaException ex) {
            throw new NegocioException("Erro ao iniciar a Persistencia − " + ex.getMessage());
        }
    }

    public void inserir(AlunoVO alunoVO) throws NegocioException {

        String mensagemErros = this.validarDados(alunoVO);

        if (!mensagemErros.isEmpty()) {
            throw new NegocioException(mensagemErros);
        }

        try {
          alunoDAO.beginTransaction();
          alunoDAO.incluir(alunoVO);
          alunoDAO.commitTransaction();
        } catch (PersistenciaException ex) {
            alunoDAO.rollbackTransaction();
            throw new NegocioException("Erro ao incluiroaluno−" + ex.getMessage());
        }
    }

    public void alterar(AlunoVO alunoVO) throws NegocioException {
        String mensagemErros = this.validarDados(alunoVO);
        if (!mensagemErros.isEmpty()) {
            throw new NegocioException(mensagemErros);
        }
        try {
            alunoDAO.beginTransaction();
            alunoDAO.incluir(alunoVO);
            alunoDAO.commitTransaction();
        } catch (PersistenciaException ex) {
            alunoDAO.rollbackTransaction();
            throw new NegocioException("Erroaoalteraroaluno−" + ex.getMessage());
        }
    }

    public void excluir(AlunoVO alunoVO) throws NegocioException {
        try {
            alunoDAO.beginTransaction();
            alunoDAO.incluir(alunoVO);
            alunoDAO.commitTransaction();
        } catch (PersistenciaException ex) {
            alunoDAO.rollbackTransaction();
            throw new NegocioException("Erroaoexcluiroaluno−" + ex.getMessage());
        }
    }

    public List<AlunoVO> pesquisaParteNome(String parteNome) throws NegocioException {
        try {
            return alunoDAO.buscaPorNome(parteNome);
        } catch (PersistenciaException ex) {
            throw new NegocioException("Erro ao pesquisar aluno pelo nome − " + ex.getMessage());
        }
    }

    public AlunoVO pesquisaMatricula(int matricula) throws NegocioException {
        try {
            return alunoDAO.buscarPorMatricula(matricula);
        } catch (PersistenciaException ex) {
            throw new NegocioException("Erroaopesquisaralunopelamatricula−" + ex.getMessage());
        }
    }

    private String validarDados(AlunoVO alunoVO) {

        String mensagemErros = "";

        if (alunoVO.getNome() == null || alunoVO.getNome().length() == 0) {
            mensagemErros += "Nomedoalunonaopodeservazio";
        }

        if (alunoVO.getNomeMae() == null || alunoVO.getNomeMae().length() == 0) {
            mensagemErros += "\nNomedamaenaopodeservazio";
        }

        if (alunoVO.getNomePai() == null || alunoVO.getNomePai().length() == 0) {
            mensagemErros += "\nNomedopainaopodeservazio";
        }

        if (alunoVO.getSexo() == null) {
            mensagemErros += "\nSexonaopodesernulo";
        }

        if (alunoVO.getEndereco().getLogradouro() == null || alunoVO.getEndereco().getLogradouro().length() == 0) {
            mensagemErros += "\nLogradouronaopodeservazio";
        }

        if (alunoVO.getEndereco().getNumero() <= 0) {
            mensagemErros += "\nNumerodevesermaiorquezero";
        }

        if (alunoVO.getEndereco().getBairro() == null || alunoVO.getEndereco().getBairro().length() == 0) {
            mensagemErros += "\nBairronaopodeservazio";
        }

        if (alunoVO.getEndereco().getCidade() == null || alunoVO.getEndereco().getCidade().length() == 0) {
            mensagemErros += "\nCidadenaopodeservazio";
        }
        if (alunoVO.getEndereco().getUf() == null) {
            mensagemErros += "\nUFnaopodeservazio";
        }

        return mensagemErros;
    }
}