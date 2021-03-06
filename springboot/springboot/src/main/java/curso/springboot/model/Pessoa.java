package curso.springboot.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;

import javassist.SerialVersionUID;

@Entity
public class Pessoa implements Serializable{
	
	private static final long SerialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@NotNull(message="Nome não pode ser nulo")
	@NotEmpty(message="Nome não pode ser vazio")
	private String nome;
	
	
	@NotNull(message="Sobrenome não pode ser nulo")
	@NotEmpty(message="Sobrenome não pode ser vazio")
	private String sobrenome;
	
	
	
	@Min(value=18 , message="Idade inválida")
	private int idade;
	
	@Autowired
	@OneToMany(mappedBy = "pessoa", orphanRemoval = true, cascade= CascadeType.ALL)

	private List<Telefone> telefones;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSobrenome() {
		return sobrenome;
	}

	public void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
	}

	public int getIdade() {
		return idade;
	}

	public void setIdade(int idade) {
		this.idade = idade;
	}
	
	
	
	
	
}
