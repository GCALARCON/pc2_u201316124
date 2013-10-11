/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.multas.entidades;

import com.mycompany.multas.entidades.*;
import com.mycompany.multas.validation.MaxAnoMasActual;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Cacheable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.QueryHint;
import javax.persistence.Temporal;
import javax.validation.constraints.Min;

/**
 *
 * @author josediaz
 */
@NamedQueries({
    @NamedQuery(name = Multas.LISTAR_DESTACADOS, query = "select a from Multa a", hints = {
        @QueryHint(name = "org.hibernate.cacheable", value = "true"),
        @QueryHint(name = "org.hibernate.cacheRegion", value = Multas.LISTAR_DESTACADOS)})
})
@Entity
@Cacheable
public class Multas implements Serializable {

    private static final long serialVersionUID = 9183366721265460766L;
    public static final String LISTAR_DESTACADOS = "Multas.buscarDestacados";

 
    	@Id @GeneratedValue
	private Long id;
	@ManyToOne
	private Contribuyente contribuyente;
	@ManyToOne
	private Tributo tributo;
//	@OneToMany(mappedBy="multa")
//	private List<Multas> fotos;
//	@Min(1900) @MaxAnoMasActual(message="El valor maximo del año de fabricacion es {0}")
//	private Integer anoFabricacion;
//	@Min(1900) @MaxAnoMasActual(value=1, message="El valor maximo del año del modelo es {0}")
    @Temporal(javax.persistence.TemporalType.DATE)
	private Date periodo;
	private Double importe;
//	private Float kilometraje;
//	private String observaciones;
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Contribuyente getContribuyente() {
		return contribuyente;
	}
	public void setRuc(Contribuyente contribuyente) {
		this.contribuyente = contribuyente;
	}

    public Tributo getTributo() {
        return tributo;
    }

    public void setTributo(Tributo tributo) {
        this.tributo = tributo;
    }

/**
    public List<Foto> getFotos() {
        return fotos;
    }

    public void setFotos(List<Foto> fotos) {
        this.fotos = fotos;
    }

    public Integer getAnoFabricacion() {
        return anoFabricacion;
    }

    public void setAnoFabricacion(Integer anoFabricacion) {
        this.anoFabricacion = anoFabricacion;
    }

**/ 

    public Date getPeriodo() {
        return periodo;
    }

    public void setPeriodo(Date Periodo) {
        this.periodo = periodo;
    } 
 
    public Double getImporte() {
        return importe;
    }

    public void setImporte(Double importe) {
        this.importe = importe;
    }


/**    
    public Float getKilometraje() {
        return kilometraje;
    }

    public void setKilometraje(Float kilometraje) {
        this.kilometraje = kilometraje;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

**/ 

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 97 * hash + (this.id != null ? this.id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Multas other = (Multas) obj;
        if (this.id != other.id && (this.id == null || !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Multas{" + "id=" + id + ", contribuyente=" + contribuyente + ", tributo=" + tributo + ", periodo=" + periodo + ", uimporte=" + importe + '}';
    }
	
        
}
