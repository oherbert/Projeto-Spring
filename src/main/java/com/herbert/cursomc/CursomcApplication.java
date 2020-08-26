package com.herbert.cursomc;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.herbert.cursomc.domain.Categoria;
import com.herbert.cursomc.domain.Produto;
import com.herbert.cursomc.repositories.CategoriaRepository;
import com.herbert.cursomc.repositories.ProdutoRepository;

@SpringBootApplication
public class CursomcApplication implements CommandLineRunner {

	@Autowired
	private CategoriaRepository categoriaRepository;
	@Autowired
	private ProdutoRepository produtoRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(CursomcApplication.class, args);
		
		
	}

	@Override
	public void run(String... args) throws Exception {
		
		Categoria cat1 = new Categoria(null,"Escritorio");
		Categoria cat2 = new Categoria(null,"Informatica");
		
		Produto prod1 = new Produto("Computador",2000.00);
		Produto prod2 = new Produto("Impressora",800.00);
		Produto prod3 = new Produto("Teclado",80.00);
		
		cat1.getProdutos().addAll(Arrays.asList(prod1,prod2,prod3));
		cat2.getProdutos().add(prod2);
		
		prod1.getCategorias().add(cat1);
		prod2.getCategorias().addAll(Arrays.asList(cat1,cat2));
		prod3.getCategorias().add(cat1);
		
		categoriaRepository.saveAll(Arrays.asList(cat1,cat2));
		produtoRepository.saveAll(Arrays.asList(prod1,prod2,prod3));
	}

}
