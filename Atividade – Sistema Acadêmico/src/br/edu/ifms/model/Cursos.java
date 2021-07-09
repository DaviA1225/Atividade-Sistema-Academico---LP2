package br.edu.ifms.model;

import br.edu.ifms.exception.AtributoDeInvalidade;

public class Cursos {
	
	private int codigo;
	private  int nivel;
	private  String nome;
	private  int cargaHoraria;
	private  boolean situacao;
	
	public Cursos() {
		this.codigo = 0;
	}
	
	public Cursos(int nivel, int cargaHoraria, String nome, boolean situacao) throws Exception {
		
		this.codigo = 0;
		this.setNivel (nivel);
		this.setNome (nome);
		this.setCargaHoraria (cargaHoraria);
		this.setSituacao (situacao);
		
	}
	
	public Cursos(int codigo, int nivel, String nome, int cargaHoraria, boolean situacao) throws Exception {
		this(nivel, cargaHoraria, nome, situacao);
		this.codigo=codigo;
	}
	
	public int getCodigo() {
		return codigo;
	}
	
	public void setCodigo (int codigo) throws Exception {
		if (codigo<0) {
			throw new Exception("O CÓDIGO DEVE SER UM NÚMERO MAIOR QUE 0 ");
		}
		if(codigo == 0) {
			throw new AtributoDeInvalidade("");
		}
		
		this.codigo = codigo;
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) throws Exception {
		if(nome!=null && nome.length()>0 && nome.length()<=50) {
			this.nome = nome;	
		}else {
			throw new Exception("O NOME DO CURSO NÃO DEVE TER MAIS DE 50 CARACTERES");
		}
		
	}

	public int getNivel() {
		return nivel;
	}

	public void setNivel(int nivel) throws Exception {
		if(nivel>=1 && nivel<=3) {
			this.nivel = nivel;
		}else {
			throw new Exception("O NIVEL DO CURSO DEVE SER ENTRE 1 E 5");
		}
		
	}
	public String getNomeNivel() {
		switch(this.nivel) {
		case 1:
			return"1";
		case 2:
			return"2";
		case 3:
			return"3";
		/*case 4:
			return"NÍVEL 4";
		case 5:
			return"NÍVEL 5";*/
		default:
			return null;
		}
	}
	
	public boolean isValid() {
		if(this.nome!=null && this.nivel>=1 && this.nivel <=5) {
			return true;
		}
		return false;
	}

	

	public int getCargaHoraria() {
		return cargaHoraria;
	}

	public void setCargaHoraria(int cargaHoraria) {
		this.cargaHoraria = cargaHoraria;
	}

	public boolean getSituacao() {
		return situacao;
	}
	
	/*public String getSituacaoTexto()//caso queira o nome da SITUAÇAO {
		if(this.situacao) {
			return "Em Curso";
		}else {
			return "Inativo";	
		}
	}*/

	public void setSituacao(boolean situacao) {
		this.situacao = situacao;
	}

	

}
