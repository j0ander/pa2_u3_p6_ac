
@Entity

@Table(name = "prodcutos")
@Getter
@Setter

public class Prodcuto {


    @id
    @GeneratedVAlue (strategy = GEneratioValu.Identyt)
    @Column(name = "prod_id")
    private Integer id;
    @Column(name = "prod_nombre")
    private Strgin nombre;
    @Column(name = "prod_precio")
    private Float precio;

}