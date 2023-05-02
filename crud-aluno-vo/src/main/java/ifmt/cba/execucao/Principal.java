package ifmt.cba.execucao;

import java.util.List;
import javax.swing.JOptionPane;
import ifmt.cba.negocio.AlunoNegocio;
import ifmt.cba.negocio.NegocioException;
import ifmt.cba.vo.AlunoVO;
import ifmt.cba.vo.EnumSexo;
import ifmt.cba.vo.EnumUF;

public class Principal {

    private static AlunoNegocio alunoNegocio;

    public static void main(String[] args) {
        try {
            alunoNegocio = new AlunoNegocio();
        } catch (NegocioException ex) {
            System.out.println("Camada de negocio e persistencia nao iniciada - " + ex.getMessage());
        }

        if (alunoNegocio != null) {
            EnumMenu opcao = EnumMenu.Sair;
            do {
                try {
                    opcao = exibirMenu();
                    switch (opcao) {
                        case IncluirAluno:
                            incluirAluno();
                            break;
                        case AlterarAluno:
                            alterarAluno();
                            break;
                        case ExcluirAluno:
                            excluirAluno();
                            break;
                        case PesqMatricula:
                            pesquisarPorMatricula();
                            break;
                        case PesqNome:
                            pesquisarPorNome();
                            break;
                        case Sair:
                            return;
                    }
                } catch (NegocioException ex) {
                    System.out.println("Operacao nao realizada corretamente - " + ex.getMessage());
                }
            } while (opcao != EnumMenu.Sair);
        }
        System.exit(0);
    }

    /**
     * Incluiumnovoalunonabasededados
     * 
     * //@throwsNegocioException
     */
    private static void incluirAluno() throws NegocioException {

        AlunoVO alunoTemp = lerDados();
        alunoNegocio.inserir(alunoTemp);
    }

    /**
     * Permiteaalteracaodosdadosdeumalunopormeiodamatricula
     * fornecida.
     * 
     * //@throwsNegocioException
     */
    private static void alterarAluno() throws NegocioException {
        int matricula = 0;
        try {
            matricula = Integer.parseInt(JOptionPane.showInputDialog(null, "Forneca a matriculado Aluno", "Leitura de Dados",
                    JOptionPane.QUESTION_MESSAGE));
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Digitacao inconsistente -" + ex.getMessage());
        }

        AlunoVO alunoVO = alunoNegocio.pesquisaMatricula(matricula);
        if (alunoVO != null) {
            AlunoVO alunoTemp = lerDados(alunoVO);
            alunoNegocio.alterar(alunoTemp);
        } else {
            JOptionPane.showMessageDialog(null, "Aluno nao localizado ");
        }
    }

    /*
     * ∗Excluiumalunopormeiodeumamatriculafornecida.
     * ∗
     * ∗@ throws NegocioException
     */
    private static void excluirAluno() throws NegocioException {
        int matricula = 0;
        try {
            matricula = Integer.parseInt(JOptionPane.showInputDialog(null, "Forneca a matriculado Aluno", "Leitura de Dados",
                    JOptionPane.QUESTION_MESSAGE));
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Digitacao inconsistente-" + ex.getMessage());
        }

        AlunoVO alunoVO = alunoNegocio.pesquisaMatricula(matricula);
        if (alunoVO != null) {
            alunoNegocio.excluir(alunoVO.getMatricula());
        } else {
            JOptionPane.showMessageDialog(null, "Aluno nao localizado");
        }
    }

    /*
     * ∗Pesquisaumalunopormeiodamatricula.
     * @ throws NegocioException
     * 
     */
    private static void pesquisarPorMatricula() throws NegocioException {
        int matricula = 0;
        try {
            matricula = Integer.parseInt(JOptionPane.showInputDialog(null, "Forneca a matricula do Aluno",
                    "LeituradeDados", JOptionPane.QUESTION_MESSAGE));
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Digitacao inconsistente-" + ex.getMessage());
        }

        AlunoVO alunoVO = alunoNegocio.pesquisaMatricula(matricula);
        if (alunoVO != null) {
            mostrarDados(alunoVO);
        } else {
            JOptionPane.showMessageDialog(null, "Aluno nao localizado");
        }
    }

    /*
     * 8∗Leumnomeoupartedeumnomedeumalunoebuscanobancodedados
     * 129∗alunosquepossuemessenome,ouqueiniciamcomapartedonome
     * 130∗fornecida.Casonaosejafornecidonenhumvalordeentradaseraretornado
     * 131∗os10primmeirosalunosordenadospelonome.
     * 132∗
     * 133∗@ throws NegocioException
     */
    private static void pesquisarPorNome() throws NegocioException {

        String nome = JOptionPane.showInputDialog(null, "Forneca o nome do Aluno", "Leitura de Dados",
                JOptionPane.QUESTION_MESSAGE);
        if (nome != null) {
            List<AlunoVO> listaAlunoVO = alunoNegocio.pesquisaParteNome(nome);

            if (listaAlunoVO.size() > 0) {
                for (AlunoVO alunoVO : listaAlunoVO) {
                    mostrarDados(alunoVO);
                }
            } else {
                JOptionPane.showMessageDialog(null, "Aluno nao localizado");
            }
        } else {

            JOptionPane.showMessageDialog(null, "Nome nao pode ser nulo");
        }
    }

