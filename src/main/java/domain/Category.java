package domain;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="category")
public class Category {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column
    private Long id;
    @Column
    private String title;
    @OneToMany(mappedBy = "ad")
    private List<Ad> adverts;

    public List<Ad> getAdverts() {
        return adverts;
    }

    public void setAdverts(List<Ad> adverts) {
        this.adverts = adverts;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
