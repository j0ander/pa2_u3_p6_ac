
@Entity
@Table(name = "clientes")
@Getter
@Setter

public class Cliente {


    @id
    @GeneratedVAlue (strategy = GEneratioValu.Identyt)
    @Column(name = "clie_id")
    private Integer id;
    @Column(name = "clie_nombre")
    private Strgin nombre;
    @Column(name = "clie_apellido")
    private Float apellido;
    @Column(name = "clie_direccion")
    private Float direccion;

}