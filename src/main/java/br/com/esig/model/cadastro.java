package br.com.esig.model;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "cadastro")
public class cadastro implements Serializable, Base {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	@Column(name = "codigo")
	private Long id;
	private String titulo;
	private String descricao;
	private String responsavel;
	private String prioridade;
	private String situacao;
	
	@Column(name = "deadline", nullable = true)
	@Temporal(TemporalType.DATE)
	private Date deadline;
	
    	
	public Long getId() {
		return id;
	}

	public String getResponsavel() {
		return responsavel;
	}

	public void setResponsavel(String responsavel) {
		this.responsavel = responsavel;
	}

	public String getPrioridade() {
		return prioridade;
	}

	public void setPrioridade(String prioridade) {
		this.prioridade = prioridade;
	}

	public String getSituacao() {
		return situacao;
	}

	public void setSituacao(String situacao) {
		this.situacao = situacao;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Date getDeadline() {
		return deadline;
	}

	public void setDeadline(Date deadLine) {
		this.deadline = deadLine;
	}

	@Override
	public int hashCode() {
		return Objects.hash(deadline, descricao, id, prioridade, responsavel, titulo, situacao);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		cadastro other = (cadastro) obj;
		return Objects.equals(deadline, other.deadline) && Objects.equals(descricao, other.descricao)
				&& Objects.equals(id, other.id) && Objects.equals(prioridade, other.prioridade)
				&& Objects.equals(responsavel, other.responsavel) && Objects.equals(titulo, other.titulo) && Objects.equals(situacao, other.situacao);

	}

	

	

	

}
