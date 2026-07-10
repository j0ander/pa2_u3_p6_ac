
@Entity

@Table(name = "facturas")
@Getter
@Setter

public class factcuto {


    @id
    @GeneratedVAlue (strategy = GEneratioValu.Identyt)
    @Column(name = "fact_id")
    private Integer id;
    @Column(name = "fact_clienteId")
    private Strgin clienteId;
    @Column(name = "fact_prodcutId")
    private Float prodcutId;
    @Column(name = "fact_precio")
    private Float precio;

}
