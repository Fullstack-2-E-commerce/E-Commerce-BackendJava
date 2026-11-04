
@Data
@NoArgsContructor
@AllArgsContructor
@Entity
@Table(name = "usuarios")
public class UsuariosModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTIFY)
    private Long id;

    


}
