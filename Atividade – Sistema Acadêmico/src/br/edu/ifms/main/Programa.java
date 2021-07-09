package br.edu.ifms.main;

import java.util.List;
import java.util.Scanner;

import br.edu.ifms.dao.CursoDao;
import br.edu.ifms.dao.ICursoDao;
import br.edu.ifms.model.Cursos;


public class Programa {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		
		int opcao;
		Scanner leitorTerminal = new Scanner(System.in);
		
		do {
			System.out.println("#### DIGITE O NÚMERO CORRESPONDENTE A OPÇÃO DESEJADA: #### ");
			System.out.println("1 - CADASTAR CURSO");
			System.out.println("2 - EDITAR CURSO");
			System.out.println("3 - EXCLUIR CURSO");
			System.out.println("4 - LISTAR CURSO");
			System.out.println("0 - FINALIZAR PROGRAMA");
			
			opcao = leitorTerminal.nextInt();
			leitorTerminal.nextLine();
			
			switch(opcao) {
				case 0:
					break;
				case 1: 
					cadastrarCurso(leitorTerminal);
					break;
				case 2:
					editarCursos(leitorTerminal);
					break;
				case 3: 
					excluirCursos(leitorTerminal);
					break;
				case 4:
					listarCursos();
					break;
				default:
					System.out.println("OPÇAO INVÁLIDA");
			}
		}while(opcao!=0);
	}
	
	
	
	
	private static void cadastrarCurso(Scanner leitorTerminal){
		System.out.println("CADASTRAR CURSOS\n");
		
		System.out.println("INFORME O NOME DO CURSO: ");
		String nome = leitorTerminal.nextLine();
		
		System.out.println("INFORME O NÍVEL DO CURSO: ");
		int nivel = leitorTerminal.nextInt();
		
		System.out.println("INFORME A CARGA HORARIA DO CURSO: ");
		int cargaHoraria = leitorTerminal.nextInt();
		
		System.out.println("INFORME A SITUAÇÃO DO CURSO: ");
		int sit = leitorTerminal.nextInt();
		
		boolean situacao;
		if(sit == 1) {
			situacao = false;
		}else {
			situacao = true;
		}
		
		
		Cursos curso;
		
		try {
			
		curso = new Cursos(nivel, cargaHoraria, nome, situacao);
		
		ICursoDao cursoDao= new CursoDao();
		cursoDao.cadastrar(curso);
		
		System.out.println("CURSO CADASTRADO\n");
	} catch(Exception e) {
		e.printStackTrace();
		System.out.println("ERRO AO CADASTRAR CURSO"+ e.getMessage());
		}
	}
	
	
	
	
	
	private static void editarCursos(Scanner leitorTerminal) {
		System.out.println("EDITAR CURSO\n");
		System.out.println("INFORME O CÓDIGO DO CURSO QUE SERÁ EDITADO: ");
		int Codigo = leitorTerminal.nextInt();
		leitorTerminal.nextLine();
		
		try {
			ICursoDao cursoDao = new CursoDao();
			Cursos cursos = cursoDao.buscar(Codigo);
			
			if(cursos != null) {
				
				System.out.print("\nNIVEL:: '"+ cursos.getNivel()+"'.\n DIGITE O NOVO NÍVEL: ");
				cursos.setNivel(leitorTerminal.nextInt());
				leitorTerminal.nextLine();//Limpar buffer do console
		
				cursoDao.editar(cursos);
		
				System.out.print("NOME: '" + cursos.getNome() + "'.\n DIGITE O NOVO NOME: ");
				String tempCursos = leitorTerminal.nextLine();
				
					if(!tempCursos.equals("")) {
						cursos.setNome(tempCursos);
					}
			
					System.out.println("\nSUCESSO NA ATUALIZAÇÃO.\n");
			
			}else {
				System.out.println("\nCÓDIGO INEXISTENTE...\n");
			}
		}catch(Exception e) {
			System.out.println("ERRO NA ATUALIZAÇÃO DO CURSO!!!!!"+ e.getMessage());
		}
	
	}
	
	
	
	

	private static void listarCursos(){
		System.out.println("LISTAR CURSO\n");
		
		ICursoDao cursoDao = new CursoDao();
		List<Cursos> cursos;
		
		try {
			cursos = cursoDao.buscarTodos();
			
			if (cursos != null && cursos.size()>0) {
			System.err.print("codigo\t| nivel\t| curso\t| cargaHoraria\t| situacao\n");
			
			for(Cursos curso : cursos) {
				System.out.print(curso.getCodigo());
				System.out.print("\t"+ curso.getNivel());
				System.out.println("\t"+ curso.getNome());
				System.out.println("\t"+curso.getCargaHoraria());
				System.out.println("\t"+curso.getSituacao());
			}
			System.out.println();
			
			}else{
				System.out.println("\nCURSO INEXISTENTE...\n");
			}
		}catch(Exception e) {
				System.out.println("ERRO NA BUSCA AO CURSO"+ e.getMessage());
			}	
	}
	
	
	
	
	
	
	private static void excluirCursos(Scanner leitorTerminal)  {
		
		System.out.println("EXCLUIR CURSO\n");
		System.out.println("INFORME O CÓDIGO DO CURSO QUE DESEJA EXCLUIR: ");
		int codigo = leitorTerminal.nextInt();
		leitorTerminal.nextLine();
		
		ICursoDao cursoDao = new CursoDao();
		
		try {
			 
			cursoDao.excluir(codigo);
				
			System.out.println("\nEXCLUIDO COM SUCESSO\n");
				
		}catch(Exception e) {
			System.out.println("ERRO NA EXCLUSÃO"+ e.getMessage());
		}	
	}

	}

