
package Caso.Caso.domain;
import jakarta.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "peliculas")
public class Pelicula {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "titulo")
    private String titulo;

    @Column(name = "tipo")
    private String tipo;

    @OneToMany(mappedBy = "pelicula", cascade = CascadeType.ALL)
    private Set<Funcion> funciones = new HashSet<>();

    // Getters y setters
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Set<Funcion> getFunciones() {
        return funciones;
    }

    public void setFunciones(Set<Funcion> funciones) {
        this.funciones = funciones;
    }
}
