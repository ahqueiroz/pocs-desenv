package br.com.queiroz;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class Principal {

	public static void main(String[] args) {
		
//		List<String> palavras = new ArrayList<>();
//		palavras.add("alura online");
//		palavras.add("casa do código");
//		palavras.add("caelum");
//		
//		palavras.sort((s1, s2) ->  Integer.compare(s1.length(), s2.length()));
//		
//		palavras.forEach(p -> System.out.println(p));			
//				
//		new Thread(() -> System.out.println("Executando um Runnable")).start();
//		
//		Function<Usuario, String> funcao1 = u -> u.getNome();
//		Function<Usuario, String> funcao2 = Usuario::getNome;
//		
//		//lambda
//		palavras.sort((s1, s2) -> {
//		    return Integer.compare(s1.length(), s2.length()); 
//		});
//		//lambda com comparing
//		palavras.sort(Comparator.comparing(s -> s.length()));
//		//reference com comparing
//		palavras.sort(String.CASE_INSENSITIVE_ORDER);
//

	    
	    List<Curso> cursos = new ArrayList<Curso>();
	    cursos.add(new Curso("Python", 45));
	    cursos.add(new Curso("JavaScript", 150));
	    cursos.add(new Curso("Java 8", 113));
	    cursos.add(new Curso("C", 55));
	    
	    //comparar cursos
//	    cursos.sort(Comparator.comparing(curso -> curso.getAlunos()));
//	    
//	    cursos.sort(Comparator.comparing(Curso::getAlunos));
//		
//	    cursos.forEach(System.out::println);
	    
//		cursos.stream().filter(c -> c.getAlunos() >= 100).mapToInt(c -> c.getAlunos()).forEach(x -> System.out.println(x));
	    
//	    cursos.stream().filter(c -> c.getAlunos() >= 100).mapToInt(c -> c.getAlunos()).sum();
	    
//	    Optional<Curso> resultado = cursos.stream().filter(c -> c.getAlunos() >= 100).findFirst();
//	    resultado.ifPresent(r -> System.out.println(r.getNome()));	
	    
//	    int resultado = cursos.stream().mapToInt(c -> c.getAlunos()).sum();
//	    System.out.println(resultado);
	    
	    List<Curso> resultado = cursos.stream().filter(c -> c.getAlunos() > 50).collect(Collectors.toList());
	    resultado.forEach(r -> System.out.println(r.getAlunos()));    

	}
}
