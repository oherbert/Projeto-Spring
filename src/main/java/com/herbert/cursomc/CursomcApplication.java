package com.herbert.cursomc;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.herbert.cursomc.domain.Categoria;
import com.herbert.cursomc.domain.Cidade;
import com.herbert.cursomc.domain.Estado;
import com.herbert.cursomc.domain.Produto;
import com.herbert.cursomc.repositories.CategoriaRepository;
import com.herbert.cursomc.repositories.CidadeRepository;
import com.herbert.cursomc.repositories.EstadoRepository;
import com.herbert.cursomc.repositories.ProdutoRepository;

@SpringBootApplication
public class CursomcApplication implements CommandLineRunner {

	@Autowired
	private CategoriaRepository categoriaRepository;
	@Autowired
	private ProdutoRepository produtoRepository;
	@Autowired
	private EstadoRepository estadoRepository;
	@Autowired
	private CidadeRepository cidadeRepository;
	
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
		
		Estado est1 = new Estado("Minas Gerais");
		Estado est2 = new Estado("São Paulo");
		
		Cidade cid1 = new Cidade("Uberlandia", est1);
		Cidade cid2 = new Cidade("Itu", est2);
		Cidade cid3 = new Cidade("Campinas",est2);
		
		cat1.getProdutos().addAll(Arrays.asList(prod1,prod2,prod3));
		cat2.getProdutos().add(prod2);
		
		prod1.getCategorias().add(cat1);
		prod2.getCategorias().addAll(Arrays.asList(cat1,cat2));
		prod3.getCategorias().add(cat1);
		
		est1.getCidades().add(cid1);
		est2.getCidades().addAll(Arrays.asList(cid2,cid3));
		
		categoriaRepository.saveAll(Arrays.asList(cat1,cat2));
		produtoRepository.saveAll(Arrays.asList(prod1,prod2,prod3));
		// Estado primeiro por causa da dependencia
		estadoRepository.saveAll(Arrays.asList(est1,est2));
		cidadeRepository.saveAll(Arrays.asList(cid1,cid2,cid3));
	}

}
