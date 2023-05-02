package ifmt.cba.persistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import ifmt.cba.util.FabricaConexao;
import ifmt.cba.vo.CursoVO;

public class CursoDAO {
    
    private Connection conexao;
    private PreparedStatement comandoInclusao;
    private PreparedStatement comandoAlteracao;
    private PreparedStatement comandoExclusao;
    private PreparedStatement comandoSelecaoCodigo;
    private PreparedStatement comandoSelecaoNome;
 
    public CursoDAO() throws PersistenciaException {
        try {
            this.conexao = FabricaConexao.obterConexao();
            this.comandoInclusao = conexao.prepareStatement(
                "INSERT INTO curso ( nome, cargahoraria, numsemestre ) VALUES ( ?, ?, ? )"
            );
            this.comandoAlteracao = conexao.prepareStatement(
                "UPDATE curso SET nome=?, cargahoraria=?, numsemestre=? WHERE codigo=?"
            );
            this.comandoExclusao = conexao.prepareStatement(
                "DELETE FROM curso WHERE codigo=?"
            );
            this.comandoSelecaoCodigo = conexao.prepareStatement(
                "SELECT * FROM curso WHERE codigo=?"
            );
            this.comandoSelecaoNome = conexao.prepareStatement(
                "SELECT * FROM curso WHERE upper(nome) LIKE ?"
            );
        } catch (Exception e) {
            throw new PersistenciaException("Erro ao preparar a persistencia - " +e.getMessage());
        }
        
    }
    
    public void incluir(CursoVO cursoVO) throws PersistenciaException {
        try {
            this.comandoInclusao.setString(1, cursoVO.getNome());
            this.comandoInclusao.setInt(2, cursoVO.getCargahoraria());
            this.comandoInclusao.setInt(3, cursoVO.getNumsemestre());
            this.comandoInclusao.executeUpdate();
        } catch (SQLException sqle) {
            throw new PersistenciaException("Erro ao inclur curso - " + sqle.getMessage());
        }
    }

    public void alterar(CursoVO cursoVO) throws PersistenciaException {
        try{
            this.comandoAlteracao.setString(1, cursoVO.getNome());
            this.comandoAlteracao.setInt(2, cursoVO.getCargahoraria());
            this.comandoAlteracao.set
        }
    }
}
