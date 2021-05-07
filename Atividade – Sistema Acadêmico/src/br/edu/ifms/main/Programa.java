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
			System.out.println("#### DIGITE O N�MERO CORRESPONDENTE A OP��O DESEJADA: #### ");
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
					System.out.println("OP�AO INV�LIDA");
			}
		}while(opcao!=0);
	}
	
	private static void cadastrarCurso(Scanner leitorTerminal){
		System.out.println("CADASTRAR CURSOS\n");
		
		System.out.println("INFORME O NOME DO CURSO: ");
		String nome = leitorTerminal.nextLine();
		
		System.out.println("INFORME O N�VEL DO CURSO: ");
		int nivel = leitorTerminal.nextInt();
		
		System.out.println("INFORME A CARGA HORARIA DO CURSO: ");
		int cargaHoraria = leitorTerminal.nextInt();
		
		System.out.println("INFORME A SITUA��O DO CURSO: ");
		boolean situacao = leitorTerminal.nextBoolean();
		
		Cursos curso;
		
		try {
			
		curso = new Cursos(nivel, cargaHoraria, nome, situacao);
		
		ICursoDao cursoDao= new CursoDao();
		cursoDao.cadastrar(curso);
		
		System.out.println("CURSO CADASTRADO\n");
	} catch(Exception e) {
		e.printStackTrace();
		System.out.println("ERRO NA ATUALIZA��O DO CURSO"+ e.getMessage());
		}
	}
	
	private static void editarCursos(Scanner leitorTerminal) {
		System.out.println("EDITAR CURSO\n");
		System.out.println("INFORME O CURSO QUE SER� EDITADO: ");
		int Codigo = leitorTerminal.nextInt();
		leitorTerminal.nextLine();
		
		try {
			ICursoDao cursoDao = new CursoDao();
			Cursos cursos = cursoDao.buscar(Codigo);
			
			if(cursos != null) {
				System.out.print("NOME ATUAL: '"+ cursos.getNome()+"'.\n DIGITE O N�VEL ATUALIZADO ");
				String tempCursos = leitorTerminal.nextLine();
				
					if(!tempCursos.equals("")) {
						cursos.setNome(tempCursos);
					}				
					System.out.print("\nN�VEL ATUALLIZADO: '"+ cursos.getNivel()+"'.\n DIGITE O NOVO N�VEL: ");
					cursos.setNivel(leitorTerminal.nextInt());
					leitorTerminal.nextLine();//Limpar buffer do console
			
					cursoDao.editar(cursos);
			
					System.out.println("\nSUCESSO NA ATUALIZA��O.\n");
			
			}else {
				System.out.println("\nC�DIGO INEXISTENTE...\n");
			}
		}catch(Exception e) {
			System.out.println("ERRO NA ATUALIZA��O DO CURSO"+ e.getMessage());
		}
	
	}

	private static void listarCursos(){
		System.out.println("LISTAR CURSO\n");
		
		ICursoDao cursoDao = new CursoDao();
		List<Cursos> cursos;
		
		try {
			cursos = cursoDao.buscarTodos();
			
			if (cursos != null && cursos.size()>0) {
			System.err.print("C�DIGO\t| N�VEL\t| CURSO\n");
			
			for(Cursos curso : cursos) {
				System.out.print(curso.getCodigo());
				System.out.print("\t| "+ curso.getNivel());
				System.out.println("\t\t| "+ curso.getNome());
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
		System.out.println("INFORME O CURSO QUE DESEJA EXCLUIR: ");
		int codigo = leitorTerminal.nextInt();
		leitorTerminal.nextLine();
		
		ICursoDao cursoDao = new CursoDao();
		
		try {
			 
			cursoDao.excluir(codigo);
				
			System.out.println("\nEXCLUIDO COM SUCESSO\n");
				
		}catch(Exception e) {
			System.out.println("ERRO NA EXCLUS�O"+ e.getMessage());
		}	
	}

	}

