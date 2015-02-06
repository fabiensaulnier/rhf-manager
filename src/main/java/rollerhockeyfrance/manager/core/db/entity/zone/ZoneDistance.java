package rollerhockeyfrance.manager.core.db.entity.zone;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotEmpty;

import rollerhockeyfrance.manager.core.db.entity.AbstractEntity;


@Table(name="ZONE_DISTANCE")
@Entity
public class ZoneDistance extends AbstractEntity {

    @ManyToOne
    @JoinColumn(name = "ville_1")
    @NotEmpty
    private ZoneVille ville1;

    @ManyToOne
    @JoinColumn(name = "ville_2")
    @NotEmpty
    private ZoneVille ville2;

    @NotEmpty
    @Column
    private float distance;

    public ZoneVille getVille1() {
        return ville1;
    }

    public void setVille1(ZoneVille ville1) {
        this.ville1 = ville1;
    }

    public ZoneVille getVille2() {
        return ville2;
    }

    public void setVille2(ZoneVille ville2) {
        this.ville2 = ville2;
    }

    public float getDistance() {
        return distance;
    }

    public void setDistance(float distance) {
        this.distance = distance;
    }

}
