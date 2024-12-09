package com.teste.product.repository;


import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.teste.product.model.Produto;

@Repository
public class ProdutoRepository {
  private ArrayList<Produto> produtos = new ArrayList<Produto>();
  private Integer ultimoId = 0;

  /**
   * Metodo para retornar uma lista de produtos.
   * @return Lista de produtos.
   */
  public List<Produto> obterTodos() {
    return produtos;
  }

  /**
   * Metodo que retorna o produto encontrado pelo seu Id.
   * @param id do produto que ser localizado.
   * @return Retorna um produto caso seja encontrado. 
   */
  public Optional<Produto> obterPorId(Integer id) {
    return produtos
        .stream()
        .filter(produto -> produto.getId() == id)
        .findFirst();
  }

  /**
   * Metodo para adcioanr produto na lista.
   * @param produto que sera adicionado. 
   * @return Retorna o produto que foi adicionado na lista.
   */
  
  public Produto adicionar(Produto produto) {
    ultimoId++;

    produto.setId(ultimoId);
    produtos.add(produto);

    return produto;
  }

  /**
   * Metodo para deletar o produto por id;
   * @param id do produto a ser deletado;
   */

  public void deletar(Integer id) {
    produtos.removeIf(produto -> produto.getId() == id);
  }

  /**
   * Metodo para atualizar o produto na lista.
   * @param produto que será atualizado.
   * @return retrona o produto após atualizar na lista.
   */

  public Produto atualizar(Produto produto) {
    //Encontrar o produto na lista. 
    Optional<Produto> produtoEncontrado = obterPorId(produto.getId());
   
    //Verificar se encontrou.
    if (produtoEncontrado.isEmpty()) {
      throw new InputMismatchException("Produto não encontrado");
    }
    
    //Remover o produto antigo da lista.
    deletar(produto.getId());

    //Depois adicionar o produto atualizado na lista.
    produtos.add(produto);

    return produto;
  }
}