    /*
     * ∗Exibenoconsoledaaplicacaoosdadosdosalunosrecebidospelo
     * 155∗parametroalunoVO.
     * 156∗
     * 157∗@paramalunoVO
     */
    private static void mostrarDados(AlunoVO alunoVO) {
        if (alunoVO != null) {
            System.out.println("Matricula:" + alunoVO.getMatricula());
            System.out.println("Nome:" + alunoVO.getNome());
            System.out.println("NomedaMae:" + alunoVO.getNomeMae());
            System.out.println("NomedaPai:" + alunoVO.getNomePai());
            System.out.println("Sexo:" + alunoVO.getSexo().name());
            if (alunoVO.getEndereco() != null) {
                System.out.println("Logradouro:" + alunoVO.getEndereco().getLogradouro());
                System.out.println("Numero:" + alunoVO.getEndereco().getNumero());
                System.out.println("Bairro:" + alunoVO.getEndereco().getBairro());
                System.out.println("Cidade:" + alunoVO.getEndereco().getCidade());
                System.out.println("UF:" + alunoVO.getEndereco().getUf());
                System.out.println("-------------------------------------------");
            }
        }
    }

    /*
     * Le os dados de um aluno exibindo os dados atuais recebidos pelo parametro
     * aluno Temp. Na alteracao permite que os dados atuais do alunos sejam
     * visualizados.NainclusÃ£osÃ£oexibidososdadosinicializadosnoAlunoVO.
     * @paramalunoTemp
     * @return
     */
    private static AlunoVO lerDados(AlunoVO alunoTemp) {

        String nome, nomeMae, nomePai, logradouro, bairro, cidade;
        int numero;
        EnumSexo sexo;
        EnumUF uf;

        try {
            nome = JOptionPane.showInputDialog("Fornecao nome do Aluno", alunoTemp.getNome().trim());
            alunoTemp.setNome(nome);
            nomeMae = JOptionPane.showInputDialog("Forneca o nome da mae do Aluno", alunoTemp.getNomeMae().trim());
            alunoTemp.setNomeMae(nomeMae);

            nomePai = JOptionPane.showInputDialog("Fornecao nome do pai do Aluno", alunoTemp.getNomePai().trim());
            alunoTemp.setNomePai(nomePai);

            sexo = (EnumSexo) JOptionPane.showInputDialog(null, "Escolha uma Opcao o", "Leitura de Dados",
                    JOptionPane.QUESTION_MESSAGE, null, EnumSexo.values(), alunoTemp.getSexo());
            alunoTemp.setSexo(sexo);

            logradouro = JOptionPane.showInputDialog("Fornecao logradouro do endereco",
                    alunoTemp.getEndereco().getLogradouro().trim());
            alunoTemp.getEndereco().setLogradouro(logradouro);

            numero = Integer.parseInt(JOptionPane.showInputDialog("Forneca o numero no endereco",
                    alunoTemp.getEndereco().getNumero()));
            alunoTemp.getEndereco().setNumero(numero);

            bairro = JOptionPane.showInputDialog("Fornecao bairro no endereco",
                    alunoTemp.getEndereco().getBairro().trim());
            alunoTemp.getEndereco().setBairro(bairro);

            cidade = JOptionPane.showInputDialog("Forneca a cidade no endereco",
                    alunoTemp.getEndereco().getCidade().trim());
            alunoTemp.getEndereco().setCidade(cidade);

            uf = (EnumUF) JOptionPane.showInputDialog(null, "Escolha uma Opcao", "Leitura de Dados",
                    JOptionPane.QUESTION_MESSAGE, null, EnumUF.values(), alunoTemp.getEndereco().getUf());
            alunoTemp.getEndereco().setUf(uf);
        } catch (Exception ex) {
            System.out.println("Digitacao inconsistente-" + ex.getMessage());
        }
        return alunoTemp;
    }

    //Cria uma nova intancia de AlunoVO e chama o metodo lerdados(AlunoVO)
    private static AlunoVO lerDados() {
        AlunoVO alunoTemp = new AlunoVO();
        return lerDados(alunoTemp);
    }

    //Exibe as opcoes por meio de uma tela de dialogo.
    private static EnumMenu exibirMenu() {
        EnumMenu opcao;

        opcao = (EnumMenu) JOptionPane.showInputDialog(null, "Escolha uma Opcao", "Menu",
                JOptionPane.QUESTION_MESSAGE, null, EnumMenu.values(), EnumMenu.values()[0]);
        if (opcao == null) {
            JOptionPane.showMessageDialog(null, "Nenhuma Opcao Escolhida");
            opcao = EnumMenu.Sair;
        }
        return opcao;
    }
}