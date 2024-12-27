package ir.jimsa.sparqlmanagement.ws.model.entity;

import jakarta.persistence.*;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Builder
@Entity
@Table(name = "sparqls")
public class SparqlEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "public_id",nullable = false, unique = true)
    private String publicId;

    private String name;
    private String description;
    private String query;
    private String creator;

}
