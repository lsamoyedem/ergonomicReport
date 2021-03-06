package dominios;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author Lucas Samoyedem
 */
@Entity
@Table(name = "ATIVIDADE")
public class Atividade implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "GEN_ATIVIDADE")
    @SequenceGenerator(name = "GEN_ATIVIDADE", sequenceName = "GEN_ATIVIDADE", allocationSize = 1, initialValue = 1)
    @NotNull
    @Column(name = "ATV_ID")
    private Integer atvId;
    @Basic(optional = false)
    @NotNull
    @Size(max = 200)
    @Column(name = "ATV_DESC")
    private String atvDesc;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ATV_SITU")
    private String atvSitu = "A";
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "txaCodAtiidade", fetch = FetchType.LAZY, orphanRemoval = true)
    private List<Tarefaxatividade> tarefaxatividadeList = new ArrayList<>();

    public Atividade() {
    }

    public Atividade(Integer atvId) {
        this.atvId = atvId;
    }

    public Atividade(Integer atvId, String atvDesc, String atvSitu) {
        this.atvId = atvId;
        this.atvDesc = atvDesc;
        this.atvSitu = atvSitu;
    }

    public Integer getAtvId() {
        return atvId;
    }

    public void setAtvId(Integer atvId) {
        this.atvId = atvId;
    }

    public String getAtvDesc() {
        return atvDesc;
    }

    public void setAtvDesc(String atvDesc) {
        this.atvDesc = atvDesc;
    }

    public String getAtvSitu() {
        return atvSitu;
    }

    public void setAtvSitu(String atvSitu) {
        this.atvSitu = atvSitu;
    }

    public List<Tarefaxatividade> getTarefaxatividadeList() {
        return tarefaxatividadeList;
    }

    public void setTarefaxatividadeList(List<Tarefaxatividade> tarefaxatividadeList) {
        this.tarefaxatividadeList = tarefaxatividadeList;
    }

    public void addNewTarefa() {
        Tarefaxatividade txa = new Tarefaxatividade();
        txa.setTxaSitu("A");
        txa.setTxaCodAtiidade(this);
        tarefaxatividadeList.add(txa);
    }

    public void removeTarefa(int index) {
        tarefaxatividadeList.remove(index);
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (atvId != null ? atvId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Atividade)) {
            return false;
        }
        Atividade other = (Atividade) object;
        return !((this.atvId == null && other.atvId != null) || (this.atvId != null && !this.atvId.equals(other.atvId)));
    }
}
