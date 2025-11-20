package br.com.fiap.model.to;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class RecursoTO {

    private Long id;

    @NotBlank(message = "O título é obrigatório")
    private String titulo;

    @NotBlank(message = "O link é obrigatório")
    private String link;

    @NotBlank(message = "A categoria é obrigatória")
    private String categoria;

    private String descricao;

    @NotNull(message = "O ID do usuário é obrigatório")
    private Long idUsuario; // Para vincular quem postou

    public RecursoTO() {}

    public RecursoTO(Long id, String titulo, String link, String categoria, String descricao, Long idUsuario) {
        this.id = id;
        this.titulo = titulo;
        this.link = link;
        this.categoria = categoria;
        this.descricao = descricao;
        this.idUsuario = idUsuario;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Long getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Long idUsuario) {
        this.idUsuario = idUsuario;
    }
}

