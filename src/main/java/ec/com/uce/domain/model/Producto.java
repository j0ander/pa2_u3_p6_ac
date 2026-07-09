package ec.com.uce.domain.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import java.math.BigDecimal;

@Entity
@Table(name = "producto")
public class Producto {
    @Id
    @SequenceGenerator(name = "seq_producto_generador", sequenceName = "seq_producto", allocationSize = 1)
    @GeneratedValue(generator = "seq_producto_generador", strategy = GenerationType.SEQUENCE)
    @Column(name = "prod_id")
    private Integer id;
    
    @Column(name = "prod_codigo_barras", unique = true, nullable = false)
    private String codigoBarras; 
    
    @Column(name = "prod_nombre", nullable = false)
    private String nombre;

    @Column(name = "prod_categoria")
    private String categoria;

    @Column(name = "prod_stock")
    private Integer stock;

    @Column(name = "prod_precio")
    private BigDecimal precio;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCodigoBarras() {
        return codigoBarras;
    }

    public void setCodigoBarras(String codigoBarras) {
        this.codigoBarras = codigoBarras;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public BigDecimal getPrecio() {
        return precio;
    }

    public void setPrecio(BigDecimal precio) {
        this.precio = precio;
    }

    
}