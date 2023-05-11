package SearchPerfume;

import javax.persistence.*;
import java.util.Date;

@Entity
public class PerfumeNote {
    @Id @GeneratedValue
    @Column(name="PERFUMENOTE_ID")
    private int id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="PERFUME_ID")
    private Perfume perfume;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="NOTE_ID")
    private Note note;

    @Column(name="PerfumeNote_update")
    private Date created_at;

    @Enumerated(EnumType.STRING)
    private RoleType notetype;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Perfume getPerfume() {
        return perfume;
    }

    public void setPerfume(Perfume perfume) {
        this.perfume = perfume;
    }

    public Note getNote() {
        return note;
    }

    public void setNote(Note note) {
        this.note = note;
    }

    public Date getCreated_at() {
        return created_at;
    }

    public void setCreated_at(Date created_at) {
        this.created_at = created_at;
    }

    public RoleType getNotetype() {
        return notetype;
    }

    public void setNotetype(RoleType notetype) {
        this.notetype = notetype;
    }
}
