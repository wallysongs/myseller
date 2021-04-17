package io.github.wallysongs.myseller;

import java.text.SimpleDateFormat;
import java.util.Arrays;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import io.github.wallysongs.myseller.domain.Categoria;
import io.github.wallysongs.myseller.domain.Cidade;
import io.github.wallysongs.myseller.domain.Cliente;
import io.github.wallysongs.myseller.domain.Endereco;
import io.github.wallysongs.myseller.domain.Estado;
import io.github.wallysongs.myseller.domain.ItemPedido;
import io.github.wallysongs.myseller.domain.Pagamento;
import io.github.wallysongs.myseller.domain.PagamentoComBoleto;
import io.github.wallysongs.myseller.domain.PagamentoComCartao;
import io.github.wallysongs.myseller.domain.Pedido;
import io.github.wallysongs.myseller.domain.Produto;
import io.github.wallysongs.myseller.domain.enums.EstadoPagamento;
import io.github.wallysongs.myseller.domain.enums.TipoCliente;
import io.github.wallysongs.myseller.repositories.CategoriaRepository;
import io.github.wallysongs.myseller.repositories.CidadeRepository;
import io.github.wallysongs.myseller.repositories.ClienteRepository;
import io.github.wallysongs.myseller.repositories.EnderecoRepository;
import io.github.wallysongs.myseller.repositories.EstadoRepository;
import io.github.wallysongs.myseller.repositories.ItemPedidoRepository;
import io.github.wallysongs.myseller.repositories.PagamentoRepository;
import io.github.wallysongs.myseller.repositories.PedidoRepository;
import io.github.wallysongs.myseller.repositories.ProdutoRepository;

@SpringBootApplication
public class MysellerApplication implements CommandLineRunner {

	private CategoriaRepository categoriaRepository;
	private ProdutoRepository produtoRepository;
	private CidadeRepository cidadeRepository;
	private EstadoRepository estadoRepository;
	private ClienteRepository clienteRepository;
	private EnderecoRepository enderecoRepository;
	private PedidoRepository pedidoRepository;
	private PagamentoRepository pagamentoRepository;
	private ItemPedidoRepository itemPedidoRepository;

	public MysellerApplication(CategoriaRepository categoriaRepository, ProdutoRepository produtoRepository,
			CidadeRepository cidadeRepository, EstadoRepository estadoRepository, ClienteRepository clienteRepository,
			EnderecoRepository enderecoRepository, PedidoRepository pedidoRepository,
			PagamentoRepository pagamentoRepository, ItemPedidoRepository itemPedidoRepository) {
		this.categoriaRepository = categoriaRepository;
		this.produtoRepository = produtoRepository;
		this.cidadeRepository = cidadeRepository;
		this.estadoRepository = estadoRepository;
		this.clienteRepository = clienteRepository;
		this.enderecoRepository = enderecoRepository;
		this.pedidoRepository = pedidoRepository;
		this.pagamentoRepository = pagamentoRepository;
		this.itemPedidoRepository = itemPedidoRepository;
	}

	public static void main(String[] args) {
		SpringApplication.run(MysellerApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Categoria categoria1 = new Categoria(null, "Informática");
		Categoria categoria2 = new Categoria(null, "Escritório");

		Produto produto1 = new Produto(null, "Computador", 2000.0);
		Produto produto2 = new Produto(null, "Impressora", 800.0);
		Produto produto3 = new Produto(null, "Mouse", 80.0);

		categoria1.getProdutos().addAll(Arrays.asList(produto1, produto2, produto3));
		categoria2.getProdutos().addAll(Arrays.asList(produto2));

		produto1.getCategorias().addAll(Arrays.asList(categoria1));
		produto2.getCategorias().addAll(Arrays.asList(categoria1, categoria2));
		produto3.getCategorias().addAll(Arrays.asList(categoria1));

		categoriaRepository.saveAll(Arrays.asList(categoria1, categoria2));
		produtoRepository.saveAll(Arrays.asList(produto1, produto2, produto3));

		Estado estado1 = new Estado(null, "Minas Gerais", "MG");
		Estado estado2 = new Estado(null, "São Paulo", "SP");

		Cidade cidade1 = new Cidade(null, "Uberlândia", estado1);
		Cidade cidade2 = new Cidade(null, "São Paulo", estado2);
		Cidade cidade3 = new Cidade(null, "Campinas", estado2);

		estado1.getCidades().addAll(Arrays.asList(cidade1));
		estado2.getCidades().addAll(Arrays.asList(cidade2, cidade3));

		estadoRepository.saveAll(Arrays.asList(estado1, estado2));
		cidadeRepository.saveAll(Arrays.asList(cidade1, cidade2, cidade3));

		Cliente cliente1 = new Cliente(null, "Maria Silva", "maria@gmail.com", "36378912377",
				TipoCliente.PESSOA_FISICA);
		cliente1.getTelefones().addAll(Arrays.asList("27363323", "93838393"));

		Endereco endereco1 = new Endereco(null, "Rua Flores", "300", "Apto 303", "Jardim", "38220834", cliente1,
				cidade1);
		Endereco endereco2 = new Endereco(null, "Avenida Matos", "105", "Sala 800", "Centro", "38777012", cliente1,
				cidade2);

		cliente1.getEnderecos().addAll(Arrays.asList(endereco1, endereco2));

		clienteRepository.saveAll(Arrays.asList(cliente1));
		enderecoRepository.saveAll(Arrays.asList(endereco1, endereco2));

		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");

		Pedido pedido1 = new Pedido(null, sdf.parse("30/09/2017 10:32"), cliente1, endereco1);
		Pedido pedido2 = new Pedido(null, sdf.parse("10/10/2017 19:35"), cliente1, endereco2);

		Pagamento pagamento1 = new PagamentoComCartao(null, EstadoPagamento.QUITADO, pedido1, 6);
		pedido1.setPagamento(pagamento1);

		Pagamento pagamento2 = new PagamentoComBoleto(null, EstadoPagamento.PENDENTE, pedido2,
				sdf.parse("20/10/2017 00:00"), null);
		pedido2.setPagamento(pagamento2);

		cliente1.getPedidos().addAll(Arrays.asList(pedido1, pedido2));

		pedidoRepository.saveAll(Arrays.asList(pedido1, pedido2));
		pagamentoRepository.saveAll(Arrays.asList(pagamento1, pagamento2));

		ItemPedido itemPedido1 = new ItemPedido(pedido1, produto1, 0.0, 1, 2000.0);
		ItemPedido itemPedido2 = new ItemPedido(pedido1, produto3, 0.0, 2, 80.0);
		ItemPedido itemPedido3 = new ItemPedido(pedido2, produto2, 100.0, 1, 800.0);

		pedido1.getItens().addAll(Arrays.asList(itemPedido1, itemPedido2));
		pedido2.getItens().addAll(Arrays.asList(itemPedido3));

		produto1.getItens().addAll(Arrays.asList(itemPedido1));
		produto2.getItens().addAll(Arrays.asList(itemPedido3));
		produto3.getItens().addAll(Arrays.asList(itemPedido2));

		itemPedidoRepository.saveAll(Arrays.asList(itemPedido1, itemPedido2, itemPedido3));
	}

}
