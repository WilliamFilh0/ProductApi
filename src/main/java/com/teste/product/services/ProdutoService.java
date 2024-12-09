package com.teste.product.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.teste.product.model.Produto;
import com.teste.product.repository.ProdutoRepository;

@Service
public class ProdutoService {

  @Autowired
  private ProdutoRepository produtoRepository;

  /**
   * Metodo para retornar uma lista de produtos.
   * 
   * @return Lista de produtos.
   */
  public List<Produto> obterTodos() {
    return produtoRepository.obterTodos();
  }

  /**
   * Metodo que retorna o produto encontrado pelo seu Id.
   * 
   * @param id do produto que ser localizado.
   * @return Retorna um produto caso seja encontrado.
   */
  public Optional<Produto> obterPorId(Integer id) {

    return produtoRepository.obterPorId(id);
  }

  /**
   * Metodo para adcioanr produto na lista.
   * 
   * @param produto que sera adicionado.
   * @return Retorna o produto que foi adicionado na lista.
   */

  public Produto adicionar(Produto produto) {
    return produtoRepository.adicionar(produto);
  }

  /**
   * Metodo para deletar o produto por id;
   * 
   * @param id do produto a ser deletado;
   */

  public void deletar(Integer id) {
    produtoRepository.deletar(id);
  }

  public Produto atualizar(Integer id, Produto produto) {
    produto.setId(id);
    return produtoRepository.atualizar(produto);
  }
}
